package com.redare.shop.unifyworkbench.sdk.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 上报表(Report)实体类
 *
 * @author makejava
 * @since 2020-10-21 17:41:21
 */
public class Report implements Serializable {
    private static final long serialVersionUID = -87738036602052826L;

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

    private String handleOrgId;

    private Integer handleState;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReportTypeCode() {
        return reportTypeCode;
    }

    public void setReporttypecode(String reportTypeCode) {
        this.reportTypeCode = reportTypeCode;
    }

    public String getReportTypeName() {
        return reportTypeName;
    }

    public void setReporttypename(String reportTypeName) {
        this.reportTypeName = reportTypeName;
    }

    public Long getReportUserId() {
        return reportUserId;
    }

    public void setReportuserid(Long reportUserId) {
        this.reportUserId = reportUserId;
    }

    public String getReportUserName() {
        return reportUserName;
    }

    public void setReportusername(String reportUserName) {
        this.reportUserName = reportUserName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
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

    public Integer getReportStatus() {
        return reportStatus;
    }

    public void setReportstatus(Integer reportStatus) {
        this.reportStatus = reportStatus;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReporttime(Date reportTime) {
        this.reportTime = reportTime;
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

    public String getHandleOrgId() {
        return handleOrgId;
    }

    public void setHandleOrgId(String handleOrgId) {
        this.handleOrgId = handleOrgId;
    }

    public Integer getHandleState() {
        return handleState;
    }

    public void setHandleState(Integer handleState) {
        this.handleState = handleState;
    }
}