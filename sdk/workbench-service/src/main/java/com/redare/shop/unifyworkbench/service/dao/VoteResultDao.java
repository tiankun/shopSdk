package com.redare.shop.unifyworkbench.service.dao;

import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.base.SpringJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.VoteNumber;
import com.redare.shop.unifyworkbench.sdk.pojo.VoteResult;
import com.redare.shop.unifyworkbench.sdk.pojo.form.VoteResultForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : zhangsq
 * @version :
 * @description：投票结果SQL
 * @date ：Created in 2020-10-30 16:47
 */
@Repository
public class VoteResultDao {

    @Autowired
    SpringJdbcHelper jdbcHelper;

    /**
     * @description: 分页查询列表数据
     * @author: zhangsq
     * @date: Created in 2020-10-30 16:52
     * @param form
     * @param curPage
     * @param pageSize
     * @param calCount
     * @param allList
     * @return: com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.VoteResult>
     * @exception:
     */
    public Page<VoteResult> findVoteResultPage(VoteResultForm.Search form, int curPage, int pageSize, boolean calCount, boolean allList){
        Sql sql = Sql.select()
                .from("t_vote_result")
                .where()
                .andBlikeJoinByOrIfNotBlank(form.getKey(),"options","voteUserName")
                .andEqIfNotNull("voteId",form.getVoteId())
                .andEqIfNotNull("voteUserId",form.getVoteUserId())
                .orderBy().desc("id");
        return jdbcHelper.queryForPageBean(sql.getSql().toString(), VoteResult.class,sql.getParams().toArray(),curPage,pageSize,calCount,allList);
    }

    /**
     * @description: 根据投票结果id查询数据
     * @author: zhangsq
     * @date: Created in 2020-10-30 16:52
     * @param form
     * @return: com.redare.shop.unifyworkbench.sdk.pojo.VoteResult
     * @exception:
     */
    public VoteResult findByIdVoteResult(VoteResultForm.Get form){
        Sql sql = Sql.select()
                .from("t_vote_result")
                .where()
                .andEq("id",form.getId());
        return jdbcHelper.queryForBean(sql.getSql().toString(),VoteResult.class,sql.getParams().toArray());
    }

    /**
     * @description: 添加数据
     * @author: zhangsq
     * @date: Created in 2020-10-30 16:55
     * @param form
     * @return: java.lang.Long
     * @exception:
     */
    public Long addVoteResult(VoteResultForm.Add form){
        Sql sql = Sql.insert("t_vote_result")
                .field("voteId",form.getVoteId())
                .field("options",form.getOptions())
                .field("voteUserId",form.getVoteUserId())
                .field("voteUserName",form.getVoteUserName())
                .field("createTime",new Date());
        return jdbcHelper.insertReturnFieldNumber(sql.getSql().toString(),sql.getParams().toArray()).longValue();
    }

    /**
     * @description: 批量添加
     * @author: zhangsq
     * @date: Created in 2020-10-30 16:55
     * @param form
     * @return: int[]
     * @exception:
     */
    public int[] batchAddVoteResult(VoteResultForm.BatchAdd form){
        Sql sql = Sql.insert("t_vote_result")
                .field("voteId")
                .field("options")
                .field("voteUserId")
                .field("voteUserName")
                .field("createTime");
        List<Object[]> params = new ArrayList<>();
        for (VoteResultForm.Add add : form.getResList()){
            params.add(
                    new Object[]{
                            form.getVoteId(),
                            add.getOptions(),
                            add.getVoteUserId(),
                            add.getVoteUserName(),
                            new Date()
                    }
            );
        }
        return jdbcHelper.batchUpdate(sql.toString(), params);
    }

    /**
     * @description: 编辑数据
     * @author: zhangsq
     * @date: Created in 2020-10-30 16:58
     * @param form
     * @return: int
     * @exception:
     */
    public int editVoteResult(VoteResultForm.Edit form){
        Sql sql = Sql.update("t_vote_result")
                .setIfNotNull("voteId",form.getVoteId())
                .setIfNotBlank("options",form.getOptions())
                .setIfNotNull("voteUserId",form.getVoteUserId())
                .setIfNotBlank("voteUserName",form.getVoteUserName())
                .set("createTime",new Date())
                .where()
                .andEq("id",form.getId());
        return jdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    /**
     * @description: 删除数据
     * @author: zhangsq
     * @date: Created in 2020-10-30 16:58
     * @param form
     * @return: int
     * @exception:
     */
    public int delVoteResult(VoteResultForm.Del form){
        Sql sql = Sql.update("t_vote_result")
                .set("del",1)
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    /**
     * @description: 批量删除数据
     * @author: zhangsq
     * @date: Created in 2020-10-30 17:08
     * @param form
     * @return: int
     * @exception:
     */
    public int batchDelVoteResult(VoteResultForm.BatchDel form){
        Sql sql = Sql.update("t_vote_result")
                .set("del",1)
                .where()
                .andIn("userId",form.getIdList());
        return jdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    /**
     * @description: 分页查询投票数
     * @author: zhangsq
     * @date: Created in 2020-10-30 18:36
     * @param form
     * @return: com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.VoteResult>
     * @exception:
     */
    public List<VoteNumber> findVoteNumberPage(VoteResultForm.Search form){
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT `options`, COUNT(*) as voteNumber from t_vote_result where voteId = '"+form.getVoteId()+"' GROUP BY `options`");
        return jdbcHelper.queryForListBean(sql.toString(), VoteNumber.class);
    }

    public List<VoteResult> findByOptionsVoteResult(VoteResultForm.Get form){
        Sql sql = Sql.select()
                .from("t_vote_result")
                .where()
                .andEq("voteId",form.getVoteId())
                .andEqIfNotNull("voteUserId",form.getVoteUserId());
        return jdbcHelper.queryForListBean(sql.getSql().toString(),VoteResult.class,sql.getParams().toArray());
    }

}
