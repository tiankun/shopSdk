package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.ImportFileInfo;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ImportFileInfoForm;

import java.util.List;

/**
 * @description:Excel导入文件信息
 * @author: zlx
 * @date: Created in 2020/11/19 16:18
 * @version:
 */
public interface ImportFileInfoSdk {

    /**
     * @description 分页查询
     * @author zlx
     * @date 2020/11/19 16:22
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.ImportFileInfo>>
     */
    CommonResult<Page<ImportFileInfo>> findImportFileInfoPage(ImportFileInfoForm.Search form,int curPage,int pageSize);

    /**
     * @description 分页查询数据
     * @author zlx
     * @date 2020/11/19 16:22
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.ImportFileInfo>>
     */
    CommonResult<List<ImportFileInfo>> findImportFileInfoPageList(ImportFileInfoForm.Search form, int curPage, int pageSize);

    /**
     * @description  查询所有数据
     * @author zlx
     * @date 2020/11/19 16:22
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.ImportFileInfo>>
     */
    CommonResult<List<ImportFileInfo>> findImportFileInfoList(ImportFileInfoForm.Search form);

    /**
     * @description 根据主键id查询数据
     * @author zlx
     * @date 2020/11/19 16:24
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.shop.unifyworkbench.sdk.pojo.ImportFileInfo>
     */
    CommonResult<ImportFileInfo> findImportFileInfo(ImportFileInfoForm.Get form);

    /**
     * @description 添加数据
     * @author zlx
     * @date 2020/11/19 16:25
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Long>
     */
    CommonResult<Long> addImportFileInfo(ImportFileInfoForm.Add form);

    /**
     * 执委管理批量生成账号
     * @param form
     * @return
     */
    CommonResult<ImportFileInfo> batchGenerateAccount(ImportFileInfoForm.Get form);
}
