package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.HjmallindUser;
import com.redare.shop.unifyworkbench.sdk.pojo.form.HjmallindUserForm;

import java.util.List;

/**
 * 用户 sdk
 *
 * @author tiankun
 * @date 2020-12-01 15:53:13
 */
public interface HjmallindUserSdk {

    /**
     * 新增用户
     */
    CommonResult<Boolean> addHjmallindUser(HjmallindUserForm.Add form);

    /**
     * 编辑用户
     */
    CommonResult<Boolean> editHjmallindUser(HjmallindUserForm.Edit form);

    /**
     * 删除用户
     */
    CommonResult<Boolean> deleteHjmallindUser(HjmallindUserForm.Del form);

    /**
     * 查询用户
     */
    CommonResult<List<HjmallindUser>> findHjmallindUserList(HjmallindUserForm.Search form);

    /**
     * 分页查询用户
     */
    CommonResult<List<HjmallindUser>> findHjmallindUserList(HjmallindUserForm.Search form, int curPage, int pageSize);

    /**
     * 分页查询用户
     */
    CommonResult<Page<HjmallindUser>> findHjmallindUserPage(HjmallindUserForm.Search form, int curPage, int pageSize);

    /**
     * 获取用户
     */
    CommonResult<HjmallindUser> getHjmallindUser(HjmallindUserForm.Get form);


}

