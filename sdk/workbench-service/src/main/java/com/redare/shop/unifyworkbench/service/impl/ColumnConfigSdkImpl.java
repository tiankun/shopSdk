package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.shop.unifyworkbench.sdk.ColumnConfigSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.ColumnConfig;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ColumnConfigForm;
import com.redare.shop.unifyworkbench.service.service.ColumnConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ColumnConfigSdkImpl
 */
@Service
public class ColumnConfigSdkImpl implements ColumnConfigSdk {

    @Autowired
    ColumnConfigService columnConfigService;

    /**
     * 分页查询列表
     * @param form
     * @param curPage
     * @param pageSize
     * @return
     */
    @Override
    public CommonResult<Page<ColumnConfig>> findColumnConfigPage(ColumnConfigForm.Search form, int curPage, int pageSize) {
        Page<ColumnConfig> page = columnConfigService.findColumnConfigPage(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(page);
    }

    /**
     * 分页查询列表数据
     * @param form
     * @param curPage
     * @param pageSize
     * @return
     */
    @Override
    public CommonResult<List<ColumnConfig>> findColumnConfigList(ColumnConfigForm.Search form, int curPage, int pageSize) {
        List<ColumnConfig> list = columnConfigService.findColumnConfigList(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(list);
    }

    /**
     * 查询所有数据
     * @param form
     * @return
     */
    @Override
    public CommonResult<List<ColumnConfig>> findColumnConfigList(ColumnConfigForm.Search form) {
        List<ColumnConfig> list = columnConfigService.findColumnConfigList(form);
        return CommonResult.returnSuccessWrapper(list);
    }

    /**
     * 根据主键id查询数据
     * @param form
     * @return
     */
    @Override
    public CommonResult<ColumnConfig> findColumnConfigById(ColumnConfigForm.Get form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        ColumnConfig columnConfig = columnConfigService.findColumnConfigById(form);
        return CommonResult.returnSuccessWrapper(columnConfig);
    }

    /**
     * 添加数据
     * @param form
     * @return
     */
    @Override
    public CommonResult<Boolean> addColumnConfig(ColumnConfigForm.Add form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        Boolean bool = columnConfigService.addColumnConfig(form);
        return CommonResult.returnBoolWrapper(bool,"添加数据失败");
    }

    /**
     * 修改数据
     * @param form
     * @return
     */
    @Override
    public CommonResult<Boolean> editColumnConfig(ColumnConfigForm.Edit form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        Boolean bool = columnConfigService.editColumnConfig(form);
        return CommonResult.returnBoolWrapper(bool,"修改数据失败");
    }

    /**
     * 删除数据
     * @param form
     * @return
     */
    @Override
    public CommonResult<Boolean> delColumnConfig(ColumnConfigForm.Del form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        Boolean bool = columnConfigService.delColumnConfig(form);
        return CommonResult.returnBoolWrapper(bool,"删除数据失败");
    }
}
