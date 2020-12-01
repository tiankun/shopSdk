package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.HjmallindOrderDetail;
import com.redare.shop.unifyworkbench.sdk.pojo.form.HjmallindOrderDetailForm;
import com.redare.shop.unifyworkbench.service.dao.HjmallindOrderDetailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



/**
 * 订单明细 impl
 *
 * @date 2020-12-01 16:21:41
 * Created by tiankun
 */
@Service
public class HjmallindOrderDetailService {

    @Autowired
    HjmallindOrderDetailDao hjmallindOrderDetailDao;


    public boolean addHjmallindOrderDetail(HjmallindOrderDetailForm.Add form) {
        long id = hjmallindOrderDetailDao.addHjmallindOrderDetail(form);
        return id > 0;
    }

    public boolean editHjmallindOrderDetail(HjmallindOrderDetailForm.Edit form) {
        return hjmallindOrderDetailDao.editHjmallindOrderDetail(form) > 0;
    }

    public boolean deleteHjmallindOrderDetail(HjmallindOrderDetailForm.Del form) {
        return hjmallindOrderDetailDao.deleteHjmallindOrderDetail(form) > 0;
    }

    public List<HjmallindOrderDetail> findHjmallindOrderDetailList(HjmallindOrderDetailForm.Search form) {
        return hjmallindOrderDetailDao.findHjmallindOrderDetailPage(form, 1, 20, false, true).getResult();
    }

    public List<HjmallindOrderDetail> findHjmallindOrderDetailList(HjmallindOrderDetailForm.Search form, int curPage, int pageSize) {
        return hjmallindOrderDetailDao.findHjmallindOrderDetailPage(form, curPage, pageSize, false, false).getResult();
    }

    public Page<HjmallindOrderDetail> findHjmallindOrderDetailPage(HjmallindOrderDetailForm.Search form, int curPage, int pageSize) {
        return hjmallindOrderDetailDao.findHjmallindOrderDetailPage(form, curPage, pageSize, true, false);
    }

    public HjmallindOrderDetail getHjmallindOrderDetail(HjmallindOrderDetailForm.Get form) {
        return hjmallindOrderDetailDao.getHjmallindOrderDetail(form);

    }


}

