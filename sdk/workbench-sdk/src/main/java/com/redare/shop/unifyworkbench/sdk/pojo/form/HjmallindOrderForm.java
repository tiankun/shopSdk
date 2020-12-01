package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

;import java.math.BigDecimal;

/**
 * 订单表
 *
 * @date 2020-12-01 16:21:27
 * Created by tiankun
 */
public class HjmallindOrderForm {

    public static class Add {
        /**
         *
         */
        @NotNull(message = "不能为空")
        private Integer storeId;

        /**
         * 用户id
         */
        @NotNull(message = "用户id不能为空")
        private Integer userId;

        /**
         * 订单号
         */
        @NotBlank(message = "订单号不能为空")
        private String orderNo;

        /**
         * 订单总费用(包含运费）
         */
        @NotNull(message = "订单总费用(包含运费）不能为空")
        private BigDecimal totalPrice;

        /**
         * 实际支付总费用(含运费）
         */
        @NotNull(message = "实际支付总费用(含运费）不能为空")
        private BigDecimal payPrice;

        /**
         * 运费
         */
        @NotNull(message = "运费不能为空")
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
        @NotBlank(message = "订单备注不能为空")
        private String remark;

        /**
         * 支付状态：0=未支付，1=已支付
         */
        @NotNull(message = "支付状态：0=未支付，1=已支付不能为空")
        private Integer isPay;

        /**
         * 支付方式：1=微信支付
         */
        @NotNull(message = "支付方式：1=微信支付不能为空")
        private Integer payType;

        /**
         * 支付时间
         */
        @NotNull(message = "支付时间不能为空")
        private Integer payTime;

        /**
         * 发货状态：0=未发货，1=已发货
         */
        @NotNull(message = "发货状态：0=未发货，1=已发货不能为空")
        private Integer isSend;

        /**
         * 发货时间
         */
        @NotNull(message = "发货时间不能为空")
        private Integer sendTime;

        /**
         * 物流公司
         */
        @NotBlank(message = "物流公司不能为空")
        private String express;

        /**
         *
         */
        @NotBlank(message = "不能为空")
        private String expressNo;

        /**
         * 确认收货状态：0=未确认，1=已确认收货
         */
        @NotNull(message = "确认收货状态：0=未确认，1=已确认收货不能为空")
        private Integer isConfirm;

        /**
         * 确认收货时间
         */
        @NotNull(message = "确认收货时间不能为空")
        private Integer confirmTime;

        /**
         * 是否已评价：0=未评价，1=已评价
         */
        @NotNull(message = "是否已评价：0=未评价，1=已评价不能为空")
        private Integer isComment;

        /**
         * 是否申请取消订单：0=否，1=申请取消订单
         */
        @NotNull(message = "是否申请取消订单：0=否，1=申请取消订单不能为空")
        private Integer applyDelete;

        /**
         *
         */
        @NotNull(message = "不能为空")
        private Integer addtime;

        /**
         *
         */
        @NotNull(message = "不能为空")
        private Integer isDelete;

        /**
         * 是否发放佣金
         */
        @NotNull(message = "是否发放佣金不能为空")
        private Integer isPrice;

        /**
         * 用户上级ID
         */
        @NotNull(message = "用户上级ID不能为空")
        private Integer parentId;

        /**
         * 一级佣金
         */
        @NotNull(message = "一级佣金不能为空")
        private BigDecimal firstPrice;

        /**
         * 二级佣金
         */
        @NotNull(message = "二级佣金不能为空")
        private BigDecimal secondPrice;

        /**
         * 三级佣金
         */
        @NotNull(message = "三级佣金不能为空")
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
        @NotNull(message = "是否到店自提 0--否 1--是不能为空")
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
        @NotNull(message = "是否取消不能为空")
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
        @NotNull(message = "是否发放积分【1=> 已发放 ， 0=> 未发放】不能为空")
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
        @NotNull(message = "入驻商户id不能为空")
        private Integer mchId;

        /**
         * 合并订单的id
         */
        @NotNull(message = "合并订单的id不能为空")
        private Integer orderUnionId;

        /**
         * 是否已转入商户账户：0=否，1=是
         */
        @NotNull(message = "是否已转入商户账户：0=否，1=是不能为空")
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
        @NotNull(message = "是否显示 0--不显示 1--显示不能为空")
        private Integer isShow;

        /**
         * 货币：活力币
         */
        private BigDecimal currency;


        public Integer getStoreId() {
            return storeId;
        }

        public Add setStoreId(Integer storeId) {
            this.storeId = storeId;
            return this;
        }


        public Integer getUserId() {
            return userId;
        }

        public Add setUserId(Integer userId) {
            this.userId = userId;
            return this;
        }


        public String getOrderNo() {
            return orderNo;
        }

        public Add setOrderNo(String orderNo) {
            this.orderNo = orderNo;
            return this;
        }


        public BigDecimal getTotalPrice() {
            return totalPrice;
        }

        public Add setTotalPrice(BigDecimal totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }


        public BigDecimal getPayPrice() {
            return payPrice;
        }

        public Add setPayPrice(BigDecimal payPrice) {
            this.payPrice = payPrice;
            return this;
        }


        public BigDecimal getExpressPrice() {
            return expressPrice;
        }

        public Add setExpressPrice(BigDecimal expressPrice) {
            this.expressPrice = expressPrice;
            return this;
        }


        public String getName() {
            return name;
        }

        public Add setName(String name) {
            this.name = name;
            return this;
        }


        public String getMobile() {
            return mobile;
        }

        public Add setMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }


        public String getAddress() {
            return address;
        }

        public Add setAddress(String address) {
            this.address = address;
            return this;
        }


        public String getRemark() {
            return remark;
        }

        public Add setRemark(String remark) {
            this.remark = remark;
            return this;
        }


        public Integer getIsPay() {
            return isPay;
        }

        public Add setIsPay(Integer isPay) {
            this.isPay = isPay;
            return this;
        }


        public Integer getPayType() {
            return payType;
        }

        public Add setPayType(Integer payType) {
            this.payType = payType;
            return this;
        }


        public Integer getPayTime() {
            return payTime;
        }

        public Add setPayTime(Integer payTime) {
            this.payTime = payTime;
            return this;
        }


        public Integer getIsSend() {
            return isSend;
        }

        public Add setIsSend(Integer isSend) {
            this.isSend = isSend;
            return this;
        }


        public Integer getSendTime() {
            return sendTime;
        }

        public Add setSendTime(Integer sendTime) {
            this.sendTime = sendTime;
            return this;
        }


        public String getExpress() {
            return express;
        }

        public Add setExpress(String express) {
            this.express = express;
            return this;
        }


        public String getExpressNo() {
            return expressNo;
        }

        public Add setExpressNo(String expressNo) {
            this.expressNo = expressNo;
            return this;
        }


        public Integer getIsConfirm() {
            return isConfirm;
        }

        public Add setIsConfirm(Integer isConfirm) {
            this.isConfirm = isConfirm;
            return this;
        }


        public Integer getConfirmTime() {
            return confirmTime;
        }

        public Add setConfirmTime(Integer confirmTime) {
            this.confirmTime = confirmTime;
            return this;
        }


        public Integer getIsComment() {
            return isComment;
        }

        public Add setIsComment(Integer isComment) {
            this.isComment = isComment;
            return this;
        }


        public Integer getApplyDelete() {
            return applyDelete;
        }

        public Add setApplyDelete(Integer applyDelete) {
            this.applyDelete = applyDelete;
            return this;
        }


        public Integer getAddtime() {
            return addtime;
        }

        public Add setAddtime(Integer addtime) {
            this.addtime = addtime;
            return this;
        }


        public Integer getIsDelete() {
            return isDelete;
        }

        public Add setIsDelete(Integer isDelete) {
            this.isDelete = isDelete;
            return this;
        }


        public Integer getIsPrice() {
            return isPrice;
        }

        public Add setIsPrice(Integer isPrice) {
            this.isPrice = isPrice;
            return this;
        }


        public Integer getParentId() {
            return parentId;
        }

        public Add setParentId(Integer parentId) {
            this.parentId = parentId;
            return this;
        }


        public BigDecimal getFirstPrice() {
            return firstPrice;
        }

        public Add setFirstPrice(BigDecimal firstPrice) {
            this.firstPrice = firstPrice;
            return this;
        }


        public BigDecimal getSecondPrice() {
            return secondPrice;
        }

        public Add setSecondPrice(BigDecimal secondPrice) {
            this.secondPrice = secondPrice;
            return this;
        }


        public BigDecimal getThirdPrice() {
            return thirdPrice;
        }

        public Add setThirdPrice(BigDecimal thirdPrice) {
            this.thirdPrice = thirdPrice;
            return this;
        }


        public BigDecimal getCouponSubPrice() {
            return couponSubPrice;
        }

        public Add setCouponSubPrice(BigDecimal couponSubPrice) {
            this.couponSubPrice = couponSubPrice;
            return this;
        }


        public String getContent() {
            return content;
        }

        public Add setContent(String content) {
            this.content = content;
            return this;
        }


        public Integer getIsOffline() {
            return isOffline;
        }

        public Add setIsOffline(Integer isOffline) {
            this.isOffline = isOffline;
            return this;
        }


        public Integer getClerkId() {
            return clerkId;
        }

        public Add setClerkId(Integer clerkId) {
            this.clerkId = clerkId;
            return this;
        }


        public String getAddressData() {
            return addressData;
        }

        public Add setAddressData(String addressData) {
            this.addressData = addressData;
            return this;
        }


        public Integer getIsCancel() {
            return isCancel;
        }

        public Add setIsCancel(Integer isCancel) {
            this.isCancel = isCancel;
            return this;
        }


        public String getOfflineQrcode() {
            return offlineQrcode;
        }

        public Add setOfflineQrcode(String offlineQrcode) {
            this.offlineQrcode = offlineQrcode;
            return this;
        }


        public BigDecimal getBeforeUpdatePrice() {
            return beforeUpdatePrice;
        }

        public Add setBeforeUpdatePrice(BigDecimal beforeUpdatePrice) {
            this.beforeUpdatePrice = beforeUpdatePrice;
            return this;
        }


        public Integer getShopId() {
            return shopId;
        }

        public Add setShopId(Integer shopId) {
            this.shopId = shopId;
            return this;
        }


        public BigDecimal getDiscount() {
            return discount;
        }

        public Add setDiscount(BigDecimal discount) {
            this.discount = discount;
            return this;
        }


        public Integer getUserCouponId() {
            return userCouponId;
        }

        public Add setUserCouponId(Integer userCouponId) {
            this.userCouponId = userCouponId;
            return this;
        }


        public String getIntegral() {
            return integral;
        }

        public Add setIntegral(String integral) {
            this.integral = integral;
            return this;
        }


        public Integer getGiveIntegral() {
            return giveIntegral;
        }

        public Add setGiveIntegral(Integer giveIntegral) {
            this.giveIntegral = giveIntegral;
            return this;
        }


        public Integer getParentId1() {
            return parentId1;
        }

        public Add setParentId1(Integer parentId1) {
            this.parentId1 = parentId1;
            return this;
        }


        public Integer getParentId2() {
            return parentId2;
        }

        public Add setParentId2(Integer parentId2) {
            this.parentId2 = parentId2;
            return this;
        }


        public Integer getIsSale() {
            return isSale;
        }

        public Add setIsSale(Integer isSale) {
            this.isSale = isSale;
            return this;
        }


        public String getWords() {
            return words;
        }

        public Add setWords(String words) {
            this.words = words;
            return this;
        }


        public String getVersion() {
            return version;
        }

        public Add setVersion(String version) {
            this.version = version;
            return this;
        }


        public BigDecimal getExpressPrice1() {
            return expressPrice1;
        }

        public Add setExpressPrice1(BigDecimal expressPrice1) {
            this.expressPrice1 = expressPrice1;
            return this;
        }


        public Integer getIsRecycle() {
            return isRecycle;
        }

        public Add setIsRecycle(Integer isRecycle) {
            this.isRecycle = isRecycle;
            return this;
        }


        public BigDecimal getRebate() {
            return rebate;
        }

        public Add setRebate(BigDecimal rebate) {
            this.rebate = rebate;
            return this;
        }


        public BigDecimal getBeforeUpdateExpress() {
            return beforeUpdateExpress;
        }

        public Add setBeforeUpdateExpress(BigDecimal beforeUpdateExpress) {
            this.beforeUpdateExpress = beforeUpdateExpress;
            return this;
        }


        public String getSellerComments() {
            return sellerComments;
        }

        public Add setSellerComments(String sellerComments) {
            this.sellerComments = sellerComments;
            return this;
        }


        public Integer getMchId() {
            return mchId;
        }

        public Add setMchId(Integer mchId) {
            this.mchId = mchId;
            return this;
        }


        public Integer getOrderUnionId() {
            return orderUnionId;
        }

        public Add setOrderUnionId(Integer orderUnionId) {
            this.orderUnionId = orderUnionId;
            return this;
        }


        public Integer getIsTransfer() {
            return isTransfer;
        }

        public Add setIsTransfer(Integer isTransfer) {
            this.isTransfer = isTransfer;
            return this;
        }


        public Integer getType() {
            return type;
        }

        public Add setType(Integer type) {
            this.type = type;
            return this;
        }


        public BigDecimal getSharePrice() {
            return sharePrice;
        }

        public Add setSharePrice(BigDecimal sharePrice) {
            this.sharePrice = sharePrice;
            return this;
        }


        public Integer getIsShow() {
            return isShow;
        }

        public Add setIsShow(Integer isShow) {
            this.isShow = isShow;
            return this;
        }


        public BigDecimal getCurrency() {
            return currency;
        }

        public Add setCurrency(BigDecimal currency) {
            this.currency = currency;
            return this;
        }


    }

    public static class Edit {

        @NotNull(message = "请传入id")
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

        public Long getId() {
            return id;
        }

        public Edit setId(Long id) {
            this.id = id;
            return this;
        }


        public Integer getStoreId() {
            return storeId;
        }

        public Edit setStoreId(Integer storeId) {
            this.storeId = storeId;
            return this;
        }

        public Integer getUserId() {
            return userId;
        }

        public Edit setUserId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public String getOrderNo() {
            return orderNo;
        }

        public Edit setOrderNo(String orderNo) {
            this.orderNo = orderNo;
            return this;
        }

        public BigDecimal getTotalPrice() {
            return totalPrice;
        }

        public Edit setTotalPrice(BigDecimal totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public BigDecimal getPayPrice() {
            return payPrice;
        }

        public Edit setPayPrice(BigDecimal payPrice) {
            this.payPrice = payPrice;
            return this;
        }

        public BigDecimal getExpressPrice() {
            return expressPrice;
        }

        public Edit setExpressPrice(BigDecimal expressPrice) {
            this.expressPrice = expressPrice;
            return this;
        }

        public String getName() {
            return name;
        }

        public Edit setName(String name) {
            this.name = name;
            return this;
        }

        public String getMobile() {
            return mobile;
        }

        public Edit setMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public String getAddress() {
            return address;
        }

        public Edit setAddress(String address) {
            this.address = address;
            return this;
        }

        public String getRemark() {
            return remark;
        }

        public Edit setRemark(String remark) {
            this.remark = remark;
            return this;
        }

        public Integer getIsPay() {
            return isPay;
        }

        public Edit setIsPay(Integer isPay) {
            this.isPay = isPay;
            return this;
        }

        public Integer getPayType() {
            return payType;
        }

        public Edit setPayType(Integer payType) {
            this.payType = payType;
            return this;
        }

        public Integer getPayTime() {
            return payTime;
        }

        public Edit setPayTime(Integer payTime) {
            this.payTime = payTime;
            return this;
        }

        public Integer getIsSend() {
            return isSend;
        }

        public Edit setIsSend(Integer isSend) {
            this.isSend = isSend;
            return this;
        }

        public Integer getSendTime() {
            return sendTime;
        }

        public Edit setSendTime(Integer sendTime) {
            this.sendTime = sendTime;
            return this;
        }

        public String getExpress() {
            return express;
        }

        public Edit setExpress(String express) {
            this.express = express;
            return this;
        }

        public String getExpressNo() {
            return expressNo;
        }

        public Edit setExpressNo(String expressNo) {
            this.expressNo = expressNo;
            return this;
        }

        public Integer getIsConfirm() {
            return isConfirm;
        }

        public Edit setIsConfirm(Integer isConfirm) {
            this.isConfirm = isConfirm;
            return this;
        }

        public Integer getConfirmTime() {
            return confirmTime;
        }

        public Edit setConfirmTime(Integer confirmTime) {
            this.confirmTime = confirmTime;
            return this;
        }

        public Integer getIsComment() {
            return isComment;
        }

        public Edit setIsComment(Integer isComment) {
            this.isComment = isComment;
            return this;
        }

        public Integer getApplyDelete() {
            return applyDelete;
        }

        public Edit setApplyDelete(Integer applyDelete) {
            this.applyDelete = applyDelete;
            return this;
        }

        public Integer getAddtime() {
            return addtime;
        }

        public Edit setAddtime(Integer addtime) {
            this.addtime = addtime;
            return this;
        }

        public Integer getIsDelete() {
            return isDelete;
        }

        public Edit setIsDelete(Integer isDelete) {
            this.isDelete = isDelete;
            return this;
        }

        public Integer getIsPrice() {
            return isPrice;
        }

        public Edit setIsPrice(Integer isPrice) {
            this.isPrice = isPrice;
            return this;
        }

        public Integer getParentId() {
            return parentId;
        }

        public Edit setParentId(Integer parentId) {
            this.parentId = parentId;
            return this;
        }

        public BigDecimal getFirstPrice() {
            return firstPrice;
        }

        public Edit setFirstPrice(BigDecimal firstPrice) {
            this.firstPrice = firstPrice;
            return this;
        }

        public BigDecimal getSecondPrice() {
            return secondPrice;
        }

        public Edit setSecondPrice(BigDecimal secondPrice) {
            this.secondPrice = secondPrice;
            return this;
        }

        public BigDecimal getThirdPrice() {
            return thirdPrice;
        }

        public Edit setThirdPrice(BigDecimal thirdPrice) {
            this.thirdPrice = thirdPrice;
            return this;
        }

        public BigDecimal getCouponSubPrice() {
            return couponSubPrice;
        }

        public Edit setCouponSubPrice(BigDecimal couponSubPrice) {
            this.couponSubPrice = couponSubPrice;
            return this;
        }

        public String getContent() {
            return content;
        }

        public Edit setContent(String content) {
            this.content = content;
            return this;
        }

        public Integer getIsOffline() {
            return isOffline;
        }

        public Edit setIsOffline(Integer isOffline) {
            this.isOffline = isOffline;
            return this;
        }

        public Integer getClerkId() {
            return clerkId;
        }

        public Edit setClerkId(Integer clerkId) {
            this.clerkId = clerkId;
            return this;
        }

        public String getAddressData() {
            return addressData;
        }

        public Edit setAddressData(String addressData) {
            this.addressData = addressData;
            return this;
        }

        public Integer getIsCancel() {
            return isCancel;
        }

        public Edit setIsCancel(Integer isCancel) {
            this.isCancel = isCancel;
            return this;
        }

        public String getOfflineQrcode() {
            return offlineQrcode;
        }

        public Edit setOfflineQrcode(String offlineQrcode) {
            this.offlineQrcode = offlineQrcode;
            return this;
        }

        public BigDecimal getBeforeUpdatePrice() {
            return beforeUpdatePrice;
        }

        public Edit setBeforeUpdatePrice(BigDecimal beforeUpdatePrice) {
            this.beforeUpdatePrice = beforeUpdatePrice;
            return this;
        }

        public Integer getShopId() {
            return shopId;
        }

        public Edit setShopId(Integer shopId) {
            this.shopId = shopId;
            return this;
        }

        public BigDecimal getDiscount() {
            return discount;
        }

        public Edit setDiscount(BigDecimal discount) {
            this.discount = discount;
            return this;
        }

        public Integer getUserCouponId() {
            return userCouponId;
        }

        public Edit setUserCouponId(Integer userCouponId) {
            this.userCouponId = userCouponId;
            return this;
        }

        public String getIntegral() {
            return integral;
        }

        public Edit setIntegral(String integral) {
            this.integral = integral;
            return this;
        }

        public Integer getGiveIntegral() {
            return giveIntegral;
        }

        public Edit setGiveIntegral(Integer giveIntegral) {
            this.giveIntegral = giveIntegral;
            return this;
        }

        public Integer getParentId1() {
            return parentId1;
        }

        public Edit setParentId1(Integer parentId1) {
            this.parentId1 = parentId1;
            return this;
        }

        public Integer getParentId2() {
            return parentId2;
        }

        public Edit setParentId2(Integer parentId2) {
            this.parentId2 = parentId2;
            return this;
        }

        public Integer getIsSale() {
            return isSale;
        }

        public Edit setIsSale(Integer isSale) {
            this.isSale = isSale;
            return this;
        }

        public String getWords() {
            return words;
        }

        public Edit setWords(String words) {
            this.words = words;
            return this;
        }

        public String getVersion() {
            return version;
        }

        public Edit setVersion(String version) {
            this.version = version;
            return this;
        }

        public BigDecimal getExpressPrice1() {
            return expressPrice1;
        }

        public Edit setExpressPrice1(BigDecimal expressPrice1) {
            this.expressPrice1 = expressPrice1;
            return this;
        }

        public Integer getIsRecycle() {
            return isRecycle;
        }

        public Edit setIsRecycle(Integer isRecycle) {
            this.isRecycle = isRecycle;
            return this;
        }

        public BigDecimal getRebate() {
            return rebate;
        }

        public Edit setRebate(BigDecimal rebate) {
            this.rebate = rebate;
            return this;
        }

        public BigDecimal getBeforeUpdateExpress() {
            return beforeUpdateExpress;
        }

        public Edit setBeforeUpdateExpress(BigDecimal beforeUpdateExpress) {
            this.beforeUpdateExpress = beforeUpdateExpress;
            return this;
        }

        public String getSellerComments() {
            return sellerComments;
        }

        public Edit setSellerComments(String sellerComments) {
            this.sellerComments = sellerComments;
            return this;
        }

        public Integer getMchId() {
            return mchId;
        }

        public Edit setMchId(Integer mchId) {
            this.mchId = mchId;
            return this;
        }

        public Integer getOrderUnionId() {
            return orderUnionId;
        }

        public Edit setOrderUnionId(Integer orderUnionId) {
            this.orderUnionId = orderUnionId;
            return this;
        }

        public Integer getIsTransfer() {
            return isTransfer;
        }

        public Edit setIsTransfer(Integer isTransfer) {
            this.isTransfer = isTransfer;
            return this;
        }

        public Integer getType() {
            return type;
        }

        public Edit setType(Integer type) {
            this.type = type;
            return this;
        }

        public BigDecimal getSharePrice() {
            return sharePrice;
        }

        public Edit setSharePrice(BigDecimal sharePrice) {
            this.sharePrice = sharePrice;
            return this;
        }

        public Integer getIsShow() {
            return isShow;
        }

        public Edit setIsShow(Integer isShow) {
            this.isShow = isShow;
            return this;
        }

        public BigDecimal getCurrency() {
            return currency;
        }

        public Edit setCurrency(BigDecimal currency) {
            this.currency = currency;
            return this;
        }

    }

    public static class Search {

        private String queryFields;

        private String key;


        public String getKey() {
            return key;
        }

        public Search setKey(String key) {
            this.key = key;
            return this;
        }

        public String getQueryFields() {
            return queryFields;
        }

        public Search setQueryFields(String queryFields) {
            this.queryFields = queryFields;
            return this;
        }


    }


    public static class Get {
        @NotNull(message = "请传入id")
        private Long id;

        private String queryFields;


        public Long getId() {
            return id;
        }

        public Get setId(Long id) {
            this.id = id;
            return this;
        }

        public String getQueryFields() {
            return queryFields;
        }

        public Get setQueryFields(String queryFields) {
            this.queryFields = queryFields;
            return this;
        }

    }

    public static class Del {
        @NotNull(message = "请传入id")
        private Long id;

        public Long getId() {
            return id;
        }

        public Del setId(Long id) {
            this.id = id;
            return this;
        }
    }


}