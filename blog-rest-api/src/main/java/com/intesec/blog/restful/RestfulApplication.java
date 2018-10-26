package com.intesec.blog.restful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan(basePackages = "com.intesec.blog.restful")
@ImportResource({ "classpath:spring-context.xml" })
public class RestfulApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(RestfulApplication.class, args);
	}
}
