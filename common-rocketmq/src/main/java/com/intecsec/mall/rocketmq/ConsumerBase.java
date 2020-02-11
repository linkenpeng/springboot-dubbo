package com.intecsec.mall.rocketmq;

import lombok.extern.log4j.Log4j2;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.io.UnsupportedEncodingException;
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
    public void listener(MqTopicTag mqTopicTag) throws MQClientException {
        log.info("开启" + mqTopicTag.getTopic() + ":" + mqTopicTag.getTag() + "消费者-------------------");
        log.info(rocketMqConfig.toString());

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(rocketMqConfig.getConsumerGroupName());

        consumer.setNamesrvAddr(rocketMqConfig.getNamesrvAddr());
        consumer.setVipChannelEnabled(false);
        consumer.subscribe(mqTopicTag.getTopic(), mqTopicTag.getTag());

        // 开启内部类实现监听
        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> ConsumerBase.this.dealBody(msgs));

        consumer.start();

        log.info("rocketmq启动成功---------------------------------------");

    }

    private ConsumeConcurrentlyStatus dealBody(List<MessageExt> msgs) {
        int num = 1;
        log.info("进入");
        for(MessageExt msg : msgs) {
            log.info("第" + num + "次消息");
            try {
                String msgStr = new String(msg.getBody(), "utf-8");
                dealMessage(msgStr);
            } catch (UnsupportedEncodingException e) {
                log.error("body转字符串解析失败");
            }
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }

    public abstract void dealMessage(String msg);

}
