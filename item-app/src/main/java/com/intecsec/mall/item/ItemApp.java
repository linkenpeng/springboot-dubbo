package com.intecsec.mall.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-02-12 21:02
 **/
@SpringBootApplication
public class ItemApp {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ItemApp.class);
    }
}
