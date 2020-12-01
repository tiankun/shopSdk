package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.devframework.webplatform.sdk.core.AccountSdk;
import com.redare.devframework.webplatform.sdk.core.arg.AccountArg;
import com.redare.devframework.webplatform.sdk.core.pojo.Account;
import com.redare.shop.unifyworkbench.sdk.BaseUserSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.*;
import com.redare.shop.unifyworkbench.sdk.pojo.form.*;
import com.redare.shop.unifyworkbench.service.service.BaseUserService;
import com.redare.shop.unifyworkbench.service.service.OrganizationService;
import com.redare.shop.unifyworkbench.service.service.UserHonorService;
import com.redare.shop.unifyworkbench.service.service.UserOrgService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @description: 人员信息接口实现类
 * @author: zhangsq
 * @date: Created in 2020-10-20 14:56
 * @return:
 * @exception:
 */
@Service
public class BaseUserSdkImpl implements BaseUserSdk {

    @Autowired
    BaseUserService baseUserService;

    @Autowired
    UserOrgService userOrgService;

    @Autowired
    UserHonorService userHonorService;

    @Autowired
    AccountSdk accountSdk;

    @Autowired
    OrganizationService organizationService;

    /**
     * @description: 根据用户姓名和手机号码查询用户信息
     * @author: zhangsq
     * @date: Created in 2020-10-20 11:31
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<com.redare.shop.unifyworkbench.sdk.pojo.BaseUser>
     * @exception:
     */
    @Override
    public CommonResult<BaseUser> getBaseUserByNameAndPhone(BaseUserForm.Search form) {
        return CommonResult.returnDataWrapper(baseUserService.getBaseUserByNameAndPhone(form));
    }

    @Override
    public CommonResult<List<BaseUserTree>> findBaseUserTreePage(BaseUserForm.Search form, int curPage, int pageSize) {
        // 查询部门信息、部门人员统计
        List<BaseUserDept>  baseUserDeptList = baseUserService.findBaseUserDept(form,curPage,pageSize);
        // 查询部门下的人员信息
        List<BaseUser> baseUserList = baseUserService.findBaseUserList(form);

        List<BaseUserTree> baseUserTreeList = new ArrayList<>();
        for(BaseUserDept baseUserDept : baseUserDeptList){
            BaseUserTree baseUserTree = new BaseUserTree();
            baseUserTree.setDepartmentId(baseUserDept.getDeptId());
            baseUserTree.setDepartmentName(baseUserDept.getDeptName().concat("（").concat(String.valueOf(baseUserDept.getCount())).concat("）"));
            baseUserTree.setUserNumbers(baseUserDept.getCount());

            List<BaseUser> userList = new ArrayList<>();
            for(BaseUser baseUser: baseUserList){
                if(StringUtils.isNotBlank(baseUserDept.getDeptId()) && baseUserDept.getDeptId().equals(baseUser.getDeptId())){
                    userList.add(baseUser);
                }
            }
            baseUserTree.setChildren(userList);
            baseUserTreeList.add(baseUserTree);
        }
        return CommonResult.returnSuccessWrapper(baseUserTreeList);
    }

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
    @Override
    public CommonResult<Page<BaseUser>> findBaseUserPage(BaseUserForm.Search form, int curPage, int pageSize) {
        return CommonResult.returnSuccessWrapper(baseUserService.findBaseUserPage(form, curPage, pageSize));
    }
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
    @Override
    public CommonResult<List<BaseUser>> findBaseUserPageList(BaseUserForm.Search form, int curPage, int pageSize) {
        return CommonResult.returnSuccessWrapper(baseUserService.findBaseUserPageList(form, curPage, pageSize));
    }
    /**
     * @description: 查询所有人员数据，不分页
     * @author: zhangsq
     * @date: Created in 2020-10-20 10:21
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.BaseUser>>
     * @exception:
     */
    @Override
    public CommonResult<List<BaseUser>> findBaseUserList(BaseUserForm.Search form) {
        return CommonResult.returnSuccessWrapper(baseUserService.findBaseUserList(form));
    }
    /**
     * @description: 根据主键id查询人员数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 10:34
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<com.redare.shop.unifyworkbench.sdk.pojo.BaseUser>
     * @exception:
     */
    @Override
    public CommonResult<BaseUser> findBaseUser(BaseUserForm.Get form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        BaseUser baseUser = baseUserService.findBaseUser(form);
        // 查询岗位信息
        List<UserOrg> userOrgList = userOrgService.findUserOrgList(new UserOrgForm.Search().setUserId(baseUser.getUserId()).setDel(0));
        baseUser.setUserOrgList(userOrgList);
        // 查询荣誉信息
        List<UserHonor> userHonorList = userHonorService.findUserHonorList(new UserHonorForm.Search().setUserId(baseUser.getUserId()).setDel(0));
        baseUser.setUserHonorList(userHonorList);
        return CommonResult.returnSuccessWrapper(baseUser);
    }

    /**
     * @description: 根据身份证ID进行查询
     * @author: zhangsq
     * @date: Created in 2020-11-09 10:27
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<com.redare.shop.unifyworkbench.sdk.pojo.BaseUser>
     * @exception:
     */
    @Override
    public CommonResult<BaseUser> findByCardNoBaseUser(BaseUserForm.Get form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        BaseUser baseUser = baseUserService.findByCardNoBaseUser(form);
        return CommonResult.returnSuccessWrapper(baseUser);
    }

    /**
     * @description: 添加人员数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 10:42
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.String>
     * @exception:
     */
    @Override
    public CommonResult<String> addBaseUser(BaseUserForm.Add form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        // 将人员添加至account
        Account account =  accountSdk.getAccount(new UserForm.Get().setAccount(form.getName())).getData();
        if (account != null){
            return CommonResult.returnFailsWrapper("账户已存在");
        }

        AccountArg.Add accountAdd = new AccountArg.Add();
        accountAdd.setAccount(form.getMobile());// 用户名
        accountAdd.setPwd("abc123456");// 密码
        accountAdd.setPlatform("shop");// 平台
        List<Long> roleIds = new ArrayList<>();
        roleIds.add((long) 26);
        accountAdd.setRoleIds(roleIds);

        List<String> strList = new ArrayList<>();
        for (UserOrgForm.Add userOrg: form.getUserOrgList()){
            strList.add(userOrg.getOrgId());
        }

        if(strList != null && strList.size() > 0){
            // 获取组织机构级别最大的OrgId
            List<Organization> organizationList =
                    organizationService.findByAreaLevelOrganization(new OrganizationForm.BatchDel().setOrgIdList(strList));
            if(null != organizationList && organizationList.size() > 0){
                Organization organization = organizationList.stream().max(Comparator.comparing(Organization::getAreaLevel)).get();
                accountAdd.setUserPlatform(organization.getOrgId());
            }
        }

        CommonResult<Long> accountId = accountSdk.addAccount(accountAdd);
        form.setUserId(accountId.getData());
        form.setUserType(1);
        baseUserService.addBaseUser(form);
        // 添加岗位信息
        if (form.getUserOrgList() != null && form.getUserOrgList().size()>0){
            for (UserOrgForm.Add add : form.getUserOrgList()){
                add.setUserId(accountId.getData());
            }
            // 批量添加人员机构信息
            UserOrgForm.BatchAdd batchUserOrgAdd = new UserOrgForm.BatchAdd();
            batchUserOrgAdd.setList(form.getUserOrgList()).setUserId(accountId.getData());
            userOrgService.batchAddUserOrg(batchUserOrgAdd);
        }

        // 添加荣誉信息
        if (form.getUserHonorList() != null && form.getUserHonorList().size()>0){
            for (UserHonorForm.Add add : form.getUserHonorList()){
                add.setUserId(accountId.getData());
            }
            // 批量添加
            UserHonorForm.BatchAdd batchUserHonorAdd = new UserHonorForm.BatchAdd();
            batchUserHonorAdd.setList(form.getUserHonorList()).setUserId(accountId.getData());
            userHonorService.batchAddUserHonor(batchUserHonorAdd);
        }

        return CommonResult.returnSuccessWrapper(accountAdd.getUserPlatform());
    }

    /**
     * @description: 编辑人员数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 10:46
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    @Override
    public CommonResult<String> editBaseUser(BaseUserForm.Edit form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        List<String> strList = new ArrayList<>();
        for (UserOrgForm.Add userOrg: form.getUserOrgList()){
            strList.add(userOrg.getOrgId());
        }
        AccountArg.Add accountAdd = new AccountArg.Add();
        if(strList != null && strList.size() > 0){
            // 获取组织机构级别最大的OrgId
            List<Organization> organizationList =
                    organizationService.findByAreaLevelOrganization(new OrganizationForm.BatchDel().setOrgIdList(strList));
            if(null != organizationList && organizationList.size() > 0){
                Organization organization = organizationList.stream().max(Comparator.comparing(Organization::getAreaLevel)).get();
                accountAdd.setUserPlatform(organization.getOrgId());
            }
        }
        //accountSdk.modifyUserPlatform(new AccountArg.UserPlatform().setUserPlatform(accountAdd.getUserPlatform()).setAccountId(form.getUserId()));
        accountSdk.modifyAccount(new AccountArg.Account().setAccountId(form.getUserId()).setAccount(form.getMobile()).setUserPlatform(accountAdd.getUserPlatform()));
        baseUserService.editBaseUser(form);
        // 编辑人员组织机构信息
        if (form.getUserOrgList() != null && form.getUserOrgList().size()>0){
            // 删除人员机构信息
            userOrgService.delUserOrg(new UserOrgForm.Del().setUserId(form.getUserId()));
            // 重新添加
            userOrgService.batchAddUserOrg(new UserOrgForm.BatchAdd().setUserId(form.getUserId()).setList(form.getUserOrgList()));
        }
        // 编辑人员荣誉信息
        if (form.getUserHonorList() != null && form.getUserHonorList().size()>0){
            // 删除人员荣誉信息
            userHonorService.delByUserHonor(new UserHonorForm.Del().setUserId(form.getUserId()));
            // 重新添加
            userHonorService.batchAddUserHonor(new UserHonorForm.BatchAdd().setUserId(form.getUserId()).setList(form.getUserHonorList()));
        }
        return CommonResult.returnSuccessWrapper(accountAdd.getUserPlatform());
    }

    /**
     * @description: 删除人员信息
     * @author: zhangsq
     * @date: Created in 2020-10-20 10:55
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    @Override
    public CommonResult<Boolean> delBaseUser(BaseUserForm.BatchDel form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        baseUserService.delBaseUser(form);
        // 删除人员组织机构信息
        userOrgService.batchDelUserOrg(form.getUserIdList());
        // 删除人员荣誉信息
        userHonorService.batchDelUserHonor(form.getUserIdList());
        return CommonResult.returnBoolWrapper(true,"删除失败");
    }
}
