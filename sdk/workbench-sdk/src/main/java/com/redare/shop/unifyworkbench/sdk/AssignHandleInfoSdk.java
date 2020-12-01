package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.AssignHandleInfo;
import com.redare.shop.unifyworkbench.sdk.pojo.form.AssignHandleInfoForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;

import java.util.List;

/**
 * 交办办理情况表(AssignHandleInfo)SDK
 *
 * @author makejava
 * @since 2020-10-21 14:10:47
 */
public interface AssignHandleInfoSdk {

    CommonResult<Boolean> insertAssignHandleInfo(AssignHandleInfo form);

    CommonResult<Boolean> updateAssignHandleInfo(AssignHandleInfo form);

    CommonResult<Boolean> deleteAssignHandleInfo(CommonForm.Del form);

    CommonResult<Boolean> updateAssignHandleInfoStatus(AssignHandleInfoForm.Edit form);

    CommonResult<Page<AssignHandleInfo>> queryForPageAssignHandleInfo(AssignHandleInfoForm.Search form, int curPage, int pageSize);

    CommonResult<List<AssignHandleInfo>> queryForListAssignHandleInfo(AssignHandleInfoForm.Search form);

    CommonResult<AssignHandleInfo> queryAssignHandleInfo(AssignHandleInfoForm.Search form);

    CommonResult<Boolean> batchDelAssignHandleInfo(CommonForm.BatchDel form);

    /**
     * 处理交办
     * @param form
     * @return
     */
    CommonResult<Boolean> handleAssign(AssignHandleInfo form);

    /**
     * 交办任务办结
     * @param form
     * @return
     */
    CommonResult<Boolean> finishAssign(AssignHandleInfo form);

    CommonResult<AssignHandleInfo> getAssignHandleInfo(AssignHandleInfo form);

}