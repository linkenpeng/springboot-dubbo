package com.intecsec.blog.mq.consumer;

import com.intecsec.mall.rocketmq.ConsumerBase;
import lombok.extern.log4j.Log4j2;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-02-02 21:56
 **/
@Log4j2
@Configuration
public class BlogConsumer extends ConsumerBase implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            super.listener(BlogMqTopicTag.BLOG_INFO_MQ);
        } catch (MQClientException e) {
            log.error("消费者监听器启动失败", e);
        }
    }

    @Override
    public void dealMessage(String msg) {
        log.info("消费mq, msg:{}", msg);
    }
}

