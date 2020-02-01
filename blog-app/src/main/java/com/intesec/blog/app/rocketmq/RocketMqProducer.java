package com.intesec.blog.app.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @description: rocketmq生产者
 * @author: peter.peng
 * @create: 2018-09-21 16:01
 **/
@Slf4j
@Component
public class RocketMqProducer {
    @Value("${apache.rocketmq.producer.producerGroup}")
    private String producerGroup;

    @Value("${apache.rocketmq.namesrvAddr}")
    private String nameservAddr;

    public void sendMq(String msg) {
        DefaultMQProducer producer = new DefaultMQProducer();
        producer.setNamesrvAddr(nameservAddr);
        producer.setProducerGroup(producerGroup);
        producer.setVipChannelEnabled(false);

        try {
            producer.start();
            log.info("send msg: {}", msg);
            Message message = new Message(EnumMqTopicTag.BLOG_MQ.getTopic(), EnumMqTopicTag.BLOG_MQ.getTag(), msg.getBytes());
            SendResult result = producer.send(message);
            log.info("发送响应：MsgId:" + result.getMsgId() + "，发送状态:" + result.getSendStatus());

        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.shutdown();
        }
    }
}
