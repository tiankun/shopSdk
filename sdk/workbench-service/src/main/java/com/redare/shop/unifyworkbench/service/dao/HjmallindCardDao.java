package com.redare.shop.unifyworkbench.service.dao;

import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.base.SpringJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.HjmallindCard;
import com.redare.shop.unifyworkbench.sdk.pojo.form.HjmallindCardForm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * DAO
 *
 * @date 2020-12-01 13:50:14
 * Created by tiankun
 */
@Repository
public class HjmallindCardDao {

    @Autowired
    SpringJdbcHelper jdbcHelper;

    public long addHjmallindCard(HjmallindCardForm.Add form) {
        Sql sql = Sql.insert("hjmallind_card")
                .field("storeId", form.getStoreId())
                .field("name", form.getName())
                .field("picUrl", form.getPicUrl())
                .field("content", form.getContent())
                .field("isDelete", form.getIsDelete())
                .field("addtime", form.getAddtime())
                .field("createTime", new Date());
        return jdbcHelper.insertReturnFieldNumber(sql).longValue();
    }

    public int[] addHjmallindCard(List<HjmallindCardForm.Add> list) {
        if (list == null || list.isEmpty()) {
            return new int[]{};
        }
        Sql sql = Sql.insert("hjmallind_card")
                .fields("storeId", "name", "picUrl", "content", "isDelete", "addtime", "createTime");
        Date createTime = new Date();
        List<Object[]> params = new ArrayList<>();
        for (HjmallindCardForm.Add item : list) {
            params.add(new Object[]{item.getStoreId(), item.getName(), item.getPicUrl(), item.getContent(), item.getIsDelete(), item.getAddtime(), createTime});
        }
        return jdbcHelper.batchUpdate(sql, params);
    }

    public int deleteHjmallindCard(HjmallindCardForm.Del form) {
        Sql sql = Sql.delete("hjmallind_card")
                .where().andEq("id", form.getId());
        return jdbcHelper.update(sql.toString(), sql.getParams().toArray());
    }

    public Page<HjmallindCard> findHjmallindCardPage(HjmallindCardForm.Search form, int curPage, int pageSize, boolean calCount, boolean allList) {
        Sql sql = Sql.select()
                .fieldsIf(StringUtils.isNotBlank(form.getQueryFields()), form.getQueryFields())
                .fieldsIf(StringUtils.isBlank(form.getQueryFields()), "*")
                .from("hjmallind_card")
                .where()
                .orderBy().desc("id");
        return jdbcHelper.queryForPageBean(sql.toString(), HjmallindCard.class, sql.getParams().toArray(), curPage, pageSize, calCount, allList);
    }


    public int editHjmallindCard(HjmallindCardForm.Edit form) {
        Sql sql = Sql.update("hjmallind_card")
                .setIfNotNull("storeId", form.getStoreId())
                .setIfNotBlank("name", form.getName())
                .setIfNotBlank("picUrl", form.getPicUrl())
                .setIfNotBlank("content", form.getContent())
                .setIfNotNull("isDelete", form.getIsDelete())
                .setIfNotNull("addtime", form.getAddtime())
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.update(sql.toString(), sql.getParams().toArray());
    }

    public HjmallindCard getHjmallindCard(HjmallindCardForm.Get form) {
        Sql sql = Sql.select()
                .fieldsIf(StringUtils.isNotBlank(form.getQueryFields()), form.getQueryFields())
                .fieldsIf(StringUtils.isBlank(form.getQueryFields()), "*")
                .from("hjmallind_card")
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.queryForBean(sql.toString(), HjmallindCard.class, sql.getParams().toArray());
    }


}

