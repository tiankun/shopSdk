package com.redare.shop.unifyworkbench.sdk.pojo;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/7/3 14:21
 * @version: 1.1
 */
public class OrganizationFun {

    private String id;
    private String module;
    private String classifyLevel;
    private String name;
    private String url;
    private boolean needPermission;
    private boolean hasPermission;
    private boolean adminPermission;

    public String getId() {
        return id;
    }

    public OrganizationFun setId(String id) {
        this.id = id;
        return this;
    }

    public String getModule() {
        return module;
    }

    public OrganizationFun setModule(String module) {
        this.module = module;
        return this;
    }

    public String getClassifyLevel() {
        return classifyLevel;
    }

    public OrganizationFun setClassifyLevel(String classifyLevel) {
        this.classifyLevel = classifyLevel;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrganizationFun setName(String name) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public OrganizationFun setUrl(String url) {
        this.url = url;
        return this;
    }

    public boolean isNeedPermission() {
        return needPermission;
    }

    public OrganizationFun setNeedPermission(boolean needPermission) {
        this.needPermission = needPermission;
        return this;
    }

    public boolean isHasPermission() {
        return hasPermission;
    }

    public OrganizationFun setHasPermission(boolean hasPermission) {
        this.hasPermission = hasPermission;
        return this;
    }

    public boolean isAdminPermission() {
        return adminPermission;
    }

    public OrganizationFun setAdminPermission(boolean adminPermission) {
        this.adminPermission = adminPermission;
        return this;
    }
}
