package com.redare.shop.unifyworkbench.sdk.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassifyManage
 * 表（t_classify_manage）
 *
 * @Author zlx
 * @Date 2020/5/9 11:53
 */
public class ClassifyManage implements Serializable {

    /**
     * 主键id
     */
    private Long id;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 父级id
     */
    private Long parentId;
    /**
     * 是否是叶子\n0:不是\n1:是
     */
    private Integer leaf;
    /**
     * 是否删除1:删除;0:未删除
     */
    private Integer del;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 创建时间
     */
    private Date createTime;

    public Long getId() {
        return id;
    }

    public ClassifyManage setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ClassifyManage setName(String name) {
        this.name = name;
        return this;
    }

    public Long getParentId() {
        return parentId;
    }

    public ClassifyManage setParentId(Long parentId) {
        this.parentId = parentId;
        return this;
    }

    public Integer getLeaf() {
        return leaf;
    }

    public ClassifyManage setLeaf(Integer leaf) {
        this.leaf = leaf;
        return this;
    }

    public Integer getDel() {
        return del;
    }

    public ClassifyManage setDel(Integer del) {
        this.del = del;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public ClassifyManage setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public ClassifyManage setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }
}
