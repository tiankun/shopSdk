package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.VoteNumber;
import com.redare.shop.unifyworkbench.sdk.pojo.VoteResult;
import com.redare.shop.unifyworkbench.sdk.pojo.form.VoteResultForm;

import java.util.List;

/**
 * @author : zhangsq
 * @version :
 * @description：投票结果信息SDK
 * @date ：Created in 2020-10-30 16:36
 */
public interface VoteResultSdk {
    /**
     * @description: 分页查询
     * @author: zhangsq
     * @date: Created in 2020-10-30 16:39
     * @param form
     * @param curPage
     * @param pageSize
     * @return: com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.VoteResult>>
     * @exception:
     */
    CommonResult<Page<VoteResult>> findVoteResultPage(VoteResultForm.Search form, int curPage, int pageSize);
    /**
     * @description: 分页查询列表数据
     * @author: zhangsq
     * @date: Created in 2020-10-30 16:39
     * @param form
     * @param curPage
     * @param pageSize
     * @return: com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.VoteResult>>
     * @exception:
     */
    CommonResult<List<VoteResult>> findVoteResultPageList(VoteResultForm.Search form, int curPage, int pageSize);
    /**
     * @description: 查询所有数据
     * @author: zhangsq
     * @date: Created in 2020-10-30 16:39
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.VoteResult>>
     * @exception:
     */
    CommonResult<List<VoteResult>> findVoteResultList(VoteResultForm.Search form);
    /**
     * @description: 根据id查询数据
     * @author: zhangsq
     * @date: Created in 2020-10-30 16:40
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<com.redare.shop.unifyworkbench.sdk.pojo.VoteResult>
     * @exception:
     */
    CommonResult<VoteResult> findByIdVoteResult(VoteResultForm.Get form);
    /**
     * @description: 添加数据
     * @author: zhangsq
     * @date: Created in 2020-10-30 16:40
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    CommonResult<Boolean> addVoteResult(VoteResultForm.Add form);

    /**
     * @description: 批量添加
     * @author: zhangsq
     * @date: Created in 2020-10-30 16:40
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    CommonResult<Boolean> batchAddVoteResult(VoteResultForm.BatchAdd form);

    /**
     * @description: 编辑数据
     * @author: zhangsq
     * @date: Created in 2020-10-30 16:40
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    CommonResult<Boolean> editVoteResult(VoteResultForm.Edit form);
    /**
     * @description: 删除数据
     * @author: zhangsq
     * @date: Created in 2020-10-30 16:40
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    CommonResult<Boolean> delVoteResult(VoteResultForm.Del form);

    /**
     * @description: 批量删除
     * @author: zhangsq
     * @date: Created in 2020-10-30 16:40
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    CommonResult<Boolean> batchDelVoteResult(VoteResultForm.BatchDel form);

    /**
     * @description: 分页查询投票数
     * @author: zhangsq
     * @date: Created in 2020-10-30 18:38
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.VoteResult>>
     * @exception:
     */
    CommonResult<List<VoteNumber>> findVoteNumberPage(VoteResultForm.Search form);
}
