package com.redare.shop.unifyworkbench.service.dao;

import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.base.SpringJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.ContentManage;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ContentManageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * TODO
 *
 * @Author zlx
 * @Date 2020/5/6 15:00
 */
@Repository
public class ContentManageDao {

    @Autowired
    SpringJdbcHelper springJdbcHelper;

    /**
     * 分页查询（t_content_manage）列表
     * @author zlx
     * @date 2020/5/6 15:54
     * @param form
     * @param curPage
     * @param pageSize
     * @param calCount
     * @param allList
     * @return com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.ContentManage>
     */
    public Page<ContentManage> findContentManagePage(ContentManageForm.Search form, int curPage, int pageSize, boolean calCount, boolean allList){
        Sql sql = Sql.select()
                .fields("tcm.*")
                .field("DATE_FORMAT(tcm.publishTime,'%Y-%m-%d')","pubTime")
                .field("bu.name","publisher")
                .field("t.name","classifyName")
                .from("t_content_manage","tcm")
                .leftJoin("base_user","bu")
                .on("tcm.publishId","bu.userId")
                .leftJoin("t_classify_manage","t")
                .on("tcm.classify","t.id")
                .where()
                .andBlikeJoinByOrIfNotBlank(form.getKey(),"tcm.title")
                .andEqIfNotNull("classify",form.getClassify())
                .andEqIfNotNull("status",form.getStatus())
                .andBetweenOptionIf(form.getStartTime() != null&&form.getEndTime() != null,"publishTime",form.getStartTime(),form.getEndTime())
                .orderBy().desc("publishTime");
        return springJdbcHelper.queryForPageBean(sql.getSql().toString(),ContentManage.class,sql.getParams().toArray(),curPage,pageSize,calCount,allList);
    }

    /**
     * 添加（t_content_manage）列表数据
     * @author zlx
     * @date 2020/5/7 10:35
     * @param form
     * @return int
     */
    public int addContentManage(ContentManageForm.Add form){
        Sql sql = Sql.insert("t_content_manage")
                .field("title",form.getTitle())
                .field("content",form.getContent())
                .field("cover",form.getCover())
                .field("enclosure",form.getEnclosure())
                .field("classify",form.getClassify())
                .field("syncToSite",form.getSyncToSite())
                .field("publishId",form.getPublishId())
                .field("orgIds",form.getOrgIds())
                .field("orgNames",form.getOrgNames())
                .field("publishTime",new Date())
                .field("status",1)
                .field("createTime",new Date());
        return springJdbcHelper.insertReturnFieldNumber(sql).intValue();
    }

    /**
     * 修改显示隐藏状态
     * @author zlx
     * @date 2020/5/7 21:46
     * @param form
     * @return int
     */
    public int editStatus(ContentManageForm.EditStatus form){
        Sql sql = Sql.update("t_content_manage")
                .set("status",form.getStatus())
                .where()
                .andEq("id",form.getId());
        return springJdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    /**
     * 根据id删除表（t_content_manage）数据
     * @author zlx
     * @date 2020/5/8 9:47
     * @param form
     * @return int
     */
    public int deleteContentManage(ContentManageForm.Del form){
        Sql sql = Sql.delete("t_content_manage")
                .where()
                .andEq("id",form.getId());
        return springJdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    /**
     * 根据id查询详情
     * @author zlx
     * @date 2020/5/8 10:59
     * @param form
     * @return com.redare.shop.unifyworkbench.sdk.pojo.ContentManage
     */
    public ContentManage getContentManage(ContentManageForm.Get form){
        Sql sql = Sql.select()
                .fields("tcm.*")
                .field("DATE_FORMAT(tcm.publishTime,'%Y-%m-%d %H:%i')","pubTime")
                .field("bu.name","publisher")
                .field("t.name","classifyName")
                .from("t_content_manage","tcm")
                .leftJoin("base_user","bu")
                .on("tcm.publishId","bu.userId")
                .leftJoin("t_classify_manage","t")
                .on("tcm.classify","t.id")
                .where()
                .andEq("tcm.id",form.getId());
        return springJdbcHelper.queryForBean(sql,ContentManage.class);
    }

    /**
     * 编辑数据
     * @author zlx
     * @date 2020/5/8 17:54
     * @param form
     * @return int
     */
    public int editContentManage(ContentManageForm.Edit form){
        Sql sql = Sql.update("t_content_manage")
                .setIfNotBlank("title",form.getTitle())
                .setIfNotBlank("content",form.getContent())
                .setIfNotBlank("cover",form.getCover())
                .setIfNotBlank("enclosure",form.getEnclosure())
                .setIfNotNull("classify",form.getClassify())
                .setIfNotNull("syncToSite",form.getSyncToSite())
                .setIfNotNull("publishId",form.getPublishId())
                .setIfNotNull("browse",form.getBrowse())
                .setIfNotBlank("orgIds",form.getOrgIds())
                .setIfNotBlank("orgNames",form.getOrgNames())
                .set("publishTime",new Date())
                .setIfNotNull("status",form.getStatus())
                .setIfNotNull("createTime",form.getCreateTime())
                .where()
                .andEq("id",form.getId());
        return springJdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    /**
     * 批量删除数据
     * @author zlx
     * @date 2020/5/9 11:12
     * @param form
     * @return int
     */
    public int batchDelContent(ContentManageForm.BatchDel form){
        Sql sql = Sql.delete("t_content_manage")
                .where()
                .andIn("id",form.getIds());
        return springJdbcHelper.update(sql);
    }

    /**
     * 查询表所有显示的数据
     * @author zlx
     * @date 2020/5/11 11:44
     * @param
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.ContentManage>
     */
    public List<ContentManage> getContentManageTop5(ContentManageForm.GetByClassify form){
        Sql sql = Sql.select()
                .fields("*")
                .field("DATE_FORMAT(publishTime,'%Y-%m-%d')","pubTime")
                .from("t_content_manage")
                .where()
                .andEq("status",1)
                .andEqIfNotNull("classify",form.getClassify())
                .orderBy().desc("publishTime");
        return springJdbcHelper.queryForListBean(sql,ContentManage.class);
    }

    /**
     * 根据分类进行分页查询数据
     * @author zlx
     * @date 2020/5/12 11:33
     * @param form
     * @param curPage
     * @param pageSize
     * @param calCount
     * @param allList
     * @return com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.ContentManage>
     */
    public Page<ContentManage> findContentManageByClassify(ContentManageForm.Search form,int curPage, int pageSize, boolean calCount, boolean allList){
        Sql sql = Sql.select()
                .fields("*")
                .field("DATE_FORMAT(publishTime,'%Y-%m-%d')","pubTime")
                .from("t_content_manage")
                .where()
                .andEq("status",1)
                .andEqIfNotNull("classify",form.getClassify())
                .orderBy().desc("publishTime");
        return springJdbcHelper.queryForPageBean(sql.getSql().toString(),ContentManage.class,sql.getParams().toArray(),curPage,pageSize,calCount,allList);
    }

    /**
     * 浏览量自动加一
     * @author zlx
     * @date 2020/5/13 14:54
     * @param form
     * @return int
     */
    public int autoPlusOneOnBrowse(ContentManageForm.Get form){
        StringBuilder stringBuilder = new StringBuilder("update t_content_manage ");
        stringBuilder.append("set browse = browse+1 ")
                .append("where id =?");
        Object[] args = {form.getId()};
        return springJdbcHelper.update(stringBuilder.toString(),args);
    }

    /**
     * @description 分页查询（根据多分类查询）
     * @author zlx
     * @date 2020/7/16 15:51
     * @param form
     * @param curPage
     * @param pageSize
     * @param calCount
     * @param allList
     * @return com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.ContentManage>
     */
    public Page<ContentManage> findContentManagePageByClassifyList(ContentManageForm.Search form, int curPage, int pageSize, boolean calCount, boolean allList){
        Sql sql = Sql.select()
                .fields("tcm.*")
                .field("DATE_FORMAT(tcm.publishTime,'%Y-%m-%d')","pubTime")
                .field("bu.name","publisher")
                .field("t.name","classifyName")
                .from("t_content_manage","tcm")
                .leftJoin("base_user","bu")
                .on("tcm.publishId","bu.userId")
                .leftJoin("t_classify_manage","t")
                .on("tcm.classify","t.id")
                .where()
                .andBlikeJoinByOrIfNotBlank(form.getKey(),"tcm.title","tcm.content")
                .andInIfNotEmpty("classify",form.getClassifyList())
                .andEqIfNotNull("status",form.getStatus())
                .andBetweenOptionIf(form.getStartTime() != null&&form.getEndTime() != null,"publishTime",form.getStartTime(),form.getEndTime())
                .orderBy().desc("publishTime");
        return springJdbcHelper.queryForPageBean(sql.getSql().toString(),ContentManage.class,sql.getParams().toArray(),curPage,pageSize,calCount,allList);
    }
}
