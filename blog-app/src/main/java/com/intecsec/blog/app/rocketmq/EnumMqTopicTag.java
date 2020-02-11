package com.intecsec.blog.app.rocketmq;

/**
 * @description: mq的topic和tag
 * @author: peter.peng
 * @create: 2018-10-18 17:57
 **/
public enum EnumMqTopicTag implements MqTopicTag {
    BLOG_MQ("PushTopic", "pushTag");

    private String topic;
    private String tag;

    EnumMqTopicTag(String topic, String tag) {
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
