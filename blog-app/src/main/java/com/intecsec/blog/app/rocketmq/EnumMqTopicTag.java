package com.intecsec.blog.app.rocketmq;

/**
 * @description: mq的topic和tag
 * @author: peter.peng
 * @create: 2018-10-18 17:57
 **/
public enum EnumMqTopicTag {
    BLOG_MQ("PushTopic", "pushTag");

    private String topic;
    private String tag;

    EnumMqTopicTag(String topic, String tag) {
        this.topic = topic;
        this.tag = tag;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
