package com.redare.shop.unifyworkbench.service.impl;

import com.alibaba.excel.EasyExcel;
import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.devframework.webplatform.sdk.common.arg.DictionaryArg;
import com.redare.devframework.webplatform.sdk.common.pojo.Dictionary;
import com.redare.devframework.webplatform.service.common.service.DictionaryService;
import com.redare.shop.unifyworkbench.sdk.DelegateRosterUserSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.DelegateRosterUser;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.DelegateRosterUserForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ImportFileInfoForm;
import com.redare.shop.unifyworkbench.service.excel.DelegateRosterUserListener;
import com.redare.shop.unifyworkbench.service.excel.DelegateRosterUserModel;
import com.redare.shop.unifyworkbench.service.service.DelegateRosterUserService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 代表名册人员列表(DelegateRosterUser)SdkImpl
 *
 * @author makejava
 * @since 2020-11-19 17:18:56
 */
@Service
public class DelegateRosterUserSdkImpl implements DelegateRosterUserSdk {
    private static final Logger LOGGER = LoggerFactory.getLogger(DelegateRosterUserSdkImpl.class);
    @Autowired
    DelegateRosterUserService delegateRosterUserService;
    @Autowired
    DictionaryService dictionaryService;

    public static final String IMPORT_TYPE = "deputy";

    public static final String NATION_DICT = "nation";

    public static final String EDUCATION_DICT = "education";

    public static final String PARTIES_DICT = "parties";



    @Override
    public CommonResult<Boolean> insertDelegateRosterUser(DelegateRosterUserForm.Add form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        final long id = delegateRosterUserService.insertDelegateRosterUser(form);
        return CommonResult.returnSuccessWrapper(id > 0);
    }

    @Override
    public CommonResult<Boolean> updateDelegateRosterUser(DelegateRosterUserForm.Edit form) {
        if (form.getId() == null) {
            return CommonResult.returnFailsWrapper("主键不能为空");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        int row = delegateRosterUserService.updateDelegateRosterUser(form);
        return CommonResult.returnSuccessWrapper(row > 0);
    }

    @Override
    public CommonResult<Boolean> deleteDelegateRosterUser(CommonForm.Del form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        int row = delegateRosterUserService.deleteDelegateRosterUser(form);
        return CommonResult.returnSuccessWrapper(row > 0);
    }


    @Override
    public CommonResult<Boolean> updateDelegateRosterUserStatus(DelegateRosterUserForm.EditStatus form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        final DelegateRosterUserForm.Edit targetForm = new DelegateRosterUserForm.Edit();
        try {
            BeanUtils.copyProperties(form, targetForm);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return CommonResult.returnFailsWrapper(e.getMessage());
        }
        int row = delegateRosterUserService.updateDelegateRosterUser(targetForm);
        return CommonResult.returnSuccessWrapper(row > 0);
    }

    @Override
    public CommonResult<Page<DelegateRosterUser>> queryForPageDelegateRosterUser(DelegateRosterUserForm.Search form, int curPage, int pageSize) {
        Page<DelegateRosterUser> data = delegateRosterUserService.queryForPageDelegateRosterUser(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(data);
    }

    @Override
    public CommonResult<List<DelegateRosterUser>> queryForListDelegateRosterUser(DelegateRosterUserForm.Search form) {
        List<DelegateRosterUser> data = delegateRosterUserService.queryForListDelegateRosterUser(form);
        return CommonResult.returnSuccessWrapper(data);
    }

    @Override
    public CommonResult<List<DelegateRosterUser>> queryForListDelegateRosterUser(DelegateRosterUserForm.Search form, int curPage, int pageSize) {
        List<DelegateRosterUser> data = delegateRosterUserService.queryForListDelegateRosterUser(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(data);
    }

    @Override
    public CommonResult<DelegateRosterUser> queryDelegateRosterUser(DelegateRosterUserForm.Search form) {
        List<DelegateRosterUser> data = delegateRosterUserService.queryForListDelegateRosterUser(form);
        if (data.size() == 1) {
            return CommonResult.returnSuccessWrapper(data.get(0));
        }
        return CommonResult.returnFailsWrapper("无效的查询条件");
    }

    @Override
    public CommonResult<Boolean> batchDelDelegateRosterUser(DelegateRosterUserForm.BatchDel form) {
        if (form == null) {
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        if (form.getIds() == null || form.getIds().size() <= 0) {
            return CommonResult.returnFailsWrapper("请传入主键id");
        }
        Boolean bool = delegateRosterUserService.batchDelDelegateRosterUser(form);

        return CommonResult.returnBoolWrapper(bool, "批量删除失败");
    }

    @Override
    public CommonResult<Boolean> importDelegateRosterUser(ImportFileInfoForm.Add form) {
        if (form == null) {
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        if(StringUtils.isBlank(form.getFileUrl())){
            return CommonResult.returnFailsWrapper("没有上传文件");
        }
        String excelUrl = form.getFileUrl();
        try {
            URL url = new URL(excelUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            InputStream inStream = conn.getInputStream();
            DictionaryArg.Search search = new DictionaryArg.Search();
            search.setPlatform("shop");
            search.setParentCode("nationName");
            List<Dictionary> nationList = dictionaryService.findDictionaryList(search);
            search.setParentCode("educationName");
            List<Dictionary> educationList = dictionaryService.findDictionaryList(search);
            search.setParentCode("parties");
            List<Dictionary> partiesList = dictionaryService.findDictionaryList(search);
            Map<String,Object> dataMap = new HashMap<>();
            dataMap.put(NATION_DICT,nationList);
            dataMap.put(EDUCATION_DICT,educationList);
            dataMap.put(PARTIES_DICT,partiesList);
            EasyExcel.read(inStream,
                    DelegateRosterUserModel.class,
                    new DelegateRosterUserListener(
                            dataMap,
                            delegateRosterUserService,
                            form,
                            IMPORT_TYPE)).sheet()
                    //默认0
                    //.sheetNo(2)
                    //表头行数
                    .headRowNumber(2)
                    .doRead();


        } catch (Exception e) {
            LOGGER.error("导入异常", e);
            return CommonResult.returnFailsWrapper(e.getMessage());
        }


        return CommonResult.returnSuccessWrapper();
    }

}