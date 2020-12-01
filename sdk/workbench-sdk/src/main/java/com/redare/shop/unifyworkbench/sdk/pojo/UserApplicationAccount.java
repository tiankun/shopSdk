package com.redare.shop.unifyworkbench.sdk.pojo;

import java.util.Date;

/**
 * @description:用户可访问应用的账号绑定信息
 * @author: zlx
 * @date: Created in 2020/8/20 14:12
 * @version: 1.1
 */
public class UserApplicationAccount {
    /**
     * 主键
     */
    private Long id;
    /**
     * 用户Id
     */
    private Long userId;
    /**
     * 应用Id
     */
    private Long applicationId;
    /**
     * 应用账号
     */
    private String applicationUserId;
    /**
     * 应用密码
     */
    private String applicationUserPwd;
    /**
     *登录账号所对应的UserId
     */
    private String accountId;
    /**
     * 创建时间
     */
    private Date createTime;

    public Long getId() {
        return id;
    }

    public UserApplicationAccount setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public UserApplicationAccount setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public UserApplicationAccount setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
        return this;
    }

    public String getApplicationUserId() {
        return applicationUserId;
    }

    public UserApplicationAccount setApplicationUserId(String applicationUserId) {
        this.applicationUserId = applicationUserId;
        return this;
    }

    public String getApplicationUserPwd() {
        return applicationUserPwd;
    }

    public UserApplicationAccount setApplicationUserPwd(String applicationUserPwd) {
        this.applicationUserPwd = applicationUserPwd;
        return this;
    }

    public String getAccountId() {
        return accountId;
    }

    public UserApplicationAccount setAccountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public UserApplicationAccount setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }
}
