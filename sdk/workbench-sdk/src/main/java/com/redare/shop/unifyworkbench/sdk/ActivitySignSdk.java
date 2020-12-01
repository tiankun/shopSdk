package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.ActivitySign;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ActivitySignForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;

import java.util.List;

/**
 * (ActivitySign)SDK
 *
 * @author dengchj
 * @since 2020-10-20 17:34:17
 */
public interface ActivitySignSdk {

    CommonResult<Boolean> insertActivitySign(ActivitySignForm.Add form);

    CommonResult<Boolean> updateActivitySign(ActivitySign form);

    CommonResult<Boolean> deleteActivitySign(CommonForm.Del form);

    CommonResult<Boolean> updateActivitySignStatus(ActivitySignForm.Edit form);

    CommonResult<Page<ActivitySign>> queryForPageActivitySign(ActivitySignForm.Search form, int curPage, int pageSize);

    CommonResult<List<ActivitySign>> queryForListActivitySign(ActivitySignForm.Search form);

    CommonResult<ActivitySign> queryActivitySign(ActivitySignForm.Search form);

    CommonResult<Boolean> batchDelActivitySign(CommonForm.BatchDel form);
    CommonResult<List<ActivitySign>>  signCount(ActivitySignForm.Get form);
    CommonResult<Boolean> importSignData(ActivitySignForm.ImportForm form);

    /**
     * 是否 已签到
     * @param form
     * @return
     */
    CommonResult<Boolean> existSign(ActivitySignForm.Search form);

}