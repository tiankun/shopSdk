package com.redare.shop.unifyworkbench.sdk.pojo;

import java.io.Serializable;

/**
 * 行政区域编码表(Area)实体类
 *
 * @author yanggr
 * @since 2020-10-21 15:05:08
 */
public class Area implements Serializable {
    private static final long serialVersionUID = 516258706967813496L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 行政编码
     */
    private String areaCode;
    /**
     * 行政区域名称
     */
    private String areaName;
    /**
     * 行政父级编码
     */
    private String parentCode;
    /**
     * 行政区域级别
     */
    private Integer level;
    /**
     * 是否叶子
     */
    private Integer leaf;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 行政区域的管理列表
     */
    private String areaManageUserIdList;
    /**
     * 行政区域Id层级标识
     */
    private String areaIdTag;
    /**
     * 行政区域IDLevel
     */
    private String areaIdLevel;
    /**
     * 行政区域名称层级
     */
    private String areaNameLevel;
    /**
     * 组织id(扩展属性)
     */
    private String orgId;
    /**
     * 组织名称（扩展属性）
     */
    private String orgName;
    /**
     * 组织类型id(扩展属性)
     */
    private String orgTypeCode;
    /**
     * 组织类型名称（扩展属性）
     */
    private String orgTypeName;
    /**
     * 组织分类（扩展属性）
     */
    private String orgClassify;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreacode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaname(String areaName) {
        this.areaName = areaName;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentcode(String parentCode) {
        this.parentCode = parentCode;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getLeaf() {
        return leaf;
    }

    public void setLeaf(Integer leaf) {
        this.leaf = leaf;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getAreaManageUserIdList() {
        return areaManageUserIdList;
    }

    public void setAreamanageuseridlist(String areaManageUserIdList) {
        this.areaManageUserIdList = areaManageUserIdList;
    }

    public String getAreaIdTag() {
        return areaIdTag;
    }

    public void setAreaidtag(String areaIdTag) {
        this.areaIdTag = areaIdTag;
    }

    public String getAreaIdLevel() {
        return areaIdLevel;
    }

    public void setAreaidlevel(String areaIdLevel) {
        this.areaIdLevel = areaIdLevel;
    }

    public String getAreaNameLevel() {
        return areaNameLevel;
    }

    public void setAreanamelevel(String areaNameLevel) {
        this.areaNameLevel = areaNameLevel;
    }


    public String getOrgId() {
        return orgId;
    }

    public Area setOrgId(String orgId) {
        this.orgId = orgId;
        return this;
    }

    public String getOrgName() {
        return orgName;
    }

    public Area setOrgName(String orgName) {
        this.orgName = orgName;
        return this;
    }

    public String getOrgTypeCode() {
        return orgTypeCode;
    }

    public Area setOrgTypeCode(String orgTypeCode) {
        this.orgTypeCode = orgTypeCode;
        return this;
    }

    public String getOrgTypeName() {
        return orgTypeName;
    }

    public Area setOrgTypeName(String orgTypeName) {
        this.orgTypeName = orgTypeName;
        return this;
    }

    public String getOrgClassify() {
        return orgClassify;
    }

    public Area setOrgClassify(String orgClassify) {
        this.orgClassify = orgClassify;
        return this;
    }
}