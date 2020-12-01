package com.redare.shop.unifyworkbench.sdk.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 活动管理(Activity)实体类
 *
 * @author dengchj
 * @since 2020-10-19 18:02:44
 */
public class Activity implements Serializable {
    private static final long serialVersionUID = 487797085874898611L;
    /**
     * 主键Id
     */
    private Long id;
    /**
     * 活动名称
     */
    private String title;
    /**
     * 活动地点
     */
    private String place;
    /**
     * 活动开始时间
     */
    private Date beginDate;
    /**
     * 活动结束时间
     */
    private Date endDate;
    /**
     * 活动类型
     */
    private String activityType;
    /**
     * 主题类型
     */
    private String trainType;
    /**
     * 组织Id
     */
    private String orgId;
    /**
     * 组织名称
     */
    private String orgName;
    /**
     * 部门Id
     */
    private String departId;
    /**
     * 部门名称
     */
    private String departName;
    /**
     * 行政编码
     */
    private String areaCode;
    /**
     * 行政区域名称
     */
    private String areaName;
    /**
     * 预计参与人数
     */
    private Integer joinCount;
    /**
     * 负责人Id
     */
    private Integer leaderId;
    /**
     * 负责人名称
     */
    private String leaderName;
    /**
     * 负责人电话
     */
    private String telphone;
    /**
     * 操作人Id
     */
    private Integer createUserId;
    /**
     * 操作人名称
     */
    private String createUserName;
    /**
     * 操作时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 上线情况;0-上线，1-下线
     */
    private Integer status;
    /**
     * 描述
     */
    private String description;
    /**
     * 活动状态:0-未开始，1-进行中，2-已结束
     */
    private String zt;
    private String picture;

    private List<ActivityAttachment> attachmentList;
    private  int activityCount;
    private List<ActivityAttachment> imageList;
    private List<ActivityAttachment> videoList;
    private Integer top;//置顶
    private  Integer sort;//排序
    private  String signUrl;//签到二维码地址



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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
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

    public String getActivityType() {
        return activityType;
    }

    public void setActivitytype(String activityType) {
        this.activityType = activityType;
    }

    public String getTrainType() {
        return trainType;
    }

    public void setTraintype(String trainType) {
        this.trainType = trainType;
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

    public String getDepartId() {
        return departId;
    }

    public void setDepartid(String departId) {
        this.departId = departId;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartname(String departName) {
        this.departName = departName;
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

    public Integer getJoinCount() {
        return joinCount;
    }

    public void setJoincount(Integer joinCount) {
        this.joinCount = joinCount;
    }

    public Integer getLeaderId() {
        return leaderId;
    }

    public void setLeaderid(Integer leaderId) {
        this.leaderId = leaderId;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeadername(String leaderName) {
        this.leaderName = leaderName;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateuserid(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateusername(String createUserName) {
        this.createUserName = createUserName;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public List<ActivityAttachment> getAttachmentList() {
        return attachmentList;
    }

    public Activity setAttachmentList(List<ActivityAttachment> attachmentList) {
        this.attachmentList = attachmentList;
        return this;
    }

    public int getActivityCount() {
        return activityCount;
    }

    public Activity setActivityCount(int activityCount) {
        this.activityCount = activityCount;
        return this;
    }

    public List<ActivityAttachment> getImageList() {
        return imageList;
    }

    public Activity setImageList(List<ActivityAttachment> imageList) {
        this.imageList = imageList;
        return this;
    }

    public List<ActivityAttachment> getVideoList() {
        return videoList;
    }

    public Activity setVideoList(List<ActivityAttachment> videoList) {
        this.videoList = videoList;
        return this;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getSignUrl() {
        return signUrl;
    }

    public void setSignUrl(String signUrl) {
        this.signUrl = signUrl;
    }
}
