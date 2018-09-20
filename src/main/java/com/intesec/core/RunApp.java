package com.intesec.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
@MapperScan("com.intesec.core.mapper")
@ComponentScan(basePackages = "com.intesec.core")
public class RunApp {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(RunApp.class, args);
	}
}
