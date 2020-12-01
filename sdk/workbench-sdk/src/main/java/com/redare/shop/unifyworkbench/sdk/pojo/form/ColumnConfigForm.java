package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class ColumnConfigForm {

    public static class Search{
        private String key;
        private String title;
        private String configPlate;

        public String getKey() {
            return key;
        }

        public Search setKey(String key) {
            this.key = key;
            return this;
        }

        public String getTitle() {
            return title;
        }

        public Search setTitle(String title) {
            this.title = title;
            return this;
        }

        public String getConfigPlate() {
            return configPlate;
        }

        public Search setConfigPlate(String configPlate) {
            this.configPlate = configPlate;
            return this;
        }
    }

    public static class Get{
        @NotNull(message = "主键id不能为空")
        private Long id;

        public Long getId() {
            return id;
        }

        public Get setId(Long id) {
            this.id = id;
            return this;
        }
    }

    public static class Add{
        private String title;
        private String configPlate;
        private String url;
        private String cover;
        private Date createTime;
        private Integer sort;

        public String getTitle() {
            return title;
        }

        public Add setTitle(String title) {
            this.title = title;
            return this;
        }

        public String getConfigPlate() {
            return configPlate;
        }

        public Add setConfigPlate(String configPlate) {
            this.configPlate = configPlate;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Add setUrl(String url) {
            this.url = url;
            return this;
        }

        public String getCover() {
            return cover;
        }

        public Add setCover(String cover) {
            this.cover = cover;
            return this;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public Add setCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public Integer getSort() {
            return sort;
        }

        public Add setSort(Integer sort) {
            this.sort = sort;
            return this;
        }
    }

    public static class Edit{
        @NotNull(message = "主键id不能为空")
        private Long id;
        private String title;
        private String configPlate;
        private String url;
        private String cover;
        private Date createTime;
        private Integer sort;

        public Long getId() {
            return id;
        }

        public Edit setId(Long id) {
            this.id = id;
            return this;
        }

        public String getTitle() {
            return title;
        }

        public Edit setTitle(String title) {
            this.title = title;
            return this;
        }

        public String getConfigPlate() {
            return configPlate;
        }

        public Edit setConfigPlate(String configPlate) {
            this.configPlate = configPlate;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Edit setUrl(String url) {
            this.url = url;
            return this;
        }

        public String getCover() {
            return cover;
        }

        public Edit setCover(String cover) {
            this.cover = cover;
            return this;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public Edit setCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public Integer getSort() {
            return sort;
        }

        public Edit setSort(Integer sort) {
            this.sort = sort;
            return this;
        }
    }

    public static class Del{
        @NotNull(message = "主键id不能为空")
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
