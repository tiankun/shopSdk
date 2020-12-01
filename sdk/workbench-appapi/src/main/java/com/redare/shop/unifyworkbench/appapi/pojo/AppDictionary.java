package com.redare.shop.unifyworkbench.appapi.pojo;

/**
 * Created by niuxm on 2020/7/17 6:22 下午.
 */
public class AppDictionary {
    private Long id;
    private String name;
    private String code;
    private String value;
    private String des;
    private int sort;
    private boolean leaf;
    private Long parentId;
    private String extArg;

    private String platform;
    private String platformName;

    public Long getId() {
        return id;
    }

    public AppDictionary setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AppDictionary setName(String name) {
        this.name = name;
        return this;
    }

    public String getCode() {
        return code;
    }

    public AppDictionary setCode(String code) {
        this.code = code;
        return this;
    }

    public String getValue() {
        return value;
    }

    public AppDictionary setValue(String value) {
        this.value = value;
        return this;
    }

    public String getDes() {
        return des;
    }

    public AppDictionary setDes(String des) {
        this.des = des;
        return this;
    }

    public int getSort() {
        return sort;
    }

    public AppDictionary setSort(int sort) {
        this.sort = sort;
        return this;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public AppDictionary setLeaf(boolean leaf) {
        this.leaf = leaf;
        return this;
    }

    public Long getParentId() {
        return parentId;
    }

    public AppDictionary setParentId(Long parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getPlatform() {
        return platform;
    }

    public AppDictionary setPlatform(String platform) {
        this.platform = platform;
        return this;
    }

    public String getPlatformName() {
        return platformName;
    }

    public AppDictionary setPlatformName(String platformName) {
        this.platformName = platformName;
        return this;
    }

    public String getExtArg() {
        return extArg;
    }

    public AppDictionary setExtArg(String extArg) {
        this.extArg = extArg;
        return this;
    }
}
