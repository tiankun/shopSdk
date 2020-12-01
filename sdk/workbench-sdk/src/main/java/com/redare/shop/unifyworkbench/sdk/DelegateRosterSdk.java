package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.DelegateRoster;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.DelegateRosterForm;

import java.util.List;

/**
 * (DelegateRoster)SDK
 *
 * @author makejava
 * @since 2020-11-19 17:12:59
 */
public interface DelegateRosterSdk {

    CommonResult<Boolean> insertDelegateRoster(DelegateRosterForm.Add form);

    CommonResult<Boolean> updateDelegateRoster(DelegateRosterForm.Edit form);

    CommonResult<Boolean> deleteDelegateRoster(CommonForm.Del form);

    CommonResult<Boolean> updateDelegateRosterStatus(DelegateRosterForm.EditStatus form);

    CommonResult<Page<DelegateRoster>> queryForPageDelegateRoster(DelegateRosterForm.Search form, int curPage, int pageSize);

    CommonResult<List<DelegateRoster>> queryForListDelegateRoster(DelegateRosterForm.Search form, int curPage, int pageSize);

    CommonResult<List<DelegateRoster>> queryForListDelegateRoster(DelegateRosterForm.Search form);

    CommonResult<DelegateRoster> queryDelegateRoster(DelegateRosterForm.Search form);

    CommonResult<Boolean> batchDelDelegateRoster(CommonForm.BatchDel form);

}