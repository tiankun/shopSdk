package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.HjmallindOrder;
import com.redare.shop.unifyworkbench.sdk.pojo.form.HjmallindOrderForm;
import com.redare.shop.unifyworkbench.service.dao.HjmallindOrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单表 impl
 *
 * @date 2020-12-01 16:21:27
 * Created by tiankun
 */
@Service
public class HjmallindOrderService {

    @Autowired
    HjmallindOrderDao hjmallindOrderDao;


    public boolean addHjmallindOrder(HjmallindOrderForm.Add form) {
        long id = hjmallindOrderDao.addHjmallindOrder(form);
        return id > 0;
    }

    public boolean editHjmallindOrder(HjmallindOrderForm.Edit form) {
        return hjmallindOrderDao.editHjmallindOrder(form) > 0;
    }

    public boolean deleteHjmallindOrder(HjmallindOrderForm.Del form) {
        return hjmallindOrderDao.deleteHjmallindOrder(form) > 0;
    }

    public List<HjmallindOrder> findHjmallindOrderList(HjmallindOrderForm.Search form) {
        return hjmallindOrderDao.findHjmallindOrderPage(form, 1, 20, false, true).getResult();
    }

    public List<HjmallindOrder> findHjmallindOrderList(HjmallindOrderForm.Search form, int curPage, int pageSize) {
        return hjmallindOrderDao.findHjmallindOrderPage(form, curPage, pageSize, false, false).getResult();
    }

    public Page<HjmallindOrder> findHjmallindOrderPage(HjmallindOrderForm.Search form, int curPage, int pageSize) {
        return hjmallindOrderDao.findHjmallindOrderPage(form, curPage, pageSize, true, false);
    }

    public HjmallindOrder getHjmallindOrder(HjmallindOrderForm.Get form) {
        return hjmallindOrderDao.getHjmallindOrder(form);

    }


}

