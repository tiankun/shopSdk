package com.redare.shop.unifyworkbench.service.pojo.arg;

public class UserArg {

    public UserArg() {
    }

    public static class AddForm {
        private Long userId;
        private String name;
        private String mobile;
        private String email;
        private String photo;
        private Long orgId;
        private String orgName;
        private Integer gender;//性别：0-未知，1-男，2-女
        private String address;//联系地址

        private Integer orgParentId;//机构父Id
        private String orgParentName;//机构父级名称
        private String namePinyinInitials;//姓名全拼首字母
        private String namePinyinShort;//姓名首字母简称
        private String staffName;//员工花名册员工姓名
        private Long staffId;//员工花名册员工id

        public AddForm() {
        }

        public Long getUserId() {
            return userId;
        }

        public AddForm setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public String getName() {
            return name;
        }

        public AddForm setName(String name) {
            this.name = name;
            return this;
        }

        public String getMobile() {
            return mobile;
        }

        public AddForm setMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public String getEmail() {
            return email;
        }

        public AddForm setEmail(String email) {
            this.email = email;
            return this;
        }

        public String getPhoto() {
            return photo;
        }

        public AddForm setPhoto(String photo) {
            this.photo = photo;
            return this;
        }

        public Long getOrgId() {
            return orgId;
        }

        public AddForm setOrgId(Long orgId) {
            this.orgId = orgId;
            return this;
        }

        public String getOrgName() {
            return orgName;
        }

        public AddForm setOrgName(String orgName) {
            this.orgName = orgName;
            return this;
        }

        public Integer getGender() {
            return gender;
        }

        public AddForm setGender(Integer gender) {
            this.gender = gender;
            return this;
        }

        public String getAddress() {
            return address;
        }

        public AddForm setAddress(String address) {
            this.address = address;
            return this;
        }

        public Integer getOrgParentId() {
            return orgParentId;
        }

        public AddForm setOrgParentId(Integer orgParentId) {
            this.orgParentId = orgParentId;
            return this;
        }

        public String getOrgParentName() {
            return orgParentName;
        }

        public AddForm setOrgParentName(String orgParentName) {
            this.orgParentName = orgParentName;
            return this;
        }

        public String getNamePinyinInitials() {
            return namePinyinInitials;
        }

        public AddForm setNamePinyinInitials(String namePinyinInitials) {
            this.namePinyinInitials = namePinyinInitials;
            return this;
        }

        public String getNamePinyinShort() {
            return namePinyinShort;
        }

        public AddForm setNamePinyinShort(String namePinyinShort) {
            this.namePinyinShort = namePinyinShort;
            return this;
        }

        public String getStaffName() {
            return staffName;
        }

        public AddForm setStaffName(String staffName) {
            this.staffName = staffName;
            return this;
        }

        public Long getStaffId() {
            return staffId;
        }

        public AddForm setStaffId(Long staffId) {
            this.staffId = staffId;
            return this;
        }
    }

    public static class Add {
        private com.redare.devframework.webplatform.sdk.core.arg.AccountArg.Add account;
        private String name;
        private String mobile;
        private String email;
        private String photo;
        private Long orgId;
        private String orgName;
        private Integer gender;//性别：0-未知，1-男，2-女
        private String address;//联系地址

        public Add() {
        }

        public com.redare.devframework.webplatform.sdk.core.arg.AccountArg.Add getAccount() {
            return this.account;
        }

        public UserArg.Add setAccount(com.redare.devframework.webplatform.sdk.core.arg.AccountArg.Add account) {
            this.account = account;
            return this;
        }

        public String getName() {
            return name;
        }

        public Add setName(String name) {
            this.name = name;
            return this;
        }

        public String getMobile() {
            return mobile;
        }

        public Add setMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public String getEmail() {
            return email;
        }

        public Add setEmail(String email) {
            this.email = email;
            return this;
        }

        public String getPhoto() {
            return photo;
        }

        public Add setPhoto(String photo) {
            this.photo = photo;
            return this;
        }

        public Long getOrgId() {
            return orgId;
        }

        public Add setOrgId(Long orgId) {
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

        public Integer getGender() {
            return gender;
        }

        public Add setGender(Integer gender) {
            this.gender = gender;
            return this;
        }

        public String getAddress() {
            return address;
        }

        public Add setAddress(String address) {
            this.address = address;
            return this;
        }
    }
}
