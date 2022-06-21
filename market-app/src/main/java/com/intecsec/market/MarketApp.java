package com.intecsec.market;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-02-12 21:18
 **/
@SpringBootApplication
@EnableDubbo
public class MarketApp {
    public static void main(String[] args) {
        SpringApplication.run(MarketApp.class, args);
    }
}
