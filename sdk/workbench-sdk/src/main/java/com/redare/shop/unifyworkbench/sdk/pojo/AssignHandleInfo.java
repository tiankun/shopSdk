package com.redare.shop.unifyworkbench.sdk.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 交办办理情况表(AssignHandleInfo)实体类
 *
 * @author makejava
 * @since 2020-10-28 10:15:39
 */
public class AssignHandleInfo implements Serializable {
    private static final long serialVersionUID = 950435571691732234L;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAssignId() {
        return assignId;
    }

    public void setAssignid(Long assignId) {
        this.assignId = assignId;
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

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public Integer getAssignStatus() {
        return assignStatus;
    }

    public void setAssignstatus(Integer assignStatus) {
        this.assignStatus = assignStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Date getPlanEndDate() {
        return planEndDate;
    }

    public void setPlanenddate(Date planEndDate) {
        this.planEndDate = planEndDate;
    }

    public String getAssignOrgId() {
        return assignOrgId;
    }

    public void setAssignorgid(String assignOrgId) {
        this.assignOrgId = assignOrgId;
    }

    public String getAssignOrgName() {
        return assignOrgName;
    }

    public void setAssignorgname(String assignOrgName) {
        this.assignOrgName = assignOrgName;
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