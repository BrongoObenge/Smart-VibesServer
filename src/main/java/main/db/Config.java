package main.db;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by j on 10/28/16.
 */
@Configuration
public class Config {
    @Bean
    CommandService commandService(){
        CommandServiceImpl bean = new CommandServiceImpl();
        return bean;
    }
}
