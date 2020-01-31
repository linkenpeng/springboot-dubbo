package com.intesec.blog.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * @description: Redis配置
 * @author: peter.peng
 * @create: 2018-08-27 18:47
 **/
@Configuration
public class RedisLettuceConfiguration {
    @Resource
    private LettuceConnectionFactory myLettuceConnectionFactory;


    @Bean
    public RedisTemplate<String, Serializable> redisTemplate() {

        RedisTemplate<String, Serializable> template = new RedisTemplate<>();

        template.setConnectionFactory(myLettuceConnectionFactory);

        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new StringRedisSerializer());


        return template;

    }
}
