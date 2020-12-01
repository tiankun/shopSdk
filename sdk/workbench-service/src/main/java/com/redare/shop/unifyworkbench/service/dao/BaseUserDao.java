package com.redare.shop.unifyworkbench.service.dao;

import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Criteria;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.base.SpringJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.BaseUser;
import com.redare.shop.unifyworkbench.sdk.pojo.BaseUserDept;
import com.redare.shop.unifyworkbench.sdk.pojo.form.BaseUserForm;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @description: 人员信息数据层
 * @author: zhangsq
 * @date: Created in 2020-10-20 15:11
 * @return:
 * @exception:
 */
@Repository
public class BaseUserDao {

    @Autowired
    SpringJdbcHelper jdbcHelper;

    /**
     * 根据用户姓名和手机号码查询用户信息
     * @param form
     * @return
     */
    public BaseUser queryBaseUserByNameAndPhone(BaseUserForm.Search form){
        Sql sql = Sql.select()
                .from("base_user")
                .where()
                .andEqIfNotBlank("name",form.getName())
                .andEq("mobile",form.getMobile());
        return jdbcHelper.queryForBean(sql.toString(),BaseUser.class,sql.getParams().toArray());
    }

    /**
     * @description: 分页查询人员列表数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 17:37
     * @param form
     * @param curPage
     * @param pageSize
     * @param calCount
     * @param allList
     * @return: com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.BaseUser>
     * @exception:
     */
    public Page<BaseUser> findBaseUserPage(BaseUserForm.Search form, int curPage, int pageSize, boolean calCount, boolean allList){
//        Sql sql = Sql.select()
////                .field("u.userId")
////                .field("u.name")
////                .field("u.photo")
////                .field("u.mobile")
////                .field("u.email")
////                .field("u.sexId")
////                .field("u.sex")
////                .field("u.nationId")
////                .field("u.nation")
////                .field("u.birthday")
////                .field("u.cardNo")
////                .field("u.politicId")
////                .field("u.politic")
////                .field("u.partyDate")
////                .field("u.nativePlace")
////                .field("u.workUnit")
////                .field("u.wechatId")
////                .field("u.unitPositionId")
////                .field("u.unitPosition")
////                .field("u.educationId")
////                .field("u.education")
////                .field("u.school")
////                .field("u.major")
////                .field("u.graduationTime")
////                .field("u.onJob")
////                .field("u.health")
////                .field("u.resumeUrl")
////                .field("u.del")
////                .from("base_user","u")
////                .leftJoin("t_user_org","o").on("o.userId","u.userId")
////                //.leftJoin("base_account","a").on("a.id","u.userId")
////                .where()
////                //.andEqIf(StringUtils.isNotBlank(form.getOrgId()),"o.orgId",form.getOrgId())
////                .andEqIfNotBlank("o.orgId",form.getOrgId())
////                .andEqIf(StringUtils.isBlank(form.getOrgId()),"o.orgId",form.getOrgId())
////                .andBlikeJoinByOrIfNotBlank(form.getKey(), "u.name", "u.mobile", "u.email", "u.cardNo")
////                .andEqIfNotNull("u.userId",form.getUserId())
////                .andEqIfNotNull("u.del",0)
////                .orderBy().desc("u.userId");womenPositionId;
//    private String womenPosition;
//    private Date servedTime;

        StringBuilder sql = new StringBuilder();
        sql.append("select u.*,o.orgId,o.orgName,o.deptId,o.deptName,o.womenPosition,o.servedTime from base_user u JOIN t_user_org o on o.userId = u.userId JOIN base_account a on a.id=u.userId WHERE 1=1");
        if (StringUtils.isNotBlank(form.getOrgId())) {
            sql.append(" and o.orgId = '"+form.getOrgId()+"'");
        } else {
            sql.append(" and o.orgId=a.userPlatform");
        }
        if(CollectionUtils.isNotEmpty(form.getOrgIds())){
            sql.append(Criteria.in(" and o.orgId",form.getOrgIds()).debugSql());
        }
        if (StringUtils.isNotBlank(form.getDeptId())) {
            sql.append(" and o.deptId = '"+form.getDeptId()+"'");
        }
        if(CollectionUtils.isNotEmpty(form.getPositionIds())){
            sql.append(Criteria.in(" and o.womenPositionId",form.getPositionIds()).debugSql());
        }
        if (StringUtils.isNotBlank(form.getKey())) {
            sql.append(" and (u.name like concat('%','"+form.getKey()+"','%') or u.cardNo like concat('%','"+form.getKey()+"','%')  or u.mobile like concat('%','"+form.getKey()+"','%') or o.deptName like concat('%','"+form.getKey()+"','%') or o.womenPosition like concat('%','"+form.getKey()+"','%'))");
        }
        if(form.getUserId() != null){
            sql.append(" and u.userId = '"+form.getUserId()+"'");
        }
        sql.append(" and u.del = 0 and u.userType = 1 ");
        sql.append(" order by updateTime desc");
        return jdbcHelper.queryForPageBean(sql.toString(), BaseUser.class, new Object[]{}, curPage, pageSize, calCount, allList);
    }

    public Page<BaseUserDept> findBaseUserDept(BaseUserForm.Search form, int curPage, int pageSize, boolean calCount, boolean allList){
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT o.orgId,o.orgName,o.deptId,o.deptName,count( 1 ) AS count FROM base_user u JOIN t_user_org o ON o.userId = u.userId JOIN base_account a ON a.id = u.userId WHERE 1 = 1 ");
        if (StringUtils.isNotBlank(form.getOrgId())) {
            sql.append(" and o.orgId = '"+form.getOrgId()+"'");
        } else {
            sql.append(" and o.orgId=a.userPlatform");
        }
        if(CollectionUtils.isNotEmpty(form.getOrgIds())){
            sql.append(Criteria.in(" and o.orgId",form.getOrgIds()).debugSql());
        }
        if(CollectionUtils.isNotEmpty(form.getPositionIds())){
            sql.append(Criteria.in(" and o.womenPositionId",form.getPositionIds()).debugSql());
        }
        if (StringUtils.isNotBlank(form.getKey())) {
            sql.append(" and (u.name like concat('%','"+form.getKey()+"','%') or u.cardNo like concat('%','"+form.getKey()+"','%')  or u.mobile like concat('%','"+form.getKey()+"','%') or o.deptName like concat('%','"+form.getKey()+"','%') or o.womenPosition like concat('%','"+form.getKey()+"','%'))");
        }
        if(form.getUserId() != null){
            sql.append(" and u.userId = '"+form.getUserId()+"'");
        }
        sql.append(" and u.del = 0 and o.deptId != '' and u.userType = 1 ");
        sql.append(" GROUP BY o.orgId,o.deptId,o.orgName,o.deptName");
        return jdbcHelper.queryForPageBean(sql.toString(), BaseUserDept.class, new Object[]{}, curPage, pageSize, calCount, allList);
    }

    /**
     * @description: 根据主键id查询人员数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 17:41
     * @param form
     * @return: com.redare.shop.unifyworkbench.sdk.pojo.BaseUser
     * @exception:
     */
    public BaseUser findBaseUser(BaseUserForm.Get form){
        Sql sql = Sql.select()
                .from("base_user")
                .where()
                .andEqIfNotNull("del",0)
                .andEqIfNotNull("userId",form.getUserId());
        return jdbcHelper.queryForBean(sql.getSql().toString(), BaseUser.class,sql.getParams().toArray());
    }

    /**
     * @description: 根据身份证ID进行查询
     * @author: zhangsq
     * @date: Created in 2020-11-09 10:25
     * @param form
     * @return: com.redare.shop.unifyworkbench.sdk.pojo.BaseUser
     * @exception:
     */
    public BaseUser findByCardNoBaseUser(BaseUserForm.Get form){
        Sql sql = Sql.select()
                .from("base_user")
                .where()
                .andEqIfNotNull("del",0)
                .andEqIfNotNull("cardNo",form.getCardNo());
        return jdbcHelper.queryForBean(sql.getSql().toString(), BaseUser.class,sql.getParams().toArray());
    }

    /**
     * @description: 添加人员数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 17:49
     * @param form
     * @return: long
     * @exception:
     */
    public int addBaseUser(BaseUserForm.Add form){
        Sql sql = Sql.insert("base_user")
                .field("userId",form.getUserId())
                .field("name",form.getName())
                .field("photo",form.getPhoto())
                .field("mobile",form.getMobile())
                .field("email",form.getEmail())
                .field("userType",form.getUserType())
                .field("sexId",form.getSexId())
                .field("sex",form.getSex())
                .field("nationId",form.getNationId())
                .field("nation",form.getNation())
                .field("birthday",form.getBirthday())
                .field("cardNo",form.getCardNo())
                .field("politicId",form.getPoliticId())
                .field("politic",form.getPolitic())
                .field("partyDate",form.getPartyDate())
                .field("nativePlace",form.getNativePlace())
                .field("workUnit",form.getWorkUnit())
                .field("wechatId",form.getWechatId())
                .field("unitPositionId",form.getUnitPositionId())
                .field("unitPosition",form.getUnitPosition())
                .field("educationId",form.getEducationId())
                .field("education",form.getEducation())
                .field("school",form.getSchool())
                .field("major",form.getMajor())
                .field("graduationTime",form.getGraduationTime())
                .field("onJob",form.getOnJob())
                .field("health",form.getHealth())
                .field("resumeUrl",form.getResumeUrl())
                .field("del",0)
                .field("createTime", new Date())
                .field("updateTime", new Date());
        return jdbcHelper.insert(sql);
    }

    /**
     * @description: 编辑人员数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 17:54
     * @param form
     * @return: int
     * @exception:
     */
    public int editBaseUser(BaseUserForm.Edit form){
        Sql sql = Sql.update("base_user")
                .setIfNotBlank("name",form.getName())
                .setIfNotBlank("photo",form.getPhoto())
                .setIfNotBlank("mobile",form.getMobile())
                .setIfNotBlank("email",form.getEmail())
                .setIfNotNull("sexId",form.getSexId())
                .setIfNotBlank("sex",form.getSex())
                .setIfNotNull("nationId",form.getNationId())
                .setIfNotBlank("nation",form.getNation())
                .setIfNotNull("birthday",form.getBirthday())
                .setIfNotBlank("cardNo",form.getCardNo())
                .setIfNotNull("politicId",form.getPoliticId())
                .setIfNotBlank("politic",form.getPolitic())
                .setIfNotNull("partyDate",form.getPartyDate())
                .setIfNotBlank("nativePlace",form.getNativePlace())
                .setIfNotBlank("workUnit",form.getWorkUnit())
                .setIfNotBlank("wechatId",form.getWechatId())
                .setIfNotNull("unitPositionId",form.getUnitPositionId())
                .setIfNotBlank("unitPosition",form.getUnitPosition())
                .setIfNotNull("educationId",form.getEducationId())
                .setIfNotBlank("education",form.getEducation())
                .setIfNotBlank("school",form.getSchool())
                .setIfNotBlank("major",form.getMajor())
                .setIfNotNull("graduationTime",form.getGraduationTime())
                .setIfNotBlank("onJob",form.getOnJob())
                .setIfNotBlank("health",form.getHealth())
                .setIfNotBlank("resumeUrl",form.getResumeUrl())
                .set("updateTime", new Date())
                .where()
                .andEq("userId", form.getUserId());
        return jdbcHelper.update(sql);
    }

    /**
     * @description: 删除人员信息
     * @author: zhangsq
     * @date: Created in 2020-10-20 17:57
     * @param form
     * @return: int
     * @exception:
     */
    public int delBaseUser(BaseUserForm.BatchDel form){
        Sql sql = Sql.update("base_user")
                .set("del",1)
                .where()
                .andIn("userId",form.getUserIdList());
        return jdbcHelper.update(sql);
    }

}
