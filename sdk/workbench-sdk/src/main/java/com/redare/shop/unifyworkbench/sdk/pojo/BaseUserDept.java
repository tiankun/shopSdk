package com.redare.shop.unifyworkbench.sdk.pojo;

import java.io.Serializable;

/**
 * @author : zhangsq
 * @version :
 * @description：用户部门实体
 * @date ：Created in 2020-11-19 17:58
 */
public class BaseUserDept implements Serializable {

    private static final long serialVersionUID = -5072712831038510072L;

    /**
     * 组织机构Id
     */
    private String orgId;
    /**
     * 组织机构名称
     */
    private String orgName;
    /**
     * 部门Id
     */
    private String deptId;
    /**
     * 部门名称
     */
    private String deptName;

    private Long count;

    public String getOrgId() {
        return orgId;
    }

    public BaseUserDept setOrgId(String orgId) {
        this.orgId = orgId;
        return this;
    }

    public String getOrgName() {
        return orgName;
    }

    public BaseUserDept setOrgName(String orgName) {
        this.orgName = orgName;
        return this;
    }

    public String getDeptId() {
        return deptId;
    }

    public BaseUserDept setDeptId(String deptId) {
        this.deptId = deptId;
        return this;
    }

    public String getDeptName() {
        return deptName;
    }

    public BaseUserDept setDeptName(String deptName) {
        this.deptName = deptName;
        return this;
    }

    public Long getCount() {
        return count;
    }

    public BaseUserDept setCount(Long count) {
        this.count = count;
        return this;
    }
}
