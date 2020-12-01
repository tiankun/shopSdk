package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.shop.unifyworkbench.sdk.DelegateRosterSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.DelegateRoster;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.DelegateRosterForm;
import com.redare.shop.unifyworkbench.service.service.DelegateRosterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (DelegateRoster)SdkImpl
 *
 * @author makejava
 * @since 2020-11-19 17:14:35
 */
@Service
public class DelegateRosterSdkImpl implements DelegateRosterSdk {
    private static final Logger LOGGER = LoggerFactory.getLogger(DelegateRosterSdkImpl.class);
    @Autowired
    DelegateRosterService delegateRosterService;

    @Override
    public CommonResult<Boolean> insertDelegateRoster(DelegateRosterForm.Add form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        final long id = delegateRosterService.insertDelegateRoster(form);
        return CommonResult.returnSuccessWrapper(id > 0);
    }

    @Override
    public CommonResult<Boolean> updateDelegateRoster(DelegateRosterForm.Edit form) {
        if (form.getId() == null) {
            return CommonResult.returnFailsWrapper("主键不能为空");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        int row = delegateRosterService.updateDelegateRoster(form);
        return CommonResult.returnSuccessWrapper(row > 0);
    }

    @Override
    public CommonResult<Boolean> deleteDelegateRoster(CommonForm.Del form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        int row = delegateRosterService.deleteDelegateRoster(form);
        return CommonResult.returnSuccessWrapper(row > 0);
    }


    @Override
    public CommonResult<Boolean> updateDelegateRosterStatus(DelegateRosterForm.EditStatus form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        final DelegateRosterForm.Edit targetForm = new DelegateRosterForm.Edit();
        try {
            BeanUtils.copyProperties(form, targetForm);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return CommonResult.returnFailsWrapper(e.getMessage());
        }
        int row = delegateRosterService.updateDelegateRoster(targetForm);
        return CommonResult.returnSuccessWrapper(row > 0);
    }

    @Override
    public CommonResult<Page<DelegateRoster>> queryForPageDelegateRoster(DelegateRosterForm.Search form, int curPage, int pageSize) {
        Page<DelegateRoster> data = delegateRosterService.queryForPageDelegateRoster(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(data);
    }

    @Override
    public CommonResult<List<DelegateRoster>> queryForListDelegateRoster(DelegateRosterForm.Search form) {
        List<DelegateRoster> data = delegateRosterService.queryForListDelegateRoster(form);
        return CommonResult.returnSuccessWrapper(data);
    }

    @Override
    public CommonResult<List<DelegateRoster>> queryForListDelegateRoster(DelegateRosterForm.Search form, int curPage, int pageSize) {
        List<DelegateRoster> data = delegateRosterService.queryForListDelegateRoster(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(data);
    }

    @Override
    public CommonResult<DelegateRoster> queryDelegateRoster(DelegateRosterForm.Search form) {
        List<DelegateRoster> data = delegateRosterService.queryForListDelegateRoster(form);
        if (data.size() == 1) {
            return CommonResult.returnSuccessWrapper(data.get(0));
        }
        return CommonResult.returnFailsWrapper("无效的查询条件");
    }

    @Override
    public CommonResult<Boolean> batchDelDelegateRoster(CommonForm.BatchDel form) {
        if (form == null) {
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        if (form.getIds() == null || form.getIds().size() <= 0) {
            return CommonResult.returnFailsWrapper("请传入主键id");
        }
        Boolean bool = delegateRosterService.batchDelDelegateRoster(form);

        return CommonResult.returnBoolWrapper(bool, "批量删除失败");
    }
}