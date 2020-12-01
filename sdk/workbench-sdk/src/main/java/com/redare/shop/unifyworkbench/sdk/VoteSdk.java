package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.Vote;
import com.redare.shop.unifyworkbench.sdk.pojo.form.VoteForm;

import java.util.List;

/**
 * 投票信息表(Vote)SDK
 *
 * @author zhangsq
 * @since 2020-10-27 11:29:43
 */
public interface VoteSdk {

    /**
     * @description: 分页查询投票列表
     * @author: zhangsq
     * @date: Created in 2020-10-27 11:35
     * @param form
     * @param curPage
     * @param pageSize
     * @return: com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.Vote>>
     * @exception:
     */
    CommonResult<Page<Vote>> queryForPageVote(VoteForm.Search form, int curPage, int pageSize);
    /**
     * @description: 分页查询投票列表数据
     * @author: zhangsq
     * @date: Created in 2020-10-27 11:35
     * @param form
     * @param curPage
     * @param pageSize
     * @return: com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.Vote>>
     * @exception:
     */
    CommonResult<List<Vote>> queryForPageListVote(VoteForm.Search form, int curPage, int pageSize);

    /**
     * @description: 查询所有投票数据，不分页
     * @author: zhangsq
     * @date: Created in 2020-10-27 11:34
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.Vote>>
     * @exception:
     */
    CommonResult<List<Vote>> queryForListVote(VoteForm.Search form);

    /**
     * @description: 根据主键id查询投票数据
     * @author: zhangsq
     * @date: Created in 2020-10-27 11:41
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<com.redare.shop.unifyworkbench.sdk.pojo.Vote>
     * @exception:
     */
    CommonResult<Vote> findByIdVote(VoteForm.Get form);

    /**
     * @description: 添加投票数据
     * @author: zhangsq
     * @date: Created in 2020-10-27 11:41
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.String>
     * @exception:
     */
    CommonResult<Boolean> insertVote(VoteForm.Add form);

    /**
     * @description: 批量添加
     * @author: zhangsq
     * @date: Created in 2020-10-27 15:09
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    public CommonResult<Boolean> batchInsertVote(VoteForm.BatchAdd form);


    /**
     * @description: 编辑投票数据
     * @author: zhangsq
     * @date: Created in 2020-10-27 11:41
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.String>
     * @exception:
     */
    CommonResult<Boolean> updateVote(VoteForm.Edit form);
    /**
     * @description: 删除投票信息
     * @author: zhangsq
     * @date: Created in 2020-10-27 11:40
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    CommonResult<Boolean> delVote(VoteForm.Del form);

    /**
     * @description: 批量删除数据
     * @author: zhangsq
     * @date: Created in 2020-10-27 14:57
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception: 
     */
    public CommonResult<Boolean> batchDelVote(VoteForm.BatchDel form);

}