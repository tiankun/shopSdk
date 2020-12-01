package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotNull;

/**
 * 行政区域编码表(Area)Form
 *
 * @author yanggr
 * @since 2020-10-21 15:05:09
 */
public class AreaForm {

    public static class Edit extends CommonForm.Del {
        @NotNull(message = "状态不能为空")
        private Integer status;

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }
    }

    public static class Search extends CommonForm.Search {

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

        public Search setId(Long id) {
            this.id = id;
            return this;
        }

        public String getAreaCode() {
            return areaCode;
        }

        public Search setAreaCode(String areaCode) {
            this.areaCode = areaCode;
            return this;
        }

        public String getAreaName() {
            return areaName;
        }

        public Search setAreaName(String areaName) {
            this.areaName = areaName;
            return this;
        }

        public String getParentCode() {
            return parentCode;
        }

        public Search setParentCode(String parentCode) {
            this.parentCode = parentCode;
            return this;
        }

        public Integer getLevel() {
            return level;
        }

        public Search setLevel(Integer level) {
            this.level = level;
            return this;
        }

        public Integer getLeaf() {
            return leaf;
        }

        public Search setLeaf(Integer leaf) {
            this.leaf = leaf;
            return this;
        }

        public Integer getSort() {
            return sort;
        }

        public Search setSort(Integer sort) {
            this.sort = sort;
            return this;
        }

        public String getAreaManageUserIdList() {
            return areaManageUserIdList;
        }

        public Search setAreaManageUserIdList(String areaManageUserIdList) {
            this.areaManageUserIdList = areaManageUserIdList;
            return this;
        }

        public String getAreaIdTag() {
            return areaIdTag;
        }

        public Search setAreaIdTag(String areaIdTag) {
            this.areaIdTag = areaIdTag;
            return this;
        }

        public String getAreaIdLevel() {
            return areaIdLevel;
        }

        public Search setAreaIdLevel(String areaIdLevel) {
            this.areaIdLevel = areaIdLevel;
            return this;
        }

        public String getAreaNameLevel() {
            return areaNameLevel;
        }

        public Search setAreaNameLevel(String areaNameLevel) {
            this.areaNameLevel = areaNameLevel;
            return this;
        }

        public String getOrgId() {
            return orgId;
        }

        public Search setOrgId(String orgId) {
            this.orgId = orgId;
            return this;
        }

        public String getOrgName() {
            return orgName;
        }

        public Search setOrgName(String orgName) {
            this.orgName = orgName;
            return this;
        }

        public String getOrgTypeCode() {
            return orgTypeCode;
        }

        public Search setOrgTypeCode(String orgTypeCode) {
            this.orgTypeCode = orgTypeCode;
            return this;
        }

        public String getOrgTypeName() {
            return orgTypeName;
        }

        public Search setOrgTypeName(String orgTypeName) {
            this.orgTypeName = orgTypeName;
            return this;
        }

        public String getOrgClassify() {
            return orgClassify;
        }

        public Search setOrgClassify(String orgClassify) {
            this.orgClassify = orgClassify;
            return this;
        }
    }

    public static class Get{

        private Long id;
        private String areaCode;

        public Long getId() {
            return id;
        }

        public Get setId(Long id) {
            this.id = id;
            return this;
        }

        public String getAreaCode() {
            return areaCode;
        }

        public Get setAreaCode(String areaCode) {
            this.areaCode = areaCode;
            return this;
        }
    }

}