package com.intesec.blog.core.component.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @description: rocketmq消费
 * @author: peter.peng
 * @create: 2018-09-21 16:00
 **/
@Slf4j
@Component
public class RocketMqConsumer {
    @Value("${apache.rocketmq.consumer.pushConsumer}")
    private String consumerGroup;

    @Value("${apache.rocketmq.namesrvAddr}")
    private String nameservAddr;

    @PostConstruct
    public void defaultMQPushConsumer() {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer();
        consumer.setNamesrvAddr(nameservAddr);

        try {
            consumer.subscribe("BenchmarkTest", "pushTag");
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
            consumer.setConsumerGroup(consumerGroup);
            consumer.registerMessageListener(new MessageListenerConcurrently() {
                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list,
                                                                ConsumeConcurrentlyContext context) {
                    for (MessageExt messageExt : list) {
                        log.info("messageExt: " + messageExt);
                        try {
                            String messageBody = new String(messageExt.getBody(), "utf-8");
                            log.info("消费响应：Msg: " + messageExt.getMsgId() + ",msgBody: " + messageBody);
                        } catch (UnsupportedEncodingException e) {
                            log.info("exception:{}", e.getMessage());
                            return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                        } catch (Exception e) {
                            log.info("error:{}", e);
                            return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                        }
                    }

                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });
            consumer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (Exception e) {

        } finally {
            consumer.shutdown();
        }

    }
}
