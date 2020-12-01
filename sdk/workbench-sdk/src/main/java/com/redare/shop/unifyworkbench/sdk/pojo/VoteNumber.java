package com.redare.shop.unifyworkbench.sdk.pojo;

import java.io.Serializable;

/**
 * @author : zhangsq
 * @version :
 * @description：投票统计票数Entity
 * @date ：Created in 2020-10-30 18:29
 */
public class VoteNumber implements Serializable {

    private static final long serialVersionUID = 3538827628932752804L;

    private String options;

    private Long voteNumber;

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public Long getVoteNumber() {
        return voteNumber;
    }

    public void setVoteNumber(Long voteNumber) {
        this.voteNumber = voteNumber;
    }
}
