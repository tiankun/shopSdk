package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.LoginLog;
import com.redare.shop.unifyworkbench.sdk.pojo.form.LoginLogForm;

import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/7/29 10:18
 * @version: 1.1
 */
public interface LoginLogSdk {

    /**
     * @description 分页查询日志信息
     * @author zlx
     * @date 2020/7/29 10:19
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.LoginLog>>
     */
    CommonResult<Page<LoginLog>> findLoginLogPage(LoginLogForm.Search form, int curPage, int pageSize);

    /**
     * @description 分页查询列表数据
     * @author zlx
     * @date 2020/7/29 10:21
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.LoginLog>>
     */
    CommonResult<List<LoginLog>> findLoginLogPageList(LoginLogForm.Search form,int curPage,int pageSize);

    /**
     * @description 查询所有数据
     * @author zlx
     * @date 2020/7/29 10:21
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.LoginLog>>
     */
    CommonResult<List<LoginLog>> findLoginLogList(LoginLogForm.Search form);

    /**
     * @description 添加日志信息
     * @author zlx
     * @date 2020/7/29 10:27
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    CommonResult<Boolean> addLoginLog(LoginLogForm.Add form);
}
