package com.intecsec.blog.app.config;

import com.intecsec.mall.redis.RedisConfig;
import com.intecsec.mall.redis.RedisManager;
import com.intecsec.mall.rocketmq.RocketMqConfig;
import com.intecsec.mall.rocketmq.RocketMqProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @description: 将一些组件纳入spring管理
 * @author: peter.peng
 * @create: 2020-02-10 09:18
 **/
@Configuration
public class ConfigComponent {

    @Bean("redisTemplate")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        return RedisConfig.getRedisTemplate(redisConnectionFactory);
    }

    @Bean("redisManager")
    public RedisManager redisManager() {
        return new RedisManager();
    }

    @Bean("rocketMqConfig")
    public RocketMqConfig rocketMqConfig() {
        return new RocketMqConfig();
    }

    @Bean("rocketMqProducer")
    public RocketMqProducer rocketMqProducer() {
        return new RocketMqProducer();
    }
}
