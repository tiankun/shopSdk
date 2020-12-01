package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.Department;
import com.redare.shop.unifyworkbench.sdk.pojo.form.DepartmentForm;

import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/10/16 17:43
 * @version:
 */
public interface DepartmentSdk {
    /**
     * @description 分页查询
     * @author zlx
     * @date 2020/10/16 17:45
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.Department>>
     */
    CommonResult<Page<Department>> findDepartmentPage(DepartmentForm.Search form,int curPage,int pageSize);
    /**
     * @description 分页查询列表数据
     * @author zlx
     * @date 2020/10/16 17:46
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.Department>>
     */
    CommonResult<List<Department>> findDepartmentPageList(DepartmentForm.Search form, int curPage, int pageSize);
    /**
     * @description 查询所有数据
     * @author zlx
     * @date 2020/10/16 17:46
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.Department>>
     */
    CommonResult<List<Department>> findDepartmentList(DepartmentForm.Search form);
    /**
     * @description 根据主键id或部门id查询数据
     * @author zlx
     * @date 2020/10/16 17:49
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.shop.unifyworkbench.sdk.pojo.Department>
     */
    CommonResult<Department> findDepartment(DepartmentForm.Get form);
    /**
     * @description 添加数据
     * @author zlx
     * @date 2020/10/16 17:51
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    CommonResult<Boolean> addDepartment(DepartmentForm.Add form);
    /**
     * @description 编辑数据
     * @author zlx
     * @date 2020/10/16 17:51
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    CommonResult<Boolean> editDepartment(DepartmentForm.Edit form);
    /**
     * @description 删除数据
     * @author zlx
     * @date 2020/10/16 17:52
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    CommonResult<Boolean> delDepartment(DepartmentForm.Del form);
}
