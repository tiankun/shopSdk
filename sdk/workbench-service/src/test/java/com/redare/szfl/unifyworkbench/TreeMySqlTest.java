package com.redare.shop.unifyworkbench;

import com.redare.devframework.common.pojo.LevelTreeQuery;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.TreeMysql;

/**
 * @Author: yanggr
 * @Date: 2020/6/30 14:14
 */
public class TreeMySqlTest   {
    public static void main(String[] args) {
        final Sql selectWhere1 =  Sql.sql("select * from ");
        Sql sql = Sql.select()
                .field("a.*")
                .from("base_dictionary", "a")

                .where()

                .andIfNotNull(true, () -> {
                    LevelTreeQuery level = new LevelTreeQuery();
                    level.setLevelId(8);
                    level.setUp(false);

                    level.setIncSelf(true);
                    level.setLevelNum(2);
                    level.setLevelNumOnly(true);


                    return TreeMysql.tree(
                            level.getLevelId(),
                            level.isUp(),
                            "base_dictionary",
                            "a.parentId",
                            "a.id",
                            level.getLevelNum(),
                            selectWhere -> selectWhere.andEq("del", 0),
                            level.isLevelNumOnly(),
                            level.isIncSelf());
                });
//                .orderBy().desc("a.sort").asc("a.id");
        System.out.println(sql.getSql());
    }


}
