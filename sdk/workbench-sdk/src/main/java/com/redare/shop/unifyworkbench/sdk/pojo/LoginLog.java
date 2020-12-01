package com.redare.shop.unifyworkbench.sdk.pojo;

import java.util.Date;

/**
 * @description: 日志管理
 * @author: zlx
 * @date: Created in 2020/7/29 10:08
 * @version: 1.1
 */
public class LoginLog {

    /**
     * 主键id
     */
    private Long id;
    /**
     * 日志类型
     */
    private String classify;
    /**
     * 操作人
     */
    private String operator;
    /**
     * 日志内容
     */
    private String content;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 日志来源（PC端、手机端）
     */
    private String source;

    public String getSource() {
        return source;
    }

    public LoginLog setSource(String source) {
        this.source = source;
        return this;
    }

    public Long getId() {
        return id;
    }

    public LoginLog setId(Long id) {
        this.id = id;
        return this;
    }

    public String getClassify() {
        return classify;
    }

    public LoginLog setClassify(String classify) {
        this.classify = classify;
        return this;
    }

    public String getOperator() {
        return operator;
    }

    public LoginLog setOperator(String operator) {
        this.operator = operator;
        return this;
    }

    public String getContent() {
        return content;
    }

    public LoginLog setContent(String content) {
        this.content = content;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public LoginLog setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }
}
