package com.redare.shop.unifyworkbench.sdk.pojo;

import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/7/9 18:29
 * @version: 1.1
 */
public class OrganizationTree {

    private Long key;
    private String title;
    private Long parentId;
    private Boolean selectable;
    private List<OrganizationTree> children;

    public List<OrganizationTree> getChildren() {
        return children;
    }

    public OrganizationTree setChildren(List<OrganizationTree> children) {
        this.children = children;
        return this;
    }

    public Long getKey() {
        return key;
    }

    public OrganizationTree setKey(Long key) {
        this.key = key;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public OrganizationTree setTitle(String title) {
        this.title = title;
        return this;
    }

    public Long getParentId() {
        return parentId;
    }

    public OrganizationTree setParentId(Long parentId) {
        this.parentId = parentId;
        return this;
    }

    public Boolean getSelectable() {
        return selectable;
    }

    public OrganizationTree setSelectable(Boolean selectable) {
        this.selectable = selectable;
        return this;
    }
}
