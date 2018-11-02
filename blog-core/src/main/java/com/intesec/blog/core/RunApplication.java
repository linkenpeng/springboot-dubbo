package com.intesec.blog.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableCaching
@MapperScan("common.intesec.blog.core.mapper")
@ComponentScan(basePackages = "com.intesec.blog.core")
@ImportResource({ "classpath:spring-context.xml" })
@EnableAutoConfiguration
public class RunApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(RunApplication.class, args);
	}
}
