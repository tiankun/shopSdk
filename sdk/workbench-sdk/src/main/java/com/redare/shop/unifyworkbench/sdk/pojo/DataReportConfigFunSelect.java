package com.redare.shop.unifyworkbench.sdk.pojo;

/**
 * @description: 数据报表配置根据menuId查询功能权限下拉选
 * @author: zlx
 * @date: Created in 2020/9/10 15:18
 * @version:
 */
public class DataReportConfigFunSelect {
    /**
     * 组件id
     */
    private String componentId;
    /**
     * 功能id
     */
    private String funId;
    /**
     * 功能名称
     */
    private String name;

    public String getComponentId() {
        return componentId;
    }

    public DataReportConfigFunSelect setComponentId(String componentId) {
        this.componentId = componentId;
        return this;
    }

    public String getFunId() {
        return funId;
    }

    public DataReportConfigFunSelect setFunId(String funId) {
        this.funId = funId;
        return this;
    }

    public String getName() {
        return name;
    }

    public DataReportConfigFunSelect setName(String name) {
        this.name = name;
        return this;
    }
}
