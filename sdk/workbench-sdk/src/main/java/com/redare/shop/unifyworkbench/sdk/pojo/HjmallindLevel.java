package com.redare.shop.unifyworkbench.sdk.pojo;

import java.io.Serializable;
import java.math.BigDecimal;import java.util.Date;

/**
 * 会员等级
 *
 * @date 2020-12-01 16:56:53
 * Created by tiankun
 */
public class HjmallindLevel implements Serializable {

    /**
     * 自增主键
     */
    private Long id;

    /**
     *
     */
    private Integer storeId;

    /**
     *
     */
    private Integer level;

    /**
     * 等级名称
     */
    private String name;

    /**
     * 会员完成订单金额满足则升级
     */
    private BigDecimal money;

    /**
     * 折扣
     */
    private BigDecimal discount;

    /**
     * 状态 0--禁用 1--启用
     */
    private Integer status;

    /**
     *
     */
    private Integer isDelete;

    /**
     *
     */
    private Integer addtime;

    /**
     * 会员图片
     */
    private String image;

    /**
     * 会员价格
     */
    private BigDecimal price;

    /**
     * 会员介绍
     */
    private String detail;

    /**
     * 购买之前提示
     */
    private String buyPrompt;

    /**
     * 会员权益(禁用)
     */
    private String synopsis;

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

    public HjmallindLevel setId(Long id) {
        this.id = id;
        return this;
    }


    public Integer getStoreId() {
        return storeId;
    }

    public HjmallindLevel setStoreId(Integer storeId) {
        this.storeId = storeId;
        return this;
    }


    public Integer getLevel() {
        return level;
    }

    public HjmallindLevel setLevel(Integer level) {
        this.level = level;
        return this;
    }


    public String getName() {
        return name;
    }

    public HjmallindLevel setName(String name) {
        this.name = name;
        return this;
    }


    public BigDecimal getMoney() {
        return money;
    }

    public HjmallindLevel setMoney(BigDecimal money) {
        this.money = money;
        return this;
    }


    public BigDecimal getDiscount() {
        return discount;
    }

    public HjmallindLevel setDiscount(BigDecimal discount) {
        this.discount = discount;
        return this;
    }


    public Integer getStatus() {
        return status;
    }

    public HjmallindLevel setStatus(Integer status) {
        this.status = status;
        return this;
    }


    public Integer getIsDelete() {
        return isDelete;
    }

    public HjmallindLevel setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
        return this;
    }


    public Integer getAddtime() {
        return addtime;
    }

    public HjmallindLevel setAddtime(Integer addtime) {
        this.addtime = addtime;
        return this;
    }


    public String getImage() {
        return image;
    }

    public HjmallindLevel setImage(String image) {
        this.image = image;
        return this;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public HjmallindLevel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }


    public String getDetail() {
        return detail;
    }

    public HjmallindLevel setDetail(String detail) {
        this.detail = detail;
        return this;
    }


    public String getBuyPrompt() {
        return buyPrompt;
    }

    public HjmallindLevel setBuyPrompt(String buyPrompt) {
        this.buyPrompt = buyPrompt;
        return this;
    }


    public String getSynopsis() {
        return synopsis;
    }

    public HjmallindLevel setSynopsis(String synopsis) {
        this.synopsis = synopsis;
        return this;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public HjmallindLevel setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public HjmallindLevel setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

}