package com.redare.shop.unifyworkbench.sdk.pojo;

import java.util.Date;

/**
 * @description: 数据报表配置
 * @author: zlx
 * @date: Created in 2020/9/8 10:54
 * @version:
 */
public class DataReportConfig {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 报表名称
     */
    private String reportName;
    /**
     * 报表分类
     */
    private String type;
    /**
     * 报表分类名称
     */
    private String typeName;
    /**
     * 访问链接
     */
    private String url;
    /**
     * 图标
     */
    private String icon;
    /**
     * 功能权限id
     */
    private String funId;
    /**
     * 操作人id
     */
    private Long userId;
    /**
     * 操作人姓名
     */
    private String userName;
    /**
     * 报表排序
     */
    private Integer sort;
    /**
     * 报表分类排序
     */
    private Integer dicSort;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    public Integer getSort() {
        return sort;
    }

    public DataReportConfig setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public Integer getDicSort() {
        return dicSort;
    }

    public DataReportConfig setDicSort(Integer dicSort) {
        this.dicSort = dicSort;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public DataReportConfig setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public DataReportConfig setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public DataReportConfig setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Long getId() {
        return id;
    }

    public DataReportConfig setId(Long id) {
        this.id = id;
        return this;
    }

    public String getReportName() {
        return reportName;
    }

    public DataReportConfig setReportName(String reportName) {
        this.reportName = reportName;
        return this;
    }

    public String getType() {
        return type;
    }

    public DataReportConfig setType(String type) {
        this.type = type;
        return this;
    }

    public String getTypeName() {
        return typeName;
    }

    public DataReportConfig setTypeName(String typeName) {
        this.typeName = typeName;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public DataReportConfig setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public DataReportConfig setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public String getFunId() {
        return funId;
    }

    public DataReportConfig setFunId(String funId) {
        this.funId = funId;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public DataReportConfig setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }
}
