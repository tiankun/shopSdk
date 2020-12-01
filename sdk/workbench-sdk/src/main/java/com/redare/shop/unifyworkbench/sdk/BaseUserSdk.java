package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.BaseUser;
import com.redare.shop.unifyworkbench.sdk.pojo.BaseUserTree;
import com.redare.shop.unifyworkbench.sdk.pojo.form.BaseUserForm;

import java.util.List;

/**
 * @description: 人员接口
 * @author: zhangsq
 * @date: Created in 2020-10-20 14:35
 * @return:
 * @exception:
 */
public interface BaseUserSdk {

    /**
     * @description: 根据用户姓名和手机号码查询用户信息
     * @author: zhangsq
     * @date: Created in 2020-10-20 11:31
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<com.redare.shop.unifyworkbench.sdk.pojo.BaseUser>
     * @exception:
     */
    CommonResult<BaseUser> getBaseUserByNameAndPhone(BaseUserForm.Search form);

    CommonResult<List<BaseUserTree>> findBaseUserTreePage(BaseUserForm.Search form, int curPage, int pageSize);

    /**
     * @description: 分页查询人员列表
     * @author: zhangsq
     * @date: Created in 2020-10-20 10:10
     * @param form
     * @param curPage
     * @param pageSize
     * @return: com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.BaseUser>>
     * @exception:
     */
    CommonResult<Page<BaseUser>> findBaseUserPage(BaseUserForm.Search form, int curPage, int pageSize);
    /**
     * @description: 分页查询人员列表数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 10:15
     * @param form
     * @param curPage
     * @param pageSize
     * @return: com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.BaseUser>>
     * @exception:
     */
    CommonResult<List<BaseUser>> findBaseUserPageList(BaseUserForm.Search form, int curPage, int pageSize);
    /**
     * @description: 查询所有人员数据，不分页
     * @author: zhangsq
     * @date: Created in 2020-10-20 10:21
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.BaseUser>>
     * @exception:
     */
    CommonResult<List<BaseUser>> findBaseUserList(BaseUserForm.Search form);
    /**
     * @description: 根据主键id查询人员数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 10:34
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<com.redare.shop.unifyworkbench.sdk.pojo.BaseUser>
     * @exception:
     */
    CommonResult<BaseUser> findBaseUser(BaseUserForm.Get form);

    /**
     * @description: 根据身份证ID进行查询
     * @author: zhangsq
     * @date: Created in 2020-11-09 10:28
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<com.redare.shop.unifyworkbench.sdk.pojo.BaseUser>
     * @exception:
     */
    CommonResult<BaseUser> findByCardNoBaseUser(BaseUserForm.Get form);
    /**
     * @description: 添加人员数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 10:42
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.String>
     * @exception:
     */
    CommonResult<String> addBaseUser(BaseUserForm.Add form);
    /**
     * @description: 编辑人员数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 10:46
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    CommonResult<String> editBaseUser(BaseUserForm.Edit form);
    /**
     * @description: 删除人员信息
     * @author: zhangsq
     * @date: Created in 2020-10-20 10:55
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    CommonResult<Boolean> delBaseUser(BaseUserForm.BatchDel form);
}
