package com.redare.shop.unifyworkbench.sdk.pojo;

import java.io.Serializable;
import java.math.BigDecimal;import java.util.Date;

/**
 * 订单明细
 *
 * @date 2020-12-01 16:21:41
 * Created by tiankun
 */
public class HjmallindOrderDetail implements Serializable {

    /**
     * 自增主键
     */
    private Long id;

    /**
     *
     */
    private Integer orderId;

    /**
     *
     */
    private Integer goodsId;

    /**
     * 商品数量
     */
    private Integer num;

    /**
     * 此商品的总价
     */
    private BigDecimal totalPrice;

    /**
     *
     */
    private Integer addtime;

    /**
     *
     */
    private Integer isDelete;

    /**
     * 商品规格
     */
    private String attr;

    /**
     * 商品规格图片
     */
    private String pic;

    /**
     * 单品积分获得
     */
    private Integer integral;

    /**
     * 是否使用会员折扣 0--不适用 1--使用
     */
    private Integer isLevel;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public HjmallindOrderDetail setId(Long id) {
        this.id = id;
        return this;
    }


    public Integer getOrderId() {
        return orderId;
    }

    public HjmallindOrderDetail setOrderId(Integer orderId) {
        this.orderId = orderId;
        return this;
    }


    public Integer getGoodsId() {
        return goodsId;
    }

    public HjmallindOrderDetail setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
        return this;
    }


    public Integer getNum() {
        return num;
    }

    public HjmallindOrderDetail setNum(Integer num) {
        this.num = num;
        return this;
    }


    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public HjmallindOrderDetail setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }


    public Integer getAddtime() {
        return addtime;
    }

    public HjmallindOrderDetail setAddtime(Integer addtime) {
        this.addtime = addtime;
        return this;
    }


    public Integer getIsDelete() {
        return isDelete;
    }

    public HjmallindOrderDetail setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
        return this;
    }


    public String getAttr() {
        return attr;
    }

    public HjmallindOrderDetail setAttr(String attr) {
        this.attr = attr;
        return this;
    }


    public String getPic() {
        return pic;
    }

    public HjmallindOrderDetail setPic(String pic) {
        this.pic = pic;
        return this;
    }


    public Integer getIntegral() {
        return integral;
    }

    public HjmallindOrderDetail setIntegral(Integer integral) {
        this.integral = integral;
        return this;
    }


    public Integer getIsLevel() {
        return isLevel;
    }

    public HjmallindOrderDetail setIsLevel(Integer isLevel) {
        this.isLevel = isLevel;
        return this;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public HjmallindOrderDetail setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public HjmallindOrderDetail setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

}