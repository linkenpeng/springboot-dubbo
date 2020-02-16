package com.intecsec.mall.entity;

import java.math.BigDecimal;
import java.util.Date;

public class OrderItem {
    private Integer id;

    private Long orderId;

    private Long itemId;

    private Long itemPrice;

    private Integer itemNum;

    private BigDecimal coupon;

    private Long couponAmout;

    private BigDecimal pointMoney;

    private Integer pointAmount;

    private BigDecimal discount;

    private Long discountAmount;

    private Date gmtCreated;

    private Date gmtUpdate;

    private Byte deleteMark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Long itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Integer getItemNum() {
        return itemNum;
    }

    public void setItemNum(Integer itemNum) {
        this.itemNum = itemNum;
    }

    public BigDecimal getCoupon() {
        return coupon;
    }

    public void setCoupon(BigDecimal coupon) {
        this.coupon = coupon;
    }

    public Long getCouponAmout() {
        return couponAmout;
    }

    public void setCouponAmout(Long couponAmout) {
        this.couponAmout = couponAmout;
    }

    public BigDecimal getPointMoney() {
        return pointMoney;
    }

    public void setPointMoney(BigDecimal pointMoney) {
        this.pointMoney = pointMoney;
    }

    public Integer getPointAmount() {
        return pointAmount;
    }

    public void setPointAmount(Integer pointAmount) {
        this.pointAmount = pointAmount;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Long getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Long discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

    public Byte getDeleteMark() {
        return deleteMark;
    }

    public void setDeleteMark(Byte deleteMark) {
        this.deleteMark = deleteMark;
    }
}