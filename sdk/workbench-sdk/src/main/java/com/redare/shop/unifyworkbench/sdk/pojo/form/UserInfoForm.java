package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotNull;
import java.util.List;

public class UserInfoForm {

    public static class Search{
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
        private List<String> deptIds;

        public String getUserId() {
            return userId;
        }

        public Search setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public String getFullDeptName() {
            return fullDeptName;
        }

        public Search setFullDeptName(String fullDeptName) {
            this.fullDeptName = fullDeptName;
            return this;
        }

        public String getUserCode() {
            return userCode;
        }

        public Search setUserCode(String userCode) {
            this.userCode = userCode;
            return this;
        }

        public String getUserName() {
            return userName;
        }

        public Search setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public String getDeptId() {
            return deptId;
        }

        public Search setDeptId(String deptId) {
            this.deptId = deptId;
            return this;
        }

        public String getSex() {
            return sex;
        }

        public Search setSex(String sex) {
            this.sex = sex;
            return this;
        }

        public String getPassword() {
            return password;
        }

        public Search setPassword(String password) {
            this.password = password;
            return this;
        }

        public String getEmail() {
            return email;
        }

        public Search setEmail(String email) {
            this.email = email;
            return this;
        }

        public String getMobilePhone() {
            return mobilePhone;
        }

        public Search setMobilePhone(String mobilePhone) {
            this.mobilePhone = mobilePhone;
            return this;
        }

        public String getPinyin() {
            return pinyin;
        }

        public Search setPinyin(String pinyin) {
            this.pinyin = pinyin;
            return this;
        }

        public String getJianpin() {
            return jianpin;
        }

        public Search setJianpin(String jianpin) {
            this.jianpin = jianpin;
            return this;
        }

        public List<String> getDeptIds() {
            return deptIds;
        }

        public Search setDeptIds(List<String> deptIds) {
            this.deptIds = deptIds;
            return this;
        }
    }

    public static class Add{
        @NotNull(message = "userId不能为空")
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

        public String getUserId() {
            return userId;
        }

        public Add setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public String getFullDeptName() {
            return fullDeptName;
        }

        public Add setFullDeptName(String fullDeptName) {
            this.fullDeptName = fullDeptName;
            return this;
        }

        public String getUserCode() {
            return userCode;
        }

        public Add setUserCode(String userCode) {
            this.userCode = userCode;
            return this;
        }

        public String getUserName() {
            return userName;
        }

        public Add setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public String getDeptId() {
            return deptId;
        }

        public Add setDeptId(String deptId) {
            this.deptId = deptId;
            return this;
        }

        public String getSex() {
            return sex;
        }

        public Add setSex(String sex) {
            this.sex = sex;
            return this;
        }

        public String getPassword() {
            return password;
        }

        public Add setPassword(String password) {
            this.password = password;
            return this;
        }

        public String getEmail() {
            return email;
        }

        public Add setEmail(String email) {
            this.email = email;
            return this;
        }

        public String getMobilePhone() {
            return mobilePhone;
        }

        public Add setMobilePhone(String mobilePhone) {
            this.mobilePhone = mobilePhone;
            return this;
        }

        public String getPinyin() {
            return pinyin;
        }

        public Add setPinyin(String pinyin) {
            this.pinyin = pinyin;
            return this;
        }

        public String getJianpin() {
            return jianpin;
        }

        public Add setJianpin(String jianpin) {
            this.jianpin = jianpin;
            return this;
        }
    }

    public static class Edit{
        @NotNull(message = "主键id不能为空")
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

        public Long getId() {
            return id;
        }

        public Edit setId(Long id) {
            this.id = id;
            return this;
        }

        public String getUserId() {
            return userId;
        }

        public Edit setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public String getFullDeptName() {
            return fullDeptName;
        }

        public Edit setFullDeptName(String fullDeptName) {
            this.fullDeptName = fullDeptName;
            return this;
        }

        public String getUserCode() {
            return userCode;
        }

        public Edit setUserCode(String userCode) {
            this.userCode = userCode;
            return this;
        }

        public String getUserName() {
            return userName;
        }

        public Edit setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public String getDeptId() {
            return deptId;
        }

        public Edit setDeptId(String deptId) {
            this.deptId = deptId;
            return this;
        }

        public String getSex() {
            return sex;
        }

        public Edit setSex(String sex) {
            this.sex = sex;
            return this;
        }

        public String getPassword() {
            return password;
        }

        public Edit setPassword(String password) {
            this.password = password;
            return this;
        }

        public String getEmail() {
            return email;
        }

        public Edit setEmail(String email) {
            this.email = email;
            return this;
        }

        public String getMobilePhone() {
            return mobilePhone;
        }

        public Edit setMobilePhone(String mobilePhone) {
            this.mobilePhone = mobilePhone;
            return this;
        }

        public String getPinyin() {
            return pinyin;
        }

        public Edit setPinyin(String pinyin) {
            this.pinyin = pinyin;
            return this;
        }

        public String getJianpin() {
            return jianpin;
        }

        public Edit setJianpin(String jianpin) {
            this.jianpin = jianpin;
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

    public static class Get{
        @NotNull(message = "userId不能为空")
        private String userId;

        public String getUserId() {
            return userId;
        }

        public Get setUserId(String userId) {
            this.userId = userId;
            return this;
        }
    }
}
