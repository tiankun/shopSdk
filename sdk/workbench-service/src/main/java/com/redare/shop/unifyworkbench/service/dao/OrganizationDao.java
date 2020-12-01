package com.redare.shop.unifyworkbench.service.dao;


import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.TreeMysql;
import com.redare.devframework.sql.db.base.SpringJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.Organization;
import com.redare.shop.unifyworkbench.sdk.pojo.OrganizationStatistics;
import com.redare.shop.unifyworkbench.sdk.pojo.form.OrganizationForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 组织机构表(Organization)表数据库访问层
 *
 * @author zlx
 * @since 2020-10-16 11:58:33
 */
@Repository
public class OrganizationDao {
    private static final String TABLE = "t_organization";

    @Autowired
    SpringJdbcHelper springJdbcHelper;

    /**
     * @description 分页查询
     * @author zlx
     * @date 2020/10/16 14:36
     * @param form
     * @param curPage
     * @param pageSize
     * @param calCount
     * @param allList
     * @return com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.Organization>
     */
    public Page<Organization> findOrganizationPage(OrganizationForm.Search form, int curPage, int pageSize, boolean calCount, boolean allList) {
        Sql sql = Sql.select()
                .field("id")
                .field("orgId")
                .field("orgName")
                .field("shortName")
                .field("areaCode")
                .field("areaLevel")
                .field("areaName")
                .field("orgClassify")
                .field("orgTypeCode")
                .field("orgTypeName")
                .field("orgIntroduce")
                .field("chairman")
                .field("contact")
                .field("telephone")
                .field("parentId")
                .field("level")
                .field("isLeaf")
                .field("remark")
                .field("orgManageUserIdList")
                .field("orgIdTag")
                .field("orgIdLevel")
                .field("orgNameLevel")
                .field("userId")
                .field("userName")
                .field("createTime")
                .field("updateTime")
                .field("status")
                .from(TABLE)
                .where()
                .andInIf(form.getBaseLevelTreeQuery() != null,"areaCode",Sql.select().field("a.areaCode").from("t_area","a")
                        .where()
                        .andIfNotNull(form.getBaseLevelTreeQuery(),()->{
                            return TreeMysql.tree(
                                    form.getBaseLevelTreeQuery().getLevelId(),
                                    form.getBaseLevelTreeQuery().isUp(),
                                    "t_area",
                                    "areaIdLevel",
                                    "areaCode",
                                    form.getBaseLevelTreeQuery().getLevelNum(),
                                    //selectWhere -> selectWhere.andEq("del", 0),
                                    form.getBaseLevelTreeQuery().isLevelNumOnly(),
                                    form.getBaseLevelTreeQuery().isIncSelf());
                        })
                )
                .andBlikeJoinByOrIfNotBlank(form.getKey(), "orgName", "shortName", "areaCode", "areaName","orgTypeName","contact")
                .andEqIfNotBlank("orgId",form.getOrgId())
                .andEqIfNotBlank("areaCode",form.getAreaCode())
                .andInIfNotEmpty("areaCode",form.getAreaCodes())
                .andEqIfNotBlank("orgClassify",form.getOrgClassify())
                .andEqIfNotNull("status",form.getStatus())
                .andInIfNotEmpty("orgId",form.getOrgIds())
                .andInIfNotEmpty("orgTypeCode",form.getOrgTypeCodeList())
                .orderBy().asc("areaCode").asc("id");
        return springJdbcHelper.queryForPageBean(sql.getSql().toString(), Organization.class, sql.getParams().toArray(), curPage, pageSize, calCount, allList);
    }

    /**
     * @description 根据主键id或orgId查询数据
     * @author zlx
     * @date 2020/10/16 14:36
     * @param form
     * @return com.redare.shop.unifyworkbench.sdk.pojo.Organization
     */
    public Organization findOrganization(OrganizationForm.Get form){
        Sql sql = Sql.select()
                .from(TABLE)
                .where()
                .andEqIfNotNull("id",form.getId())
                .andEqIfNotBlank("orgId",form.getOrgId());
        return springJdbcHelper.queryForBean(sql.getSql().toString(),Organization.class,sql.getParams().toArray());
    }

    /**
     * @description 添加数据
     * @author zlx
     * @date 2020/10/16 14:36
     * @param form
     * @return long
     */
    public long insertOrganization(OrganizationForm.Add form) {
        Sql sql = Sql.insert(TABLE)
                .field("orgId", form.getOrgId())
                .field("orgName", form.getOrgName())
                .field("shortName", form.getShortName())
                .field("areaCode", form.getAreaCode())
                .field("areaLevel", form.getAreaLevel())
                .field("areaName", form.getAreaName())
                .field("orgClassify", form.getOrgClassify())
                .field("orgTypeCode", form.getOrgTypeCode())
                .field("orgTypeName", form.getOrgTypeName())
                .field("orgIntroduce", form.getOrgIntroduce())
                .field("chairman", form.getChairman())
                .field("contact", form.getContact())
                .field("telephone", form.getTelephone())
                .field("parentId", form.getParentId())
                .field("level", form.getLevel())
                .field("isLeaf", form.getIsLeaf())
                .field("remark", form.getRemark())
                .field("orgManageUserIdList", form.getOrgManageUserIdList())
                .field("orgIdTag", form.getOrgIdTag())
                .field("orgIdLevel", form.getOrgIdLevel())
                .field("orgNameLevel", form.getOrgNameLevel())
                .field("userId", form.getUserId())
                .field("userName", form.getUserName())
                .field("createTime", new Date())
                .field("updateTime", new Date())
                .field("status", form.getStatus());
        return springJdbcHelper.insertReturnFieldNumber(sql).longValue();
    }

    /**
     * @description 编辑数据
     * @author zlx
     * @date 2020/10/16 14:38
     * @param form
     * @return int
     */
    public int updateOrganization(OrganizationForm.Edit form) {
        Sql sql = Sql.update(TABLE)
                .setIfNotBlank("orgId", form.getOrgId())
                .setIfNotBlank("orgName", form.getOrgName())
                .setIfNotBlank("shortName", form.getShortName())
                .setIfNotBlank("areaCode", form.getAreaCode())
                .setIfNotNull("areaLevel",form.getAreaLevel())
                .setIfNotBlank("areaName", form.getAreaName())
                .setIfNotBlank("orgClassify", form.getOrgClassify())
                .setIfNotBlank("orgTypeCode", form.getOrgTypeCode())
                .setIfNotBlank("orgTypeName", form.getOrgTypeName())
                .setIfNotBlank("orgIntroduce", form.getOrgIntroduce())
                .setIfNotBlank("chairman", form.getChairman())
                .setIfNotBlank("contact", form.getContact())
                .setIfNotBlank("telephone", form.getTelephone())
                .setIfNotBlank("parentId", form.getParentId())
                .setIfNotNull("level", form.getLevel())
                .setIfNotNull("isLeaf", form.getIsLeaf())
                .setIfNotBlank("remark", form.getRemark())
                .setIfNotBlank("orgManageUserIdList", form.getOrgManageUserIdList())
                .setIfNotBlank("orgIdTag", form.getOrgIdTag())
                .setIfNotBlank("orgIdLevel", form.getOrgIdLevel())
                .setIfNotBlank("orgNameLevel", form.getOrgNameLevel())
                .setIfNotNull("userId", form.getUserId())
                .setIfNotBlank("userName", form.getUserName())
                .set("updateTime", new Date())
                .setIfNotNull("status", form.getStatus())
                .where()
                .andEq("id", form.getId());
        return springJdbcHelper.update(sql);
    }

    /**
     * @description 删除或批量删除数据
     * @author zlx
     * @date 2020/10/16 14:40
     * @param form
     * @return int
     */
    public int batchDelOrganization(OrganizationForm.BatchDel form) {
        Sql sql = Sql.update(TABLE)
                .set("status",-1)
                .where()
                .andIn("orgId",form.getOrgIdList());
        return springJdbcHelper.update(sql);
    }

    public List<TreeNode> queryOrgTreeNode(OrganizationForm orgForm) {
        Sql sql = Sql.select()
                .field("orgId","`key`")
                .field("orgName","title")
                .field("areaCode","parentId")
                .field("true as isLeaf")

                .from("t_organization", "a")
                .where()
                .andEq("status",1);


        List<TreeNode> list = springJdbcHelper.queryForListBean(sql, TreeNode.class);
        return list;
    }

    /**
     * @description: TODO
     * @author: zhangsq
     * @date: Created in 2020-10-23 19:06
     * @param form
     * @return: java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.Organization>
     * @exception:
     */
    public List<Organization> findByAreaLevelOrganization(OrganizationForm.BatchDel form){
        Sql sql = Sql.select()
                .field("orgId")
                .field("areaLevel")
                .from(TABLE)
                .where()
                .andIn("orgId",form.getOrgIdList());
        return springJdbcHelper.queryForListBean(sql.getSql().toString(),Organization.class,sql.getParams().toArray());
    }

    /**
     * @description 统计横向组织和纵向组织所占百分比
     * @author zlx
     * @date 2020/11/2 16:46
     * @param
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.OrganizationStatistics>
     */
    public List<OrganizationStatistics> findOrganizationStatistics(){
        Sql sql = Sql.select()
                .field("t.orgClassify,t.orgTypeCode,t.orgTypeName")
                .field("count(t.orgTypeCode)","codeCount")
                .field("t2.classifyCount")
                .field("ROUND((count(t.orgTypeCode) / t2.classifyCount) * 100,2)","percentage")
                .from("t_organization","t")
                .join(Sql.select()
                        .field("t1.orgClassify")
                        .field("COUNT(t1.orgClassify)","classifyCount")
                        .from("t_organization","t1")
                        .groupBy("t1.orgClassify"),"t2")
                .on("t.orgClassify","t2.orgClassify")
                .groupBy("t.orgClassify,t.orgTypeCode,t.orgTypeName");
        return springJdbcHelper.queryForListBean(sql.getSql().toString(),OrganizationStatistics.class);
    }

    /**
     * @description 根据区域code和orgName查询数据
     * @author zlx
     * @date 2020/11/10 10:29
     * @param form
     * @return com.redare.shop.unifyworkbench.sdk.pojo.Organization
     */
    public Organization findOrganizationByAreaCodeAndOrgName(OrganizationForm.Search form){
        Sql sql = Sql.select()
                .from("t_organization")
                .where()
                .andEq("orgName",form.getOrgName())
                .andEq("areaCode",form.getAreaCode())
                .andEq("status",1);
        return springJdbcHelper.queryForBean(sql.getSql().toString(),Organization.class,sql.getParams().toArray());
    }

    public List<Organization> generateOrganization(OrganizationForm.Search form){
        Sql sql = Sql.select()
                .field("CONCAT(b.areaName,a.areaName,'妇女联合会') as orgName")
                .field("a.areaCode,a.level as areaLevel,a.areaName,'zx' as orgClassify")
                .field("(CASE WHEN a.level = 5 THEN 'community' WHEN a.level = 4 THEN 'street' WHEN a.level = 3 THEN 'administrative' WHEN a.level = 2 THEN 'township' WHEN a.level = 1 THEN 'local' ELSE NULL END) orgTypeCode")
                .field("(CASE WHEN a.level = 5 THEN '村(社区)妇联' WHEN a.level = 4 THEN '乡镇(街道)妇联' WHEN a.level = 3 THEN '县(区)妇联' WHEN a.level = 2 THEN '州(市)妇联' WHEN a.level = 1 THEN '省妇联' ELSE NULL END) orgTypeName")
                .field("1713 as userId")
                .field("'admin' as userName,NOW() AS createTime,NOW() AS updateTime,1 as `status`")
                .from(Sql.select()
                        .field("t.areaCode,t.areaName,t.`level`,t.parentCode")
                        .from("t_area","t")
                        .where()
                        .andInIf(form.getBaseLevelTreeQuery() != null,"t.areaCode",Sql.select().field("a.areaCode").from("t_area","a")
                                .where()
                                .andIfNotNull(form.getBaseLevelTreeQuery(),()->{
                                    return TreeMysql.tree(
                                            form.getBaseLevelTreeQuery().getLevelId(),
                                            form.getBaseLevelTreeQuery().isUp(),
                                            "t_area",
                                            "areaIdLevel",
                                            "areaCode",
                                            form.getBaseLevelTreeQuery().getLevelNum(),
                                            //selectWhere -> selectWhere.andEq("del", 0),
                                            form.getBaseLevelTreeQuery().isLevelNumOnly(),
                                            form.getBaseLevelTreeQuery().isIncSelf());
                                })
                        ),"a")
                .join("t_area","b")
                .on("a.parentCode","b.areaCode");
        return springJdbcHelper.queryForListBean(sql.getSql().toString(),Organization.class,sql.getParams().toArray());
    }

    public List<Organization> findByAreaCodeAndOrgClassify(OrganizationForm.Search form){
        Sql sql = Sql.select()
                .from("t_organization")
                .where()
                .andEq("areaCode",form.getAreaCode())
                .andEq("orgClassify",form.getOrgClassify());
        return springJdbcHelper.queryForListBean(sql.getSql().toString(),Organization.class,sql.getParams().toArray());
    }
}