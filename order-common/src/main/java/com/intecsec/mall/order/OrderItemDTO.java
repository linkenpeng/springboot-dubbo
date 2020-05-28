package com.intecsec.mall.order;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-04-04 19:42
 **/
@Data
public class OrderItemDTO implements Serializable {

    private static final long serialVersionUID = 7736501051774467112L;

    private Integer id;

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
