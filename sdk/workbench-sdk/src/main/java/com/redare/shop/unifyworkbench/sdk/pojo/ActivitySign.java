package com.redare.shop.unifyworkbench.sdk.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * (ActivitySign)实体类
 *
 * @author dengchj
 * @since 2020-10-20 17:34:16
 */
public class ActivitySign implements Serializable {
    private static final long serialVersionUID = 710533984039721070L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 人员id
     */
    private Integer userId;
    /**
     * 人员姓名
     */
    private String userName;
    /**
     * 部门id
     */
    private String depId;
    /**
     * 部门名称
     */
    private String depName;
    /**
     * 组织id
     */
    private String orgId;
    /**
     * 组织名称
     */
    private String orgName;
    /**
     * 行政编码
     */
    private String areaCode;
    /**
     * 行政区域名称
     */
    private String areaName;
    /**
     * 性别
     */
    private String sex;
    /**
     * 联系方式
     */
    private String telphone;
    /**
     * 任职时间
     */
    private Date postDate;
    /**
     * 签到时间
     */
    private Date signTime;
    /**
     * 出生日期
     */
    private Date birthDate;
    /**
     * 文化水平
     */
    private String educationLevel;
    /**
     * 状态
     */
    private String status;
    /**
     * 人员类型：0-内部 ,1-群众
     */
    private String type;
    private  int manCount;//签到人员统计
    private Long activityId;//活动Id;
    private  String postion;//职位
    private String activityTitle;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserid(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepid(String depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepname(String depName) {
        this.depName = depName;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostdate(Date postDate) {
        this.postDate = postDate;
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSigntime(Date signTime) {
        this.signTime = signTime;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthdate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationlevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getManCount() {
        return manCount;
    }

    public ActivitySign setManCount(int manCount) {
        this.manCount = manCount;
        return this;
    }

    public Long getActivityId() {
        return activityId;
    }

    public ActivitySign setActivityId(Long activityId) {
        this.activityId = activityId;
        return this;
    }

    public String getPostion() {
        return postion;
    }

    public ActivitySign setPostion(String postion) {
        this.postion = postion;
        return this;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public ActivitySign setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
        return this;
    }
}