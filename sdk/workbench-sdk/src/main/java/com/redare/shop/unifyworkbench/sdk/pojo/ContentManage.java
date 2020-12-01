package com.redare.shop.unifyworkbench.sdk.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * ContentManage
 * 表：t_content_manage
 *
 * @Author zlx
 * @Date 2020/5/6 14:27
 */
public class ContentManage implements Serializable {

    /**
     * 主键id
     */
    private Long id;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 封面
     */
    private String cover;
    /**
     * 附件
     */
    private String enclosure;
    /**
     * 分类
     */
    private Integer classify;
    /**
     * 分类名称
     */
    private String classifyName;
    /**
     * 同步到网站
     */
    private Integer syncToSite;
    /**
     * 发布人id
     */
    private Long publishId;
    /**
     * 发布人
     */
    private String publisher;
    /**
     * 浏览量
     */
    private Integer browse;
    /**
     * 发布时间
     */
    private Date publishTime;
    /**
     * 发布时间字符串
     */
    private String pubTime;
    /**
     * 显示状态1-显示；0-隐藏
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 年
     */
    private String year;
    /**
     * 月日
     */
    private String monthAndDay;

    /**
     * 附件集合
     */
    private List<ContentAttachment> attachmentList;
    /**
     * 接收组织id，逗号分隔
     */
    private String orgIds;
    /**
     * 接收组织名称，逗号分隔
     */
    private String orgNames;
    /**
     * 接收组织集合
     */
    private List<String> orgIdList;

    public String getOrgIds() {
        return orgIds;
    }

    public ContentManage setOrgIds(String orgIds) {
        this.orgIds = orgIds;
        return this;
    }

    public String getOrgNames() {
        return orgNames;
    }

    public ContentManage setOrgNames(String orgNames) {
        this.orgNames = orgNames;
        return this;
    }

    public List<String> getOrgIdList() {
        return orgIdList;
    }

    public ContentManage setOrgIdList(List<String> orgIdList) {
        this.orgIdList = orgIdList;
        return this;
    }

    public String getYear() {
        return year;
    }

    public ContentManage setYear(String year) {
        this.year = year;
        return this;
    }

    public String getMonthAndDay() {
        return monthAndDay;
    }

    public ContentManage setMonthAndDay(String monthAndDay) {
        this.monthAndDay = monthAndDay;
        return this;
    }

    public List<ContentAttachment> getAttachmentList() {
        return attachmentList;
    }

    public ContentManage setAttachmentList(List<ContentAttachment> attachmentList) {
        this.attachmentList = attachmentList;
        return this;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public ContentManage setClassifyName(String classifyName) {
        this.classifyName = classifyName;
        return this;
    }

    public String getPublisher() {
        return publisher;
    }

    public ContentManage setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public Long getId() {
        return id;
    }

    public ContentManage setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ContentManage setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public ContentManage setContent(String content) {
        this.content = content;
        return this;
    }

    public String getCover() {
        return cover;
    }

    public ContentManage setCover(String cover) {
        this.cover = cover;
        return this;
    }

    public String getEnclosure() {
        return enclosure;
    }

    public ContentManage setEnclosure(String enclosure) {
        this.enclosure = enclosure;
        return this;
    }

    public Integer getClassify() {
        return classify;
    }

    public ContentManage setClassify(Integer classify) {
        this.classify = classify;
        return this;
    }

    public Integer getSyncToSite() {
        return syncToSite;
    }

    public ContentManage setSyncToSite(Integer syncToSite) {
        this.syncToSite = syncToSite;
        return this;
    }

    public Long getPublishId() {
        return publishId;
    }

    public ContentManage setPublishId(Long publishId) {
        this.publishId = publishId;
        return this;
    }

    public Integer getBrowse() {
        return browse;
    }

    public ContentManage setBrowse(Integer browse) {
        this.browse = browse;
        return this;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public ContentManage setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public ContentManage setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public ContentManage setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getPubTime() {
        return pubTime;
    }

    public ContentManage setPubTime(String pubTime) {
        this.pubTime = pubTime;
        return this;
    }
}
