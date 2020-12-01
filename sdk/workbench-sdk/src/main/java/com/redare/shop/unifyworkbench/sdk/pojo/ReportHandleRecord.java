package com.redare.shop.unifyworkbench.sdk.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 上报处理记录表(ReportHandleRecord)实体类
 *
 * @author makejava
 * @since 2020-10-21 14:14:23
 */
public class ReportHandleRecord implements Serializable {
    private static final long serialVersionUID = -50380946718527233L;

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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportid(Long reportId) {
        this.reportId = reportId;
    }

    public String getHandleOrgId() {
        return handleOrgId;
    }

    public void setHandleorgid(String handleOrgId) {
        this.handleOrgId = handleOrgId;
    }

    public String getHandleOrgName() {
        return handleOrgName;
    }

    public void setHandleorgname(String handleOrgName) {
        this.handleOrgName = handleOrgName;
    }

    public Long getHandleUserId() {
        return handleUserId;
    }

    public void setHandleuserid(Long handleUserId) {
        this.handleUserId = handleUserId;
    }

    public String getHandleUserName() {
        return handleUserName;
    }

    public void setHandleusername(String handleUserName) {
        this.handleUserName = handleUserName;
    }

    public Integer getHandleState() {
        return handleState;
    }

    public void setHandlestate(Integer handleState) {
        this.handleState = handleState;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getHandleResult() {
        return handleResult;
    }

    public void setHandleresult(String handleResult) {
        this.handleResult = handleResult;
    }

    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
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