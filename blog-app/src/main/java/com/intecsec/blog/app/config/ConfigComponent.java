package com.intecsec.blog.app.config;

import com.intecsec.mall.redis.RedisConfig;
import com.intecsec.mall.redis.RedisUtil;
import com.intecsec.mall.rocketmq.RocketMqConfig;
import com.intecsec.mall.rocketmq.RocketMqProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 将一些组件纳入spring管理
 * @author: peter.peng
 * @create: 2020-02-10 09:18
 **/
@Configuration
public class ConfigComponent {

    @Bean("redisConfig")
    public RedisConfig redisConfig() {
        return new RedisConfig();
    }

    @Bean("redisUtil")
    public RedisUtil redisUtil() {
        return new RedisUtil();
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
