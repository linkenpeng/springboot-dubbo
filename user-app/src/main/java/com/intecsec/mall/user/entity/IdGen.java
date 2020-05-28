package com.intecsec.mall.user.entity;

import lombok.Data;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-05-27 16:09
 **/
@Data
public class IdGen {

    private String idName;

    private long nextStartId = 1L;

    private int fetchLen = 100;

    private String idDesc;
}
