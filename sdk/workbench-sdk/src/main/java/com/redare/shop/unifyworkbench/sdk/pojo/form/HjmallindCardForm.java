package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotNull;

;

/**
 * @date 2020-12-01 13:43:00
 * Created by tiankun
 */
public class HjmallindCardForm {

    public static class Add {
        /**
         *
         */
        private Integer storeId;

        /**
         * 卡券名称
         */
        private String name;

        /**
         * 卡券图片
         */
        private String picUrl;

        /**
         * 卡券描述
         */
        private String content;

        /**
         *
         */
        private Integer isDelete;

        /**
         *
         */
        private Integer addtime;


        public Integer getStoreId() {
            return storeId;
        }

        public Add setStoreId(Integer storeId) {
            this.storeId = storeId;
            return this;
        }


        public String getName() {
            return name;
        }

        public Add setName(String name) {
            this.name = name;
            return this;
        }


        public String getPicUrl() {
            return picUrl;
        }

        public Add setPicUrl(String picUrl) {
            this.picUrl = picUrl;
            return this;
        }


        public String getContent() {
            return content;
        }

        public Add setContent(String content) {
            this.content = content;
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


    }

    public static class Edit {

        @NotNull(message = "请传入id")
        private Long id;

        /**
         *
         */
        private Integer storeId;
        /**
         * 卡券名称
         */
        private String name;
        /**
         * 卡券图片
         */
        private String picUrl;
        /**
         * 卡券描述
         */
        private String content;
        /**
         *
         */
        private Integer isDelete;
        /**
         *
         */
        private Integer addtime;

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

        public String getName() {
            return name;
        }

        public Edit setName(String name) {
            this.name = name;
            return this;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public Edit setPicUrl(String picUrl) {
            this.picUrl = picUrl;
            return this;
        }

        public String getContent() {
            return content;
        }

        public Edit setContent(String content) {
            this.content = content;
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