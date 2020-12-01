package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 评论表(SchoolComment)Form
 *
 * @author dengchj
 * @since 2020-10-13 14:21:05
 */
public class SchoolCommentForm {

    public static class Edit extends CommonForm.Del {
        @NotNull(message = "状态不能为空")
        private Integer status;

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }
    }

    public static class Search extends CommonForm.Search {

        /**
         * 主键Id
         */
        private Integer id;
        /**
         * 素材Id
         */
        private Integer materialId;
        /**
         * 内容
         */
        private String content;
        /**
         * 用户Id
         */
        private Integer userId;
        /**
         * 用户名
         */
        private String userName;
        /**
         * 创建时间
         */
        private Date createTime;
        /**
         * 更新时间
         */
        private Date updateTime;
        /**
         * 状态
         */
        private Integer status;

        public Integer getId() {
            return id;
        }

        public Search setId(Integer id) {
            this.id = id;
            return this;
        }

        public Integer getMaterialId() {
            return materialId;
        }

        public Search setMaterialId(Integer materialId) {
            this.materialId = materialId;
            return this;
        }

        public String getContent() {
            return content;
        }

        public Search setContent(String content) {
            this.content = content;
            return this;
        }

        public Integer getUserId() {
            return userId;
        }

        public Search setUserId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public String getUserName() {
            return userName;
        }

        public Search setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public Search setCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public Date getUpdateTime() {
            return updateTime;
        }

        public Search setUpdateTime(Date updateTime) {
            this.updateTime = updateTime;
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

}