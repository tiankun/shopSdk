package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.SchoolNumberposition;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.SchoolNumberpositionForm;

import java.util.List;

/**
 * 学堂管理-数字阵地(SchoolNumberposition)SDK
 *
 * @author dengchj
 * @since 2020-10-13 14:24:24
 */
public interface SchoolNumberpositionSdk {
    /**
     * 添加数字阵地
     * @param form
     * @return
     */

    CommonResult<Boolean> insertSchoolNumberposition(SchoolNumberposition form);

    /**
     * 修改数字阵地
     * @param form
     * @return
     */

    CommonResult<Boolean> updateSchoolNumberposition(SchoolNumberposition form);

    /**
     * 删除数字阵地
     * @param form
     * @return
     */

    CommonResult<Boolean> deleteSchoolNumberposition(CommonForm.Del form);

    /**
     * 更改状态
     * @param form
     * @return
     */

    CommonResult<Boolean> updateSchoolNumberpositionStatus(SchoolNumberpositionForm.changeStatus form);

    /**
     * 分页查询
     * @param form
     * @param curPage
     * @param pageSize
     * @return
     */

    CommonResult<Page<SchoolNumberposition>> queryForPageSchoolNumberposition(SchoolNumberpositionForm.Search form, int curPage, int pageSize);

    CommonResult<List<SchoolNumberposition>> queryForListSchoolNumberposition(SchoolNumberpositionForm.Search form,int curPage,int pageSize);

    /**
     * 根据id查询数字阵地详情
     * @param form
     * @return
     */

    CommonResult<SchoolNumberposition> querySchoolNumberposition(SchoolNumberpositionForm.Get form);

    /**
     * 批量删除
     * @param form
     * @return
     */

    CommonResult<Boolean> batchDelSchoolNumberposition(CommonForm.BatchDel form);

}