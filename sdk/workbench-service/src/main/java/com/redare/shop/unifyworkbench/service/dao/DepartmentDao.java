package com.redare.shop.unifyworkbench.service.dao;

import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.base.SpringJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.Department;
import com.redare.shop.unifyworkbench.sdk.pojo.form.DepartmentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/10/16 17:53
 * @version:
 */
@Repository
public class DepartmentDao {

    @Autowired
    SpringJdbcHelper springJdbcHelper;

    /**
     * @description 分页查询
     * @author zlx
     * @date 2020/10/16 17:57
     * @param form
     * @param curPage
     * @param pageSize
     * @param calCount
     * @param allList
     * @return com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.Department>
     */
    public Page<Department> findDepartmentPage(DepartmentForm.Search form,int curPage,int pageSize,boolean calCount,boolean allList){
        Sql sql = Sql.select()
                .from("t_department")
                .where()
                .andBlikeJoinByOrIfNotBlank(form.getKey(),"deptName")
                .andEqIfNotBlank("orgId",form.getOrgId())
                .andEqIfNotNull("status",form.getStatus())
                .orderBy().desc("id");
        return springJdbcHelper.queryForPageBean(sql.getSql().toString(),Department.class,sql.getParams().toArray(),curPage,pageSize,calCount,allList);
    }

    /**
     * @description 根据主键id或部门id查询数据
     * @author zlx
     * @date 2020/10/16 18:00
     * @param form
     * @return com.redare.shop.unifyworkbench.sdk.pojo.Department
     */
    public Department findDepartment(DepartmentForm.Get form){
        Sql sql = Sql.select()
                .from("t_department")
                .where()
                .andEqIfNotNull("id",form.getId())
                .andEqIfNotBlank("departmentId",form.getDepartmentId());
        return springJdbcHelper.queryForBean(sql.getSql().toString(),Department.class,sql.getParams().toArray());
    }

    /**
     * @description 添加数据
     * @author zlx
     * @date 2020/10/16 18:05
     * @param form
     * @return java.lang.Long
     */
    public Long addDepartment(DepartmentForm.Add form){
        Sql sql = Sql.insert("t_department")
                .field("orgId",form.getOrgId())
                .field("orgName",form.getOrgName())
                .field("departmentId",form.getDepartmentId())
                .field("parentId",form.getParentId())
                .field("deptName",form.getDeptName())
                .field("userId",form.getUserId())
                .field("userName",form.getUserName())
                .field("departManageUserIdList",form.getDepartManageUserIdList())
                .field("departIdTag",form.getDepartIdTag())
                .field("departIdLevel",form.getDepartIdLevel())
                .field("departNameLevel",form.getDepartNameLevel())
                .field("createTime",form.getCreateTime())
                .field("updateTime",form.getUpdateTime())
                .field("status",form.getStatus());
        return springJdbcHelper.insertReturnFieldNumber(sql.getSql().toString(),sql.getParams().toArray()).longValue();
    }

    /**
     * @description 编辑数据
     * @author zlx
     * @date 2020/10/16 18:12
     * @param form
     * @return int
     */
    public int editDepartment(DepartmentForm.Edit form){
        Sql sql = Sql.update("t_department")
                .setIfNotBlank("orgId",form.getOrgId())
                .setIfNotBlank("orgName",form.getOrgName())
                .setIfNotBlank("departmentId",form.getDepartmentId())
                .setIfNotBlank("parentId",form.getParentId())
                .setIfNotBlank("deptName",form.getDeptName())
                .setIfNotNull("userId",form.getUserId())
                .setIfNotBlank("userName",form.getUserName())
                .setIfNotBlank("departManageUserIdList",form.getDepartManageUserIdList())
                .setIfNotBlank("departIdTag",form.getDepartIdTag())
                .setIfNotBlank("departIdLevel",form.getDepartIdLevel())
                .setIfNotBlank("departNameLevel",form.getDepartNameLevel())
                .set("updateTime",new Date())
                .setIfNotNull("status",form.getStatus())
                .where()
                .andEq("id",form.getId());
        return springJdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    /**
     * @description 删除数据
     * @author zlx
     * @date 2020/10/16 18:14
     * @param form
     * @return int
     */
    public int delDepartment(DepartmentForm.Del form){
        Sql sql = Sql.delete("t_department")
                .where()
                .andEq("id",form.getId());
        return springJdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    public int[] batchAddDepartment(DepartmentForm.BatchAdd form){
        Sql sql = Sql.insert("t_department")
                .field("orgId")
                .field("orgName")
                .field("departmentId")
                .field("parentId")
                .field("deptName")
                .field("userId")
                .field("userName")
                .field("departManageUserIdList")
                .field("departIdTag")
                .field("departIdLevel")
                .field("departNameLevel")
                .field("createTime")
                .field("updateTime")
                .field("status");
        List<Object[]> params = new ArrayList<>();
        for (DepartmentForm.Add add : form.getList()){
            params.add(
                    new Object[]{
                           add.getOrgId(),
                            add.getOrgName(),
                            add.getDepartmentId(),
                            add.getParentId(),
                            add.getDeptName(),
                            add.getUserId(),
                            add.getUserName(),
                            add.getDepartManageUserIdList(),
                            add.getDepartIdTag(),
                            add.getDepartIdLevel(),
                            add.getDepartNameLevel(),
                            add.getCreateTime(),
                            new Date(),
                            1
                    }
            );
        }
        return springJdbcHelper.batchUpdate(sql.toString(), params);
    }

    /**
     * @description 根据组织机构id删除数据
     * @author zlx
     * @date 2020/10/20 11:34
     * @param form
     * @return int
     */
    public int delByOrgId(DepartmentForm.DelByOrgId form){
        Sql sql = Sql.delete("t_department")
                .where()
                .andEq("orgId",form.getOrgId());
        return springJdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    public int batchDel(List<String> orgIdList){
        Sql sql = Sql.update("t_department")
                .set("status",-1)
                .where()
                .andIn("orgId",orgIdList);
        return springJdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    /**
     * @description 根据部门id删除更新状态
     * @author zlx
     * @date 2020/11/23 15:46
     * @param deptIds
     * @return int
     */
    public int delDepartmentByDeptId(List<String> deptIds){
        Sql sql = Sql.update("t_department")
                .set("status",-1)
                .where()
                .andIn("departmentId",deptIds);
        return springJdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }
}
