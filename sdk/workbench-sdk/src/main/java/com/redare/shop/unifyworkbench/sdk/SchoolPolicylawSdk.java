package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.SchoolPolicylaw;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.SchoolPolicylawForm;

import java.util.List;

/**
 * 学堂管理-政策法规(SchoolPolicylaw)SDK
 *
 * @author dengchj
 * @since 2020-10-13 14:24:46
 */
public interface SchoolPolicylawSdk {
    /**
     * 添加政策法规
     * @param form
     * @return
     */

    CommonResult<Boolean> insertSchoolPolicylaw(SchoolPolicylaw form);

    /**
     * 编辑政策法规
     * @param form
     * @return
     */

    CommonResult<Boolean> updateSchoolPolicylaw(SchoolPolicylaw form);

    /**
     * 删除政策法规
     * @param form
     * @return
     */

    CommonResult<Boolean> deleteSchoolPolicylaw(CommonForm.Del form);

    /**
     * 更改桩体
     * @param form
     * @return
     */

    CommonResult<Boolean> updateSchoolPolicylawStatus(SchoolPolicylawForm.changeStatus form);

    /**
     * 分页查询政策法规列表
     * @param form
     * @param curPage
     * @param pageSize
     * @return
     */

    CommonResult<Page<SchoolPolicylaw>> queryForPageSchoolPolicylaw(SchoolPolicylawForm.Search form, int curPage, int pageSize);

    /**
     * 查询政策法规不分页
     * @param form
     * @return
     */

    CommonResult<List<SchoolPolicylaw>> queryForListSchoolPolicylaw(SchoolPolicylawForm.Search form,int curPage, int pageSize );


    CommonResult<SchoolPolicylaw> querySchoolPolicylaw(SchoolPolicylawForm.Search form);

    /**
     * 批量删除
     * @param form
     * @return
     */

    CommonResult<Boolean> batchDelSchoolPolicylaw(CommonForm.BatchDel form);

    /**
     * 根据Id获取政策法规信息
     * @param form
     * @return
     */
    CommonResult<SchoolPolicylaw> getSchoolPolicylawInfo(SchoolPolicylawForm.Search form);

    /**
     * 置顶
     * @param form
     * @return
     */
    CommonResult<Boolean> updateTopStatus(SchoolPolicylawForm.Top form);

}