package com.redare.shop.unifyworkbench.service.dao;

import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.base.SpringJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.HjmallindOrder;
import com.redare.shop.unifyworkbench.sdk.pojo.form.HjmallindOrderForm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 订单表 DAO
 *
 * @date 2020-12-01 16:21:27
 * Created by tiankun
 */
@Repository
public class HjmallindOrderDao {

    @Autowired
    SpringJdbcHelper jdbcHelper;

    public long addHjmallindOrder(HjmallindOrderForm.Add form) {
        Sql sql = Sql.insert("hjmallind_order")
                .field("storeId", form.getStoreId())
                .field("userId", form.getUserId())
                .field("orderNo", form.getOrderNo())
                .field("totalPrice", form.getTotalPrice())
                .field("payPrice", form.getPayPrice())
                .field("expressPrice", form.getExpressPrice())
                .field("name", form.getName())
                .field("mobile", form.getMobile())
                .field("address", form.getAddress())
                .field("remark", form.getRemark())
                .field("isPay", form.getIsPay())
                .field("payType", form.getPayType())
                .field("payTime", form.getPayTime())
                .field("isSend", form.getIsSend())
                .field("sendTime", form.getSendTime())
                .field("express", form.getExpress())
                .field("expressNo", form.getExpressNo())
                .field("isConfirm", form.getIsConfirm())
                .field("confirmTime", form.getConfirmTime())
                .field("isComment", form.getIsComment())
                .field("applyDelete", form.getApplyDelete())
                .field("addtime", form.getAddtime())
                .field("isDelete", form.getIsDelete())
                .field("isPrice", form.getIsPrice())
                .field("parentId", form.getParentId())
                .field("firstPrice", form.getFirstPrice())
                .field("secondPrice", form.getSecondPrice())
                .field("thirdPrice", form.getThirdPrice())
                .field("couponSubPrice", form.getCouponSubPrice())
                .field("content", form.getContent())
                .field("isOffline", form.getIsOffline())
                .field("clerkId", form.getClerkId())
                .field("addressData", form.getAddressData())
                .field("isCancel", form.getIsCancel())
                .field("offlineQrcode", form.getOfflineQrcode())
                .field("beforeUpdatePrice", form.getBeforeUpdatePrice())
                .field("shopId", form.getShopId())
                .field("discount", form.getDiscount())
                .field("userCouponId", form.getUserCouponId())
                .field("integral", form.getIntegral())
                .field("giveIntegral", form.getGiveIntegral())
                .field("parentId1", form.getParentId1())
                .field("parentId2", form.getParentId2())
                .field("isSale", form.getIsSale())
                .field("words", form.getWords())
                .field("version", form.getVersion())
                .field("expressPrice1", form.getExpressPrice1())
                .field("isRecycle", form.getIsRecycle())
                .field("rebate", form.getRebate())
                .field("beforeUpdateExpress", form.getBeforeUpdateExpress())
                .field("sellerComments", form.getSellerComments())
                .field("mchId", form.getMchId())
                .field("orderUnionId", form.getOrderUnionId())
                .field("isTransfer", form.getIsTransfer())
                .field("type", form.getType())
                .field("sharePrice", form.getSharePrice())
                .field("isShow", form.getIsShow())
                .field("currency", form.getCurrency())
                .field("createTime", new Date());
        return jdbcHelper.insertReturnFieldNumber(sql).longValue();
    }

    public int[] addHjmallindOrder(List<HjmallindOrderForm.Add> list) {
        if (list == null || list.isEmpty()) {
            return new int[]{};
        }
        Sql sql = Sql.insert("hjmallind_order")
                .fields("storeId", "userId", "orderNo", "totalPrice", "payPrice", "expressPrice", "name", "mobile", "address", "remark", "isPay", "payType", "payTime", "isSend", "sendTime", "express", "expressNo", "isConfirm", "confirmTime", "isComment", "applyDelete", "addtime", "isDelete", "isPrice", "parentId", "firstPrice", "secondPrice", "thirdPrice", "couponSubPrice", "content", "isOffline", "clerkId", "addressData", "isCancel", "offlineQrcode", "beforeUpdatePrice", "shopId", "discount", "userCouponId", "integral", "giveIntegral", "parentId1", "parentId2", "isSale", "words", "version", "expressPrice1", "isRecycle", "rebate", "beforeUpdateExpress", "sellerComments", "mchId", "orderUnionId", "isTransfer", "type", "sharePrice", "isShow", "currency", "createTime");
        Date createTime = new Date();
        List<Object[]> params = new ArrayList<>();
        for (HjmallindOrderForm.Add item : list) {
            params.add(new Object[]{item.getStoreId(), item.getUserId(), item.getOrderNo(), item.getTotalPrice(), item.getPayPrice(), item.getExpressPrice(), item.getName(), item.getMobile(), item.getAddress(), item.getRemark(), item.getIsPay(), item.getPayType(), item.getPayTime(), item.getIsSend(), item.getSendTime(), item.getExpress(), item.getExpressNo(), item.getIsConfirm(), item.getConfirmTime(), item.getIsComment(), item.getApplyDelete(), item.getAddtime(), item.getIsDelete(), item.getIsPrice(), item.getParentId(), item.getFirstPrice(), item.getSecondPrice(), item.getThirdPrice(), item.getCouponSubPrice(), item.getContent(), item.getIsOffline(), item.getClerkId(), item.getAddressData(), item.getIsCancel(), item.getOfflineQrcode(), item.getBeforeUpdatePrice(), item.getShopId(), item.getDiscount(), item.getUserCouponId(), item.getIntegral(), item.getGiveIntegral(), item.getParentId1(), item.getParentId2(), item.getIsSale(), item.getWords(), item.getVersion(), item.getExpressPrice1(), item.getIsRecycle(), item.getRebate(), item.getBeforeUpdateExpress(), item.getSellerComments(), item.getMchId(), item.getOrderUnionId(), item.getIsTransfer(), item.getType(), item.getSharePrice(), item.getIsShow(), item.getCurrency(), createTime});
        }
        return jdbcHelper.batchUpdate(sql, params);
    }

    public int deleteHjmallindOrder(HjmallindOrderForm.Del form) {
        Sql sql = Sql.delete("hjmallind_order")
                .where().andEq("id", form.getId());
        return jdbcHelper.update(sql.toString(), sql.getParams().toArray());
    }

    public Page<HjmallindOrder> findHjmallindOrderPage(HjmallindOrderForm.Search form, int curPage, int pageSize, boolean calCount, boolean allList) {
        Sql sql = Sql.select()
                .fieldsIf(StringUtils.isNotBlank(form.getQueryFields()), form.getQueryFields())
                .fieldsIf(StringUtils.isBlank(form.getQueryFields()), "*")
                .from("hjmallind_order")
                .where()
                .orderBy().desc("id");
        return jdbcHelper.queryForPageBean(sql.toString(), HjmallindOrder.class, sql.getParams().toArray(), curPage, pageSize, calCount, allList);
    }


    public int editHjmallindOrder(HjmallindOrderForm.Edit form) {
        Sql sql = Sql.update("hjmallind_order")
                .setIfNotNull("storeId", form.getStoreId())
                .setIfNotNull("userId", form.getUserId())
                .setIfNotBlank("orderNo", form.getOrderNo())
                .setIfNotNull("totalPrice", form.getTotalPrice())
                .setIfNotNull("payPrice", form.getPayPrice())
                .setIfNotNull("expressPrice", form.getExpressPrice())
                .setIfNotBlank("name", form.getName())
                .setIfNotBlank("mobile", form.getMobile())
                .setIfNotBlank("address", form.getAddress())
                .setIfNotBlank("remark", form.getRemark())
                .setIfNotNull("isPay", form.getIsPay())
                .setIfNotNull("payType", form.getPayType())
                .setIfNotNull("payTime", form.getPayTime())
                .setIfNotNull("isSend", form.getIsSend())
                .setIfNotNull("sendTime", form.getSendTime())
                .setIfNotBlank("express", form.getExpress())
                .setIfNotBlank("expressNo", form.getExpressNo())
                .setIfNotNull("isConfirm", form.getIsConfirm())
                .setIfNotNull("confirmTime", form.getConfirmTime())
                .setIfNotNull("isComment", form.getIsComment())
                .setIfNotNull("applyDelete", form.getApplyDelete())
                .setIfNotNull("addtime", form.getAddtime())
                .setIfNotNull("isDelete", form.getIsDelete())
                .setIfNotNull("isPrice", form.getIsPrice())
                .setIfNotNull("parentId", form.getParentId())
                .setIfNotNull("firstPrice", form.getFirstPrice())
                .setIfNotNull("secondPrice", form.getSecondPrice())
                .setIfNotNull("thirdPrice", form.getThirdPrice())
                .setIfNotNull("couponSubPrice", form.getCouponSubPrice())
                .setIfNotBlank("content", form.getContent())
                .setIfNotNull("isOffline", form.getIsOffline())
                .setIfNotNull("clerkId", form.getClerkId())
                .setIfNotBlank("addressData", form.getAddressData())
                .setIfNotNull("isCancel", form.getIsCancel())
                .setIfNotBlank("offlineQrcode", form.getOfflineQrcode())
                .setIfNotNull("beforeUpdatePrice", form.getBeforeUpdatePrice())
                .setIfNotNull("shopId", form.getShopId())
                .setIfNotNull("discount", form.getDiscount())
                .setIfNotNull("userCouponId", form.getUserCouponId())
                .setIfNotBlank("integral", form.getIntegral())
                .setIfNotNull("giveIntegral", form.getGiveIntegral())
                .setIfNotNull("parentId1", form.getParentId1())
                .setIfNotNull("parentId2", form.getParentId2())
                .setIfNotNull("isSale", form.getIsSale())
                .setIfNotBlank("words", form.getWords())
                .setIfNotBlank("version", form.getVersion())
                .setIfNotNull("expressPrice1", form.getExpressPrice1())
                .setIfNotNull("isRecycle", form.getIsRecycle())
                .setIfNotNull("rebate", form.getRebate())
                .setIfNotNull("beforeUpdateExpress", form.getBeforeUpdateExpress())
                .setIfNotBlank("sellerComments", form.getSellerComments())
                .setIfNotNull("mchId", form.getMchId())
                .setIfNotNull("orderUnionId", form.getOrderUnionId())
                .setIfNotNull("isTransfer", form.getIsTransfer())
                .setIfNotNull("type", form.getType())
                .setIfNotNull("sharePrice", form.getSharePrice())
                .setIfNotNull("isShow", form.getIsShow())
                .setIfNotNull("currency", form.getCurrency())
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.update(sql.toString(), sql.getParams().toArray());
    }

    public HjmallindOrder getHjmallindOrder(HjmallindOrderForm.Get form) {
        Sql sql = Sql.select()
                .fieldsIf(StringUtils.isNotBlank(form.getQueryFields()), form.getQueryFields())
                .fieldsIf(StringUtils.isBlank(form.getQueryFields()), "*")
                .from("hjmallind_order")
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.queryForBean(sql.toString(), HjmallindOrder.class, sql.getParams().toArray());
    }


}

