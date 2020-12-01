package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.DelegateRosterUser;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.DelegateRosterUserForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ImportFileInfoForm;

import java.util.List;

/**
 * 代表名册人员列表(DelegateRosterUser)SDK
 *
 * @author makejava
 * @since 2020-11-19 17:15:35
 */
public interface DelegateRosterUserSdk {

    CommonResult<Boolean> insertDelegateRosterUser(DelegateRosterUserForm.Add form);

    CommonResult<Boolean> updateDelegateRosterUser(DelegateRosterUserForm.Edit form);

    CommonResult<Boolean> deleteDelegateRosterUser(CommonForm.Del form);

    CommonResult<Boolean> updateDelegateRosterUserStatus(DelegateRosterUserForm.EditStatus form);

    CommonResult<Page<DelegateRosterUser>> queryForPageDelegateRosterUser(DelegateRosterUserForm.Search form, int curPage, int pageSize);

    CommonResult<List<DelegateRosterUser>> queryForListDelegateRosterUser(DelegateRosterUserForm.Search form, int curPage, int pageSize);

    CommonResult<List<DelegateRosterUser>> queryForListDelegateRosterUser(DelegateRosterUserForm.Search form);

    CommonResult<DelegateRosterUser> queryDelegateRosterUser(DelegateRosterUserForm.Search form);

    CommonResult<Boolean> batchDelDelegateRosterUser(DelegateRosterUserForm.BatchDel form);

    CommonResult<Boolean> importDelegateRosterUser(ImportFileInfoForm.Add form);

}