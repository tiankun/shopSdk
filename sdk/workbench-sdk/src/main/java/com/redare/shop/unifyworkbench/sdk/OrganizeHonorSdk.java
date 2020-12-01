package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.OrganizeHonor;
import com.redare.shop.unifyworkbench.sdk.pojo.form.OrganizeHonorForm;

import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/10/19 15:14
 * @version:
 */
public interface OrganizeHonorSdk {

    CommonResult<Page<OrganizeHonor>> findOrganizeHonorPage(OrganizeHonorForm.Search form,int curPage,int pageSize);

    CommonResult<List<OrganizeHonor>> findOrganizeHonorPageList(OrganizeHonorForm.Search form, int curPage, int pageSize);

    CommonResult<List<OrganizeHonor>> findOrganizeHonorList(OrganizeHonorForm.Search form);

    CommonResult<OrganizeHonor> findOrganizeHonor(OrganizeHonorForm.Get form);

    CommonResult<Boolean> addOrganizeHonor(OrganizeHonorForm.Add form);

    CommonResult<Boolean> editOrganizeHonor(OrganizeHonorForm.Edit form);

    CommonResult<Boolean> delOrganizeHonor(OrganizeHonorForm.Del form);
}
