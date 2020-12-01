package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

/**
 * 投票信息表(Vote)Form
 *
 * @author zhangsq
 * @since 2020-10-27 11:29:42
 */
public class VoteForm {

    public static class Add{
        /**
         * 自增主键
         */
        private Long id;
        /**
         * 组织机构Id
         */
        private String orgId;
        /**
         * 组织机构名称
         */
        private String orgName;
        /**
         * 投票类型Id（数据字典）
         */
        private Integer voteTypeId;
        /**
         * 投票类型名称（数据字典）
         */
        private String voteTypeName;
        /**
         * 投票主题
         */
        private String voteTitle;
        /**
         * 投票选项（JSON字符串）
         */
        private String votingOptions;
        /**
         * 投票截止时间
         */
        private Date voteEndTime;
        /**
         * 是否允许多选（0-不允许，1-允许）
         */
        private Integer isMultiSelect;
        /**
         * 是否匿名投票（0-不匿名投票，1-匿名投票）
         */
        private String isAnonymous;
        /**
         * 删除状态（0-未删除，1-已删除）
         */
        private Integer status;
        /**
         * 操作人
         */
        private String operator;
        /**
         * 创建时间
         */
        private Date createTime;
        /**
         * 修改时间
         */
        private Date updateTime;
        /**
         * 备注
         */
        private String remark;

        public Long getId() {
            return id;
        }

        public Add setId(Long id) {
            this.id = id;
            return this;
        }

        public String getOrgId() {
            return orgId;
        }

        public Add setOrgId(String orgId) {
            this.orgId = orgId;
            return this;
        }

        public String getOrgName() {
            return orgName;
        }

        public Add setOrgName(String orgName) {
            this.orgName = orgName;
            return this;
        }

        public Integer getVoteTypeId() {
            return voteTypeId;
        }

        public Add setVoteTypeId(Integer voteTypeId) {
            this.voteTypeId = voteTypeId;
            return this;
        }

        public String getVoteTypeName() {
            return voteTypeName;
        }

        public Add setVoteTypeName(String voteTypeName) {
            this.voteTypeName = voteTypeName;
            return this;
        }

        public String getVoteTitle() {
            return voteTitle;
        }

        public Add setVoteTitle(String voteTitle) {
            this.voteTitle = voteTitle;
            return this;
        }

        public String getVotingOptions() {
            return votingOptions;
        }

        public Add setVotingOptions(String votingOptions) {
            this.votingOptions = votingOptions;
            return this;
        }

        public Date getVoteEndTime() {
            return voteEndTime;
        }

        public Add setVoteEndTime(Date voteEndTime) {
            this.voteEndTime = voteEndTime;
            return this;
        }

        public Integer getIsMultiSelect() {
            return isMultiSelect;
        }

        public Add setIsMultiSelect(Integer isMultiSelect) {
            this.isMultiSelect = isMultiSelect;
            return this;
        }

        public String getIsAnonymous() {
            return isAnonymous;
        }

        public Add setIsAnonymous(String isAnonymous) {
            this.isAnonymous = isAnonymous;
            return this;
        }

        public Integer getStatus() {
            return status;
        }

        public Add setStatus(Integer status) {
            this.status = status;
            return this;
        }

        public String getOperator() {
            return operator;
        }

        public Add setOperator(String operator) {
            this.operator = operator;
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

        public String getRemark() {
            return remark;
        }

        public Add setRemark(String remark) {
            this.remark = remark;
            return this;
        }
    }

    public static class Edit {
        /**
         * 自增主键
         */
        private Long id;
        /**
         * 组织机构Id
         */
        private String orgId;
        /**
         * 组织机构名称
         */
        private String orgName;
        /**
         * 投票类型Id（数据字典）
         */
        private Integer voteTypeId;
        /**
         * 投票类型名称（数据字典）
         */
        private String voteTypeName;
        /**
         * 投票主题
         */
        private String voteTitle;
        /**
         * 投票选项（JSON字符串）
         */
        private String votingOptions;
        /**
         * 投票截止时间
         */
        private Date voteEndTime;
        /**
         * 是否允许多选（0-不允许，1-允许）
         */
        private Integer isMultiSelect;
        /**
         * 是否匿名投票（0-不匿名投票，1-匿名投票）
         */
        private String isAnonymous;
        /**
         * 删除状态（0-未删除，1-已删除）
         */
        private Integer status;
        /**
         * 操作人
         */
        private String operator;
        /**
         * 创建时间
         */
        private Date createTime;
        /**
         * 修改时间
         */
        private Date updateTime;
        /**
         * 备注
         */
        private String remark;

        public Long getId() {
            return id;
        }

        public Edit setId(Long id) {
            this.id = id;
            return this;
        }

        public String getOrgId() {
            return orgId;
        }

        public Edit setOrgId(String orgId) {
            this.orgId = orgId;
            return this;
        }

        public String getOrgName() {
            return orgName;
        }

        public Edit setOrgName(String orgName) {
            this.orgName = orgName;
            return this;
        }

        public Integer getVoteTypeId() {
            return voteTypeId;
        }

        public Edit setVoteTypeId(Integer voteTypeId) {
            this.voteTypeId = voteTypeId;
            return this;
        }

        public String getVoteTypeName() {
            return voteTypeName;
        }

        public Edit setVoteTypeName(String voteTypeName) {
            this.voteTypeName = voteTypeName;
            return this;
        }

        public String getVoteTitle() {
            return voteTitle;
        }

        public Edit setVoteTitle(String voteTitle) {
            this.voteTitle = voteTitle;
            return this;
        }

        public String getVotingOptions() {
            return votingOptions;
        }

        public Edit setVotingOptions(String votingOptions) {
            this.votingOptions = votingOptions;
            return this;
        }

        public Date getVoteEndTime() {
            return voteEndTime;
        }

        public Edit setVoteEndTime(Date voteEndTime) {
            this.voteEndTime = voteEndTime;
            return this;
        }

        public Integer getIsMultiSelect() {
            return isMultiSelect;
        }

        public Edit setIsMultiSelect(Integer isMultiSelect) {
            this.isMultiSelect = isMultiSelect;
            return this;
        }

        public String getIsAnonymous() {
            return isAnonymous;
        }

        public Edit setIsAnonymous(String isAnonymous) {
            this.isAnonymous = isAnonymous;
            return this;
        }

        public Integer getStatus() {
            return status;
        }

        public Edit setStatus(Integer status) {
            this.status = status;
            return this;
        }

        public String getOperator() {
            return operator;
        }

        public Edit setOperator(String operator) {
            this.operator = operator;
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

        public String getRemark() {
            return remark;
        }

        public Edit setRemark(String remark) {
            this.remark = remark;
            return this;
        }
    }

    public static class Get {
        private Long id;

        private Integer status;

        public Long getId() {
            return id;
        }

        public Get setId(Long id) {
            this.id = id;
            return this;
        }

        public Integer getStatus() {
            return status;
        }

        public Get setStatus(Integer status) {
            this.status = status;
            return this;
        }
    }

    public static class Del {
        private Long id;

        public Long getId() {
            return id;
        }

        public Del setId(Long id) {
            this.id = id;
            return this;
        }
    }

    public static class BatchAdd {

        private List<VoteForm.Add> voteList;

        public List<Add> getVoteList() {
            return voteList;
        }

        public BatchAdd setVoteList(List<Add> voteList) {
            this.voteList = voteList;
            return this;
        }
    }

    public static class BatchDel {
        /**
         * '用户ID'
         */
        @NotEmpty(message = "主键不能为空")
        List<Long> idList;

        public List<Long> getIdList() {
            return idList;
        }

        public BatchDel setIdList(List<Long> idList) {
            this.idList = idList;
            return this;
        }
    }

    public static class Search {
        /**
         * 关键字
         */
        private String key;
        /**
         * 自增主键
         */
        private Long id;

        private Integer voteStatus;

        private String orgId;

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

        public Integer getVoteStatus() {
            return voteStatus;
        }

        public Search setVoteStatus(Integer voteStatus) {
            this.voteStatus = voteStatus;
            return this;
        }

        public String getOrgId() {
            return orgId;
        }

        public Search setOrgId(String orgId) {
            this.orgId = orgId;
            return this;
        }
    }

}