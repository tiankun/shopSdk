package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 代表名册人员列表(DelegateRosterUser)Form
 *
 * @author makejava
 * @since 2020-11-19 17:15:35
 */
public class DelegateRosterUserForm {
    public static class Add {
        /**
         * 代表名册ID
         */
        private Long rosterId;
        /**
         * 导入记录ID(t_import_template.id)
         */
        private Long recordId;
        /**
         * 姓名
         */
        private String name;
        /**
         * 工作单位及职务
         */
        private String workUnit;
        /**
         * 民族
         */
        private String nation;
        /**
         * 籍贯
         */
        private String nativePlace;
        /**
         * 出生日期
         */
        private Date birthday;
        /**
         * 身份证号码
         */
        private String idCardNo;
        /**
         * 参加工作时间
         */
        private Date workDate;
        /**
         * 学历
         */
        private String education;
        /**
         * 党派
         */
        private String parties;
        /**
         * 职称
         */
        private String title;
        /**
         * 手机号码
         */
        private String mobile;
        /**
         * 备注
         */
        private String remark;
        /**
         * 创建时间
         */
        private Date createTime;
        /**
         * 修改时间
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

        private Long nationDictId;

        private Long educationDictId;

        private Long partiesDictId;

        public Long getRosterId() {
            return rosterId;
        }

        public void setRosterId(Long rosterId) {
            this.rosterId = rosterId;
        }

        public Long getRecordId() {
            return recordId;
        }

        public void setRecordId(Long recordId) {
            this.recordId = recordId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getWorkUnit() {
            return workUnit;
        }

        public void setWorkUnit(String workUnit) {
            this.workUnit = workUnit;
        }

        public String getNation() {
            return nation;
        }

        public void setNation(String nation) {
            this.nation = nation;
        }

        public String getNativePlace() {
            return nativePlace;
        }

        public void setNativePlace(String nativePlace) {
            this.nativePlace = nativePlace;
        }

        public Date getBirthday() {
            return birthday;
        }

        public void setBirthday(Date birthday) {
            this.birthday = birthday;
        }

        public String getIdCardNo() {
            return idCardNo;
        }

        public void setIdCardNo(String idCardNo) {
            this.idCardNo = idCardNo;
        }

        public Date getWorkDate() {
            return workDate;
        }

        public void setWorkDate(Date workDate) {
            this.workDate = workDate;
        }

        public String getEducation() {
            return education;
        }

        public void setEducation(String education) {
            this.education = education;
        }

        public String getParties() {
            return parties;
        }

        public void setParties(String parties) {
            this.parties = parties;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Date createTime) {
            this.createTime = createTime;
        }

        public Date getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Date updateTime) {
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

        public void setAreaCode(String areaCode) {
            this.areaCode = areaCode;
        }

        public String getAreaName() {
            return areaName;
        }

        public void setAreaName(String areaName) {
            this.areaName = areaName;
        }

        public String getOrgId() {
            return orgId;
        }

        public void setOrgId(String orgId) {
            this.orgId = orgId;
        }

        public String getOrgName() {
            return orgName;
        }

        public void setOrgName(String orgName) {
            this.orgName = orgName;
        }

        public String getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(String departmentId) {
            this.departmentId = departmentId;
        }

        public String getDeptName() {
            return deptName;
        }

        public void setDeptName(String deptName) {
            this.deptName = deptName;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Long getNationDictId() {
            return nationDictId;
        }

        public void setNationDictId(Long nationDictId) {
            this.nationDictId = nationDictId;
        }

        public Long getEducationDictId() {
            return educationDictId;
        }

        public void setEducationDictId(Long educationDictId) {
            this.educationDictId = educationDictId;
        }

        public Long getPartiesDictId() {
            return partiesDictId;
        }

        public void setPartiesDictId(Long partiesDictId) {
            this.partiesDictId = partiesDictId;
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
        private String name;
        private String mobile;
        private Long rosterId;

        public Long getRosterId() {
            return rosterId;
        }

        public Search setRosterId(Long rosterId) {
            this.rosterId = rosterId;
            return this;
        }

        public String getName() {
            return name;
        }

        public Search setName(String name) {
            this.name = name;
            return this;
        }

        public String getMobile() {
            return mobile;
        }

        public Search setMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }
    }

    public static class Get{
        private Long id;

        private Long rosterId;

        private String mobile;

        private String idCardNo;

        public Long getId() {
            return id;
        }

        public Get setId(Long id) {
            this.id = id;
            return this;
        }

        public Long getRosterId() {
            return rosterId;
        }

        public Get setRosterId(Long rosterId) {
            this.rosterId = rosterId;
            return this;
        }

        public String getMobile() {
            return mobile;
        }

        public Get setMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public String getIdCardNo() {
            return idCardNo;
        }

        public Get setIdCardNo(String idCardNo) {
            this.idCardNo = idCardNo;
            return this;
        }
    }

    public static class BatchDel extends CommonForm.BatchDel{
        private Long rosterId;

        public Long getRosterId() {
            return rosterId;
        }

        public void setRosterId(Long rosterId) {
            this.rosterId = rosterId;
        }
    }

}