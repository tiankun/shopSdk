package com.redare.shop.unifyworkbench.sdk.pojo;

import java.util.Date;
import java.util.List;

/**
 * 待办事项
 */
public class PendingItem {

    private Long id;

    private String title;

    private String publishOrg;

    private Date publishTime;

    private String type;
    /**
     * 0:待办,1：已办
     */
    private Integer handleState;
    /**
     * 接收组织
     */
    private String orgId;
    /**
     * 待办数量
     */
    private Long todoCount;
    /**
     * 超时数量
     */
    private Long overtimeCount;
    /**
     * 已完成数量
     */
    private Long doneCount;
    /**
     * 总数量
     */
    private Long totalCount;
    /**
     * 已办数量
     */
    private Long handleCount;
    /**
     * 0未读，1已读
     */
    private Integer readed;
    /**
     * 阅读时间
     */
    private Date readTime;

    private List<UserMessage> userMessageList;

    public Long getId() {
        return id;
    }

    public PendingItem setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public PendingItem setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPublishOrg() {
        return publishOrg;
    }

    public PendingItem setPublishOrg(String publishOrg) {
        this.publishOrg = publishOrg;
        return this;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public PendingItem setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
        return this;
    }

    public String getType() {
        return type;
    }

    public PendingItem setType(String type) {
        this.type = type;
        return this;
    }

    public String getOrgId() {
        return orgId;
    }

    public PendingItem setOrgId(String orgId) {
        this.orgId = orgId;
        return this;
    }

    public Long getTodoCount() {
        return todoCount;
    }

    public PendingItem setTodoCount(Long todoCount) {
        this.todoCount = todoCount;
        return this;
    }

    public Long getOvertimeCount() {
        return overtimeCount;
    }

    public PendingItem setOvertimeCount(Long overtimeCount) {
        this.overtimeCount = overtimeCount;
        return this;
    }

    public Long getDoneCount() {
        return doneCount;
    }

    public PendingItem setDoneCount(Long doneCount) {
        this.doneCount = doneCount;
        return this;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public PendingItem setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    public Integer getHandleState() {
        return handleState;
    }

    public void setHandleState(Integer handleState) {
        this.handleState = handleState;
    }

    public Long getHandleCount() {
        return handleCount;
    }

    public void setHandleCount(Long handleCount) {
        this.handleCount = handleCount;
    }

    public Integer getReaded() {
        return readed;
    }

    public void setReaded(Integer readed) {
        this.readed = readed;
    }

    public Date getReadTime() {
        return readTime;
    }

    public void setReadTime(Date readTime) {
        this.readTime = readTime;
    }

    public List<UserMessage> getUserMessageList() {
        return userMessageList;
    }

    public void setUserMessageList(List<UserMessage> userMessageList) {
        this.userMessageList = userMessageList;
    }
}
