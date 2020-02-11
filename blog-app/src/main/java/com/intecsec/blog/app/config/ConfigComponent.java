package com.intecsec.blog.app.config;

import com.intecsec.mall.redis.RedisUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 将一些组件纳入spring管理
 * @author: peter.peng
 * @create: 2020-02-10 09:18
 **/
@Configuration
public class ConfigComponent {

    @Bean("redisUtil")
    public RedisUtil redisUtil() {
        return new RedisUtil();
    }
}
