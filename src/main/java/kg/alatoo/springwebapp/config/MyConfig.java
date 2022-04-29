package kg.alatoo.springwebapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public MyBean getBean() {
        return new MyBean("First Bean");
    }
}
