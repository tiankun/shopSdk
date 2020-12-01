package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.DelegateRoster;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.DelegateRosterForm;
import com.redare.shop.unifyworkbench.service.dao.DelegateRosterDao;
import com.redare.shop.unifyworkbench.service.dao.DelegateRosterUserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * (DelegateRoster)表服务接口
 *
 * @author makejava
 * @since 2020-11-19 17:14:35
 */
@Service
public class DelegateRosterService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DelegateRosterService.class);
    @Autowired
    DelegateRosterDao delegateRosterDao;
    @Autowired
    DelegateRosterUserDao delegateRosterUserDao;

    public long insertDelegateRoster(DelegateRosterForm.Add form) {
        return delegateRosterDao.insertDelegateRoster(form);
    }

    public int updateDelegateRoster(DelegateRosterForm.Edit form) {
        return delegateRosterDao.updateDelegateRoster(form);
    }

    public Page<DelegateRoster> queryForPageDelegateRoster(DelegateRosterForm.Search form, int curPage, int pageSize) {
        return delegateRosterDao.queryForPageDelegateRoster(form, curPage, pageSize, true, false);
    }

    public List<DelegateRoster> queryForListDelegateRoster(DelegateRosterForm.Search form, int curPage, int pageSize) {
        return delegateRosterDao.queryForPageDelegateRoster(form, curPage, pageSize, false, false).getResult();
    }

    public List<DelegateRoster> queryForListDelegateRoster(DelegateRosterForm.Search form) {
        return delegateRosterDao.queryForListDelegateRoster(form);
    }

    public DelegateRoster queryForDelegateRoster(DelegateRosterForm.Search form) {
        final List<DelegateRoster> list = delegateRosterDao.queryForListDelegateRoster(form);
        if (list != null && list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    @Transactional
    public int deleteDelegateRoster(CommonForm.Del form) {
        /*DelegateRosterUserForm.BatchDel batchDel = new DelegateRosterUserForm.BatchDel();
        batchDel.setRosterId(form.getId());
        delegateRosterUserDao.batchDelDelegateRosterUser(batchDel);*/
        return delegateRosterDao.deleteDelegateRoster(form);
    }

    public Boolean batchDelDelegateRoster(CommonForm.BatchDel form) {
        return delegateRosterDao.batchDelDelegateRoster(form) > 0;
    }

}