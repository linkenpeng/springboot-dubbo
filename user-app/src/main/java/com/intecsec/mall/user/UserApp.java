package com.intecsec.mall.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-02-12 21:00
 **/
@SpringBootApplication
public class UserApp {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(UserApp.class);
    }
}
