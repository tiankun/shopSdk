package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotNull;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/7/17 11:13
 * @version: 1.1
 */
public class IosCodedowloadForm {

    public static class Search{
        private String key;
        private Integer status;

        public String getKey() {
            return key;
        }

        public Search setKey(String key) {
            this.key = key;
            return this;
        }

        public Integer getStatus() {
            return status;
        }

        public Search setStatus(Integer status) {
            this.status = status;
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

    public static class Edit{
        @NotNull(message = "主键id不能为空")
        private Long id;
        private Integer status;

        public Long getId() {
            return id;
        }

        public Edit setId(Long id) {
            this.id = id;
            return this;
        }

        public Integer getStatus() {
            return status;
        }

        public Edit setStatus(Integer status) {
            this.status = status;
            return this;
        }
    }
}
