package com.intesec.springboot2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
@MapperScan("com.intesec.springboot2.mapper")
public class Springboot2Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Springboot2Application.class, args);
		RedisTemplate redisTemplate  = (RedisTemplate) context.getBean("redisTemplate");
		String rtnValue = (String)redisTemplate.opsForValue().get("event:10");
		System.out.println(rtnValue);
	}
}
