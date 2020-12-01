package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * UserMessageForm
 *
 * @Author zlx
 * @Date 2020/5/13 15:40
 */
public class UserMessageForm {

    public static class Search{
        private String key;
        private String msgType;
        private String title;
        private String content;
        private Long userId;
        private Integer readed;

        /**
         * 各个业务ID
         */
        private String bizId;
        /**
         * 各个业务表
         */
        private String bizTable;

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

        public String getTitle() {
            return title;
        }

        public Search setTitle(String title) {
            this.title = title;
            return this;
        }

        public String getContent() {
            return content;
        }

        public Search setContent(String content) {
            this.content = content;
            return this;
        }

        public Long getUserId() {
            return userId;
        }

        public Search setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Integer getReaded() {
            return readed;
        }

        public Search setReaded(Integer readed) {
            this.readed = readed;
            return this;
        }

        public String getBizId() {
            return bizId;
        }

        public Search setBizId(String bizId) {
            this.bizId = bizId;
            return this;
        }

        public String getBizTable() {
            return bizTable;
        }

        public Search setBizTable(String bizTable) {
            this.bizTable = bizTable;
            return this;
        }
    }

    public static class Add{
        private String msgType;
        private String title;
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
        private String bizTable;

        private Long userId;
        private Integer readed;
        private Date readTime;
        private Date createTime;
        private Date updateTime;
        private Long msgId;


        public Long getMsgId() {
            return msgId;
        }

        public Add setMsgId(Long msgId) {
            this.msgId = msgId;
            return this;
        }

        public String getMsgType() {
            return msgType;
        }

        public Add setMsgType(String msgType) {
            this.msgType = msgType;
            return this;
        }

        public String getTitle() {
            return title;
        }

        public Add setTitle(String title) {
            this.title = title;
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

        public Long getUserId() {
            return userId;
        }

        public Add setUserId(Long userId) {
            this.userId = userId;
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

        public String getAppUrl() {
            return appUrl;
        }

        public Add setAppUrl(String appUrl) {
            this.appUrl = appUrl;
            return this;
        }

        public String getBizId() {
            return bizId;
        }

        public Add setBizId(String bizId) {
            this.bizId = bizId;
            return this;
        }

        public String getBizTable() {
            return bizTable;
        }

        public Add setBizTable(String bizTable) {
            this.bizTable = bizTable;
            return this;
        }
    }

    public static class Get{
        @NotNull(message = "主键id不能为空")
        private Long id;
        private Integer type;

        public Integer getType() {
            return type;
        }

        public Get setType(Integer type) {
            this.type = type;
            return this;
        }

        public Long getId() {
            return id;
        }

        public Get setId(Long id) {
            this.id = id;
            return this;
        }

    }

    public static class Edit{
        private Long id;
        private String msgType;
        private String title;
        private String content;
        private String url;
        private Long userId;
        private Integer readed;
        private Date readTime;
        private Date createTime;
        private Date updateTime;
        private Long msgId;
        /**
         * 各个业务ID
         */
        private String bizId;
        private String bizTable;


        public Long getMsgId() {
            return msgId;
        }

        public Edit setMsgId(Long msgId) {
            this.msgId = msgId;
            return this;
        }

        public Long getId() {
            return id;
        }

        public Edit setId(Long id) {
            this.id = id;
            return this;
        }

        public String getMsgType() {
            return msgType;
        }

        public Edit setMsgType(String msgType) {
            this.msgType = msgType;
            return this;
        }

        public String getTitle() {
            return title;
        }

        public Edit setTitle(String title) {
            this.title = title;
            return this;
        }

        public String getContent() {
            return content;
        }

        public Edit setContent(String content) {
            this.content = content;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Edit setUrl(String url) {
            this.url = url;
            return this;
        }

        public Long getUserId() {
            return userId;
        }

        public Edit setUserId(Long userId) {
            this.userId = userId;
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

        public Date getCreateTime() {
            return createTime;
        }

        public Edit setCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public Date getUpdateTime() {
            return updateTime;
        }

        public Edit setUpdateTime(Date updateTime) {
            this.updateTime = updateTime;
            return this;
        }

        public String getBizId() {
            return bizId;
        }

        public Edit setBizId(String bizId) {
            this.bizId = bizId;
            return this;
        }

        public String getBizTable() {
            return bizTable;
        }

        public Edit setBizTable(String bizTable) {
            this.bizTable = bizTable;
            return this;
        }
    }

    public static class Delete{
        @NotNull(message = "主键id不能为空")
        private Long id;

        public Long getId() {
            return id;
        }

        public Delete setId(Long id) {
            this.id = id;
            return this;
        }
    }

    public static class batchUpdateMessageStatus {
        @NotNull(message = "用户id不能为空")
        private Long userId;
        private String msgType;
        public Long getUserId() {
            return userId;
        }

        public batchUpdateMessageStatus setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public String getMsgType() {
            return msgType;
        }

        public batchUpdateMessageStatus setMsgType(String msgType) {
            this.msgType = msgType;
            return this;
        }
    }

    public static class CountItem{
        private String msgType;
        @NotNull(message = "用户Id不能为空")
        private Long userId;

        public String getMsgType() {
            return msgType;
        }

        public CountItem setMsgType(String msgType) {
            this.msgType = msgType;
            return this;
        }

        public Long getUserId() {
            return userId;
        }

        public CountItem setUserId(Long userId) {
            this.userId = userId;
            return this;
        }
    }

    public static class DeleteByMsgId{
        @NotNull(message = "消息id不能为空")
        private List<Long> msgId;

        public List<Long> getMsgId() {
            return msgId;
        }

        public DeleteByMsgId setMsgId(List<Long> msgId) {
            this.msgId = msgId;
            return this;
        }
    }

    public static class EditContentByMsgId{
        @NotNull(message = "消息id不能为空")
        private Long msgId;
        private String title;
        private String content;

        public Long getMsgId() {
            return msgId;
        }

        public EditContentByMsgId setMsgId(Long msgId) {
            this.msgId = msgId;
            return this;
        }

        public String getTitle() {
            return title;
        }

        public EditContentByMsgId setTitle(String title) {
            this.title = title;
            return this;
        }

        public String getContent() {
            return content;
        }

        public EditContentByMsgId setContent(String content) {
            this.content = content;
            return this;
        }
    }

    public static class GetByUserId{
        @NotNull(message = "userId不能为空")
        private Long userId;
        private String msgType;

        private String bizId;

        private String bizTable;

        public String getMsgType() {
            return msgType;
        }

        public GetByUserId setMsgType(String msgType) {
            this.msgType = msgType;
            return this;
        }

        public Long getUserId() {
            return userId;
        }

        public GetByUserId setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public String getBizId() {
            return bizId;
        }

        public void setBizId(String bizId) {
            this.bizId = bizId;
        }

        public String getBizTable() {
            return bizTable;
        }

        public void setBizTable(String bizTable) {
            this.bizTable = bizTable;
        }
    }
}
