package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.shop.unifyworkbench.sdk.UserOrgSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.UserOrg;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserOrgForm;
import com.redare.shop.unifyworkbench.service.service.UserOrgService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : zhangsq
 * @version :
 * @description：人员组织机构接口实现类
 * @date ：Created in 2020-10-20 14:52
 */
@Service
public class UserOrgSdkImpl implements UserOrgSdk {

    @Autowired
    UserOrgService userOrgService;

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
    @Override
    public CommonResult<Page<UserOrg>> findUserOrgPage(UserOrgForm.Search form, int curPage, int pageSize) {
        return CommonResult.returnSuccessWrapper(userOrgService.findUserOrgPage(form, curPage, pageSize));
    }
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
    @Override
    public CommonResult<List<UserOrg>> findUserOrgPageList(UserOrgForm.Search form, int curPage, int pageSize) {
        return CommonResult.returnSuccessWrapper(userOrgService.findUserOrgPageList(form, curPage, pageSize));
    }
    /**
     * @description: 查询所有数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 14:26
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserOrg>>
     * @exception:
     */
    @Override
    public CommonResult<List<UserOrg>> findUserOrgList(UserOrgForm.Search form) {
        return CommonResult.returnSuccessWrapper(userOrgService.findUserOrgList(form));
    }
    /**
     * @description: 根据主键id查询数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 14:27
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<com.redare.shop.unifyworkbench.sdk.pojo.UserOrg>
     * @exception:
     */
    @Override
    public CommonResult<UserOrg> findUserOrg(UserOrgForm.Get form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        return CommonResult.returnSuccessWrapper(userOrgService.findUserOrg(form));
    }
    /**
     * @description: 添加数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 14:27
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    @Override
    public CommonResult<Boolean> addUserOrg(UserOrgForm.Add form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        return CommonResult.returnBoolWrapper(userOrgService.addUserOrg(form),"添加失败");
    }

    /**
     * @description: 批量添加
     * @author: zhangsq
     * @date: Created in 2020-10-21 11:31
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    @Override
    public CommonResult<Boolean> batchAddUserOrg(UserOrgForm.BatchAdd form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        return CommonResult.returnBoolWrapper(userOrgService.batchAddUserOrg(form),"添加失败");
    }

    /**
     * @description: 编辑数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 14:27
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    @Override
    public CommonResult<Boolean> editUserOrg(UserOrgForm.Edit form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        return CommonResult.returnBoolWrapper(userOrgService.editUserOrg(form),"编辑失败");
    }
    /**
     * @description: 删除数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 14:27
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    @Override
    public CommonResult<Boolean> delUserOrg(UserOrgForm.Del form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        return CommonResult.returnBoolWrapper(userOrgService.delUserOrg(form),"删除失败");
    }

    @Override
    public CommonResult<Boolean> delById(UserOrgForm.Del form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        return CommonResult.returnBoolWrapper(userOrgService.delById(form),"删除失败");
    }

    /**
     * @description: 批量删除数据
     * @author: zhangsq
     * @date: Created in 2020-10-21 11:03
     * @param userIdList
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    @Override
    public CommonResult<Boolean> batchDelUserOrg(List<Long> userIdList) {
        return CommonResult.returnBoolWrapper(userOrgService.batchDelUserOrg(userIdList) > 0,"删除失败");
    }

    /**
     * @description 根据用户id查询用户所在的机构
     * @author zlx
     * @date 2020/10/24 14:10
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserOrg>>
     */
    @Override
    public CommonResult<List<UserOrg>> findUserOrgByUserId(UserOrgForm.Search form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        if (form.getUserId() == null){
            return CommonResult.returnFailsWrapper("用户id不能为空");
        }
        return CommonResult.returnSuccessWrapper(userOrgService.findUserOrgByUserId(form));
    }

    /**
     * @description 据机构id分页查询人员数据分页
     * @author zlx
     * @date 2020/10/28 18:02
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.UserOrg>>
     */
    @Override
    public CommonResult<Page<UserOrg>> findUserOrgPageByOrgId(UserOrgForm.Get form, int curPage, int pageSize) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        if (StringUtils.isBlank(form.getOrgId())){
            return CommonResult.returnFailsWrapper("组织机构id不能为空");
        }
        return CommonResult.returnSuccessWrapper(userOrgService.findUserOrgPageByOrgId(form, curPage, pageSize));
    }

    /**
     * @description 据机构id分页查询人员数据
     * @author zlx
     * @date 2020/11/12 16:38
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserOrg>>
     */
    @Override
    public CommonResult<List<UserOrg>> findUserOrgListByOrgId(UserOrgForm.Get form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        if (StringUtils.isBlank(form.getOrgId())){
            return CommonResult.returnFailsWrapper("组织机构id不能为空");
        }
        return CommonResult.returnSuccessWrapper(userOrgService.findUserOrgListByOrgId(form));
    }

    /**
     * @description 根据组织机构id和部门id判断是否存在人员
     * @author zlx
     * @date 2020/11/23 16:15
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    @Override
    public CommonResult<Boolean> checkUserOrgByOrgIdAndDeptId(UserOrgForm.Get form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        if (StringUtils.isBlank(form.getOrgId())){
            return CommonResult.returnFailsWrapper("组织机构id不能为空");
        }
        if (StringUtils.isBlank(form.getDeptId())){
            return CommonResult.returnFailsWrapper("部门id不能为空");
        }
        return CommonResult.returnSuccessWrapper(userOrgService.checkUserOrgByOrgIdAndDeptId(form));
    }
}
