package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * 交办表(Assign)Form
 *
 * @author makejava
 * @since 2020-10-22 14:31:38
 */
public class AssignForm {

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


        private Long id;
        /**
         * 上级id
         */
        private Long pid;
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
         * 短信发送职位
         */
        private List<Integer> positionIds;
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

        public Long getId() {
            return id;
        }

        public Search setId(Long id) {
            this.id = id;
            return this;
        }

        public Long getPid() {
            return pid;
        }

        public Search setPid(Long pid) {
            this.pid = pid;
            return this;
        }

        public String getTitle() {
            return title;
        }

        public Search setTitle(String title) {
            this.title = title;
            return this;
        }

        public String getTypeCode() {
            return typeCode;
        }

        public Search setTypeCode(String typeCode) {
            this.typeCode = typeCode;
            return this;
        }

        public String getTypeName() {
            return typeName;
        }

        public Search setTypeName(String typeName) {
            this.typeName = typeName;
            return this;
        }

        public String getContent() {
            return content;
        }

        public Search setContent(String content) {
            this.content = content;
            return this;
        }

        public String getAttention() {
            return attention;
        }

        public Search setAttention(String attention) {
            this.attention = attention;
            return this;
        }

        public Date getBeginDate() {
            return beginDate;
        }

        public Search setBeginDate(Date beginDate) {
            this.beginDate = beginDate;
            return this;
        }

        public Date getEndDate() {
            return endDate;
        }

        public Search setEndDate(Date endDate) {
            this.endDate = endDate;
            return this;
        }

        public Long getAssignUserId() {
            return assignUserId;
        }

        public Search setAssignUserId(Long assignUserId) {
            this.assignUserId = assignUserId;
            return this;
        }

        public String getAssignUserName() {
            return assignUserName;
        }

        public Search setAssignUserName(String assignUserName) {
            this.assignUserName = assignUserName;
            return this;
        }

        public String getAssignOrgId() {
            return assignOrgId;
        }

        public Search setAssignOrgId(String assignOrgId) {
            this.assignOrgId = assignOrgId;
            return this;
        }

        public String getAssignOrgName() {
            return assignOrgName;
        }

        public Search setAssignOrgName(String assignOrgName) {
            this.assignOrgName = assignOrgName;
            return this;
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

        public Search setImages(String images) {
            this.images = images;
            return this;
        }

        public String getFiles() {
            return files;
        }

        public Search setFiles(String files) {
            this.files = files;
            return this;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public Search setCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public Date getUpdateTime() {
            return updateTime;
        }

        public Search setUpdateTime(Date updateTime) {
            this.updateTime = updateTime;
            return this;
        }

        public Integer getStatus() {
            return status;
        }

        public Search setStatus(Integer status) {
            this.status = status;
            return this;
        }

        public Integer getAssignStatus() {
            return assignStatus;
        }

        public Search setAssignStatus(Integer assignStatus) {
            this.assignStatus = assignStatus;
            return this;
        }

        public Date getAssignTime() {
            return assignTime;
        }

        public Search setAssignTime(Date assignTime) {
            this.assignTime = assignTime;
            return this;
        }

        public String getParentAreaCode() {
            return parentAreaCode;
        }

        public Search setParentAreaCode(String parentAreaCode) {
            this.parentAreaCode = parentAreaCode;
            return this;
        }

        public String getParentAreaName() {
            return parentAreaName;
        }

        public Search setParentAreaName(String parentAreaName) {
            this.parentAreaName = parentAreaName;
            return this;
        }

        public String getParentOrgId() {
            return parentOrgId;
        }

        public Search setParentOrgId(String parentOrgId) {
            this.parentOrgId = parentOrgId;
            return this;
        }

        public String getParentOrgName() {
            return parentOrgName;
        }

        public Search setParentOrgName(String parentOrgName) {
            this.parentOrgName = parentOrgName;
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

        public String getDepartmentId() {
            return departmentId;
        }

        public Search setDepartmentId(String departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public String getDeptName() {
            return deptName;
        }

        public Search setDeptName(String deptName) {
            this.deptName = deptName;
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

        public Integer getSendMsg() {
            return sendMsg;
        }

        public Search setSendMsg(Integer sendMsg) {
            this.sendMsg = sendMsg;
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

}