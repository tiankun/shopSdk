package com.redare.shop.unifyworkbench.service.dao;

import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.base.SpringJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.ImportPersonnelInfo;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ImportPersonnelInfoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/11/19 17:59
 * @version:
 */
@Repository
public class ImportPersonnelInfoDao {

    @Autowired
    SpringJdbcHelper springJdbcHelper;

    /**
     * @description 分页查询
     * @author zlx
     * @date 2020/11/19 18:09
     * @param form
     * @param curPage
     * @param pageSize
     * @param calCount
     * @param allList
     * @return com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.ImportPersonnelInfo>
     */
    public Page<ImportPersonnelInfo> findImportPersonnelInfoPage(ImportPersonnelInfoForm.Search form,int curPage,int pageSize,boolean calCount,boolean allList){
        Sql sql = Sql.select()
                .from("t_import_personnel_info")
                .where()
                .andBlikeJoinByOrIfNotBlank(form.getKey(),"orgName","deptName")
                .andEqIfNotBlank("name",form.getName())
                .andEqIfNotBlank("mobile",form.getMobile())
                .andEqIfNotBlank("orgId",form.getOrgId())
                .andEqIfNotNull("status",form.getStatus())
                .andEqIfNotBlank("importType",form.getImportType())
                .andEqIfNotNull("recordId",form.getRecordId())
                .andEqIfNotBlank("rosterId",form.getRosterId())
                .orderBy().desc("createTime");
        return springJdbcHelper.queryForPageBean(sql.getSql().toString(),ImportPersonnelInfo.class,sql.getParams().toArray(),curPage,pageSize,calCount,allList);
    }

    /**
     * @description 根据主键id查询数据
     * @author zlx
     * @date 2020/11/19 18:10
     * @param form
     * @return com.redare.shop.unifyworkbench.sdk.pojo.ImportPersonnelInfo
     */
    public ImportPersonnelInfo findImportPersonnelInfo(ImportPersonnelInfoForm.Get form){
        Sql sql = Sql.select()
                .from("t_import_personnel_info")
                .where()
                .andEq("id",form.getId());
        return springJdbcHelper.queryForBean(sql.getSql().toString(),ImportPersonnelInfo.class,sql.getParams().toArray());
    }

    /**
     * @description 添加数据
     * @author zlx
     * @date 2020/11/19 18:21
     * @param form
     * @return java.lang.Long
     */
    public Long addImportPersonnelInfo(ImportPersonnelInfoForm.Add form){
        Sql sql = Sql.insert("t_import_personnel_info")
                .field("orgId",form.getOrgId())
                .field("orgName",form.getOrgName())
                .field("rosterId",form.getRosterId())
                .field("rosterName",form.getRosterName())
                .field("name",form.getName())
                .field("birthday",form.getBirthday())
                .field("cardNo",form.getCardNo())
                .field("sex",form.getSex())
                .field("nativePlace",form.getNativePlace())
                .field("nationId",form.getNationId())
                .field("nation",form.getNation())
                .field("politicId",form.getPoliticId())
                .field("politic",form.getPolitic())
                .field("partyDate",form.getPartyDate())
                .field("deptName",form.getDeptName())
                .field("position",form.getPosition())
                .field("positionId",form.getPositionId())
                .field("positionType",form.getPositionType())
                .field("positionTime",form.getPositionTime())
                .field("educationId",form.getEducationId())
                .field("education",form.getEducation())
                .field("school",form.getSchool())
                .field("major",form.getMajor())
                .field("graduationTime",form.getGraduationTime())
                .field("mobile",form.getMobile())
                .field("weChat",form.getWeChat())
                .field("email",form.getEmail())
                .field("unit",form.getUnit())
                .field("unitPosition",form.getUnitPosition())
                .field("servedTime",form.getServedTime())
                .field("deputy",form.getDeputy())
                .field("honour",form.getHonour())
                .field("recordId",form.getRecordId())
                .field("changeAccount",form.getChangeAccount())
                .field("importType",form.getImportType())
                .field("createTime",form.getCreateTime())
                .field("updateTime",form.getUpdateTime())
                .field("status",form.getStatus())
                .field("deptId",form.getDeptId())
                .field("positionTypeCode",form.getPositionTypeCode())
                .field("remark",form.getRemark())
                .field("areaCode",form.getAreaCode())
                .field("areaName",form.getAreaName())
                .field("userId",form.getUserId())
                .field("userName",form.getUserName());
        return springJdbcHelper.insertReturnFieldNumber(sql).longValue();
    }

    public List<ImportPersonnelInfo> findRosterList(ImportPersonnelInfoForm.Search form){
        Sql sql = Sql.select()
                .fields("DISTINCT rosterId,rosterName")
                .from("t_import_personnel_info")
                .where()
                .andEq("status",1)
                .andIsNotEmpty("rosterId")
                .andEqIfNotBlank("orgId",form.getOrgId())
                .andLikeIfNotBlank("areaCode",form.getAreaCode())
                .orderBy().desc("rosterId");
        return springJdbcHelper.queryForListBean(sql.getSql().toString(),ImportPersonnelInfo.class,sql.getParams().toArray());
    }

    /**
     * @description 编辑数据
     * @author zlx
     * @date 2020/11/19 18:28
     * @param form
     * @return boolean
     */
    public boolean editImportPersonnelInfo(ImportPersonnelInfoForm.Edit form){
        Sql sql = Sql.update("t_import_personnel_info")
                .setIfNotBlank("orgId",form.getOrgId())
                .setIfNotBlank("orgName",form.getOrgName())
                .setIfNotBlank("rosterId",form.getRosterId())
                .setIfNotBlank("rosterName",form.getRosterName())
                .setIfNotBlank("name",form.getName())
                .setIfNotNull("birthday",form.getBirthday())
                .setIfNotBlank("cardNo",form.getCardNo())
                .setIfNotBlank("sex",form.getSex())
                .setIfNotBlank("nativePlace",form.getNativePlace())
                .setIfNotNull("nationId",form.getNationId())
                .setIfNotBlank("nation",form.getNation())
                .setIfNotNull("politicId",form.getPoliticId())
                .setIfNotBlank("politic",form.getPolitic())
                .setIfNotNull("partyDate",form.getPartyDate())
                .setIfNotBlank("deptName",form.getDeptName())
                .setIfNotBlank("position",form.getPosition())
                .setIfNotNull("positionId",form.getPositionId())
                .setIfNotBlank("positionType",form.getPositionType())
                .setIfNotNull("positionTime",form.getPositionTime())
                .setIfNotNull("educationId",form.getEducationId())
                .setIfNotBlank("education",form.getEducation())
                .setIfNotBlank("school",form.getSchool())
                .setIfNotBlank("major",form.getMajor())
                .setIfNotNull("graduationTime",form.getGraduationTime())
                .setIfNotBlank("mobile",form.getMobile())
                .setIfNotBlank("weChat",form.getWeChat())
                .setIfNotBlank("email",form.getEmail())
                .setIfNotBlank("unit",form.getUnit())
                .setIfNotBlank("unitPosition",form.getUnitPosition())
                .setIfNotNull("servedTime",form.getServedTime())
                .setIfNotBlank("deputy",form.getDeputy())
                .setIfNotBlank("honour",form.getHonour())
                .setIfNotNull("recordId",form.getRecordId())
                .setIfNotNull("changeAccount",form.getChangeAccount())
                .setIfNotBlank("importType",form.getImportType())
                .setIfNotNull("createTime",form.getCreateTime())
                .setIfNotNull("updateTime",form.getUpdateTime())
                .setIfNotNull("status",form.getStatus())
                .setIfNotBlank("deptId",form.getDeptId())
                .setIfNotBlank("positionTypeCode",form.getPositionTypeCode())
                .setIfNotBlank("remark",form.getRemark())
                .setIfNotBlank("areaCode",form.getAreaCode())
                .setIfNotBlank("areaName",form.getAreaName())
                .setIfNotNull("userId",form.getUserId())
                .setIfNotBlank("userName",form.getUserName())
                .where()
                .andEq("id",form.getId());
        return springJdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray())>0;
    }

    /**
     * @description 根据主键id删除数据
     * @author zlx
     * @date 2020/11/19 18:30
     * @param form
     * @return boolean
     */
    public boolean delImportPersonnelInfo(ImportPersonnelInfoForm.Del form){
        Sql sql = Sql.update("t_import_personnel_info")
                .set("status",-1)
                .where()
                .andEq("id",form.getId());
        return springJdbcHelper.update(sql)>0;
    }

    /**
     * 删除执委名单
     * @param form
     * @return
     */
    public int delByRosterId(ImportPersonnelInfoForm.BatchDel form){
        Sql sql = Sql.update("t_import_personnel_info")
                .set("status",-1)
                .where()
                .andInIfNotEmpty("id",form.getIds())
                .andEqIfNotBlank("rosterId",form.getRosterId());
        return springJdbcHelper.update(sql);
    }

    /**
     * @description 批量添加数据
     * @author zlx
     * @date 2020/11/20 15:35
     * @param list
     * @return int[]
     */
    public int[] batchAdd(List<ImportPersonnelInfo> list,Long recordId){
        Sql sql = Sql.insert("t_import_personnel_info")
                .field("orgId")
                .field("orgName")
                .field("rosterId")
                .field("rosterName")
                .field("name")
                .field("birthday")
                .field("cardNo")
                .field("sex")
                .field("nativePlace")
                .field("nationId")
                .field("nation")
                .field("politicId")
                .field("politic")
                .field("partyDate")
                .field("deptName")
                .field("position")
                .field("positionId")
                .field("positionType")
                .field("positionTime")
                .field("educationId")
                .field("education")
                .field("school")
                .field("major")
                .field("graduationTime")
                .field("mobile")
                .field("weChat")
                .field("email")
                .field("unit")
                .field("unitPosition")
                .field("servedTime")
                .field("deputy")
                .field("honour")
                .field("recordId")
                .field("changeAccount")
                .field("importType")
                .field("createTime")
                .field("updateTime")
                .field("status")
                .field("deptId")
                .field("positionTypeCode")
                .field("remark")
                .field("areaCode")
                .field("areaName")
                .field("userId")
                .field("userName");
        List<Object[]> params = new ArrayList<>();
        for (ImportPersonnelInfo item : list){
            params.add(
                    new Object[]{
                            item.getOrgId(),
                            item.getOrgName(),
                            item.getRosterId(),
                            item.getRosterName(),
                            item.getName(),
                            item.getBirthday(),
                            item.getCardNo(),
                            item.getSex(),
                            item.getNativePlace(),
                            item.getNationId(),
                            item.getNation(),
                            item.getPoliticId(),
                            item.getPolitic(),
                            item.getPartyDate(),
                            item.getDeptName(),
                            item.getPosition(),
                            item.getPositionId(),
                            item.getPositionType(),
                            item.getPositionTime(),
                            item.getEducationId(),
                            item.getEducation(),
                            item.getSchool(),
                            item.getMajor(),
                            item.getGraduationTime(),
                            item.getMobile(),
                            item.getWeChat(),
                            item.getEmail(),
                            item.getUnit(),
                            item.getUnitPosition(),
                            item.getServedTime(),
                            item.getDeputy(),
                            item.getHonour(),
                            recordId,
                            item.getChangeAccount(),
                            item.getImportType(),
                            item.getCreateTime(),
                            item.getUpdateTime(),
                            item.getStatus(),
                            item.getDeptId(),
                            item.getPositionTypeCode(),
                            item.getRemark(),
                            item.getAreaCode(),
                            item.getAreaName(),
                            item.getUserId(),
                            item.getUserName()
                    }
            );
        }
        return springJdbcHelper.batchUpdate(sql.toString(), params);
    }

    /**
     * @description 批量添加数据
     * @author zlx
     * @date 2020/11/20 15:35
     * @param list
     * @return int[]
     */
    public int[] batchAdd(List<ImportPersonnelInfo> list,Long recordId,String rosterId){
        Sql sql = Sql.insert("t_import_personnel_info")
                .field("orgId")
                .field("orgName")
                .field("rosterId")
                .field("rosterName")
                .field("name")
                .field("birthday")
                .field("cardNo")
                .field("sex")
                .field("nativePlace")
                .field("nationId")
                .field("nation")
                .field("politicId")
                .field("politic")
                .field("partyDate")
                .field("deptName")
                .field("position")
                .field("positionId")
                .field("positionType")
                .field("positionTime")
                .field("educationId")
                .field("education")
                .field("school")
                .field("major")
                .field("graduationTime")
                .field("mobile")
                .field("weChat")
                .field("email")
                .field("unit")
                .field("unitPosition")
                .field("servedTime")
                .field("deputy")
                .field("honour")
                .field("recordId")
                .field("changeAccount")
                .field("importType")
                .field("createTime")
                .field("updateTime")
                .field("status")
                .field("deptId")
                .field("positionTypeCode")
                .field("remark")
                .field("areaCode")
                .field("areaName")
                .field("userId")
                .field("userName");
        List<Object[]> params = new ArrayList<>();
        for (ImportPersonnelInfo item : list){
            params.add(
                    new Object[]{
                            item.getOrgId(),
                            item.getOrgName(),
                            rosterId,
                            item.getRosterName(),
                            item.getName(),
                            item.getBirthday(),
                            item.getCardNo(),
                            item.getSex(),
                            item.getNativePlace(),
                            item.getNationId(),
                            item.getNation(),
                            item.getPoliticId(),
                            item.getPolitic(),
                            item.getPartyDate(),
                            item.getDeptName(),
                            item.getPosition(),
                            item.getPositionId(),
                            item.getPositionType(),
                            item.getPositionTime(),
                            item.getEducationId(),
                            item.getEducation(),
                            item.getSchool(),
                            item.getMajor(),
                            item.getGraduationTime(),
                            item.getMobile(),
                            item.getWeChat(),
                            item.getEmail(),
                            item.getUnit(),
                            item.getUnitPosition(),
                            item.getServedTime(),
                            item.getDeputy(),
                            item.getHonour(),
                            recordId,
                            item.getChangeAccount(),
                            item.getImportType(),
                            item.getCreateTime(),
                            item.getUpdateTime(),
                            item.getStatus(),
                            item.getDeptId(),
                            item.getPositionTypeCode(),
                            item.getRemark(),
                            item.getAreaCode(),
                            item.getAreaName(),
                            item.getUserId(),
                            item.getUserName()
                    }
            );
        }
        return springJdbcHelper.batchUpdate(sql.toString(), params);
    }

    /**
     * @description 批量修改状态
     * @author zlx
     * @date 2020/11/20 15:39
     * @param list
     * @return int
     */
    public int batchEditStatus(List<Long> list){
        Sql sql = Sql.update("t_import_personnel_info")
                .set("status",-1)
                .where()
                .andIn("id",list);
        return springJdbcHelper.update(sql);
    }

    public int editChangeAccount(ImportPersonnelInfoForm.Edit form){
        Sql sql = Sql.update("t_import_personnel_info")
                .set("changeAccount",1)
                .where()
                .andEq("id",form.getId());
        return springJdbcHelper.update(sql);
    }
}
