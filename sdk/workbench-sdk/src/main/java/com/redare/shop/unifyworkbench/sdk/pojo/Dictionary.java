package com.redare.shop.unifyworkbench.sdk.pojo;

import java.util.List;

public class Dictionary {
    private long id;
    private String platform;
    private String platformName;
    private String dicCode;
    private String dicName;
    private String dicValue;
    private String des;
    private String extArg;
    private boolean canEdit;
    private int sort;
    private boolean leaf;
    private long parentId;
    private int status;
    private List<Dictionary> children;

    public long getId() {
        return id;
    }

    public Dictionary setId(long id) {
        this.id = id;
        return this;
    }

    public String getPlatform() {
        return platform;
    }

    public Dictionary setPlatform(String platform) {
        this.platform = platform;
        return this;
    }

    public String getPlatformName() {
        return platformName;
    }

    public Dictionary setPlatformName(String platformName) {
        this.platformName = platformName;
        return this;
    }

    public String getDicCode() {
        return dicCode;
    }

    public Dictionary setDicCode(String dicCode) {
        this.dicCode = dicCode;
        return this;
    }

    public String getDicName() {
        return dicName;
    }

    public Dictionary setDicName(String dicName) {
        this.dicName = dicName;
        return this;
    }

    public String getDicValue() {
        return dicValue;
    }

    public Dictionary setDicValue(String dicValue) {
        this.dicValue = dicValue;
        return this;
    }

    public String getDes() {
        return des;
    }

    public Dictionary setDes(String des) {
        this.des = des;
        return this;
    }

    public String getExtArg() {
        return extArg;
    }

    public Dictionary setExtArg(String extArg) {
        this.extArg = extArg;
        return this;
    }

    public boolean isCanEdit() {
        return canEdit;
    }

    public Dictionary setCanEdit(boolean canEdit) {
        this.canEdit = canEdit;
        return this;
    }

    public int getSort() {
        return sort;
    }

    public Dictionary setSort(int sort) {
        this.sort = sort;
        return this;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public Dictionary setLeaf(boolean leaf) {
        this.leaf = leaf;
        return this;
    }

    public long getParentId() {
        return parentId;
    }

    public Dictionary setParentId(long parentId) {
        this.parentId = parentId;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public Dictionary setStatus(int status) {
        this.status = status;
        return this;
    }

    public List<Dictionary> getChildren() {
        return children;
    }

    public Dictionary setChildren(List<Dictionary> children) {
        this.children = children;
        return this;
    }
}
