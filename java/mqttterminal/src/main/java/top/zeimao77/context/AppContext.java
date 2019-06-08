package top.zeimao77.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.zeimao77.entity.EntityFactory;
import top.zeimao77.entity.Oled;
import top.zeimao77.main.Start;

public class AppContext {

    private static Logger logger = LoggerFactory.getLogger(AppContext.class);

    public static AnnotationConfigApplicationContext context;

    public static void run(Class clazz) {
        EntityFactory.init();
        Oled.oledInit();
        Oled.drawStr(0,"starting...");
        context =  new AnnotationConfigApplicationContext(clazz);
        Start start = context.getBean(Start.class);
        start.start();
    }

    public static <T> T getBean (Class<T> clazz){
        if(context != null) {
            return context.getBean(clazz);
        }
        throw new NullPointerException("初始化异常");
    }

}
