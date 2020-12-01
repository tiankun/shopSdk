package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * 交办办理情况表(AssignHandleInfo)Form
 *
 * @author makejava
 * @since 2020-10-28 10:15:41
 */
public class AssignHandleInfoForm {

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
         * 交办id
         */
        private Long assignId;
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
         * 办理情况说明
         */
        private String situation;
        /**
         * 交办状态0：待办，1：已交办，2：已完成
         */
        private Integer assignStatus;
        /**
         * 状态0：进行中，1：已完成，-1：删除
         */
        private Integer status;
        /**
         * 图片
         */
        private String images;
        /**
         * 附件
         */
        private String files;
        /**
         * 计划完成时间
         */
        private Date planEndDate;
        /**
         * 交办组织
         */
        private String assignOrgId;
        /**
         * 交办组织名称
         */
        private String assignOrgName;
        /**
         * 创建时间
         */
        private Date createTime;
        /**
         * 更新时间
         */
        private Date updateTime;
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

        private List<Integer> assignStatusList;

        public Long getId() {
            return id;
        }

        public Search setId(Long id) {
            this.id = id;
            return this;
        }

        public Long getAssignId() {
            return assignId;
        }

        public Search setAssignId(Long assignId) {
            this.assignId = assignId;
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

        public String getSituation() {
            return situation;
        }

        public Search setSituation(String situation) {
            this.situation = situation;
            return this;
        }

        public Integer getAssignStatus() {
            return assignStatus;
        }

        public Search setAssignStatus(Integer assignStatus) {
            this.assignStatus = assignStatus;
            return this;
        }

        public Integer getStatus() {
            return status;
        }

        public Search setStatus(Integer status) {
            this.status = status;
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

        public Date getPlanEndDate() {
            return planEndDate;
        }

        public Search setPlanEndDate(Date planEndDate) {
            this.planEndDate = planEndDate;
            return this;
        }

        public String getAssignOrgId() {
            return assignOrgId;
        }

        public Search setAssignOrgId(String assignOrgId) {
            this.assignOrgId = assignOrgId;
            return this;
        }

        public String getAssignOrgName() {
            return assignOrgName;
        }

        public Search setAssignOrgName(String assignOrgName) {
            this.assignOrgName = assignOrgName;
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

        public List<Integer> getAssignStatusList() {
            return assignStatusList;
        }

        public Search setAssignStatusList(List<Integer> assignStatusList) {
            this.assignStatusList = assignStatusList;
            return this;
        }
    }

}