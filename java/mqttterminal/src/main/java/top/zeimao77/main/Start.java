package top.zeimao77.main;

import org.fusesource.mqtt.client.*;
import org.fusesource.mqtt.client.Future;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import top.zeimao77.core.MessageProcessing;
import top.zeimao77.entity.EntityFactory;
import top.zeimao77.entity.Light;
import top.zeimao77.entity.Oled;
import top.zeimao77.util.DateFormatUtil;
import top.zeimao77.util.ServiceAssert;

import java.net.URISyntaxException;
import java.util.concurrent.*;

@Component
public class Start {

    private static Logger logger = LoggerFactory.getLogger(Start.class);

    ThreadPoolExecutor executorService;

    public Start(){
        executorService = new ThreadPoolExecutor(5,10,60, TimeUnit.SECONDS,new LinkedBlockingQueue<>(MAX_EXE_QUEUE));
    }

    private Runnable oledRunnable = () ->{
        while(true) {
            Oled.oledClear();
            Oled.drawStr(0,"Listening...");
            String nowDate = DateFormatUtil.nowDate();
            String nowTime = DateFormatUtil.nowTime();
            Oled.drawStr(2,nowDate);
            Oled.drawStr(4,nowTime);
            String serverState = String.format("THR:%2d QUE:%3d",executorService.getPoolSize(),executorService.getQueue().size());
            Oled.drawStr(6,serverState);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    private boolean LIFE= true;

    @Value("${mqtt_username}")
    private String USERNAME;

    @Value("${mqtt_password}")
    private String PASSWORD;

    @Value("${mqtt_brokeurl}")
    private String BROKEURL;

    @Value("${mqtt_clientId}")
    private String CLIENTID;

    private static final Integer MAX_EXE_QUEUE = 128;

    private final static Topic[] topics = new Topic[]{
            new Topic("mqtt-topic-test1", QoS.AT_LEAST_ONCE),
    };

    public void start() {
        init();
        MQTT mqtt = new MQTT();
        try {
            mqtt.setHost(BROKEURL);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        mqtt.setClientId(CLIENTID);
        mqtt.setUserName(USERNAME);
        mqtt.setPassword(PASSWORD);
        FutureConnection connection = mqtt.futureConnection();
        connection.connect();
        connection.subscribe(topics);
        logger.info("服务运行成功！正在订阅服务器消息......");
        new Thread(oledRunnable).start();
        while(LIFE) {
            while(executorService.getQueue().size() == MAX_EXE_QUEUE) {
                Thread.yield();
            }
            Future<Message> future = connection.receive();
            try {
                Message message = future.await();
                MessageProcessing processing = new MessageProcessing(message);
                logger.info(String.format("池中线程数量：%d;队列数量：%d",executorService.getPoolSize(),executorService.getQueue().size()));
                executorService.submit(processing);
            } catch (Exception e) {
                logger.error("ERROR",e);
            }
        }
        connection.disconnect();
    }

    public void init() {
        ServiceAssert.notNull(CLIENTID);
        ServiceAssert.notNull(BROKEURL);
        ServiceAssert.notNull(USERNAME);
        ServiceAssert.notNull(PASSWORD);
        Light applight = (Light) EntityFactory.getTerminal("LIGHT_D7A1656513CE41278A8043EC6E70AECF");
        applight.init();
        applight.turnOn(null);
    }

    public void stop() {
        this.LIFE = false;
    }

}
