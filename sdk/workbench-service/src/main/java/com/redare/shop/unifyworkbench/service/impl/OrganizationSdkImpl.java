package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.devframework.webplatform.sdk.core.AccountSdk;
import com.redare.devframework.webplatform.sdk.core.arg.AccountArg;
import com.redare.shop.unifyworkbench.sdk.OrganizationSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.Organization;
import com.redare.shop.unifyworkbench.sdk.pojo.OrganizationStatistics;
import com.redare.shop.unifyworkbench.sdk.pojo.form.*;
import com.redare.shop.unifyworkbench.service.service.*;
import com.redare.shop.unifyworkbench.service.util.PinyinUtils;
import com.redare.shop.unifyworkbench.service.util.UUIDutils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 组织机构表(Organization)SdkImpl
 *
 * @author makejava
 * @since 2020-10-16 11:58:37
 */
@Service
public class OrganizationSdkImpl implements OrganizationSdk {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationSdkImpl.class);

    private static final String[] HXCLASSIFY=new String[]{"office","institution","colleges","twoNew","school","society"};

    private static final String[] ZXCLASSIFY=new String[]{"local","township","street","administrative","community"};

    @Autowired
    OrganizationService organizationService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    OrganizeChangeTermService organizeChangeTermService;

    @Autowired
    OrganizeHonorService organizeHonorService;

    @Autowired
    UserOrgService userOrgService;

    @Autowired
    AccountSdk accountSdk;

    @Autowired
    BaseUserService baseUserService;


    /**
     * @description 分页查询
     * @author zlx
     * @date 2020/10/16 14:58
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.Organization>>
     */
    @Override
    public CommonResult<Page<Organization>> findOrganizationPage(OrganizationForm.Search form, int curPage, int pageSize) {
        return CommonResult.returnSuccessWrapper(organizationService.findOrganizationPage(form, curPage, pageSize));
    }

    /**
     * @description 分页查询列表数据
     * @author zlx
     * @date 2020/10/16 14:59
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.Organization>>
     */
    @Override
    public CommonResult<List<Organization>> findOrganizationPageList(OrganizationForm.Search form, int curPage, int pageSize) {
        return CommonResult.returnSuccessWrapper(organizationService.findOrganizationPageList(form, curPage, pageSize));
    }

    /**
     * @description 查询所有数据，不分页
     * @author zlx
     * @date 2020/10/16 14:59
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.Organization>>
     */
    @Override
    public CommonResult<List<Organization>> findOrganizationList(OrganizationForm.Search form) {
        return CommonResult.returnSuccessWrapper(organizationService.findOrganizationList(form));
    }

    /**
     * @description 根据主键id或orgId 查询数据
     * @author zlx
     * @date 2020/10/16 15:03
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.shop.unifyworkbench.sdk.pojo.Organization>
     */
    @Override
    public CommonResult<Organization> findOrganization(OrganizationForm.Get form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        Organization organization = organizationService.findOrganization(form);
        organization.setDepartmentList(departmentService.findDepartmentList(new DepartmentForm.Search().setOrgId(organization.getOrgId()).setStatus(1)));
        organization.setOrganizeChangeTermList(organizeChangeTermService.findOrganizeChangeTermList(new OrganizeChangeTermForm.Search().setOrgId(organization.getOrgId()).setDel(0)));
        organization.setOrganizeHonorList(organizeHonorService.findOrganizeHonorList(new OrganizeHonorForm.Search().setOrgId(organization.getOrgId()).setDel(0)));
        organization.setStatistics(userOrgService.findStatistics(new UserOrgForm.Get().setOrgId(organization.getOrgId())));
        return CommonResult.returnSuccessWrapper(organization);
    }

    /**
     * @description 添加数据
     * @author zlx
     * @date 2020/10/16 15:03
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    @Override
    @Transactional
    public CommonResult<String> addOrganization(OrganizationForm.Add form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        String orgId = UUIDutils.get32UUID();
        if (StringUtils.isNotBlank(form.getOrgTypeCode())){
            if (ArrayUtils.contains(ZXCLASSIFY,form.getOrgTypeCode())){
                form.setOrgClassify("zx");
            }
            else if (ArrayUtils.contains(HXCLASSIFY,form.getOrgTypeCode())){
                form.setOrgClassify("hx");
            }
        }
        Long id = organizationService.addOrganization(form.setOrgId(orgId).setStatus(1));

        //【直属】部门
        DepartmentForm.Add departAdd = new DepartmentForm.Add();
        departAdd.setOrgId(orgId).setOrgName(form.getOrgName()).setDepartmentId(UUIDutils.get32UUID())
                .setDeptName("直属").setUserId(form.getUserId()).setUserName(form.getUserName())
                .setCreateTime(new Date()).setUpdateTime(new Date()).setStatus(1);
        //【执委】部门
        DepartmentForm.Add departAdd1 = new DepartmentForm.Add();
        departAdd1.setOrgId(orgId).setOrgName(form.getOrgName()).setDepartmentId(UUIDutils.get32UUID())
                .setDeptName("执委").setUserId(form.getUserId()).setUserName(form.getUserName())
                .setCreateTime(new Date()).setUpdateTime(new Date()).setStatus(1);
        //处理部门信息
        final List<DepartmentForm.Add> departmentList = form.getAddDepartmentList();
        if (departmentList != null && departmentList.size()>0){
            for (DepartmentForm.Add add : departmentList){
                add.setDepartmentId(UUIDutils.get32UUID()).setOrgId(orgId).setOrgName(form.getOrgName());
            }
            DepartmentForm.BatchAdd batchAdd = new DepartmentForm.BatchAdd();
            //添加【直属】部门、【执委】部门
            departmentList.add(departAdd);
            departmentList.add(departAdd1);
            batchAdd.setList(departmentList);

            departmentService.batchAddDepartment(batchAdd);
        }else {
            //添加【直属】部门、【执委】部门
            List<DepartmentForm.Add> adds = new ArrayList<>();
            adds.add(departAdd);
            adds.add(departAdd1);
            DepartmentForm.BatchAdd batchAdd = new DepartmentForm.BatchAdd();
            batchAdd.setList(adds);
            departmentService.batchAddDepartment(batchAdd);
        }
        //处理换届信息
        if (form.getOrganizeChangeTermList() != null && form.getOrganizeChangeTermList().size()>0){
            OrganizeChangeTermForm.BatchAdd batchAdd = new OrganizeChangeTermForm.BatchAdd();
            batchAdd.setList(form.getOrganizeChangeTermList()).setOrgId(orgId).setOrgName(form.getOrgName());
            organizeChangeTermService.batchAddOrganizeChangeTerm(batchAdd);
        }
        //处理组织荣誉信息
        if (form.getOrganizeHonorList() != null && form.getOrganizeHonorList().size()>0){
            OrganizeHonorForm.BatchAdd batchAdd = new OrganizeHonorForm.BatchAdd();
            batchAdd.setList(form.getOrganizeHonorList()).setOrgId(orgId).setOrgName(form.getOrgName());
            organizeHonorService.batchAddOrganizeHonor(batchAdd);
        }
        //添加管理员账号
        AccountArg.Add accountAdd = new AccountArg.Add();
        String account = PinyinUtils.getFirstSpell(form.getAreaName())+"0000"+id;
        accountAdd.setAccount(account);
        accountAdd.setPwd(account);
        accountAdd.setPlatform("shop");
        List<Long> roleIds = new ArrayList<>();
        roleIds.add((long) 28);
        accountAdd.setRoleIds(roleIds);
        accountAdd.setUserPlatform(orgId);
        CommonResult<Long> accountId = accountSdk.addAccount(accountAdd);
        form.setUserId(accountId.getData());
        baseUserService.addBaseUser(new BaseUserForm.Add().setUserId(accountId.getData()).setName(form.getOrgName()+"管理员").setRemark(form.getOrgName()+"管理员").setUserType(0));
        UserOrgForm.Add add = new UserOrgForm.Add();
        add.setUserId(accountId.getData()).setOrgId(orgId).setOrgName(form.getOrgName()).setDel(0).setCreateTime(new Date()).setUpdateTime(new Date());
        userOrgService.addUserOrg(add);
        return CommonResult.returnSuccessWrapper(orgId);
    }

    /**
     * @description 编辑数据
     * @author zlx
     * @date 2020/10/16 15:06
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    @Override
    @Transactional
    public CommonResult<Boolean> editOrganization(OrganizationForm.Edit form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        if (StringUtils.isNotBlank(form.getOrgTypeCode())){
            if (ArrayUtils.contains(ZXCLASSIFY,form.getOrgTypeCode())){
                form.setOrgClassify("zx");
            }
            else if (ArrayUtils.contains(HXCLASSIFY,form.getOrgTypeCode())){
                form.setOrgClassify("hx");
            }
        }
        organizationService.editOrganization(form);
        //处理部门信息--新增
        if (form.getAddDepartmentList() != null && form.getAddDepartmentList().size()>0){
            for (DepartmentForm.Add add : form.getAddDepartmentList()){
                add.setDepartmentId(UUIDutils.get32UUID()).setOrgId(form.getOrgId()).setOrgName(form.getOrgName());
            }
            DepartmentForm.BatchAdd batchAdd = new DepartmentForm.BatchAdd();
            batchAdd.setList(form.getAddDepartmentList());
            departmentService.batchAddDepartment(batchAdd);
        }
        //处理部门信息--编辑
        if (form.getEditDepartmentList() != null && form.getEditDepartmentList().size()>0){
            for (DepartmentForm.Edit edit: form.getEditDepartmentList()){
                departmentService.editDepartment(edit.setStatus(1));
            }
        }
        //处理部门信息--删除(页面删除操作前校验部门下有人则不允许删除)
        if (form.getDelDepartmentList() != null && form.getDelDepartmentList().size()>0){
            departmentService.delDepartmentByDeptId(form.getDelDepartmentList());
        }

        //处理换届信息
        if (form.getOrganizeChangeTermList() != null && form.getOrganizeChangeTermList().size()>0){
            organizeChangeTermService.delByOrgId(new OrganizeChangeTermForm.DelByOrgId().setOrgId(form.getOrgId()));
            for (OrganizeChangeTermForm.Edit edit : form.getOrganizeChangeTermList()){
                organizeChangeTermService.addOrganizeChangeTerm(new OrganizeChangeTermForm.Add()
                        .setOrgId(form.getOrgId())
                        .setOrgName(form.getOrgName())
                        .setChangeInfo(edit.getChangeInfo())
                        .setUserId(edit.getUserId())
                        .setUserName(edit.getUserName())
                        .setDel(0)
                        .setChangeTime(edit.getChangeTime())
                        .setCreateTime(edit.getCreateTime())
                        .setUpdateTime(new Date())
                );
            }
        }
        //处理组织荣誉信息
        if (form.getOrganizeHonorList() != null && form.getOrganizeHonorList().size()>0){
            organizeHonorService.delByOrgId(new OrganizeHonorForm.DelByOrgId().setOrgId(form.getOrgId()));
            for (OrganizeHonorForm.Edit edit: form.getOrganizeHonorList()){
                organizeHonorService.addOrganizeHonor(new OrganizeHonorForm.Add()
                        .setOrgId(form.getOrgId())
                        .setOrgName(form.getOrgName())
                        .setHonorName(edit.getHonorName())
                        .setUserId(edit.getUserId())
                        .setUserName(edit.getUserName())
                        .setDel(0)
                        .setHonorTime(edit.getHonorTime())
                        .setCreateTime(edit.getCreateTime())
                        .setUpdateTime(new Date())
                );
            }
        }
        return CommonResult.returnBoolWrapper(true,"编辑失败");
    }

    /**
     * @description 删除或批量删除数据
     * @author zlx
     * @date 2020/10/16 15:52
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    @Override
    @Transactional
    public CommonResult<Boolean> delOrganization(OrganizationForm.BatchDel form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        if (form.getOrgIdList() == null || form.getOrgIdList().size() == 0){
            return CommonResult.returnFailsWrapper("组织机构不能为空");
        }
        organizationService.delOrganization(form);
        departmentService.batchDel(form.getOrgIdList());
        organizeChangeTermService.batchDel(form.getOrgIdList());
        organizeHonorService.batchDel(form.getOrgIdList());
        return CommonResult.returnBoolWrapper(true,"删除失败");
    }

    /**
     * @description: 根据行政区划Id查询组织机构信息
     * @author: zhangsq
     * @date: Created in 2020-10-26 10:14
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.Organization>>
     * @exception:
     */
    @Override
    public CommonResult<List<Organization>> findByAreaCodeOrganization(OrganizationForm.Search form) {
        return CommonResult.returnSuccessWrapper(organizationService.findByAreaCodeOrganization(form));
    }

    /**
     * @description 统计横向组织和纵向组织所占百分比
     * @author zlx
     * @date 2020/11/2 16:50
     * @param
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.Map<java.lang.String,java.lang.Object>>
     */
    @Override
    public CommonResult<Map<String, Object>> findOrganizationStatistics() {
        List<OrganizationStatistics> list = organizationService.findOrganizationStatistics();
        List<OrganizationStatistics> zxList = new ArrayList<>();
        List<OrganizationStatistics> hxList = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        if (list != null && list.size()>0){
            zxList = list.stream().filter(e->"zx".equals(e.getOrgClassify())).collect(Collectors.toList());
            hxList = list.stream().filter(e->"hx".equals(e.getOrgClassify())).collect(Collectors.toList());
        }
        map.put("zx",zxList);
        map.put("hx",hxList);
        return CommonResult.returnSuccessWrapper(map);
    }

    /**
     * @description 根据区域code和组织名称查询数据
     * @author zlx
     * @date 2020/11/10 10:33
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.shop.unifyworkbench.sdk.pojo.Organization>
     */
    @Override
    public CommonResult<Organization> findOrganizationByAreaCodeAndOrgName(OrganizationForm.Search form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        if (StringUtils.isBlank(form.getAreaCode())){
            return CommonResult.returnFailsWrapper("区域code不能为空");
        }
        if (StringUtils.isBlank(form.getOrgName())){
            return CommonResult.returnFailsWrapper("组织名称不能为空");
        }
        return CommonResult.returnSuccessWrapper(organizationService.findOrganizationByAreaCodeAndOrgName(form));
    }
}
