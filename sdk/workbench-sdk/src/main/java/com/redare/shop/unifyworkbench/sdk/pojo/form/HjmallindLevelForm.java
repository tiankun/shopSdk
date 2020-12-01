package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotNull;

;import java.math.BigDecimal;

/**
 * 会员等级
 *
 * @date 2020-12-01 16:56:53
 * Created by tiankun
 */
public class HjmallindLevelForm {

    public static class Add {
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


        public Integer getStoreId() {
            return storeId;
        }

        public Add setStoreId(Integer storeId) {
            this.storeId = storeId;
            return this;
        }


        public Integer getLevel() {
            return level;
        }

        public Add setLevel(Integer level) {
            this.level = level;
            return this;
        }


        public String getName() {
            return name;
        }

        public Add setName(String name) {
            this.name = name;
            return this;
        }


        public BigDecimal getMoney() {
            return money;
        }

        public Add setMoney(BigDecimal money) {
            this.money = money;
            return this;
        }


        public BigDecimal getDiscount() {
            return discount;
        }

        public Add setDiscount(BigDecimal discount) {
            this.discount = discount;
            return this;
        }


        public Integer getStatus() {
            return status;
        }

        public Add setStatus(Integer status) {
            this.status = status;
            return this;
        }


        public Integer getIsDelete() {
            return isDelete;
        }

        public Add setIsDelete(Integer isDelete) {
            this.isDelete = isDelete;
            return this;
        }


        public Integer getAddtime() {
            return addtime;
        }

        public Add setAddtime(Integer addtime) {
            this.addtime = addtime;
            return this;
        }


        public String getImage() {
            return image;
        }

        public Add setImage(String image) {
            this.image = image;
            return this;
        }


        public BigDecimal getPrice() {
            return price;
        }

        public Add setPrice(BigDecimal price) {
            this.price = price;
            return this;
        }


        public String getDetail() {
            return detail;
        }

        public Add setDetail(String detail) {
            this.detail = detail;
            return this;
        }


        public String getBuyPrompt() {
            return buyPrompt;
        }

        public Add setBuyPrompt(String buyPrompt) {
            this.buyPrompt = buyPrompt;
            return this;
        }


        public String getSynopsis() {
            return synopsis;
        }

        public Add setSynopsis(String synopsis) {
            this.synopsis = synopsis;
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

        public Integer getLevel() {
            return level;
        }

        public Edit setLevel(Integer level) {
            this.level = level;
            return this;
        }

        public String getName() {
            return name;
        }

        public Edit setName(String name) {
            this.name = name;
            return this;
        }

        public BigDecimal getMoney() {
            return money;
        }

        public Edit setMoney(BigDecimal money) {
            this.money = money;
            return this;
        }

        public BigDecimal getDiscount() {
            return discount;
        }

        public Edit setDiscount(BigDecimal discount) {
            this.discount = discount;
            return this;
        }

        public Integer getStatus() {
            return status;
        }

        public Edit setStatus(Integer status) {
            this.status = status;
            return this;
        }

        public Integer getIsDelete() {
            return isDelete;
        }

        public Edit setIsDelete(Integer isDelete) {
            this.isDelete = isDelete;
            return this;
        }

        public Integer getAddtime() {
            return addtime;
        }

        public Edit setAddtime(Integer addtime) {
            this.addtime = addtime;
            return this;
        }

        public String getImage() {
            return image;
        }

        public Edit setImage(String image) {
            this.image = image;
            return this;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public Edit setPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public String getDetail() {
            return detail;
        }

        public Edit setDetail(String detail) {
            this.detail = detail;
            return this;
        }

        public String getBuyPrompt() {
            return buyPrompt;
        }

        public Edit setBuyPrompt(String buyPrompt) {
            this.buyPrompt = buyPrompt;
            return this;
        }

        public String getSynopsis() {
            return synopsis;
        }

        public Edit setSynopsis(String synopsis) {
            this.synopsis = synopsis;
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