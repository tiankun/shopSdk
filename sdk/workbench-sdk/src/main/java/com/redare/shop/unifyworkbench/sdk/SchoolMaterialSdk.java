package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.SchoolMaterial;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.SchoolMaterialForm;

import java.util.List;

/**
 * 学堂管理-素材管理(SchoolMaterial)SDK
 *
 * @author dengchj
 * @since 2020-10-15 15:04:13
 */
public interface SchoolMaterialSdk {
    /**
     * 添加素材
     * @param form
     * @return
     */
    CommonResult<Boolean> insertSchoolMaterial(SchoolMaterialForm.Add form);

    /**
     * 编辑素材
     * @param form
     * @return
     */

    CommonResult<Boolean> updateSchoolMaterial(SchoolMaterialForm.Edit form);

    /**
     * 删除素材
     * @param form
     * @return
     */

    CommonResult<Boolean> deleteSchoolMaterial(CommonForm.Del form);

    /**
     * 更改状态
     * @param form
     * @return
     */

    CommonResult<Boolean> updateSchoolMaterialStatus(SchoolMaterialForm.changeStatus form);

    /**
     * 查询素材
     * @param form
     * @param curPage
     * @param pageSize
     * @return
     */

    CommonResult<Page<SchoolMaterial>> queryForPageSchoolMaterial(SchoolMaterialForm.Search form, int curPage, int pageSize);

    /**
     * 查询素材列表
     * @param form
     * @return
     */

    CommonResult<List<SchoolMaterial>> queryForListSchoolMaterial(SchoolMaterialForm.Search form,int curPage,int pageSize);

    /**
     * 根据id查询素材信息
     * @param form
     * @return
     */

    CommonResult<SchoolMaterial> querySchoolMaterial(SchoolMaterialForm.Search form);

    /**
     * 批量删除
     * @param form
     * @return
     */

    CommonResult<Boolean> batchDelSchoolMaterial(CommonForm.BatchDel form);
    /**
     * 置顶
     * @param form
     * @return
     */
    CommonResult<Boolean> updateTopStatus(SchoolMaterialForm.Top form);

    /**
     * 设置排序
     * @param form
     * @return
     */
    CommonResult<Boolean> updateSort(SchoolMaterialForm.Sort form);
}