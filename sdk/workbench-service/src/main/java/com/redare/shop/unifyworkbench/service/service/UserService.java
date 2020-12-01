package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.webplatform.sdk.core.arg.AccountArg;
import com.redare.devframework.webplatform.sdk.core.arg.RoleArg;
import com.redare.devframework.webplatform.sdk.core.pojo.PlatformRole;
import com.redare.devframework.webplatform.service.core.pojo.AccountForm;
import com.redare.devframework.webplatform.service.core.service.AccountService;
import com.redare.shop.unifyworkbench.sdk.pojo.User;
import com.redare.shop.unifyworkbench.service.dao.UserDao;
import com.redare.shop.unifyworkbench.service.pojo.arg.UserArg;
import com.redare.shop.unifyworkbench.sdk.pojo.form.TreeNode;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserForm;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/6/30 14:05
 * @version: 1.1
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    AccountService accountService;

    /**
     * @description 根据手机号码查询用户信息
     * @author zlx
     * @date 2020/6/30 14:06
     * @param form
     * @return com.redare.shop.unifyworkbench.sdk.pojo.User
     */
    public User findUserByMobile(UserForm.Get form){
        return userDao.findUserByMobile(form);
    }

    /**
     * @description 根据机构id查询机构下人员信息
     * @author zlx
     * @date 2020/7/6 16:57
     * @param form
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.User>
     */
    public List<User> findUserListByOrgId(UserForm.Search form){
        return userDao.findUserListByOgrId(form);
    }

    /**
     * @description: 通讯录中根据组织机构id或ParentId查询机构下的用户信息
     * @author: zhangsq
     * @date: Created in 2020-07-17 11:00
     * @param form
     * @return: java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.User>
     * @exception:
     */
    public Page<User> findContactsBookUserListByOgrId(UserForm.Search form ,int curPage, int pageSize){
        return userDao.findContactsBookUserListByOgrId(form, curPage, pageSize, true, false);
    }

    /**
     * @description: 用户管理中根据员工Id查询该员工在Base_user表是否存在
     * @author: zhangsq
     * @date: Created in 2020-07-28 14:44
     * @param form
     * @return: com.redare.shop.unifyworkbench.sdk.pojo.User
     * @exception:
     */
    public User findByStaffIdBaseUser(UserForm.GetStaffId form){
        return userDao.findByStaffIdBaseUser(form);
    }

    public Page<User> findUserPage(UserForm.Search form, int curPage, int pageSize) {
        return userDao.findUserPage(form, curPage, pageSize, true, false);
    }

    public List<User> findUserList(UserForm.Search form, int curPage, int pageSize) {
        return userDao.findUserPage(form, curPage, pageSize, false, false).getResult();
    }

    public List<User> findUserAll(UserForm.Search form) {
        return userDao.findUserPage(form, 0, 0, false, true).getResult();
    }

    public long getUserCount(UserForm.Search form) {
        return userDao.getUserCount(form);
    }

    public User getUser(UserForm.Get form) {
        User user = userDao.getUser(form);
        if (user != null) {
            List<PlatformRole> roleList = accountService.findRoleList(new RoleArg.Search().setAccountId(user.getId()));
            if (CollectionUtils.isNotEmpty(roleList)) {
                for (PlatformRole role : roleList) {
                    if (role.isAdmin()) {
                        user.setAdmin(true);
                        break;
                    }
                }
            }
            user.setRoleList(roleList);
        }
        return user;
    }

    @Transactional
    public Long addUser(UserArg.AddForm form, AccountArg.Add accountAdd) {
        long userId = accountService.addAccount(accountAdd);
        form.setUserId(userId);
        userDao.addUser(form);
        return userId;
    }

    @Transactional
    public boolean editUser(UserForm.Edit form) {
        boolean bl = this.userDao.editUser(form) > 0;
        if (StringUtils.isNotBlank(form.getAccount())){
            this.accountService.modifyAccount(new AccountForm.Modify().setAccount(form.getAccount()).setWhere(new AccountForm.Modify.Where().setId(form.getUserId())));
        }
        return bl;
    }

    public boolean resetUserPwd(UserForm.ResetPwd form) {
        return userDao.resetUserPwd(form) > 0;
    }

    public List<TreeNode> findUserTreeNode(UserForm.Search form) {
        return userDao.findUserTreeNode(form);
    }

    /**
     * @description 根据逗号分隔的角色id和机构id查询可用的用户信息
     * @author zlx
     * @date 2020/7/24 14:55
     * @param roleIds
     * @param orgIds
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.User>
     */
    public List<User> findByRoleIdsAndOrgIds(String roleIds,String orgIds){
        return userDao.findByRoleIdsAndOrgIds(roleIds, orgIds);
    }

    /**
     * @description 查询oa账号密码
     * @author zlx
     * @date 2020/7/24 17:22
     * @param roleIds
     * @param orgIds
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.User>
     */
    public List<User> findOaAccountByRoleIdsAndOrgIds(String roleIds,String orgIds){
        return userDao.findOaAccountByRoleIdsAndOrgIds (roleIds, orgIds);
    }
}
