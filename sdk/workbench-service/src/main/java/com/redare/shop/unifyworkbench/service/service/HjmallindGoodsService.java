package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.HjmallindGoods;
import com.redare.shop.unifyworkbench.sdk.pojo.form.HjmallindGoodsForm;
import com.redare.shop.unifyworkbench.service.dao.HjmallindGoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品 impl
 *
 * @date 2020-12-01 16:20:57
 * Created by tiankun
 */
@Service
public class HjmallindGoodsService {

    @Autowired
    HjmallindGoodsDao hjmallindGoodsDao;


    public boolean addHjmallindGoods(HjmallindGoodsForm.Add form) {
        long id = hjmallindGoodsDao.addHjmallindGoods(form);
        return id > 0;
    }

    public boolean editHjmallindGoods(HjmallindGoodsForm.Edit form) {
        return hjmallindGoodsDao.editHjmallindGoods(form) > 0;
    }

    public boolean deleteHjmallindGoods(HjmallindGoodsForm.Del form) {
        return hjmallindGoodsDao.deleteHjmallindGoods(form) > 0;
    }

    public List<HjmallindGoods> findHjmallindGoodsList(HjmallindGoodsForm.Search form) {
        return hjmallindGoodsDao.findHjmallindGoodsPage(form, 1, 20, false, true).getResult();
    }

    public List<HjmallindGoods> findHjmallindGoodsList(HjmallindGoodsForm.Search form, int curPage, int pageSize) {
        return hjmallindGoodsDao.findHjmallindGoodsPage(form, curPage, pageSize, false, false).getResult();
    }

    public Page<HjmallindGoods> findHjmallindGoodsPage(HjmallindGoodsForm.Search form, int curPage, int pageSize) {
        return hjmallindGoodsDao.findHjmallindGoodsPage(form, curPage, pageSize, true, false);
    }

    public HjmallindGoods getHjmallindGoods(HjmallindGoodsForm.Get form) {
        return hjmallindGoodsDao.getHjmallindGoods(form);

    }


}

