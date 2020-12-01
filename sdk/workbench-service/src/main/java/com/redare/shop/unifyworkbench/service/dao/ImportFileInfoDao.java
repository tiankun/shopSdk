package com.redare.shop.unifyworkbench.service.dao;

import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.base.SpringJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.ImportFileInfo;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ImportFileInfoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/11/19 16:26
 * @version:
 */
@Repository
public class ImportFileInfoDao {

    @Autowired
    SpringJdbcHelper springJdbcHelper;

    /**
     * @description 分页查询
     * @author zlx
     * @date 2020/11/19 16:32
     * @param form
     * @param curPage
     * @param pageSize
     * @param calCount
     * @param allList
     * @return com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.ImportFileInfo>
     */
    public Page<ImportFileInfo> findImportFileInfoPage(ImportFileInfoForm.Search form,int curPage,int pageSize,boolean calCount,boolean allList){
        Sql subSql = Sql.select()
                .field("t1.id")
                .field("IF(count(t2.id)>0,1,0)","validStatus")
                .from("t_import_fileInfo","t1")
                .leftJoin("t_import_personnel_info","t2").on("t1.id","t2.recordId").and(Sql.sql("t2.`status` = 1"))
                .groupBy("t1.id");
        Sql sql = Sql.select()
                .field("t.*")
                .field("v.validStatus")
                .from("t_import_fileInfo","t")
                .leftJoin(subSql,"v").on("t.id","v.id")
                .where()
                .andBlikeJoinByOrIfNotBlank(form.getKey(),"t.fileName","t.uploadUserName","t.orgName","t.areaName")
                .andEqIfNotBlank("t.type",form.getType())
                .andEqIfNotBlank("t.orgId",form.getOrgId())
                .andEqIfNotBlank("t.areaCode",form.getAreaCode())
                .andBetweenOptionIf(form.getStartTime() != null&&form.getEndTime() != null,"t.uploadTime",form.getStartTime(),form.getEndTime())
                .orderBy().desc("t.createTime");
        return springJdbcHelper.queryForPageBean(sql.getSql().toString(),ImportFileInfo.class,sql.getParams().toArray(),curPage,pageSize,calCount,allList);
    }

    /**
     * @description 根据主键id查询数据
     * @author zlx
     * @date 2020/11/19 16:34
     * @param form
     * @return com.redare.shop.unifyworkbench.sdk.pojo.ImportFileInfo
     */
    public ImportFileInfo findImportFileInfo(ImportFileInfoForm.Get form){
        Sql sql = Sql.select()
                .from("t_import_fileInfo")
                .where()
                .andEq("id",form.getId());
        return springJdbcHelper.queryForBean(sql.getSql().toString(),ImportFileInfo.class,sql.getParams().toArray());
    }

    /**
     * @description 添加数据
     * @author zlx
     * @date 2020/11/19 16:45
     * @param form
     * @return java.lang.Long
     */
    public Long addImportFileInfo(ImportFileInfoForm.Add form){
        Sql sql = Sql.insert("t_import_fileInfo")
                .field("fileName",form.getFileName())
                .field("fileUrl",form.getFileUrl())
                .field("filePath",form.getFilePath())
                .field("fileSize",form.getFileSize())
                .field("type",form.getType())
                .field("uploadUserId",form.getUploadUserId())
                .field("uploadUserName",form.getUploadUserName())
                .field("orgId",form.getOrgId())
                .field("orgName",form.getOrgName())
                .field("areaCode",form.getAreaCode())
                .field("areaName",form.getAreaName())
                .field("updateTime",form.getUpdateTime())
                .field("importCount",form.getImportCount());
        return springJdbcHelper.insertReturnFieldNumber(sql).longValue();
    }

    public Boolean updateImportStatus(Long id){
        Sql sql = Sql.update("t_import_fileInfo")
                .set("status",1)
                .where()
                .andEq("id",id);
        return springJdbcHelper.update(sql)>0;
    }

    /**
     * @description 更新数据导入量
     * @author zlx
     * @date 2020/11/20 17:05
     * @param count
     * @param id
     * @return java.lang.Boolean
     */
    public Boolean editImportCount(Integer count,Long id){
        Sql sql = Sql.update("t_import_fileInfo")
                .set("importCount",count)
                .where()
                .andEq("id",id);
        return springJdbcHelper.update(sql)>0;

    }
}
