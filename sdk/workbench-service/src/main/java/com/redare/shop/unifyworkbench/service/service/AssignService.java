package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.*;
import com.redare.shop.unifyworkbench.sdk.pojo.form.*;
import com.redare.shop.unifyworkbench.service.dao.AssignDao;
import com.redare.shop.unifyworkbench.service.dao.AssignHandleInfoDao;
import com.redare.shop.unifyworkbench.service.dao.UserMessageDao;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 交办表(Assign)表服务接口
 *
 * @author makejava
 * @since 2020-10-22 14:32:13
 */
@Service
public class AssignService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AssignService.class);
    @Autowired
    AssignDao assignDao;
    @Autowired
    AssignHandleInfoDao assignHandleInfoDao;
    @Autowired
    OrganizationService organizationService;
    @Autowired
    BaseUserService baseUserService;
    @Autowired
    UserMessageDao userMessageDao;

    public long insertAssign(Assign form) {
        return assignDao.insertAssign(form);
    }

    public int updateAssign(Assign form) {
        return assignDao.updateAssign(form);
    }

    public Page<Assign> queryForPageAssign(AssignForm.Search form, int curPage, int pageSize) {
        return assignDao.queryForPageAssign(form, curPage, pageSize, true, false);
    }

    public Page<Assign> queryAssignPage(AssignForm.Search form,int curPage,int pageSize){
        return assignDao.queryAssignPage(form,curPage,pageSize,true,false);
    }

    public List<Assign> queryForListAssign(AssignForm.Search form) {
        return assignDao.queryForListAssign(form);
    }

    public Assign queryForAssign(AssignForm.Search form) {
        final List<Assign> list = assignDao.queryForListAssign(form);
        if (list != null && list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public int deleteAssign(CommonForm.Del form) {
        return assignDao.deleteAssign(form);
    }

    public int deleteAssignByPid(Assign form){
        return assignDao.deleteAssignByPid(form);
    }

    public Boolean batchDelAssign(CommonForm.BatchDel form) {
        return assignDao.batchDelAssign(form) > 0;
    }

    @Transactional
    public Boolean createAssign(Assign form){
        Boolean result = false;
        //1.新增交办信息
        long id = assignDao.insertAssign(form);
        result = id>0;
        Assign editForm = new Assign();
        editForm.setId(id);
        editForm.setAssignCode(form.getOrgId()+"-JB-"+id);
        result = assignDao.updateAssign(editForm)>0;
        //2.根据当前创建人所在组织及选择承办组织创建办理信息
        AssignHandleInfo assignHandleInfo = new AssignHandleInfo();
        assignHandleInfo.setAssignid(id);
        assignHandleInfo.setHandleorgid(form.getOrgId());
        assignHandleInfo.setHandleorgname(form.getOrgName());
        assignHandleInfo.setAssignstatus(1);          //已交办
        assignHandleInfo.setHandleuserid(form.getUserId());
        assignHandleInfo.setHandleusername(form.getUserName());
        assignHandleInfo.setAreacode(form.getAreaCode());
        assignHandleInfo.setAreaname(form.getAreaName());
        assignHandleInfo.setOrgid(form.getOrgId());
        assignHandleInfo.setOrgname(form.getOrgName());
        assignHandleInfo.setDepartmentid(form.getDepartmentId());
        assignHandleInfo.setDeptname(form.getDeptName());
        assignHandleInfo.setUserid(form.getUserId());
        assignHandleInfo.setUsername(form.getUserName());
        result = assignHandleInfoDao.insertAssignHandleInfo(assignHandleInfo)>0;
        //承办组织待办
        List<Organization> orgList = new ArrayList<>();
        if(StringUtils.isNotBlank(form.getUnderTakeOrgIds())){
            List<String> orgIds = Arrays.asList(StringUtils.split(form.getUnderTakeOrgIds(),","));
            orgList = organizationService.findOrganizationList(new OrganizationForm.Search().setOrgIds(orgIds));
        }
        for(Organization organization:orgList){
            AssignHandleInfo addForm = new AssignHandleInfo();
            addForm.setAssignid(id);
            addForm.setHandleorgid(organization.getOrgId());
            addForm.setHandleorgname(organization.getOrgName());
            addForm.setAssignstatus(0);
            addForm.setPlanenddate(form.getEndDate());
            addForm.setAssignorgid(form.getOrgId());
            addForm.setAssignorgname(form.getAssignOrgName());
            result = assignHandleInfoDao.insertAssignHandleInfo(addForm)>0;
            //推送待办消息
            List<BaseUser> userList = baseUserService.findBaseUserList(new BaseUserForm.Search().setOrgId(organization.getOrgId()));
            //userList不为空，则推送消息
            if(CollectionUtils.isNotEmpty(userList)){
                for(BaseUser user:userList){
                    UserMessageForm.Add messageForm = new UserMessageForm.Add();
                    messageForm.setMsgType("gtasks");
                    messageForm.setTitle(form.getTitle());
                    messageForm.setContent(form.getContent());
                    messageForm.setUrl("/shop/task/view");
                    messageForm.setUserId(user.getUserId());
                    messageForm.setBizId(String.valueOf(id));
                    messageForm.setBizTable("t_assign");
                    result = userMessageDao.addUserMessage(messageForm)>0;
                }
            }
        }
        return result;
    }

    @Transactional
    public Boolean deliverAssign(Assign form){
        Boolean result = false;
        //1.新增一条交办信息
        CommonForm.Del assignForm = new CommonForm.Del();
        assignForm.setId(form.getPid());
        Assign assign = assignDao.queryAssign(assignForm);
        result = assignDao.insertAssign(form)>0;
        //2.添加待办信息
        List<Organization> orgList = new ArrayList<>();
        if(StringUtils.isNotBlank(form.getUnderTakeOrgIds())){
            List<String> orgIds = Arrays.asList(StringUtils.split(form.getUnderTakeOrgIds(),","));
            orgList = organizationService.findOrganizationList(new OrganizationForm.Search().setOrgIds(orgIds));
        }
        for(Organization organization:orgList){
            AssignHandleInfo addForm = new AssignHandleInfo();
            addForm.setAssignid(form.getPid());
            addForm.setHandleorgid(organization.getOrgId());
            addForm.setHandleorgname(organization.getOrgName());
            addForm.setAssignstatus(0);
            addForm.setPlanenddate(form.getEndDate());
            addForm.setAssignorgid(form.getOrgId());
            addForm.setAssignorgname(form.getAssignOrgName());
            result = assignHandleInfoDao.insertAssignHandleInfo(addForm)>0;

            //推送待办消息
            List<BaseUser> userList = baseUserService.findBaseUserList(new BaseUserForm.Search().setOrgId(organization.getOrgId()));
            //userList不为空，则推送消息
            if(CollectionUtils.isNotEmpty(userList)){
                for(BaseUser user:userList){
                    UserMessageForm.Add messageForm = new UserMessageForm.Add();
                    messageForm.setMsgType("gtasks");
                    messageForm.setTitle(assign.getTitle());
                    messageForm.setContent(assign.getContent());
                    messageForm.setUrl("/shop/task/view");
                    messageForm.setUserId(user.getUserId());
                    messageForm.setBizId(String.valueOf(assign.getId()));
                    messageForm.setBizTable("t_assign");
                    result = userMessageDao.addUserMessage(messageForm)>0;
                }
            }
        }
        //3.修改办理状态
        AssignHandleInfo getForm = new AssignHandleInfo();
        getForm.setAssignid(form.getPid());
        getForm.setHandleorgid(form.getOrgId());
        AssignHandleInfo assignHandleInfo = assignHandleInfoDao.queryAssignHandleInfo(getForm);
        assignHandleInfo.setAssignstatus(1);
        assignHandleInfo.setHandleuserid(form.getUserId());
        assignHandleInfo.setHandleusername(form.getUserName());
        assignHandleInfo.setAreacode(form.getAreaCode());
        assignHandleInfo.setAreaname(form.getAreaName());
        assignHandleInfo.setOrgid(form.getOrgId());
        assignHandleInfo.setOrgname(form.getOrgName());
        assignHandleInfo.setDepartmentid(form.getDepartmentId());
        assignHandleInfo.setDeptname(form.getDeptName());
        assignHandleInfo.setUserid(form.getUserId());
        assignHandleInfo.setUsername(form.getUserName());
        result = assignHandleInfoDao.updateAssignHandleInfo(assignHandleInfo)>0;
        return result;
    }

    public Page<AssignStatistics> queryAssignCompletionRatePage(AssignStatistics form,int curPage, int pageSize){
        return assignDao.queryAssignCompletionRatePage(form,curPage,pageSize,true,false);
    }

    public List<AssignStatistics> queryAssignCompletionRateList(AssignStatistics form,int curPage, int pageSize){
        return assignDao.queryAssignCompletionRatePage(form,curPage,pageSize,false,false).getResult();
    }

    public List<AssignStatistics> queryAssignCompletionRateList(AssignStatistics form){
        return assignDao.queryAssignCompletionRatePage(form,0,0,false,true).getResult();
    }

}