package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.Vote;
import com.redare.shop.unifyworkbench.sdk.pojo.form.VoteForm;
import com.redare.shop.unifyworkbench.service.dao.VoteDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 投票信息表(Vote)表服务接口
 *
 * @author zhangsq
 * @since 2020-10-27 11:30:31
 */
@Service
public class VoteService {
    private static final Logger LOGGER = LoggerFactory.getLogger(VoteService.class);

    @Autowired
    VoteDao voteDao;

    /**
     * @description: 分页查询
     * @author: zhangsq
     * @date: Created in 2020-10-27 14:51
     * @param form
     * @param curPage
     * @param pageSize
     * @return: com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.Vote>
     * @exception:
     */
    public Page<Vote> queryForPageVote(VoteForm.Search form, int curPage, int pageSize){
        return voteDao.queryForPageVote(form,curPage,pageSize,true,false);
    }

    /**
     * @description: 分页查询列表数据
     * @author: zhangsq
     * @date: Created in 2020-10-27 14:50
     * @param form
     * @param curPage
     * @param pageSize
     * @return: java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.Vote>
     * @exception:
     */
    public List<Vote> queryForPageListVote(VoteForm.Search form, int curPage, int pageSize){
        return voteDao.queryForPageVote(form,curPage,pageSize,false,false).getResult();
    }
    
    /**
     * @description: 查询所有数据
     * @author: zhangsq
     * @date: Created in 2020-10-27 14:47
     * @param form
     * @return: java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.Vote>
     * @exception: 
     */
    public List<Vote> queryForListVote(VoteForm.Search form){
        return voteDao.queryForPageVote(form,0,0,false,true).getResult();
    }

    /**
     * @description: 根据主键id查询数据
     * @author: zhangsq
     * @date: Created in 2020-10-27 14:46
     * @param form
     * @return: com.redare.shop.unifyworkbench.sdk.pojo.Vote
     * @exception:
     */
    public Vote findByIdVote(VoteForm.Get form){
        return voteDao.findByIdVote(form);
    }

    /**
     * @description: 添加
     * @author: zhangsq
     * @date: Created in 2020-10-27 12:09
     * @param form
     * @return: long
     * @exception:
     */
    public long insertVote(VoteForm.Add form) {
        return voteDao.insertVote(form);
    }

    /**
     * @description: 批量添加
     * @author: zhangsq
     * @date: Created in 2020-10-27 14:45
     * @param form
     * @return: boolean
     * @exception:
     */
    public boolean batchInsertVote(VoteForm.BatchAdd form){
        return voteDao.batchInsertVote(form).length>0;
    }

    /**
     * @description: 编辑
     * @author: zhangsq
     * @date: Created in 2020-10-27 12:09
     * @param form
     * @return: int
     * @exception:
     */
    public int updateVote(VoteForm.Edit form) {
        return voteDao.updateVote(form);
    }

    /**
     * @description: 删除
     * @author: zhangsq
     * @date: Created in 2020-10-27 14:43
     * @param form
     * @return: int
     * @exception:
     */
    public int deleteVote(VoteForm.Del form) {
        return voteDao.deleteVote(form);
    }


    /**
     * @description: 批量删除数据
     * @author: zhangsq
     * @date: Created in 2020-10-27 12:08
     * @param form
     * @return: java.lang.Boolean
     * @exception:
     */
    public int batchDelVote(VoteForm.BatchDel form) {
        return voteDao.batchDelVote(form);
    }

}