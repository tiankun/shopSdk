package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class MessageReceiveuserForm {

    public static class Search{

        private String msgId;

        private String userId;

        private String account;

        private String name;

        private Long ztktUserId;

        private String departmentId;

        private String departmentName;

        private Integer readed;

        private Date readTime;

        public String getMsgId() {
            return msgId;
        }

        public Search setMsgId(String msgId) {
            this.msgId = msgId;
            return this;
        }

        public String getUserId() {
            return userId;
        }

        public Search setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public String getAccount() {
            return account;
        }

        public Search setAccount(String account) {
            this.account = account;
            return this;
        }

        public String getName() {
            return name;
        }

        public Search setName(String name) {
            this.name = name;
            return this;
        }

        public Long getZtktUserId() {
            return ztktUserId;
        }

        public Search setZtktUserId(Long ztktUserId) {
            this.ztktUserId = ztktUserId;
            return this;
        }

        public String getDepartmentId() {
            return departmentId;
        }

        public Search setDepartmentId(String departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public String getDepartmentName() {
            return departmentName;
        }

        public Search setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
            return this;
        }

        public Integer getReaded() {
            return readed;
        }

        public Search setReaded(Integer readed) {
            this.readed = readed;
            return this;
        }

        public Date getReadTime() {
            return readTime;
        }

        public Search setReadTime(Date readTime) {
            this.readTime = readTime;
            return this;
        }
    }

    public static class Add{
        @NotNull(message = "待阅消息id不能为空")
        private String msgId;

        private String userId;

        private String account;

        private String name;

        private Long ztktUserId;

        private String departmentId;

        private String departmentName;

        private Integer readed;

        private Date readTime;

        public String getMsgId() {
            return msgId;
        }

        public Add setMsgId(String msgId) {
            this.msgId = msgId;
            return this;
        }

        public String getUserId() {
            return userId;
        }

        public Add setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public String getAccount() {
            return account;
        }

        public Add setAccount(String account) {
            this.account = account;
            return this;
        }

        public String getName() {
            return name;
        }

        public Add setName(String name) {
            this.name = name;
            return this;
        }

        public Long getZtktUserId() {
            return ztktUserId;
        }

        public Add setZtktUserId(Long ztktUserId) {
            this.ztktUserId = ztktUserId;
            return this;
        }

        public String getDepartmentId() {
            return departmentId;
        }

        public Add setDepartmentId(String departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public String getDepartmentName() {
            return departmentName;
        }

        public Add setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
            return this;
        }

        public Integer getReaded() {
            return readed;
        }

        public Add setReaded(Integer readed) {
            this.readed = readed;
            return this;
        }

        public Date getReadTime() {
            return readTime;
        }

        public Add setReadTime(Date readTime) {
            this.readTime = readTime;
            return this;
        }
    }

    public static class Edit{
        @NotNull(message = "主键id不能为空")
        private Long id;
        @NotNull(message = "待阅消息id不能为空")
        private String msgId;

        private String userId;

        private String account;

        private String name;

        private Long ztktUserId;

        private String departmentId;

        private String departmentName;

        private Integer readed;

        private Date readTime;

        public Long getId() {
            return id;
        }

        public Edit setId(Long id) {
            this.id = id;
            return this;
        }

        public String getMsgId() {
            return msgId;
        }

        public Edit setMsgId(String msgId) {
            this.msgId = msgId;
            return this;
        }

        public String getUserId() {
            return userId;
        }

        public Edit setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public String getAccount() {
            return account;
        }

        public Edit setAccount(String account) {
            this.account = account;
            return this;
        }

        public String getName() {
            return name;
        }

        public Edit setName(String name) {
            this.name = name;
            return this;
        }

        public Long getZtktUserId() {
            return ztktUserId;
        }

        public Edit setZtktUserId(Long ztktUserId) {
            this.ztktUserId = ztktUserId;
            return this;
        }

        public String getDepartmentId() {
            return departmentId;
        }

        public Edit setDepartmentId(String departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public String getDepartmentName() {
            return departmentName;
        }

        public Edit setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
            return this;
        }

        public Integer getReaded() {
            return readed;
        }

        public Edit setReaded(Integer readed) {
            this.readed = readed;
            return this;
        }

        public Date getReadTime() {
            return readTime;
        }

        public Edit setReadTime(Date readTime) {
            this.readTime = readTime;
            return this;
        }
    }

    public static class Get{

        private Long id;

        private String msgId;

        private String userId;

        public Long getId() {
            return id;
        }

        public Get setId(Long id) {
            this.id = id;
            return this;
        }

        public String getMsgId() {
            return msgId;
        }

        public Get setMsgId(String msgId) {
            this.msgId = msgId;
            return this;
        }

        public String getUserId() {
            return userId;
        }

        public Get setUserId(String userId) {
            this.userId = userId;
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
