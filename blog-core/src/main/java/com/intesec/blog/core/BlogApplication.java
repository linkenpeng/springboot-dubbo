package com.intesec.blog.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableCaching
public class BlogApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BlogApplication.class, args);
	}
}
