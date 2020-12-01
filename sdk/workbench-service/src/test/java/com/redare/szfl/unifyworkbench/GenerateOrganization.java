package com.redare.shop.unifyworkbench;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.webplatform.sdk.core.AccountSdk;
import com.redare.devframework.webplatform.sdk.core.arg.AccountArg;
import com.redare.shop.unifyworkbench.sdk.common.pojo.BaseLevelTreeQuery;
import com.redare.shop.unifyworkbench.sdk.pojo.Organization;
import com.redare.shop.unifyworkbench.sdk.pojo.form.BaseUserForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.DepartmentForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.OrganizationForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserOrgForm;
import com.redare.shop.unifyworkbench.service.service.BaseUserService;
import com.redare.shop.unifyworkbench.service.service.DepartmentService;
import com.redare.shop.unifyworkbench.service.service.OrganizationService;
import com.redare.shop.unifyworkbench.service.service.UserOrgService;
import com.redare.shop.unifyworkbench.service.util.PinyinUtils;
import com.redare.shop.unifyworkbench.service.util.UUIDutils;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/11/25 16:38
 * @version:
 */
public class GenerateOrganization extends AbstractJUnitConfig{

    @Autowired
    OrganizationService organizationService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    AccountSdk accountSdk;

    @Autowired
    BaseUserService baseUserService;

    @Autowired
    UserOrgService userOrgService;

    @Test
    public void testGenerateOrganization(){
        OrganizationForm.Search form = new OrganizationForm.Search();
        String rootId = "530000";
        String levelId = "530100";
        BaseLevelTreeQuery baseLevelTreeQuery = new BaseLevelTreeQuery();
        baseLevelTreeQuery.setRootId(rootId).setUp(false).setIncSelf(true).setLevelNum(4).setLevelNumOnly(false)
                .setSortToTree(false).setLevelId(levelId);
        form.setBaseLevelTreeQuery(baseLevelTreeQuery);
        List<Organization> list = organizationService.generateOrganization(form);
        getData(list);
    }

    @Transactional
    public void getData(List<Organization> list){
        for (Organization organization : list){
            List<Organization> organizationList = organizationService.findByAreaCodeAndOrgClassify(new OrganizationForm.Search().setAreaCode(organization.getAreaCode()).setOrgClassify("zx"));
            if (organizationList == null || organizationList.isEmpty()){
                String orgId = UUIDutils.get32UUID();
                organization.setOrgId(orgId);
                OrganizationForm.Add addOrg = new OrganizationForm.Add();
                BeanUtils.copyProperties(organization,addOrg);
                Long id = organizationService.addOrganization(addOrg);

                //【直属】部门
                DepartmentForm.Add departAdd = new DepartmentForm.Add();
                departAdd.setOrgId(orgId).setOrgName(organization.getOrgName()).setDepartmentId(UUIDutils.get32UUID())
                        .setDeptName("直属").setUserId(organization.getUserId()).setUserName(organization.getUserName())
                        .setCreateTime(new Date()).setUpdateTime(new Date()).setStatus(1);
                //【执委】部门
                DepartmentForm.Add departAdd1 = new DepartmentForm.Add();
                departAdd1.setOrgId(orgId).setOrgName(organization.getOrgName()).setDepartmentId(UUIDutils.get32UUID())
                        .setDeptName("执委").setUserId(organization.getUserId()).setUserName(organization.getUserName())
                        .setCreateTime(new Date()).setUpdateTime(new Date()).setStatus(1);
                //添加【直属】部门、【执委】部门
                List<DepartmentForm.Add> adds = new ArrayList<>();
                adds.add(departAdd);
                adds.add(departAdd1);
                DepartmentForm.BatchAdd batchAdd = new DepartmentForm.BatchAdd();
                batchAdd.setList(adds);
                departmentService.batchAddDepartment(batchAdd);

                //添加管理员账号
                AccountArg.Add accountAdd = new AccountArg.Add();
                String account = PinyinUtils.getFirstSpell(organization.getAreaName())+"0000"+id;
                accountAdd.setAccount(account);
                accountAdd.setPwd(account);
                accountAdd.setPlatform("shop");
                List<Long> roleIds = new ArrayList<>();
                roleIds.add((long) 28);
                accountAdd.setRoleIds(roleIds);
                accountAdd.setUserPlatform(orgId);
//            CommonResult<Long> accountId = new CommonResult<>();
                CommonResult<Long> accountId = accountSdk.addAccount(accountAdd);
//            BaseUserForm.Add baseadd = new BaseUserForm.Add().setUserId(accountId.getData()).setName(organization.getOrgName()+"管理员").setRemark(organization.getOrgName()+"管理员").setUserType(0);
                baseUserService.addBaseUser(new BaseUserForm.Add().setUserId(accountId.getData()).setName(organization.getOrgName()+"管理员").setRemark(organization.getOrgName()+"管理员").setUserType(0));
                UserOrgForm.Add add = new UserOrgForm.Add();
                add.setUserId(accountId.getData()).setOrgId(orgId).setOrgName(organization.getOrgName()).setDel(0).setCreateTime(new Date()).setUpdateTime(new Date());
                userOrgService.addUserOrg(add);
            }
        }
    }
}
