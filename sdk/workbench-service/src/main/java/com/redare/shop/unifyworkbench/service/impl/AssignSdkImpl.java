package com.redare.shop.unifyworkbench.service.impl;

import com.google.common.collect.ImmutableMap;
import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.utils.JsonUtils;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.devframework.smsgateway.sdk.SmsSendSdk;
import com.redare.devframework.smsgateway.sdk.pojo.SendResult;
import com.redare.devframework.smsgateway.sdk.pojo.arg.SmsSendArg;
import com.redare.shop.unifyworkbench.sdk.AssignSdk;
import com.redare.shop.unifyworkbench.sdk.BaseUserSdk;
import com.redare.shop.unifyworkbench.sdk.UserMessageSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.*;
import com.redare.shop.unifyworkbench.sdk.pojo.form.*;
import com.redare.shop.unifyworkbench.service.config.AppApiConfig;
import com.redare.shop.unifyworkbench.service.service.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 交办表(Assign)SdkImpl
 *
 * @author makejava
 * @since 2020-10-22 14:32:13
 */
@Service
public class AssignSdkImpl implements AssignSdk {
    private static final Logger LOGGER = LoggerFactory.getLogger(AssignSdkImpl.class);
    @Autowired
    AssignService assignService;
    @Autowired
    OrganizationService organizationService;
    @Autowired
    AreaService areaService;
    @Autowired
    AssignHandleInfoService assignHandleInfoService;
    @Autowired
    UserMessageService userMessageService;
    @Autowired
    UserMessageSdk userMessageSdk;
    @Autowired
    BaseUserSdk baseUserSdk;

    @Autowired
    SmsSendSdk smsSendSdk;
    @Autowired
    AppApiConfig config;

    private static final String rootAreaCode = "530000";

    @Override
    public CommonResult<Boolean> insertAssign(Assign form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        final long id = assignService.insertAssign(form);
        return CommonResult.returnSuccessWrapper(id > 0);
    }

    @Override
    public CommonResult<Boolean> updateAssign(Assign form) {
        if (form.getId() == null) {
            return CommonResult.returnFailsWrapper("主键不能为空");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        int row = assignService.updateAssign(form);
        return CommonResult.returnSuccessWrapper(row > 0);
    }

    @Override
    @Transactional
    public CommonResult<Boolean> deleteAssign(CommonForm.Del form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        int row = assignService.deleteAssign(form);


        AssignHandleInfoForm.Search search = new AssignHandleInfoForm.Search();
        search.setAssignId(form.getId());
        List<AssignHandleInfo> list = assignHandleInfoService.queryForListAssignHandleInfo(search);
        try {
            Assign delForm = new Assign();
            delForm.setPid(form.getId());
            assignService.deleteAssignByPid(delForm);
            if(CollectionUtils.isNotEmpty(list)){
                for(AssignHandleInfo handleInfo:list){
                    CommonForm.Del del = new CommonForm.Del();
                    del.setId(handleInfo.getId());
                    assignHandleInfoService.deleteAssignHandleInfo(del);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return CommonResult.returnSuccessWrapper(false);
        }
        return CommonResult.returnSuccessWrapper(row > 0);
    }


    @Override
    public CommonResult<Boolean> updateAssignStatus(AssignForm.Edit form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        final Assign targetForm = new Assign();
        try {
            BeanUtils.copyProperties(form, targetForm);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return CommonResult.returnFailsWrapper(e.getMessage());
        }
        int row = assignService.updateAssign(targetForm);
        return CommonResult.returnSuccessWrapper(row > 0);
    }

    @Override
    public CommonResult<Page<Assign>> queryForPageAssign(AssignForm.Search form, int curPage, int pageSize) {
        Page<Assign> data = assignService.queryForPageAssign(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(data);
    }

    @Override
    public CommonResult<Page<Assign>> queryAssignPage(AssignForm.Search form, int curPage, int pageSize) {
        Page<Assign> data = assignService.queryAssignPage(form,curPage,pageSize);
        return CommonResult.returnSuccessWrapper(data);
    }

    @Override
    public CommonResult<List<Assign>> queryForListAssign(AssignForm.Search form) {
        List<Assign> data = assignService.queryForListAssign(form);
        return CommonResult.returnSuccessWrapper(data);
    }

    @Override
    public CommonResult<Assign> queryAssign(AssignForm.Search form) {
        List<Assign> data = assignService.queryForListAssign(form);
        if (data.size() == 1) {
            UserMessageForm.GetByUserId getForm = new UserMessageForm.GetByUserId();
            getForm.setUserId(form.getUserId());
            getForm.setBizId(form.getId().toString());
            getForm.setBizTable("t_assign");
            List<UserMessage> list = userMessageService.getUserMessageByUserId(getForm);
            if(list.size()==1){
                UserMessageForm.Edit editForm = new UserMessageForm.Edit();
                editForm.setId(list.get(0).getId());
                userMessageSdk.editReadedAndreadTime(editForm);
            }
            return CommonResult.returnSuccessWrapper(data.get(0));
        }
        return CommonResult.returnFailsWrapper("无效的查询条件");
    }

    @Override
    public CommonResult<Boolean> batchDelAssign(CommonForm.BatchDel form) {
        if (form == null) {
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        if (form.getIds() == null || form.getIds().size() <= 0) {
            return CommonResult.returnFailsWrapper("请传入主键id");
        }
        Boolean bool = assignService.batchDelAssign(form);

        return CommonResult.returnBoolWrapper(bool, "批量删除失败");
    }

    @Override
    public CommonResult<Boolean> createAssign(Assign form){
        Boolean result = false;
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        BaseUserForm.Search search = new BaseUserForm.Search();
        if(StringUtils.isNotBlank(form.getUnderTakeOrgIds())){
            search.setOrgIds(Arrays.asList(form.getUnderTakeOrgIds().split(",")));
        }
        search.setPositionIds(form.getPositionIds());
        List<BaseUser> userList = baseUserSdk.findBaseUserList(search).getData();
        try {
            if(CollectionUtils.isNotEmpty(form.getPositionIds())){
                form.setPostIds(JsonUtils.toJson(form.getPositionIds()));
            }
            result = assignService.createAssign(form);
            if(CollectionUtils.isNotEmpty(userList)){
                List<String> mobileList = new ArrayList<>();
                for(BaseUser user:userList){
                    if(StringUtils.isNotBlank(user.getMobile())){
                        mobileList.add(user.getMobile());
                    }
                    CommonResult<SendResult> sendResult = smsSendSdk.sendSms((SmsSendArg.Send) new SmsSendArg.Send()
                            .setMobile(Arrays.asList(user.getMobile()))
                            .setTemplateCode("gtask")
                            .setTemplateArgs(ImmutableMap.of(
                                    "user", user.getName()))
                            .setSysCode(config.getSmsBsId()));
                    LOGGER.info(sendResult.getData().getContent());
                }

            }
        }catch (Exception e){
            e.printStackTrace();

        }
        return CommonResult.returnSuccessWrapper(result);
    }

    @Override
    public CommonResult<Page<AssignStatistics>> queryAssignCompletionRatePage(AssignStatistics form, int curPage, int pageSize) {
        form = wrapperSearch(form);
        return CommonResult.returnSuccessWrapper(assignService.queryAssignCompletionRatePage(form,curPage,pageSize));
    }

    @Override
    public CommonResult<List<AssignStatistics>> queryAssignCompletionRateList(AssignStatistics form, int curPage, int pageSize) {
        form = wrapperSearch(form);
        return CommonResult.returnSuccessWrapper(assignService.queryAssignCompletionRateList(form,curPage,pageSize));
    }

    @Override
    public CommonResult<List<AssignStatistics>> queryAssignCompletionRateList(AssignStatistics form) {
        form = wrapperSearch(form);
        return CommonResult.returnSuccessWrapper(assignService.queryAssignCompletionRateList(form));
    }

    @Override
    public CommonResult<List<Organization>> findOrganizationList(OrganizationForm.Search form) {
        if (form == null) {
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        List<Area> areaList = areaService.queryAreaOrgList(new AreaForm.Search().setParentCode(form.getAreaCode()));
        List<String> areaCodes = new ArrayList<>();
        areaCodes.add(form.getAreaCode());
        if(CollectionUtils.isNotEmpty(areaList)){
            for(Area area:areaList){
                areaCodes.add(area.getAreaCode());
            }
        }
        OrganizationForm.Search search = new OrganizationForm.Search();
        search.setAreaCodes(areaCodes);
        search.setStatus(1);
        List<Organization> list = organizationService.findOrganizationList(search);
        List<Organization> newList = list.stream().filter(e->!e.getOrgId().equals(form.getOrgId())).collect(Collectors.toList());
        return CommonResult.returnSuccessWrapper(newList);
    }

    @Override
    public CommonResult<Boolean> deliverAssign(Assign form) {
        Boolean result = false;
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        BaseUserForm.Search search = new BaseUserForm.Search();
        if(StringUtils.isNotBlank(form.getUnderTakeOrgIds())){
            search.setOrgIds(Arrays.asList(form.getUnderTakeOrgIds().split(",")));
        }
        search.setPositionIds(form.getPositionIds());
        List<BaseUser> userList = baseUserSdk.findBaseUserList(search).getData();
        try {
            result = assignService.deliverAssign(form);
            if(CollectionUtils.isNotEmpty(userList)){
                List<String> mobileList = new ArrayList<>();
                for(BaseUser user:userList){
                    if(StringUtils.isNotBlank(user.getMobile())){
                        mobileList.add(user.getMobile());
                    }
                    CommonResult<SendResult> sendResult = smsSendSdk.sendSms((SmsSendArg.Send) new SmsSendArg.Send()
                            .setMobile(Arrays.asList(user.getMobile()))
                            .setTemplateCode("gtask")
                            .setTemplateArgs(ImmutableMap.of(
                                    "user", user.getName()))
                            .setSysCode(config.getSmsBsId()));
                    LOGGER.info(sendResult.getData().getContent());
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return CommonResult.returnSuccessWrapper(result);
    }

    public AssignStatistics wrapperSearch(AssignStatistics form){
        Organization organization = organizationService.findOrganization(new OrganizationForm.Get().setOrgId(form.getOrgId()));
        if(organization!=null){
            if(organization.getOrgClassify().equals("hx") || organization.getAreaLevel()==5){
                OrganizationForm.Search search = new OrganizationForm.Search();
                search.setAreaCode(rootAreaCode);
                search.setOrgClassify("zx");
                List<Organization> orgList = organizationService.findOrganizationList(search);
                if(CollectionUtils.isNotEmpty(orgList)){
                    form.setOrgId(orgList.get(0).getOrgId());
                    form.setAreaCode(orgList.get(0).getAreaCode());
                }
            }
        }
        return form;
    }
}