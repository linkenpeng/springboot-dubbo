package com.intesec.blog.core.component.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

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

    @PostConstruct
    public void defaultMQProducer() {
        DefaultMQProducer producer = new DefaultMQProducer();
        producer.setNamesrvAddr(nameservAddr);
        producer.setProducerGroup(producerGroup);

        try {
            producer.start();

            for (int i = 0; i < 100; i++) {
                String messageBody = "我是message: " + i;
                String message = new String(messageBody.getBytes(), "utf-8");
                Message msg = new Message("BenchmarkTest", "pushTag", "key_" + i, message.getBytes());

                SendResult result = producer.send(msg);
                log.info("发送响应：MsgId:" + result.getMsgId() + "，发送状态:" + result.getSendStatus());
            }

        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.shutdown();
        }
    }
}
