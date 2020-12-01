package com.redare.shop.unifyworkbench.sdk.pojo.form;

import java.util.Date;
import java.util.List;

/**
 * @author : zhangsq
 * @version :
 * @description：投票结果信息Form
 * @date ：Created in 2020-10-30 16:22
 */
public class VoteResultForm {

    public static class Add{
        /**
         * 自增主键
         */
        private Long id;
        /**
         * 投票Id
         */
        private Long voteId;
        /**
         * 投票选项
         */
        private String options;
        /**
         * 投票人Id
         */
        private Long voteUserId;
        /**
         * 投票人姓名
         */
        private String voteUserName;
        /**
         * 投票时间
         */
        private Date createTime;

        public Long getId() {
            return id;
        }

        public Add setId(Long id) {
            this.id = id;
            return this;
        }

        public Long getVoteId() {
            return voteId;
        }

        public Add setVoteId(Long voteId) {
            this.voteId = voteId;
            return this;
        }

        public String getOptions() {
            return options;
        }

        public Add setOptions(String options) {
            this.options = options;
            return this;
        }

        public Long getVoteUserId() {
            return voteUserId;
        }

        public Add setVoteUserId(Long voteUserId) {
            this.voteUserId = voteUserId;
            return this;
        }

        public String getVoteUserName() {
            return voteUserName;
        }

        public Add setVoteUserName(String voteUserName) {
            this.voteUserName = voteUserName;
            return this;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public Add setCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }
    }

    public static class BatchAdd{

        private List<VoteResultForm.Add> resList;

        private Long voteId;

        public List<Add> getResList() {
            return resList;
        }

        public BatchAdd setResList(List<Add> resList) {
            this.resList = resList;
            return this;
        }

        public Long getVoteId() {
            return voteId;
        }

        public BatchAdd setVoteId(Long voteId) {
            this.voteId = voteId;
            return this;
        }
    }

    public static class Edit{
        /**
         * 自增主键
         */
        private Long id;
        /**
         * 投票Id
         */
        private Long voteId;
        /**
         * 投票选项
         */
        private String options;
        /**
         * 投票人Id
         */
        private Long voteUserId;
        /**
         * 投票人姓名
         */
        private String voteUserName;
        /**
         * 投票时间
         */
        private Date createTime;

        public Long getId() {
            return id;
        }

        public Edit setId(Long id) {
            this.id = id;
            return this;
        }

        public Long getVoteId() {
            return voteId;
        }

        public Edit setVoteId(Long voteId) {
            this.voteId = voteId;
            return this;
        }

        public String getOptions() {
            return options;
        }

        public Edit setOptions(String options) {
            this.options = options;
            return this;
        }

        public Long getVoteUserId() {
            return voteUserId;
        }

        public Edit setVoteUserId(Long voteUserId) {
            this.voteUserId = voteUserId;
            return this;
        }

        public String getVoteUserName() {
            return voteUserName;
        }

        public Edit setVoteUserName(String voteUserName) {
            this.voteUserName = voteUserName;
            return this;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public Edit setCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }
    }

    public static class Del{
        /**
         * 自增主键
         */
        private Long id;

        public Long getId() {
            return id;
        }

        public Del setId(Long id) {
            this.id = id;
            return this;
        }
    }

    public static class Search{
        private String key;
        /**
         * 自增主键
         */
        private Long id;

        /**
         * 投票Id
         */
        private Long voteId;

        /**
         * 投票Id
         */
        private Long voteUserId;

        public String getKey() {
            return key;
        }

        public Search setKey(String key) {
            this.key = key;
            return this;
        }

        public Long getId() {
            return id;
        }

        public Search setId(Long id) {
            this.id = id;
            return this;
        }

        public Long getVoteId() {
            return voteId;
        }

        public Search setVoteId(Long voteId) {
            this.voteId = voteId;
            return this;
        }

        public Long getVoteUserId() {
            return voteUserId;
        }

        public Search setVoteUserId(Long voteUserId) {
            this.voteUserId = voteUserId;
            return this;
        }
    }

    public static class BatchDel{

        List<Long> idList;

        public List<Long> getIdList() {
            return idList;
        }

        public BatchDel setIdList(List<Long> idList) {
            this.idList = idList;
            return this;
        }
    }

    public static class Get{
        /**
         * 自增主键
         */
        private Long id;

        private Long voteId;

        private Long voteUserId;

        /**
         * 投票选项
         */
        private String options;

        public Long getId() {
            return id;
        }

        public Get setId(Long id) {
            this.id = id;
            return this;
        }

        public Long getVoteId() {
            return voteId;
        }

        public Get setVoteId(Long voteId) {
            this.voteId = voteId;
            return this;
        }

        public Long getVoteUserId() {
            return voteUserId;
        }

        public Get setVoteUserId(Long voteUserId) {
            this.voteUserId = voteUserId;
            return this;
        }

        public String getOptions() {
            return options;
        }

        public Get setOptions(String options) {
            this.options = options;
            return this;
        }
    }
}
