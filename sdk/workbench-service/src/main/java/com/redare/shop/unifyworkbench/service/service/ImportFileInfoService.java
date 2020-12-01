package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.webplatform.sdk.core.arg.AccountArg;
import com.redare.devframework.webplatform.service.core.service.AccountService;
import com.redare.shop.unifyworkbench.sdk.pojo.ImportFileInfo;
import com.redare.shop.unifyworkbench.sdk.pojo.ImportPersonnelInfo;
import com.redare.shop.unifyworkbench.sdk.pojo.form.*;
import com.redare.shop.unifyworkbench.service.dao.BaseUserDao;
import com.redare.shop.unifyworkbench.service.dao.ImportFileInfoDao;
import com.redare.shop.unifyworkbench.service.dao.ImportPersonnelInfoDao;
import com.redare.shop.unifyworkbench.service.dao.UserOrgDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/11/19 16:45
 * @version:
 */
@Service
public class ImportFileInfoService {

    @Autowired
    ImportFileInfoDao importFileInfoDao;
    @Autowired
    AccountService accountService;
    @Autowired
    BaseUserDao baseUserDao;
    @Autowired
    UserOrgDao userOrgDao;
    @Autowired
    ImportPersonnelInfoDao importPersonnelInfoDao;


    /**
     * @description 分页查询
     * @author zlx
     * @date 2020/11/19 16:47
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.ImportFileInfo>
     */
    public Page<ImportFileInfo> findImportFileInfoPage(ImportFileInfoForm.Search form, int curPage, int pageSize){
        return importFileInfoDao.findImportFileInfoPage(form,curPage,pageSize,true,false);
    }

    /**
     * @description 分页查询数据
     * @author zlx
     * @date 2020/11/19 16:48
     * @param form
     * @param curPage
     * @param pageSize
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.ImportFileInfo>
     */
    public List<ImportFileInfo> findImportFileInfoPageList(ImportFileInfoForm.Search form, int curPage, int pageSize){
        return importFileInfoDao.findImportFileInfoPage(form,curPage,pageSize,false,false).getResult();
    }

    /**
     * @description 查询所有数据
     * @author zlx
     * @date 2020/11/19 16:48
     * @param form
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.ImportFileInfo>
     */
    public List<ImportFileInfo> findImportFileInfoList(ImportFileInfoForm.Search form){
        return importFileInfoDao.findImportFileInfoPage(form,0,0,false,true).getResult();
    }

    /**
     * @description 根据主键id查询数据
     * @author zlx
     * @date 2020/11/19 16:49
     * @param form
     * @return com.redare.shop.unifyworkbench.sdk.pojo.ImportFileInfo
     */
    public ImportFileInfo findImportFileInfo(ImportFileInfoForm.Get form){
        return importFileInfoDao.findImportFileInfo(form);
    }

    /**
     * @description 添加数据
     * @author zlx
     * @date 2020/11/19 16:51
     * @param form
     * @return java.lang.Long
     */
    public Long addImportFileInfo(ImportFileInfoForm.Add form){
        return importFileInfoDao.addImportFileInfo(form);
    }

    /**
     * 修改状态
     * @param id
     * @return
     */
    public Boolean updateImportStatus(Long id){
        return importFileInfoDao.updateImportStatus(id);
    }
    /**
     * @description 更新数据导入量
     * @author zlx
     * @date 2020/11/20 17:05
     * @param count
     * @param id
     * @return java.lang.Boolean
     */
    public Boolean editImportCount(Integer count,Long id){
        return importFileInfoDao.editImportCount(count, id);
    }

    @Transactional
    public Boolean generateAccount(BaseUserForm.Add form, AccountArg.Add accountAdd, UserOrgForm.Add userOrgForm, ImportPersonnelInfo personnelInfo) throws Exception{
        //将人员添加至account
        long accountId = accountService.addAccount(accountAdd);
        form.setUserId(accountId);
        baseUserDao.addBaseUser(form);
        //用户组织关联信息
        userOrgForm.setUserId(accountId);
        userOrgDao.addUserOrg(userOrgForm);
        ImportPersonnelInfoForm.Edit edit = new ImportPersonnelInfoForm.Edit();
        BeanUtils.copyProperties(personnelInfo,edit);
        edit.setChangeAccount(1);
        importPersonnelInfoDao.editImportPersonnelInfo(edit);
        return true;
    }
}
