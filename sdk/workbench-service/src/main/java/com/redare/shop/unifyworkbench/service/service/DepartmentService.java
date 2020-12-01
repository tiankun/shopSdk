package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.Department;
import com.redare.shop.unifyworkbench.sdk.pojo.form.DepartmentForm;
import com.redare.shop.unifyworkbench.service.dao.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/10/16 18:15
 * @version:
 */
@Service
public class DepartmentService {

    @Autowired
    DepartmentDao departmentDao;

    public Page<Department> findDepartmentPage(DepartmentForm.Search form,int curPage,int pageSize){
        return departmentDao.findDepartmentPage(form,curPage,pageSize,true,false);
    }

    public List<Department> findDepartmentPageList(DepartmentForm.Search form, int curPage, int pageSize){
        return departmentDao.findDepartmentPage(form,curPage,pageSize,false,false).getResult();
    }

    public List<Department> findDepartmentList(DepartmentForm.Search form){
        return departmentDao.findDepartmentPage(form,0,0,false,true).getResult();
    }

    public Department findDepartment(DepartmentForm.Get form){
        return departmentDao.findDepartment(form);
    }

    public boolean addDepartment(DepartmentForm.Add form){
        return departmentDao.addDepartment(form)>0;
    }

    public boolean editDepartment(DepartmentForm.Edit form){
        return departmentDao.editDepartment(form)>0;
    }

    public boolean delDepartment(DepartmentForm.Del form){
        return departmentDao.delDepartment(form)>0;
    }

    public boolean batchAddDepartment(DepartmentForm.BatchAdd form){
        return departmentDao.batchAddDepartment(form).length>0;
    }

    public int delByOrgId(DepartmentForm.DelByOrgId form){
        return departmentDao.delByOrgId(form);
    }

    public int batchDel(List<String> orgIdList){
        return departmentDao.batchDel(orgIdList);
    }

    /**
     * @description 根据部门id删除更新状态
     * @author zlx
     * @date 2020/11/23 15:46
     * @param deptIds
     * @return int
     */
    public int delDepartmentByDeptId(List<String> deptIds){
        return departmentDao.delDepartmentByDeptId(deptIds);
    }
}
