package com.redare.shop.unifyworkbench.sdk.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : zhangsq
 * @version :
 * @description：投票结果t_vote_result
 * @date ：Created in 2020-10-30 16:17
 */
public class VoteResult implements Serializable {

    private static final long serialVersionUID = -5017043516326741223L;

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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVoteId() {
        return voteId;
    }

    public void setVoteId(Long voteId) {
        this.voteId = voteId;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public Long getVoteUserId() {
        return voteUserId;
    }

    public void setVoteUserId(Long voteUserId) {
        this.voteUserId = voteUserId;
    }

    public String getVoteUserName() {
        return voteUserName;
    }

    public void setVoteUserName(String voteUserName) {
        this.voteUserName = voteUserName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
