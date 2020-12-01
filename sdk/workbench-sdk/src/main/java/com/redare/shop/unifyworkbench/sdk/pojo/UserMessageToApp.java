package com.redare.shop.unifyworkbench.sdk.pojo;

import java.util.Date;
import java.util.List;

/**
 * @description:消息推送至APP(t_user_message_toApp)
 * @author: zlx
 * @date: Created in 2020/6/16 16:17
 * @version: 1.1
 */
public class UserMessageToApp {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 消息标题
     */
    private String title;
    /**
     * 消息类型(sys:系统消息 notice:通知公告 report:报表消息 news:新闻消息)
     */
    private String msgType;
    /**
     * 消息内容
     */
    private String content;
    /**
     * 消息详情url
     */
    private String url;
    /**
     * 用户Id
     */
    private String userIds;
    /**
     * 0未读，1已读
     */
    private Integer readed;
    /**
     * 消息内容详情id（t_content_manage表主键）
     */
    private Long msgId;
    /**
     * 角色，用逗号分隔
     */
    private String roleIds;
    /**
     * 消息接收者类型 1-按角色；2-按姓名
     */
    private Integer msgReceiveType;
    /**
     * 消息作用域，1-保存至数据库，2-推送至APP
     */
    private String msgScope;
    /**
     * 阅读时间
     */
    private Date readTime;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 角色名称
     */
    private String roleNames;
    /**
     * 姓名
     */
    private String userNames;
    /**
     * 消息类型中文名
     */
    private String msgName;

    private List<String> budgetReport;

    private List<String> manageReport;

    private String sendReport;

    public String getMsgName() {
        return msgName;
    }

    public UserMessageToApp setMsgName(String msgName) {
        this.msgName = msgName;
        return this;
    }

    public String getRoleNames() {
        return roleNames;
    }

    public UserMessageToApp setRoleNames(String roleNames) {
        this.roleNames = roleNames;
        return this;
    }

    public String getUserNames() {
        return userNames;
    }

    public UserMessageToApp setUserNames(String userNames) {
        this.userNames = userNames;
        return this;
    }

    public Long getId() {
        return id;
    }

    public UserMessageToApp setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public UserMessageToApp setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getMsgType() {
        return msgType;
    }

    public UserMessageToApp setMsgType(String msgType) {
        this.msgType = msgType;
        return this;
    }

    public String getContent() {
        return content;
    }

    public UserMessageToApp setContent(String content) {
        this.content = content;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public UserMessageToApp setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getUserIds() {
        return userIds;
    }

    public UserMessageToApp setUserIds(String userIds) {
        this.userIds = userIds;
        return this;
    }

    public Integer getReaded() {
        return readed;
    }

    public UserMessageToApp setReaded(Integer readed) {
        this.readed = readed;
        return this;
    }

    public Long getMsgId() {
        return msgId;
    }

    public UserMessageToApp setMsgId(Long msgId) {
        this.msgId = msgId;
        return this;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public UserMessageToApp setRoleIds(String roleIds) {
        this.roleIds = roleIds;
        return this;
    }

    public Integer getMsgReceiveType() {
        return msgReceiveType;
    }

    public UserMessageToApp setMsgReceiveType(Integer msgReceiveType) {
        this.msgReceiveType = msgReceiveType;
        return this;
    }

    public String getMsgScope() {
        return msgScope;
    }

    public UserMessageToApp setMsgScope(String msgScope) {
        this.msgScope = msgScope;
        return this;
    }

    public Date getReadTime() {
        return readTime;
    }

    public UserMessageToApp setReadTime(Date readTime) {
        this.readTime = readTime;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public UserMessageToApp setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public UserMessageToApp setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public List<String> getBudgetReport() {
        return budgetReport;
    }

    public UserMessageToApp setBudgetReport(List<String> budgetReport) {
        this.budgetReport = budgetReport;
        return this;
    }

    public List<String> getManageReport() {
        return manageReport;
    }

    public UserMessageToApp setManageReport(List<String> manageReport) {
        this.manageReport = manageReport;
        return this;
    }

    public String getSendReport() {
        return sendReport;
    }

    public UserMessageToApp setSendReport(String sendReport) {
        this.sendReport = sendReport;
        return this;
    }
}
