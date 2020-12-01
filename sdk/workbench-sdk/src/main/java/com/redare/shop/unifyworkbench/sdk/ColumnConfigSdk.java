package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.ColumnConfig;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ColumnConfigForm;

import java.util.List;

/**
 *专栏配置表sdk
 */
public interface ColumnConfigSdk {

    /**
     * 分页查询列表
     * @param form
     * @return
     */
    CommonResult<Page<ColumnConfig>> findColumnConfigPage(ColumnConfigForm.Search form, int curPage, int pageSize);

    /**
     * 分页查询列表数据
     * @param form
     * @param curPage
     * @param pageSize
     * @return
     */
    CommonResult<List<ColumnConfig>> findColumnConfigList(ColumnConfigForm.Search form,int curPage,int pageSize);

    /**
     * 查询所有数据
     * @param form
     * @return
     */
    CommonResult<List<ColumnConfig>> findColumnConfigList(ColumnConfigForm.Search form);

    /**
     * 根据主键id查询数据
     * @param form
     * @return
     */
    CommonResult<ColumnConfig> findColumnConfigById(ColumnConfigForm.Get form);

    /**
     *  添加数据
     * @param form
     * @return
     */
    CommonResult<Boolean> addColumnConfig(ColumnConfigForm.Add form);

    /**
     * 修改数据
     * @param form
     * @return
     */
    CommonResult<Boolean> editColumnConfig(ColumnConfigForm.Edit form);

    /**
     * 删除数据
     * @param form
     * @return
     */
    CommonResult<Boolean> delColumnConfig(ColumnConfigForm.Del form);
}
