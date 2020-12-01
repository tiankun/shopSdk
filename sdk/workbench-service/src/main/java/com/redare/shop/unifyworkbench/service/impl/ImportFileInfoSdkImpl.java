package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.devframework.webplatform.sdk.core.AccountSdk;
import com.redare.devframework.webplatform.sdk.core.arg.AccountArg;
import com.redare.devframework.webplatform.sdk.core.pojo.Account;
import com.redare.shop.unifyworkbench.sdk.BaseUserSdk;
import com.redare.shop.unifyworkbench.sdk.ImportFileInfoSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.BaseUser;
import com.redare.shop.unifyworkbench.sdk.pojo.ImportFileInfo;
import com.redare.shop.unifyworkbench.sdk.pojo.ImportPersonnelInfo;
import com.redare.shop.unifyworkbench.sdk.pojo.form.BaseUserForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ImportFileInfoForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ImportPersonnelInfoForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserOrgForm;
import com.redare.shop.unifyworkbench.service.service.BaseUserService;
import com.redare.shop.unifyworkbench.service.service.ImportFileInfoService;
import com.redare.shop.unifyworkbench.service.service.ImportPersonnelInfoService;
import com.redare.shop.unifyworkbench.service.service.UserOrgService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/11/19 16:51
 * @version:
 */
@Service
public class ImportFileInfoSdkImpl implements ImportFileInfoSdk {



    @Autowired
    ImportFileInfoService importFileInfoService;
    @Autowired
    ImportPersonnelInfoService importPersonnelInfoService;
    @Autowired
    BaseUserSdk baseUserSdk;
    @Autowired
    AccountSdk accountSdk;
    @Autowired
    BaseUserService baseUserService;
    @Autowired
    UserOrgService userOrgService;

    private static final String ACCOUNT_PWD = "abc123456";

    private static final String ACCOUNT_PLATFORM = "shop";

    private static final Long[] ACCOUNT_ROLEIDS = {26L};

    /**
     * @description 分页查询
     * @author zlx
     * @date 2020/11/19 16:52
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.ImportFileInfo>>
     */
    @Override
    public CommonResult<Page<ImportFileInfo>> findImportFileInfoPage(ImportFileInfoForm.Search form, int curPage, int pageSize) {
        return CommonResult.returnSuccessWrapper(importFileInfoService.findImportFileInfoPage(form, curPage, pageSize));
    }

    /**
     * @description 分页查询数据
     * @author zlx
     * @date 2020/11/19 16:53
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.ImportFileInfo>>
     */
    @Override
    public CommonResult<List<ImportFileInfo>> findImportFileInfoPageList(ImportFileInfoForm.Search form, int curPage, int pageSize) {
        return CommonResult.returnSuccessWrapper(importFileInfoService.findImportFileInfoPageList(form, curPage, pageSize));
    }

    /**
     * @description 查询所有数据
     * @author zlx
     * @date 2020/11/19 16:59
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.ImportFileInfo>>
     */
    @Override
    public CommonResult<List<ImportFileInfo>> findImportFileInfoList(ImportFileInfoForm.Search form) {
        return CommonResult.returnSuccessWrapper(importFileInfoService.findImportFileInfoList(form));
    }

    /**
     * @description 根据主键id查询数据
     * @author zlx
     * @date 2020/11/19 17:01
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.shop.unifyworkbench.sdk.pojo.ImportFileInfo>
     */
    @Override
    public CommonResult<ImportFileInfo> findImportFileInfo(ImportFileInfoForm.Get form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        return CommonResult.returnSuccessWrapper(importFileInfoService.findImportFileInfo(form));
    }

    /**
     * @description 添加数据
     * @author zlx
     * @date 2020/11/19 17:02
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Long>
     */
    @Override
    public CommonResult<Long> addImportFileInfo(ImportFileInfoForm.Add form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        return CommonResult.returnSuccessWrapper(importFileInfoService.addImportFileInfo(form));
    }

    @Override
    public CommonResult<ImportFileInfo> batchGenerateAccount(ImportFileInfoForm.Get form) {
        ImportPersonnelInfoForm.Search search = new ImportPersonnelInfoForm.Search();
        search.setRecordId(form.getId());
        search.setStatus(1);
        List<ImportPersonnelInfo> list = importPersonnelInfoService.findImportPersonnelInfoList(search);

        List<String> mobileList = new ArrayList<>();
        Long generateCount = 0L;
        if(CollectionUtils.isNotEmpty(list)){
            for(ImportPersonnelInfo personnelInfo:list){
                BaseUserForm.Add addForm = new BaseUserForm.Add();
                BeanUtils.copyProperties(personnelInfo,addForm);
                addForm.setName(personnelInfo.getName());
                addForm.setUserType(1);
                addForm.setBirthday(personnelInfo.getBirthday());
                addForm.setCardNo(personnelInfo.getCardNo());
                addForm.setSex(personnelInfo.getSex());
                addForm.setNativePlace(personnelInfo.getNativePlace());
                if(personnelInfo.getNationId()!=null){
                    addForm.setNationId(personnelInfo.getNationId().longValue());
                }
                addForm.setNation(personnelInfo.getNation());
                if(personnelInfo.getPoliticId()!=null){
                    addForm.setPoliticId(personnelInfo.getPoliticId().longValue());
                }
                //用户基本信息
                addForm.setPolitic(personnelInfo.getPolitic());
                addForm.setPartyDate(personnelInfo.getPartyDate());
                addForm.setEducationId(personnelInfo.getEducationId());
                addForm.setEducation(personnelInfo.getEducation());
                addForm.setSchool(personnelInfo.getSchool());
                addForm.setMajor(personnelInfo.getMajor());
                addForm.setGraduationTime(personnelInfo.getGraduationTime());
                addForm.setWorkUnit(personnelInfo.getUnit());
                addForm.setWechatId(personnelInfo.getWeChat());
                addForm.setUnitPosition(personnelInfo.getUnitPosition());
                addForm.setRemark(personnelInfo.getRemark());
                //账号信息
                AccountArg.Add accountAdd = new AccountArg.Add();
                accountAdd.setAccount(addForm.getMobile());
                accountAdd.setPwd(ACCOUNT_PWD);
                accountAdd.setPlatform(ACCOUNT_PLATFORM);
                List<Long> roleList = Arrays.asList(ACCOUNT_ROLEIDS);
                accountAdd.setRoleIds(roleList);
                accountAdd.setUserPlatform(personnelInfo.getOrgId());
                //用户组织关联信息
                UserOrgForm.Add userOrgForm = new UserOrgForm.Add();
                userOrgForm.setCreateTime(new Date());
                userOrgForm.setDel(0);
                userOrgForm.setOrgId(personnelInfo.getOrgId());
                userOrgForm.setOrgName(personnelInfo.getOrgName());
                userOrgForm.setDeptId(personnelInfo.getDeptId());
                userOrgForm.setDeptName(personnelInfo.getDeptName());
                userOrgForm.setWomenPosition(personnelInfo.getPosition());
                userOrgForm.setWomenPositionId(personnelInfo.getPositionId());
                userOrgForm.setPositionTypeCode(personnelInfo.getPositionTypeCode());
                userOrgForm.setPositionTypeName(personnelInfo.getPositionType());
                userOrgForm.setServedTime(personnelInfo.getPositionTime());
                userOrgForm.setOperator(form.getUserName());

                CommonResult result = accountSdk.validateAccountInfo(accountAdd);
                List<BaseUser> userList = new ArrayList<>();
                if(result.isNotSuccess()){
                    mobileList.add(personnelInfo.getMobile());
                    //账号已存在，判断是否是相同组织，若不是相同组织，则向t_user_org插入一条记录
                    AccountArg.Get accountArg = new AccountArg.Get();
                    accountArg.setAccount(personnelInfo.getMobile());
                    Account account = accountSdk.getAccount(accountArg).getData();

                    if(account!=null){
                        if(!account.getUserPlatform().equals(personnelInfo.getOrgId())){
                            userOrgForm.setUserId(account.getId());
                            userOrgService.addUserOrg(userOrgForm);
                        }
                    }
                    continue;
                }
                try{
                    importFileInfoService.generateAccount(addForm,accountAdd,userOrgForm,personnelInfo);
                    generateCount++;
                }catch (Exception e){
                    e.printStackTrace();
                    continue;
                }
            }
            if(mobileList.size()+generateCount==list.size()){
                //修改状态
                importFileInfoService.updateImportStatus(form.getId());
            }
        }
        ImportFileInfo importFileInfo = new ImportFileInfo();
        importFileInfo.setMobileList(mobileList);
        importFileInfo.setGenerateCount(generateCount);
        return CommonResult.returnSuccessWrapper(importFileInfo);
    }
}
