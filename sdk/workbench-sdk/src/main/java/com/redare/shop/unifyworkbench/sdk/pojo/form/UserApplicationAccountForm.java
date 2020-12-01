package com.redare.shop.unifyworkbench.sdk.pojo.form;

import java.util.Date;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/8/20 14:16
 * @version: 1.1
 */
public class UserApplicationAccountForm {

    public static class Add{
        private Long userId;
        private Long applicationId;
        private String applicationUserId;
        private String applicationUserPwd;
        private String accountId;
        private Date createTime;

        public Long getUserId() {
            return userId;
        }

        public Add setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Long getApplicationId() {
            return applicationId;
        }

        public Add setApplicationId(Long applicationId) {
            this.applicationId = applicationId;
            return this;
        }

        public String getApplicationUserId() {
            return applicationUserId;
        }

        public Add setApplicationUserId(String applicationUserId) {
            this.applicationUserId = applicationUserId;
            return this;
        }

        public String getApplicationUserPwd() {
            return applicationUserPwd;
        }

        public Add setApplicationUserPwd(String applicationUserPwd) {
            this.applicationUserPwd = applicationUserPwd;
            return this;
        }

        public String getAccountId() {
            return accountId;
        }

        public Add setAccountId(String accountId) {
            this.accountId = accountId;
            return this;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public Add setCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }
    }

    public static class Get{
        private Long id;
        private Long userId;
        private Long applicationId;

        public Long getId() {
            return id;
        }

        public Get setId(Long id) {
            this.id = id;
            return this;
        }

        public Long getUserId() {
            return userId;
        }

        public Get setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Long getApplicationId() {
            return applicationId;
        }

        public Get setApplicationId(Long applicationId) {
            this.applicationId = applicationId;
            return this;
        }
    }

    public static class Edit{
        private Long id;
        private Long userId;
        private Long applicationId;
        private String applicationUserId;
        private String applicationUserPwd;
        private String accountId;
        private Date createTime;

        public Long getId() {
            return id;
        }

        public Edit setId(Long id) {
            this.id = id;
            return this;
        }

        public Long getUserId() {
            return userId;
        }

        public Edit setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Long getApplicationId() {
            return applicationId;
        }

        public Edit setApplicationId(Long applicationId) {
            this.applicationId = applicationId;
            return this;
        }

        public String getApplicationUserId() {
            return applicationUserId;
        }

        public Edit setApplicationUserId(String applicationUserId) {
            this.applicationUserId = applicationUserId;
            return this;
        }

        public String getApplicationUserPwd() {
            return applicationUserPwd;
        }

        public Edit setApplicationUserPwd(String applicationUserPwd) {
            this.applicationUserPwd = applicationUserPwd;
            return this;
        }

        public String getAccountId() {
            return accountId;
        }

        public Edit setAccountId(String accountId) {
            this.accountId = accountId;
            return this;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public Edit setCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }
    }
}
