package com.intecsec.mall.order.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderItem {
    private Long id;

    private Long orderId;

    private Long itemId;

    private Long itemPrice;

    private Integer itemNum;

    private String itemName;

    private BigDecimal coupon;

    private Long couponAmout;

    private BigDecimal pointMoney;

    private Integer pointAmount;

    private BigDecimal discount;

    private Long discountAmount;

    private Date gmtCreated;

    private Date gmtUpdate;

    private Byte deleteMark;
}