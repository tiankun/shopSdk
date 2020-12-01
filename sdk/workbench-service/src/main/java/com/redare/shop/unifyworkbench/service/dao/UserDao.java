package com.redare.shop.unifyworkbench.service.dao;

import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.base.SpringJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.User;
import com.redare.shop.unifyworkbench.sdk.pojo.form.TreeNode;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserForm;
import com.redare.shop.unifyworkbench.service.pojo.arg.UserArg;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/6/30 11:13
 * @version: 1.1
 */
@Repository
public class UserDao {

    @Autowired
    SpringJdbcHelper jdbcHelper;

    /**
     * @description 根据手机号码查询用户信息
     * @author zlx
     * @date 2020/6/30 14:04
     * @param form
     * @return com.redare.shop.unifyworkbench.sdk.pojo.User
     */
    public User findUserByMobile(UserForm.Get form){
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT a.userId,a.name,a.photo,a.mobile,a.email,b.id,b.account,b.platform,b.status FROM (");
        sql.append(" SELECT u.* FROM base_user u WHERE u.mobile="+form.getMobile()+") a JOIN (");
        sql.append(" SELECT ba.* FROM base_account ba WHERE ba.del=0) b ON a.userId = b.id");
        return jdbcHelper.queryForBean(sql.toString(),User.class);
    }

    /**
     * @description 根据组织机构id查询机构下的人员信息
     * @author zlx
     * @date 2020/7/6 16:55
     * @param form
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.User>
     */
    public List<User> findUserListByOgrId(UserForm.Search form) {
        Sql sql = Sql.select()
                .from("base_user")
                .where()
                .andEq("orgId", form.getOrgId());
        return jdbcHelper.queryForListBean(sql.getSql().toString(), User.class, sql.getParams().toArray());
    }

    /**
     * @description: 通讯录中根据组织机构id或ParentId查询机构下的用户信息
     * @author: zhangsq
     * @date: Created in 2020-07-17 11:00
     * @param form
     * @return: java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.User>
     * @exception:
     */
    public Page<User> findContactsBookUserListByOgrId(UserForm.Search form,int curPage, int pageSize, boolean calCount, boolean allList) {
        Sql sql = Sql.select()
                .from("base_user")
                .where()
                .andBlikeJoinByOrIfNotBlank(form.getKey(),"name","namePinyinInitials","mobile","orgName","orgParentName")
                .andEqIfNotNull("name",form.getName())
                .andEqIfNotNull("mobile", form.getMobile())
                .andEqIfNotNull("orgId", form.getOrgId())
                .andEqIfNotNull("orgName", form.getOrgName())
                .andEqIfNotNull("orgParentId", form.getOrgParentId())
                .andEqIfNotNull("orgParentName", form.getOrgParentName())
                .andEqIfNotNull("namePinyinShort",form.getNamePinyinShort())
                .andEqIfNotNull("staffName",form.getStaffName())
                .andEqIfNotNull("namePinyinInitials",form.getNamePinyinInitials())
                .andIsNotNullIf(form.isMobileFlag(),"mobile")
                .andIsNotNullIf(form.isEmailFlag(),"email")
                .orderBy().desc("createTime");
        return jdbcHelper.queryForPageBean(sql, User.class, curPage, pageSize, calCount, allList);
    }

    /**
     * @description: 用户管理中根据员工Id查询该员工在Base_user表是否存在
     * @author: zhangsq
     * @date: Created in 2020-07-28 17:19
     * @param form
     * @return: com.redare.shop.unifyworkbench.sdk.pojo.User
     * @exception:
     */
    public User findByStaffIdBaseUser(UserForm.GetStaffId form){
        Sql sql = Sql.select()
                .fields("a.*")
                .from("base_user","a")
                .join("base_account","b")
                .on("a.userId","b.id")
                .where()
                .andEq("a.staffId", form.getStaffId())
                .andEq("b.del",0);
        return jdbcHelper.queryForBean(sql, User.class);
    }

    public long getUserCount(UserForm.Search form) {
        boolean excRoot = !form.isIncRoot();
        if ((form.getId() != null && form.getId() == 0) || "root".equals(form.getAccount())) {
            excRoot = false;
        }
        Sql sql = Sql.selectCount()
                .from("base_account", "a")
                .join("base_platform", "b")
                .on("a.platform", "b.platform")
                .andEq("a.del", 0)
                .andEq("b.del", 0)
                .join("base_user", "e")
                .on("a.id", "e.userId")
                .joinIf(CollectionUtils.isNotEmpty(form.getRoleIds()), () ->
                        Sql.select()
                                .field("distinct accountId", "accountId")
                                .from("base_account_role")
                                .where()
                                .andIn("roleId", form.getRoleIds()), "d")
                .on("a.id", "d.accountId")
                .endJoinIf()
                .andNotEqIf(excRoot, "a.id", 0)
                .andEqIfNotBlank("a.account", form.getAccount())
                .andEqIfNotNull("a.id", form.getId())
                .andEqIfNotBlank("a.platform", form.getPlatform())
                .andEqIfNotBlank("a.userPlatform", form.getUserPlatform())
                .andEqIfNotNull("a.menuId", form.getMenuId())
                .andEqIfNotNull("a.status", form.getStatus())
                .andEqIfNotNull("a.needResetPwd", form.getNeedResetPwd())
                .andBlikeJoinByOrIfNotBlank(form.getKey(), "a.account", "e.mobile", "e.email", "e.name")
                .andEqIfNotBlank("e.mobile", form.getMobile())
                .andEqIfNotBlank("e.email", form.getEmail())
                .andEqIfNotBlank("e.name", form.getName());
        return jdbcHelper.queryForNumber(sql);
    }

    public Page<User> findUserPage(UserForm.Search form, int curPage, int pageSize, boolean calCount, boolean allList) {

        boolean excRoot = !form.isIncRoot();
        if ((form.getId() != null && form.getId() == 0) || "root".equals(form.getAccount())) {
            excRoot = false;
        }
        Sql sql = Sql.select()
                .fields("a.*", "if(a.id=0,1,0) as root")
                .fields("b.name as platformName")
                .fieldsIf(form.isIncMenu(), "c.name as menuName")
                .fields("e.userId", "e.name", "e.photo", "e.mobile", "e.email")
                .from("base_account", "a")
                .join("base_platform", "b")
                .on("a.platform", "b.platform")
                .andEq("a.del", 0)
                .andEq("b.del", 0)
                .joinIf(form.isIncMenu(), "base_platform_menu", "c")
                .on("a.menuId", "c.id")
                .endJoinIf()
                .joinIf(CollectionUtils.isNotEmpty(form.getRoleIds()), () ->
                        Sql.select()
                                .field("distinct accountId", "accountId")
                                .from("base_account_role")
                                .where()
                                .andIn("roleId", form.getRoleIds()), "d")
                .on("a.id", "d.accountId")
                .endJoinIf()
                .join("base_user", "e")
                .on("a.id", "e.userId")
                .where()
                .andInIfNotEmpty("a.id", form.getUserIds())
                .andNotEqIf(excRoot, "a.id", 0)
                .andEqIfNotBlank("a.account", form.getAccount())
                .andEqIfNotNull("a.id", form.getId())
                .andEqIfNotBlank("a.platform", form.getPlatform())
                .andEqIfNotBlank("a.userPlatform", form.getUserPlatform())
                .andEqIfNotNull("a.menuId", form.getMenuId())
                .andEqIfNotNull("a.status", form.getStatus())
                .andEqIfNotNull("a.needResetPwd", form.getNeedResetPwd())
                .andBlikeJoinByOrIfNotBlank(form.getKey(), "a.account", "e.mobile", "e.email", "e.name")
                .andEqIfNotBlank("e.mobile", form.getMobile())
                .andEqIfNotBlank("e.email", form.getEmail())
                .andEqIfNotBlank("e.name", form.getName())
                .andIf(form.getRoleId() != null,()->Sql.sql("FIND_IN_SET("+form.getRoleId()+", a.roleIds)"))
                .orderBy().desc("id");
        return jdbcHelper.queryForPageBean(sql, User.class, curPage, pageSize, calCount, allList);
    }

    public User getUser(UserForm.Get form) {
        Sql sql = Sql.select()
                .fields("a.*", "if(a.id=0,1,0) as root")
                .fields("b.name as platformName")
                .fieldsIf(form.isIncMenu(), "c.name as menuName")
                .fields("e.userId", "e.name", "e.photo", "e.mobile", "e.email")
                .from("base_account", "a")
                .join("base_platform", "b")
                .on("a.platform", "b.platform")
                .andEq("a.del", 0)
                .andEq("b.del", 0)
                .joinIf(form.isIncMenu(), "base_platform_menu", "c")
                .on("a.menuId", "c.id")
                .endJoinIf()
                .join("base_user", "e")
                .on("a.id", "e.userId")
                .where()
                .andEqIfNotBlank("a.account", form.getAccount())
                .andEqIfNotNull("a.id", form.getId())
                .andEqIfNotBlank("a.platform", form.getPlatform())
                .andEqIfNotBlank("a.userPlatform", form.getUserPlatform())
                .andEqIfNotNull("a.status", form.getStatus())
                .andEqIfNotBlank("e.mobile",form.getMobile());
        return jdbcHelper.queryForBean(sql, User.class);
    }

    public int addUser(UserArg.AddForm form) {
        Date now = new Date();
        Sql sql = Sql.insert("base_user")
                .field("userId", form.getUserId())
                .field("name", form.getName())
                .field("namePinyinInitials",form.getNamePinyinInitials())
                .field("namePinyinShort",form.getNamePinyinShort())
                .field("photo", form.getPhoto())
                .field("mobile", form.getMobile())
                .field("email", form.getEmail())
                .field("orgId", form.getOrgId())
                .field("orgName",form.getOrgName())
                .field("orgParentId",form.getOrgParentId())
                .field("orgParentName",form.getOrgParentName())
                .field("staffId",form.getStaffId())
                .field("staffName",form.getStaffName())
                //.field("gender", form.getGender() == null ? 0 : form.getGender())
                .field("createTime", now)
                .field("updateTime", now);
        return jdbcHelper.insert(sql);
    }

    public int editUser(UserForm.Edit form) {
        Date now = new Date();
        Sql sql = Sql.update("base_user")
                .setIfNotBlank("name", form.getName())
                .setIfNotNull("photo", form.getPhoto())
                .setIfNotNull("mobile", form.getMobile())
                .setIfNotNull("email", form.getEmail())
                .setIfNotNull("orgId", form.getOrgId())
                .setIfNotBlank("orgName",form.getOrgName())
                //.setIfNotNull("gender",form.getGender())
                .setIfNotNull("subscribeStatus",form.getSubscribeStatus())
                .setIfNotNull("wxOpenId",form.getWxOpenId())
                .where()
                .andEq("userId", form.getUserId());
        return jdbcHelper.update(sql);
    }

    public int resetUserPwd(UserForm.ResetPwd form) {
        Sql sql = Sql.update("base_account")
                .set("pwd", form.getPwd())
                .where()
                .andEqIfNotBlank("account", form.getAccount());
        return jdbcHelper.update(sql.toString(), sql.getParams().toArray());
    }

    /**
     * 用户结构树
     * @param form
     * @return
     */
    public List<TreeNode> findUserTreeNode(UserForm.Search form){
        Sql sql = Sql.select()
                .field("userId","`key`")
                .field("name","title")
                .field("orgId","parentId")
                .field("true as isLeaf")
                .from("base_user")
                .where()
                .andEqIfNotNull("orgId",  form.getOrgId());

        return jdbcHelper.queryForListBean(sql.toString(), TreeNode.class, sql.getParams().toArray());
    }


    /**
     * @description 根据逗号分隔的角色id和机构id查询可用的用户信息
     * @author zlx
     * @date 2020/7/24 14:41
     * @param roleIds
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.User>
     */
    public List<User> findByRoleIdsAndOrgIds(String roleIds,String orgIds){
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT d.id AS userId FROM (SELECT a.* FROM (SELECT b.* FROM base_account b WHERE b.`status`= 0 AND b.del = 0) a")
                .append(" WHERE CONCAT(',',a.roleIds,',') REGEXP CONCAT(',',replace('"+roleIds+"',',',',|,'), ',') = 1)d")
                .append(" UNION")
                .append(" SELECT e.userId FROM (SELECT c.* FROM (SELECT b.* FROM base_user b WHERE b.userId in (SELECT b.id FROM base_account b WHERE b.`status`= 0 AND b.del = 0)) c")
                .append(" WHERE FIND_IN_SET(c.orgId,'"+orgIds+"')) e");
        return jdbcHelper.queryForListBean(sql.toString(), User.class);
    }

    /**
     * @description 查询oa账号密码
     * @author zlx
     * @date 2020/7/24 17:21
     * @param roleIds
     * @param orgIds
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.User>
     */
    public List<User> findOaAccountByRoleIdsAndOrgIds(String roleIds,String orgIds){
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT h.userId,h.`name`,h.mobile,j.userId as accountId,j.account,j.`password` AS pwd FROM (SELECT c.id AS userId,d.`name`,d.mobile FROM (SELECT a.* FROM (SELECT b.* FROM base_account b WHERE b.`status`= 0 AND b.del = 0) a")
                .append(" WHERE CONCAT(',',a.roleIds,',') REGEXP CONCAT(',',replace('"+roleIds+"',',',',|,'), ',') = 1) c JOIN base_user d ON c.id = d.userId")
                .append(" UNION ")
                .append(" SELECT f.userId,f.`name`,f.mobile FROM (SELECT c.* FROM (SELECT b.* FROM base_user b WHERE b.userId in (SELECT b.id FROM base_account b WHERE b.`status`= 0 AND b.del = 0)) c")
                .append(" WHERE FIND_IN_SET(c.orgId,'"+orgIds+"'))f)h")
                .append(" LEFT JOIN (SELECT t.* FROM t_oa_account t WHERE t.`status` != -1) j")
                .append(" ON TRIM(j.mobile)=TRIM(h.mobile) AND TRIM(j.userName)=TRIM(h.`name`)");
        return jdbcHelper.queryForListBean(sql.toString(),User.class);
    }
}