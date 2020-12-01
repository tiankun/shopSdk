package com.redare.shop.unifyworkbench.sdk.pojo;

import java.util.Date;

/**
 * 专栏配置表
 */
public class ColumnConfig {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 配置标题
     */
    private String title;
    /**
     * 配置板块
     */
    private String configPlate;
    /**
     * 链接
     */
    private String url;
    /**
     * 封面
     */
    private String cover;
    /**
     * 配置时间
     */
    private Date createTime;
    /**
     * @description: 排序
     * @author: zhangsq
     * @date: Created in 2020-07-15 17:43
     */
    private Integer sort;

    public Long getId() {
        return id;
    }

    public ColumnConfig setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ColumnConfig setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getConfigPlate() {
        return configPlate;
    }

    public ColumnConfig setConfigPlate(String configPlate) {
        this.configPlate = configPlate;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public ColumnConfig setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getCover() {
        return cover;
    }

    public ColumnConfig setCover(String cover) {
        this.cover = cover;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public ColumnConfig setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public ColumnConfig setSort(Integer sort) {
        this.sort = sort;
        return this;
    }
}
