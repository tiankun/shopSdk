package com.redare.shop.unifyworkbench.sdk.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 学堂管理-素材附件管理(ActivityAttachment)实体类
 *
 * @author dengchj
 * @since 2020-10-19 18:03:16
 */
public class ActivityAttachment implements Serializable {
    private static final long serialVersionUID = -71377631201145322L;
    /**
     * 主键id
     */
    private Long uid;
    /**
     * 素材管理id
     */
    private Long materialId;
    /**
     * 文件名称
     */
    private String name;
    /**
     * 文件路径
     */
    private String url;
    /**
     * 文件大小
     */
    private Integer size;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 文件状态
     */
    private String status;
    /**
     * 文件类型
     */
    private String fileType;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialid(Long materialId) {
        this.materialId = materialId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreatetime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFiletype(String fileType) {
        this.fileType = fileType;
    }

}