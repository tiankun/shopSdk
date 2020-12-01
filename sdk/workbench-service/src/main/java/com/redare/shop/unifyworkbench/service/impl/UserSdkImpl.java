package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.devframework.webplatform.sdk.core.AccountSdk;
import com.redare.devframework.webplatform.sdk.core.PlatformSdk;
import com.redare.devframework.webplatform.sdk.core.arg.AccountArg;
import com.redare.devframework.webplatform.sdk.core.arg.PlatformMenuArg;
import com.redare.devframework.webplatform.sdk.core.arg.RoleArg;
import com.redare.devframework.webplatform.sdk.core.pojo.Account;
import com.redare.devframework.webplatform.sdk.core.pojo.PlatformMenu;
import com.redare.shop.unifyworkbench.sdk.UserSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.User;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserForm;
import com.redare.shop.unifyworkbench.service.pojo.arg.UserArg;
import com.redare.shop.unifyworkbench.service.service.UserService;
import com.redare.shop.unifyworkbench.service.util.PinyinUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/6/30 14:07
 * @version: 1.1
 */
@Service
public class UserSdkImpl implements UserSdk {

    public static final String ORG_ID_PREFIX = "orgId_";
    @Autowired
    UserService userService;

    @Autowired
    AccountSdk accountSdk;

    @Autowired
    PlatformSdk platformSdk;

    /**
     * @description 根据手机号码查询用户信息
     * @author zlx
     * @date 2020/6/30 14:10
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.shop.unifyworkbench.sdk.pojo.User>
     */
    @Override
    public CommonResult<User> findUserByMobile(UserForm.Get form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        User user = userService.findUserByMobile(form);
        return CommonResult.returnSuccessWrapper(user);
    }

    /**
     * @description 根据机构id查询机构下人员信息
     * @author zlx
     * @date 2020/7/6 16:59
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.User>>
     */
    @Override
    public CommonResult<List<User>> findUserListByOrgId(UserForm.Search form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        List<User> list = userService.findUserListByOrgId(form);
        return CommonResult.returnSuccessWrapper(list);
    }

    /**
     * @description: 通讯录中根据组织机构id或ParentId查询机构下的用户信息
     * @author: zhangsq
     * @date: Created in 2020-07-17 10:59
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.User>>
     * @exception:
     */
    @Override
    public CommonResult<Page<User>> findContactsBookUserListByOgrId(UserForm.Search form, int curPage, int pageSize) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        return CommonResult.returnSuccessWrapper(userService.findContactsBookUserListByOgrId(form, curPage, pageSize));
    }

    /**
     * @description: 用户管理中根据员工Id查询该员工在Base_user表是否存在
     * @author: zhangsq
     * @date: Created in 2020-07-28 14:41
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<com.redare.shop.unifyworkbench.sdk.pojo.User>
     * @exception:
     */
    @Override
    public CommonResult<Boolean> findByStaffIdBaseUser(UserForm.GetStaffId form) {
        User user = userService.findByStaffIdBaseUser(form);
        return CommonResult.returnDataWrapper(user != null?true:false);
    }

    @Override
    public CommonResult<Page<User>> findUserPage(UserForm.Search form, int curPage, int pageSize) {
        return CommonResult.returnSuccessWrapper(userService.findUserPage(form, curPage, pageSize));
    }

    @Override
    public CommonResult<List<User>> findUserList(UserForm.Search form, int curPage, int pageSize) {
        return CommonResult.returnSuccessWrapper(userService.findUserList(form, curPage, pageSize));
    }

    @Override
    public CommonResult<List<User>> findUserList(UserForm.Search form) {
        return CommonResult.returnSuccessWrapper(userService.findUserAll(form));
    }

    @Override
    public CommonResult<User> getUser(UserForm.Get form) {
        User user = userService.getUser(form);
        return CommonResult.returnDataWrapper(user);
    }

    @Transactional
    @Override
    public CommonResult<Long> addUser(UserForm.Add form) {
        CommonResult result = ValidationUtils.simpleValidate(form);
        if (result.isNotSuccess()) {
            return result;
        }

        if (!form.getPwd().equals(form.getPwd1())) {
            return CommonResult.returnFailsWrapper("两次密码输入不一致");
        }
        if (null == form.getOrgParentId()) {
            return CommonResult.returnFailsWrapper("组织机构父Id不能为空");
        }

        // 将姓名name值生成拼音拼音首字母
        if (!"".equals(form.getName())) {
            form.setNamePinyinInitials(PinyinUtils.getFirstSpell(form.getName()).toUpperCase());
            form.setNamePinyinShort(PinyinUtils.getFirstSpell(form.getName()).substring(0,1).toUpperCase());
        }

        result = this.validateUserInfo(form);
        if (result.isNotSuccess()){
            return CommonResult.returnFailsWrapper(result.getMessage());
        }
        result = this.validateUserPassword(new AccountArg.Password().setPassword(form.getPwd()));
        if (result.isNotSuccess()){
            return CommonResult.returnFailsWrapper(result.getMessage());
        }
        Account account =  accountSdk.getAccount(new UserForm.Get().setAccount(form.getAccount())).getData();
        if (account != null){
            return CommonResult.returnFailsWrapper("账户已存在");
        }
        List<PlatformMenu> platformMenuList =  platformSdk.findMenuList(new PlatformMenuArg.Search().setDefaults(true).setEnabled(true).setPlatform(form.getPlatform())).getData();
        if (platformMenuList != null && platformMenuList.size() > 0){
            form.setMenuId(platformMenuList.get(0).getId());
        }
        if (StringUtils.isNotBlank(form.getMobile())){
            User user = this.getUser(new UserForm.Get().setMobile(form.getMobile())).getData();
            if (user != null){
                return CommonResult.returnFailsWrapper("手机号已被使用");
            }
        }
        // 判断员工是否已经绑定
        if (form.getStaffId() != null){
            User user = userService.findByStaffIdBaseUser(new UserForm.GetStaffId().setStaffId(form.getStaffId()));
            if (user != null){
                return CommonResult.returnFailsWrapper("员工姓名已经存在了");
            }
        }

        long userId = userService.addUser(new UserArg.AddForm()
                        .setEmail(form.getEmail())
                        .setMobile(form.getMobile())
                        .setName(form.getName())
                        .setGender(form.getGender())
                        .setAddress(form.getAddress())
                        .setOrgId(form.getOrgId())
                        .setOrgName(form.getOrgName())
                        .setOrgParentId(form.getOrgParentId())
                        .setOrgParentName(form.getOrgParentName())
                        .setNamePinyinInitials(form.getNamePinyinInitials())
                        .setNamePinyinShort(form.getNamePinyinShort())
                        .setStaffName(form.getStaffName())
                        .setStaffId(form.getStaffId()),
                new AccountArg.Add()
                        .setAccount(form.getAccount())
                        .setPlatform(form.getPlatform())
                        .setUserPlatform(String.format("%s_%s",form.getPlatform(),form.getOrgId()))
                        .setRoleIds(form.getRoleIds())
                        .setNeedResetPwd(form.isNeedResetPwd())
                        .setMenuId(form.getMenuId())
                        .setPwd(form.getPwd()));
//                        .setPwd(DigestUtils.md5Hex(form.getPwd())));

        return CommonResult.returnBoolWrapper(userId > 0, "保存失败", userId);
    }

    @Transactional
    @Override
    public CommonResult<Void> editUser(UserForm.Edit form) {
        CommonResult result = ValidationUtils.simpleValidate(form);
        if (result.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(result.getMessage());
        }
        Account account = accountSdk.getAccount(new UserForm.Get()
                .setId(form.getUserId())
                .setStatus(0)
        ).getData();
        if (account == null){
            return CommonResult.returnFailsWrapper("账号不存在");
        }

        // 将姓名name值生成拼音拼音首字母
        if (!"".equals(form.getName())) {
            if(!PinyinUtils.getFirstSpell(form.getName()).toUpperCase().equals(form.getNamePinyinInitials())) {
                form.setNamePinyinInitials(PinyinUtils.getFirstSpell(form.getName()).toUpperCase());
                form.setNamePinyinShort(PinyinUtils.getFirstSpell(form.getName()).substring(0,1).toUpperCase());
            }
        }
        if (StringUtils.isNotBlank(form.getAccount())){
            account = accountSdk.getAccount(new UserForm.Get().setAccount(form.getAccount())).getData();
            if (account != null && account.getId() != form.getUserId()){
                return CommonResult.returnFailsWrapper("账户已存在");
            }
        }
        if (StringUtils.isNotBlank(form.getMobile())){
            User user = this.getUser(new UserForm.Get().setMobile(form.getMobile())).getData();
            if (user != null && user.getId() != form.getUserId().longValue()){
                return CommonResult.returnFailsWrapper("手机号已被使用");
            }
        }
        UserForm.Get Getform = new UserForm.Get();
        Getform.setId(form.getUserId());

        boolean bool = this.userService.editUser(form);
        return CommonResult.returnBoolWrapper(bool, "操作失败");
    }

    @Transactional
    @Override
    public CommonResult<Boolean> updateUserPwd(UserForm.Pwd form) {
        CommonResult result = ValidationUtils.simpleValidate(form);
        if (result.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(result.getMessage());
        }
        if (!StringUtils.equals(form.getPwd1(), form.getPwd2())) {
            return CommonResult.returnFailsWrapper("两次输入的密码不一致！");
        }
        result = this.validateUserPassword(new AccountArg.Password().setPassword(form.getPwd1()));
        if (result.isNotSuccess()){
            return CommonResult.returnFailsWrapper(result.getMessage());
        }
        User userInfo = userService.getUser((UserForm.Get) new UserForm.Get().setId(form.getAccountId()));
        /*String pwd = userInfo.getPwd();
        String md5pwd = DigestUtils.md5Hex(form.getPwd());
        if (!md5pwd.equals(pwd)) {
            return CommonResult.returnFailsWrapper("修改失败，原密码错误");
        }*/
        String md5pdw1 = DigestUtils.md5Hex(form.getPwd1());
        form.setPwd1(md5pdw1);
        return CommonResult.returnBoolWrapper(userService.resetUserPwd(new UserForm.ResetPwd().setPwd(md5pdw1).setAccount(userInfo.getAccount())), "修改密码失败");
    }

    @Transactional
    @Override
    public CommonResult<Void> deleteUser(AccountArg.Del form) {
        CommonResult result = ValidationUtils.simpleValidate(form);
        if (result.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(result.getMessage());
        }
        return accountSdk.delAccount(form);
    }

    public CommonResult<Void> validateUserInfo(com.redare.devframework.webplatform.sdk.core.arg.UserArg.Add form) {
        CommonResult result = accountSdk.validateAccountInfo(form);
        if (result.isNotSuccess()) {
            return result;
        }
        result = ValidationUtils.simpleValidate(form);
        if (result.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(result.getMessage());
        }
        return result;
    }

    public CommonResult<Void> validateUserPassword(AccountArg.Password form) {
        return accountSdk.validateAccountPassword(form);
    }

    @Override
    public CommonResult<Void> modifyUserRole(RoleArg.Modify form) {
        CommonResult result = ValidationUtils.simpleValidate(form);
        if (result.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(result.getMessage());
        }
        Account account = accountSdk.getAccount(new UserForm.Get().setId(form.getAccountId())).getData();
        if (account == null){
            return CommonResult.returnFailsWrapper("账号不存在");
        }
        return accountSdk.modifyRole(form.setReplace(true));
    }




    /**
     * @param str
     * @param list2
     * @return boolean
     * @description 判断两个逗号分隔字符串是否相等
     * @author zlx
     * @date 2020/7/27 15:20
     */
    private boolean checkDiffrent(String str, List<Long> list2) {
        List<Long> list1 = new ArrayList<>();
        if (StringUtils.isNotBlank(str)) {
            list1 = Arrays.stream(str
                    .split(","))
                    .map(Long::parseLong)
                    .collect(Collectors.toList());
        }
        if (list2 == null) {
            list2 = new ArrayList<>();
        }
        list1.sort(Comparator.comparing(t -> Long.hashCode(t)));
        list2.sort(Comparator.comparing(t -> Long.hashCode(t)));
        return list1.toString().equals(list2.toString());
    }


    @Override
    public CommonResult<Void> changeSubscribeStatus(UserForm.SubscribeStatus form) {
        CommonResult result = ValidationUtils.simpleValidate(form);
        if (result.isNotSuccess()){
            return result;
        }
        result = this.editUser(new UserForm.Edit().setUserId(form.getUserId()).setSubscribeStatus(form.getSubscribeStatus()));
        if (result.isNotSuccess()){
            return CommonResult.returnFailsWrapper("修改订阅状态失败");
        }
        return CommonResult.returnSuccessWrapper();
    }



    @Transactional
    @Override
    public CommonResult<Void> resetUserPwd(UserForm.ResetPwd form) {
        CommonResult result = ValidationUtils.simpleValidate(form);
        if (result.isNotSuccess()){
            return result;
        }
        if (!form.getPwd().equalsIgnoreCase(form.getConfirmPwd())){
            return CommonResult.returnFailsWrapper("两次输入的密码不一致");
        }
        result = this.validateUserPassword(new AccountArg.Password().setPassword(form.getPwd()));
        if (result.isNotSuccess()){
            return result;
        }
        UserForm.Get get = new UserForm.Get();
        get.setMobile(form.getMobile()).setAccount(form.getAccount());
        User user = this.getUser(get).getData();
        if (user == null){
            return CommonResult.returnFailsWrapper("账户不存在");
        }
        boolean bl = userService.resetUserPwd(form.setAccount(user.getAccount()));
        if (bl){
            this.editUser(new UserForm.Edit().setUserId(user.getId()).setWxOpenId(""));
        }
        return CommonResult.returnBoolWrapper(bl,"重置失败");
    }
}
