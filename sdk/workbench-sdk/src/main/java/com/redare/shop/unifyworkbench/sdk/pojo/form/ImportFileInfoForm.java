package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/11/19 15:58
 * @version:
 */
public class ImportFileInfoForm {

    public static class Search{
        private String key;
        private Long id;
        private String fileName;
        private String fileUrl;
        private String filePath;
        private Integer fileSize;
        private String type;
        private Date uploadTime;
        private Long uploadUserId;
        private String uploadUserName;
        private String orgId;
        private String orgName;
        private String areaCode;
        private String areaName;
        private Date createTime;
        private Date updateTime;
        private Integer importCount;
        private Integer status;
        private String startTime;
        private String endTime;


        public String getKey() {
            return key;
        }

        public Search setKey(String key) {
            this.key = key;
            return this;
        }

        public Long getId() {
            return id;
        }

        public Search setId(Long id) {
            this.id = id;
            return this;
        }

        public String getFileName() {
            return fileName;
        }

        public Search setFileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public String getFileUrl() {
            return fileUrl;
        }

        public Search setFileUrl(String fileUrl) {
            this.fileUrl = fileUrl;
            return this;
        }

        public String getFilePath() {
            return filePath;
        }

        public Search setFilePath(String filePath) {
            this.filePath = filePath;
            return this;
        }

        public Integer getFileSize() {
            return fileSize;
        }

        public Search setFileSize(Integer fileSize) {
            this.fileSize = fileSize;
            return this;
        }

        public String getType() {
            return type;
        }

        public Search setType(String type) {
            this.type = type;
            return this;
        }

        public Date getUploadTime() {
            return uploadTime;
        }

        public Search setUploadTime(Date uploadTime) {
            this.uploadTime = uploadTime;
            return this;
        }

        public Long getUploadUserId() {
            return uploadUserId;
        }

        public Search setUploadUserId(Long uploadUserId) {
            this.uploadUserId = uploadUserId;
            return this;
        }

        public String getUploadUserName() {
            return uploadUserName;
        }

        public Search setUploadUserName(String uploadUserName) {
            this.uploadUserName = uploadUserName;
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

        public Integer getImportCount() {
            return importCount;
        }

        public Search setImportCount(Integer importCount) {
            this.importCount = importCount;
            return this;
        }

        public Integer getStatus() {
            return status;
        }

        public Search setStatus(Integer status) {
            this.status = status;
            return this;
        }

        public String getStartTime() {
            return startTime;
        }

        public Search setStartTime(String startTime) {
            this.startTime = startTime;
            return this;
        }

        public String getEndTime() {
            return endTime;
        }

        public Search setEndTime(String endTime) {
            this.endTime = endTime;
            return this;
        }
    }

    public static class Add{
        private String fileName;
        private String fileUrl;
        private String filePath;
        private Integer fileSize;
        private String type;
        private Date uploadTime;
        private Long uploadUserId;
        private String uploadUserName;
        private String orgId;
        private String orgName;
        private String areaCode;
        private String areaName;
        private Date createTime;
        private Date updateTime;
        private Integer importCount;
        private Integer status;

        /*****************临时属性***********************/
        /**
         * 代表名册ID
         */
        private Long rosterId;
        /**
         * 执委名单名称
         */
        private String rosterName;

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

        public String getFilePath() {
            return filePath;
        }

        public Add setFilePath(String filePath) {
            this.filePath = filePath;
            return this;
        }

        public Integer getFileSize() {
            return fileSize;
        }

        public Add setFileSize(Integer fileSize) {
            this.fileSize = fileSize;
            return this;
        }

        public String getType() {
            return type;
        }

        public Add setType(String type) {
            this.type = type;
            return this;
        }

        public Date getUploadTime() {
            return uploadTime;
        }

        public Add setUploadTime(Date uploadTime) {
            this.uploadTime = uploadTime;
            return this;
        }

        public Long getUploadUserId() {
            return uploadUserId;
        }

        public Add setUploadUserId(Long uploadUserId) {
            this.uploadUserId = uploadUserId;
            return this;
        }

        public String getUploadUserName() {
            return uploadUserName;
        }

        public Add setUploadUserName(String uploadUserName) {
            this.uploadUserName = uploadUserName;
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

        public Integer getImportCount() {
            return importCount;
        }

        public Add setImportCount(Integer importCount) {
            this.importCount = importCount;
            return this;
        }

        public Integer getStatus() {
            return status;
        }

        public Add setStatus(Integer status) {
            this.status = status;
            return this;
        }

        public Long getRosterId() {
            return rosterId;
        }

        public Add setRosterId(Long rosterId) {
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
    }

    public static class Get{
        @NotNull(message = "主键id不能为空")
        private Long id;

        private Long userId;

        private String userName;

        public Long getId() {
            return id;
        }

        public Get setId(Long id) {
            this.id = id;
            return this;
        }

        public Long getUserId() {
            return userId;
        }

        public Get setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public String getUserName() {
            return userName;
        }

        public Get setUserName(String userName) {
            this.userName = userName;
            return this;
        }
    }

}
