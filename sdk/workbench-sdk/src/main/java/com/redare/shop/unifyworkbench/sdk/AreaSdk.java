package com.redare.shop.unifyworkbench.sdk;


import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.common.pojo.BaseLevelTreeQuery;
import com.redare.shop.unifyworkbench.sdk.pojo.Area;
import com.redare.shop.unifyworkbench.sdk.pojo.form.AreaForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.TreeNode;

import java.util.List;
import java.util.Map;

/**
 * 行政区域编码表(Area)SDK
 *
 * @author yanggr
 * @since 2020-10-21 15:05:09
 */
public interface AreaSdk {

    CommonResult<Boolean> insertArea(Area form);

    CommonResult<Boolean> updateArea(Area form);

    CommonResult<Boolean> deleteArea(CommonForm.Del form);

    CommonResult<Boolean> updateAreaStatus(AreaForm.Edit form);

    CommonResult<Page<Area>> queryForPageArea(AreaForm.Search form, int curPage, int pageSize);

    CommonResult<List<Area>> queryForListArea(AreaForm.Search form);

    CommonResult<Area> queryArea(AreaForm.Search form);

    CommonResult<Boolean> batchDelArea(CommonForm.BatchDel form);

    /**
     * 查询区域树
     * @param form
     * @return
     */
    CommonResult<Map<String, List<TreeNode>>> queryAreaTree(BaseLevelTreeQuery form);
    /**
     * 查询区域列表
     * @param form
     * @return [{},{},{}]
     */
    CommonResult<List<TreeNode>> queryAreaList(BaseLevelTreeQuery form);

    /**
     * 查询区域+组织机构数
     * @param form
     * @return
     */
    CommonResult<Map<String, List<TreeNode>>> queryAreaAndOrgTree(BaseLevelTreeQuery form);

//    /**
//     * 查询区域+组织机构+部门
//     * @param form
//     * @return
//     */
//    CommonResult<List<TreeNode>> queryAreaAndOrgAndDepartTree(AreaForm.Search form);
//
//    /**
//     * 查询区域+组织机构+人员
//     * @param form
//     * @return
//     */
//    CommonResult<List<TreeNode>> queryAreaAndOrgAndUserTree(AreaForm.Search form);

    /**
     * 查询区域组织列表
     * @param form
     * @return
     */
    CommonResult<Area> getParentAreaZxOrg(AreaForm.Search form);

}
