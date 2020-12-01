package com.redare.shop.unifyworkbench.service.impl;

import com.alibaba.excel.EasyExcel;
import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.shop.unifyworkbench.sdk.ActivitySignSdk;
import com.redare.shop.unifyworkbench.sdk.common.pojo.BaseUserInfo;
import com.redare.shop.unifyworkbench.sdk.pojo.ActivitySign;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ActivitySignForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.service.excel.SignExcelListener;
import com.redare.shop.unifyworkbench.service.excel.SignExcelModel;
import com.redare.shop.unifyworkbench.service.service.ActivitySignService;
import com.redare.shop.unifyworkbench.service.service.BaseUserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * (ActivitySign)SdkImpl
 *
 * @author dengchj
 * @since 2020-10-20 17:34:46
 */
@Service
public class ActivitySignSdkImpl implements ActivitySignSdk {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActivitySignSdkImpl.class);
    @Autowired
    ActivitySignService activitySignService;
    @Autowired
    BaseUserInfoService baseUserInfoService;

    @Override
    public CommonResult<Boolean> insertActivitySign(ActivitySignForm.Add form) {
        if(form.getUserId()!=null) {
            BaseUserInfo baseUserInfoForm = new BaseUserInfo();
            baseUserInfoForm.setUserId(Long.valueOf(form.getUserId()));
            baseUserInfoForm.setOrgId(form.getOrgId());
            List<BaseUserInfo> baseUserInfo = baseUserInfoService.queryBaseUserInfoList(baseUserInfoForm);
            form.setUserName(baseUserInfo.get(0).getName());
            form.setDepId(baseUserInfo.get(0).getDeptId());
            form.setDepName(baseUserInfo.get(0).getDeptName());
            form.setOrgId(baseUserInfo.get(0).getOrgId());
            form.setOrgName(baseUserInfo.get(0).getOrgName());
            form.setPostion(baseUserInfo.get(0).getWomenPosition());
            form.setBirthDate(baseUserInfo.get(0).getBirthday());
            form.setEducationLevel(baseUserInfo.get(0).getEducation());
            form.setTelphone(baseUserInfo.get(0).getMobile());
            form.setSex(baseUserInfo.get(0).getSex());
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }else if(
                (form.getType().equals("1")||form.getType().equals("2")) && activitySignService.existSign(new ActivitySignForm.Search().setActivityId(form.getActivityId()).setUserName(form.getUserName()).setBirthDate(form.getBirthDate()).setType(form.getType()))){
            return CommonResult.returnFailsWrapper("您已签到");
        }else if( form.getType().equals("0") && activitySignService.existNeiBuSign(new ActivitySignForm.Search().setActivityId(form.getActivityId()).setUserId(form.getUserId()).setOrgId(form.getOrgId()))){
            return CommonResult.returnFailsWrapper("您已签到");
        }
        else{
            final long id = activitySignService.insertActivitySign(form);
            return CommonResult.returnSuccessWrapper(id>0);
        }
    }

    @Override
    public CommonResult<Boolean> updateActivitySign(ActivitySign form) {
        if (form.getId() == null) {
            return CommonResult.returnFailsWrapper("主键不能为空");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        int row = activitySignService.updateActivitySign(form);
        return CommonResult.returnSuccessWrapper(row > 0);
    }

    @Override
    public CommonResult<Boolean> deleteActivitySign(CommonForm.Del form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        int row = activitySignService.deleteActivitySign(form);
        return CommonResult.returnSuccessWrapper(row > 0);
    }


    @Override
    public CommonResult<Boolean> updateActivitySignStatus(ActivitySignForm.Edit form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        final ActivitySign targetForm = new ActivitySign();
        try {
            BeanUtils.copyProperties(form, targetForm);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return CommonResult.returnFailsWrapper(e.getMessage());
        }
        int row = activitySignService.updateActivitySign(targetForm);
        return CommonResult.returnSuccessWrapper(row > 0);
    }

    @Override
    public CommonResult<Page<ActivitySign>> queryForPageActivitySign(ActivitySignForm.Search form, int curPage, int pageSize) {
        Page<ActivitySign> data = activitySignService.queryForPageActivitySign(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(data);
    }

    @Override
    public CommonResult<List<ActivitySign>> queryForListActivitySign(ActivitySignForm.Search form) {
        List<ActivitySign> data = activitySignService.queryForListActivitySign(form);
        return CommonResult.returnSuccessWrapper(data);
    }

    @Override
    public CommonResult<ActivitySign> queryActivitySign(ActivitySignForm.Search form) {
        List<ActivitySign> data = activitySignService.queryForListActivitySign(form);
        if (data.size() == 1) {
            return CommonResult.returnSuccessWrapper(data.get(0));
        }
        return CommonResult.returnFailsWrapper("无效的查询条件");
    }

    @Override
    public CommonResult<Boolean> batchDelActivitySign(CommonForm.BatchDel form) {
        if (form == null) {
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        if (form.getIds() == null || form.getIds().size() <= 0) {
            return CommonResult.returnFailsWrapper("请传入主键id");
        }
        Boolean bool = activitySignService.batchDelActivitySign(form);

        return CommonResult.returnBoolWrapper(bool, "批量删除失败");
    }

    @Override
    public CommonResult<List<ActivitySign>> signCount(ActivitySignForm.Get form) {
        return CommonResult.returnSuccessWrapper(activitySignService.signCount(form));
    }

    @Override
    public CommonResult<Boolean> importSignData(ActivitySignForm.ImportForm form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        String excelUrl = form.getExcelPath();
        Boolean bool = true;
        try {
        URL url = new URL(excelUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5 * 1000);
        InputStream inStream = conn.getInputStream();
         EasyExcel.read(inStream, SignExcelModel.class, new SignExcelListener(activitySignService,form)).sheet().headRowNumber(1).doRead();

        } catch (Exception e) {
            bool=false;
            e.printStackTrace();
        }
        return CommonResult.returnBoolWrapper(bool,"导入失败");
    }

    @Override
    public CommonResult<Boolean> existSign(ActivitySignForm.Search form) {
        Boolean bool=activitySignService.existSign(form);
        return CommonResult.returnBoolWrapper(bool,"您已签到，请勿重复签到");
    }
}