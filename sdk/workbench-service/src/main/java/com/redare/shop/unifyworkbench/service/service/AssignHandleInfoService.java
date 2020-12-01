package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.Assign;
import com.redare.shop.unifyworkbench.sdk.pojo.AssignHandleInfo;
import com.redare.shop.unifyworkbench.sdk.pojo.form.AssignHandleInfoForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.service.dao.AssignDao;
import com.redare.shop.unifyworkbench.service.dao.AssignHandleInfoDao;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 交办办理情况表(AssignHandleInfo)表服务接口
 *
 * @author makejava
 * @since 2020-10-21 14:11:40
 */
@Service
public class AssignHandleInfoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AssignHandleInfoService.class);
    @Autowired
    AssignHandleInfoDao assignHandleInfoDao;
    @Autowired
    AssignDao assignDao;

    public long insertAssignHandleInfo(AssignHandleInfo form) {
        return assignHandleInfoDao.insertAssignHandleInfo(form);
    }

    public int updateAssignHandleInfo(AssignHandleInfo form) {
        return assignHandleInfoDao.updateAssignHandleInfo(form);
    }

    public Page<AssignHandleInfo> queryForPageAssignHandleInfo(AssignHandleInfoForm.Search form, int curPage, int pageSize) {
        return assignHandleInfoDao.queryForPageAssignHandleInfo(form, curPage, pageSize, true, false);
    }

    public List<AssignHandleInfo> queryForListAssignHandleInfo(AssignHandleInfoForm.Search form) {
        return assignHandleInfoDao.queryForListAssignHandleInfo(form);
    }

    public AssignHandleInfo queryForAssignHandleInfo(AssignHandleInfoForm.Search form) {
        final List<AssignHandleInfo> list = assignHandleInfoDao.queryForListAssignHandleInfo(form);
        if (list != null && list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public int deleteAssignHandleInfo(CommonForm.Del form) {
        return assignHandleInfoDao.deleteAssignHandleInfo(form);
    }

    public Boolean batchDelAssignHandleInfo(CommonForm.BatchDel form) {
        return assignHandleInfoDao.batchDelAssignHandleInfo(form) > 0;
    }

    public AssignHandleInfo queryAssignHandleInfo(AssignHandleInfo form){
       return  assignHandleInfoDao.queryAssignHandleInfo(form);
    }

    public Boolean handleAssign(AssignHandleInfo form){
        Boolean result = false;
        //1.新增处理记录
        form.setAssignstatus(2);
        result = assignHandleInfoDao.updateAssignHandleInfo(form)>0;
        //办理交办任务时，设置status为1
        CommonForm.Del assignForm = new CommonForm.Del();
        assignForm.setId(form.getAssignId());
        Assign assign = assignDao.queryAssign(assignForm);
        AssignHandleInfo handleForm = new AssignHandleInfo();
        handleForm.setAssignid(assign.getId());
        handleForm.setHandleorgid(assign.getAssignOrgId());
        AssignHandleInfo rootHandleInfo = assignHandleInfoDao.queryAssignHandleInfo(handleForm);
        rootHandleInfo.setStatus(1);
        result = assignHandleInfoDao.updateAssignHandleInfo(rootHandleInfo)>0;

        //根据当前处理记录的交办组织查询
        AssignHandleInfo assignHandleInfo = assignHandleInfoDao.queryAssignHandleInfo(form);

        AssignHandleInfoForm.Search search = new AssignHandleInfoForm.Search();
        search.setAssignId(assignHandleInfo.getAssignId());
        search.setAssignOrgId(assignHandleInfo.getAssignOrgId());
        List<Integer> assignStatusList = new ArrayList<>();
        assignStatusList.add(0);
        assignStatusList.add(1);
        search.setAssignStatusList(assignStatusList);
        List<AssignHandleInfo> assignHandleInfoList = assignHandleInfoDao.queryForListAssignHandleInfo(search);
        if(CollectionUtils.isEmpty(assignHandleInfoList)){
            AssignHandleInfo getForm = new AssignHandleInfo();
            getForm.setAssignid(assignHandleInfo.getAssignId());
            getForm.setHandleorgid(assignHandleInfo.getAssignOrgId());
            //上级交办处理记录
            AssignHandleInfo parentHandleInfo = assignHandleInfoDao.queryAssignHandleInfo(getForm);
            parentHandleInfo.setAssignstatus(0);
            parentHandleInfo.setStatus(2);
            result = assignHandleInfoDao.updateAssignHandleInfo(parentHandleInfo)>0;
        }
        return result;
    }

    public Boolean finishAssign(AssignHandleInfo form){
        Boolean result = false;
        //修改处理结果
        form.setAssignstatus(2);
        result = assignHandleInfoDao.updateAssignHandleInfo(form)>0;
        //修改交办信息
        Assign assign = new Assign();
        assign.setId(form.getAssignId());
        assign.setAssignstatus(2);
        assign.setFinishTime(new Date());
        result = assignDao.updateAssign(assign)>0;
        return result;
    }

}