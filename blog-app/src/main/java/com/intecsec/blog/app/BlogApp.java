package com.intecsec.blog.app;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-01-27 16:36
 **/
@SpringBootApplication
@EnableDubbo
@EnableCaching
public class BlogApp {
    private static final Logger logger = LoggerFactory.getLogger(BlogApp.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BlogApp.class, args);
    }
}
