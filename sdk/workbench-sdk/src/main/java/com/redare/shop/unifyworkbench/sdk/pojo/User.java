package com.redare.shop.unifyworkbench.sdk.pojo;

import com.redare.devframework.webplatform.sdk.core.pojo.PlatformRole;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/6/30 11:07
 * @version: 1.1
 */
public class User {
    private Long userId;
    private String name;
    private String mobile;
    private String email;
    private String photo;
    private long id;
    private String accountId;
    private String account;
    private String pwd;
    private String platform;
    private String platformName;
    private String userPlatform;
    private long menuId;
    private String menuName;
    private String roleIds;
    private String roleNames;
    private int status;
    private String statusMsg;
    private boolean needResetPwd;
    private Date lastLoginTime;
    private Date createTime;
    private Date updateTime;
    private boolean admin;
    private boolean root;
    private List<PlatformRole> roleList;
    private List<Long> roleIdList;
    private Long orgId;
    private String orgName;
    private Integer orgParentId;
    private String orgParentName;
    private String namePinyinInitials;
    private String namePinyinShort;
    private String departmentName;
    private String post;

    public String getDepartmentName() {
        return departmentName;
    }

    public User setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
        return this;
    }

    public String getPost() {
        return post;
    }

    public User setPost(String post) {
        this.post = post;
        return this;
    }

    public String getAccountId() {
        return accountId;
    }

    public User setAccountId(String accountId) {
        this.accountId = accountId;
        return this;
    }
    /**
     * @description: 员工花名册员工姓名
     * @author: zhangsq
     * @date: Created in 2020-07-29 10:42
     */
    private String staffName;
    /**
     * @description: 员工花名册员工id
     * @author: zhangsq
     * @date: Created in 2020-07-29 10:42
     */
    private Long staffId;

    public Long getUserId() {
        return userId;
    }

    public User setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public User setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public User setPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    public long getId() {
        return id;
    }

    public User setId(long id) {
        this.id = id;
        return this;
    }

    public String getAccount() {
        return account;
    }

    public User setAccount(String account) {
        this.account = account;
        return this;
    }

    public String getPwd() {
        return pwd;
    }

    public User setPwd(String pwd) {
        this.pwd = pwd;
        return this;
    }

    public String getPlatform() {
        return platform;
    }

    public User setPlatform(String platform) {
        this.platform = platform;
        return this;
    }

    public String getPlatformName() {
        return platformName;
    }

    public User setPlatformName(String platformName) {
        this.platformName = platformName;
        return this;
    }

    public String getUserPlatform() {
        return userPlatform;
    }

    public User setUserPlatform(String userPlatform) {
        this.userPlatform = userPlatform;
        return this;
    }

    public long getMenuId() {
        return menuId;
    }

    public User setMenuId(long menuId) {
        this.menuId = menuId;
        return this;
    }

    public String getMenuName() {
        return menuName;
    }

    public User setMenuName(String menuName) {
        this.menuName = menuName;
        return this;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public User setRoleIds(String roleIds) {
        this.roleIds = roleIds;
        return this;
    }

    public String getRoleNames() {
        return roleNames;
    }

    public User setRoleNames(String roleNames) {
        this.roleNames = roleNames;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public User setStatus(int status) {
        this.status = status;
        return this;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public User setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
        return this;
    }

    public boolean isNeedResetPwd() {
        return needResetPwd;
    }

    public User setNeedResetPwd(boolean needResetPwd) {
        this.needResetPwd = needResetPwd;
        return this;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public User setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public User setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public User setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public boolean isAdmin() {
        return admin;
    }

    public User setAdmin(boolean admin) {
        this.admin = admin;
        return this;
    }

    public boolean isRoot() {
        return root;
    }

    public User setRoot(boolean root) {
        this.root = root;
        return this;
    }

    public List<PlatformRole> getRoleList() {
        return roleList;
    }

    public User setRoleList(List<PlatformRole> roleList) {
        this.roleList = roleList;
        return this;
    }

    public List<Long> getRoleIdList() {
        return roleIdList;
    }

    public User setRoleIdList(List<Long> roleIdList) {
        this.roleIdList = roleIdList;
        return this;
    }

    public Long getOrgId() {
        return orgId;
    }

    public User setOrgId(Long orgId) {
        this.orgId = orgId;
        return this;
    }

    public String getOrgName() {
        return orgName;
    }

    public User setOrgName(String orgName) {
        this.orgName = orgName;
        return this;
    }

    public Integer getOrgParentId() {
        return orgParentId;
    }

    public User setOrgParentId(Integer orgParentId) {
        this.orgParentId = orgParentId;
        return this;
    }

    public String getOrgParentName() {
        return orgParentName;
    }

    public User setOrgParentName(String orgParentName) {
        this.orgParentName = orgParentName;
        return this;
    }

    public String getNamePinyinInitials() {
        return namePinyinInitials;
    }

    public User setNamePinyinInitials(String namePinyinInitials) {
        this.namePinyinInitials = namePinyinInitials;
        return this;
    }

    public String getNamePinyinShort() {
        return namePinyinShort;
    }

    public User setNamePinyinShort(String namePinyinShort) {
        this.namePinyinShort = namePinyinShort;
        return this;
    }

    public String getStaffName() {
        return staffName;
    }

    public User setStaffName(String staffName) {
        this.staffName = staffName;
        return this;
    }

    public Long getStaffId() {
        return staffId;
    }

    public User setStaffId(Long staffId) {
        this.staffId = staffId;
        return this;
    }
}
