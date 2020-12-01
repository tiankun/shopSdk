package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.common.pojo.BaseLevelTreeQuery;
import com.redare.shop.unifyworkbench.sdk.pojo.Area;
import com.redare.shop.unifyworkbench.sdk.pojo.form.AreaForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.TreeNode;
import com.redare.shop.unifyworkbench.service.dao.AreaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 行政区域编码表(Area)表服务接口
 *
 * @author yanggr
 * @since 2020-10-21 15:05:55
 */
@Service
public class AreaService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AreaService.class);
    @Autowired
    AreaDao areaDao;

    public long insertArea(Area form) {
        return areaDao.insertArea(form);
    }

    public int updateArea(Area form) {
        return areaDao.updateArea(form);
    }

    public Page<Area> queryForPageArea(AreaForm.Search form, int curPage, int pageSize) {
        return areaDao.queryForPageArea(form, curPage, pageSize, true, false);
    }

    public List<Area> queryForListArea(AreaForm.Search form) {
        return areaDao.queryForListArea(form);
    }

    public Area queryForArea(AreaForm.Search form) {
        final List<Area> list = areaDao.queryForListArea(form);
        if (list != null && list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public int deleteArea(CommonForm.Del form) {
        return areaDao.deleteArea(form);
    }

    public Boolean batchDelArea(CommonForm.BatchDel form) {
        return areaDao.batchDelArea(form) > 0;
    }

    public List<TreeNode> queryAreaTreeNode(BaseLevelTreeQuery form) {
        return areaDao.queryAreaTreeNode(form);
    }

    public Area queryArea(AreaForm.Get form){
        return areaDao.queryArea(form);
    }

    public List<Area> queryAreaOrgList(AreaForm.Search form){
        return areaDao.queryAreaOrgList(form);
    }

    public List<Area> findNextAreaByParentCode(String areaCode){
        return areaDao.findNextAreaByParentCode(areaCode);
    }
}