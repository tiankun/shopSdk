package com.redare.shop.unifyworkbench.service.dao;


import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.TreeMysql;
import com.redare.devframework.sql.db.MySqlJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.common.pojo.BaseLevelTreeQuery;
import com.redare.shop.unifyworkbench.sdk.pojo.Area;
import com.redare.shop.unifyworkbench.sdk.pojo.form.AreaForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 行政区域编码表(Area)表数据库访问层
 *
 * @author yanggr
 * @since 2020-10-21 15:05:54
 */
@Repository
public class AreaDao {
    private static final String TABLE = "t_area";
    @Autowired
    MySqlJdbcHelper jdbcHelper;

    public long insertArea(Area form) {
        Sql sql = Sql.insert(TABLE)
                .field("areaCode", form.getAreaCode())
                .field("areaName", form.getAreaName())
                .field("parentCode", form.getParentCode())
                .field("level", form.getLevel())
                .field("leaf", form.getLeaf())
                .field("sort", form.getSort())
                .field("areaManageUserIdList", form.getAreaManageUserIdList())
                .field("areaIdTag", form.getAreaIdTag())
                .field("areaIdLevel", form.getAreaIdLevel())
                .field("areaNameLevel", form.getAreaNameLevel());
        return jdbcHelper.insertReturnFieldNumber(sql).longValue();
    }

    public Page<Area> queryForPageArea(AreaForm.Search form, int curPage, int pageSize, boolean calCount, boolean allList) {
        Sql sql = Sql.select()
                .field("id")
                .field("areaCode")
                .field("areaName")
                .field("parentCode")
                .field("level")
                .field("leaf")
                .field("sort")
                .field("areaManageUserIdList")
                .field("areaIdTag")
                .field("areaIdLevel")
                .field("areaNameLevel")
                .from(TABLE)
                .where()
                .andBetweenOptionIf(form.getBeginTime() != null && form.getEndTime() != null, "createTime", form.getBeginTime(), form.getEndTime())
                .andBlikeJoinByOrIfNotBlank(form.getKey(), "paperName", "journalTitle", "copyrightOwner", "author")
                .orderBy().desc("id");
        return jdbcHelper.queryForPageBean(sql.getSql().toString(), Area.class, sql.getParams().toArray(), curPage, pageSize, calCount, allList);
    }

    public List<Area> queryForListArea(AreaForm.Search form) {
        Sql sql = Sql.select()
                .field("id")
                .field("areaCode")
                .field("areaName")
                .field("parentCode")
                .field("level")
                .field("leaf")
                .field("sort")
                .field("areaManageUserIdList")
                .field("areaIdTag")
                .field("areaIdLevel")
                .field("areaNameLevel")
                .from(TABLE)
                .where()
                .andEqIfNotNull("id", form.getId())
                .andEqIfNotNull("level", form.getLevel())
                .andBetweenOptionIf(form.getBeginTime() != null && form.getEndTime() != null, "awardTime", form.getBeginTime(), form.getEndTime())
                .andEqIfNotBlank("areaCode",form.getAreaCode())
                .andNotEq("id",0)
                .orderBy().desc("id");
        return jdbcHelper.queryForListBean(sql.getSql().toString(), Area.class, sql.getParams().toArray());
    }

    public int updateArea(Area form) {
        Sql sql = Sql.update(TABLE)
                .setIfNotBlank("areaCode", form.getAreaCode())
                .setIfNotBlank("areaName", form.getAreaName())
                .setIfNotBlank("parentCode", form.getParentCode())
                .setIfNotNull("level", form.getLevel())
                .setIfNotNull("leaf", form.getLeaf())
                .setIfNotNull("sort", form.getSort())
                .setIfNotBlank("areaManageUserIdList", form.getAreaManageUserIdList())
                .setIfNotBlank("areaIdTag", form.getAreaIdTag())
                .setIfNotBlank("areaIdLevel", form.getAreaIdLevel())
                .setIfNotBlank("areaNameLevel", form.getAreaNameLevel())
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.update(sql);
    }

    public int deleteArea(CommonForm.Del form) {
        Sql sql = Sql.delete(TABLE)
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.update(sql);
    }

    public int batchDelArea(CommonForm.BatchDel form) {
        Sql sql = Sql.delete(TABLE)
                .where()
                .andIn("id", form.getIds());
        return jdbcHelper.update(sql);
    }

    public List<TreeNode> queryAreaTreeNode(BaseLevelTreeQuery form) {
        Sql sql = Sql.select()
                .field("areaCode","`key`")
                .field("areaCode","`value`")
                .field("areaName","title")
                .field("parentCode","parentId")
                .field("leaf","isLeaf")
                .field("level","level")
                .field("areaIdLevel","idLevel")
                .field("areaNameLevel","nameLevel")
                .from("t_area", "a")
                .where()
                .andIfNotNull(true, () -> {
                    return TreeMysql.tree(
                            form.getLevelId(),
                            form.isUp(),
                            "t_area",
                            "areaIdLevel",
                            "areaCode",
                            form.getLevelNum(),
                            //selectWhere -> selectWhere.andEq("del", 0),
                            form.isLevelNumOnly(),
                            form.isIncSelf());
                });

        List<TreeNode> list = jdbcHelper.queryForListBean(sql, TreeNode.class);
        return list;
    }

    public List<Area> queryAreaOrgList(AreaForm.Search form){
        Sql sql = Sql.select()
                .field("t1.areaCode")
                .field("t1.areaName")
                .field("t1.parentCode")
                .field("t1.level")
                .field("t1.areaIdLevel")
                .field("t2.orgId")
                .field("t2.orgName")
                .field("t2.orgTypeCode")
                .field("t2.orgTypeName")
                .from(TABLE,"t1")
                .leftJoin("t_organization","t2").on("t1.areaCode","t2.areaCode").and(Sql.sql("t2.status=1"))
                .where()
                .andEqIfNotBlank("t1.areaCode",form.getAreaCode())
                .andEqIfNotBlank("t1.parentCode",form.getParentCode())
                .andEqIfNotBlank("t2.orgClassify",form.getOrgClassify())
                .orderBy().asc("t1.areaCode");
        return jdbcHelper.queryForListBean(sql.getSql().toString(),Area.class,sql.getParams().toArray());
    }

    public Area queryArea(AreaForm.Get form){
        Sql sql = Sql.select()
                .from(TABLE)
                .where()
                .andEqIfNotNull("id",form.getId())
                .andEqIfNotBlank("areaCode",form.getAreaCode());
        return jdbcHelper.queryForBean(sql.getSql().toString(),Area.class,sql.getParams().toArray());
    }

    /**
     * @description 根据区域code查询下级区域信息
     * @author zlx
     * @date 2020/11/14 13:22
     * @param areaCode
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.Area>
     */
    public List<Area> findNextAreaByParentCode(String areaCode){
        Sql sql = Sql.select()
                .from(TABLE)
                .where()
                .andEq("parentCode",areaCode);
        return jdbcHelper.queryForListBean(sql.getSql().toString(),Area.class,sql.getParams().toArray());
    }
}
