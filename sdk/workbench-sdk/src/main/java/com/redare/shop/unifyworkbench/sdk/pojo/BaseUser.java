package com.redare.shop.unifyworkbench.sdk.pojo;

import com.redare.devframework.webplatform.sdk.core.pojo.User;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @description: Base_user实体类
 * @author: zhangsq
 * @date: Created in 2020-10-19 10:10
 * @return:
 * @exception:
 */
public class BaseUser extends User implements Serializable {
    /**
     * '人员类型（0-管理账号类型，1-普通用户类型）'
     */
    private Integer userType;
    /**
     * 性别Id(字典表id)
     */
    private Long sexId;
    /**
     * '性别'
     */
    private String sex;
    /**
     * '民族Id(字典表id)'
     */
    private Long nationId;
    /**
     * '民族'
     */
    private String nation;
    /**
     * '出生日期'
     */
    private Date birthday;
    /**
     * '身份证号'
     */
    private String cardNo;
    /**
     * '政治面貌(字典表id)'
     */
    private Long politicId;
    /**
     * '政治面貌'
     */
    private String  politic;
    /**
     * '入党时间'
     */
    private Date partyDate;
    /**
     * '籍贯'
     */
    private String nativePlace;
    /**
     * '工作单位'
     */
    private String workUnit;
    /**
     * '微信号'
     */
    private String wechatId;
    /**
     * '单位职位Id(字典表id)'
     */
    private Integer unitPositionId;
    /**
     * '单位职位'
     */
    private String unitPosition;
    /**
     * '学历Id(字典表id)'
     */
    private Integer educationId;
    /**
     * '最高学历'
     */
    private String education;
    /**
     * '毕业学校'
     */
    private String school;
    /**
     * '所学专业'
     */
    private String major;
    /**
     * '毕业时间'
     */
    private Date graduationTime;
    /**
     * '在职状态'
     */
    private String onJob;
    /**
     * '健康状况'
     */
    private String health;
    /**
     * '员工照片url'
     */
    private String resumeUrl;
    /**
     * 是否删除0:正常,1:删除
     */
    private Integer del;

    /**
     * '备注'
     */
    private String remark;

    /**
     * '岗位信息'
     */
    private List<UserOrg> userOrgList;

    /**
     * 荣誉信息
     */
    private List<UserHonor> userHonorList;

    private String orgId;
    private String orgName;
    /**
     * 上级纵向组织id
     */
    private String orgParentId;
    /**
     *  上级纵向组织name
     */
    private String orgParentName;
    /**
     * 上级区域或当前区域接收组织id
     */
    private String receiveOrgId;
    /**
     * 上级区域或当前区域接收组织名称
     */
    private String receiveOrgName;
    private String deptId;
    private String deptName;
    private Integer womenPositionId;
    private String womenPosition;
    private Date servedTime;

    public Integer getUserType() {
        return userType;
    }

    public BaseUser setUserType(Integer userType) {
        this.userType = userType;
        return this;
    }

    public Long getSexId() {
        return sexId;
    }

    public void setSexId(Long sexId) {
        this.sexId = sexId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Long getNationId() {
        return nationId;
    }

    public void setNationId(Long nationId) {
        this.nationId = nationId;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Long getPoliticId() {
        return politicId;
    }

    public void setPoliticId(Long politicId) {
        this.politicId = politicId;
    }

    public String getPolitic() {
        return politic;
    }

    public void setPolitic(String politic) {
        this.politic = politic;
    }

    public Date getPartyDate() {
        return partyDate;
    }

    public void setPartyDate(Date partyDate) {
        this.partyDate = partyDate;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public Integer getUnitPositionId() {
        return unitPositionId;
    }

    public void setUnitPositionId(Integer unitPositionId) {
        this.unitPositionId = unitPositionId;
    }

    public String getUnitPosition() {
        return unitPosition;
    }

    public void setUnitPosition(String unitPosition) {
        this.unitPosition = unitPosition;
    }

    public Integer getEducationId() {
        return educationId;
    }

    public void setEducationId(Integer educationId) {
        this.educationId = educationId;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Date getGraduationTime() {
        return graduationTime;
    }

    public void setGraduationTime(Date graduationTime) {
        this.graduationTime = graduationTime;
    }

    public String getOnJob() {
        return onJob;
    }

    public void setOnJob(String onJob) {
        this.onJob = onJob;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getResumeUrl() {
        return resumeUrl;
    }

    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }



    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<UserOrg> getUserOrgList() {
        return userOrgList;
    }

    public void setUserOrgList(List<UserOrg> userOrgList) {
        this.userOrgList = userOrgList;
    }

    public List<UserHonor> getUserHonorList() {
        return userHonorList;
    }

    public void setUserHonorList(List<UserHonor> userHonorList) {
        this.userHonorList = userHonorList;
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

    public String getOrgParentId() {
        return orgParentId;
    }

    public void setOrgParentId(String orgParentId) {
        this.orgParentId = orgParentId;
    }

    public String getOrgParentName() {
        return orgParentName;
    }

    public void setOrgParentName(String orgParentName) {
        this.orgParentName = orgParentName;
    }

    public String getReceiveOrgId() {
        return receiveOrgId;
    }

    public void setReceiveOrgId(String receiveOrgId) {
        this.receiveOrgId = receiveOrgId;
    }

    public String getReceiveOrgName() {
        return receiveOrgName;
    }

    public void setReceiveOrgName(String receiveOrgName) {
        this.receiveOrgName = receiveOrgName;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getWomenPositionId() {
        return womenPositionId;
    }

    public void setWomenPositionId(Integer womenPositionId) {
        this.womenPositionId = womenPositionId;
    }

    public String getWomenPosition() {
        return womenPosition;
    }

    public void setWomenPosition(String womenPosition) {
        this.womenPosition = womenPosition;
    }

    public Date getServedTime() {
        return servedTime;
    }

    public void setServedTime(Date servedTime) {
        this.servedTime = servedTime;
    }
}
