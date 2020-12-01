package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.IosCodedowload;
import com.redare.shop.unifyworkbench.sdk.pojo.form.IosCodedowloadForm;
import com.redare.shop.unifyworkbench.service.dao.IosCodedowloadDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/7/17 11:38
 * @version: 1.1
 */
@Service
public class IosCodedowloadService {

    @Autowired
    IosCodedowloadDao iosCodedowloadDao;

    /**
     * @description 分页查询
     * @author zlx
     * @date 2020/7/17 11:40
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.IosCodedowload>
     */
    public Page<IosCodedowload> findIosCodedowloadPage(IosCodedowloadForm.Search form, int curPage, int pageSize){
        return iosCodedowloadDao.findIosCodedowloadPage(form,curPage,pageSize,true,false);
    }

    /**
     * @description 分页查询列表
     * @author zlx
     * @date 2020/7/17 11:41
     * @param form
     * @param curPage
     * @param pageSize
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.IosCodedowload>
     */
    public List<IosCodedowload> findIosCodedowloadList(IosCodedowloadForm.Search form,int curPage,int pageSize){
        return iosCodedowloadDao.findIosCodedowloadPage(form,curPage,pageSize,false,false).getResult();
    }

    /**
     * @description 查询所有数据
     * @author zlx
     * @date 2020/7/17 11:42
     * @param form
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.IosCodedowload>
     */
    public List<IosCodedowload> findIosCodedowloadList(IosCodedowloadForm.Search form){
        return iosCodedowloadDao.findIosCodedowloadPage(form,0,0,false,true).getResult();
    }

    /**
     * @description 根据主键id查询数据
     * @author zlx
     * @date 2020/7/17 11:47
     * @param form
     * @return com.redare.shop.unifyworkbench.sdk.pojo.IosCodedowload
     */
    public IosCodedowload findIosCodedowload(IosCodedowloadForm.Get form){
        return iosCodedowloadDao.findIosCodedowload(form);
    }

    /**
     * @description 根据主键id更新状态
     * @author zlx
     * @date 2020/7/17 11:48
     * @param form
     * @return boolean
     */
    public boolean editIosCodedowloadStatus(IosCodedowloadForm.Edit form){
        return iosCodedowloadDao.editIosCodedowloadStatus(form)>0;
    }
}
