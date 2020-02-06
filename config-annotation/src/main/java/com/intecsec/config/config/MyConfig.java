package com.intecsec.config.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.intecsec.config.pojo.MyBean;
import org.springframework.context.annotation.Lazy;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-02-05 11:50
 **/
@Lazy
@Configuration
@ComponentScan(basePackages = "com.intecsec.config.pojo")
public class MyConfig {

    @Bean
    public MyBean myBean(){
        System.out.println("myBean Initialized");
        return new MyBean();
    }

    @Bean
    public MyBean IfLazyInit(){
        System.out.println("initialized");
        return new MyBean();
    }


}
