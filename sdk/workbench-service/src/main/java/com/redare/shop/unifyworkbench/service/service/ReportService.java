package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.OrganizationSdk;
import com.redare.shop.unifyworkbench.sdk.common.pojo.BaseUserInfo;
import com.redare.shop.unifyworkbench.sdk.pojo.*;
import com.redare.shop.unifyworkbench.sdk.pojo.form.*;
import com.redare.shop.unifyworkbench.service.dao.*;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 上报表(Report)表服务接口
 *
 * @author makejava
 * @since 2020-10-21 14:13:50
 */
@Service
public class ReportService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReportService.class);
    @Autowired
    ReportDao reportDao;
    @Autowired
    ReportHandleRecordDao reportHandleRecordDao;
    @Autowired
    AreaDao areaDao;
    @Autowired
    OrganizationService organizationService;
    @Autowired
    BaseUserInfoDao baseUserInfoDao;
    @Autowired
    BaseUserService baseUserService;
    @Autowired
    UserMessageDao userMessageDao;

    public long insertReport(Report form) {
        return reportDao.insertReport(form);
    }

    public int updateReport(Report form) {
        ReportHandleRecordForm.Search search = new ReportHandleRecordForm.Search();
        search.setHandleOrgId(form.getOrgId());
        search.setReportId(form.getId());
        ReportHandleRecord reportHandleRecord = reportHandleRecordDao.queryReportHandleRecord(search);
        reportHandleRecord.setComment(form.getDescription());
        reportHandleRecord.setAttachments(form.getFiles());
        reportHandleRecordDao.updateReportHandleRecord(reportHandleRecord);
        return reportDao.updateReport(form);
    }

    public Page<Report> queryForPageReport(ReportForm.Search form, int curPage, int pageSize) {
        return reportDao.queryForPageReport(form, curPage, pageSize, true, false);
    }

    public List<Report> queryForListReport(ReportForm.Search form) {
        return reportDao.queryForListReport(form);
    }

    public Report queryForReport(ReportForm.Search form) {
        final List<Report> list = reportDao.queryForListReport(form);
        if (list != null && list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public int deleteReport(CommonForm.Del form) {
        return reportDao.deleteReport(form);
    }

    public Boolean batchDelReport(CommonForm.BatchDel form) {
        return reportDao.batchDelReport(form) > 0;
    }

    @Transactional
    public Boolean fillReport(Report form){

        Boolean result = false;
        long id = reportDao.insertReport(form);
        result = id>0;
        ReportHandleRecord handleRecord = new ReportHandleRecord();
        handleRecord.setReportid(id);
        handleRecord.setHandleorgid(form.getOrgId());
        handleRecord.setHandleorgname(form.getOrgName());
        handleRecord.setHandleuserid(form.getUserId());
        handleRecord.setHandleusername(form.getUserName());
        handleRecord.setHandlestate(1);
        handleRecord.setComment(form.getDescription());
        handleRecord.setAttachments(form.getFiles());
        handleRecord.setUpdatetime(new Date());
        handleRecord.setAreacode(form.getAreaCode());
        handleRecord.setAreaname(form.getAreaName());
        handleRecord.setOrgid(form.getOrgId());
        handleRecord.setOrgname(form.getOrgName());
        handleRecord.setUserid(form.getUserId());
        handleRecord.setUsername(form.getUserName());
        result = reportHandleRecordDao.insertReportHandleRecord(handleRecord)>0;
        if(result){
            BaseUserInfo baseUserForm = new BaseUserInfo();
            baseUserForm.setUserId(form.getUserId());
            List<BaseUserInfo> list = baseUserInfoDao.queryBaseUserInfo(baseUserForm);
            if (list.size() == 1) {
                final BaseUserInfo baseUserInfo = list.get(0);
                //根据areaCode,查询上级组织
                Area area = areaDao.queryArea(new AreaForm.Get().setAreaCode(baseUserInfo.getAreaCode()));
                //上级区域纵向组织
                List<Area> areaList = areaDao.queryAreaOrgList(new AreaForm.Search().setAreaCode(area.getParentCode()).setOrgClassify(OrganizationSdk.ORG_CLASSIFY_ZX));
                //当前区域纵向组织
                List<Area> arealist = areaDao.queryAreaOrgList(new AreaForm.Search().setAreaCode(area.getAreaCode()).setOrgClassify(OrganizationSdk.ORG_CLASSIFY_ZX));
                if (areaList.size() == 1) {
                    baseUserInfo.setOrgParentId(areaList.get(0).getOrgId());
                    baseUserInfo.setOrgParentName(areaList.get(0).getOrgName());
                }
                List<BaseUser> userList = new ArrayList<>();
                //根据当前用户的组织分类（横向/纵向），设置接收组织
                if (OrganizationSdk.ORG_CLASSIFY_ZX.equals(baseUserInfo.getOrgClassify())) {
                    if (areaList.size() == 1) {
                        //接收组织处理记录
                        ReportHandleRecord reportHandleRecord = new ReportHandleRecord();
                        reportHandleRecord.setReportid(id);
                        reportHandleRecord.setHandleorgid(areaList.get(0).getOrgId());
                        reportHandleRecord.setHandleorgname(areaList.get(0).getOrgName());
                        reportHandleRecord.setHandlestate(0);
                        result = reportHandleRecordDao.insertReportHandleRecord(reportHandleRecord)>0;

                        userList = baseUserService.findBaseUserList(new BaseUserForm.Search().setOrgId(areaList.get(0).getOrgId()));
                    }
                } else {
                    if (arealist.size() == 1) {
                        ReportHandleRecord reportHandleRecord = new ReportHandleRecord();
                        reportHandleRecord.setReportid(id);
                        reportHandleRecord.setHandleorgid(arealist.get(0).getOrgId());
                        reportHandleRecord.setHandleorgname(arealist.get(0).getOrgName());
                        reportHandleRecord.setHandlestate(0);
                        result = reportHandleRecordDao.insertReportHandleRecord(reportHandleRecord)>0;
                        userList = baseUserService.findBaseUserList(new BaseUserForm.Search().setOrgId(arealist.get(0).getOrgId()));
                        if(!result){
                            return result;
                        }
                    }
                }
                //userList不为空，则推送消息
                if(CollectionUtils.isNotEmpty(userList)){
                    for(BaseUser user:userList){
                        UserMessageForm.Add addForm = new UserMessageForm.Add();
                        addForm.setMsgType("gtasks");
                        addForm.setTitle(form.getTitle());
                        addForm.setContent(form.getDescription());
                        addForm.setUrl("/report/info");
                        addForm.setUserId(user.getUserId());
                        addForm.setBizId(String.valueOf(id));
                        addForm.setBizTable("t_report");
                        userMessageDao.addUserMessage(addForm);
                    }
                }

            }
        }
        return result;
    }

}