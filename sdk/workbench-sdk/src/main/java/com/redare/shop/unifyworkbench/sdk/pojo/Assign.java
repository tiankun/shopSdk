package com.redare.shop.unifyworkbench.sdk.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 交办表(Assign)实体类
 *
 * @author makejava
 * @since 2020-10-22 14:31:36
 */
public class Assign implements Serializable {
    private static final long serialVersionUID = -65370058862224540L;

    private Long id;
    /**
     * 上级id
     */
    private Long pid;
    /**
     * 交办编号
     */
    private String assignCode;
    /**
     * 交办标题
     */
    private String title;
    /**
     * 交办类型编码
     */
    private String typeCode;
    /**
     * 交办类型名称
     */
    private String typeName;
    /**
     * 交办描述
     */
    private String content;
    /**
     * 交办意见
     */
    private String attention;
    /**
     * 开始日期
     */
    private Date beginDate;
    /**
     * 结束日期
     */
    private Date endDate;
    /**
     * 交办人
     */
    private Long assignUserId;
    /**
     * 交办人名称
     */
    private String assignUserName;
    /**
     * 交办组织
     */
    private String assignOrgId;
    /**
     * 交办组织名称
     */
    private String assignOrgName;
    /***
     * 是否发送短信
     */
    private Integer sendMsg;
    /**
     * 承办组织
     */
    private String underTakeOrgIds;
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
     * 状态0:未完成，1：已完成，-1：删除
     */
    private Integer status;
    /**
     * 交办状态0:未交办，1:已交办
     */
    private Integer assignStatus;
    /**
     * 交办时间
     */
    private Date assignTime;
    /**
     * 交办任务办结时间
     */
    private Date finishTime;

    /**
     * 上级行政编码 t_area.areaCode
     */
    private String parentAreaCode;
    /**
     * 上级行政区域名称 t_area.areaName
     */
    private String parentAreaName;
    /**
     * 上级组织机构Id t_organization.orgId
     */
    private String parentOrgId;
    /**
     * 上级机构名称 t_area.orgName
     */
    private String parentOrgName;
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
    /**
     * 交办状态0：待办，1：已交办，2：已完成，3：下级承办单位都完成
     */
    private Integer handleStatus;
    /**
     * 下级组织是否全部完成
     */
    private Integer state;
    /**
     * 短信发送职位
     */
    private List<Integer> positionIds;
    /**
     * 职位ID
     */
    private String postIds;


    public Integer getHandleStatus() {
        return handleStatus;
    }

    public void setHandleStatus(Integer handleStatus) {
        this.handleStatus = handleStatus;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getAssignCode() {
        return assignCode;
    }

    public void setAssignCode(String assignCode) {
        this.assignCode = assignCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBegindate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEnddate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getAssignUserId() {
        return assignUserId;
    }

    public void setAssignuserid(Long assignUserId) {
        this.assignUserId = assignUserId;
    }

    public String getAssignUserName() {
        return assignUserName;
    }

    public void setAssignusername(String assignUserName) {
        this.assignUserName = assignUserName;
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

    public String getUnderTakeOrgIds() {
        return underTakeOrgIds;
    }

    public void setUnderTakeOrgIds(String underTakeOrgIds) {
        this.underTakeOrgIds = underTakeOrgIds;
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

    public Integer getAssignStatus() {
        return assignStatus;
    }

    public void setAssignstatus(Integer assignStatus) {
        this.assignStatus = assignStatus;
    }

    public Date getAssignTime() {
        return assignTime;
    }

    public void setAssigntime(Date assignTime) {
        this.assignTime = assignTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getParentAreaCode() {
        return parentAreaCode;
    }

    public void setParentareacode(String parentAreaCode) {
        this.parentAreaCode = parentAreaCode;
    }

    public String getParentAreaName() {
        return parentAreaName;
    }

    public void setParentareaname(String parentAreaName) {
        this.parentAreaName = parentAreaName;
    }

    public String getParentOrgId() {
        return parentOrgId;
    }

    public void setParentorgid(String parentOrgId) {
        this.parentOrgId = parentOrgId;
    }

    public String getParentOrgName() {
        return parentOrgName;
    }

    public void setParentorgname(String parentOrgName) {
        this.parentOrgName = parentOrgName;
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

    public Integer getSendMsg() {
        return sendMsg;
    }

    public void setSendMsg(Integer sendMsg) {
        this.sendMsg = sendMsg;
    }

    public List<Integer> getPositionIds() {
        return positionIds;
    }

    public void setPositionIds(List<Integer> positionIds) {
        this.positionIds = positionIds;
    }

    public String getPostIds() {
        return postIds;
    }

    public void setPostIds(String postIds) {
        this.postIds = postIds;
    }
}