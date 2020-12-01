package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.ContentManage;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ContentManageForm;
import com.redare.shop.unifyworkbench.service.dao.ContentManageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ContentManageService
 *
 * @Author zlx
 * @Date 2020/5/6 15:56
 */
@Service
public class ContentManageService {

    @Autowired
    ContentManageDao contentManageDao;

    /**
     * 分页查询（t_content_manage）表
     * @author zlx
     * @date 2020/5/6 16:09
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.ContentManage>
     */
    public Page<ContentManage> findContentManagePage(ContentManageForm.Search form, int curPage, int pageSize){
        return contentManageDao.findContentManagePage(form,curPage,pageSize,true,false);
    }

    /**
     * 分页查询列表数据
     * @author zlx
     * @date 2020/5/12 11:45
     * @param form
     * @param curPage
     * @param pageSize
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.ContentManage>
     */
    public List<ContentManage> findContentManageList(ContentManageForm.Search form,int curPage,int pageSize){
        return contentManageDao.findContentManagePage(form,curPage,pageSize,false,false).getResult();
    }

    /**
     * 查询列表所有数据
     * @author zlx
     * @date 2020/5/12 11:46
     * @param form
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.ContentManage>
     */
    public List<ContentManage> findContentManageList(ContentManageForm.Search form){
        return contentManageDao.findContentManagePage(form,0,0,false,true).getResult();
    }
    /**
     * 新增（t_content_manage）列表数据
     * @author zlx
     * @date 2020/5/7 10:37
     * @param form
     * @return java.lang.Boolean
     */
    public Integer addContentManage(ContentManageForm.Add form){
        return contentManageDao.addContentManage(form);
    }

    /**
     * 修改显示隐藏状态
     * @author zlx
     * @date 2020/5/7 21:48
     * @param form
     * @return java.lang.Integer
     */
    public Integer editStatus(ContentManageForm.EditStatus form){
        return contentManageDao.editStatus(form);
    }

    /**
     * 根据id删除（t_content_manage）数据
     * @author zlx
     * @date 2020/5/8 9:49
     * @param form
     * @return java.lang.Boolean
     */
    public Boolean deleteContentManage(ContentManageForm.Del form){
        return contentManageDao.deleteContentManage(form)>0;
    }

    /**
     * 根据id查询详情
     * @author zlx
     * @date 2020/5/8 11:01
     * @param form
     * @return com.redare.shop.unifyworkbench.sdk.pojo.ContentManage
     */
    public ContentManage getContentManage(ContentManageForm.Get form){
        return contentManageDao.getContentManage(form);
    }

    /**
     * 编辑数据
     * @author zlx
     * @date 2020/5/8 17:55
     * @param form
     * @return java.lang.Boolean
     */
    public Boolean editContentManage(ContentManageForm.Edit form){
        return contentManageDao.editContentManage(form)>0;
    }

    /**
     * 批量删除数据
     * @author zlx
     * @date 2020/5/9 11:13
     * @param form
     * @return java.lang.Boolean
     */
    public Boolean batchDelConten(ContentManageForm.BatchDel form){
        return contentManageDao.batchDelContent(form) >0;
    }

    /**
     * 获取表所有显示的数据
     * @author zlx
     * @date 2020/5/11 11:47
     * @param
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.ContentManage>
     */
    public List<ContentManage> getContentManageTop5(ContentManageForm.GetByClassify form){
        return contentManageDao.getContentManageTop5(form);
    }

    /**
     * 根据分类查询分页数据
     * @author zlx
     * @date 2020/5/12 11:34
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.ContentManage>
     */
    public Page<ContentManage> findContentManageByClassify(ContentManageForm.Search form,int curPage, int pageSize){
        return contentManageDao.findContentManagePage(form,curPage,pageSize,true,false);
    }

    /**
     * 浏览量自动加一
     * @author zlx
     * @date 2020/5/13 14:55
     * @param form
     * @return int
     */
    public int autoPlusOneOnBrowse(ContentManageForm.Get form){
        return contentManageDao.autoPlusOneOnBrowse(form);
    }

    /**
     * @description 根据分类集合分页查询数据
     * @author zlx
     * @date 2020/7/16 15:55
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.ContentManage>
     */
    public Page<ContentManage> findContentManagePageByClassifyList(ContentManageForm.Search form,int curPage, int pageSize){
        return contentManageDao.findContentManagePageByClassifyList(form,curPage,pageSize,true,false);
    }
}