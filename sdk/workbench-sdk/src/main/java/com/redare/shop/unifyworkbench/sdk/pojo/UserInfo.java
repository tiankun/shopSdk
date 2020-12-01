package com.redare.shop.unifyworkbench.sdk.pojo;

import java.io.Serializable;
import java.util.List;

public class UserInfo implements Serializable {
    private static final long serialVersionUID = -8456285334112887832L;
    private String key;
    private Long id;
    private String userId;
    private String fullDeptName;
    private String userCode;
    private String userName;
    private String deptId;
    private String sex;
    private String password;
    private String email;
    private String mobilePhone;
    private String pinyin;
    private String jianpin;

    private boolean mobilePhoneFlag;
    private boolean emailFlag;

    private List<String> strList;

    public String getKey() {
        return key;
    }

    public UserInfo setKey(String key) {
        this.key = key;
        return this;
    }

    public Long getId() {
        return id;
    }

    public UserInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public UserInfo setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getFullDeptName() {
        return fullDeptName;
    }

    public UserInfo setFullDeptName(String fullDeptName) {
        this.fullDeptName = fullDeptName;
        return this;
    }

    public String getUserCode() {
        return userCode;
    }

    public UserInfo setUserCode(String userCode) {
        this.userCode = userCode;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public UserInfo setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getDeptId() {
        return deptId;
    }

    public UserInfo setDeptId(String deptId) {
        this.deptId = deptId;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public UserInfo setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserInfo setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserInfo setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public UserInfo setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public String getPinyin() {
        return pinyin;
    }

    public UserInfo setPinyin(String pinyin) {
        this.pinyin = pinyin;
        return this;
    }

    public String getJianpin() {
        return jianpin;
    }

    public UserInfo setJianpin(String jianpin) {
        this.jianpin = jianpin;
        return this;
    }

    public boolean isMobilePhoneFlag() {
        return mobilePhoneFlag;
    }

    public UserInfo setMobilePhoneFlag(boolean mobilePhoneFlag) {
        this.mobilePhoneFlag = mobilePhoneFlag;
        return this;
    }

    public boolean isEmailFlag() {
        return emailFlag;
    }

    public UserInfo setEmailFlag(boolean emailFlag) {
        this.emailFlag = emailFlag;
        return this;
    }

    public List<String> getStrList() {
        return strList;
    }

    public UserInfo setStrList(List<String> strList) {
        this.strList = strList;
        return this;
    }
}
