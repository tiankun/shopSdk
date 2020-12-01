package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.Importemplate;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ImportemplateForm;


import java.util.List;

/**
 * Excel导入模板表：ImportemplateSdk
 *
 * @author yj
 * @email yangj@redare.cn
 * @date 2020-03-17
 */
public interface ImportemplateSdk {
    /**
    * 分页查询(t_import_template：Excel导入模板表)列表
    * @param form
    * @param curPage
    * @param pageSize
    * @return
    */
    CommonResult<Page<Importemplate>> findImportemplatePage(ImportemplateForm.Search form, int curPage, int pageSize);

    /**
     * 分页查询(t_import_template：Excel导入模板表)列表
     * @param form
     * @param curPage
     * @param pageSize
     * @return list
     */
    CommonResult<List<Importemplate>> findImportemplateList(ImportemplateForm.Search form, int curPage, int pageSize);

    /**
     * 查询(t_import_template：Excel导入模板表)列表，不分页
     * @param form
     * @return
     */
    CommonResult<List<Importemplate>> findImportemplateList(ImportemplateForm.Search form);

    /**
    * 查询详情(t_import_template：Excel导入模板表)
    * @param form
    * @return
    */
    CommonResult<Importemplate> getImportemplate(ImportemplateForm.Get form);

    /**
    * 新增(t_import_template：Excel导入模板表)
    * @param form
    * @return
    */
    CommonResult<Boolean> addImportemplate(ImportemplateForm.Add form);

    /**
    * 修改(t_import_template：Excel导入模板表)
    * @param form
    * @return
    */
    CommonResult<Boolean> editImportemplate(ImportemplateForm.Edit form);

    /**
    * 删除(t_import_template：Excel导入模板表)
    * @param form
    * @return
    */
    CommonResult<Boolean> deleteImportemplate(ImportemplateForm.Del form);

    /**
     * @description 根据模板类型查询数据
     * @author zlx
     * @date 2020/11/21 10:55
     * @param type
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.shop.unifyworkbench.sdk.pojo.Importemplate>
     */
    CommonResult<Importemplate> findImportTemplateByType(String type);
}
