package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 上报表(Report)Form
 *
 * @author makejava
 * @since 2020-10-21 17:41:22
 */
public class ReportForm {

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


        private Long id;
        /**
         * 上报标题
         */
        private String title;
        /**
         * 上报类型编码
         */
        private String reportTypeCode;
        /**
         * 上报类型名称
         */
        private String reportTypeName;
        /**
         * 上报人员
         */
        private Long reportUserId;
        /**
         * 上报人员名称
         */
        private String reportUserName;
        /**
         * 上报情况说明
         */
        private String description;
        /**
         * 图片
         */
        private String images;
        /**
         * 附件
         */
        private String files;
        /**
         * 创建时间
         */
        private Date createTime;
        /**
         * 更新时间
         */
        private Date updateTime;
        /**
         * 状态0：未完成，1：已完成，-1：删除
         */
        private Integer status;
        /**
         * 上报状态0：未上报，1：已上报
         */
        private Integer reportStatus;
        /**
         * 上报时间
         */
        private Date reportTime;
        /**
         * 行政编码 t_area.areaCode
         */
        private String areaCode;
        /**
         * 行政区域名称 t_area.areaName
         */
        private String areaName;
        /**
         * 组织机构Id t_organization.orgId
         */
        private String orgId;
        /**
         * 机构名称 t_area.orgName
         */
        private String orgName;
        /**
         * 组织机构id t_department.departmentId
         */
        private String departmentId;
        /**
         * 部门名称 t_department.deptName
         */
        private String deptName;
        /**
         * 操作人员id
         */
        private Long userId;
        /**
         * 操作人员名称
         */
        private String userName;

        public Long getId() {
            return id;
        }

        public Search setId(Long id) {
            this.id = id;
            return this;
        }

        public String getTitle() {
            return title;
        }

        public Search setTitle(String title) {
            this.title = title;
            return this;
        }

        public String getReportTypeCode() {
            return reportTypeCode;
        }

        public Search setReportTypeCode(String reportTypeCode) {
            this.reportTypeCode = reportTypeCode;
            return this;
        }

        public String getReportTypeName() {
            return reportTypeName;
        }

        public Search setReportTypeName(String reportTypeName) {
            this.reportTypeName = reportTypeName;
            return this;
        }

        public Long getReportUserId() {
            return reportUserId;
        }

        public Search setReportUserId(Long reportUserId) {
            this.reportUserId = reportUserId;
            return this;
        }

        public String getReportUserName() {
            return reportUserName;
        }

        public Search setReportUserName(String reportUserName) {
            this.reportUserName = reportUserName;
            return this;
        }

        public String getDescription() {
            return description;
        }

        public Search setDescription(String description) {
            this.description = description;
            return this;
        }

        public String getImages() {
            return images;
        }

        public Search setImages(String images) {
            this.images = images;
            return this;
        }

        public String getFiles() {
            return files;
        }

        public Search setFiles(String files) {
            this.files = files;
            return this;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public Search setCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public Date getUpdateTime() {
            return updateTime;
        }

        public Search setUpdateTime(Date updateTime) {
            this.updateTime = updateTime;
            return this;
        }

        public Integer getStatus() {
            return status;
        }

        public Search setStatus(Integer status) {
            this.status = status;
            return this;
        }

        public Integer getReportStatus() {
            return reportStatus;
        }

        public Search setReportStatus(Integer reportStatus) {
            this.reportStatus = reportStatus;
            return this;
        }

        public Date getReportTime() {
            return reportTime;
        }

        public Search setReportTime(Date reportTime) {
            this.reportTime = reportTime;
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

        public String getDepartmentId() {
            return departmentId;
        }

        public Search setDepartmentId(String departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public String getDeptName() {
            return deptName;
        }

        public Search setDeptName(String deptName) {
            this.deptName = deptName;
            return this;
        }

        public Long getUserId() {
            return userId;
        }

        public Search setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public String getUserName() {
            return userName;
        }

        public Search setUserName(String userName) {
            this.userName = userName;
            return this;
        }
    }

}