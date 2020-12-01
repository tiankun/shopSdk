package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 学堂管理-数字阵地(SchoolNumberposition)Form
 *
 * @author dengchj
 * @since 2020-10-13 14:24:24
 */
public class SchoolNumberpositionForm {

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
         * 名称
         */
        private String title;
        /**
         * 组织Id
         */
        private String orgId;
        /**
         * 组织名称
         */
        private String orgName;
        /**
         * 简介
         */
        private String content;
        /**
         * 链接
         */
        private String links;
        /**
         * 上传人员Id
         */
        private Integer userId;
        /**
         * 上传人员名称
         */
        private String userName;
        /**
         * 状态
         */
        private Integer status;
        /**
         * 创建时间
         */
        private Date createTime;
        /**
         * 更新时间
         */
        private Date updateTime;

        public Integer getId() {
            return id;
        }

        public Search setId(Integer id) {
            this.id = id;
            return this;
        }

        public String getTitle() {
            return title;
        }

        public Search setTitle(String title) {
            this.title = title;
            return this;
        }

        public String getOrgId() {
            return orgId;
        }

        public Search setOrgId(String orgId) {
            this.orgId = orgId;
            return this;
        }

        public String getOrgName() {
            return orgName;
        }

        public Search setOrgName(String orgName) {
            this.orgName = orgName;
            return this;
        }

        public String getContent() {
            return content;
        }

        public Search setContent(String content) {
            this.content = content;
            return this;
        }

        public String getLinks() {
            return links;
        }

        public Search setLinks(String links) {
            this.links = links;
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

        public Integer getStatus() {
            return status;
        }

        public Search setStatus(Integer status) {
            this.status = status;
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

    }
    public  static  class  changeStatus{
        private Integer status;
        private Long id;

        public Integer getStatus() {
            return status;
        }

        public changeStatus setStatus(Integer status) {
            this.status = status;
            return this;
        }

        public Long getId() {
            return id;
        }

        public changeStatus setId(Long id) {
            this.id = id;
            return this;
        }
    }

    public  static class Get{
        private  Long id;

        public Long getId() {
            return id;
        }

        public Get setId(Long id) {
            this.id = id;
            return this;
        }
    }

}