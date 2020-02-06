package com.intecsec.config.config;

import com.intecsec.config.pojo.CustomerBo;
import com.intecsec.config.pojo.MyBean;
import com.intecsec.config.pojo.SchedulerBo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.activation.DataSource;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-02-05 15:35
 **/
@Configuration
public class AppConfig {

    @Bean
    public MyBean myBean(){
        return new MyBean();
    }
}