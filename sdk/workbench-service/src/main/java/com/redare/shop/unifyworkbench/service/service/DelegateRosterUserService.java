package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.DelegateRosterUser;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.DelegateRosterUserForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ImportFileInfoForm;
import com.redare.shop.unifyworkbench.service.dao.DelegateRosterUserDao;
import com.redare.shop.unifyworkbench.service.dao.ImportFileInfoDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 代表名册人员列表(DelegateRosterUser)表服务接口
 *
 * @author makejava
 * @since 2020-11-19 17:18:55
 */
@Service
public class DelegateRosterUserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DelegateRosterUserService.class);
    @Autowired
    DelegateRosterUserDao delegateRosterUserDao;
    @Autowired
    ImportFileInfoDao importFileInfoDao;

    public long insertDelegateRosterUser(DelegateRosterUserForm.Add form) {
        return delegateRosterUserDao.insertDelegateRosterUser(form);
    }

    public int updateDelegateRosterUser(DelegateRosterUserForm.Edit form) {
        return delegateRosterUserDao.updateDelegateRosterUser(form);
    }

    public Page<DelegateRosterUser> queryForPageDelegateRosterUser(DelegateRosterUserForm.Search form, int curPage, int pageSize) {
        return delegateRosterUserDao.queryForPageDelegateRosterUser(form, curPage, pageSize, true, false);
    }

    public List<DelegateRosterUser> queryForListDelegateRosterUser(DelegateRosterUserForm.Search form, int curPage, int pageSize) {
        return delegateRosterUserDao.queryForPageDelegateRosterUser(form, curPage, pageSize, false, false).getResult();
    }

    public List<DelegateRosterUser> queryForListDelegateRosterUser(DelegateRosterUserForm.Search form) {
        return delegateRosterUserDao.queryForListDelegateRosterUser(form);
    }

    public DelegateRosterUser queryForDelegateRosterUser(DelegateRosterUserForm.Search form) {
        final List<DelegateRosterUser> list = delegateRosterUserDao.queryForListDelegateRosterUser(form);
        if (list != null && list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public int deleteDelegateRosterUser(CommonForm.Del form) {
        return delegateRosterUserDao.deleteDelegateRosterUser(form);
    }

    public Boolean batchDelDelegateRosterUser(DelegateRosterUserForm.BatchDel form) {
        return delegateRosterUserDao.batchDelDelegateRosterUser(form) > 0;
    }

    @Transactional
    public Boolean addDelegateRosterUser(ImportFileInfoForm.Add form,List<DelegateRosterUserForm.Add> list){
        try {
            long id = importFileInfoDao.addImportFileInfo(form);
            for(DelegateRosterUserForm.Add addForm:list){
                DelegateRosterUser delegateRosterUser = delegateRosterUserDao.queryDelegateRosterUser(new DelegateRosterUserForm.Get().setRosterId(addForm.getRosterId()).setIdCardNo(addForm.getIdCardNo()));
                if(delegateRosterUser!=null){
                    DelegateRosterUserForm.Edit editForm = new DelegateRosterUserForm.Edit();
                    editForm.setId(delegateRosterUser.getId());
                    editForm.setStatus(-1);
                    delegateRosterUserDao.updateDelegateRosterUser(editForm);
                    delegateRosterUserDao.insertDelegateRosterUser(addForm,id);
                }else{
                    delegateRosterUserDao.insertDelegateRosterUser(addForm,id);
                }
            }
            //更新导入记录数
            importFileInfoDao.editImportCount(list.size(),id);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

}