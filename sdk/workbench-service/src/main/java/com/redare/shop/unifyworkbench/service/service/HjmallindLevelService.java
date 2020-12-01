package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.HjmallindLevel;
import com.redare.shop.unifyworkbench.sdk.pojo.form.HjmallindLevelForm;
import com.redare.shop.unifyworkbench.service.dao.HjmallindLevelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

;


/**
 * 会员等级 impl
 *
 * @date 2020-12-01 16:56:53
 * Created by tiankun
 */
@Service
public class HjmallindLevelService {

    @Autowired
    HjmallindLevelDao hjmallindLevelDao;


    public boolean addHjmallindLevel(HjmallindLevelForm.Add form) {
        long id = hjmallindLevelDao.addHjmallindLevel(form);
        return id > 0;
    }

    public boolean editHjmallindLevel(HjmallindLevelForm.Edit form) {
        return hjmallindLevelDao.editHjmallindLevel(form) > 0;
    }

    public boolean deleteHjmallindLevel(HjmallindLevelForm.Del form) {
        return hjmallindLevelDao.deleteHjmallindLevel(form) > 0;
    }

    public List<HjmallindLevel> findHjmallindLevelList(HjmallindLevelForm.Search form) {
        return hjmallindLevelDao.findHjmallindLevelPage(form, 1, 20, false, true).getResult();
    }

    public List<HjmallindLevel> findHjmallindLevelList(HjmallindLevelForm.Search form, int curPage, int pageSize) {
        return hjmallindLevelDao.findHjmallindLevelPage(form, curPage, pageSize, false, false).getResult();
    }

    public Page<HjmallindLevel> findHjmallindLevelPage(HjmallindLevelForm.Search form, int curPage, int pageSize) {
        return hjmallindLevelDao.findHjmallindLevelPage(form, curPage, pageSize, true, false);
    }

    public HjmallindLevel getHjmallindLevel(HjmallindLevelForm.Get form) {
        return hjmallindLevelDao.getHjmallindLevel(form);

    }


}

