package com.redare.shop.unifyworkbench.sdk.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 组织荣誉信息(OrganizeHonor)实体类
 *
 * @author makejava
 * @since 2020-10-19 14:58:46
 */
public class OrganizeHonor implements Serializable {
    private static final long serialVersionUID = -26031962491920525L;
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
     * 荣誉名称
     */
    private String honorName;
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
     * 获得时间
     */
    private Date honorTime;
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

    public OrganizeHonor setId(Long id) {
        this.id = id;
        return this;
    }

    public String getOrgId() {
        return orgId;
    }

    public OrganizeHonor setOrgId(String orgId) {
        this.orgId = orgId;
        return this;
    }

    public String getOrgName() {
        return orgName;
    }

    public OrganizeHonor setOrgName(String orgName) {
        this.orgName = orgName;
        return this;
    }

    public String getHonorName() {
        return honorName;
    }

    public OrganizeHonor setHonorName(String honorName) {
        this.honorName = honorName;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public OrganizeHonor setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public OrganizeHonor setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public Integer getDel() {
        return del;
    }

    public OrganizeHonor setDel(Integer del) {
        this.del = del;
        return this;
    }

    public Date getHonorTime() {
        return honorTime;
    }

    public OrganizeHonor setHonorTime(Date honorTime) {
        this.honorTime = honorTime;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public OrganizeHonor setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public OrganizeHonor setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}