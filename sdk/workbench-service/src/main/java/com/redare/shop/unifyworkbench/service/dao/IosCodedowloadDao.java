package com.redare.shop.unifyworkbench.service.dao;

import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.base.SpringJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.IosCodedowload;
import com.redare.shop.unifyworkbench.sdk.pojo.form.IosCodedowloadForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/7/17 11:34
 * @version: 1.1
 */
@Repository
public class IosCodedowloadDao {

    @Autowired
    SpringJdbcHelper springJdbcHelper;

    /**
     * @description 分页查询
     * @author zlx
     * @date 2020/7/17 11:38
     * @param form
     * @param curPage
     * @param pageSize
     * @param calCount
     * @param allList
     * @return com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.IosCodedowload>
     */
    public Page<IosCodedowload> findIosCodedowloadPage(IosCodedowloadForm.Search form,int curPage,int pageSize,boolean calCount,boolean allList){
        Sql sql = Sql.select()
                .from("t_ios_codedowload")
                .where()
                .andEqIfNotNull("status",form.getStatus());
        return springJdbcHelper.queryForPageBean(sql.toString(),IosCodedowload.class,sql.getParams().toArray(),curPage,pageSize,calCount,allList);
    }

    /**
     * @description 根据主键id查询数据
     * @author zlx
     * @date 2020/7/17 11:44
     * @param form
     * @return com.redare.shop.unifyworkbench.sdk.pojo.IosCodedowload
     */
    public IosCodedowload findIosCodedowload(IosCodedowloadForm.Get form){
        Sql sql = Sql.select()
                .from("t_ios_codedowload")
                .where()
                .andEq("id",form.getId());
        return springJdbcHelper.queryForBean(sql.toString(),IosCodedowload.class,sql.getParams().toArray());
    }

    /**
     * @description 根据主键id更新状态
     * @author zlx
     * @date 2020/7/17 11:46
     * @param form
     * @return int
     */
    public int editIosCodedowloadStatus(IosCodedowloadForm.Edit form){
        Sql sql = Sql.update("t_ios_codedowload")
                .setIfNotNull("status",form.getStatus())
                .where()
                .andEq("id",form.getId());
        return springJdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }
}
