package com.intesec.blog.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

import java.util.HashMap;
import java.util.Map;


/**
 * @description: Redis工厂类
 * @author: peter.peng
 * @create: 2018-08-27 18:51
 **/
@Configuration
public class RedisLettuceFactoryConfig {
    @Autowired
    private Environment environment;

    @Bean
    public RedisConnectionFactory myLettuceConnectionFactory() {
        Map<String, Object> source = new HashMap();

        source.put("spring.redis.cluster.nodes", environment.getProperty("spring.redis.cluster.nodes"));
        source.put("spring.redis.cluster.timeout", environment.getProperty("spring.redis.cluster.timeout"));
        source.put("spring.redis.cluster.max-redirects", environment.getProperty("spring.redis.cluster.max-redirects"));

        RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration(new MapPropertySource("RedisClusterConfiguration", source));

        return new LettuceConnectionFactory(redisClusterConfiguration);

    }
}
