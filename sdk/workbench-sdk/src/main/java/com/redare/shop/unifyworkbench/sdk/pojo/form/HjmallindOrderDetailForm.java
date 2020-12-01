package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

;import java.math.BigDecimal;

/**
 * 订单明细
 *
 * @date 2020-12-01 16:21:41
 * Created by tiankun
 */
public class HjmallindOrderDetailForm {

    public static class Add {
        /**
         *
         */
        @NotNull(message = "不能为空")
        private Integer orderId;

        /**
         *
         */
        @NotNull(message = "不能为空")
        private Integer goodsId;

        /**
         * 商品数量
         */
        @NotNull(message = "商品数量不能为空")
        private Integer num;

        /**
         * 此商品的总价
         */
        @NotNull(message = "此商品的总价不能为空")
        private BigDecimal totalPrice;

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
         * 商品规格
         */
        @NotBlank(message = "商品规格不能为空")
        private String attr;

        /**
         * 商品规格图片
         */
        @NotBlank(message = "商品规格图片不能为空")
        private String pic;

        /**
         * 单品积分获得
         */
        @NotNull(message = "单品积分获得不能为空")
        private Integer integral;

        /**
         * 是否使用会员折扣 0--不适用 1--使用
         */
        @NotNull(message = "是否使用会员折扣 0--不适用 1--使用不能为空")
        private Integer isLevel;


        public Integer getOrderId() {
            return orderId;
        }

        public Add setOrderId(Integer orderId) {
            this.orderId = orderId;
            return this;
        }


        public Integer getGoodsId() {
            return goodsId;
        }

        public Add setGoodsId(Integer goodsId) {
            this.goodsId = goodsId;
            return this;
        }


        public Integer getNum() {
            return num;
        }

        public Add setNum(Integer num) {
            this.num = num;
            return this;
        }


        public BigDecimal getTotalPrice() {
            return totalPrice;
        }

        public Add setTotalPrice(BigDecimal totalPrice) {
            this.totalPrice = totalPrice;
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


        public String getAttr() {
            return attr;
        }

        public Add setAttr(String attr) {
            this.attr = attr;
            return this;
        }


        public String getPic() {
            return pic;
        }

        public Add setPic(String pic) {
            this.pic = pic;
            return this;
        }


        public Integer getIntegral() {
            return integral;
        }

        public Add setIntegral(Integer integral) {
            this.integral = integral;
            return this;
        }


        public Integer getIsLevel() {
            return isLevel;
        }

        public Add setIsLevel(Integer isLevel) {
            this.isLevel = isLevel;
            return this;
        }


    }

    public static class Edit {

        @NotNull(message = "请传入id")
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

        public Long getId() {
            return id;
        }

        public Edit setId(Long id) {
            this.id = id;
            return this;
        }


        public Integer getOrderId() {
            return orderId;
        }

        public Edit setOrderId(Integer orderId) {
            this.orderId = orderId;
            return this;
        }

        public Integer getGoodsId() {
            return goodsId;
        }

        public Edit setGoodsId(Integer goodsId) {
            this.goodsId = goodsId;
            return this;
        }

        public Integer getNum() {
            return num;
        }

        public Edit setNum(Integer num) {
            this.num = num;
            return this;
        }

        public BigDecimal getTotalPrice() {
            return totalPrice;
        }

        public Edit setTotalPrice(BigDecimal totalPrice) {
            this.totalPrice = totalPrice;
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

        public String getAttr() {
            return attr;
        }

        public Edit setAttr(String attr) {
            this.attr = attr;
            return this;
        }

        public String getPic() {
            return pic;
        }

        public Edit setPic(String pic) {
            this.pic = pic;
            return this;
        }

        public Integer getIntegral() {
            return integral;
        }

        public Edit setIntegral(Integer integral) {
            this.integral = integral;
            return this;
        }

        public Integer getIsLevel() {
            return isLevel;
        }

        public Edit setIsLevel(Integer isLevel) {
            this.isLevel = isLevel;
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