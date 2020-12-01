package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 上报处理记录表(ReportHandleRecord)Form
 *
 * @author makejava
 * @since 2020-10-21 14:14:23
 */
public class ReportHandleRecordForm {

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
         * 上报id
         */
        private Long reportId;
        /**
         * 处理单位
         */
        private String handleOrgId;
        /**
         * 处理单位名称
         */
        private String handleOrgName;
        /**
         * 处理人
         */
        private Long handleUserId;
        /**
         * 处理人名称
         */
        private String handleUserName;
        /**
         * 处理状态0:处理中，1:继续上报，2:已完成
         */
        private Integer handleState;
        /**
         * 处理意见
         */
        private String comment;
        /**
         * 处理结果
         */
        private String handleResult;
        /**
         * 附件
         */
        private String attachments;
        /**
         * 创建时间
         */
        private Date createTime;
        /**
         * 更新时间
         */
        private Date updateTime;
        /**
         * 状态0：正常，-1：删除
         */
        private Integer status;
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

        public Long getReportId() {
            return reportId;
        }

        public Search setReportId(Long reportId) {
            this.reportId = reportId;
            return this;
        }

        public String getHandleOrgId() {
            return handleOrgId;
        }

        public Search setHandleOrgId(String handleOrgId) {
            this.handleOrgId = handleOrgId;
            return this;
        }

        public String getHandleOrgName() {
            return handleOrgName;
        }

        public Search setHandleOrgName(String handleOrgName) {
            this.handleOrgName = handleOrgName;
            return this;
        }

        public Long getHandleUserId() {
            return handleUserId;
        }

        public Search setHandleUserId(Long handleUserId) {
            this.handleUserId = handleUserId;
            return this;
        }

        public String getHandleUserName() {
            return handleUserName;
        }

        public Search setHandleUserName(String handleUserName) {
            this.handleUserName = handleUserName;
            return this;
        }

        public Integer getHandleState() {
            return handleState;
        }

        public Search setHandleState(Integer handleState) {
            this.handleState = handleState;
            return this;
        }

        public String getComment() {
            return comment;
        }

        public Search setComment(String comment) {
            this.comment = comment;
            return this;
        }

        public String getHandleResult() {
            return handleResult;
        }

        public Search setHandleResult(String handleResult) {
            this.handleResult = handleResult;
            return this;
        }

        public String getAttachments() {
            return attachments;
        }

        public Search setAttachments(String attachments) {
            this.attachments = attachments;
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