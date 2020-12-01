package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.OrganizeChangeTerm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.OrganizeChangeTermForm;

import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/10/19 11:11
 * @version:
 */
public interface OrganizeChangeTermSdk {
    /**
     * @description 分页
     * @author zlx
     * @date 2020/10/19 11:14
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.OrganizeChangeTerm>>
     */
    CommonResult<Page<OrganizeChangeTerm>> findOrganizeChangeTermPage(OrganizeChangeTermForm.Search form ,int curPage,int pageSize);

    /**
     * @description 分页查询列表
     * @author zlx
     * @date 2020/10/19 11:15
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.OrganizeChangeTerm>>
     */
    CommonResult<List<OrganizeChangeTerm>> findOrganizeChangeTermPageList(OrganizeChangeTermForm.Search form , int curPage, int pageSize);

    /**
     * @description 查询所有数据
     * @author zlx
     * @date 2020/10/19 11:15
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.OrganizeChangeTerm>>
     */
    CommonResult<List<OrganizeChangeTerm>> findOrganizeChangeTermList(OrganizeChangeTermForm.Search form);

    /**
     * @description 根据主键id查询数据
     * @author zlx
     * @date 2020/10/19 11:18
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.shop.unifyworkbench.sdk.pojo.OrganizeChangeTerm>
     */
    CommonResult<OrganizeChangeTerm> findOrganizeChangeTerm(OrganizeChangeTermForm.Get form);

    /**
     * @description 添加数据
     * @author zlx
     * @date 2020/10/19 11:22
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    CommonResult<Boolean> addOrganizeChangeTerm(OrganizeChangeTermForm.Add form);

    /**
     * @description 编辑数据
     * @author zlx
     * @date 2020/10/19 11:23
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    CommonResult<Boolean> editOrganizeChangeTerm(OrganizeChangeTermForm.Edit form);
    /**
     * @description 删除数据
     * @author zlx
     * @date 2020/10/19 11:24
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    CommonResult<Boolean> delOrganizeChangeTerm(OrganizeChangeTermForm.Del form);
}
