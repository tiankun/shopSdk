package com.redare.shop.unifyworkbench.sdk.pojo;

import java.util.Date;

public class MessageShow {
    /**
     * 消息id
     */
    private String msgId;
    /**
     * 系统编码
     */
    private String sysCode;
    /**
     * 系统名称
     */
    private String sysName;
    /**
     * 消息类型
     */
    private String typeName;
    /**
     * 消息标题
     */
    private String title;
    /***
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建部门
     */
    private String createDepartmentName;
    /**
     * 创建人
     */
    private String createUserName;
    /**
     * PC端消息详情url
     */
    private String url;
    /**
     * 手机端消息详情url
     */
    private String mobileUrl;

    public String getMsgId() {
        return msgId;
    }

    public MessageShow setMsgId(String msgId) {
        this.msgId = msgId;
        return this;
    }

    public String getSysCode() {
        return sysCode;
    }

    public MessageShow setSysCode(String sysCode) {
        this.sysCode = sysCode;
        return this;
    }

    public String getSysName() {
        return sysName;
    }

    public MessageShow setSysName(String sysName) {
        this.sysName = sysName;
        return this;
    }

    public String getTypeName() {
        return typeName;
    }

    public MessageShow setTypeName(String typeName) {
        this.typeName = typeName;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public MessageShow setTitle(String title) {
        this.title = title;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public MessageShow setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getCreateDepartmentName() {
        return createDepartmentName;
    }

    public MessageShow setCreateDepartmentName(String createDepartmentName) {
        this.createDepartmentName = createDepartmentName;
        return this;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public MessageShow setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public MessageShow setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getMobileUrl() {
        return mobileUrl;
    }

    public MessageShow setMobileUrl(String mobileUrl) {
        this.mobileUrl = mobileUrl;
        return this;
    }
}
