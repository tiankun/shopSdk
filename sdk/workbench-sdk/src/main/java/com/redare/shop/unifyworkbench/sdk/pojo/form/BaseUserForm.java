package com.redare.shop.unifyworkbench.sdk.pojo.form;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @description: Base_user实体类
 * @author: zhangsq
 * @date: Created in 2020-10-19 14:18
 * @return:
 * @exception:
 */
public class BaseUserForm {

    /**
     * @description: 添加
     * @author: zhangsq
     * @date: Created in 2020-10-19 14:35
     * @return:
     * @exception:
     */
    public static class Add{
        /**
         * '用户ID'
         */
        private Long userId;
        /**
         * '性别'
         */
        private String name;
        /**
         * '手机号'
         */
        private String mobile;
        /**
         * '邮箱'
         */
        private String email;
        /**
         * '头像'
         */
        private String photo;
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
         * '创建时间'
         */
        private Date createTime;
        /**
         * '更新时间'
         */
        private Date updateTime;
        /**
         * '备注'
         */
        private String remark;

        /**
         * '岗位信息'
         */
        private List<UserOrgForm.Add> userOrgList;

        /**
         * 荣誉信息
         */
        private List<UserHonorForm.Add> userHonorList;

        public Long getUserId() {
            return userId;
        }

        public Add setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public String getName() {
            return name;
        }

        public Add setName(String name) {
            this.name = name;
            return this;
        }

        public String getMobile() {
            return mobile;
        }

        public Add setMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public String getEmail() {
            return email;
        }

        public Add setEmail(String email) {
            this.email = email;
            return this;
        }

        public String getPhoto() {
            return photo;
        }

        public Add setPhoto(String photo) {
            this.photo = photo;
            return this;
        }

        public Integer getUserType() {
            return userType;
        }

        public Add setUserType(Integer userType) {
            this.userType = userType;
            return this;
        }

        public Long getSexId() {
            return sexId;
        }

        public Add setSexId(Long sexId) {
            this.sexId = sexId;
            return this;
        }

        public String getSex() {
            return sex;
        }

        public Add setSex(String sex) {
            this.sex = sex;
            return this;
        }

        public Long getNationId() {
            return nationId;
        }

        public Add setNationId(Long nationId) {
            this.nationId = nationId;
            return this;
        }

        public String getNation() {
            return nation;
        }

        public Add setNation(String nation) {
            this.nation = nation;
            return this;
        }

        public Date getBirthday() {
            return birthday;
        }

        public Add setBirthday(Date birthday) {
            this.birthday = birthday;
            return this;
        }

        public String getCardNo() {
            return cardNo;
        }

        public Add setCardNo(String cardNo) {
            this.cardNo = cardNo;
            return this;
        }

        public Long getPoliticId() {
            return politicId;
        }

        public Add setPoliticId(Long politicId) {
            this.politicId = politicId;
            return this;
        }

        public String getPolitic() {
            return politic;
        }

        public Add setPolitic(String politic) {
            this.politic = politic;
            return this;
        }

        public Date getPartyDate() {
            return partyDate;
        }

        public Add setPartyDate(Date partyDate) {
            this.partyDate = partyDate;
            return this;
        }

        public String getNativePlace() {
            return nativePlace;
        }

        public Add setNativePlace(String nativePlace) {
            this.nativePlace = nativePlace;
            return this;
        }

        public String getWorkUnit() {
            return workUnit;
        }

        public Add setWorkUnit(String workUnit) {
            this.workUnit = workUnit;
            return this;
        }

        public String getWechatId() {
            return wechatId;
        }

        public Add setWechatId(String wechatId) {
            this.wechatId = wechatId;
            return this;
        }

        public Integer getUnitPositionId() {
            return unitPositionId;
        }

        public Add setUnitPositionId(Integer unitPositionId) {
            this.unitPositionId = unitPositionId;
            return this;
        }

        public String getUnitPosition() {
            return unitPosition;
        }

        public Add setUnitPosition(String unitPosition) {
            this.unitPosition = unitPosition;
            return this;
        }

        public Integer getEducationId() {
            return educationId;
        }

        public Add setEducationId(Integer educationId) {
            this.educationId = educationId;
            return this;
        }

        public String getEducation() {
            return education;
        }

        public Add setEducation(String education) {
            this.education = education;
            return this;
        }

        public String getSchool() {
            return school;
        }

        public Add setSchool(String school) {
            this.school = school;
            return this;
        }

        public String getMajor() {
            return major;
        }

        public Add setMajor(String major) {
            this.major = major;
            return this;
        }

        public Date getGraduationTime() {
            return graduationTime;
        }

        public Add setGraduationTime(Date graduationTime) {
            this.graduationTime = graduationTime;
            return this;
        }

        public String getOnJob() {
            return onJob;
        }

        public Add setOnJob(String onJob) {
            this.onJob = onJob;
            return this;
        }

        public String getHealth() {
            return health;
        }

        public Add setHealth(String health) {
            this.health = health;
            return this;
        }

        public String getResumeUrl() {
            return resumeUrl;
        }

        public Add setResumeUrl(String resumeUrl) {
            this.resumeUrl = resumeUrl;
            return this;
        }

        public Integer getDel() {
            return del;
        }

        public Add setDel(Integer del) {
            this.del = del;
            return this;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public Add setCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public Date getUpdateTime() {
            return updateTime;
        }

        public Add setUpdateTime(Date updateTime) {
            this.updateTime = updateTime;
            return this;
        }

        public String getRemark() {
            return remark;
        }

        public Add setRemark(String remark) {
            this.remark = remark;
            return this;
        }

        public List<UserOrgForm.Add> getUserOrgList() {
            return userOrgList;
        }

        public Add setUserOrgList(List<UserOrgForm.Add> userOrgList) {
            this.userOrgList = userOrgList;
            return this;
        }

        public List<UserHonorForm.Add> getUserHonorList() {
            return userHonorList;
        }

        public Add setUserHonorList(List<UserHonorForm.Add> userHonorList) {
            this.userHonorList = userHonorList;
            return this;
        }
    }
    /**
     * @description: 搜索
     * @author: zhangsq
     * @date: Created in 2020-10-19 15:55
     * @return:
     * @exception:
     */
    public static class Search{
        /**
         * '用户ID'
         */
        private Long userId;
        /**
         * 关键字
         */
        private String key;
        private String name;
        private String mobile;
        private String orgId;
        private String deptId;
        private String deptName;
        private String userPlatform;
        private String areaCode;
        private List<String> orgIds;
        private List<Integer> positionIds;

        private Integer del;

        public Long getUserId() {
            return userId;
        }

        public Search setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public String getKey() {
            return key;
        }

        public Search setKey(String key) {
            this.key = key;
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

        public String getOrgId() {
            return orgId;
        }

        public Search setOrgId(String orgId) {
            this.orgId = orgId;
            return this;
        }

        public String getDeptId() {
            return deptId;
        }

        public Search setDeptId(String deptId) {
            this.deptId = deptId;
            return this;
        }

        public String getDeptName() {
            return deptName;
        }

        public Search setDeptName(String deptName) {
            this.deptName = deptName;
            return this;
        }

        public String getUserPlatform() {
            return userPlatform;
        }

        public Search setUserPlatform(String userPlatform) {
            this.userPlatform = userPlatform;
            return this;
        }

        public String getAreaCode() {
            return areaCode;
        }

        public Search setAreaCode(String areaCode) {
            this.areaCode = areaCode;
            return this;
        }

        public Integer getDel() {
            return del;
        }

        public Search setDel(Integer del) {
            this.del = del;
            return this;
        }

        public List<String> getOrgIds() {
            return orgIds;
        }

        public Search setOrgIds(List<String> orgIds) {
            this.orgIds = orgIds;
            return this;
        }

        public List<Integer> getPositionIds() {
            return positionIds;
        }

        public Search setPositionIds(List<Integer> positionIds) {
            this.positionIds = positionIds;
            return this;
        }
    }

    /**
     * @description: 编辑
     * @author: zhangsq
     * @date: Created in 2020-10-19 15:32
     * @return:
     * @exception:
     */
    public static class Edit {
        /**
         * '用户ID'
         */
        private Long userId;
        /**
         * '性别'
         */
        private String name;
        /**
         * '手机号'
         */
        private String mobile;
        /**
         * '邮箱'
         */
        private String email;
        /**
         * '头像'
         */
        private String photo;
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
         * '创建时间'
         */
        private Date createTime;
        /**
         * '更新时间'
         */
        private Date updateTime;
        /**
         * '备注'
         */
        private String remark;

        /**
         * '岗位信息'
         */
        private List<UserOrgForm.Add> userOrgList;

        /**
         * 荣誉信息
         */
        private List<UserHonorForm.Add> userHonorList;

        public Long getUserId() {
            return userId;
        }

        public Edit setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public String getName() {
            return name;
        }

        public Edit setName(String name) {
            this.name = name;
            return this;
        }

        public String getMobile() {
            return mobile;
        }

        public Edit setMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public String getEmail() {
            return email;
        }

        public Edit setEmail(String email) {
            this.email = email;
            return this;
        }

        public String getPhoto() {
            return photo;
        }

        public Edit setPhoto(String photo) {
            this.photo = photo;
            return this;
        }

        public Integer getUserType() {
            return userType;
        }

        public Edit setUserType(Integer userType) {
            this.userType = userType;
            return this;
        }

        public Long getSexId() {
            return sexId;
        }

        public Edit setSexId(Long sexId) {
            this.sexId = sexId;
            return this;
        }

        public String getSex() {
            return sex;
        }

        public Edit setSex(String sex) {
            this.sex = sex;
            return this;
        }

        public Long getNationId() {
            return nationId;
        }

        public Edit setNationId(Long nationId) {
            this.nationId = nationId;
            return this;
        }

        public String getNation() {
            return nation;
        }

        public Edit setNation(String nation) {
            this.nation = nation;
            return this;
        }

        public Date getBirthday() {
            return birthday;
        }

        public Edit setBirthday(Date birthday) {
            this.birthday = birthday;
            return this;
        }

        public String getCardNo() {
            return cardNo;
        }

        public Edit setCardNo(String cardNo) {
            this.cardNo = cardNo;
            return this;
        }

        public Long getPoliticId() {
            return politicId;
        }

        public Edit setPoliticId(Long politicId) {
            this.politicId = politicId;
            return this;
        }

        public String getPolitic() {
            return politic;
        }

        public Edit setPolitic(String politic) {
            this.politic = politic;
            return this;
        }

        public Date getPartyDate() {
            return partyDate;
        }

        public Edit setPartyDate(Date partyDate) {
            this.partyDate = partyDate;
            return this;
        }

        public String getNativePlace() {
            return nativePlace;
        }

        public Edit setNativePlace(String nativePlace) {
            this.nativePlace = nativePlace;
            return this;
        }

        public String getWorkUnit() {
            return workUnit;
        }

        public Edit setWorkUnit(String workUnit) {
            this.workUnit = workUnit;
            return this;
        }

        public String getWechatId() {
            return wechatId;
        }

        public Edit setWechatId(String wechatId) {
            this.wechatId = wechatId;
            return this;
        }

        public Integer getUnitPositionId() {
            return unitPositionId;
        }

        public Edit setUnitPositionId(Integer unitPositionId) {
            this.unitPositionId = unitPositionId;
            return this;
        }

        public String getUnitPosition() {
            return unitPosition;
        }

        public Edit setUnitPosition(String unitPosition) {
            this.unitPosition = unitPosition;
            return this;
        }

        public Integer getEducationId() {
            return educationId;
        }

        public Edit setEducationId(Integer educationId) {
            this.educationId = educationId;
            return this;
        }

        public String getEducation() {
            return education;
        }

        public Edit setEducation(String education) {
            this.education = education;
            return this;
        }

        public String getSchool() {
            return school;
        }

        public Edit setSchool(String school) {
            this.school = school;
            return this;
        }

        public String getMajor() {
            return major;
        }

        public Edit setMajor(String major) {
            this.major = major;
            return this;
        }

        public Date getGraduationTime() {
            return graduationTime;
        }

        public Edit setGraduationTime(Date graduationTime) {
            this.graduationTime = graduationTime;
            return this;
        }

        public String getOnJob() {
            return onJob;
        }

        public Edit setOnJob(String onJob) {
            this.onJob = onJob;
            return this;
        }

        public String getHealth() {
            return health;
        }

        public Edit setHealth(String health) {
            this.health = health;
            return this;
        }

        public String getResumeUrl() {
            return resumeUrl;
        }

        public Edit setResumeUrl(String resumeUrl) {
            this.resumeUrl = resumeUrl;
            return this;
        }

        public Integer getDel() {
            return del;
        }

        public Edit setDel(Integer del) {
            this.del = del;
            return this;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public Edit setCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public Date getUpdateTime() {
            return updateTime;
        }

        public Edit setUpdateTime(Date updateTime) {
            this.updateTime = updateTime;
            return this;
        }

        public String getRemark() {
            return remark;
        }

        public Edit setRemark(String remark) {
            this.remark = remark;
            return this;
        }

        public List<UserOrgForm.Add> getUserOrgList() {
            return userOrgList;
        }

        public Edit setUserOrgList(List<UserOrgForm.Add> userOrgList) {
            this.userOrgList = userOrgList;
            return this;
        }

        public List<UserHonorForm.Add> getUserHonorList() {
            return userHonorList;
        }

        public Edit setUserHonorList(List<UserHonorForm.Add> userHonorList) {
            this.userHonorList = userHonorList;
            return this;
        }
    }

    /**
     * @description: 查询
     * @author: zhangsq
     * @date: Created in 2020-10-19 15:20
     * @return:
     * @exception:
     */
    public static class Get {
        private Long userId;

        private String cardNo;

        private Integer del;

        public Long getUserId() {
            return userId;
        }

        public Get setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public String getCardNo() {
            return cardNo;
        }

        public Get setCardNo(String cardNo) {
            this.cardNo = cardNo;
            return this;
        }

        public Integer getDel() {
            return del;
        }

        public Get setDel(Integer del) {
            this.del = del;
            return this;
        }
    }

    /**
     * @description: 删除或批量删除
     * @author: zhangsq
     * @date: Created in 2020-10-19 15:20
     * @return:
     * @exception:
     */
    public static class BatchDel {
        /**
         * '用户ID'
         */
        @NotEmpty(message = "主键不能为空")
        List<Long> userIdList;

        public List<Long> getUserIdList() {
            return userIdList;
        }

        public BatchDel setUserIdList(List<Long> userIdList) {
            this.userIdList = userIdList;
            return this;
        }
    }

    public static class Pwd {
        @NotNull(
                message = "账号ID不能为空"
        )
        private Long accountId;
        private String platform;
        private String userPlatform;
        @NotNull(
                message = "密码不能为空"
        )
        @Length(
                max = 40,
                message = "密码不能超过40个字符"
        )
        private String pwd;
        private Boolean needResetPwd;

        public Long getAccountId() {
            return accountId;
        }

        public Pwd setAccountId(Long accountId) {
            this.accountId = accountId;
            return this;
        }

        public String getPlatform() {
            return platform;
        }

        public Pwd setPlatform(String platform) {
            this.platform = platform;
            return this;
        }

        public String getUserPlatform() {
            return userPlatform;
        }

        public Pwd setUserPlatform(String userPlatform) {
            this.userPlatform = userPlatform;
            return this;
        }

        public String getPwd() {
            return pwd;
        }

        public Pwd setPwd(String pwd) {
            this.pwd = pwd;
            return this;
        }

        public Boolean getNeedResetPwd() {
            return needResetPwd;
        }

        public Pwd setNeedResetPwd(Boolean needResetPwd) {
            this.needResetPwd = needResetPwd;
            return this;
        }
    }
}
