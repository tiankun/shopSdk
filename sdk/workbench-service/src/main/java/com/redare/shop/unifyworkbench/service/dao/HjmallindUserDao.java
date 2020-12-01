package com.redare.shop.unifyworkbench.service.dao;

import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.base.SpringJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.HjmallindUser;
import com.redare.shop.unifyworkbench.sdk.pojo.form.HjmallindUserForm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 用户 DAO
 *
 * @date 2020-12-01 15:53:13
 * Created by tiankun
 */
@Repository
public class HjmallindUserDao {

    @Autowired
    SpringJdbcHelper jdbcHelper;

    public long addHjmallindUser(HjmallindUserForm.Add form) {
        Sql sql = Sql.insert("hjmallind_user")
                .field("type", form.getType())
                .field("username", form.getUsername())
                .field("password", form.getPassword())
                .field("authKey", form.getAuthKey())
                .field("accessToken", form.getAccessToken())
                .field("addtime", form.getAddtime())
                .field("isDelete", form.getIsDelete())
                .field("wechatOpenId", form.getWechatOpenId())
                .field("wechatUnionId", form.getWechatUnionId())
                .field("nickname", form.getNickname())
                .field("avatarUrl", form.getAvatarUrl())
                .field("storeId", form.getStoreId())
                .field("isDistributor", form.getIsDistributor())
                .field("parentId", form.getParentId())
                .field("time", form.getTime())
                .field("totalPrice", form.getTotalPrice())
                .field("price", form.getPrice())
                .field("isClerk", form.getIsClerk())
                .field("we7Uid", form.getWe7Uid())
                .field("shopId", form.getShopId())
                .field("level", form.getLevel())
                .field("integral", form.getIntegral())
                .field("totalIntegral", form.getTotalIntegral())
                .field("money", form.getMoney())
                .field("contactWay", form.getContactWay())
                .field("comments", form.getComments())
                .field("binding", form.getBinding())
                .field("wechatPlatformOpenId", form.getWechatPlatformOpenId())
                .field("platform", form.getPlatform())
                .field("blacklist", form.getBlacklist())
                .field("parentUserId", form.getParentUserId())
                .field("createTime", new Date());
        return jdbcHelper.insertReturnFieldNumber(sql).longValue();
    }

    public int[] addHjmallindUser(List<HjmallindUserForm.Add> list) {
        if (list == null || list.isEmpty()) {
            return new int[]{};
        }
        Sql sql = Sql.insert("hjmallind_user")
                .fields("type", "username", "password", "authKey", "accessToken", "addtime", "isDelete", "wechatOpenId", "wechatUnionId", "nickname", "avatarUrl", "storeId", "isDistributor", "parentId", "time", "totalPrice", "price", "isClerk", "we7Uid", "shopId", "level", "integral", "totalIntegral", "money", "contactWay", "comments", "binding", "wechatPlatformOpenId", "platform", "blacklist", "parentUserId", "createTime");
        Date createTime = new Date();
        List<Object[]> params = new ArrayList<>();
        for (HjmallindUserForm.Add item : list) {
            params.add(new Object[]{item.getType(), item.getUsername(), item.getPassword(), item.getAuthKey(), item.getAccessToken(), item.getAddtime(), item.getIsDelete(), item.getWechatOpenId(), item.getWechatUnionId(), item.getNickname(), item.getAvatarUrl(), item.getStoreId(), item.getIsDistributor(), item.getParentId(), item.getTime(), item.getTotalPrice(), item.getPrice(), item.getIsClerk(), item.getWe7Uid(), item.getShopId(), item.getLevel(), item.getIntegral(), item.getTotalIntegral(), item.getMoney(), item.getContactWay(), item.getComments(), item.getBinding(), item.getWechatPlatformOpenId(), item.getPlatform(), item.getBlacklist(), item.getParentUserId(), createTime});
        }
        return jdbcHelper.batchUpdate(sql, params);
    }

    public int deleteHjmallindUser(HjmallindUserForm.Del form) {
        Sql sql = Sql.delete("hjmallind_user")
                .where().andEq("id", form.getId());
        return jdbcHelper.update(sql.toString(), sql.getParams().toArray());
    }

    public Page<HjmallindUser> findHjmallindUserPage(HjmallindUserForm.Search form, int curPage, int pageSize, boolean calCount, boolean allList) {
        Sql sql = Sql.select()
                .fieldsIf(StringUtils.isNotBlank(form.getQueryFields()), form.getQueryFields())
                .fieldsIf(StringUtils.isBlank(form.getQueryFields()), "*")
                .from("hjmallind_user")
                .where()
                .orderBy().desc("id");
        return jdbcHelper.queryForPageBean(sql.toString(), HjmallindUser.class, sql.getParams().toArray(), curPage, pageSize, calCount, allList);
    }


    public int editHjmallindUser(HjmallindUserForm.Edit form) {
        Sql sql = Sql.update("hjmallind_user")
                .setIfNotNull("type", form.getType())
                .setIfNotBlank("username", form.getUsername())
                .setIfNotBlank("password", form.getPassword())
                .setIfNotBlank("authKey", form.getAuthKey())
                .setIfNotBlank("accessToken", form.getAccessToken())
                .setIfNotNull("addtime", form.getAddtime())
                .setIfNotNull("isDelete", form.getIsDelete())
                .setIfNotBlank("wechatOpenId", form.getWechatOpenId())
                .setIfNotBlank("wechatUnionId", form.getWechatUnionId())
                .setIfNotBlank("nickname", form.getNickname())
                .setIfNotBlank("avatarUrl", form.getAvatarUrl())
                .setIfNotNull("storeId", form.getStoreId())
                .setIfNotNull("isDistributor", form.getIsDistributor())
                .setIfNotNull("parentId", form.getParentId())
                .setIfNotNull("time", form.getTime())
                .setIfNotNull("totalPrice", form.getTotalPrice())
                .setIfNotNull("price", form.getPrice())
                .setIfNotNull("isClerk", form.getIsClerk())
                .setIfNotNull("we7Uid", form.getWe7Uid())
                .setIfNotNull("shopId", form.getShopId())
                .setIfNotNull("level", form.getLevel())
                .setIfNotNull("integral", form.getIntegral())
                .setIfNotNull("totalIntegral", form.getTotalIntegral())
                .setIfNotNull("money", form.getMoney())
                .setIfNotBlank("contactWay", form.getContactWay())
                .setIfNotBlank("comments", form.getComments())
                .setIfNotBlank("binding", form.getBinding())
                .setIfNotBlank("wechatPlatformOpenId", form.getWechatPlatformOpenId())
                .setIfNotNull("platform", form.getPlatform())
                .setIfNotNull("blacklist", form.getBlacklist())
                .setIfNotNull("parentUserId", form.getParentUserId())
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.update(sql.toString(), sql.getParams().toArray());
    }

    public HjmallindUser getHjmallindUser(HjmallindUserForm.Get form) {
        Sql sql = Sql.select()
                .fieldsIf(StringUtils.isNotBlank(form.getQueryFields()), form.getQueryFields())
                .fieldsIf(StringUtils.isBlank(form.getQueryFields()), "*")
                .from("hjmallind_user")
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.queryForBean(sql.toString(), HjmallindUser.class, sql.getParams().toArray());
    }


}

