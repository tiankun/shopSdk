package com.redare.shop.unifyworkbench.sdk.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 代表名册人员列表(DelegateRosterUser)实体类
 *
 * @author makejava
 * @since 2020-11-19 17:15:34
 */
public class DelegateRosterUser implements Serializable {
    private static final long serialVersionUID = 713319471519157271L;
    /**
     * 主键
     */
    private Long id;
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
     * 民族字典ID
     */
    private Long nationDictId;
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
     * 学历字典ID
     */
    private Long educationDictId;
    /**
     * 学历
     */
    private String education;
    /**
     * 党派字典ID
     */
    private String partiesDictId;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRosterId() {
        return rosterId;
    }

    public void setRosterid(Long rosterId) {
        this.rosterId = rosterId;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordid(Long recordId) {
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

    public void setWorkunit(String workUnit) {
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

    public void setNativeplace(String nativePlace) {
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

    public void setIdcardno(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkdate(Date workDate) {
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