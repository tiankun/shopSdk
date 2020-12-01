package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/11/19 17:38
 * @version:
 */
public class ImportPersonnelInfoForm {

    public static class Search{
        private String key;
        private String name;
        private String mobile;
        private String orgId;
        private Integer status;
        private String importType;
        private Long recordId;
        private String rosterId;
        private String rosterName;
        private String areaCode;
        private String areaName;
        private Long userId;
        private String userName;

        public String getImportType() {
            return importType;
        }

        public Search setImportType(String importType) {
            this.importType = importType;
            return this;
        }

        public Integer getStatus() {
            return status;
        }

        public Search setStatus(Integer status) {
            this.status = status;
            return this;
        }

        public String getOrgId() {
            return orgId;
        }

        public Search setOrgId(String orgId) {
            this.orgId = orgId;
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

        public Long getRecordId() {
            return recordId;
        }

        public Search setRecordId(Long recordId) {
            this.recordId = recordId;
            return this;
        }

        public String getRosterId() {
            return rosterId;
        }

        public Search setRosterId(String rosterId) {
            this.rosterId = rosterId;
            return this;
        }

        public String getRosterName() {
            return rosterName;
        }

        public Search setRosterName(String rosterName) {
            this.rosterName = rosterName;
            return this;
        }

        public String getAreaCode() {
            return areaCode;
        }

        public Search setAreaCode(String areaCode) {
            this.areaCode = areaCode;
            return this;
        }

        public String getAreaName() {
            return areaName;
        }

        public Search setAreaName(String areaName) {
            this.areaName = areaName;
            return this;
        }

        public Long getUserId() {
            return userId;
        }

        public Search setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public String getUserName() {
            return userName;
        }

        public Search setUserName(String userName) {
            this.userName = userName;
            return this;
        }
    }

    public static class Add{
        private String orgId;
        private String orgName;
        private String rosterId;
        private String rosterName;
        private String name;
        private Date birthday;
        private String cardNo;
        private String sex;
        private String nativePlace;
        private Integer nationId;
        private String nation;
        private Integer politicId;
        private String politic;
        private Date partyDate;
        private String deptName;
        private String position;
        private Integer positionId;
        private String positionType;
        private Date positionTime;
        private Integer educationId;
        private String education;
        private String school;
        private String major;
        private Date graduationTime;
        private String mobile;
        private String weChat;
        private String email;
        private String unit;
        private String unitPosition;
        private Date servedTime;
        private String deputy;
        private String honour;
        private Long recordId;
        private Integer changeAccount;
        private String importType;
        private Date createTime;
        private Date updateTime;
        private Integer status;
        private String remark;
        private String deptId;
        private String positionTypeCode;
        private String areaCode;
        private String areaName;
        private Long userId;
        private String userName;

        public String getPositionTypeCode() {
            return positionTypeCode;
        }

        public Add setPositionTypeCode(String positionTypeCode) {
            this.positionTypeCode = positionTypeCode;
            return this;
        }

        public String getDeptId() {
            return deptId;
        }

        public void setDeptId(String deptId) {
            this.deptId = deptId;
        }

        public String getOrgId() {
            return orgId;
        }

        public Add setOrgId(String orgId) {
            this.orgId = orgId;
            return this;
        }

        public String getOrgName() {
            return orgName;
        }

        public Add setOrgName(String orgName) {
            this.orgName = orgName;
            return this;
        }

        public String getName() {
            return name;
        }

        public Add setName(String name) {
            this.name = name;
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

        public String getSex() {
            return sex;
        }

        public Add setSex(String sex) {
            this.sex = sex;
            return this;
        }

        public String getNativePlace() {
            return nativePlace;
        }

        public Add setNativePlace(String nativePlace) {
            this.nativePlace = nativePlace;
            return this;
        }

        public Integer getNationId() {
            return nationId;
        }

        public Add setNationId(Integer nationId) {
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

        public Integer getPoliticId() {
            return politicId;
        }

        public Add setPoliticId(Integer politicId) {
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

        public String getDeptName() {
            return deptName;
        }

        public Add setDeptName(String deptName) {
            this.deptName = deptName;
            return this;
        }

        public String getPosition() {
            return position;
        }

        public Add setPosition(String position) {
            this.position = position;
            return this;
        }

        public Integer getPositionId() {
            return positionId;
        }

        public Add setPositionId(Integer positionId) {
            this.positionId = positionId;
            return this;
        }

        public String getPositionType() {
            return positionType;
        }

        public Add setPositionType(String positionType) {
            this.positionType = positionType;
            return this;
        }

        public Date getPositionTime() {
            return positionTime;
        }

        public Add setPositionTime(Date positionTime) {
            this.positionTime = positionTime;
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

        public String getMobile() {
            return mobile;
        }

        public Add setMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public String getWeChat() {
            return weChat;
        }

        public Add setWeChat(String weChat) {
            this.weChat = weChat;
            return this;
        }

        public String getEmail() {
            return email;
        }

        public Add setEmail(String email) {
            this.email = email;
            return this;
        }

        public String getUnit() {
            return unit;
        }

        public Add setUnit(String unit) {
            this.unit = unit;
            return this;
        }

        public String getUnitPosition() {
            return unitPosition;
        }

        public Add setUnitPosition(String unitPosition) {
            this.unitPosition = unitPosition;
            return this;
        }

        public Date getServedTime() {
            return servedTime;
        }

        public Add setServedTime(Date servedTime) {
            this.servedTime = servedTime;
            return this;
        }

        public String getDeputy() {
            return deputy;
        }

        public Add setDeputy(String deputy) {
            this.deputy = deputy;
            return this;
        }

        public String getHonour() {
            return honour;
        }

        public Add setHonour(String honour) {
            this.honour = honour;
            return this;
        }

        public Long getRecordId() {
            return recordId;
        }

        public Add setRecordId(Long recordId) {
            this.recordId = recordId;
            return this;
        }

        public Integer getChangeAccount() {
            return changeAccount;
        }

        public Add setChangeAccount(Integer changeAccount) {
            this.changeAccount = changeAccount;
            return this;
        }

        public String getImportType() {
            return importType;
        }

        public Add setImportType(String importType) {
            this.importType = importType;
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

        public Integer getStatus() {
            return status;
        }

        public Add setStatus(Integer status) {
            this.status = status;
            return this;
        }

        public String getRemark() {
            return remark;
        }

        public Add setRemark(String remark) {
            this.remark = remark;
            return this;
        }

        public String getRosterId() {
            return rosterId;
        }

        public Add setRosterId(String rosterId) {
            this.rosterId = rosterId;
            return this;
        }

        public String getRosterName() {
            return rosterName;
        }

        public Add setRosterName(String rosterName) {
            this.rosterName = rosterName;
            return this;
        }

        public String getAreaCode() {
            return areaCode;
        }

        public Add setAreaCode(String areaCode) {
            this.areaCode = areaCode;
            return this;
        }

        public String getAreaName() {
            return areaName;
        }

        public Add setAreaName(String areaName) {
            this.areaName = areaName;
            return this;
        }

        public Long getUserId() {
            return userId;
        }

        public Add setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public String getUserName() {
            return userName;
        }

        public Add setUserName(String userName) {
            this.userName = userName;
            return this;
        }
    }

    public static class Edit{
        @NotNull(message = "主键id不能为空")
        private Long id;
        private String orgId;
        private String orgName;
        private String rosterId;
        private String rosterName;
        private String name;
        private Date birthday;
        private String cardNo;
        private String sex;
        private String nativePlace;
        private Integer nationId;
        private String nation;
        private Integer politicId;
        private String politic;
        private Date partyDate;
        private String deptName;
        private String position;
        private Integer positionId;
        private String positionType;
        private Date positionTime;
        private Integer educationId;
        private String education;
        private String school;
        private String major;
        private Date graduationTime;
        private String mobile;
        private String weChat;
        private String email;
        private String unit;
        private String unitPosition;
        private Date servedTime;
        private String deputy;
        private String honour;
        private Long recordId;
        private Integer changeAccount;
        private String importType;
        private Date createTime;
        private Date updateTime;
        private Integer status;
        private String remark;
        private String deptId;
        private String positionTypeCode;
        private String areaCode;
        private String areaName;
        private Long userId;
        private String userName;

        public String getPositionTypeCode() {
            return positionTypeCode;
        }

        public Edit setPositionTypeCode(String positionTypeCode) {
            this.positionTypeCode = positionTypeCode;
            return this;
        }

        public String getDeptId() {
            return deptId;
        }

        public Edit setDeptId(String deptId) {
            this.deptId = deptId;
            return this;
        }

        public Long getId() {
            return id;
        }

        public Edit setId(Long id) {
            this.id = id;
            return this;
        }

        public String getOrgId() {
            return orgId;
        }

        public Edit setOrgId(String orgId) {
            this.orgId = orgId;
            return this;
        }

        public String getOrgName() {
            return orgName;
        }

        public Edit setOrgName(String orgName) {
            this.orgName = orgName;
            return this;
        }

        public String getName() {
            return name;
        }

        public Edit setName(String name) {
            this.name = name;
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

        public String getSex() {
            return sex;
        }

        public Edit setSex(String sex) {
            this.sex = sex;
            return this;
        }

        public String getNativePlace() {
            return nativePlace;
        }

        public Edit setNativePlace(String nativePlace) {
            this.nativePlace = nativePlace;
            return this;
        }

        public Integer getNationId() {
            return nationId;
        }

        public Edit setNationId(Integer nationId) {
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

        public Integer getPoliticId() {
            return politicId;
        }

        public Edit setPoliticId(Integer politicId) {
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

        public String getDeptName() {
            return deptName;
        }

        public Edit setDeptName(String deptName) {
            this.deptName = deptName;
            return this;
        }

        public String getPosition() {
            return position;
        }

        public Edit setPosition(String position) {
            this.position = position;
            return this;
        }

        public Integer getPositionId() {
            return positionId;
        }

        public Edit setPositionId(Integer positionId) {
            this.positionId = positionId;
            return this;
        }

        public String getPositionType() {
            return positionType;
        }

        public Edit setPositionType(String positionType) {
            this.positionType = positionType;
            return this;
        }

        public Date getPositionTime() {
            return positionTime;
        }

        public Edit setPositionTime(Date positionTime) {
            this.positionTime = positionTime;
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

        public String getMobile() {
            return mobile;
        }

        public Edit setMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public String getWeChat() {
            return weChat;
        }

        public Edit setWeChat(String weChat) {
            this.weChat = weChat;
            return this;
        }

        public String getEmail() {
            return email;
        }

        public Edit setEmail(String email) {
            this.email = email;
            return this;
        }

        public String getUnit() {
            return unit;
        }

        public Edit setUnit(String unit) {
            this.unit = unit;
            return this;
        }

        public String getUnitPosition() {
            return unitPosition;
        }

        public Edit setUnitPosition(String unitPosition) {
            this.unitPosition = unitPosition;
            return this;
        }

        public Date getServedTime() {
            return servedTime;
        }

        public Edit setServedTime(Date servedTime) {
            this.servedTime = servedTime;
            return this;
        }

        public String getDeputy() {
            return deputy;
        }

        public Edit setDeputy(String deputy) {
            this.deputy = deputy;
            return this;
        }

        public String getHonour() {
            return honour;
        }

        public Edit setHonour(String honour) {
            this.honour = honour;
            return this;
        }

        public Long getRecordId() {
            return recordId;
        }

        public Edit setRecordId(Long recordId) {
            this.recordId = recordId;
            return this;
        }

        public Integer getChangeAccount() {
            return changeAccount;
        }

        public Edit setChangeAccount(Integer changeAccount) {
            this.changeAccount = changeAccount;
            return this;
        }

        public String getImportType() {
            return importType;
        }

        public Edit setImportType(String importType) {
            this.importType = importType;
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

        public Integer getStatus() {
            return status;
        }

        public Edit setStatus(Integer status) {
            this.status = status;
            return this;
        }

        public String getRemark() {
            return remark;
        }

        public Edit setRemark(String remark) {
            this.remark = remark;
            return this;
        }

        public String getRosterId() {
            return rosterId;
        }

        public Edit setRosterId(String rosterId) {
            this.rosterId = rosterId;
            return this;
        }

        public String getRosterName() {
            return rosterName;
        }

        public Edit setRosterName(String rosterName) {
            this.rosterName = rosterName;
            return this;
        }

        public String getAreaCode() {
            return areaCode;
        }

        public Edit setAreaCode(String areaCode) {
            this.areaCode = areaCode;
            return this;
        }

        public String getAreaName() {
            return areaName;
        }

        public Edit setAreaName(String areaName) {
            this.areaName = areaName;
            return this;
        }

        public Long getUserId() {
            return userId;
        }

        public Edit setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public String getUserName() {
            return userName;
        }

        public Edit setUserName(String userName) {
            this.userName = userName;
            return this;
        }
    }

    public static class Get{
        @NotNull(message = "主键id不能为空")
        private Long id;

        public Long getId() {
            return id;
        }

        public Get setId(Long id) {
            this.id = id;
            return this;
        }
    }

    public static class Del{
        @NotNull(message = "主键id不能为空")
        private Long id;

        public Long getId() {
            return id;
        }

        public Del setId(Long id) {
            this.id = id;
            return this;
        }
    }

    /**
     * 批量删除（逻辑删除）
     */
    public static class BatchDel{
        private List<Long> ids;
        private String rosterId;

        public List<Long> getIds() {
            return ids;
        }

        public BatchDel setIds(List<Long> ids) {
            this.ids = ids;
            return this;
        }

        public String getRosterId() {
            return rosterId;
        }

        public BatchDel setRosterId(String rosterId) {
            this.rosterId = rosterId;
            return this;
        }
    }
}
