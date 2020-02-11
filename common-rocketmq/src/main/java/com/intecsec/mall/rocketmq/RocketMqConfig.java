package com.intecsec.mall.rocketmq;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-02-02 21:51
 **/

@Getter
@Setter
@Configuration
@ToString
public class RocketMqConfig {
    @Value("${rocketmq.producer.groupName}")
    private String producerGroupName;

    @Value("${rocketmq.consumer.groupName}")
    private String consumerGroupName;

    @Value("${rocketmq.namesrvAddr}")
    private String namesrvAddr;
}
