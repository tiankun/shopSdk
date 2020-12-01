package com.redare.shop.unifyworkbench.service.dao;

import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.base.SpringJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.HjmallindOrderDetail;
import com.redare.shop.unifyworkbench.sdk.pojo.form.HjmallindOrderDetailForm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 订单明细 DAO
 *
 * @date 2020-12-01 16:21:41
 * Created by tiankun
 */
@Repository
public class HjmallindOrderDetailDao {

    @Autowired
    SpringJdbcHelper jdbcHelper;

    public long addHjmallindOrderDetail(HjmallindOrderDetailForm.Add form) {
        Sql sql = Sql.insert("hjmallind_order_detail")
                .field("orderId", form.getOrderId())
                .field("goodsId", form.getGoodsId())
                .field("num", form.getNum())
                .field("totalPrice", form.getTotalPrice())
                .field("addtime", form.getAddtime())
                .field("isDelete", form.getIsDelete())
                .field("attr", form.getAttr())
                .field("pic", form.getPic())
                .field("integral", form.getIntegral())
                .field("isLevel", form.getIsLevel())
                .field("createTime", new Date());
        return jdbcHelper.insertReturnFieldNumber(sql).longValue();
    }

    public int[] addHjmallindOrderDetail(List<HjmallindOrderDetailForm.Add> list) {
        if (list == null || list.isEmpty()) {
            return new int[]{};
        }
        Sql sql = Sql.insert("hjmallind_order_detail")
                .fields("orderId", "goodsId", "num", "totalPrice", "addtime", "isDelete", "attr", "pic", "integral", "isLevel", "createTime");
        Date createTime = new Date();
        List<Object[]> params = new ArrayList<>();
        for (HjmallindOrderDetailForm.Add item : list) {
            params.add(new Object[]{item.getOrderId(), item.getGoodsId(), item.getNum(), item.getTotalPrice(), item.getAddtime(), item.getIsDelete(), item.getAttr(), item.getPic(), item.getIntegral(), item.getIsLevel(), createTime});
        }
        return jdbcHelper.batchUpdate(sql, params);
    }

    public int deleteHjmallindOrderDetail(HjmallindOrderDetailForm.Del form) {
        Sql sql = Sql.delete("hjmallind_order_detail")
                .where().andEq("id", form.getId());
        return jdbcHelper.update(sql.toString(), sql.getParams().toArray());
    }

    public Page<HjmallindOrderDetail> findHjmallindOrderDetailPage(HjmallindOrderDetailForm.Search form, int curPage, int pageSize, boolean calCount, boolean allList) {
        Sql sql = Sql.select()
                .fieldsIf(StringUtils.isNotBlank(form.getQueryFields()), form.getQueryFields())
                .fieldsIf(StringUtils.isBlank(form.getQueryFields()), "*")
                .from("hjmallind_order_detail")
                .where()
                .orderBy().desc("id");
        return jdbcHelper.queryForPageBean(sql.toString(), HjmallindOrderDetail.class, sql.getParams().toArray(), curPage, pageSize, calCount, allList);
    }


    public int editHjmallindOrderDetail(HjmallindOrderDetailForm.Edit form) {
        Sql sql = Sql.update("hjmallind_order_detail")
                .setIfNotNull("orderId", form.getOrderId())
                .setIfNotNull("goodsId", form.getGoodsId())
                .setIfNotNull("num", form.getNum())
                .setIfNotNull("totalPrice", form.getTotalPrice())
                .setIfNotNull("addtime", form.getAddtime())
                .setIfNotNull("isDelete", form.getIsDelete())
                .setIfNotBlank("attr", form.getAttr())
                .setIfNotBlank("pic", form.getPic())
                .setIfNotNull("integral", form.getIntegral())
                .setIfNotNull("isLevel", form.getIsLevel())
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.update(sql.toString(), sql.getParams().toArray());
    }

    public HjmallindOrderDetail getHjmallindOrderDetail(HjmallindOrderDetailForm.Get form) {
        Sql sql = Sql.select()
                .fieldsIf(StringUtils.isNotBlank(form.getQueryFields()), form.getQueryFields())
                .fieldsIf(StringUtils.isBlank(form.getQueryFields()), "*")
                .from("hjmallind_order_detail")
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.queryForBean(sql.toString(), HjmallindOrderDetail.class, sql.getParams().toArray());
    }


}

