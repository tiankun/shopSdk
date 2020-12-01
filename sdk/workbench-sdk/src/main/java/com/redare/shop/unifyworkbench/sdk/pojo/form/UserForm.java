package com.redare.shop.unifyworkbench.sdk.pojo.form;

import com.redare.devframework.webplatform.sdk.core.arg.AccountArg;
import com.redare.devframework.webplatform.sdk.core.arg.UserArg;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/6/30 11:10
 * @version: 1.1
 */
public class UserForm {

    public static class GetStaffId{

        private Long StaffId;

        public Long getStaffId() {
            return StaffId;
        }

        public GetStaffId setStaffId(Long staffId) {
            StaffId = staffId;
            return this;
        }
    }

    public static class Get extends AccountArg.Get{
        //@NotBlank(message = "手机号码不能为空")
        private String mobile;

        public String getMobile() {
            return mobile;
        }

        public Get setMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }
        private Long orgId;

        public Long getOrgId() {
            return orgId;
        }

        public Get setOrgId(Long orgId) {
            this.orgId = orgId;
            return this;
        }
    }

    public static class Search extends UserArg.Search{
        private String key;
        private Long roleId;
        private Long orgId;
        private String orgName;//机构名称
        private List<Long> userIds; //根据用户id查询

        private Integer orgParentId;//机构父Id
        private String orgParentName;//机构父级名称
        private String namePinyinInitials;//姓名全拼首字母
        private String namePinyinShort;//姓名首字母简称
        private String staffName;//员工花名册员工姓名
        private Long staffId;//员工花名册员工id

        private boolean mobileFlag;
        private boolean emailFlag;

        public String getKey() {
            return key;
        }

        public Search setKey(String key) {
            this.key = key;
            return this;
        }

        public Long getRoleId() {
            return roleId;
        }

        public Search setRoleId(Long roleId) {
            this.roleId = roleId;
            return this;
        }

        public Long getOrgId() {
            return orgId;
        }

        public Search setOrgId(Long orgId) {
            this.orgId = orgId;
            return this;
        }

        public String getOrgName() {
            return orgName;
        }

        public Search setOrgName(String orgName) {
            this.orgName = orgName;
            return this;
        }

        public List<Long> getUserIds() {
            return userIds;
        }

        public Search setUserIds(List<Long> userIds) {
            this.userIds = userIds;
            return this;
        }

        public Integer getOrgParentId() {
            return orgParentId;
        }

        public Search setOrgParentId(Integer orgParentId) {
            this.orgParentId = orgParentId;
            return this;
        }

        public String getOrgParentName() {
            return orgParentName;
        }

        public Search setOrgParentName(String orgParentName) {
            this.orgParentName = orgParentName;
            return this;
        }

        public String getNamePinyinInitials() {
            return namePinyinInitials;
        }

        public Search setNamePinyinInitials(String namePinyinInitials) {
            this.namePinyinInitials = namePinyinInitials;
            return this;
        }

        public String getNamePinyinShort() {
            return namePinyinShort;
        }

        public Search setNamePinyinShort(String namePinyinShort) {
            this.namePinyinShort = namePinyinShort;
            return this;
        }

        public String getStaffName() {
            return staffName;
        }

        public Search setStaffName(String staffName) {
            this.staffName = staffName;
            return this;
        }

        public Long getStaffId() {
            return staffId;
        }

        public Search setStaffId(Long staffId) {
            this.staffId = staffId;
            return this;
        }

        public boolean isMobileFlag() {
            return mobileFlag;
        }

        public Search setMobileFlag(boolean mobileFlag) {
            this.mobileFlag = mobileFlag;
            return this;
        }

        public boolean isEmailFlag() {
            return emailFlag;
        }

        public Search setEmailFlag(boolean emailFlag) {
            this.emailFlag = emailFlag;
            return this;
        }
    }

    public static class Add extends UserArg.Add {
        @NotBlank(message = "密码不能为空")
        private String pwd1;//密码
        @NotNull(message = "单位/部门id不能为空")
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


        public String getPwd1() {
            return pwd1;
        }

        public Add setPwd1(String pwd1) {
            this.pwd1 = pwd1;
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

        public Integer getOrgParentId() {
            return orgParentId;
        }

        public Add setOrgParentId(Integer orgParentId) {
            this.orgParentId = orgParentId;
            return this;
        }

        public String getOrgParentName() {
            return orgParentName;
        }

        public Add setOrgParentName(String orgParentName) {
            this.orgParentName = orgParentName;
            return this;
        }

        public String getNamePinyinInitials() {
            return namePinyinInitials;
        }

        public Add setNamePinyinInitials(String namePinyinInitials) {
            this.namePinyinInitials = namePinyinInitials;
            return this;
        }

        public String getNamePinyinShort() {
            return namePinyinShort;
        }

        public Add setNamePinyinShort(String namePinyinShort) {
            this.namePinyinShort = namePinyinShort;
            return this;
        }

        public String getStaffName() {
            return staffName;
        }

        public Add setStaffName(String staffName) {
            this.staffName = staffName;
            return this;
        }

        public Long getStaffId() {
            return staffId;
        }

        public Add setStaffId(Long staffId) {
            this.staffId = staffId;
            return this;
        }
    }

    public static class Edit {
        //条件
        @NotNull(message = "用户id不能为空")
        private Long userId;

        //修改字段
        private String account;
        private String name;
        private String mobile;
        private String email;
        private String photo;
        private Long orgId;
        private String orgName;
        private Integer gender;//性别：0-未知，1-男，2-女
        private String address;//联系地址
        @Min(value = 0,message = "订阅状态为0或1")
        @Max(value = 1,message = "订阅状态为0或1")
        private Integer subscribeStatus;//是否订阅消息：0-否，1-是
        private String wxOpenId;

        private Integer orgParentId;//机构父Id
        private String orgParentName;//机构父级名称
        private String namePinyinInitials;//姓名全拼首字母
        private String namePinyinShort;//姓名首字母简称
        private String staffName;//员工花名册员工姓名
        private Long staffId;//员工花名册员工id

        public Long getUserId() {
            return userId;
        }

        public Edit setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public String getAccount() {
            return account;
        }

        public Edit setAccount(String account) {
            this.account = account;
            return this;
        }

        public String getName() {
            return name;
        }

        public Edit setName(String name) {
            this.name = name;
            return this;
        }

        public String getMobile() {
            return mobile;
        }

        public Edit setMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public String getEmail() {
            return email;
        }

        public Edit setEmail(String email) {
            this.email = email;
            return this;
        }

        public String getPhoto() {
            return photo;
        }

        public Edit setPhoto(String photo) {
            this.photo = photo;
            return this;
        }

        public Long getOrgId() {
            return orgId;
        }

        public Edit setOrgId(Long orgId) {
            this.orgId = orgId;
            return this;
        }

        public String getOrgName() {
            return orgName;
        }

        public Edit setOrgName(String orgName) {
            this.orgName = orgName;
            return this;
        }

        public Integer getGender() {
            return gender;
        }

        public Edit setGender(Integer gender) {
            this.gender = gender;
            return this;
        }

        public String getAddress() {
            return address;
        }

        public Edit setAddress(String address) {
            this.address = address;
            return this;
        }

        public Integer getSubscribeStatus() {
            return subscribeStatus;
        }

        public Edit setSubscribeStatus(Integer subscribeStatus) {
            this.subscribeStatus = subscribeStatus;
            return this;
        }

        public String getWxOpenId() {
            return wxOpenId;
        }

        public Edit setWxOpenId(String wxOpenId) {
            this.wxOpenId = wxOpenId;
            return this;
        }

        public Integer getOrgParentId() {
            return orgParentId;
        }

        public Edit setOrgParentId(Integer orgParentId) {
            this.orgParentId = orgParentId;
            return this;
        }

        public String getOrgParentName() {
            return orgParentName;
        }

        public Edit setOrgParentName(String orgParentName) {
            this.orgParentName = orgParentName;
            return this;
        }

        public String getNamePinyinInitials() {
            return namePinyinInitials;
        }

        public Edit setNamePinyinInitials(String namePinyinInitials) {
            this.namePinyinInitials = namePinyinInitials;
            return this;
        }

        public String getNamePinyinShort() {
            return namePinyinShort;
        }

        public Edit setNamePinyinShort(String namePinyinShort) {
            this.namePinyinShort = namePinyinShort;
            return this;
        }

        public String getStaffName() {
            return staffName;
        }

        public Edit setStaffName(String staffName) {
            this.staffName = staffName;
            return this;
        }

        public Long getStaffId() {
            return staffId;
        }

        public Edit setStaffId(Long staffId) {
            this.staffId = staffId;
            return this;
        }
    }

    public static class Pwd {
        @NotBlank(message = "请填写新密码")
        private String pwd1;
        @NotBlank(message = "请确认新密码")
        private String pwd2;
        @NotNull(message = "用户ID不能为空")
        private Long accountId;

        public String getPwd1() {
            return pwd1;
        }

        public Pwd setPwd1(String pwd1) {
            this.pwd1 = pwd1;
            return this;
        }

        public String getPwd2() {
            return pwd2;
        }

        public Pwd setPwd2(String pwd2) {
            this.pwd2 = pwd2;
            return this;
        }

        public Long getAccountId() {
            return accountId;
        }

        public Pwd setAccountId(Long accountId) {
            this.accountId = accountId;
            return this;
        }
    }

    public static class SubscribeStatus {
        @NotNull(message = "id不能为空")
        private Long userId;
        @NotNull(message = "订阅状态不能为空")
        @Min(value = 0,message = "订阅状态为0或1")
        @Max(value = 1,message = "订阅状态为0或1")
        private Integer subscribeStatus;//是否订阅消息：0-否，1-是

        public Long getUserId() {
            return userId;
        }

        public SubscribeStatus setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Integer getSubscribeStatus() {
            return subscribeStatus;
        }

        public SubscribeStatus setSubscribeStatus(Integer subscribeStatus) {
            this.subscribeStatus = subscribeStatus;
            return this;
        }
    }

    public static class BindWx {
        @NotBlank(message = "授权码不能为空")
        private String code;//微信授权码
        @NotBlank(message = "小程序编码不能为空")
        private String appCode;//小程序code
        @NotBlank(message = "账号不能为空")
        private String account;//账户
        @NotBlank(message = "密码不能为空")
        private String pwd;//密码
        private String nickName;//微信昵称
        private String avatarUrl;//微信头像
        private String province;
        private String city;
        private String country;

        public String getCode() {
            return code;
        }

        public BindWx setCode(String code) {
            this.code = code;
            return this;
        }

        public String getAppCode() {
            return appCode;
        }

        public BindWx setAppCode(String appCode) {
            this.appCode = appCode;
            return this;
        }

        public String getAccount() {
            return account;
        }

        public BindWx setAccount(String account) {
            this.account = account;
            return this;
        }

        public String getPwd() {
            return pwd;
        }

        public BindWx setPwd(String pwd) {
            this.pwd = pwd;
            return this;
        }

        public String getNickName() {
            return nickName;
        }

        public BindWx setNickName(String nickName) {
            this.nickName = nickName;
            return this;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public BindWx setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
            return this;
        }

        public String getProvince() {
            return province;
        }

        public BindWx setProvince(String province) {
            this.province = province;
            return this;
        }

        public String getCity() {
            return city;
        }

        public BindWx setCity(String city) {
            this.city = city;
            return this;
        }

        public String getCountry() {
            return country;
        }

        public BindWx setCountry(String country) {
            this.country = country;
            return this;
        }
    }

    public static class WxLogin {
        @NotBlank(message = "授权码不能为空")
        private String code;//微信授权码
        @NotBlank(message = "小程序编码不能为空")
        private String appCode;//小程序code

        public String getCode() {
            return code;
        }

        public WxLogin setCode(String code) {
            this.code = code;
            return this;
        }

        public String getAppCode() {
            return appCode;
        }

        public WxLogin setAppCode(String appCode) {
            this.appCode = appCode;
            return this;
        }
    }

    public static class ResetPwd {
        //传入其一
        private String account;
        private String mobile;

        //行密码
        @NotBlank(message = "新密码不能为空")
        private String pwd;
        @NotBlank(message = "确认密码不能为空")
        private String confirmPwd;

        public String getAccount() {
            return account;
        }

        public ResetPwd setAccount(String account) {
            this.account = account;
            return this;
        }

        public String getMobile() {
            return mobile;
        }

        public ResetPwd setMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public String getPwd() {
            return pwd;
        }

        public ResetPwd setPwd(String pwd) {
            this.pwd = pwd;
            return this;
        }

        public String getConfirmPwd() {
            return confirmPwd;
        }

        public ResetPwd setConfirmPwd(String confirmPwd) {
            this.confirmPwd = confirmPwd;
            return this;
        }
    }
}
