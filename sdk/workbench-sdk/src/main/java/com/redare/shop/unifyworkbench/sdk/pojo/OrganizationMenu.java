package com.redare.shop.unifyworkbench.sdk.pojo;


import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/7/3 11:21
 * @version: 1.1
 */
public class OrganizationMenu {
    private long id;
    private String menuId;
    private long platformMenuId;
    private String name;
    private String urlPath;
    private String componentId;
    private String componentClassId;
    private String componentName;
    private String componentWebPath;
    private String extArg;
    private String iconCls;
    private boolean leaf;
    private String parentMenuId;
    private boolean root;
    private int sort;
    private boolean enabled;
    private String menuIdLevels;
    private String nameLevels;
    private boolean refPage;
    private boolean refComponent;
    private List<OrganizationMenu> children;
    private boolean hasPermission;
    private boolean adminPermission;

    public long getId() {
        return id;
    }

    public OrganizationMenu setId(long id) {
        this.id = id;
        return this;
    }

    public String getMenuId() {
        return menuId;
    }

    public OrganizationMenu setMenuId(String menuId) {
        this.menuId = menuId;
        return this;
    }

    public long getPlatformMenuId() {
        return platformMenuId;
    }

    public OrganizationMenu setPlatformMenuId(long platformMenuId) {
        this.platformMenuId = platformMenuId;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrganizationMenu setName(String name) {
        this.name = name;
        return this;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public OrganizationMenu setUrlPath(String urlPath) {
        this.urlPath = urlPath;
        return this;
    }

    public String getComponentId() {
        return componentId;
    }

    public OrganizationMenu setComponentId(String componentId) {
        this.componentId = componentId;
        return this;
    }

    public String getComponentClassId() {
        return componentClassId;
    }

    public OrganizationMenu setComponentClassId(String componentClassId) {
        this.componentClassId = componentClassId;
        return this;
    }

    public String getComponentName() {
        return componentName;
    }

    public OrganizationMenu setComponentName(String componentName) {
        this.componentName = componentName;
        return this;
    }

    public String getComponentWebPath() {
        return componentWebPath;
    }

    public OrganizationMenu setComponentWebPath(String componentWebPath) {
        this.componentWebPath = componentWebPath;
        return this;
    }

    public String getExtArg() {
        return extArg;
    }

    public OrganizationMenu setExtArg(String extArg) {
        this.extArg = extArg;
        return this;
    }

    public String getIconCls() {
        return iconCls;
    }

    public OrganizationMenu setIconCls(String iconCls) {
        this.iconCls = iconCls;
        return this;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public OrganizationMenu setLeaf(boolean leaf) {
        this.leaf = leaf;
        return this;
    }

    public String getParentMenuId() {
        return parentMenuId;
    }

    public OrganizationMenu setParentMenuId(String parentMenuId) {
        this.parentMenuId = parentMenuId;
        return this;
    }

    public boolean isRoot() {
        return root;
    }

    public OrganizationMenu setRoot(boolean root) {
        this.root = root;
        return this;
    }

    public int getSort() {
        return sort;
    }

    public OrganizationMenu setSort(int sort) {
        this.sort = sort;
        return this;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public OrganizationMenu setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public String getMenuIdLevels() {
        return menuIdLevels;
    }

    public OrganizationMenu setMenuIdLevels(String menuIdLevels) {
        this.menuIdLevels = menuIdLevels;
        return this;
    }

    public String getNameLevels() {
        return nameLevels;
    }

    public OrganizationMenu setNameLevels(String nameLevels) {
        this.nameLevels = nameLevels;
        return this;
    }

    public boolean isRefPage() {
        return refPage;
    }

    public OrganizationMenu setRefPage(boolean refPage) {
        this.refPage = refPage;
        return this;
    }

    public boolean isRefComponent() {
        return refComponent;
    }

    public OrganizationMenu setRefComponent(boolean refComponent) {
        this.refComponent = refComponent;
        return this;
    }

    public List<OrganizationMenu> getChildren() {
        return children;
    }

    public OrganizationMenu setChildren(List<OrganizationMenu> children) {
        this.children = children;
        return this;
    }

    public boolean isHasPermission() {
        return hasPermission;
    }

    public OrganizationMenu setHasPermission(boolean hasPermission) {
        this.hasPermission = hasPermission;
        return this;
    }

    public boolean isAdminPermission() {
        return adminPermission;
    }

    public OrganizationMenu setAdminPermission(boolean adminPermission) {
        this.adminPermission = adminPermission;
        return this;
    }
}
