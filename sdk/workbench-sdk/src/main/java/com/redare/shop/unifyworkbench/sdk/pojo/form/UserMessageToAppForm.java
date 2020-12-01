package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/6/16 16:26
 * @version: 1.1
 */
public class UserMessageToAppForm {

    public static class Add{
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
         * 截止时间
         */
        private String endDate;
        /**
         * 季度
         */
        private String jd;

        private List<String> budgetReport;

        private List<String> manageReport;

        private String sendReport;

        private List<String> roleIdList;

        private List<String> userIdList;

        private List<String> msgScopeList;

        public List<String> getRoleIdList() {
            return roleIdList;
        }

        public Add setRoleIdList(List<String> roleIdList) {
            this.roleIdList = roleIdList;
            return this;
        }

        public List<String> getUserIdList() {
            return userIdList;
        }

        public Add setUserIdList(List<String> userIdList) {
            this.userIdList = userIdList;
            return this;
        }

        public List<String> getMsgScopeList() {
            return msgScopeList;
        }

        public Add setMsgScopeList(List<String> msgScopeList) {
            this.msgScopeList = msgScopeList;
            return this;
        }

        public String getTitle() {
            return title;
        }

        public Add setTitle(String title) {
            this.title = title;
            return this;
        }

        public String getMsgType() {
            return msgType;
        }

        public Add setMsgType(String msgType) {
            this.msgType = msgType;
            return this;
        }

        public String getContent() {
            return content;
        }

        public Add setContent(String content) {
            this.content = content;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Add setUrl(String url) {
            this.url = url;
            return this;
        }

        public String getUserIds() {
            return userIds;
        }

        public Add setUserIds(String userIds) {
            this.userIds = userIds;
            return this;
        }

        public Integer getReaded() {
            return readed;
        }

        public Add setReaded(Integer readed) {
            this.readed = readed;
            return this;
        }

        public Long getMsgId() {
            return msgId;
        }

        public Add setMsgId(Long msgId) {
            this.msgId = msgId;
            return this;
        }

        public String getRoleIds() {
            return roleIds;
        }

        public Add setRoleIds(String roleIds) {
            this.roleIds = roleIds;
            return this;
        }

        public Integer getMsgReceiveType() {
            return msgReceiveType;
        }

        public Add setMsgReceiveType(Integer msgReceiveType) {
            this.msgReceiveType = msgReceiveType;
            return this;
        }

        public String getMsgScope() {
            return msgScope;
        }

        public Add setMsgScope(String msgScope) {
            this.msgScope = msgScope;
            return this;
        }

        public Date getReadTime() {
            return readTime;
        }

        public Add setReadTime(Date readTime) {
            this.readTime = readTime;
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

        public String getEndDate() {
            return endDate;
        }

        public Add setEndDate(String endDate) {
            this.endDate = endDate;
            return this;
        }

        public String getJd() {
            return jd;
        }

        public Add setJd(String jd) {
            this.jd = jd;
            return this;
        }

        public List<String> getBudgetReport() {
            return budgetReport;
        }

        public Add setBudgetReport(List<String> budgetReport) {
            this.budgetReport = budgetReport;
            return this;
        }

        public List<String> getManageReport() {
            return manageReport;
        }

        public Add setManageReport(List<String> manageReport) {
            this.manageReport = manageReport;
            return this;
        }

        public String getSendReport() {
            return sendReport;
        }

        public Add setSendReport(String sendReport) {
            this.sendReport = sendReport;
            return this;
        }
    }

    public static class Search{
        private String key;
        private String msgType;
        private String msgScope;

        public String getKey() {
            return key;
        }

        public Search setKey(String key) {
            this.key = key;
            return this;
        }

        public String getMsgType() {
            return msgType;
        }

        public Search setMsgType(String msgType) {
            this.msgType = msgType;
            return this;
        }

        public String getMsgScope() {
            return msgScope;
        }

        public Search setMsgScope(String msgScope) {
            this.msgScope = msgScope;
            return this;
        }
    }

    public static class Del{
        @NotNull(message = "主键id不能为空")
        private Long id;

        public Long getId() {
            return id;
        }

        public Del setId(Long id) {
            this.id = id;
            return this;
        }
    }
}
