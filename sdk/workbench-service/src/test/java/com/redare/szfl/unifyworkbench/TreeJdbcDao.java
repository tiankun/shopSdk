package com.redare.shop.unifyworkbench;

import com.redare.devframework.common.pojo.LevelTreeQuery;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.TreeMysql;
import com.redare.shop.unifyworkbench.sdk.pojo.form.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @Author: guangrongyang
 * @Date: 2020/10/19 16:37
 */

public class TreeJdbcDao extends AbstractJUnitConfig {
    @Test
    public void testTreeMySql() {
        //id
        final String levelId = "177";
        final String levelsField = "parentId";
        String levelIdField = "id";
        Sql sql = Sql.select()
                .field("a.*")
                .from("base_dictionary", "a")

                .where()

                .andIfNotNull(true, () -> {
                    LevelTreeQuery level = new LevelTreeQuery();
                    level.setLevelId(levelId);
                    level.setUp(false);

                    level.setIncSelf(true);
                    level.setLevelNum(0);
                    level.setLevelNumOnly(true);


                    return TreeMysql.tree(
                            level.getLevelId(),
                            level.isUp(),
                            "base_dictionary",
                            "parentId",
                            "id",
                            level.getLevelNum(),
                            selectWhere -> selectWhere.andEq("del", 0),
                            level.isLevelNumOnly(),
                            level.isIncSelf());
                });

        List<Map<String, Object>> list = jdbcHelper.queryForListMap(sql.getSql().toString(), sql.getParams().toArray());

        //新包装的返回值
        List<Map> result = new ArrayList<>();
        if (list.isEmpty()){
            return;
        }
        //包含root节点
        if (true) {
            //默认ID排序asc
            final Map map = list.get(0);
            final String pId = String.valueOf(map.get(levelIdField));
            map.put("childs", getChilds(pId,list,levelsField, levelIdField));

            result.add(map);
        } else {
            result.addAll(getChilds(levelId, list,levelsField,levelIdField));
        }
    }
    @Test
    public void testTreeMySql2() {
        //id
        final String levelId = "530000";
        final String levelsField = "parentId";
        String levelIdField = "id";

        LevelTreeQuery level = new LevelTreeQuery();
        level.setLevelId("530000");
        level.setUp(false);

        level.setIncSelf(true);
        level.setLevelNum(2);
        level.setLevelNumOnly(true);
        Sql sql = Sql.select()
                .field("areaCode","`key`")
                .field("areaName","title")
                .field("parentCode","parentId")
                .from("t_area", "a")

                .where()

                .andIfNotNull(true, () -> {



                    return TreeMysql.tree(
                            level.getLevelId(),
                            level.isUp(),
                            "t_area",
                            "parentCode",
                            "areaCode",
                            level.getLevelNum(),
                            selectWhere -> selectWhere.andEq("del", 0),
                            level.isLevelNumOnly(),
                            level.isIncSelf());
                });

        System.out.println(sql.debugSql());
        List<TreeNode> list = jdbcHelper.queryForListBean(sql, TreeNode.class);
        System.out.println(list);


    }

    /**
     * 根据父节点获取孩子节点
     *
     * @param pId
     * @param list
     * @param levelIdField
     * @return
     */
    public Collection<? extends Map> getChilds(String pId, List<Map<String, Object>> list, String parentIdField, String levelIdField) {
        List<Map> result = new ArrayList<>();

        final Iterator<Map<String, Object>> iterator = list.iterator();
        while (iterator.hasNext()) {
            final Map map = iterator.next();
            //id
            if (String.valueOf(map.get(parentIdField)).equals(pId)) {
                map.put("childs", getChilds(String.valueOf(map.get(levelIdField)), list,parentIdField, levelIdField));
                result.add(map);
            }
        }
        return result;
    }

    /**
     * 根据孩子节点获取父节点
     * @param pId
     * @param list
     * @param levelIdField
     * @return
     */
    private Collection<? extends Map> getParents(String pId, List<Map<String, Object>> list, String parentIdField, String levelIdField) {
        List<Map> result = new ArrayList<>();

        final Iterator<Map<String, Object>> iterator = list.iterator();
        while (iterator.hasNext()) {
            final Map map = iterator.next();
            //id
            if (String.valueOf(map.get(parentIdField)).equals(pId)) {
                map.put("childs", getChilds(String.valueOf(map.get(levelIdField)), list,parentIdField, levelIdField));
                result.add(map);
            }
        }
        return result;
    }
}
