package com.redare.shop.unifyworkbench.sdk.pojo;

import java.io.Serializable;
import java.math.BigDecimal;import java.util.Date;

/**
 * 订单表
 *
 * @date 2020-12-01 16:21:27
 * Created by tiankun
 */
public class HjmallindOrder implements Serializable {

    /**
     * 自增主键
     */
    private Long id;

    /**
     *
     */
    private Integer storeId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 订单总费用(包含运费）
     */
    private BigDecimal totalPrice;

    /**
     * 实际支付总费用(含运费）
     */
    private BigDecimal payPrice;

    /**
     * 运费
     */
    private BigDecimal expressPrice;

    /**
     * 收货人姓名
     */
    private String name;

    /**
     * 收货人手机
     */
    private String mobile;

    /**
     * 收货地址
     */
    private String address;

    /**
     * 订单备注
     */
    private String remark;

    /**
     * 支付状态：0=未支付，1=已支付
     */
    private Integer isPay;

    /**
     * 支付方式：1=微信支付
     */
    private Integer payType;

    /**
     * 支付时间
     */
    private Integer payTime;

    /**
     * 发货状态：0=未发货，1=已发货
     */
    private Integer isSend;

    /**
     * 发货时间
     */
    private Integer sendTime;

    /**
     * 物流公司
     */
    private String express;

    /**
     *
     */
    private String expressNo;

    /**
     * 确认收货状态：0=未确认，1=已确认收货
     */
    private Integer isConfirm;

    /**
     * 确认收货时间
     */
    private Integer confirmTime;

    /**
     * 是否已评价：0=未评价，1=已评价
     */
    private Integer isComment;

    /**
     * 是否申请取消订单：0=否，1=申请取消订单
     */
    private Integer applyDelete;

    /**
     *
     */
    private Integer addtime;

    /**
     *
     */
    private Integer isDelete;

    /**
     * 是否发放佣金
     */
    private Integer isPrice;

    /**
     * 用户上级ID
     */
    private Integer parentId;

    /**
     * 一级佣金
     */
    private BigDecimal firstPrice;

    /**
     * 二级佣金
     */
    private BigDecimal secondPrice;

    /**
     * 三级佣金
     */
    private BigDecimal thirdPrice;

    /**
     * 优惠券抵消金额
     */
    private BigDecimal couponSubPrice;

    /**
     *
     */
    private String content;

    /**
     * 是否到店自提 0--否 1--是
     */
    private Integer isOffline;

    /**
     * 核销员user_id
     */
    private Integer clerkId;

    /**
     * 收货地址信息，json格式
     */
    private String addressData;

    /**
     * 是否取消
     */
    private Integer isCancel;

    /**
     * 核销码
     */
    private String offlineQrcode;

    /**
     * 修改前的价格
     */
    private BigDecimal beforeUpdatePrice;

    /**
     * 自提门店ID
     */
    private Integer shopId;

    /**
     * 会员折扣
     */
    private BigDecimal discount;

    /**
     * 使用的优惠券ID
     */
    private Integer userCouponId;

    /**
     * 积分使用
     */
    private String integral;

    /**
     * 是否发放积分【1=> 已发放 ， 0=> 未发放】
     */
    private Integer giveIntegral;

    /**
     * 用户上二级ID
     */
    private Integer parentId1;

    /**
     * 用户上三级ID
     */
    private Integer parentId2;

    /**
     * 是否超过售后时间
     */
    private Integer isSale;

    /**
     * 商家留言
     */
    private String words;

    /**
     * 版本
     */
    private String version;

    /**
     * 减免的运费
     */
    private BigDecimal expressPrice1;

    /**
     *
     */
    private Integer isRecycle;

    /**
     * 自购返利
     */
    private BigDecimal rebate;

    /**
     * 价格修改前的运费
     */
    private BigDecimal beforeUpdateExpress;

    /**
     * 商家备注
     */
    private String sellerComments;

    /**
     * 入驻商户id
     */
    private Integer mchId;

    /**
     * 合并订单的id
     */
    private Integer orderUnionId;

    /**
     * 是否已转入商户账户：0=否，1=是
     */
    private Integer isTransfer;

    /**
     * 0:普通订单 1大转盘订单
     */
    private Integer type;

    /**
     * 发放佣金的金额
     */
    private BigDecimal sharePrice;

    /**
     * 是否显示 0--不显示 1--显示
     */
    private Integer isShow;

    /**
     * 货币：活力币
     */
    private BigDecimal currency;

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

    public HjmallindOrder setId(Long id) {
        this.id = id;
        return this;
    }


    public Integer getStoreId() {
        return storeId;
    }

    public HjmallindOrder setStoreId(Integer storeId) {
        this.storeId = storeId;
        return this;
    }


    public Integer getUserId() {
        return userId;
    }

    public HjmallindOrder setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }


    public String getOrderNo() {
        return orderNo;
    }

    public HjmallindOrder setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }


    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public HjmallindOrder setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }


    public BigDecimal getPayPrice() {
        return payPrice;
    }

    public HjmallindOrder setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
        return this;
    }


    public BigDecimal getExpressPrice() {
        return expressPrice;
    }

    public HjmallindOrder setExpressPrice(BigDecimal expressPrice) {
        this.expressPrice = expressPrice;
        return this;
    }


    public String getName() {
        return name;
    }

    public HjmallindOrder setName(String name) {
        this.name = name;
        return this;
    }


    public String getMobile() {
        return mobile;
    }

    public HjmallindOrder setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }


    public String getAddress() {
        return address;
    }

    public HjmallindOrder setAddress(String address) {
        this.address = address;
        return this;
    }


    public String getRemark() {
        return remark;
    }

    public HjmallindOrder setRemark(String remark) {
        this.remark = remark;
        return this;
    }


    public Integer getIsPay() {
        return isPay;
    }

    public HjmallindOrder setIsPay(Integer isPay) {
        this.isPay = isPay;
        return this;
    }


    public Integer getPayType() {
        return payType;
    }

    public HjmallindOrder setPayType(Integer payType) {
        this.payType = payType;
        return this;
    }


    public Integer getPayTime() {
        return payTime;
    }

    public HjmallindOrder setPayTime(Integer payTime) {
        this.payTime = payTime;
        return this;
    }


    public Integer getIsSend() {
        return isSend;
    }

    public HjmallindOrder setIsSend(Integer isSend) {
        this.isSend = isSend;
        return this;
    }


    public Integer getSendTime() {
        return sendTime;
    }

    public HjmallindOrder setSendTime(Integer sendTime) {
        this.sendTime = sendTime;
        return this;
    }


    public String getExpress() {
        return express;
    }

    public HjmallindOrder setExpress(String express) {
        this.express = express;
        return this;
    }


    public String getExpressNo() {
        return expressNo;
    }

    public HjmallindOrder setExpressNo(String expressNo) {
        this.expressNo = expressNo;
        return this;
    }


    public Integer getIsConfirm() {
        return isConfirm;
    }

    public HjmallindOrder setIsConfirm(Integer isConfirm) {
        this.isConfirm = isConfirm;
        return this;
    }


    public Integer getConfirmTime() {
        return confirmTime;
    }

    public HjmallindOrder setConfirmTime(Integer confirmTime) {
        this.confirmTime = confirmTime;
        return this;
    }


    public Integer getIsComment() {
        return isComment;
    }

    public HjmallindOrder setIsComment(Integer isComment) {
        this.isComment = isComment;
        return this;
    }


    public Integer getApplyDelete() {
        return applyDelete;
    }

    public HjmallindOrder setApplyDelete(Integer applyDelete) {
        this.applyDelete = applyDelete;
        return this;
    }


    public Integer getAddtime() {
        return addtime;
    }

    public HjmallindOrder setAddtime(Integer addtime) {
        this.addtime = addtime;
        return this;
    }


    public Integer getIsDelete() {
        return isDelete;
    }

    public HjmallindOrder setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
        return this;
    }


    public Integer getIsPrice() {
        return isPrice;
    }

    public HjmallindOrder setIsPrice(Integer isPrice) {
        this.isPrice = isPrice;
        return this;
    }


    public Integer getParentId() {
        return parentId;
    }

    public HjmallindOrder setParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }


    public BigDecimal getFirstPrice() {
        return firstPrice;
    }

    public HjmallindOrder setFirstPrice(BigDecimal firstPrice) {
        this.firstPrice = firstPrice;
        return this;
    }


    public BigDecimal getSecondPrice() {
        return secondPrice;
    }

    public HjmallindOrder setSecondPrice(BigDecimal secondPrice) {
        this.secondPrice = secondPrice;
        return this;
    }


    public BigDecimal getThirdPrice() {
        return thirdPrice;
    }

    public HjmallindOrder setThirdPrice(BigDecimal thirdPrice) {
        this.thirdPrice = thirdPrice;
        return this;
    }


    public BigDecimal getCouponSubPrice() {
        return couponSubPrice;
    }

    public HjmallindOrder setCouponSubPrice(BigDecimal couponSubPrice) {
        this.couponSubPrice = couponSubPrice;
        return this;
    }


    public String getContent() {
        return content;
    }

    public HjmallindOrder setContent(String content) {
        this.content = content;
        return this;
    }


    public Integer getIsOffline() {
        return isOffline;
    }

    public HjmallindOrder setIsOffline(Integer isOffline) {
        this.isOffline = isOffline;
        return this;
    }


    public Integer getClerkId() {
        return clerkId;
    }

    public HjmallindOrder setClerkId(Integer clerkId) {
        this.clerkId = clerkId;
        return this;
    }


    public String getAddressData() {
        return addressData;
    }

    public HjmallindOrder setAddressData(String addressData) {
        this.addressData = addressData;
        return this;
    }


    public Integer getIsCancel() {
        return isCancel;
    }

    public HjmallindOrder setIsCancel(Integer isCancel) {
        this.isCancel = isCancel;
        return this;
    }


    public String getOfflineQrcode() {
        return offlineQrcode;
    }

    public HjmallindOrder setOfflineQrcode(String offlineQrcode) {
        this.offlineQrcode = offlineQrcode;
        return this;
    }


    public BigDecimal getBeforeUpdatePrice() {
        return beforeUpdatePrice;
    }

    public HjmallindOrder setBeforeUpdatePrice(BigDecimal beforeUpdatePrice) {
        this.beforeUpdatePrice = beforeUpdatePrice;
        return this;
    }


    public Integer getShopId() {
        return shopId;
    }

    public HjmallindOrder setShopId(Integer shopId) {
        this.shopId = shopId;
        return this;
    }


    public BigDecimal getDiscount() {
        return discount;
    }

    public HjmallindOrder setDiscount(BigDecimal discount) {
        this.discount = discount;
        return this;
    }


    public Integer getUserCouponId() {
        return userCouponId;
    }

    public HjmallindOrder setUserCouponId(Integer userCouponId) {
        this.userCouponId = userCouponId;
        return this;
    }


    public String getIntegral() {
        return integral;
    }

    public HjmallindOrder setIntegral(String integral) {
        this.integral = integral;
        return this;
    }


    public Integer getGiveIntegral() {
        return giveIntegral;
    }

    public HjmallindOrder setGiveIntegral(Integer giveIntegral) {
        this.giveIntegral = giveIntegral;
        return this;
    }


    public Integer getParentId1() {
        return parentId1;
    }

    public HjmallindOrder setParentId1(Integer parentId1) {
        this.parentId1 = parentId1;
        return this;
    }


    public Integer getParentId2() {
        return parentId2;
    }

    public HjmallindOrder setParentId2(Integer parentId2) {
        this.parentId2 = parentId2;
        return this;
    }


    public Integer getIsSale() {
        return isSale;
    }

    public HjmallindOrder setIsSale(Integer isSale) {
        this.isSale = isSale;
        return this;
    }


    public String getWords() {
        return words;
    }

    public HjmallindOrder setWords(String words) {
        this.words = words;
        return this;
    }


    public String getVersion() {
        return version;
    }

    public HjmallindOrder setVersion(String version) {
        this.version = version;
        return this;
    }


    public BigDecimal getExpressPrice1() {
        return expressPrice1;
    }

    public HjmallindOrder setExpressPrice1(BigDecimal expressPrice1) {
        this.expressPrice1 = expressPrice1;
        return this;
    }


    public Integer getIsRecycle() {
        return isRecycle;
    }

    public HjmallindOrder setIsRecycle(Integer isRecycle) {
        this.isRecycle = isRecycle;
        return this;
    }


    public BigDecimal getRebate() {
        return rebate;
    }

    public HjmallindOrder setRebate(BigDecimal rebate) {
        this.rebate = rebate;
        return this;
    }


    public BigDecimal getBeforeUpdateExpress() {
        return beforeUpdateExpress;
    }

    public HjmallindOrder setBeforeUpdateExpress(BigDecimal beforeUpdateExpress) {
        this.beforeUpdateExpress = beforeUpdateExpress;
        return this;
    }


    public String getSellerComments() {
        return sellerComments;
    }

    public HjmallindOrder setSellerComments(String sellerComments) {
        this.sellerComments = sellerComments;
        return this;
    }


    public Integer getMchId() {
        return mchId;
    }

    public HjmallindOrder setMchId(Integer mchId) {
        this.mchId = mchId;
        return this;
    }


    public Integer getOrderUnionId() {
        return orderUnionId;
    }

    public HjmallindOrder setOrderUnionId(Integer orderUnionId) {
        this.orderUnionId = orderUnionId;
        return this;
    }


    public Integer getIsTransfer() {
        return isTransfer;
    }

    public HjmallindOrder setIsTransfer(Integer isTransfer) {
        this.isTransfer = isTransfer;
        return this;
    }


    public Integer getType() {
        return type;
    }

    public HjmallindOrder setType(Integer type) {
        this.type = type;
        return this;
    }


    public BigDecimal getSharePrice() {
        return sharePrice;
    }

    public HjmallindOrder setSharePrice(BigDecimal sharePrice) {
        this.sharePrice = sharePrice;
        return this;
    }


    public Integer getIsShow() {
        return isShow;
    }

    public HjmallindOrder setIsShow(Integer isShow) {
        this.isShow = isShow;
        return this;
    }


    public BigDecimal getCurrency() {
        return currency;
    }

    public HjmallindOrder setCurrency(BigDecimal currency) {
        this.currency = currency;
        return this;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public HjmallindOrder setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public HjmallindOrder setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

}