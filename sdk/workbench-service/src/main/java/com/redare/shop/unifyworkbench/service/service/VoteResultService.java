package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.VoteNumber;
import com.redare.shop.unifyworkbench.sdk.pojo.VoteResult;
import com.redare.shop.unifyworkbench.sdk.pojo.form.VoteResultForm;
import com.redare.shop.unifyworkbench.service.dao.VoteResultDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : zhangsq
 * @version :
 * @description：投票结果业务Service
 * @date ：Created in 2020-10-30 16:45
 */
@Service
public class VoteResultService {

    @Autowired
    VoteResultDao voteResultDao;

    /**
     * @description: 分页查询
     * @author: zhangsq
     * @date: Created in 2020-10-30 17:09
     * @param form
     * @param curPage
     * @param pageSize
     * @return: com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.VoteResult>
     * @exception:
     */
    public Page<VoteResult> findVoteResultPage(VoteResultForm.Search form, int curPage, int pageSize){
        return voteResultDao.findVoteResultPage(form,curPage,pageSize,true,false);
    }

    /**
     * @description: 分页查询列表数据
     * @author: zhangsq
     * @date: Created in 2020-10-30 17:09
     * @param form
     * @param curPage
     * @param pageSize
     * @return: java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.VoteResult>
     * @exception:
     */
    public List<VoteResult> findVoteResultPageList(VoteResultForm.Search form, int curPage, int pageSize){
        return voteResultDao.findVoteResultPage(form,curPage,pageSize,false,false).getResult();
    }

    /**
     * @description: 查询所有数据
     * @author: zhangsq
     * @date: Created in 2020-10-30 17:08
     * @param form
     * @return: java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.VoteResult>
     * @exception:
     */
    public List<VoteResult> findVoteResultList(VoteResultForm.Search form){
        return voteResultDao.findVoteResultPage(form,0,0,false,true).getResult();
    }

    /**
     * @description: 根据id查询数据
     * @author: zhangsq
     * @date: Created in 2020-10-30 17:08
     * @param form
     * @return: com.redare.shop.unifyworkbench.sdk.pojo.VoteResult
     * @exception:
     */
    public VoteResult findByIdVoteResult(VoteResultForm.Get form){
        return voteResultDao.findByIdVoteResult(form);
    }

    /**
     * @description: 添加数据
     * @author: zhangsq
     * @date: Created in 2020-10-30 17:08
     * @param form
     * @return: boolean
     * @exception:
     */
    public boolean addVoteResult(VoteResultForm.Add form){
        return voteResultDao.addVoteResult(form) > 0;
    }

    /**
     * @description: 批量添加
     * @author: zhangsq
     * @date: Created in 2020-10-30 17:08
     * @param form
     * @return: boolean
     * @exception:
     */
    public boolean batchAddVoteResult(VoteResultForm.BatchAdd form){
        return voteResultDao.batchAddVoteResult(form).length>0;
    }

    /**
     * @description: 编辑数据
     * @author: zhangsq
     * @date: Created in 2020-10-30 17:08
     * @param form
     * @return: boolean
     * @exception:
     */
    public boolean editVoteResult(VoteResultForm.Edit form){
        return voteResultDao.editVoteResult(form) > 0;
    }

    /**
     * @description: 删除数据
     * @author: zhangsq
     * @date: Created in 2020-10-30 17:08
     * @param form
     * @return: boolean
     * @exception:
     */
    public boolean delVoteResult(VoteResultForm.Del form){
        return voteResultDao.delVoteResult(form) > 0;
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
        return voteResultDao.batchDelVoteResult(form);
    }

    /**
     * @description: 分页查询投票数
     * @author: zhangsq
     * @date: Created in 2020-10-30 18:37
     * @param form
     * @return: com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.VoteResult>
     * @exception:
     */
    public List<VoteNumber> findVoteNumberPage(VoteResultForm.Search form){
        return voteResultDao.findVoteNumberPage(form);
    }

    public List<VoteResult> findByOptionsVoteResult(VoteResultForm.Get form){
        return voteResultDao.findByOptionsVoteResult(form);
    };
}
