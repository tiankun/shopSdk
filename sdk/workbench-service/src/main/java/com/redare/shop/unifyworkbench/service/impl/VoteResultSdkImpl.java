package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.shop.unifyworkbench.sdk.VoteResultSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.VoteNumber;
import com.redare.shop.unifyworkbench.sdk.pojo.VoteResult;
import com.redare.shop.unifyworkbench.sdk.pojo.form.VoteResultForm;
import com.redare.shop.unifyworkbench.service.service.VoteResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : zhangsq
 * @version :
 * @description：投票结果SDK接口实现
 * @date ：Created in 2020-10-30 16:41
 */
@Service
public class VoteResultSdkImpl implements VoteResultSdk {

    @Autowired
    VoteResultService voteResultService;

    /**
     * @description: 分页查询
     * @author: zhangsq
     * @date: Created in 2020-10-30 17:10
     * @param form
     * @param curPage
     * @param pageSize
     * @return: com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.VoteResult>>
     * @exception:
     */
    @Override
    public CommonResult<Page<VoteResult>> findVoteResultPage(VoteResultForm.Search form, int curPage, int pageSize) {
        return CommonResult.returnSuccessWrapper(voteResultService.findVoteResultPage(form, curPage, pageSize));
    }

    /**
     * @description: 分页查询列表数据
     * @author: zhangsq
     * @date: Created in 2020-10-30 17:10
     * @param form
     * @param curPage
     * @param pageSize
     * @return: com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.VoteResult>>
     * @exception:
     */
    @Override
    public CommonResult<List<VoteResult>> findVoteResultPageList(VoteResultForm.Search form, int curPage, int pageSize) {
        return CommonResult.returnSuccessWrapper(voteResultService.findVoteResultPageList(form, curPage, pageSize));
    }
    /**
     * @description: 查询所有数据
     * @author: zhangsq
     * @date: Created in 2020-10-30 17:10
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.VoteResult>>
     * @exception:
     */
    @Override
    public CommonResult<List<VoteResult>> findVoteResultList(VoteResultForm.Search form) {
        return CommonResult.returnSuccessWrapper(voteResultService.findVoteResultList(form));
    }
    /**
     * @description: 根据id查询数据
     * @author: zhangsq
     * @date: Created in 2020-10-30 17:10
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<com.redare.shop.unifyworkbench.sdk.pojo.VoteResult>
     * @exception:
     */
    @Override
    public CommonResult<VoteResult> findByIdVoteResult(VoteResultForm.Get form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        return CommonResult.returnSuccessWrapper(voteResultService.findByIdVoteResult(form));
    }
    /**
     * @description: 添加数据
     * @author: zhangsq
     * @date: Created in 2020-10-30 17:09
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    @Override
    public CommonResult<Boolean> addVoteResult(VoteResultForm.Add form) {
        if (form.getVoteId() == null){
            return CommonResult.returnFailsWrapper("投票id不能为空");
        }
        VoteResultForm.Get get = new VoteResultForm.Get();
        get.setVoteId(form.getVoteId());
        get.setVoteUserId(form.getVoteUserId());
        List<VoteResult> voteResult = voteResultService.findByOptionsVoteResult(get);
        if(null != voteResult  && voteResult.size() > 0 ){
            // 已经投过票了
            return CommonResult.returnBoolWrapper(false,"已投票");
        } else {
            return CommonResult.returnBoolWrapper(voteResultService.addVoteResult(form),"添加失败");
        }

    }

    /**
     * @description: 批量添加
     * @author: zhangsq
     * @date: Created in 2020-10-21 11:18
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    @Override
    public CommonResult<Boolean> batchAddVoteResult(VoteResultForm.BatchAdd form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        return CommonResult.returnBoolWrapper(voteResultService.batchAddVoteResult(form),"添加失败");
    }

    /**
     * @description: 编辑数据
     * @author: zhangsq
     * @date: Created in 2020-10-30 17:09
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    @Override
    public CommonResult<Boolean> editVoteResult(VoteResultForm.Edit form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        return CommonResult.returnBoolWrapper(voteResultService.editVoteResult(form),"编辑失败");
    }
    /**
     * @description: 删除数据
     * @author: zhangsq
     * @date: Created in 2020-10-30 17:09
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    @Override
    public CommonResult<Boolean> delVoteResult(VoteResultForm.Del form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        return CommonResult.returnBoolWrapper(voteResultService.delVoteResult(form),"删除失败");
    }

    /**
     * @description: 批量删除数据
     * @author: zhangsq
     * @date: Created in 2020-10-30 17:09
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    @Override
    public CommonResult<Boolean> batchDelVoteResult(VoteResultForm.BatchDel form) {
        return CommonResult.returnBoolWrapper(voteResultService.batchDelVoteResult(form) > 0,"删除失败");
    }


    /**
     * @description: 分页查询投票数
     * @author: zhangsq
     * @date: Created in 2020-10-30 18:38
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.VoteResult>>
     * @exception:
     */
    @Override
    public CommonResult<List<VoteNumber>> findVoteNumberPage(VoteResultForm.Search form) {
        return CommonResult.returnSuccessWrapper(voteResultService.findVoteNumberPage(form));
    }
}
