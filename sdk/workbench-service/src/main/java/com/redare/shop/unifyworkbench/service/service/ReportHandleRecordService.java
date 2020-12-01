package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.*;
import com.redare.shop.unifyworkbench.sdk.pojo.form.*;
import com.redare.shop.unifyworkbench.service.dao.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * 上报处理记录表(ReportHandleRecord)表服务接口
 *
 * @author makejava
 * @since 2020-10-21 14:15:35
 */
@Service
public class ReportHandleRecordService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReportHandleRecordService.class);
    @Autowired
    ReportHandleRecordDao reportHandleRecordDao;
    @Autowired
    ReportDao reportDao;
    @Autowired
    AreaDao areaDao;
    @Autowired
    OrganizationService organizationService;
    @Autowired
    BaseUserService baseUserService;
    @Autowired
    UserMessageDao userMessageDao;

    public long insertReportHandleRecord(ReportHandleRecord form) {
        return reportHandleRecordDao.insertReportHandleRecord(form);
    }

    public int updateReportHandleRecord(ReportHandleRecord form) {
        return reportHandleRecordDao.updateReportHandleRecord(form);
    }

    public Page<ReportHandleRecord> queryForPageReportHandleRecord(ReportHandleRecordForm.Search form, int curPage, int pageSize) {
        return reportHandleRecordDao.queryForPageReportHandleRecord(form, curPage, pageSize, true, false);
    }

    public List<ReportHandleRecord> queryForListReportHandleRecord(ReportHandleRecordForm.Search form) {
        CommonForm.Del getForm = new CommonForm.Del();
        getForm.setId(form.getReportId());
        Report report = reportDao.queryReport(getForm);
        List<ReportHandleRecord> reportHandleRecordList = new ArrayList<>();
        if(report!=null){
            form.setHandleOrgId(report.getOrgId());
            reportHandleRecordList = reportHandleRecordDao.queryForListReportHandleRecord(form);
        }
        return reportHandleRecordList;
    }



    public ReportHandleRecord queryForReportHandleRecord(ReportHandleRecordForm.Search form) {
        return reportHandleRecordDao.queryReportHandleRecord(form);
    }

    public List<ReportHandleRecord> queryForListReportRecord(ReportHandleRecordForm.Search form){
        return reportHandleRecordDao.queryForListReportRecord(form);
    }

    public int deleteReportHandleRecord(CommonForm.Del form) {
        return reportHandleRecordDao.deleteReportHandleRecord(form);
    }

    public Boolean batchDelReportHandleRecord(CommonForm.BatchDel form) {
        return reportHandleRecordDao.batchDelReportHandleRecord(form) > 0;
    }

    @Transactional
    public Boolean pushReport(ReportHandleRecord form){
        Boolean result = false;
        //1.修改当前处理记录
        form.setHandlestate(1);
        result = reportHandleRecordDao.updateReportHandleRecord(form)>0;
        CommonForm.Del getForm = new CommonForm.Del();
        getForm.setId(form.getReportId());
        Report report = reportDao.queryReport(getForm);
        //2.插入一条新的处理记录
        ReportHandleRecord reportHandleRecord = new ReportHandleRecord();
        reportHandleRecord.setReportid(form.getReportId());
        //根据areaCode查询上级组织
        Area area = areaDao.queryArea(new AreaForm.Get().setAreaCode(form.getAreaCode()));
        List<Organization> orgList = new ArrayList<>();
        if(StringUtils.isNotBlank(area.getParentCode())){
            OrganizationForm.Search search = new OrganizationForm.Search();
            search.setAreaCode(area.getParentCode());
            search.setOrgClassify("zx");
            search.setStatus(1);
            orgList = organizationService.findOrganizationList(search);
        }
        if(CollectionUtils.isNotEmpty(orgList)){
            for(Organization item:orgList){
                reportHandleRecord.setHandleorgid(item.getOrgId());
                reportHandleRecord.setHandleorgname(item.getOrgName());
                reportHandleRecord.setHandlestate(0);
                result = reportHandleRecordDao.insertReportHandleRecord(reportHandleRecord)>0;
            }
            List<BaseUser> userList = baseUserService.findBaseUserList(new BaseUserForm.Search().setOrgId(orgList.get(0).getOrgId()));
            //userList不为空，则推送消息
            if(CollectionUtils.isNotEmpty(userList)){
                for(BaseUser user:userList){
                    UserMessageForm.Add addForm = new UserMessageForm.Add();
                    addForm.setMsgType("gtasks");
                    addForm.setTitle(report.getTitle());
                    addForm.setContent(report.getDescription());
                    addForm.setUrl("/report/info");
                    addForm.setUserId(user.getUserId());
                    addForm.setBizId(String.valueOf(report));
                    addForm.setBizTable("t_report");
                    userMessageDao.addUserMessage(addForm);
                }
            }
        }
        return result;
    }

    @Transactional
    public Boolean handleReport(ReportHandleRecord form){
        Boolean result = false;
        //1.修改当前上报处理记录
        form.setHandlestate(2);
        result = reportHandleRecordDao.updateReportHandleRecord(form)>0;
        //2.修改上报基本信息状态
        CommonForm.Del commonForm = new CommonForm.Del();
        commonForm.setId(form.getReportId());
        Report report = reportDao.queryReport(commonForm);
        report.setStatus(2);
        result = reportDao.updateReport(report)>0;
        return result;
    }

}