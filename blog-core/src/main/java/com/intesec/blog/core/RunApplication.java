package com.intesec.blog.core;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching
@MapperScan("com.intesec.blog.core.mapper")
@ComponentScan(basePackages = "com.intesec.blog.core")
@EnableDubboConfig
public class RunApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(RunApplication.class, args);
	}
}
