package com.redare.shop.unifyworkbench.sdk.pojo.form;

import java.util.Date;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/10/29 16:25
 * @version:
 */
public class OrganizationExchangeForm {

    public static class Search{
        private String key;
        private String orgId;
        private Long userId;

        public String getKey() {
            return key;
        }

        public Search setKey(String key) {
            this.key = key;
            return this;
        }

        public String getOrgId() {
            return orgId;
        }

        public Search setOrgId(String orgId) {
            this.orgId = orgId;
            return this;
        }

        public Long getUserId() {
            return userId;
        }

        public Search setUserId(Long userId) {
            this.userId = userId;
            return this;
        }
    }

    public static class Add{
        private String orgId;
        private String orgName;
        private Long userId;
        private String userName;
        private String exchangeInfo;
        private String attachment;
        private Date createTime;
        private Date updateTime;
        private Integer status;

        public String getOrgId() {
            return orgId;
        }

        public Add setOrgId(String orgId) {
            this.orgId = orgId;
            return this;
        }

        public String getOrgName() {
            return orgName;
        }

        public Add setOrgName(String orgName) {
            this.orgName = orgName;
            return this;
        }

        public Long getUserId() {
            return userId;
        }

        public Add setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public String getUserName() {
            return userName;
        }

        public Add setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public String getExchangeInfo() {
            return exchangeInfo;
        }

        public Add setExchangeInfo(String exchangeInfo) {
            this.exchangeInfo = exchangeInfo;
            return this;
        }

        public String getAttachment() {
            return attachment;
        }

        public Add setAttachment(String attachment) {
            this.attachment = attachment;
            return this;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public Add setCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public Date getUpdateTime() {
            return updateTime;
        }

        public Add setUpdateTime(Date updateTime) {
            this.updateTime = updateTime;
            return this;
        }

        public Integer getStatus() {
            return status;
        }

        public Add setStatus(Integer status) {
            this.status = status;
            return this;
        }
    }
}
