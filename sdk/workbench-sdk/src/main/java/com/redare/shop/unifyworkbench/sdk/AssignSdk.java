package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.Assign;
import com.redare.shop.unifyworkbench.sdk.pojo.AssignStatistics;
import com.redare.shop.unifyworkbench.sdk.pojo.Organization;
import com.redare.shop.unifyworkbench.sdk.pojo.form.AssignForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.OrganizationForm;

import java.util.List;

/**
 * 交办表(Assign)SDK
 *
 * @author makejava
 * @since 2020-10-22 14:31:39
 */
public interface AssignSdk {

    CommonResult<Boolean> insertAssign(Assign form);

    CommonResult<Boolean> updateAssign(Assign form);

    CommonResult<Boolean> deleteAssign(CommonForm.Del form);

    CommonResult<Boolean> updateAssignStatus(AssignForm.Edit form);

    CommonResult<Page<Assign>> queryForPageAssign(AssignForm.Search form, int curPage, int pageSize);

    CommonResult<Page<Assign>> queryAssignPage(AssignForm.Search form,int curPage,int pageSize);

    CommonResult<List<Assign>> queryForListAssign(AssignForm.Search form);

    CommonResult<Assign> queryAssign(AssignForm.Search form);

    CommonResult<Boolean> batchDelAssign(CommonForm.BatchDel form);

    CommonResult<Boolean> deliverAssign(Assign form);

    CommonResult<Boolean> createAssign(Assign form);

    CommonResult<Page<AssignStatistics>> queryAssignCompletionRatePage(AssignStatistics form, int curPage, int pageSize);

    CommonResult<List<AssignStatistics>> queryAssignCompletionRateList(AssignStatistics form,int curPage, int pageSize);

    CommonResult<List<AssignStatistics>> queryAssignCompletionRateList(AssignStatistics form);

    CommonResult<List<Organization>> findOrganizationList(OrganizationForm.Search form);

}