package com.redare.shop.unifyworkbench.appapi.pojo.base.form;

import com.redare.devframework.common.validation.validator.Mobile;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.util.List;

/**
 * Created by taoyuandi on 28/05/2017.
 */
public class UserForm {

    public static class WorkForm {
        private Long userId;
        private Boolean worked;

        public Long getUserId() {
            return userId;
        }

        public WorkForm setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Boolean getWorked() {
            return worked;
        }

        public WorkForm setWorked(Boolean worked) {
            this.worked = worked;
            return this;
        }
    }

    public static class Get {

        private String platform;//平台信息
        private String account;//账号信息
        private Long userId;//用户ID
        private String wxOpenId;//微信openId
        private boolean incOrg;//是否包含组织
        private boolean nameSpell;//是否包含姓名拼音

        public String getAccount() {
            return account;
        }

        public Get setAccount(String account) {
            this.account = account;
            return this;
        }

        public Long getUserId() {
            return userId;
        }

        public Get setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public String getWxOpenId() {
            return wxOpenId;
        }

        public Get setWxOpenId(String wxOpenId) {
            this.wxOpenId = wxOpenId;
            return this;
        }

        public boolean isIncOrg() {
            return incOrg;
        }

        public Get setIncOrg(boolean incOrg) {
            this.incOrg = incOrg;
            return this;
        }

        public String getPlatform() {
            return platform;
        }

        public Get setPlatform(String platform) {
            this.platform = platform;
            return this;
        }

        public boolean isNameSpell() {
            return nameSpell;
        }

        public Get setNameSpell(boolean nameSpell) {
            this.nameSpell = nameSpell;
            return this;
        }
    }

    public static class Search {

        private List<Long> id;//用户ID
        private String key;//关键字
        private Integer status;//状态
        private Long roleId;//角色
        private Long orgId;//组织ID
        private String platform;//平台
        private List<String> platforms;//平台
        private String userPlatform;//用户平台
        private Long pMenuId;//菜单ID
        private boolean exclRoot;//是否排除root用户
        private boolean nameSpell;//是否包含姓名拼音
        private boolean incOrg;
        private boolean assign;//是否查询净空审核人员

        public List<String> getPlatforms() {
            return platforms;
        }

        public Search setPlatforms(List<String> platforms) {
            this.platforms = platforms;
            return this;
        }

        public String getPlatform() {
            return platform;
        }

        public Search setPlatform(String platform) {
            this.platform = platform;
            return this;
        }

        public String getUserPlatform() {
            return userPlatform;
        }

        public Search setUserPlatform(String userPlatform) {
            this.userPlatform = userPlatform;
            return this;
        }

        public Long getpMenuId() {
            return pMenuId;
        }

        public Search setpMenuId(Long pMenuId) {
            this.pMenuId = pMenuId;
            return this;
        }

        public boolean isIncOrg() {
            return incOrg;
        }

        public Search setIncOrg(boolean incOrg) {
            this.incOrg = incOrg;
            return this;
        }

        public boolean isExclRoot() {
            return exclRoot;
        }

        public Search setExclRoot(boolean exclRoot) {
            this.exclRoot = exclRoot;
            return this;
        }

        public String getKey() {
            return key;
        }

        public Search setKey(String key) {
            this.key = key;
            return this;
        }

        public Integer getStatus() {
            return status;
        }

        public Search setStatus(Integer status) {
            this.status = status;
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

        public List<Long> getId() {
            return id;
        }

        public Search setId(List<Long> id) {
            this.id = id;
            return this;
        }

        public boolean isNameSpell() {
            return nameSpell;
        }

        public Search setNameSpell(boolean nameSpell) {
            this.nameSpell = nameSpell;
            return this;
        }

        public boolean isAssign() {
            return assign;
        }

        public Search setAssign(boolean assign) {
            this.assign = assign;
            return this;
        }
    }

    public static class Edit {

        @NotNull(message = "用户ID不能为空")
        private Long userId;
        private String platform;//平台
        @Length(min = 1, max = 10, message = "用户名不能超过10个字符")
        private String name;//名字
        @Mobile
        private String mobile;//手机号
        @Email(message = "邮箱格式错误")
        private String email;//邮箱
        private String photo;//头像
        private String wxOpenId;//微信openId
        private List<Long> orgIds;//公司ID

        public Long getUserId() {
            return userId;
        }

        public Edit setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public String getPlatform() {
            return platform;
        }

        public Edit setPlatform(String platform) {
            this.platform = platform;
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

        public String getWxOpenId() {
            return wxOpenId;
        }

        public Edit setWxOpenId(String wxOpenId) {
            this.wxOpenId = wxOpenId;
            return this;
        }

        public List<Long> getOrgIds() {
            return orgIds;
        }

        public Edit setOrgIds(List<Long> orgIds) {
            this.orgIds = orgIds;
            return this;
        }
    }

    public static class AddForm {

        private Long userId;
        private String name;
        private String mobile;
        private String email;
        private List<Long> orgIds;
        private String photo;
        private Long empNo;
        private String companyName;
        private String post;

        public String getCompanyName() {
            return companyName;
        }

        public AddForm setCompanyName(String companyName) {
            this.companyName = companyName;
            return this;
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

        public List<Long> getOrgIds() {
            return orgIds;
        }

        public AddForm setOrgIds(List<Long> orgIds) {
            this.orgIds = orgIds;
            return this;
        }

        public String getPhoto() {
            return photo;
        }

        public AddForm setPhoto(String photo) {
            this.photo = photo;
            return this;
        }

        public Long getEmpNo() {
            return empNo;
        }

        public AddForm setEmpNo(Long empNo) {
            this.empNo = empNo;
            return this;
        }

        public String getPost() {
            return post;
        }

        public AddForm setPost(String post) {
            this.post = post;
            return this;
        }
    }

    public static class Add {

        private String account;//账号

        @NotBlank(message = "密码不能为空")
        private String pwd1;//密码
        @NotBlank(message = "确认密码不能为空")
        private String pwd2;//密码

        private String platform;//平台
        private String userPlatform;//用户平台
        private Long roleId;//角色
        private List<Long> orgIds;//公司ID

        @NotBlank(message = "用户名不能为空")
        @Length(max = 10, message = "用户名不能超过10个字符")
        private String name;//名字
        private String companyName;

        @Mobile
        private String mobile;//手机号

        @Email(message = "邮箱格式错误")
        private String email;//邮箱
        private String photo;//头像
        private Long empNo;//员工编号
        private String post;//职务

        public String getAccount() {
            return account;
        }

        public Add setAccount(String account) {
            this.account = account;
            return this;
        }

        public String getPwd1() {
            return pwd1;
        }

        public Add setPwd1(String pwd1) {
            this.pwd1 = pwd1;
            return this;
        }

        public String getPwd2() {
            return pwd2;
        }

        public Add setPwd2(String pwd2) {
            this.pwd2 = pwd2;
            return this;
        }

        public String getPlatform() {
            return platform;
        }

        public Add setPlatform(String platform) {
            this.platform = platform;
            return this;
        }

        public String getUserPlatform() {
            return userPlatform;
        }

        public Add setUserPlatform(String userPlatform) {
            this.userPlatform = userPlatform;
            return this;
        }

        public Long getRoleId() {
            return roleId;
        }

        public Add setRoleId(Long roleId) {
            this.roleId = roleId;
            return this;
        }

        public List<Long> getOrgIds() {
            return orgIds;
        }

        public Add setOrgIds(List<Long> orgIds) {
            this.orgIds = orgIds;
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

        public Long getEmpNo() {
            return empNo;
        }

        public Add setEmpNo(Long empNo) {
            this.empNo = empNo;
            return this;
        }

        public String getPost() {
            return post;
        }

        public Add setPost(String post) {
            this.post = post;
            return this;
        }

        public String getCompanyName() {
            return companyName;
        }

        public Add setCompanyName(String companyName) {
            this.companyName = companyName;
            return this;
        }
    }

    public static class AddUserOrgForm {
        private Long userId;
        private Long orgId;

        public Long getUserId() {
            return userId;
        }

        public AddUserOrgForm setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Long getOrgId() {
            return orgId;
        }

        public AddUserOrgForm setOrgId(Long orgId) {
            this.orgId = orgId;
            return this;
        }
    }

    public static class Pwd {
        @NotNull(message = "账号ID不能为空")
        private Long accountId;
        @NotNull(message = "密码不能为空")
        @Length(max = 16, message = "密码不能超过16个字符")
        private String pwd;

        public Long getAccountId() {
            return accountId;
        }

        public Pwd setAccountId(Long accountId) {
            this.accountId = accountId;
            return this;
        }

        public String getPwd() {
            return pwd;
        }

        public Pwd setPwd(String pwd) {
            this.pwd = pwd;
            return this;
        }
    }


    public static class Status {
        @Min(value = 1L, message = "账号ID错误")
        private Long accountId;
        private String platform;
        private String userPlatform;
        @NotNull(message = "状态不能为空")
        @Min(value = -1L, message = "状态错误")
        @Max(value = 2L, message = "状态错误")
        private Integer status;

        public Long getAccountId() {
            return accountId;
        }

        public Status setAccountId(Long accountId) {
            this.accountId = accountId;
            return this;
        }

        public String getPlatform() {
            return platform;
        }

        public Status setPlatform(String platform) {
            this.platform = platform;
            return this;
        }

        public String getUserPlatform() {
            return userPlatform;
        }

        public Status setUserPlatform(String userPlatform) {
            this.userPlatform = userPlatform;
            return this;
        }

        public Integer getStatus() {
            return status;
        }

        public Status setStatus(Integer status) {
            this.status = status;
            return this;
        }
    }
}
