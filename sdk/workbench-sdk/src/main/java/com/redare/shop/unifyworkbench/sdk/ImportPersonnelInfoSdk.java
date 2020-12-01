package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.ImportPersonnelInfo;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ImportFileInfoForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ImportPersonnelInfoForm;

import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/11/19 17:52
 * @version:
 */
public interface ImportPersonnelInfoSdk {

    /**
     * @description 分页查询
     * @author zlx
     * @date 2020/11/19 17:54
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.ImportPersonnelInfo>>
     */
    CommonResult<Page<ImportPersonnelInfo>> findImportPersonnelInfoPage(ImportPersonnelInfoForm.Search form,int curPage,int pageSize);

    /**
     * @description 分页查询数据
     * @author zlx
     * @date 2020/11/19 17:55
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.ImportPersonnelInfo>>
     */
    CommonResult<List<ImportPersonnelInfo>> findImportPersonnelInfoPageList(ImportPersonnelInfoForm.Search form, int curPage, int pageSize);

    /**
     * @description 查询所有数据
     * @author zlx
     * @date 2020/11/19 17:55
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.ImportPersonnelInfo>>
     */
    CommonResult<List<ImportPersonnelInfo>> findImportPersonnelInfoList(ImportPersonnelInfoForm.Search form);

    /**
     * @description 根据主键id查询数据
     * @author zlx
     * @date 2020/11/19 17:55
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.shop.unifyworkbench.sdk.pojo.ImportPersonnelInfo>
     */
    CommonResult<ImportPersonnelInfo> findImportPersonnelInfo(ImportPersonnelInfoForm.Get form);

    /**
     * @description 添加数据
     * @author zlx
     * @date 2020/11/19 17:56
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Long>
     */
    CommonResult<Long> addImportPersonnelInfo(ImportPersonnelInfoForm.Add form);

    /**
     * @description 编辑数据
     * @author zlx
     * @date 2020/11/19 17:57
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    CommonResult<Boolean> editImportPersonnelInfo(ImportPersonnelInfoForm.Edit form);

    /**
     * @description 根据主键id删除数据
     * @author zlx
     * @date 2020/11/19 17:57
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    CommonResult<Boolean> delImportPersonnelInfo(ImportPersonnelInfoForm.Del form);

    /**
     * @description 导入数据
     * @author zlx
     * @date 2020/11/20 16:20
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    CommonResult<Boolean> importData(ImportFileInfoForm.Add form);

    /**
     * @description 更新数据状态
     * @author zlx
     * @date 2020/11/20 17:38
     * @param list
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    CommonResult<Boolean> batchEditStatus(List<Long> list);

    /**
     * 查询执行委员名单
     * @param form
     * @return
     */
    CommonResult<List<ImportPersonnelInfo>> findRosterList(ImportPersonnelInfoForm.Search form);

    /**
     * 删除执委名单
     * @param form
     * @return
     */
    CommonResult<Boolean> delByRosterId(ImportPersonnelInfoForm.BatchDel form);
}
