package com.redare.shop.unifyworkbench.service.dao;

import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.base.SpringJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.HjmallindGoods;
import com.redare.shop.unifyworkbench.sdk.pojo.form.HjmallindGoodsForm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 商品 DAO
 *
 * @date 2020-12-01 16:20:57
 * Created by tiankun
 */
@Repository
public class HjmallindGoodsDao {

    @Autowired
    SpringJdbcHelper jdbcHelper;

    public long addHjmallindGoods(HjmallindGoodsForm.Add form) {
        Sql sql = Sql.insert("hjmallind_goods")
                .field("storeId", form.getStoreId())
                .field("name", form.getName())
                .field("price", form.getPrice())
                .field("originalPrice", form.getOriginalPrice())
                .field("detail", form.getDetail())
                .field("catId", form.getCatId())
                .field("status", form.getStatus())
                .field("addtime", form.getAddtime())
                .field("isDelete", form.getIsDelete())
                .field("attr", form.getAttr())
                .field("service", form.getService())
                .field("sort", form.getSort())
                .field("virtualSales", form.getVirtualSales())
                .field("coverPic", form.getCoverPic())
                .field("videoUrl", form.getVideoUrl())
                .field("unit", form.getUnit())
                .field("individualShare", form.getIndividualShare())
                .field("shareCommissionFirst", form.getShareCommissionFirst())
                .field("shareCommissionSecond", form.getShareCommissionSecond())
                .field("shareCommissionThird", form.getShareCommissionThird())
                .field("weight", form.getWeight())
                .field("freight", form.getFreight())
                .field("fullCut", form.getFullCut())
                .field("integral", form.getIntegral())
                .field("useAttr", form.getUseAttr())
                .field("shareType", form.getShareType())
                .field("quickPurchase", form.getQuickPurchase())
                .field("hotCakes", form.getHotCakes())
                .field("costPrice", form.getCostPrice())
                .field("memberDiscount", form.getMemberDiscount())
                .field("rebate", form.getRebate())
                .field("mchId", form.getMchId())
                .field("goodsNum", form.getGoodsNum())
                .field("mchSort", form.getMchSort())
                .field("confineCount", form.getConfineCount())
                .field("isLevel", form.getIsLevel())
                .field("type", form.getType())
                .field("isNegotiable", form.getIsNegotiable())
                .field("attrSettingType", form.getAttrSettingType())
                .field("barcode", form.getBarcode())
                .field("createTime", new Date());
        return jdbcHelper.insertReturnFieldNumber(sql).longValue();
    }

    public int[] addHjmallindGoods(List<HjmallindGoodsForm.Add> list) {
        if (list == null || list.isEmpty()) {
            return new int[]{};
        }
        Sql sql = Sql.insert("hjmallind_goods")
                .fields("storeId", "name", "price", "originalPrice", "detail", "catId", "status", "addtime", "isDelete", "attr", "service", "sort", "virtualSales", "coverPic", "videoUrl", "unit", "individualShare", "shareCommissionFirst", "shareCommissionSecond", "shareCommissionThird", "weight", "freight", "fullCut", "integral", "useAttr", "shareType", "quickPurchase", "hotCakes", "costPrice", "memberDiscount", "rebate", "mchId", "goodsNum", "mchSort", "confineCount", "isLevel", "type", "isNegotiable", "attrSettingType", "barcode", "createTime");
        Date createTime = new Date();
        List<Object[]> params = new ArrayList<>();
        for (HjmallindGoodsForm.Add item : list) {
            params.add(new Object[]{item.getStoreId(), item.getName(), item.getPrice(), item.getOriginalPrice(), item.getDetail(), item.getCatId(), item.getStatus(), item.getAddtime(), item.getIsDelete(), item.getAttr(), item.getService(), item.getSort(), item.getVirtualSales(), item.getCoverPic(), item.getVideoUrl(), item.getUnit(), item.getIndividualShare(), item.getShareCommissionFirst(), item.getShareCommissionSecond(), item.getShareCommissionThird(), item.getWeight(), item.getFreight(), item.getFullCut(), item.getIntegral(), item.getUseAttr(), item.getShareType(), item.getQuickPurchase(), item.getHotCakes(), item.getCostPrice(), item.getMemberDiscount(), item.getRebate(), item.getMchId(), item.getGoodsNum(), item.getMchSort(), item.getConfineCount(), item.getIsLevel(), item.getType(), item.getIsNegotiable(), item.getAttrSettingType(), item.getBarcode(), createTime});
        }
        return jdbcHelper.batchUpdate(sql, params);
    }

    public int deleteHjmallindGoods(HjmallindGoodsForm.Del form) {
        Sql sql = Sql.delete("hjmallind_goods")
                .where().andEq("id", form.getId());
        return jdbcHelper.update(sql.toString(), sql.getParams().toArray());
    }

    public Page<HjmallindGoods> findHjmallindGoodsPage(HjmallindGoodsForm.Search form, int curPage, int pageSize, boolean calCount, boolean allList) {
        Sql sql = Sql.select()
                .fieldsIf(StringUtils.isNotBlank(form.getQueryFields()), form.getQueryFields())
                .fieldsIf(StringUtils.isBlank(form.getQueryFields()), "*")
                .from("hjmallind_goods")
                .where()
                .orderBy().desc("id");
        return jdbcHelper.queryForPageBean(sql.toString(), HjmallindGoods.class, sql.getParams().toArray(), curPage, pageSize, calCount, allList);
    }


    public int editHjmallindGoods(HjmallindGoodsForm.Edit form) {
        Sql sql = Sql.update("hjmallind_goods")
                .setIfNotNull("storeId", form.getStoreId())
                .setIfNotBlank("name", form.getName())
                .setIfNotNull("price", form.getPrice())
                .setIfNotNull("originalPrice", form.getOriginalPrice())
                .setIfNotBlank("detail", form.getDetail())
                .setIfNotNull("catId", form.getCatId())
                .setIfNotNull("status", form.getStatus())
                .setIfNotNull("addtime", form.getAddtime())
                .setIfNotNull("isDelete", form.getIsDelete())
                .setIfNotBlank("attr", form.getAttr())
                .setIfNotBlank("service", form.getService())
                .setIfNotNull("sort", form.getSort())
                .setIfNotNull("virtualSales", form.getVirtualSales())
                .setIfNotBlank("coverPic", form.getCoverPic())
                .setIfNotBlank("videoUrl", form.getVideoUrl())
                .setIfNotBlank("unit", form.getUnit())
                .setIfNotNull("individualShare", form.getIndividualShare())
                .setIfNotNull("shareCommissionFirst", form.getShareCommissionFirst())
                .setIfNotNull("shareCommissionSecond", form.getShareCommissionSecond())
                .setIfNotNull("shareCommissionThird", form.getShareCommissionThird())
                .setIfNotNull("weight", form.getWeight())
                .setIfNotNull("freight", form.getFreight())
                .setIfNotBlank("fullCut", form.getFullCut())
                .setIfNotBlank("integral", form.getIntegral())
                .setIfNotNull("useAttr", form.getUseAttr())
                .setIfNotNull("shareType", form.getShareType())
                .setIfNotNull("quickPurchase", form.getQuickPurchase())
                .setIfNotNull("hotCakes", form.getHotCakes())
                .setIfNotNull("costPrice", form.getCostPrice())
                .setIfNotNull("memberDiscount", form.getMemberDiscount())
                .setIfNotNull("rebate", form.getRebate())
                .setIfNotNull("mchId", form.getMchId())
                .setIfNotNull("goodsNum", form.getGoodsNum())
                .setIfNotNull("mchSort", form.getMchSort())
                .setIfNotNull("confineCount", form.getConfineCount())
                .setIfNotNull("isLevel", form.getIsLevel())
                .setIfNotNull("type", form.getType())
                .setIfNotNull("isNegotiable", form.getIsNegotiable())
                .setIfNotNull("attrSettingType", form.getAttrSettingType())
                .setIfNotBlank("barcode", form.getBarcode())
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.update(sql.toString(), sql.getParams().toArray());
    }

    public HjmallindGoods getHjmallindGoods(HjmallindGoodsForm.Get form) {
        Sql sql = Sql.select()
                .fieldsIf(StringUtils.isNotBlank(form.getQueryFields()), form.getQueryFields())
                .fieldsIf(StringUtils.isBlank(form.getQueryFields()), "*")
                .from("hjmallind_goods")
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.queryForBean(sql.toString(), HjmallindGoods.class, sql.getParams().toArray());
    }


}

