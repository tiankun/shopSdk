package com.redare.shop.unifyworkbench.appapi.pojo;

/**
 * Created by niuxiaoming on 16/9/8.
 */
public class GlobalArg {

    private String account;//用户账号
    private String platform; //平台信息 编码
    private String platformName; //平台信息 名称
    private String userPlatform; //用户所属平台
    private Long userId; //用户id
    private String name; //用户名称
    private Long roleId; //角色id
    private String roleName;//角色名称
    private boolean admin;//是否管理员
    private boolean root;//是否root用户

    public String getAccount() {
        return account;
    }

    public GlobalArg setAccount(String account) {
        this.account = account;
        return this;
    }

    public String getPlatform() {
        return platform;
    }

    public GlobalArg setPlatform(String platform) {
        this.platform = platform;
        return this;
    }

    public String getPlatformName() {
        return platformName;
    }

    public GlobalArg setPlatformName(String platformName) {
        this.platformName = platformName;
        return this;
    }

    public String getUserPlatform() {
        return userPlatform;
    }

    public GlobalArg setUserPlatform(String userPlatform) {
        this.userPlatform = userPlatform;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public GlobalArg setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getName() {
        return name;
    }

    public GlobalArg setName(String name) {
        this.name = name;
        return this;
    }

    public Long getRoleId() {
        return roleId;
    }

    public GlobalArg setRoleId(Long roleId) {
        this.roleId = roleId;
        return this;
    }

    public String getRoleName() {
        return roleName;
    }

    public GlobalArg setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public boolean isAdmin() {
        return admin;
    }

    public GlobalArg setAdmin(boolean admin) {
        this.admin = admin;
        return this;
    }

    public boolean isRoot() {
        return root;
    }

    public GlobalArg setRoot(boolean root) {
        this.root = root;
        return this;
    }
}
