package com.redare.shop.unifyworkbench.service.dao;

import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.base.SpringJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.Importemplate;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ImportemplateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Excel导入模板表：ImportemplateDao
 *
 * @author yj
 * @email yangj@redare.cn
 * @date 2020-03-17
 */
@Repository
public class ImportemplateDao {
    @Autowired
    SpringJdbcHelper jdbcHelper;

    /**
     * 查询(t_import_template：Excel导入模板表)列表
     * @param form
     * @param curPage
     * @param pageSize
     * @return
     */
    public Page<Importemplate> findImportemplatePage(ImportemplateForm.Search form, int curPage, int pageSize, boolean calCount, boolean allList) {
        Sql sql = Sql.select()
                .from("t_import_template")
                .where()
                .andBlikeJoinByOrIfNotBlank(form.getKey(),"name")
                .andEq("status",0)
                .andEqIfNotBlank("type",form.getType())
                .orderBy().desc("type","updateTime");
       return jdbcHelper.queryForPageBean(sql.getSql().toString(), Importemplate.class, sql.getParams().toArray(), curPage, pageSize, calCount, allList);
    }

    /**
    * 根据id查询(t_import_template：Excel导入模板表)详情
    * @param form
    */
    public Importemplate getImportemplate(ImportemplateForm.Get form){
        Sql sql = Sql.select()
                .from("t_import_template")
                .where()
                .andEq("id",form.getId());
        return jdbcHelper.queryForBean(sql,Importemplate.class);
    }

    /**
    * 新增(t_import_template：Excel导入模板表)信息
    * @param form
    * @return
    */
    public boolean addImportemplate(ImportemplateForm.Add form){
        Sql sql= Sql.insert("t_import_template")
            .field("name",form.getName())
            .field("type",form.getType())
            .field("fileName",form.getFileName())
            .field("fileUrl",form.getFileUrl())
            .field("createTime",new Date())
            .field("updateTime",new Date())
            .field("createUserId",form.getCreateUserId())
            .field("createUserName",form.getCreateUserName());
       return jdbcHelper.insertReturnFieldNumber(sql).intValue() >0;
    }

    /**
    * 修改(t_import_template：Excel导入模板表)信息
    * @param form
    * @return
    */
    public boolean editImportemplate(ImportemplateForm.Edit form){
        Sql sql = Sql.update("t_import_template")
            .setIfNotNull("id",form.getId())
            .setIfNotBlank("name",form.getName())
            .setIfNotBlank("type",form.getType())
            .setIfNotBlank("fileName",form.getFileName())
            .setIfNotBlank("fileUrl",form.getFileUrl())
            .setIfNotNull("status",form.getStatus())
            .set("updateTime",new Date())
            .where()
            .andEq("id", form.getId());
        return jdbcHelper.update(sql.toString(), sql.getParams().toArray())>0;
    }

    /**
    * 根据id删除(t_import_template：Excel导入模板表)信息
    * @param form
    * @return
    */
    public boolean deleteImportemplate(ImportemplateForm.Del form){
        Sql sql = Sql.delete("t_import_template")
                .where().andEq("id", form.getId());
        return jdbcHelper.update(sql.toString(), sql.getParams().toArray())>0;
    }

    /**
     * @description 根据类型查询模板
     * @author zlx
     * @date 2020/11/21 10:57
     * @param type
     * @return com.redare.shop.unifyworkbench.sdk.pojo.Importemplate
     */
    public Importemplate findImportemplateByType(String type){
        Sql sql = Sql.select()
                .from("t_import_template")
                .where()
                .andEq("type",type)
                .andEq("status",0);
        return jdbcHelper.queryForBean(sql.getSql().toString(),Importemplate.class,sql.getParams().toArray());
    }

}
