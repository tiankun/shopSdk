package com.redare.shop.unifyworkbench.appapi.controller.base;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.appapi.controller.BaseApiController;
import com.redare.shop.unifyworkbench.sdk.OrganizationSdk;
import com.redare.shop.unifyworkbench.sdk.UserOrgSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.Organization;
import com.redare.shop.unifyworkbench.sdk.pojo.UserOrg;
import com.redare.shop.unifyworkbench.sdk.pojo.form.OrganizationForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserOrgForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tiankun on 2020-10-27
 */

@Controller
@RequestMapping("/base/org")
public class OrganizationController extends BaseApiController {
    @Autowired
    UserOrgSdk userOrgSdk;

    @Autowired
    OrganizationSdk organizationSdk;

    /**
     * 根据用户id查询所有机构
     * @param form
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public CommonResult<List<UserOrg>> findUserOrgByUserId(
            @RequestBody UserOrgForm.Search form,
            HttpServletRequest request
    ) {
        return userOrgSdk.findUserOrgByUserId(form);
    }

    /**
     * 查询组织人员
     * @param form
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/org/user/list", method = RequestMethod.POST)
    public CommonResult<List<UserOrg>> findUserOrgList(
            @RequestBody UserOrgForm.Get form,
            @RequestParam(value = "curPage", defaultValue = "1") int curPage,
            @RequestParam(value = "pageSize", defaultValue = "20") int pageSize,
            HttpServletRequest request
    ) {
        return CommonResult.returnSuccessWrapper(userOrgSdk.findUserOrgPageByOrgId(form,curPage,pageSize).getData().getResult());
    }


    /**
     * 根据orgId查询数据
     * @param form
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/data", method = RequestMethod.POST)
    public CommonResult<Organization> findOrganization (
            @RequestBody OrganizationForm.Get form,
            HttpServletRequest request
    ) {
        return organizationSdk.findOrganization(form);
    }


    @ResponseBody
    @RequestMapping(value = "/organization/list", method = RequestMethod.POST)
    public CommonResult<List<Organization>> findOrganizationList(
            @RequestBody OrganizationForm.Search form,
            HttpServletRequest request
    ) {
        return organizationSdk.findOrganizationList(form);
    }

    /**
     * 统计横向组织和纵向组织百分比
     * @param
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/organization/statistics", method = RequestMethod.POST)
    public CommonResult<Map<String, Object>> findOrganizationStatistics(
            HttpServletRequest request
    ) {
        return organizationSdk.findOrganizationStatistics();
    }

    /**
     * 组织数据(活动列表搜索用)
     * @param
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/build/list", method = RequestMethod.POST)
    public CommonResult<List> buildOrganizationList(
            @RequestBody OrganizationForm.Search form,
            HttpServletRequest request
    ) {
        form.setStatus(1);

        List list=new ArrayList();
        List<Organization> organizationList = organizationSdk.findOrganizationList(form).getData();
        for (int i = 0; i <organizationList.size() ; i++) {
            Map map=new HashMap();
            map.put("orgId",organizationList.get(i).getOrgId());
            map.put("id",organizationList.get(i).getId());
            map.put("orgName",organizationList.get(i).getOrgName());
            map.put("text",organizationList.get(i).getAreaName()+"|"+organizationList.get(i).getOrgName());
            list.add(map);
        }

        return CommonResult.returnSuccessWrapper(list);
    }
}
