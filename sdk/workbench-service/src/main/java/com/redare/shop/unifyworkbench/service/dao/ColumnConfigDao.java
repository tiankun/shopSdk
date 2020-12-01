package com.redare.shop.unifyworkbench.service.dao;

import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.base.SpringJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.ColumnConfig;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ColumnConfigForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * ColumnConfigDao
 */
@Repository
public class ColumnConfigDao {

    @Autowired
    SpringJdbcHelper springJdbcHelper;

    /**
     * 分页查询列表
     * @param form
     * @param curPage
     * @param pageSize
     * @param calCount
     * @param allList
     * @return
     */
    public Page<ColumnConfig> findColumnConfigPage(ColumnConfigForm.Search form,int curPage,int pageSize,boolean calCount,boolean allList){
        Sql sql = Sql.select()
                .from("t_column_config")
                .where()
                .andBlikeJoinByOrIfNotBlank(form.getKey(),"title","configPlate")
                .orderBy().asc("sort").desc("createTime");
        return springJdbcHelper.queryForPageBean(sql.getSql().toString(),ColumnConfig.class,sql.getParams().toArray(),curPage,pageSize,calCount,allList);
    }

    /**
     * 根据主键id查询数据
     * @param form
     * @return
     */
    public ColumnConfig findColumnConfigById(ColumnConfigForm.Get form){
        Sql sql = Sql.select()
                .from("t_column_config")
                .where()
                .andEq("id",form.getId());
        return springJdbcHelper.queryForBean(sql,ColumnConfig.class);
    }

    /**
     * 添加数据
     * @param form
     * @return
     */
    public int addColumnConfig(ColumnConfigForm.Add form){
        Sql sql = Sql.insert("t_column_config")
                .field("title",form.getTitle())
                .field("configPlate",form.getConfigPlate())
                .field("url",form.getUrl())
                .field("cover",form.getCover())
                .field("createTime",new Date())
                .field("sort",form.getSort());
        return springJdbcHelper.insertReturnFieldNumber(sql).intValue();
    }

    /**
     * 修改数据
     * @param form
     * @return
     */
    public int editColumnConfig(ColumnConfigForm.Edit form){
        Sql sql = Sql.update("t_column_config")
                .setIfNotBlank("title",form.getTitle())
                .setIfNotBlank("configPlate",form.getConfigPlate())
                .setIfNotBlank("url",form.getUrl())
                .setIfNotBlank("cover",form.getCover())
                .setIfNotNull("sort",form.getSort())
                .where()
                .andEq("id",form.getId());
        return springJdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    /**
     * 删除数据
     * @param form
     * @return
     */
    public int delColumnConfig(ColumnConfigForm.Del form){
        Sql sql = Sql.delete("t_column_config")
                .where()
                .andEq("id",form.getId());
        return springJdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }
}
