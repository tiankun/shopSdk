package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.UserInfo;
import com.redare.shop.unifyworkbench.sdk.pojo.UserInfoLinkman;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserInfoLinkmanForm;

import java.util.List;
/**
 * ：UserInfoLinkmanSdk
 *
 * @author yj
 * @email yangj@redare.cn
 * @date 2020-08-25
 */
public interface UserInfoLinkmanSdk {
    /**
    * 分页查询(t_user_info_linkman：)列表
    * @param form
    * @param curPage
    * @param pageSize
    * @return
    */
    CommonResult<Page<UserInfo>> findUserInfoLinkmanPage(UserInfoLinkmanForm.Search form, int curPage, int pageSize);

    /**
     * 分页查询(t_user_info_linkman：)列表
     * @param form
     * @param curPage
     * @param pageSize
     * @return list
     */
    CommonResult<List<UserInfo>> findUserInfoLinkmanList(UserInfoLinkmanForm.Search form, int curPage, int pageSize);

    /**
     * 查询(t_user_info_linkman：)列表，不分页
     * @param form
     * @return
     */
    CommonResult<List<UserInfo>> findUserInfoLinkmanList(UserInfoLinkmanForm.Search form);

    /**
    * 查询详情(t_user_info_linkman：)
    * @param form
    * @return
    */
    CommonResult<UserInfoLinkman> getUserInfoLinkman(UserInfoLinkmanForm.Get form);

    /**
    * 新增或修改(t_user_info_linkman：) 传入ztktUserId、userId;
    * @param form
    * @return
    */
    CommonResult<Boolean> addOrUpdateLinkman(UserInfoLinkmanForm.Add form);



    /**
    * 删除(t_user_info_linkman：)
    * @param form
    * @return
    */
    CommonResult<Boolean> deleteUserInfoLinkman(UserInfoLinkmanForm.Del form);
}
