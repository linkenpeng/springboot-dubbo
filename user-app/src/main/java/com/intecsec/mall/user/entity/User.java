package com.intecsec.mall.user.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private Long id;

    private String userName;

    private String password;

    private String salt;

    private String nickName;

    private String avatar;

    private String role;

    private Date gmtCreated;

    private Date gmtUpdate;

    private Byte deleteMark;

}