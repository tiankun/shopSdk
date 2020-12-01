package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.shop.unifyworkbench.sdk.UserHonorSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.UserHonor;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserHonorForm;
import com.redare.shop.unifyworkbench.service.service.UserHonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : zhangsq
 * @version :
 * @description：人员荣誉接口实现类
 * @date ：Created in 2020-10-20 14:51
 */
@Service
public class UserHonorSdkImpl implements UserHonorSdk {

    @Autowired
    UserHonorService userHonorService;

    /**
     * @description: 分页查询
     * @author: zhangsq
     * @date: Created in 2020-10-20 14:26
     * @param form
     * @param curPage
     * @param pageSize
     * @return: com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.UserHonor>>
     * @exception:
     */
    @Override
    public CommonResult<Page<UserHonor>> findUserHonorPage(UserHonorForm.Search form, int curPage, int pageSize) {
        return CommonResult.returnSuccessWrapper(userHonorService.findUserHonorPage(form, curPage, pageSize));
    }
    /**
     * @description: 分页查询列表数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 14:26
     * @param form
     * @param curPage
     * @param pageSize
     * @return: com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserHonor>>
    Honor* @exception:
     */
    @Override
    public CommonResult<List<UserHonor>> findUserHonorPageList(UserHonorForm.Search form, int curPage, int pageSize) {
        return CommonResult.returnSuccessWrapper(userHonorService.findUserHonorPageList(form, curPage, pageSize));
    }
    /**
     * @description: 查询所有数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 14:26
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserHonor>>
     * @exception:
     */
    @Override
    public CommonResult<List<UserHonor>> findUserHonorList(UserHonorForm.Search form) {
        return CommonResult.returnSuccessWrapper(userHonorService.findUserHonorList(form));
    }
    /**
     * @description: 根据荣誉id查询数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 14:27
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<com.redare.shop.unifyworkbench.sdk.pojo.UserHonor>
     * @exception:
     */
    @Override
    public CommonResult<UserHonor> findUserHonor(UserHonorForm.Get form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        return CommonResult.returnSuccessWrapper(userHonorService.findUserHonor(form));
    }
    /**
     * @description: 添加数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 14:27
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    @Override
    public CommonResult<Boolean> addUserHonor(UserHonorForm.Add form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        return CommonResult.returnBoolWrapper(userHonorService.addUserHonor(form),"添加失败");
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
    public CommonResult<Boolean> batchAddUserHonor(UserHonorForm.BatchAdd form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        return CommonResult.returnBoolWrapper(userHonorService.batchAddUserHonor(form),"添加失败");
    }

    /**
     * @description: 编辑数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 14:27
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    @Override
    public CommonResult<Boolean> editUserHonor(UserHonorForm.Edit form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        return CommonResult.returnBoolWrapper(userHonorService.editUserHonor(form),"编辑失败");
    }
    /**
     * @description: 删除数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 14:27
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */

    @Override
    public CommonResult<Boolean> delUserHonor(UserHonorForm.Del form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        return CommonResult.returnBoolWrapper(userHonorService.delUserHonor(form),"删除失败");
    }

    /**
     * @description: 批量删除数据
     * @author: zhangsq
     * @date: Created in 2020-10-21 11:03
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    @Override
    public CommonResult<Boolean> batchDelUserHonor(UserHonorForm.BatchDel form) {
        return CommonResult.returnBoolWrapper(userHonorService.batchDelUserHonor(form) > 0,"删除失败");
    }
}
