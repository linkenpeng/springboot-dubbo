package com.intecsec.blog.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Blog {
    private Integer id;

    private String title;

    private String content;

    private Byte deleteMark;

    private Date createTime;

    private Date updateTime;
}