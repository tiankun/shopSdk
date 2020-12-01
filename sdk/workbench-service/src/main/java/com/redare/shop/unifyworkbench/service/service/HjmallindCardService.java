package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.HjmallindCard;
import com.redare.shop.unifyworkbench.sdk.pojo.form.HjmallindCardForm;
import com.redare.shop.unifyworkbench.service.dao.HjmallindCardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



/**
 * impl
 *
 * @date 2020-12-01 13:50:14
 * Created by tiankun
 */
@Service
public class HjmallindCardService {

    @Autowired
    HjmallindCardDao hjmallindCardDao;


    public boolean addHjmallindCard(HjmallindCardForm.Add form) {
        long id = hjmallindCardDao.addHjmallindCard(form);
        return id > 0;
    }

    public boolean editHjmallindCard(HjmallindCardForm.Edit form) {
        return hjmallindCardDao.editHjmallindCard(form) > 0;
    }

    public boolean deleteHjmallindCard(HjmallindCardForm.Del form) {
        return hjmallindCardDao.deleteHjmallindCard(form) > 0;
    }

    public List<HjmallindCard> findHjmallindCardList(HjmallindCardForm.Search form) {
        return hjmallindCardDao.findHjmallindCardPage(form, 1, 20, false, true).getResult();
    }

    public List<HjmallindCard> findHjmallindCardList(HjmallindCardForm.Search form, int curPage, int pageSize) {
        return hjmallindCardDao.findHjmallindCardPage(form, curPage, pageSize, false, false).getResult();
    }

    public Page<HjmallindCard> findHjmallindCardPage(HjmallindCardForm.Search form, int curPage, int pageSize) {
        return hjmallindCardDao.findHjmallindCardPage(form, curPage, pageSize, true, false);
    }

    public HjmallindCard getHjmallindCard(HjmallindCardForm.Get form) {
        return hjmallindCardDao.getHjmallindCard(form);

    }


}

