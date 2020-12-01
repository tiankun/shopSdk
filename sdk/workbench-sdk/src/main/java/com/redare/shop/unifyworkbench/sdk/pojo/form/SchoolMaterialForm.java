package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 学堂管理-素材管理(SchoolMaterial)Form
 *
 * @author dengchj
 * @since 2020-10-13 14:23:45
 */
public class SchoolMaterialForm {

    public static class Edit  {
        private Integer id;
        /**
         * 标题
         */
        private String title;
        /**
         * 分类Id
         */
        private Integer markId;
        /**
         * 分类名称
         */
        private String markName;
        /**
         * 介绍
         */
        private String description;
        /**
         * 素材图片
         */
        private String picture;
        /**
         * 审核状态:0-未审核，1-审核通过，2-审核驳回
         */
        private Integer status;
        /**
         * 创建时间
         */
        private Date createTime;
        /**
         * 更新时间
         */
        private Date updateTime;
        /**
         * 组织Id
         */
        private String orgId;
        /**
         * 组织名称
         */
        private String orgName;
        /**
         * 发布人Id
         */
        private Integer publishUserId;
        /**
         * 发布人名称
         */
        private String publishUserName;
        /**
         * 阅读量
         */
        private Integer readCount;
        /**
         * 评论数
         */
        private Integer commentCount;
        /**
         * 分享数
         */
        private Integer shareCount;
        /**
         * 审核意见
         */
        private String advice;
        /**
         * 行政编码
         */
        private String areaCode;
        /**
         * 行政区域名称
         */
        private String areaName;
        /**
         * 部门Id
         */
        private String departmentId;
        /**
         * 部门名称
         */
        private String deptName;
        /**
         * 附件名称
         */
        private  String fileName;
        /**
         * 附件url
         */
        private String fileUrl;
        /**
         * 文件类型
         */
        private String fileType;
        /**
         * 文件大小
         */
        private Double fileSize;

        public Integer getId() {
            return id;
        }

        public Edit setId(Integer id) {
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

        public Integer getMarkId() {
            return markId;
        }

        public Edit setMarkId(Integer markId) {
            this.markId = markId;
            return this;
        }

        public String getMarkName() {
            return markName;
        }

        public Edit setMarkName(String markName) {
            this.markName = markName;
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

        public Integer getStatus() {
            return status;
        }

        public Edit setStatus(Integer status) {
            this.status = status;
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

        public Integer getPublishUserId() {
            return publishUserId;
        }

        public Edit setPublishUserId(Integer publishUserId) {
            this.publishUserId = publishUserId;
            return this;
        }

        public String getPublishUserName() {
            return publishUserName;
        }

        public Edit setPublishUserName(String publishUserName) {
            this.publishUserName = publishUserName;
            return this;
        }

        public Integer getReadCount() {
            return readCount;
        }

        public Edit setReadCount(Integer readCount) {
            this.readCount = readCount;
            return this;
        }

        public Integer getCommentCount() {
            return commentCount;
        }

        public Edit setCommentCount(Integer commentCount) {
            this.commentCount = commentCount;
            return this;
        }

        public Integer getShareCount() {
            return shareCount;
        }

        public Edit setShareCount(Integer shareCount) {
            this.shareCount = shareCount;
            return this;
        }

        public String getAdvice() {
            return advice;
        }

        public Edit setAdvice(String advice) {
            this.advice = advice;
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

        public String getDepartmentId() {
            return departmentId;
        }

        public Edit setDepartmentId(String departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public String getDeptName() {
            return deptName;
        }

        public Edit setDeptName(String deptName) {
            this.deptName = deptName;
            return this;
        }

        public String getFileName() {
            return fileName;
        }

        public Edit setFileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public String getFileUrl() {
            return fileUrl;
        }

        public Edit setFileUrl(String fileUrl) {
            this.fileUrl = fileUrl;
            return this;
        }

        public String getFileType() {
            return fileType;
        }

        public Edit setFileType(String fileType) {
            this.fileType = fileType;
            return this;
        }

        public Double getFileSize() {
            return fileSize;
        }

        public Edit setFileSize(Double fileSize) {
            this.fileSize = fileSize;
            return this;
        }
    }

    public static class Search extends CommonForm.Search {

        /**
         * 主键id
         */
        private Integer id;
        /**
         * 标题
         */
        private String title;

        /**
         * 分类名称
         */
        private String markName;
        private Long markId;
        /**
         * 介绍
         */
        private String description;

        /**
         * 审核状态:0-未审核，1-审核通过，2-审核驳回
         */
        private Integer status;
        /**
         * 创建时间
         */


        private String fileType;
        private String orgId;//组织Id
        private Long userId;
        private Integer top;


        public Integer getId() {
            return id;
        }

        public Search setId(Integer id) {
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

        public String getMarkName() {
            return markName;
        }

        public Search setMarkName(String markName) {
            this.markName = markName;
            return this;
        }

        public String getDescription() {
            return description;
        }

        public Search setDescription(String description) {
            this.description = description;
            return this;
        }

        public Integer getStatus() {
            return status;
        }

        public Search setStatus(Integer status) {
            this.status = status;
            return this;
        }

        public String getFileType() {
            return fileType;
        }

        public Search setFileType(String fileType) {
            this.fileType = fileType;
            return this;
        }

        public Long getMarkId() {
            return markId;
        }

        public Search setMarkId(Long markId) {
            this.markId = markId;
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

        public Integer getTop() {
            return top;
        }

        public Search setTop(Integer top) {
            this.top = top;
            return this;
        }
    }


    public  static  class Add{
        private Integer id;
        /**
         * 标题
         */
        private String title;
        /**
         * 分类Id
         */
        private Integer markId;
        /**
         * 分类名称
         */
        private String markName;
        /**
         * 介绍
         */
        private String description;
        /**
         * 素材图片
         */
        private String picture;
        /**
         * 审核状态:0-未审核，1-审核通过，2-审核驳回
         */
        private Integer status;
        /**
         * 创建时间
         */
        private Date createTime;
        /**
         * 更新时间
         */
        private Date updateTime;
        /**
         * 组织Id
         */
        private String orgId;
        /**
         * 组织名称
         */
        private String orgName;
        /**
         * 发布人Id
         */
        private Integer publishUserId;
        /**
         * 发布人名称
         */
        private String publishUserName;
        /**
         * 阅读量
         */
        private Integer readCount;
        /**
         * 评论数
         */
        private Integer commentCount;
        /**
         * 分享数
         */
        private Integer shareCount;
        /**
         * 审核意见
         */
        private String advice;
        /**
         * 行政编码
         */
        private String areaCode;
        /**
         * 行政区域名称
         */
        private String areaName;
        /**
         * 部门Id
         */
        private String departmentId;
        /**
         * 部门名称
         */
        private String deptName;
        /**
         * 附件名称
         */
        private  String fileName;
        /**
         * 附件url
         */
        private String fileUrl;
        /**
         * 文件类型
         */
        private String fileType;
        /**
         * 文件大小
         */
        private Double fileSize;

        public Integer getId() {
            return id;
        }

        public Add setId(Integer id) {
            this.id = id;
            return this;
        }

        public String getTitle() {
            return title;
        }

        public Add setTitle(String title) {
            this.title = title;
            return this;
        }

        public Integer getMarkId() {
            return markId;
        }

        public Add setMarkId(Integer markId) {
            this.markId = markId;
            return this;
        }

        public String getMarkName() {
            return markName;
        }

        public Add setMarkName(String markName) {
            this.markName = markName;
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

        public Integer getStatus() {
            return status;
        }

        public Add setStatus(Integer status) {
            this.status = status;
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

        public Integer getPublishUserId() {
            return publishUserId;
        }

        public Add setPublishUserId(Integer publishUserId) {
            this.publishUserId = publishUserId;
            return this;
        }

        public String getPublishUserName() {
            return publishUserName;
        }

        public Add setPublishUserName(String publishUserName) {
            this.publishUserName = publishUserName;
            return this;
        }

        public Integer getReadCount() {
            return readCount;
        }

        public Add setReadCount(Integer readCount) {
            this.readCount = readCount;
            return this;
        }

        public Integer getCommentCount() {
            return commentCount;
        }

        public Add setCommentCount(Integer commentCount) {
            this.commentCount = commentCount;
            return this;
        }

        public Integer getShareCount() {
            return shareCount;
        }

        public Add setShareCount(Integer shareCount) {
            this.shareCount = shareCount;
            return this;
        }

        public String getAdvice() {
            return advice;
        }

        public Add setAdvice(String advice) {
            this.advice = advice;
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

        public String getDepartmentId() {
            return departmentId;
        }

        public Add setDepartmentId(String departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public String getDeptName() {
            return deptName;
        }

        public Add setDeptName(String deptName) {
            this.deptName = deptName;
            return this;
        }

        public String getFileName() {
            return fileName;
        }

        public Add setFileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public String getFileUrl() {
            return fileUrl;
        }

        public Add setFileUrl(String fileUrl) {
            this.fileUrl = fileUrl;
            return this;
        }

        public String getFileType() {
            return fileType;
        }

        public Add setFileType(String fileType) {
            this.fileType = fileType;
            return this;
        }

        public Double getFileSize() {
            return fileSize;
        }

        public Add setFileSize(Double fileSize) {
            this.fileSize = fileSize;
            return this;
        }
    }

    public  static class Get{
        private Long id;

        public Long getId() {
            return id;
        }

        public Get setId(Long id) {
            this.id = id;
            return this;
        }
    }
    public  static class Audit{
        private Long id;
        private int status;
        private String advice;

        public Long getId() {
            return id;
        }

        public Audit setId(Long id) {
            this.id = id;
            return this;
        }

        public int getStatus() {
            return status;
        }

        public Audit setStatus(int status) {
            this.status = status;
            return this;
        }

        public String getAdvice() {
            return advice;
        }

        public Audit setAdvice(String advice) {
            this.advice = advice;
            return this;
        }

    }

    public  static  class changeStatus{
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