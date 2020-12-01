package com.redare.shop.unifyworkbench.sdk.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author : zhangsq
 * @version :
 * @description：人员管理表格树实体类
 * @date ：Created in 2020-11-19 14:36
 */
public class BaseUserTree implements Serializable {

    private static final long serialVersionUID = -3636096917438731693L;

    /**
     * '部门ID'
     */
    private String departmentId;
    /**
     * '部门名称'
     */
    private String departmentName;

    /**
     * 部门人数
     */
    private Long userNumbers;

    /**
     * 部门对应的人员信息
     */
    private List<BaseUser> children;

    public String getDepartmentId() {
        return departmentId;
    }

    public BaseUserTree setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
        return this;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public BaseUserTree setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
        return this;
    }

    public Long getUserNumbers() {
        return userNumbers;
    }

    public BaseUserTree setUserNumbers(Long userNumbers) {
        this.userNumbers = userNumbers;
        return this;
    }

    public List<BaseUser> getChildren() {
        return children;
    }

    public BaseUserTree setChildren(List<BaseUser> children) {
        this.children = children;
        return this;
    }
}
