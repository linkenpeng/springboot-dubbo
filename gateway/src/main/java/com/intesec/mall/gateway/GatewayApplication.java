package com.intesec.mall.gateway;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description: 网关接口
 * @author: peter.peng
 * @create: 2020-01-10 09:47
 **/
@SpringBootApplication
@EnableDubbo()
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
