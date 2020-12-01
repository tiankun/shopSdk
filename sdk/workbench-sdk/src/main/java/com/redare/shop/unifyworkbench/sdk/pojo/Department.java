package com.redare.shop.unifyworkbench.sdk.pojo;

import java.util.Date;

/**
 * @description: 部门表
 * @author: zlx
 * @date: Created in 2020/10/16 16:10
 * @version:
 */
public class Department {
    /**
     * 自增主键，不要用
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
     * 部门id
     */
    private String departmentId;
    /**
     * 父级departmentId
     */
    private String parentId;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 操作人员id
     */
    private Long userId;
    /**
     * 操作人员名称
     */
    private String userName;
    /**
     * '部门的管理人员列表'
     */
    private String departManageUserIdList;
    /**
     * 部门Id层级标识
     */
    private String departIdTag;
    /**
     * 部门IDLevel
     */
    private String departIdLevel;
    /**
     * '部门名称层级'
     */
    private String departNameLevel;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * '修改时间'
     */
    private Date updateTime;
    /**
     * 状态1：正常，0：，-1:删除
     */
    private Integer status;

    public Long getId() {
        return id;
    }

    public Department setId(Long id) {
        this.id = id;
        return this;
    }

    public String getOrgId() {
        return orgId;
    }

    public Department setOrgId(String orgId) {
        this.orgId = orgId;
        return this;
    }

    public String getOrgName() {
        return orgName;
    }

    public Department setOrgName(String orgName) {
        this.orgName = orgName;
        return this;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public Department setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
        return this;
    }

    public String getParentId() {
        return parentId;
    }

    public Department setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getDeptName() {
        return deptName;
    }

    public Department setDeptName(String deptName) {
        this.deptName = deptName;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public Department setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public Department setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getDepartManageUserIdList() {
        return departManageUserIdList;
    }

    public Department setDepartManageUserIdList(String departManageUserIdList) {
        this.departManageUserIdList = departManageUserIdList;
        return this;
    }

    public String getDepartIdTag() {
        return departIdTag;
    }

    public Department setDepartIdTag(String departIdTag) {
        this.departIdTag = departIdTag;
        return this;
    }

    public String getDepartIdLevel() {
        return departIdLevel;
    }

    public Department setDepartIdLevel(String departIdLevel) {
        this.departIdLevel = departIdLevel;
        return this;
    }

    public String getDepartNameLevel() {
        return departNameLevel;
    }

    public Department setDepartNameLevel(String departNameLevel) {
        this.departNameLevel = departNameLevel;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Department setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public Department setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public Department setStatus(Integer status) {
        this.status = status;
        return this;
    }
}
