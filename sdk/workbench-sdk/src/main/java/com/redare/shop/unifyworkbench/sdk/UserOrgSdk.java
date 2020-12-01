package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.UserOrg;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserOrgForm;

import java.util.List;

/**
 * @author : zhangsq
 * @version :
 * @description：人员组织机构接口类
 * @date ：Created in 2020-10-20 14:19
 */
public interface UserOrgSdk {

    /**
     * @description: 分页查询
     * @author: zhangsq
     * @date: Created in 2020-10-20 14:26
     * @param form
     * @param curPage
     * @param pageSize
     * @return: com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.UserOrg>>
     * @exception:
     */
    CommonResult<Page<UserOrg>> findUserOrgPage(UserOrgForm.Search form, int curPage, int pageSize);
    /**
     * @description: 分页查询列表数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 14:26
     * @param form
     * @param curPage
     * @param pageSize
     * @return: com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserOrg>>
     * @exception:
     */
    CommonResult<List<UserOrg>> findUserOrgPageList(UserOrgForm.Search form, int curPage, int pageSize);
    /**
     * @description: 查询所有数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 14:26
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserOrg>>
     * @exception:
     */
    CommonResult<List<UserOrg>> findUserOrgList(UserOrgForm.Search form);
    /**
     * @description: 根据主键id查询数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 14:27
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<com.redare.shop.unifyworkbench.sdk.pojo.UserOrg>
     * @exception:
     */
    CommonResult<UserOrg> findUserOrg(UserOrgForm.Get form);
    /**
     * @description: 添加数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 14:27
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    CommonResult<Boolean> addUserOrg(UserOrgForm.Add form);

    /**
     * @description: 批量添加
     * @author: zhangsq
     * @date: Created in 2020-10-21 11:13
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    CommonResult<Boolean> batchAddUserOrg(UserOrgForm.BatchAdd form);

    /**
     * @description: 编辑数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 14:27
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    CommonResult<Boolean> editUserOrg(UserOrgForm.Edit form);
    /**
     * @description: 删除数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 14:27
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    CommonResult<Boolean> delUserOrg(UserOrgForm.Del form);

    CommonResult<Boolean> delById(UserOrgForm.Del form);

    /**
     * @description: 批量删除
     * @author: zhangsq
     * @date: Created in 2020-10-21 10:59
     * @param userIdList
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    CommonResult<Boolean> batchDelUserOrg(List<Long> userIdList);
    /**
     * @description 根据用户id查询用户所在机构
     * @author zlx
     * @date 2020/10/24 12:09
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserOrg>>
     */
    CommonResult<List<UserOrg>> findUserOrgByUserId(UserOrgForm.Search form);
    /**
     * @description 据机构id分页查询人员数据分页
     * @author zlx
     * @date 2020/10/28 17:59
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.UserOrg>>
     */
    CommonResult<Page<UserOrg>> findUserOrgPageByOrgId(UserOrgForm.Get form,int curPage,int pageSize);
    /**
     * @description 据机构id分页查询所有人员数据
     * @author zlx
     * @date 2020/11/12 16:35
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserOrg>>
     */
    CommonResult<List<UserOrg>> findUserOrgListByOrgId(UserOrgForm.Get form);
    /**
     * @description 根据组织机构id和部门id判断是否存在人员
     * @author zlx
     * @date 2020/11/23 16:09
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    CommonResult<Boolean> checkUserOrgByOrgIdAndDeptId(UserOrgForm.Get form);
}
