package com.redare.shop.unifyworkbench.service.service;

import com.redare.shop.unifyworkbench.sdk.pojo.ClassifyManage;
import com.redare.shop.unifyworkbench.service.dao.ClassifyManageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassifyManageService
 *
 * @Author zlx
 * @Date 2020/5/9 12:03
 */
@Service
public class ClassifyManageService {

    @Autowired
    ClassifyManageDao classifyManageDao;

    /**
     * 查询所有的分类数据
     * @author zlx
     * @date 2020/5/9 12:04
     * @param
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.ClassifyManage>
     */
    public List<ClassifyManage> findClassifyList(){
        return classifyManageDao.findClassifyList();
    }
}
