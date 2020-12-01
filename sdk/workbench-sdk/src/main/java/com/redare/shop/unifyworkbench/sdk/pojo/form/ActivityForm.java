package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 活动管理(Activity)Form
 *
 * @author dengchj
 * @since 2020-10-19 18:02:44
 */
public class ActivityForm {



    public static class Search extends CommonForm.Search {

        /**
         * 主键Id
         */
        private Long id;
        /**
         * 活动名称
         */
        private String title;
        private Integer zt;
        private String orgId;
        private  Long userId;
        /**
         * 活动时间，用于查询当天的所有活动
         */
        private String beginDate;
        private String endDate;
        private Integer top;
        private Integer status;
        private String activityType;//活动类型

        /**
         * 主题类型
         */
        private String trainType;
        private String areaName;
        private  String areaCode;

        public Long getId() {
            return id;
        }

        public Search setId(Long id) {
            this.id = id;
            return this;
        }

        public String getTitle() {
            return title;
        }

        public Search setTitle(String title) {
            this.title = title;
            return this;
        }

        public Integer getZt() {
            return zt;
        }

        public Search setZt(Integer zt) {
            this.zt = zt;
            return this;
        }

        public String getOrgId() {
            return orgId;
        }

        public Search setOrgId(String orgId) {
            this.orgId = orgId;
            return this;
        }

        public Long getUserId() {
            return userId;
        }

        public Search setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public String getBeginDate() {
            return beginDate;
        }

        public Search setBeginDate(String beginDate) {
            this.beginDate = beginDate;
            return this;
        }

        public Integer getTop() {
            return top;
        }

        public Search setTop(Integer top) {
            this.top = top;
            return this;
        }

        public Integer getStatus() {
            return status;
        }

        public Search setStatus(Integer status) {
            this.status = status;
            return this;
        }

        public String getActivityType() {
            return activityType;
        }

        public Search setActivityType(String activityType) {
            this.activityType = activityType;
            return this;
        }

        public String getEndDate() {
            return endDate;
        }

        public Search setEndDate(String endDate) {
            this.endDate = endDate;
            return this;
        }

        public String getAreaName() {
            return areaName;
        }

        public Search setAreaName(String areaName) {
            this.areaName = areaName;
            return this;
        }

        public String getAreaCode() {
            return areaCode;
        }

        public Search setAreaCode(String areaCode) {
            this.areaCode = areaCode;
            return this;
        }

        public String getTrainType() {
            return trainType;
        }

        public Search setTrainType(String trainType) {
            this.trainType = trainType;
            return this;
        }
    }

    public  static  class  Add{
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
         * 培训类型
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
        private String picture;//封面图


        public String getTitle() {
            return title;
        }

        public Add setTitle(String title) {
            this.title = title;
            return this;
        }

        public String getPlace() {
            return place;
        }

        public Add setPlace(String place) {
            this.place = place;
            return this;
        }

        public Date getBeginDate() {
            return beginDate;
        }

        public Add setBeginDate(Date beginDate) {
            this.beginDate = beginDate;
            return this;
        }

        public Date getEndDate() {
            return endDate;
        }

        public Add setEndDate(Date endDate) {
            this.endDate = endDate;
            return this;
        }

        public String getActivityType() {
            return activityType;
        }

        public Add setActivityType(String activityType) {
            this.activityType = activityType;
            return this;
        }

        public String getTrainType() {
            return trainType;
        }

        public Add setTrainType(String trainType) {
            this.trainType = trainType;
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

        public String getDepartId() {
            return departId;
        }

        public Add setDepartId(String departId) {
            this.departId = departId;
            return this;
        }

        public String getDepartName() {
            return departName;
        }

        public Add setDepartName(String departName) {
            this.departName = departName;
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

        public Integer getJoinCount() {
            return joinCount;
        }

        public Add setJoinCount(Integer joinCount) {
            this.joinCount = joinCount;
            return this;
        }

        public Integer getLeaderId() {
            return leaderId;
        }

        public Add setLeaderId(Integer leaderId) {
            this.leaderId = leaderId;
            return this;
        }

        public String getLeaderName() {
            return leaderName;
        }

        public Add setLeaderName(String leaderName) {
            this.leaderName = leaderName;
            return this;
        }

        public String getTelphone() {
            return telphone;
        }

        public Add setTelphone(String telphone) {
            this.telphone = telphone;
            return this;
        }

        public Integer getCreateUserId() {
            return createUserId;
        }

        public Add setCreateUserId(Integer createUserId) {
            this.createUserId = createUserId;
            return this;
        }

        public String getCreateUserName() {
            return createUserName;
        }

        public Add setCreateUserName(String createUserName) {
            this.createUserName = createUserName;
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

        public String getDescription() {
            return description;
        }

        public Add setDescription(String description) {
            this.description = description;
            return this;
        }

        public String getPicture() {
            return picture;
        }

        public Add setPicture(String picture) {
            this.picture = picture;
            return this;
        }
    }


    public  static class Edit{
        @NotNull(message = "主键不能为空")
        private  Long id;
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
         * 培训类型
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
        private  String picture;


        public Long getId() {
            return id;
        }

        public Edit setId(Long id) {
            this.id = id;
            return this;
        }

        public String getTitle() {
            return title;
        }

        public Edit setTitle(String title) {
            this.title = title;
            return this;
        }

        public String getPlace() {
            return place;
        }

        public Edit setPlace(String place) {
            this.place = place;
            return this;
        }

        public Date getBeginDate() {
            return beginDate;
        }

        public Edit setBeginDate(Date beginDate) {
            this.beginDate = beginDate;
            return this;
        }

        public Date getEndDate() {
            return endDate;
        }

        public Edit setEndDate(Date endDate) {
            this.endDate = endDate;
            return this;
        }

        public String getActivityType() {
            return activityType;
        }

        public Edit setActivityType(String activityType) {
            this.activityType = activityType;
            return this;
        }

        public String getTrainType() {
            return trainType;
        }

        public Edit setTrainType(String trainType) {
            this.trainType = trainType;
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

        public String getDepartId() {
            return departId;
        }

        public Edit setDepartId(String departId) {
            this.departId = departId;
            return this;
        }

        public String getDepartName() {
            return departName;
        }

        public Edit setDepartName(String departName) {
            this.departName = departName;
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

        public Integer getJoinCount() {
            return joinCount;
        }

        public Edit setJoinCount(Integer joinCount) {
            this.joinCount = joinCount;
            return this;
        }

        public Integer getLeaderId() {
            return leaderId;
        }

        public Edit setLeaderId(Integer leaderId) {
            this.leaderId = leaderId;
            return this;
        }

        public String getLeaderName() {
            return leaderName;
        }

        public Edit setLeaderName(String leaderName) {
            this.leaderName = leaderName;
            return this;
        }

        public String getTelphone() {
            return telphone;
        }

        public Edit setTelphone(String telphone) {
            this.telphone = telphone;
            return this;
        }

        public Integer getCreateUserId() {
            return createUserId;
        }

        public Edit setCreateUserId(Integer createUserId) {
            this.createUserId = createUserId;
            return this;
        }

        public String getCreateUserName() {
            return createUserName;
        }

        public Edit setCreateUserName(String createUserName) {
            this.createUserName = createUserName;
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

        public String getDescription() {
            return description;
        }

        public Edit setDescription(String description) {
            this.description = description;
            return this;
        }

        public String getPicture() {
            return picture;
        }

        public Edit setPicture(String picture) {
            this.picture = picture;
            return this;
        }
    }

    public  static  class changeStatus {
        private Integer status;
        private Long id;

        public Integer getStatus() {
            return status;
        }

        public changeStatus setStatus(Integer status) {
            this.status = status;
            return this;
        }

        public Long getId() {
            return id;
        }

        public changeStatus setId(Long id) {
            this.id = id;
            return this;
        }
    }

    public static class HeatmapSearch{
        /**
         * 查询月份，如(2020-10)
         */
        private String yearMonth;
        private String orgId;//组织id

        public String getYearMonth() {
            return yearMonth;
        }

        public HeatmapSearch setYearMonth(String yearMonth) {
            this.yearMonth = yearMonth;
            return this;
        }

        public String getOrgId() {
            return orgId;
        }

        public HeatmapSearch setOrgId(String orgId) {
            this.orgId = orgId;
            return this;
        }
    }

    public static class Top {

        @NotNull(message = "请传入id")
        private Long id;

        @NotNull(message = "请传入置顶状态")
        private Integer top;

        public Long getId() {
            return id;
        }

        public Top setId(Long id) {
            this.id = id;
            return this;
        }

        public Integer getTop() {
            return top;
        }

        public Top setTop(Integer top) {
            this.top = top;
            return this;
        }
    }

    public static class Sort{
        @NotNull(message = "请传入id")
        private Long id;

        @NotNull(message = "请传入排序值")
        private Integer sort;

        public Long getId() {
            return id;
        }

        public Sort setId(Long id) {
            this.id = id;
            return this;
        }

        public Integer getSort() {
            return sort;
        }

        public Sort setSort(Integer sort) {
            this.sort = sort;
            return this;
        }
    }

}
