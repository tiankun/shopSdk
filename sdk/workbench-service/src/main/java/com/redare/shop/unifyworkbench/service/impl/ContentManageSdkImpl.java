package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.devframework.webplatform.service.core.service.UserService;
import com.redare.shop.unifyworkbench.sdk.ContentManageSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.ContentAttachment;
import com.redare.shop.unifyworkbench.sdk.pojo.ContentManage;
import com.redare.shop.unifyworkbench.sdk.pojo.Organization;
import com.redare.shop.unifyworkbench.sdk.pojo.UserOrg;
import com.redare.shop.unifyworkbench.sdk.pojo.form.*;
import com.redare.shop.unifyworkbench.service.service.*;
import com.redare.shop.unifyworkbench.service.util.HtmlProcessUtil;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ContentManageSdkImpl
 *
 * @Author zlx
 * @Date 2020/5/6 16:06
 */
@Service
public class ContentManageSdkImpl implements ContentManageSdk {

    @Autowired
    ContentManageService contentManageService;

    @Autowired
    ContentAttachmentService contentAttachmentService;

    @Autowired
    UserService userService;

    @Autowired
    UserMessageService userMessageService;

    @Autowired
    OrganizationService organizationService;

    @Autowired
    UserOrgService userOrgService;

    private static final int[] CLASSIFY=new int[]{5,7,8};

    private static final int NOTICE = 6;

    /**
     * 分页查询（t_content_manage）列表
     * @author zlx
     * @date 2020/5/6 16:17
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.ContentManage>>
     */
    @Override
    public CommonResult<Page<ContentManage>> findContentManagePage(ContentManageForm.Search form, int curPage, int pageSize) {
        Page<ContentManage> page = contentManageService.findContentManagePage(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(page);
    }

    /**
     * 查询列表数据，分页
     * @author zlx
     * @date 2020/5/12 11:48
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.ContentManage>>
     */
    @Override
    public CommonResult<List<ContentManage>> findContentManageList(ContentManageForm.Search form, int curPage, int pageSize) {
        List<ContentManage> list = contentManageService.findContentManageList(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(list);
    }

    /**
     *  查询所有数据，不分页
     * @author zlx
     * @date 2020/5/12 11:49
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.ContentManage>>
     */
    @Override
    public CommonResult<List<ContentManage>> findContentManageList(ContentManageForm.Search form) {
        List<ContentManage> list = contentManageService.findContentManageList(form);
        return CommonResult.returnSuccessWrapper(list);
    }

    /**
     *新增（t_content_manage）列表数据
     * @author zlx
     * @date 2020/5/7 10:43
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    @Override
    public CommonResult<Integer> addContentManage(ContentManageForm.Add form){
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if(commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        if (form.getContent() != null && !"".equals(form.getContent())){
            form.setContent(form.getContent().replaceAll(";lt&","&lt;").replaceAll(";gt&","&gt;"));
        }
        List<String> orgIdList = new ArrayList<>();
        if (StringUtils.isNotBlank(form.getOrgIds())){
            orgIdList = Arrays.stream(form.getOrgIds().split(",")).collect(Collectors.toList());
            List<Organization> list = organizationService.findOrganizationList(new OrganizationForm.Search().setStatus(1).setOrgIds(orgIdList));
            if (list != null && list.size()>0){
                form.setOrgNames(StringUtils.join(list.stream().map(Organization::getOrgName).collect(Collectors.toList()), ","));
            }
        }
        Integer contentId = contentManageService.addContentManage(form);
        if (orgIdList.size()>0){
            addUserMessageInfo(orgIdList,form.getContent(),form.getTitle(),form.getClassify(),contentId);
        }
        return CommonResult.returnDataWrapper(contentId);
    }


    private void addUserMessageInfo(List<String> orgIdList,String content,String title,Integer classify,Integer contentId){
        List<UserOrg> userOrgs = userOrgService.findUserOrgList(new UserOrgForm.Search().setOrgIdList(orgIdList));
        if (userOrgs != null && userOrgs.size()>0){
            List<Long> userIdList = userOrgs.stream().map(UserOrg::getUserId).distinct().collect(Collectors.toList());
            List<UserMessageForm.Add> list = new ArrayList<>();
            for (Long userId : userIdList){
                UserMessageForm.Add messageAdd = new UserMessageForm.Add();
                messageAdd.setTitle(title);
                if (classify == NOTICE){
                    messageAdd.setMsgType("notice");
                    messageAdd.setContent("关于"+title+"的通知公告");
                }else if (ArrayUtils.contains(CLASSIFY,classify)){
                    messageAdd.setMsgType("news");
                    messageAdd.setContent("关于"+title+"的新闻公告");
                }
                messageAdd.setUrl("/message/detail");
                messageAdd.setUserId(userId);
                messageAdd.setReaded(0);
                messageAdd.setCreateTime(new Date());
                messageAdd.setUpdateTime(new Date());
                messageAdd.setBizId(contentId.toString());
                messageAdd.setMsgId(Long.valueOf(contentId));
                messageAdd.setBizTable("t_content_manage");
                list.add(messageAdd);
            }
            userMessageService.batchAddUserMessage(list);
        }
    }
    /**
     * 修改显示隐藏状态
     * @author zlx
     * @date 2020/5/7 21:51
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    @Override
    public CommonResult<Boolean> editStatus(ContentManageForm.EditStatus form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        Boolean bool = contentManageService.editStatus(form)>0;
        return CommonResult.returnBoolWrapper(bool,"修改状态失败");
    }

    /**
     * 根据id删除（t_content_manage）表数据
     * @author zlx
     * @date 2020/5/8 9:52
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    @Override
    public CommonResult<Boolean> deleteContentManage(ContentManageForm.Del form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        Boolean bool = contentManageService.deleteContentManage(form);
        ContentAttachmentForm.Del del = new ContentAttachmentForm.Del();
        del.setContentId(form.getId());
        contentAttachmentService.deleteAttachment(del);
        UserMessageForm.DeleteByMsgId deleteByMsgId = new UserMessageForm.DeleteByMsgId();
        List<Long> list = new ArrayList<>();
        list.add(form.getId());
        deleteByMsgId.setMsgId(list);
        userMessageService.deleteByMsgId(deleteByMsgId);
        return CommonResult.returnBoolWrapper(bool,"删除数据失败");
    }

    /**
     * 根据id查询内容详情
     * @author zlx
     * @date 2020/5/8 11:25
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.shop.unifyworkbench.sdk.pojo.ContentManage>
     */
    @Override
    public CommonResult<ContentManage> getContentManage(ContentManageForm.Get form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        contentManageService.autoPlusOneOnBrowse(form);
        if (form.getUserMsgId() != null){
            UserMessageForm.Get userMessageForm = new UserMessageForm.Get();
            userMessageForm.setId(form.getUserMsgId());
            userMessageService.updateReadedAndReadTime(userMessageForm);
        }
        ContentManage contentManage = contentManageService.getContentManage(form);
        if (contentManage != null){
            if (contentManage.getContent() != null && !"".equals(contentManage.getContent())){
                String content = StringEscapeUtils.unescapeHtml4(contentManage.getContent());
                contentManage.setContent(content);
            }
            ContentAttachmentForm.GetByContentId getByContentId = new ContentAttachmentForm.GetByContentId();
            getByContentId.setContentId(form.getId());
            List<ContentAttachment> list = contentAttachmentService.findContentAttachmentList(getByContentId);
            contentManage.setAttachmentList(list);
        }
        return CommonResult.returnDataWrapper(contentManage);
    }

    /**
     * 编辑数据
     * @author zlx
     * @date 2020/5/8 17:58
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    @Override
    public CommonResult<Boolean> editContentManage(ContentManageForm.Edit form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        if (form.getContent() != null && !"".equals(form.getContent())){
            form.setContent(form.getContent().replaceAll(";lt&","&lt;").replaceAll(";gt&","&gt;"));
        }
        List<String> orgIdList = new ArrayList<>();
        if (StringUtils.isNotBlank(form.getOrgIds())){
            orgIdList = Arrays.stream(form.getOrgIds().split(",")).collect(Collectors.toList());
            List<Organization> list = organizationService.findOrganizationList(new OrganizationForm.Search().setStatus(1).setOrgIds(orgIdList));
            if (list != null && list.size()>0){
                form.setOrgNames(StringUtils.join(list.stream().map(Organization::getOrgName).collect(Collectors.toList()), ","));
            }
        }
        Boolean bool = contentManageService.editContentManage(form);
        List<Long> idList = new ArrayList<>();
        idList.add(form.getId());
        userMessageService.deleteByMsgId(new UserMessageForm.DeleteByMsgId().setMsgId(idList));
        if (orgIdList.size()>0){
            addUserMessageInfo(orgIdList,form.getContent(),form.getTitle(),form.getClassify(),form.getId().intValue());
        }
        return CommonResult.returnBoolWrapper(bool,"编辑失败");
    }

    /**
     * 批量删除数据
     * @author zlx
     * @date 2020/5/9 11:25
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    @Override
    public CommonResult<Boolean> batchDelContent(ContentManageForm.BatchDel form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        if (form.getIds() == null || form.getIds().size()<=0){
            return CommonResult.returnFailsWrapper("请传入主键id");
        }
        Boolean bool = contentManageService.batchDelConten(form);
        ContentAttachmentForm.BatchDel del = new ContentAttachmentForm.BatchDel();
        del.setContentId(form.getIds());
        contentAttachmentService.batchDelAttachmentByContentId(del);
        UserMessageForm.DeleteByMsgId deleteByMsgId = new UserMessageForm.DeleteByMsgId();
        deleteByMsgId.setMsgId(form.getIds());
        userMessageService.deleteByMsgId(deleteByMsgId);
        return CommonResult.returnBoolWrapper(bool,"批量删除失败");
    }

    /**
     * 查询前五条数据
     * @author zlx
     * @date 2020/5/11 13:12
     * @param
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.Map<java.lang.String,java.lang.Object>>
     */
    @Override
    public CommonResult<Map<String, Object>> getContentManageTop5(ContentManageForm.GetByClassify form) {
        Map<String,Object> map = new HashMap<>();
        ContentManage contentManage = null;
        List<ContentManage> lists = new ArrayList<>();
        List<ContentManage> list = contentManageService.getContentManageTop5(form);
        if (list != null && list.size()>0){
            if (list.size() == 1){
                contentManage = assemble(list.get(0));
            }else {
                if (list.size() >= 5){
                    contentManage = assemble(list.get(0));
                    for (int i = 1; i <5 ; i++) {
                        lists.add(assemble(list.get(i)));
                    }
                }else {
                    contentManage = assemble(list.get(0));
                    for (int i = 1; i <list.size() ; i++) {
                        lists.add(assemble(list.get(i)));
                    }
                }
            }
        }
        map.put("top1",contentManage);
        map.put("list",lists);
        return CommonResult.returnSuccessWrapper(map);
    }

    /**
     * 根据分类进行分页查询
     * @author zlx
     * @date 2020/5/12 11:59
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.ContentManage>>
     */
    @Override
    public CommonResult<Page<ContentManage>> findContentManagePageByClassify(ContentManageForm.Search form, int curPage, int pageSize) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        Page<ContentManage> page = contentManageService.findContentManageByClassify(form,curPage,pageSize);
        if (page.getResult() != null && page.getResult().size() >0){
            List<ContentManage> list = new ArrayList<>();
            for (ContentManage contentManage : page.getResult()){
                if (contentManage.getContent() != null && !"".equals(contentManage.getContent())){
                    String content = StringEscapeUtils.unescapeHtml4(contentManage.getContent());
                    contentManage.setContent(HtmlProcessUtil.getTextFromHtml(content));
                }
                list.add(contentManage);
            }
            page.setResult(list);
        }
        return CommonResult.returnSuccessWrapper(page);
    }

    /**
     * @description 根据分类集合分页查询数据
     * @author zlx
     * @date 2020/7/16 15:56
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.ContentManage>>
     */
    @Override
    public CommonResult<Page<ContentManage>> findContentManagePageByClassifyList(ContentManageForm.Search form, int curPage, int pageSize) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        Page<ContentManage> page = contentManageService.findContentManagePageByClassifyList(form,curPage,pageSize);
        if (page.getResult() != null && page.getResult().size() >0){
            List<ContentManage> list = new ArrayList<>();
            for (ContentManage contentManage : page.getResult()){
                if (contentManage.getContent() != null && !"".equals(contentManage.getContent())){
                    String content = StringEscapeUtils.unescapeHtml4(contentManage.getContent());
                    contentManage.setContent(HtmlProcessUtil.getTextFromHtml(content));
                }
                list.add(contentManage);
            }
            page.setResult(list);
        }
        return CommonResult.returnSuccessWrapper(page);
    }

    private ContentManage assemble(ContentManage contentManage){
        if (contentManage.getContent() != null && !"".equals(contentManage.getContent())){
            String content = StringEscapeUtils.unescapeHtml4(contentManage.getContent());
            contentManage.setContent(HtmlProcessUtil.getTextFromHtml(content));
        }
        String[] pubTime = contentManage.getPubTime().split("-");
        contentManage.setYear(pubTime[0]);
        contentManage.setMonthAndDay(pubTime[1]+"-"+pubTime[2]);
        return contentManage;
    }
}
