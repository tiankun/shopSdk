package com.redare.shop.unifyworkbench.service.dao;

import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.BaseSql;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.MySqlJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.PendingItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 待办事项
 */
@Repository
public class PendingItemDao {

    @Autowired
    MySqlJdbcHelper jdbcHelper;
    /**
     * 分页查询待办列表
     * @param form
     * @param curPage
     * @param pageSize
     * @param calCount
     * @param allList
     * @return
     */
    public Page<PendingItem> queryPendingItemPage(PendingItem form,int curPage, int pageSize, boolean calCount, boolean allList){
        Sql[] unionSqlArr = new Sql[2];
        unionSqlArr[0] = Sql.select()
                .field("t1.id")
                .field("t1.title")
                .field("t1.orgName","publishOrg")
                .field("t1.reportTime","publishTime")
                .field("'report'","type")
                .field("t2.createTime")
                .field("IFNULL(t0.readed,0)","readed")
                .from("t_report","t1")
                .join("t_report_handle_record","t2").on("t1.id","t2.reportId")
                .leftJoin(Sql.sql("select DISTINCT readed,bizId from t_user_message where msgType = 'gtasks' and bizTable = 't_report' and readed = 1"),"t0")
                .on("t1.id","t0.bizId")
                .where()
                .andEq("t2.handleState",0)
                .andEqIfNotBlank("t2.handleOrgId",form.getOrgId());
        unionSqlArr[1] = Sql.select()
                .field("t3.id")
                .field("t3.title")
                .field("t3.assignOrgName","publishOrg")
                .field("t3.assignTime","publishTime")
                .field("'assign'","type")
                .field("t4.createTime")
                .field("IFNULL(t0.readed,0)","readed")
                .from("t_assign","t3")
                .join("t_assign_handle_info","t4").on("t3.id","t4.assignId")
                .leftJoin(Sql.sql("select DISTINCT readed,bizId from t_user_message where msgType = 'gtasks' and bizTable = 't_assign' and readed = 1"),"t0")
                .on("t3.id","t0.bizId")
                .where()
                .andEq("t4.assignStatus", 0)
                .andEqIfNotBlank("t4.handleOrgId",form.getOrgId());
        BaseSql baseSql = Sql.unionAll(unionSqlArr);
        Sql sql = Sql.select()
                .field("id")
                .field("title")
                .field("publishOrg")
                .field("publishTime")
                .field("type")
                .field("readed")
                .from(baseSql,"v")
                .orderBy().desc("createTime");
        return jdbcHelper.queryForPageBean(sql.getSql().toString(),PendingItem.class,sql.getParams().toArray(),curPage,pageSize,calCount,allList);
    }

    /**
     * 已办列表
     * @param form
     * @param curPage
     * @param pageSize
     * @param calCount
     * @param allList
     * @return
     */
    public Page<PendingItem> queryHandledItemPage(PendingItem form,int curPage, int pageSize, boolean calCount, boolean allList){
        Sql[] unionSqlArr = new Sql[2];
        unionSqlArr[0] = Sql.select()
                .field("t1.id")
                .field("t1.title")
                .field("t1.orgName","publishOrg")
                .field("t1.reportTime","publishTime")
                .field("'report'","type")
                .field("t2.createTime")
                .from("t_report","t1")
                .join("t_report_handle_record","t2").on("t1.id","t2.reportId")
                .where()
                .andNotEq("t2.handleState",0)
                .andEqIfNotBlank("t2.handleOrgId",form.getOrgId());
        unionSqlArr[1] = Sql.select()
                .field("t3.id")
                .field("t3.title")
                .field("t3.assignOrgName","publishOrg")
                .field("t3.assignTime","publishTime")
                .field("'assign'","type")
                .field("t4.createTime")
                .from("t_assign","t3")
                .join("t_assign_handle_info","t4").on("t3.id","t4.assignId")
                .where()
                .andNotEq("t4.assignStatus", 0)
                .andEqIfNotBlank("t4.handleOrgId",form.getOrgId());
        BaseSql baseSql = Sql.unionAll(unionSqlArr);
        Sql sql = Sql.select()
                .field("id")
                .field("title")
                .field("publishOrg")
                .field("publishTime")
                .field("type")
                .from(baseSql,"v")
                .orderBy().desc("createTime");
        return jdbcHelper.queryForPageBean(sql.getSql().toString(),PendingItem.class,sql.getParams().toArray(),curPage,pageSize,calCount,allList);
    }



    /**
     * 统计数量
     * @param form
     * @return
     */
    public PendingItem queryItemCount(PendingItem form){
        Sql[] unionSqlArr = new Sql[2];
        unionSqlArr[0] = Sql.select()
                .field("count(DISTINCT t2.id )","todoCount")
                .field("0","overtimeCount")
                .field("count(DISTINCT t3.id )","doneCount")
                .field("count(DISTINCT t4.id )","totalCount")
                .field("count(DISTINCT t5.id)","handleCount")
                .from("t_report","t1")
                .leftJoin("t_report_handle_record","t2").on("t1.id","t2.reportId")
                .and(Sql.sql("t2.handleState = 0")).and(Sql.sql("t2.handleOrgId = ?",form.getOrgId()))
                .leftJoin("t_report_handle_record","t3").on("t1.id","t3.reportId")
                .and(Sql.sql("t3.handleState = 2")).and(Sql.sql("t3.handleOrgId = ?",form.getOrgId()))
                .leftJoin("t_report_handle_record","t4").on("t1.id","t4.reportId")
                .and(Sql.sql("t4.handleOrgId = ?",form.getOrgId()))
                .leftJoin("t_report_handle_record","t5").on("t1.id","t5.reportId")
                .and(Sql.sql("t5.handleState <> 0")).and(Sql.sql("t5.handleOrgId = ?",form.getOrgId()));
        unionSqlArr[1] = Sql.select()
                .field("count(DISTINCT t2.id )","todoCount")
                .field("count(DISTINCT t3.id )","overtimeCount")
                .field("count(DISTINCT t4.id )","doneCount")
                .field("count(DISTINCT t5.id )","totalCount")
                .field("count(DISTINCT t6.id)","handleCount")
                .from("t_assign","t1")
                .leftJoin("t_assign_handle_info","t2").on("t1.id","t2.assignId")
                .and(Sql.sql("t2.assignStatus =0")).and(Sql.sql("t2.handleOrgId = ?",form.getOrgId()))
                .leftJoin("t_assign_handle_info","t3").on("t1.id","t3.assignId")
                .and(Sql.sql("t3.planEndDate < NOW()")).and(Sql.sql("t3.handleOrgId = ?",form.getOrgId()))
                .leftJoin("t_assign_handle_info","t4").on("t1.id","t4.assignId")
                .and(Sql.sql("t4.assignStatus = 2")).and(Sql.sql("t4.handleOrgId = ?",form.getOrgId()))
                .leftJoin("t_assign_handle_info","t5").on("t1.id","t5.assignId")
                .and(Sql.sql("t5.handleOrgId = ?",form.getOrgId()))
                .leftJoin("t_assign_handle_info","t6").on("t1.id","t6.assignId")
                .and(Sql.sql("t6.assignStatus <>0")).and(Sql.sql("t6.handleOrgId = ?",form.getOrgId()));
        BaseSql baseSql = Sql.unionAll(unionSqlArr);
        Sql sql = Sql.select()
                .field("sum(todoCount)","todoCount")
                .field("sum(overtimeCount)","overtimeCount")
                .field("sum(doneCount)","doneCount")
                .field("sum(totalCount)","totalCount")
                .field("sum(handleCount)","handleCount")
                .from(baseSql,"v");
        return jdbcHelper.queryForBean(sql.getSql().toString(),PendingItem.class,sql.getParams().toArray());
    }
}
