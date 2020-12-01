package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * (DelegateRoster)Form
 *
 * @author makejava
 * @since 2020-11-19 17:12:59
 */
public class DelegateRosterForm {
    public static class Add {
        /**
         * 名称
         */
        private String name;
        /**
         * 备注
         */
        private String remark;
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
         * 状态0:正常，-1：删除
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getFiles() {
            return files;
        }

        public void setFiles(String files) {
            this.files = files;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public void setCreatetime(Date createTime) {
            this.createTime = createTime;
        }

        public Date getUpdateTime() {
            return updateTime;
        }

        public void setUpdatetime(Date updateTime) {
            this.updateTime = updateTime;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
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

        public String getOrgId() {
            return orgId;
        }

        public void setOrgid(String orgId) {
            this.orgId = orgId;
        }

        public String getOrgName() {
            return orgName;
        }

        public void setOrgname(String orgName) {
            this.orgName = orgName;
        }

        public String getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentid(String departmentId) {
            this.departmentId = departmentId;
        }

        public String getDeptName() {
            return deptName;
        }

        public void setDeptname(String deptName) {
            this.deptName = deptName;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserid(Long userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUsername(String userName) {
            this.userName = userName;
        }

    }

    public static class Edit extends Add {
        @NotNull(message = "主键不能为空")
        private Long id;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }

    public static class EditStatus extends CommonForm.Del {
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
        private String orgId;

        public String getOrgId() {
            return orgId;
        }

        public Search setOrgId(String orgId) {
            this.orgId = orgId;
            return this;
        }

        private String areaCode;

        public String getAreaCode() {
            return areaCode;
        }

        public Search setAreaCode(String areaCode) {
            this.areaCode = areaCode;
            return this;
        }
    }

}