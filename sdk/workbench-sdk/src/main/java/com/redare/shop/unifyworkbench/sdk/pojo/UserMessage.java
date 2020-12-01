package com.redare.shop.unifyworkbench.sdk.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * UserMessage
 * 表（t_user_message）
 *
 * @Author zlx
 * @Date 2020/5/13 15:27
 */
public class UserMessage implements Serializable {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 消息类型(sys:系统消息 notice:通知公告 report:报表消息 news:新闻消息)
     */
    private String title;
    private String msgType;
    /**
     * 消息名称
     */
    private String msgName;
    /**
     * 消息内容详情id（t_content_manage表主键）
     */
    private Long msgId;
    /**
     * 消息内容
     */
    private String content;
    /**
     * PC消息详情url
     */
    private String url;

    /**
     * App跳转url
     */
    private String appUrl;
    /**
     * 各个业务ID
     */
    private String bizId;
    /**
     * 各个业务table
     */
    private String bizTable;
    /**
     * 用户Id
     */
    private Long userId;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 0未读，1已读
     */
    private Integer readed;
    /**
     * 阅读时间
     */
    private Date readTime;
    /**
     * 阅读时间字符串
     */
    private String readTimeStr;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 创建时间字符串
     */
    private String createTimeStr;

    private String dateStr;

    private String timeStr;

    public String getDateStr() {
        return dateStr;
    }

    public UserMessage setDateStr(String dateStr) {
        this.dateStr = dateStr;
        return this;
    }

    public String getTimeStr() {
        return timeStr;
    }

    public UserMessage setTimeStr(String timeStr) {
        this.timeStr = timeStr;
        return this;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public UserMessage setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
        return this;
    }

    public Long getMsgId() {
        return msgId;
    }

    public UserMessage setMsgId(Long msgId) {
        this.msgId = msgId;
        return this;
    }

    public String getReadTimeStr() {
        return readTimeStr;
    }

    public UserMessage setReadTimeStr(String readTimeStr) {
        this.readTimeStr = readTimeStr;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public UserMessage setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getMsgName() {
        return msgName;
    }

    public UserMessage setMsgName(String msgName) {
        this.msgName = msgName;
        return this;
    }

    public Long getId() {
        return id;
    }

    public UserMessage setId(Long id) {
        this.id = id;
        return this;
    }

    public String getMsgType() {
        return msgType;
    }

    public UserMessage setMsgType(String msgType) {
        this.msgType = msgType;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public UserMessage setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public UserMessage setContent(String content) {
        this.content = content;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public UserMessage setUrl(String url) {
        this.url = url;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public UserMessage setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Integer getReaded() {
        return readed;
    }

    public UserMessage setReaded(Integer readed) {
        this.readed = readed;
        return this;
    }

    public Date getReadTime() {
        return readTime;
    }

    public UserMessage setReadTime(Date readTime) {
        this.readTime = readTime;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public UserMessage setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public UserMessage setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public UserMessage setAppUrl(String appUrl) {
        this.appUrl = appUrl;
        return this;

    }

    public String getBizId() {
        return bizId;
    }

    public UserMessage setBizId(String bizId) {
        this.bizId = bizId;
        return this;

    }

    public String getBizTable() {
        return bizTable;
    }

    public UserMessage setBizTable(String bizTable) {
        this.bizTable = bizTable;
        return this;
    }
}
