package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.LoginLogSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.LoginLog;
import com.redare.shop.unifyworkbench.sdk.pojo.form.LoginLogForm;
import com.redare.shop.unifyworkbench.service.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/7/29 14:30
 * @version:
 */
@Service
public class LoginLogSdkImpl implements LoginLogSdk {

    @Autowired
    LoginLogService loginLogService;
    /**
     * @description 分页查询
     * @author zlx
     * @date 2020/7/29 14:31
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.LoginLog>>
     */
    @Override
    public CommonResult<Page<LoginLog>> findLoginLogPage(LoginLogForm.Search form, int curPage, int pageSize) {
        Page<LoginLog> page = loginLogService.findLoginLogPage(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(page);
    }

    /**
     * @description 分页查询数据
     * @author zlx
     * @date 2020/7/29 14:31
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.LoginLog>>
     */
    @Override
    public CommonResult<List<LoginLog>> findLoginLogPageList(LoginLogForm.Search form, int curPage, int pageSize) {
        List<LoginLog> list = loginLogService.findLoginLogPageList(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(list);
    }

    /**
     * @description 查询所有数据
     * @author zlx
     * @date 2020/7/29 14:32
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.LoginLog>>
     */
    @Override
    public CommonResult<List<LoginLog>> findLoginLogList(LoginLogForm.Search form) {
        List<LoginLog> list = loginLogService.findLoginLogList(form);
        return CommonResult.returnSuccessWrapper(list);
    }

    /**
     * @description 添加数据
     * @author zlx
     * @date 2020/7/29 14:33
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    @Override
    public CommonResult<Boolean> addLoginLog(LoginLogForm.Add form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        boolean bool = loginLogService.addLoginLog(form);
        return CommonResult.returnBoolWrapper(bool,"操作失败");
    }
}
