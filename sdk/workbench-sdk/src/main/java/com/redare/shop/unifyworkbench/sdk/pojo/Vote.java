package com.redare.shop.unifyworkbench.sdk.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 投票信息表(Vote)实体类
 *
 * @author zhangsq
 * @since 2020-10-27 11:29:42
 */
public class Vote implements Serializable {
    private static final long serialVersionUID = -16005712988697918L;
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgid(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgname(String orgName) {
        this.orgName = orgName;
    }

    public Integer getVoteTypeId() {
        return voteTypeId;
    }

    public void setVotetypeid(Integer voteTypeId) {
        this.voteTypeId = voteTypeId;
    }

    public String getVoteTypeName() {
        return voteTypeName;
    }

    public void setVotetypename(String voteTypeName) {
        this.voteTypeName = voteTypeName;
    }

    public String getVoteTitle() {
        return voteTitle;
    }

    public void setVotetitle(String voteTitle) {
        this.voteTitle = voteTitle;
    }

    public String getVotingOptions() {
        return votingOptions;
    }

    public void setVotingoptions(String votingOptions) {
        this.votingOptions = votingOptions;
    }

    public Date getVoteEndTime() {
        return voteEndTime;
    }

    public void setVoteendtime(Date voteEndTime) {
        this.voteEndTime = voteEndTime;
    }

    public Integer getIsMultiSelect() {
        return isMultiSelect;
    }

    public void setIsmultiselect(Integer isMultiSelect) {
        this.isMultiSelect = isMultiSelect;
    }

    public String getIsAnonymous() {
        return isAnonymous;
    }

    public void setIsanonymous(String isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreatetime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdatetime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}