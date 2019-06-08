package top.zeimao77.main;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import top.zeimao77.context.AppContext;

@ComponentScan(value = "top.zeimao77")
@Configuration
@PropertySource(value = "classpath:/config/appconfig.properties")
public class AppApplication {

    public static void main(String[] args) {
        AppContext.run(AppApplication.class);
    }

}
