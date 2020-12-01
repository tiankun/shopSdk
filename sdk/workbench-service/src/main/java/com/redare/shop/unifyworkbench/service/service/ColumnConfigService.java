package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.ColumnConfig;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ColumnConfigForm;
import com.redare.shop.unifyworkbench.service.dao.ColumnConfigDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ColumnConfigService
 */
@Service
public class ColumnConfigService {

    @Autowired
    ColumnConfigDao columnConfigDao;

    /**
     * 分页查询列表
     * @param form
     * @param curPage
     * @param pageSize
     * @return
     */
    public Page<ColumnConfig> findColumnConfigPage(ColumnConfigForm.Search form, int curPage, int pageSize){
        return columnConfigDao.findColumnConfigPage(form,curPage,pageSize,true,false);
    }

    /**
     * 分页查询列表数据
     * @param form
     * @param curPage
     * @param pageSize
     * @return
     */
    public List<ColumnConfig> findColumnConfigList(ColumnConfigForm.Search form,int curPage,int pageSize){
        return columnConfigDao.findColumnConfigPage(form,curPage,pageSize,false,false).getResult();
    }

    /**
     * 查询所有数据
     * @param form
     * @return
     */
    public List<ColumnConfig> findColumnConfigList(ColumnConfigForm.Search form){
        return columnConfigDao.findColumnConfigPage(form,0,0,false,true).getResult();
    }

    /**
     * 根据主键id查询数据
     * @param form
     * @return
     */
    public ColumnConfig findColumnConfigById(ColumnConfigForm.Get form){
        return columnConfigDao.findColumnConfigById(form);
    }

    /**
     * 添加数据
     * @param form
     * @return
     */
    public Boolean addColumnConfig(ColumnConfigForm.Add form){
        return columnConfigDao.addColumnConfig(form)>0;
    }

    /**
     * 修改数据
     * @param form
     * @return
     */
    public Boolean editColumnConfig(ColumnConfigForm.Edit form){
        return columnConfigDao.editColumnConfig(form)>0;
    }

    /**
     * 删除数据
     * @param form
     * @return
     */
    public Boolean delColumnConfig(ColumnConfigForm.Del form){
        return columnConfigDao.delColumnConfig(form)>0;
    }
}
