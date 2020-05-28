package com.intecsec.blog.mq.consumer;

import com.intecsec.mall.rocketmq.MqTopicTag;

/**
 * @description: mq的topic和tag
 * @author: peter.peng
 * @create: 2018-10-18 17:57
 **/
public enum BlogMqTopicTag implements MqTopicTag {
    BLOG_INFO_MQ("PushTopic", "blogInfoTag");

    private String topic;
    private String tag;

    BlogMqTopicTag(String topic, String tag) {
        this.topic = topic;
        this.tag = tag;
    }

    @Override
    public String getTopic() {
        return topic;
    }

    @Override
    public String getTag() {
        return tag;
    }
}
