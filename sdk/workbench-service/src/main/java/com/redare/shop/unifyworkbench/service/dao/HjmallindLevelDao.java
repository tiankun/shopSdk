package com.redare.shop.unifyworkbench.service.dao;

import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.base.SpringJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.HjmallindLevel;
import com.redare.shop.unifyworkbench.sdk.pojo.form.HjmallindLevelForm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 会员等级 DAO
 *
 * @date 2020-12-01 16:56:53
 * Created by tiankun
 */
@Repository
public class HjmallindLevelDao {

    @Autowired
    SpringJdbcHelper jdbcHelper;

    public long addHjmallindLevel(HjmallindLevelForm.Add form) {
        Sql sql = Sql.insert("hjmallind_level")
                .field("storeId", form.getStoreId())
                .field("level", form.getLevel())
                .field("name", form.getName())
                .field("money", form.getMoney())
                .field("discount", form.getDiscount())
                .field("status", form.getStatus())
                .field("isDelete", form.getIsDelete())
                .field("addtime", form.getAddtime())
                .field("image", form.getImage())
                .field("price", form.getPrice())
                .field("detail", form.getDetail())
                .field("buyPrompt", form.getBuyPrompt())
                .field("synopsis", form.getSynopsis())
                .field("createTime", new Date());
        return jdbcHelper.insertReturnFieldNumber(sql).longValue();
    }

    public int[] addHjmallindLevel(List<HjmallindLevelForm.Add> list) {
        if (list == null || list.isEmpty()) {
            return new int[]{};
        }
        Sql sql = Sql.insert("hjmallind_level")
                .fields("storeId", "level", "name", "money", "discount", "status", "isDelete", "addtime", "image", "price", "detail", "buyPrompt", "synopsis", "createTime");
        Date createTime = new Date();
        List<Object[]> params = new ArrayList<>();
        for (HjmallindLevelForm.Add item : list) {
            params.add(new Object[]{item.getStoreId(), item.getLevel(), item.getName(), item.getMoney(), item.getDiscount(), item.getStatus(), item.getIsDelete(), item.getAddtime(), item.getImage(), item.getPrice(), item.getDetail(), item.getBuyPrompt(), item.getSynopsis(), createTime});
        }
        return jdbcHelper.batchUpdate(sql, params);
    }

    public int deleteHjmallindLevel(HjmallindLevelForm.Del form) {
        Sql sql = Sql.delete("hjmallind_level")
                .where().andEq("id", form.getId());
        return jdbcHelper.update(sql.toString(), sql.getParams().toArray());
    }

    public Page<HjmallindLevel> findHjmallindLevelPage(HjmallindLevelForm.Search form, int curPage, int pageSize, boolean calCount, boolean allList) {
        Sql sql = Sql.select()
                .fieldsIf(StringUtils.isNotBlank(form.getQueryFields()), form.getQueryFields())
                .fieldsIf(StringUtils.isBlank(form.getQueryFields()), "*")
                .from("hjmallind_level")
                .where()
                .orderBy().desc("id");
        return jdbcHelper.queryForPageBean(sql.toString(), HjmallindLevel.class, sql.getParams().toArray(), curPage, pageSize, calCount, allList);
    }


    public int editHjmallindLevel(HjmallindLevelForm.Edit form) {
        Sql sql = Sql.update("hjmallind_level")
                .setIfNotNull("storeId", form.getStoreId())
                .setIfNotNull("level", form.getLevel())
                .setIfNotBlank("name", form.getName())
                .setIfNotNull("money", form.getMoney())
                .setIfNotNull("discount", form.getDiscount())
                .setIfNotNull("status", form.getStatus())
                .setIfNotNull("isDelete", form.getIsDelete())
                .setIfNotNull("addtime", form.getAddtime())
                .setIfNotBlank("image", form.getImage())
                .setIfNotNull("price", form.getPrice())
                .setIfNotBlank("detail", form.getDetail())
                .setIfNotBlank("buyPrompt", form.getBuyPrompt())
                .setIfNotBlank("synopsis", form.getSynopsis())
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.update(sql.toString(), sql.getParams().toArray());
    }

    public HjmallindLevel getHjmallindLevel(HjmallindLevelForm.Get form) {
        Sql sql = Sql.select()
                .fieldsIf(StringUtils.isNotBlank(form.getQueryFields()), form.getQueryFields())
                .fieldsIf(StringUtils.isBlank(form.getQueryFields()), "*")
                .from("hjmallind_level")
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.queryForBean(sql.toString(), HjmallindLevel.class, sql.getParams().toArray());
    }


}

