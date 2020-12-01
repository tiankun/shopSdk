package com.redare.shop.unifyworkbench.sdk.pojo;

import java.io.Serializable;

public class OaAccount implements Serializable {

    private Long id;
    private String userId;
    private String account;
    private String password;
    private String mobile;
    private String userName;
    private Integer status;

    public Long getId() {
        return id;
    }

    public OaAccount setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public OaAccount setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getAccount() {
        return account;
    }

    public OaAccount setAccount(String account) {
        this.account = account;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public OaAccount setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public OaAccount setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public OaAccount setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public OaAccount setStatus(Integer status) {
        this.status = status;
        return this;
    }
}
