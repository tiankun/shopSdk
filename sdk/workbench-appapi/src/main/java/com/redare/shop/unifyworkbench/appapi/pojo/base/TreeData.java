package com.redare.shop.unifyworkbench.appapi.pojo.base;

import java.util.List;

/**
 * Created by tiankun on 2020-08-21
 */
public class TreeData {
    private Long id;
    private String deptId;
    private String name;
    private List<TreeData> children;
    private Boolean isLeaf;

    public Long getId() {
        return id;
    }

    public TreeData setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TreeData setName(String name) {
        this.name = name;
        return this;
    }

    public List<TreeData> getChildren() {
        return children;
    }

    public TreeData setChildren(List<TreeData> children) {
        this.children = children;
        return this;
    }

    public String getDeptId() {
        return deptId;
    }

    public TreeData setDeptId(String deptId) {
        this.deptId = deptId;
        return this;
    }

    public Boolean getLeaf() {
        return isLeaf;
    }

    public TreeData setLeaf(Boolean leaf) {
        isLeaf = leaf;
        return this;
    }
}
