package com.redare.shop.unifyworkbench.service.dao;


import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.base.SpringJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.Vote;
import com.redare.shop.unifyworkbench.sdk.pojo.form.VoteForm;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 投票信息表(Vote)表数据库访问层
 *
 * @author zhangsq
 * @since 2020-10-27 11:30:31
 */
@Repository
public class VoteDao {
    private static final String TABLE = "t_vote";

    @Autowired
    SpringJdbcHelper jdbcHelper;

    /**
     * @description: 分页查询列表数据
     * @author: zhangsq
     * @date: Created in 2020-10-27 14:39
     * @param form
     * @param curPage
     * @param pageSize
     * @param calCount
     * @param allList
     * @return: com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.Vote>
     * @exception:
     */
    public Page<Vote> queryForPageVote(VoteForm.Search form, int curPage, int pageSize, boolean calCount, boolean allList) {
        /*Sql sql = Sql.select()
                .from(TABLE)
                .where()
                .andBlikeJoinByOrIfNotBlank(form.getKey(), "voteTitle", "voteTypeName", "orgName")
                .andEqIfNotNull("id",form.getId())
                .andEqIfNotNull("status",0)
                .andEqIfNotNull("voteStatus",0)
                .orderBy().desc("voteEndTime");
        return jdbcHelper.queryForPageBean(sql.getSql().toString(), Vote.class, sql.getParams().toArray(), curPage, pageSize, calCount, allList);
*/
        StringBuilder sql = new StringBuilder();
        sql.append("select * from t_vote where 1=1 ");
        if (null != form.getId()) {
            sql.append(" and id = '"+form.getId()+"'");
        }
        if (StringUtils.isNotBlank(form.getOrgId())) {
            sql.append(" and orgId = '"+form.getOrgId()+"'");
        }
        if (StringUtils.isNotBlank(form.getKey())) {
            sql.append(" and (voteTitle like concat('%','"+form.getKey()+"','%') or voteTypeName like concat('%','"+form.getKey()+"','%') or orgName like concat('%','"+form.getKey()+"','%'))");
        }
        if(form.getVoteStatus() != null){
            if(form.getVoteStatus() == 1){
                sql.append(" and unix_timestamp(voteEndTime) >= unix_timestamp(NOW())");
            } else {
                sql.append(" and unix_timestamp(voteEndTime) < unix_timestamp(NOW())");
            }
        }
        sql.append(" and status = 0");
        sql.append(" order by voteEndTime desc");
        return jdbcHelper.queryForPageBean(sql.toString(), Vote.class, new Object[]{}, curPage, pageSize, calCount, allList);
    }

    /**
     * @description: 根据主键id查询数据
     * @author: zhangsq
     * @date: Created in 2020-10-27 14:38
     * @param form
     * @return: com.redare.shop.unifyworkbench.sdk.pojo.Vote
     * @exception:
     */
    public Vote findByIdVote(VoteForm.Get form){
        Sql sql = Sql.select()
                .from(TABLE)
                .where()
                .andEqIfNotNull("status",0)
                .andEqIfNotNull("id",form.getId());
        return jdbcHelper.queryForBean(sql.getSql().toString(),Vote.class,sql.getParams().toArray());
    }

    /**
     * @description: 批量添加
     * @author: zhangsq
     * @date: Created in 2020-10-27 14:33
     * @param form
     * @return: int[]
     * @exception:
     */
    public int[] batchInsertVote(VoteForm.BatchAdd form){
        Sql sql = Sql.insert(TABLE)
                .field("orgId")
                .field("orgName")
                .field("voteTypeId")
                .field("voteTypeName")
                .field("voteTitle")
                .field("votingOptions")
                .field("voteEndTime")
                .field("isMultiSelect")
                .field("isAnonymous")
                .field("status")
                .field("operator")
                .field("createTime")
                .field("updateTime")
                .field("remark");
        List<Object[]> params = new ArrayList<>();
        for (VoteForm.Add add : form.getVoteList()){
            params.add(
                    new Object[]{
                            add.getOrgId(),
                            add.getOrgName(),
                            add.getVoteTypeId(),
                            add.getVoteTypeName(),
                            add.getVoteTitle(),
                            add.getVotingOptions(),
                            add.getVoteEndTime(),
                            add.getIsMultiSelect(),
                            add.getIsAnonymous(),
                            0,
                            add.getOperator(),
                            new Date(),
                            new Date(),
                            add.getRemark(),
                    }
            );
        }
        return jdbcHelper.batchUpdate(sql.toString(), params);
    }

    /**
     * @description: 添加
     * @author: zhangsq
     * @date: Created in 2020-10-27 14:40
     * @param form
     * @return: long
     * @exception:
     */
    public long insertVote(VoteForm.Add form) {
        Sql sql = Sql.insert(TABLE)
                .field("orgId", form.getOrgId())
                .field("orgName", form.getOrgName())
                .field("voteTypeId", form.getVoteTypeId())
                .field("voteTypeName", form.getVoteTypeName())
                .field("voteTitle", form.getVoteTitle())
                .field("votingOptions", form.getVotingOptions())
                .field("voteEndTime", form.getVoteEndTime())
                .field("isMultiSelect", form.getIsMultiSelect())
                .field("isAnonymous", form.getIsAnonymous())
                .field("status", 0)
                .field("operator", form.getOperator())
                .field("createTime",  new Date())
                .field("updateTime",  new Date())
                .field("remark", form.getRemark());
        return jdbcHelper.insertReturnFieldNumber(sql).longValue();
    }

    /**
     * @description: 编辑数据
     * @author: zhangsq
     * @date: Created in 2020-10-27 14:32
     * @param form
     * @return: int
     * @exception:
     */
    public int updateVote(VoteForm.Edit form) {
        Sql sql = Sql.update(TABLE)
                .setIfNotBlank("orgId", form.getOrgId())
                .setIfNotBlank("orgName", form.getOrgName())
                .setIfNotNull("voteTypeId", form.getVoteTypeId())
                .setIfNotBlank("voteTypeName", form.getVoteTypeName())
                .setIfNotBlank("voteTitle", form.getVoteTitle())
                .setIfNotBlank("votingOptions", form.getVotingOptions())
                .setIfNotNull("voteEndTime", form.getVoteEndTime())
                .setIfNotNull("isMultiSelect", form.getIsMultiSelect())
                .setIfNotBlank("isAnonymous", form.getIsAnonymous())
                .setIfNotBlank("operator", form.getOperator())
                .setIfNotNull("updateTime", new Date())
                .setIfNotBlank("remark", form.getRemark())
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    /**
     * @description: 删除
     * @author: zhangsq
     * @date: Created in 2020-10-27 14:40
     * @param form
     * @return: int
     * @exception:
     */
    public int deleteVote(VoteForm.Del form) {
        Sql sql = Sql.update(TABLE)
                .set("status",1)
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    /**
     * @description: 删除或批量删除
     * @author: zhangsq
     * @date: Created in 2020-10-27 14:31
     * @param form
     * @return: int
     * @exception:
     */
    public int batchDelVote(VoteForm.BatchDel form) {
        Sql sql = Sql.update(TABLE)
                .set("status",1)
                .where()
                .andIn("id", form.getIdList());
        return jdbcHelper.update(sql);
    }
}