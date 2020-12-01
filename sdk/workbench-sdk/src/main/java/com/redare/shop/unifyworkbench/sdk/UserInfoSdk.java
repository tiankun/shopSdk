package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.UserInfo;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserInfoForm;

import java.util.List;

public interface UserInfoSdk {
    /**
     * 分页查询用户信息（含分页信息）
     * @param form
     * @param curPage
     * @param pageSize
     * @return
     */
    CommonResult<Page<UserInfo>> findUserInfoPage(UserInfoForm.Search form, int curPage, int pageSize);

    /**
     * 分页查询用户信息（不含分页信息）
     * @param form
     * @param curPage
     * @param pageSize
     * @return
     */
    CommonResult<List<UserInfo>> findUserInfoList(UserInfoForm.Search form,int curPage,int pageSize);

    /**
     * 查询用户列表
     * @param form
     * @return
     */
    CommonResult<List<UserInfo>> findUserInfoList(UserInfoForm.Search form);

    /**
     * 根据用户id查询用户信息
     * @param form
     * @return
     */
    CommonResult<UserInfo> getUserInfoByUserId(UserInfoForm.Get form);

    /**
     * 添加用户信息
     * @param form
     * @return
     */
    CommonResult<Boolean> addUserInfo(UserInfoForm.Add form);

    /**
     * 修改用户信息
     * @param form
     * @return
     */
    CommonResult<Boolean> editUserInfo(UserInfoForm.Edit form);

    /**
     * 添加或修改用户信息
     * @param form
     * @return
     */
    CommonResult<Boolean> addOrUpdateUserInfo(UserInfoForm.Add form);

    /**
     * 清空表
     * @return
     */
    CommonResult<Boolean> truncateTable();

    /**
     * 传入登录用户Id查询对应OA账号信息
     * @param form
     * @return
     */
    CommonResult<UserInfo> getUserInfoByLoginUserId(UserInfoForm.Get form);


}
