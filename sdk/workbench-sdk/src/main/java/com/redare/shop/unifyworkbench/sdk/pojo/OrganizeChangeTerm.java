package com.redare.shop.unifyworkbench.sdk.pojo;

import java.util.Date;

/**
 * @description:组织换届信息
 * @author: zlx
 * @date: Created in 2020/10/19 10:14
 * @version:
 */
public class OrganizeChangeTerm {
    /**
     * 主键
     */
    private Long id;
    /**
     * 组织机构id
     */
    private String orgId;
    /**
     * 组织机构名称
     */
    private String orgName;
    /**
     * 换届信息
     */
    private String changeInfo;
    /**
     * 操作人员id
     */
    private Long userId;
    /**
     * 操作人员名称
     */
    private String userName;
    /**
     * 是否删除0:正常，1:删除
     */
    private Integer del;
    /**
     * 换届时间
     */
    private Date changeTime;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public OrganizeChangeTerm setId(Long id) {
        this.id = id;
        return this;
    }

    public String getOrgId() {
        return orgId;
    }

    public OrganizeChangeTerm setOrgId(String orgId) {
        this.orgId = orgId;
        return this;
    }

    public String getOrgName() {
        return orgName;
    }

    public OrganizeChangeTerm setOrgName(String orgName) {
        this.orgName = orgName;
        return this;
    }

    public String getChangeInfo() {
        return changeInfo;
    }

    public OrganizeChangeTerm setChangeInfo(String changeInfo) {
        this.changeInfo = changeInfo;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public OrganizeChangeTerm setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public OrganizeChangeTerm setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public Integer getDel() {
        return del;
    }

    public OrganizeChangeTerm setDel(Integer del) {
        this.del = del;
        return this;
    }

    public Date getChangeTime() {
        return changeTime;
    }

    public OrganizeChangeTerm setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public OrganizeChangeTerm setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public OrganizeChangeTerm setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}
