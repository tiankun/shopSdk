package com.redare.shop.unifyworkbench.sdk.pojo;

import java.util.Date;

/**
 * 待阅消息接收人
 */
public class MessageReceiveuser {

    private Long id;

    private String msgId;

    private String userId;

    private String account;

    private String name;

    private Long ztktUserId;

    private String departmentId;

    private String departmentName;

    private Integer readed;

    private Date readTime;

    public Long getId() {
        return id;
    }

    public MessageReceiveuser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getMsgId() {
        return msgId;
    }

    public MessageReceiveuser setMsgId(String msgId) {
        this.msgId = msgId;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public MessageReceiveuser setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getAccount() {
        return account;
    }

    public MessageReceiveuser setAccount(String account) {
        this.account = account;
        return this;
    }

    public String getName() {
        return name;
    }

    public MessageReceiveuser setName(String name) {
        this.name = name;
        return this;
    }

    public Long getZtktUserId() {
        return ztktUserId;
    }

    public MessageReceiveuser setZtktUserId(Long ztktUserId) {
        this.ztktUserId = ztktUserId;
        return this;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public MessageReceiveuser setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
        return this;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public MessageReceiveuser setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
        return this;
    }

    public Integer getReaded() {
        return readed;
    }

    public MessageReceiveuser setReaded(Integer readed) {
        this.readed = readed;
        return this;
    }

    public Date getReadTime() {
        return readTime;
    }

    public MessageReceiveuser setReadTime(Date readTime) {
        this.readTime = readTime;
        return this;
    }
}
