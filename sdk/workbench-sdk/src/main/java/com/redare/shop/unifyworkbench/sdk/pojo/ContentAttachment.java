package com.redare.shop.unifyworkbench.sdk.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * ContentAttachment
 * 表(t_content_attachment)
 *
 * @Author zlx
 * @Date 2020/5/7 18:22
 */
public class ContentAttachment implements Serializable {
    /**
     * 主键id
     */
    private Long uid;
    /**
     * 内容管理id
     */
    private Long contentId;
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

    private String status;

    public String getStatus() {
        return status;
    }

    public ContentAttachment setStatus(String status) {
        this.status = status;
        return this;
    }

    public Long getUid() {
        return uid;
    }

    public ContentAttachment setUid(Long uid) {
        this.uid = uid;
        return this;
    }

    public String getName() {
        return name;
    }

    public ContentAttachment setName(String name) {
        this.name = name;
        return this;
    }

    public Long getContentId() {
        return contentId;
    }

    public ContentAttachment setContentId(Long contentId) {
        this.contentId = contentId;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public ContentAttachment setUrl(String url) {
        this.url = url;
        return this;
    }

    public Integer getSize() {
        return size;
    }

    public ContentAttachment setSize(Integer size) {
        this.size = size;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public ContentAttachment setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }
}
