package com.redare.shop.unifyworkbench.sdk.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @description: Excel导入文件信息
 * @author: zlx
 * @date: Created in 2020/11/19 15:50
 * @version:
 */
public class ImportFileInfo implements Serializable {
    /**
     * 主键
     */
    private Long id;
    /**
     * 导入文件
     */
    private String fileName;
    /**
     * 文件上传url
     */
    private String fileUrl;
    /**
     * 文件路径
     */
    private String filePath;
    /**
     * 文件大小
     */
    private Integer fileSize;
    /**
     * 类型：deputy-代表名册，executive-执委管理，person-人员导入
     */
    private String type;
    /**
     * 上传时间
     */
    private Date uploadTime;
    /**
     * 上传人id
     */
    private Long uploadUserId;
    /**
     * 上传人姓名
     */
    private String uploadUserName;
    /**
     * 组织id
     */
    private String orgId;
    /**
     * 组织名称
     */
    private String orgName;
    /**
     * 区域code
     */
    private String areaCode;
    /**
     * 区域名称
     */
    private String areaName;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 导入数据数量
     */
    private Integer importCount;
    /**
     * 是否已转成用户账号:0-否；1-是
     */
    private Integer status;
    /**
     * 代表名册ID
     */
    private Long rosterId;

    private Integer validStatus;
    /**
     * 账号存在的手机号
     */
    private List<String> mobileList;
    /**
     * 生成账号数
     */
    private Long generateCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Long getUploadUserId() {
        return uploadUserId;
    }

    public void setUploadUserId(Long uploadUserId) {
        this.uploadUserId = uploadUserId;
    }

    public String getUploadUserName() {
        return uploadUserName;
    }

    public void setUploadUserName(String uploadUserName) {
        this.uploadUserName = uploadUserName;
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

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getImportCount() {
        return importCount;
    }

    public void setImportCount(Integer importCount) {
        this.importCount = importCount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getRosterId() {
        return rosterId;
    }

    public void setRosterId(Long rosterId) {
        this.rosterId = rosterId;
    }

    public Integer getValidStatus() {
        return validStatus;
    }

    public void setValidStatus(Integer validStatus) {
        this.validStatus = validStatus;
    }

    public List<String> getMobileList() {
        return mobileList;
    }

    public ImportFileInfo setMobileList(List<String> mobileList) {
        this.mobileList = mobileList;
        return this;
    }

    public Long getGenerateCount() {
        return generateCount;
    }

    public ImportFileInfo setGenerateCount(Long generateCount) {
        this.generateCount = generateCount;
        return this;
    }
}
