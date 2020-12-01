package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.shop.unifyworkbench.sdk.UserInfoLinkmanSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.UserInfo;
import com.redare.shop.unifyworkbench.sdk.pojo.UserInfoLinkman;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserInfoLinkmanForm;
import com.redare.shop.unifyworkbench.service.service.UserInfoLinkmanService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
/**
 * ：UserInfoLinkmanSdkImpl
 *
 * @author yj
 * @email yangj@redare.cn
 * @date 2020-08-25
 */
@Service
public class UserInfoLinkmanSdkImpl implements UserInfoLinkmanSdk {
    @Autowired
    UserInfoLinkmanService userInfoLinkmanService;
    @Override
    public CommonResult<Page<UserInfo>> findUserInfoLinkmanPage(UserInfoLinkmanForm.Search form, int curPage, int pageSize) {
        return CommonResult.returnSuccessWrapper(userInfoLinkmanService.findUserInfoLinkmanPage(form,curPage,pageSize));
    }

    @Override
    public CommonResult<List<UserInfo>> findUserInfoLinkmanList(UserInfoLinkmanForm.Search form, int curPage, int pageSize) {
        return CommonResult.returnDataWrapper(userInfoLinkmanService.findUserInfoLinkmanList(form,curPage,pageSize));
    }

    @Override
    public CommonResult<List<UserInfo>> findUserInfoLinkmanList(UserInfoLinkmanForm.Search form) {
        return CommonResult.returnDataWrapper(userInfoLinkmanService.findUserInfoLinkmanList(form));
    }

    @Override
    public CommonResult<UserInfoLinkman> getUserInfoLinkman(UserInfoLinkmanForm.Get form) {
        return CommonResult.returnSuccessWrapper(userInfoLinkmanService.getUserInfoLinkman(form));
    }

    @Transactional
    @Override
    public CommonResult<Boolean> addOrUpdateLinkman(UserInfoLinkmanForm.Add form) {
        if (form.getZtktUserId() == null|| StringUtils.isBlank(form.getUserId())){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        //查询是否添加过
        UserInfoLinkman userInfoLinkman = userInfoLinkmanService.getUserInfoLinkman(new UserInfoLinkmanForm.Get().setZtktUserId(form.getZtktUserId()).setUserId(form.getUserId()));
        Boolean isSuccess=false;
        if(userInfoLinkman!=null){
            //修改
            UserInfoLinkmanForm.Edit edit=new UserInfoLinkmanForm.Edit();
            edit.setId(userInfoLinkman.getId())
                .setUserId(userInfoLinkman.getUserId())
                .setZtktUserId(userInfoLinkman.getZtktUserId())
                .setLinkCount(userInfoLinkman.getLinkCount()+1)
                .setUpdateTime(new Date());
            isSuccess=userInfoLinkmanService.editUserInfoLinkman(edit);
        }else{
            //添加
            form.setLinkCount(1).setCreateTime(new Date()).setUpdateTime(new Date());
            isSuccess=userInfoLinkmanService.addUserInfoLinkman(form);
        }
        return CommonResult.returnBoolWrapper(isSuccess,"更新失败！");
    }


    @Override
    public CommonResult<Boolean> deleteUserInfoLinkman(UserInfoLinkmanForm.Del form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        return  CommonResult.returnBoolWrapper(userInfoLinkmanService.deleteUserInfoLinkman(form),"删除失败！");
    }
}
