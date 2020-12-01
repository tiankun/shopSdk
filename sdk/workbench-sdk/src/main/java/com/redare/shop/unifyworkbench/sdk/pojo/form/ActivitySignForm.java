package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * (ActivitySign)Form
 *
 * @author dengchj
 * @since 2020-10-20 17:34:17
 */
public class ActivitySignForm {

    public static class Edit extends CommonForm.Del {
        @NotNull(message = "状态不能为空")
        private Integer status;

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }
    }

    public static class Search extends CommonForm.Search {

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
         * 人员类型：0-内部 ,1-群众,2-巾帼志愿者
         */
        private String type;
        private Long activityId;

        public Integer getId() {
            return id;
        }

        public Search setId(Integer id) {
            this.id = id;
            return this;
        }

        public Integer getUserId() {
            return userId;
        }

        public Search setUserId(Integer userId) {
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

        public String getDepId() {
            return depId;
        }

        public Search setDepId(String depId) {
            this.depId = depId;
            return this;
        }

        public String getDepName() {
            return depName;
        }

        public Search setDepName(String depName) {
            this.depName = depName;
            return this;
        }

        public String getOrgId() {
            return orgId;
        }

        public Search setOrgId(String orgId) {
            this.orgId = orgId;
            return this;
        }

        public String getOrgName() {
            return orgName;
        }

        public Search setOrgName(String orgName) {
            this.orgName = orgName;
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

        public String getSex() {
            return sex;
        }

        public Search setSex(String sex) {
            this.sex = sex;
            return this;
        }

        public String getTelphone() {
            return telphone;
        }

        public Search setTelphone(String telphone) {
            this.telphone = telphone;
            return this;
        }

        public Date getPostDate() {
            return postDate;
        }

        public Search setPostDate(Date postDate) {
            this.postDate = postDate;
            return this;
        }

        public Date getSignTime() {
            return signTime;
        }

        public Search setSignTime(Date signTime) {
            this.signTime = signTime;
            return this;
        }

        public Date getBirthDate() {
            return birthDate;
        }

        public Search setBirthDate(Date birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public String getEducationLevel() {
            return educationLevel;
        }

        public Search setEducationLevel(String educationLevel) {
            this.educationLevel = educationLevel;
            return this;
        }

        public String getStatus() {
            return status;
        }

        public Search setStatus(String status) {
            this.status = status;
            return this;
        }

        public String getType() {
            return type;
        }

        public Search setType(String type) {
            this.type = type;
            return this;
        }

        public Long getActivityId() {
            return activityId;
        }

        public Search setActivityId(Long activityId) {
            this.activityId = activityId;
            return this;
        }
    }

    public static class ImportForm {
        private String excelPath;
        private Long activityId;
        private String type;

        public String getExcelPath() {
            return excelPath;
        }

        public ImportForm setExcelPath(String excelPath) {
            this.excelPath = excelPath;
            return this;
        }

        public Long getActivityId() {
            return activityId;
        }

        public ImportForm setActivityId(Long activityId) {
            this.activityId = activityId;
            return this;
        }

        public String getType() {
            return type;
        }

        public ImportForm setType(String type) {
            this.type = type;
            return this;
        }
    }
    public  static  class  Add{
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
        @NotNull(message = "活动id不能为空")
        private Long activityId;
        private String postion;//职位
        @NotEmpty(message = "类型不能为空")
        private String type;//人员类型：0-内部 ,1-群众
        private String status;

        public Integer getUserId() {
            return userId;
        }

        public Add setUserId(Integer userId) {
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

        public String getDepId() {
            return depId;
        }

        public Add setDepId(String depId) {
            this.depId = depId;
            return this;
        }

        public String getDepName() {
            return depName;
        }

        public Add setDepName(String depName) {
            this.depName = depName;
            return this;
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

        public String getSex() {
            return sex;
        }

        public Add setSex(String sex) {
            this.sex = sex;
            return this;
        }

        public String getTelphone() {
            return telphone;
        }

        public Add setTelphone(String telphone) {
            this.telphone = telphone;
            return this;
        }

        public Date getPostDate() {
            return postDate;
        }

        public Add setPostDate(Date postDate) {
            this.postDate = postDate;
            return this;
        }

        public Date getSignTime() {
            return signTime;
        }

        public Add setSignTime(Date signTime) {
            this.signTime = signTime;
            return this;
        }

        public Date getBirthDate() {
            return birthDate;
        }

        public Add setBirthDate(Date birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public String getEducationLevel() {
            return educationLevel;
        }

        public Add setEducationLevel(String educationLevel) {
            this.educationLevel = educationLevel;
            return this;
        }

        public Long getActivityId() {
            return activityId;
        }

        public Add setActivityId(Long activityId) {
            this.activityId = activityId;
            return this;
        }

        public String getPostion() {
            return postion;
        }

        public Add setPostion(String postion) {
            this.postion = postion;
            return this;
        }

        public String getType() {
            return type;
        }

        public Add setType(String type) {
            this.type = type;
            return this;
        }

        public String getStatus() {
            return status;
        }

        public Add setStatus(String status) {
            this.status = status;
            return this;
        }
    }

    public static  class  BatchAdd{
        private List<ActivitySignForm.Add> addList;

        public List<Add> getAddList() {
            return addList;
        }

        public BatchAdd setAddList(List<Add> addList) {
            this.addList = addList;
            return this;
        }
    }

    public  static class Get{
        private Long activityId;
        private  Long id;

        public Long getActivityId() {
            return activityId;
        }

        public Get setActivityId(Long activityId) {
            this.activityId = activityId;
            return this;
        }

        public Long getId() {
            return id;
        }

        public Get setId(Long id) {
            this.id = id;
            return this;
        }
    }
    public   static  class DelByActivityId{
        private  Long activityId;

        public Long getActivityId() {
            return activityId;
        }

        public DelByActivityId setActivityId(Long activityId) {
            this.activityId = activityId;
            return this;
        }
    }

    public   static  class DelByActivityIdAndType{
        private  Long activityId;
        private String type;

        public Long getActivityId() {
            return activityId;
        }

        public DelByActivityIdAndType setActivityId(Long activityId) {
            this.activityId = activityId;
            return this;
        }

        public String getType() {
            return type;
        }

        public DelByActivityIdAndType setType(String type) {
            this.type = type;
            return this;
        }
    }

    public  static  class BatchDelByActivityId{
        @NotEmpty(message = "主键不能为空")
        List<Long> activityIds;

        public List<Long> getActivityIds() {
            return activityIds;
        }

        public BatchDelByActivityId setActivityIds(List<Long> activityIds) {
            this.activityIds = activityIds;
            return this;
        }
    }


    }