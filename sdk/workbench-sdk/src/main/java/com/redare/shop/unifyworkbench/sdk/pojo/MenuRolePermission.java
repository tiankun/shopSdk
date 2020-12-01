package com.redare.shop.unifyworkbench.sdk.pojo;

/**
 * @description: MenuRolePermission
 * @author: zlx
 * @date: Created in 2020/6/13 13:30
 * @version: 1.1
 */
public class MenuRolePermission {

    private String menuId;
    private String menuName;
    private String id;
    private String url;
    private String needPermission;
    private String name;
    private String componentId;
    private String webPath;
    private String urlPath;

    public String getUrlPath() {
        return urlPath;
    }

    public MenuRolePermission setUrlPath(String urlPath) {
        this.urlPath = urlPath;
        return this;
    }

    public String getMenuName() {
        return menuName;
    }

    public MenuRolePermission setMenuName(String menuName) {
        this.menuName = menuName;
        return this;
    }

    public String getId() {
        return id;
    }

    public MenuRolePermission setId(String id) {
        this.id = id;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public MenuRolePermission setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getNeedPermission() {
        return needPermission;
    }

    public MenuRolePermission setNeedPermission(String needPermission) {
        this.needPermission = needPermission;
        return this;
    }

    public String getMenuId() {
        return menuId;
    }

    public MenuRolePermission setMenuId(String menuId) {
        this.menuId = menuId;
        return this;
    }

    public String getName() {
        return name;
    }

    public MenuRolePermission setName(String name) {
        this.name = name;
        return this;
    }

    public String getComponentId() {
        return componentId;
    }

    public MenuRolePermission setComponentId(String componentId) {
        this.componentId = componentId;
        return this;
    }

    public String getWebPath() {
        return webPath;
    }

    public MenuRolePermission setWebPath(String webPath) {
        this.webPath = webPath;
        return this;
    }
}
