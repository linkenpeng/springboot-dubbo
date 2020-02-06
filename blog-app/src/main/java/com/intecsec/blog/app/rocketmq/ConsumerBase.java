package com.intecsec.blog.app.rocketmq;

import lombok.extern.log4j.Log4j2;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-02-02 21:54
 **/
@Configuration
@Log4j2
public abstract class ConsumerBase {

    @Autowired
    private RocketMqConfig rocketMqConfig;

    // 开启消费者监听服务
    public void listener(EnumMqTopicTag enumMqTopicTag) throws MQClientException {
        log.info("开启" + enumMqTopicTag.getTopic() + ":" + enumMqTopicTag.getTag() + "消费者-------------------");
        log.info(rocketMqConfig.toString());

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(rocketMqConfig.getConsumerGroupName());

        consumer.setNamesrvAddr(rocketMqConfig.getNamesrvAddr());
        consumer.setVipChannelEnabled(false);
        consumer.subscribe(enumMqTopicTag.getTopic(), enumMqTopicTag.getTag());

        // 开启内部类实现监听
        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> ConsumerBase.this.dealBody(msgs));

        consumer.start();

        log.info("rocketmq启动成功---------------------------------------");

    }

    // 处理body的业务
    public abstract ConsumeConcurrentlyStatus dealBody(List<MessageExt> msgs);

}
