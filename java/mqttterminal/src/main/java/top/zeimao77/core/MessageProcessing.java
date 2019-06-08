package top.zeimao77.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.fusesource.mqtt.client.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import top.zeimao77.aligenie.entity.AligenieHP;
import top.zeimao77.consts.AligenieControl;
import top.zeimao77.consts.AligenieNamespace;
import top.zeimao77.consts.ServiceErrorEnum;
import top.zeimao77.entity.EntityFactory;
import top.zeimao77.exception.ServiceRuntimeException;
import top.zeimao77.terminal.service.AbstractTerminal;
import top.zeimao77.terminal.service.Terminal;
import top.zeimao77.util.DateFormatUtil;
import top.zeimao77.util.ServiceAssert;

public class MessageProcessing extends Thread {

    private Logger logger = LoggerFactory.getLogger(MessageProcessing.class);

    private Message message;

    public MessageProcessing(Message message) {
        logger.info("收到消息，开始新线程"+Thread.currentThread().getName());
        this.message = message;
    }

    @Override
    public void run() {
        String topic = message.getTopic();
        String payload = message.getPayloadBuffer().utf8().toString();
        logger.info(String.format("%s[%s]:%s",topic, DateFormatUtil.nowTime(),payload));
        try {
        	AligenieHP hp = AligenieHP.parse(payload);
        	ServiceAssert.notNull(hp);
        	if(AligenieNamespace.CONTROL.getNamespace().equals(hp.getHeader().getNamespace())) {
                String deviceId = hp.getPayload().getDeviceId();
                String deviceControl = AligenieControl.getMethodName(hp.getHeader().getName());
                Terminal terminal = EntityFactory.getTerminal(deviceId);
                ServiceAssert.notNull(terminal, ServiceErrorEnum.DEVICE_IS_NOT_EXIST);
                Method method = terminal.getControl(deviceControl);
                method.invoke(terminal, hp.getPayload());
            } else if(AligenieNamespace.DISCOVERY.getNamespace().equals(hp.getHeader().getNamespace())) {

            } else if(AligenieNamespace.QUERY.getNamespace().equals(hp.getHeader().getNamespace())) {

            }
        }catch (InvocationTargetException  e) {
        	logger.error("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			logger.error(String.format("错误消息：%s", payload));
			logger.error("调用CONTROL异常",e.getTargetException());
			logger.error("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		}catch (ServiceRuntimeException e) {
        	logger.error("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			logger.error(String.format("错误消息：%s", payload));
			logger.error(e.getCode(),e);
			logger.error("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		}catch (Exception e) {
			logger.error("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			logger.error(String.format("错误消息： %s", payload));
			logger.error(e.getMessage(),e);
			logger.error("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		}finally {
			message.ack();
		}
        
    }

}
