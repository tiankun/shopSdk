package com.redare.shop.unifyworkbench.sdk.pojo;

import java.util.Date;

/**
 * 待阅消息
 */
public class Message {
    private Long id;
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

    public Long getId() {
        return id;
    }

    public Message setId(Long id) {
        this.id = id;
        return this;
    }

    public String getMsgId() {
        return msgId;
    }

    public Message setMsgId(String msgId) {
        this.msgId = msgId;
        return this;
    }

    public String getSysCode() {
        return sysCode;
    }

    public Message setSysCode(String sysCode) {
        this.sysCode = sysCode;
        return this;
    }

    public String getTypeName() {
        return typeName;
    }

    public Message setTypeName(String typeName) {
        this.typeName = typeName;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Message setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDes() {
        return des;
    }

    public Message setDes(String des) {
        this.des = des;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Message setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getCreateDepartmentId() {
        return createDepartmentId;
    }

    public Message setCreateDepartmentId(String createDepartmentId) {
        this.createDepartmentId = createDepartmentId;
        return this;
    }

    public String getCreateDepartmentName() {
        return createDepartmentName;
    }

    public Message setCreateDepartmentName(String createDepartmentName) {
        this.createDepartmentName = createDepartmentName;
        return this;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public Message setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
        return this;
    }

    public String getCreateUserAccount() {
        return createUserAccount;
    }

    public Message setCreateUserAccount(String createUserAccount) {
        this.createUserAccount = createUserAccount;
        return this;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public Message setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
        return this;
    }

    public Long getZtktUserId() {
        return ztktUserId;
    }

    public Message setZtktUserId(Long ztktUserId) {
        this.ztktUserId = ztktUserId;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Message setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getMobileUrl() {
        return mobileUrl;
    }

    public Message setMobileUrl(String mobileUrl) {
        this.mobileUrl = mobileUrl;
        return this;
    }
}
