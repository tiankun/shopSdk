package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.shop.unifyworkbench.sdk.UserInfoSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.UserInfo;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserInfoForm;
import com.redare.shop.unifyworkbench.service.service.UserInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoSdkImpl implements UserInfoSdk {
    @Autowired
    private UserInfoService userInfoService;

    @Override
    public CommonResult<Page<UserInfo>> findUserInfoPage(UserInfoForm.Search form, int curPage, int pageSize) {
        Page<UserInfo> page = userInfoService.findUserInfoPage(form,curPage,pageSize);
        return CommonResult.returnDataWrapper(page);
    }

    @Override
    public CommonResult<List<UserInfo>> findUserInfoList(UserInfoForm.Search form, int curPage, int pageSize) {
        List<UserInfo> list = userInfoService.findUserInfoList(form,curPage,pageSize);
        return CommonResult.returnDataWrapper(list);
    }

    @Override
    public CommonResult<List<UserInfo>> findUserInfoList(UserInfoForm.Search form) {
        List<UserInfo> list = userInfoService.findUserInfoList(form);
        return CommonResult.returnDataWrapper(list);
    }

    @Override
    public CommonResult<UserInfo> getUserInfoByUserId(UserInfoForm.Get form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        UserInfo userInfo = userInfoService.getUserInfoByUserId(form);
        return CommonResult.returnSuccessWrapper(userInfo);
    }

    @Override
    public CommonResult<Boolean> addUserInfo(UserInfoForm.Add form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        return CommonResult.returnBoolWrapper(userInfoService.addUserInfo(form),"新增用户信息失败");
    }

    @Override
    public CommonResult<Boolean> editUserInfo(UserInfoForm.Edit form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        return CommonResult.returnBoolWrapper(userInfoService.editUserInfo(form),"修改用户信息失败");
    }

    @Override
    public CommonResult<Boolean> addOrUpdateUserInfo(UserInfoForm.Add form) {
        Boolean result = false;
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        UserInfo userInfo = userInfoService.getUserInfoByUserId(new UserInfoForm.Get().setUserId(form.getUserId()));
        if(userInfo!=null){
            //修改、
            UserInfoForm.Edit editForm = new UserInfoForm.Edit();
            BeanUtils.copyProperties(form,editForm);
            editForm.setId(userInfo.getId());
            result = userInfoService.editUserInfo(editForm);
        }else{
            //添加
            result = userInfoService.addUserInfo(form);
        }
        return CommonResult.returnBoolWrapper(result,"更新失败");
    }

    @Override
    public CommonResult<Boolean> truncateTable() {
        return CommonResult.returnBoolWrapper(userInfoService.truncateTable(),"清空失败");
    }

    @Override
    public CommonResult<UserInfo> getUserInfoByLoginUserId(UserInfoForm.Get form) {
        return CommonResult.returnSuccessWrapper(userInfoService.getUserInfoByLoginUserId(form));
    }

}
