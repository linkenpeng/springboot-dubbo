package com.intecsec.blog.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: Blog
 * @author: peter.peng
 * @create: 2018-10-18 11:28
 **/
@Data
public class BlogDTO implements Serializable {

    private Integer id;

    private String title;

    private String content;

    private Byte deleteMark;

    private Date createTime;

    private Date updateTime;
}
