package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.shop.unifyworkbench.sdk.IosCodedowloadSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.IosCodedowload;
import com.redare.shop.unifyworkbench.sdk.pojo.form.IosCodedowloadForm;
import com.redare.shop.unifyworkbench.service.service.IosCodedowloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/7/17 11:49
 * @version: 1.1
 */
@Service
public class IosCodedowloadSdkImpl implements IosCodedowloadSdk {


    @Autowired
    IosCodedowloadService iosCodedowloadService;

    /**
     * @description 分页查询
     * @author zlx
     * @date 2020/7/17 11:54
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.IosCodedowload>>
     */
    @Override
    public CommonResult<Page<IosCodedowload>> findIosCodedowloadPage(IosCodedowloadForm.Search form, int curPage, int pageSize) {
        return CommonResult.returnSuccessWrapper(iosCodedowloadService.findIosCodedowloadPage(form, curPage, pageSize));
    }

    /**
     * @description 分页查询列表
     * @author zlx
     * @date 2020/7/17 11:54
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.IosCodedowload>>
     */
    @Override
    public CommonResult<List<IosCodedowload>> findIosCodedowloadList(IosCodedowloadForm.Search form, int curPage, int pageSize) {
        return CommonResult.returnSuccessWrapper(iosCodedowloadService.findIosCodedowloadList(form, curPage, pageSize));
    }

    /**
     * @description 查询所有数据
     * @author zlx
     * @date 2020/7/17 11:54
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.IosCodedowload>>
     */
    @Override
    public CommonResult<List<IosCodedowload>> findIosCodedowloadList(IosCodedowloadForm.Search form) {
        return CommonResult.returnSuccessWrapper(iosCodedowloadService.findIosCodedowloadList(form));
    }

    /**
     * @description 根据主键id查询数据
     * @author zlx
     * @date 2020/7/17 11:57
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.shop.unifyworkbench.sdk.pojo.IosCodedowload>
     */
    @Override
    public CommonResult<IosCodedowload> findIosCodedowload(IosCodedowloadForm.Get form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        IosCodedowload iosCodedowload = iosCodedowloadService.findIosCodedowload(form);
        return CommonResult.returnSuccessWrapper(iosCodedowload);
    }

    /**
     * @description 根据主键id修改状态
     * @author zlx
     * @date 2020/7/17 11:59
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    @Override
    public CommonResult<Boolean> editIosCodedowloadStatus(IosCodedowloadForm.Edit form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return  CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        return CommonResult.returnBoolWrapper(iosCodedowloadService.editIosCodedowloadStatus(form),"操作失败");
    }
}
