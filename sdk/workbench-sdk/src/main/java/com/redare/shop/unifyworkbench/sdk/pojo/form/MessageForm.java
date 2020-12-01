package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;

public class MessageForm {

    public static class Search{
        private String msgId;
        private String sysCode;
        private String typeName;
        private String title;
        private String des;
        private Date createTime;
        private String createDepartmentId;
        private String createDepartmentName;
        private String createUserId;
        private String createUserAccount;
        private String createUserName;
        private Long ztktUserId;
        private String url;
        private String mobileUrl;

        private String key;

        public String getMsgId() {
            return msgId;
        }

        public Search setMsgId(String msgId) {
            this.msgId = msgId;
            return this;
        }

        public String getSysCode() {
            return sysCode;
        }

        public Search setSysCode(String sysCode) {
            this.sysCode = sysCode;
            return this;
        }

        public String getTypeName() {
            return typeName;
        }

        public Search setTypeName(String typeName) {
            this.typeName = typeName;
            return this;
        }

        public String getTitle() {
            return title;
        }

        public Search setTitle(String title) {
            this.title = title;
            return this;
        }

        public String getDes() {
            return des;
        }

        public Search setDes(String des) {
            this.des = des;
            return this;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public Search setCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public String getCreateDepartmentId() {
            return createDepartmentId;
        }

        public Search setCreateDepartmentId(String createDepartmentId) {
            this.createDepartmentId = createDepartmentId;
            return this;
        }

        public String getCreateDepartmentName() {
            return createDepartmentName;
        }

        public Search setCreateDepartmentName(String createDepartmentName) {
            this.createDepartmentName = createDepartmentName;
            return this;
        }

        public String getCreateUserId() {
            return createUserId;
        }

        public Search setCreateUserId(String createUserId) {
            this.createUserId = createUserId;
            return this;
        }

        public String getCreateUserAccount() {
            return createUserAccount;
        }

        public Search setCreateUserAccount(String createUserAccount) {
            this.createUserAccount = createUserAccount;
            return this;
        }

        public String getCreateUserName() {
            return createUserName;
        }

        public Search setCreateUserName(String createUserName) {
            this.createUserName = createUserName;
            return this;
        }

        public Long getZtktUserId() {
            return ztktUserId;
        }

        public Search setZtktUserId(Long ztktUserId) {
            this.ztktUserId = ztktUserId;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Search setUrl(String url) {
            this.url = url;
            return this;
        }

        public String getMobileUrl() {
            return mobileUrl;
        }

        public Search setMobileUrl(String mobileUrl) {
            this.mobileUrl = mobileUrl;
            return this;
        }

        public String getKey() {
            return key;
        }

        public Search setKey(String key) {
            this.key = key;
            return this;
        }
    }

    public static class Add{
        @NotNull(message = "待阅消息id不能为空")
        private String msgId;
        @NotNull(message = "系统编码，双方约定编码不能为空")
        private String sysCode;
        private String typeName;
        private String title;
        private String des;
        private Date createTime;
        private String createDepartmentId;
        private String createDepartmentName;
        private String createUserId;
        private String createUserAccount;
        private String createUserName;
        private Long ztktUserId;
        private String url;
        private String mobileUrl;

        public String getMsgId() {
            return msgId;
        }

        public Add setMsgId(String msgId) {
            this.msgId = msgId;
            return this;
        }

        public String getSysCode() {
            return sysCode;
        }

        public Add setSysCode(String sysCode) {
            this.sysCode = sysCode;
            return this;
        }

        public String getTypeName() {
            return typeName;
        }

        public Add setTypeName(String typeName) {
            this.typeName = typeName;
            return this;
        }

        public String getTitle() {
            return title;
        }

        public Add setTitle(String title) {
            this.title = title;
            return this;
        }

        public String getDes() {
            return des;
        }

        public Add setDes(String des) {
            this.des = des;
            return this;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public Add setCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public String getCreateDepartmentId() {
            return createDepartmentId;
        }

        public Add setCreateDepartmentId(String createDepartmentId) {
            this.createDepartmentId = createDepartmentId;
            return this;
        }

        public String getCreateDepartmentName() {
            return createDepartmentName;
        }

        public Add setCreateDepartmentName(String createDepartmentName) {
            this.createDepartmentName = createDepartmentName;
            return this;
        }

        public String getCreateUserId() {
            return createUserId;
        }

        public Add setCreateUserId(String createUserId) {
            this.createUserId = createUserId;
            return this;
        }

        public String getCreateUserAccount() {
            return createUserAccount;
        }

        public Add setCreateUserAccount(String createUserAccount) {
            this.createUserAccount = createUserAccount;
            return this;
        }

        public String getCreateUserName() {
            return createUserName;
        }

        public Add setCreateUserName(String createUserName) {
            this.createUserName = createUserName;
            return this;
        }

        public Long getZtktUserId() {
            return ztktUserId;
        }

        public Add setZtktUserId(Long ztktUserId) {
            this.ztktUserId = ztktUserId;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Add setUrl(String url) {
            this.url = url;
            return this;
        }

        public String getMobileUrl() {
            return mobileUrl;
        }

        public Add setMobileUrl(String mobileUrl) {
            this.mobileUrl = mobileUrl;
            return this;
        }
    }

    public static class Edit{
        @NotNull(message = "主键id不能为空")
        private Long id;
        @NotNull(message = "待阅消息id不能为空")
        private String msgId;
        @NotNull(message = "系统编码，双方约定编码不能为空")
        private String sysCode;
        private String typeName;
        private String title;
        private String des;
        private Date createTime;
        private String createDepartmentId;
        private String createDepartmentName;
        private String createUserId;
        private String createUserAccount;
        private String createUserName;
        private Long ztktUserId;
        private String url;
        private String mobileUrl;

        public Long getId() {
            return id;
        }

        public Edit setId(Long id) {
            this.id = id;
            return this;
        }

        public String getMsgId() {
            return msgId;
        }

        public Edit setMsgId(String msgId) {
            this.msgId = msgId;
            return this;
        }

        public String getSysCode() {
            return sysCode;
        }

        public Edit setSysCode(String sysCode) {
            this.sysCode = sysCode;
            return this;
        }

        public String getTypeName() {
            return typeName;
        }

        public Edit setTypeName(String typeName) {
            this.typeName = typeName;
            return this;
        }

        public String getTitle() {
            return title;
        }

        public Edit setTitle(String title) {
            this.title = title;
            return this;
        }

        public String getDes() {
            return des;
        }

        public Edit setDes(String des) {
            this.des = des;
            return this;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public Edit setCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public String getCreateDepartmentId() {
            return createDepartmentId;
        }

        public Edit setCreateDepartmentId(String createDepartmentId) {
            this.createDepartmentId = createDepartmentId;
            return this;
        }

        public String getCreateDepartmentName() {
            return createDepartmentName;
        }

        public Edit setCreateDepartmentName(String createDepartmentName) {
            this.createDepartmentName = createDepartmentName;
            return this;
        }

        public String getCreateUserId() {
            return createUserId;
        }

        public Edit setCreateUserId(String createUserId) {
            this.createUserId = createUserId;
            return this;
        }

        public String getCreateUserAccount() {
            return createUserAccount;
        }

        public Edit setCreateUserAccount(String createUserAccount) {
            this.createUserAccount = createUserAccount;
            return this;
        }

        public String getCreateUserName() {
            return createUserName;
        }

        public Edit setCreateUserName(String createUserName) {
            this.createUserName = createUserName;
            return this;
        }

        public Long getZtktUserId() {
            return ztktUserId;
        }

        public Edit setZtktUserId(Long ztktUserId) {
            this.ztktUserId = ztktUserId;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Edit setUrl(String url) {
            this.url = url;
            return this;
        }

        public String getMobileUrl() {
            return mobileUrl;
        }

        public Edit setMobileUrl(String mobileUrl) {
            this.mobileUrl = mobileUrl;
            return this;
        }
    }

    public static class Get{
        private Long id;

        private String msgId;

        private String sysCode;

        public Long getId() {
            return id;
        }

        public Get setId(Long id) {
            this.id = id;
            return this;
        }

        public String getMsgId() {
            return msgId;
        }

        public Get setMsgId(String msgId) {
            this.msgId = msgId;
            return this;
        }

        public String getSysCode() {
            return sysCode;
        }

        public Get setSysCode(String sysCode) {
            this.sysCode = sysCode;
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
