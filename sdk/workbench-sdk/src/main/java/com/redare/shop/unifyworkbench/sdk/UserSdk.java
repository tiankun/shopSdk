package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.webplatform.sdk.core.arg.AccountArg;
import com.redare.devframework.webplatform.sdk.core.arg.RoleArg;
import com.redare.shop.unifyworkbench.sdk.pojo.User;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserForm;

import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/6/30 11:12
 * @version: 1.1
 */
public interface UserSdk {

    /**
     * @description 根据手机号码查询用户信息
     * @author zlx
     * @date 2020/7/6 16:50
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.shop.unifyworkbench.sdk.pojo.User>
     */
    CommonResult<User> findUserByMobile(UserForm.Get form);

    /**
     * @description 根据组织机构id查询机构下的用户信息
     * @author zlx
     * @date 2020/7/6 16:50
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.User>>
     */
    CommonResult<List<User>> findUserListByOrgId(UserForm.Search form);

    /**
     * @description: 通讯录中根据组织机构id或ParentId查询机构下的用户信息
     * @author: zhangsq
     * @date: Created in 2020-07-17 10:59
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.User>>
     * @exception:
     */
    CommonResult<Page<User>> findContactsBookUserListByOgrId(UserForm.Search form, int curPage, int pageSize);

    /**
     * @description: 用户管理中根据员工Id查询该员工在Base_user表是否存在
     * @author: zhangsq
     * @date: Created in 2020-07-28 14:41
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<com.redare.shop.unifyworkbench.sdk.pojo.User>
     * @exception:
     */
    CommonResult<Boolean> findByStaffIdBaseUser(UserForm.GetStaffId form);

    CommonResult<Page<User>> findUserPage(UserForm.Search form, int curPage, int pageSize);

    CommonResult<List<User>> findUserList(UserForm.Search form, int curPage, int pageSize);

    CommonResult<List<User>> findUserList(UserForm.Search form);

    CommonResult<User> getUser(UserForm.Get form);

    CommonResult<Long> addUser(UserForm.Add form);

    CommonResult<Void> editUser(UserForm.Edit form);

    CommonResult<Boolean> updateUserPwd(UserForm.Pwd form);

    CommonResult<Void> deleteUser(AccountArg.Del form);

    CommonResult<Void> modifyUserRole(RoleArg.Modify form);

    CommonResult<Void> changeSubscribeStatus(UserForm.SubscribeStatus form);


    /**
     * 重置密码
     * @param form
     * @return
     */
    CommonResult<Void> resetUserPwd(UserForm.ResetPwd form);


}
