package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.shop.unifyworkbench.sdk.VoteSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.Vote;
import com.redare.shop.unifyworkbench.sdk.pojo.form.VoteForm;
import com.redare.shop.unifyworkbench.service.service.VoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 投票信息表(Vote)SdkImpl
 *
 * @author zhangsq
 * @since 2020-10-27 11:30:31
 */
@Service
public class VoteSdkImpl implements VoteSdk {
    private static final Logger LOGGER = LoggerFactory.getLogger(VoteSdkImpl.class);
    @Autowired
    VoteService voteService;

    /**
     * @description: 分页查询投票列表
     * @author: zhangsq
     * @date: Created in 2020-10-27 11:44
     * @param form
     * @param curPage
     * @param pageSize
     * @return: com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.Vote>>
     * @exception:
     */
    @Override
    public CommonResult<Page<Vote>> queryForPageVote(VoteForm.Search form, int curPage, int pageSize) {
        Page<Vote> data = voteService.queryForPageVote(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(data);
    }

    /**
     * @description: 分页查询投票列表数据
     * @author: zhangsq
     * @date: Created in 2020-10-27 11:45
     * @param form
     * @param curPage
     * @param pageSize
     * @return: com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.Vote>>
     * @exception:
     */
    @Override
    public CommonResult<List<Vote>> queryForPageListVote(VoteForm.Search form, int curPage, int pageSize) {
        List<Vote> data = voteService.queryForPageListVote(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(data);
    }

    /**
     * @description: 查询所有投票数据，不分页
     * @author: zhangsq
     * @date: Created in 2020-10-27 11:44
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.Vote>>
     * @exception:
     */
    @Override
    public CommonResult<List<Vote>> queryForListVote(VoteForm.Search form) {
        List<Vote> data = voteService.queryForListVote(form);
        return CommonResult.returnSuccessWrapper(data);
    }

    /**
     * @description: 根据主键id查询数据
     * @author: zhangsq
     * @date: Created in 2020-10-27 15:05
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<com.redare.shop.unifyworkbench.sdk.pojo.Vote>
     * @exception: 
     */
    @Override
    public CommonResult<Vote> findByIdVote(VoteForm.Get form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        return CommonResult.returnSuccessWrapper(voteService.findByIdVote(form));
    }

    /**
     * @description: 添加
     * @author: zhangsq
     * @date: Created in 2020-10-27 15:03
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    @Override
    public CommonResult<Boolean> insertVote(VoteForm.Add form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        final long id = voteService.insertVote(form);
        return CommonResult.returnSuccessWrapper(id > 0);
    }

    /**
     * @description: 批量添加
     * @author: zhangsq
     * @date: Created in 2020-10-27 15:03
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    @Override
    public CommonResult<Boolean> batchInsertVote(VoteForm.BatchAdd form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        return CommonResult.returnBoolWrapper(voteService.batchInsertVote(form),"添加失败");
    }


    /**
     * @description: 编辑数据
     * @author: zhangsq
     * @date: Created in 2020-10-27 15:02
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    @Override
    public CommonResult<Boolean> updateVote(VoteForm.Edit form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        final VoteForm.Edit targetForm = new VoteForm.Edit();
        try {
            BeanUtils.copyProperties(form, targetForm);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return CommonResult.returnFailsWrapper(e.getMessage());
        }
        int row = voteService.updateVote(targetForm);
        return CommonResult.returnSuccessWrapper(row > 0);
    }

    /**
     * @description: 删除数据
     * @author: zhangsq
     * @date: Created in 2020-10-27 15:01
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    @Override
    public CommonResult<Boolean> delVote(VoteForm.Del form) {
        if (form == null) {
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        int bool = voteService.deleteVote(form);
        return CommonResult.returnBoolWrapper(bool > 0, "删除失败");
    }

    /**
     * @description: 批量删除数据
     * @author: zhangsq
     * @date: Created in 2020-10-27 14:57
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    @Override
    public CommonResult<Boolean> batchDelVote(VoteForm.BatchDel form) {
        return CommonResult.returnBoolWrapper(voteService.batchDelVote(form) > 0,"批量删除失败");
    }
}