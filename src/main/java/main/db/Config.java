package main.db;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by j on 10/26/16.
 */
@Configuration
public class Config {
    @Bean
    public dbService serv(){
        dbServiceImpl bean = new dbServiceImpl();
        return bean;
    }
}
