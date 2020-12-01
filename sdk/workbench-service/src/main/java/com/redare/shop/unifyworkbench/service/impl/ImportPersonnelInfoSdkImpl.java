package com.redare.shop.unifyworkbench.service.impl;

import com.alibaba.excel.EasyExcel;
import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.devframework.webplatform.service.common.service.DictionaryService;
import com.redare.shop.unifyworkbench.sdk.ImportPersonnelInfoSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.ImportPersonnelInfo;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ImportFileInfoForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ImportPersonnelInfoForm;
import com.redare.shop.unifyworkbench.service.excel.ImportPersonnelInfoExcel;
import com.redare.shop.unifyworkbench.service.excel.ImportPersonnelInfoListener;
import com.redare.shop.unifyworkbench.service.service.DepartmentService;
import com.redare.shop.unifyworkbench.service.service.ImportFileInfoService;
import com.redare.shop.unifyworkbench.service.service.ImportPersonnelInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/11/20 16:21
 * @version:
 */
@Service
public class ImportPersonnelInfoSdkImpl implements ImportPersonnelInfoSdk {

    @Autowired
    ImportPersonnelInfoService importPersonnelInfoService;

    @Autowired
    ImportFileInfoService importFileInfoService;

    @Autowired
    DictionaryService dictionaryService;

    @Autowired
    DepartmentService departmentService;

    /**
     * @description 分页查询
     * @author zlx
     * @date 2020/11/20 16:28
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.ImportPersonnelInfo>>
     */
    @Override
    public CommonResult<Page<ImportPersonnelInfo>> findImportPersonnelInfoPage(ImportPersonnelInfoForm.Search form, int curPage, int pageSize) {
        return CommonResult.returnSuccessWrapper(importPersonnelInfoService.findImportPersonnelInfoPage(form, curPage, pageSize));
    }

    /**
     * @description 分页查询数据
     * @author zxl
     * @date 2020/11/20 16:28
     * @param form
 * @param curPage
 * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.ImportPersonnelInfo>>
     */
    @Override
    public CommonResult<List<ImportPersonnelInfo>> findImportPersonnelInfoPageList(ImportPersonnelInfoForm.Search form, int curPage, int pageSize) {
        return CommonResult.returnSuccessWrapper(importPersonnelInfoService.findImportPersonnelInfoPageList(form, curPage, pageSize));
    }

    /**
     * @description 查询所有数据
     * @author zlx
     * @date 2020/11/20 16:28
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.ImportPersonnelInfo>>
     */
    @Override
    public CommonResult<List<ImportPersonnelInfo>> findImportPersonnelInfoList(ImportPersonnelInfoForm.Search form) {
        return CommonResult.returnSuccessWrapper(importPersonnelInfoService.findImportPersonnelInfoList(form));
    }

    /**
     * @description 根据主键id查询数据
     * @author zlx
     * @date 2020/11/20 16:29
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.shop.unifyworkbench.sdk.pojo.ImportPersonnelInfo>
     */
    @Override
    public CommonResult<ImportPersonnelInfo> findImportPersonnelInfo(ImportPersonnelInfoForm.Get form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        return CommonResult.returnSuccessWrapper(importPersonnelInfoService.findImportPersonnelInfo(form));
    }

    /**
     * @description 添加数据
     * @author zlx
     * @date 2020/11/20 16:29
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Long>
     */
    @Override
    public CommonResult<Long> addImportPersonnelInfo(ImportPersonnelInfoForm.Add form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        return CommonResult.returnSuccessWrapper(importPersonnelInfoService.addImportPersonnelInfo(form));
    }

    /**
     * @description 修改数据
     * @author zlx
     * @date 2020/11/20 16:29
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    @Override
    public CommonResult<Boolean> editImportPersonnelInfo(ImportPersonnelInfoForm.Edit form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        return CommonResult.returnBoolWrapper(importPersonnelInfoService.editImportPersonnelInfo(form),"编辑失败");
    }

    /**
     * @description 根据主键id删除数据
     * @author zlx
     * @date 2020/11/20 16:29
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    @Override
    public CommonResult<Boolean> delImportPersonnelInfo(ImportPersonnelInfoForm.Del form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        return CommonResult.returnBoolWrapper(importPersonnelInfoService.delImportPersonnelInfo(form),"删除失败");
    }

    /**
     * @description 导入数据
     * @author zlx
     * @date 2020/11/20 16:29
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    @Override
    @Transactional
    public CommonResult<Boolean> importData(ImportFileInfoForm.Add form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        if (StringUtils.isBlank(form.getFileUrl())) {
            return CommonResult.returnFailsWrapper("没有上传文件");
        }
        form.setUploadTime(new Date());
        form.setCreateTime(new Date());
        form.setUpdateTime(new Date());
        form.setStatus(0);
        try {
            URL url = new URL(form.getFileUrl());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            InputStream inStream = conn.getInputStream();
            EasyExcel.read(inStream, ImportPersonnelInfoExcel.class,new ImportPersonnelInfoListener(dictionaryService,importPersonnelInfoService,
                    importFileInfoService,form.getType(),form,departmentService)).sheet().headRowNumber(1).doRead();
        }catch (Exception e){
            return CommonResult.returnFailsWrapper(e.getMessage());
        }
        return CommonResult.returnSuccessWrapper();
    }

    /**
     * @description 更新数据状态
     * @author zlx
     * @date 2020/11/20 17:39
     * @param list
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    @Override
    public CommonResult<Boolean> batchEditStatus(List<Long> list) {
        if (list.isEmpty()){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        return CommonResult.returnBoolWrapper(importPersonnelInfoService.batchEditStatus(list)>0,"更新失败");
    }

    /**
     * 查询执行委员名单
     * @param form
     * @return
     */
    @Override
    public CommonResult<List<ImportPersonnelInfo>> findRosterList(ImportPersonnelInfoForm.Search form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        return CommonResult.returnSuccessWrapper(importPersonnelInfoService.findRosterList(form));
    }

    @Override
    public CommonResult<Boolean> delByRosterId(ImportPersonnelInfoForm.BatchDel form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        int row = importPersonnelInfoService.delByRosterId(form);
        return CommonResult.returnSuccessWrapper(row>0);
    }


}
