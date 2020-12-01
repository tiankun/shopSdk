package com.redare.shop.unifyworkbench.service.dao;

import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.base.SpringJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.ClassifyManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassifyManageDao
 *
 * @Author zlx
 * @Date 2020/5/9 11:59
 */
@Repository
public class ClassifyManageDao {

    @Autowired
    SpringJdbcHelper springJdbcHelper;

    /**
     * 查询所有的分类数据
     * @author zlx
     * @date 2020/5/9 12:02
     * @param
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.ClassifyManage>
     */
    public List<ClassifyManage> findClassifyList(){
        Sql sql = Sql.select()
                .from("t_classify_manage")
                .where()
                .andEq("del",0)
                .orderBy().asc("sort");
        return springJdbcHelper.queryForListBean(sql,ClassifyManage.class);
    }
}
