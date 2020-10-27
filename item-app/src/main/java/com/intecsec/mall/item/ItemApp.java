package com.intecsec.mall.item;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-02-12 21:02
 **/
@SpringBootApplication
// @EnableDubbo
// @Import(value = { XxlJobConfig.class })
@ImportResource({ "spring-context.xml" })
public class ItemApp {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ItemApp.class);
    }
}
