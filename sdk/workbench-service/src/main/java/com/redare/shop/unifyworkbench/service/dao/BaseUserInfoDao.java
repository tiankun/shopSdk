package com.redare.shop.unifyworkbench.service.dao;

import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.MySqlJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.common.pojo.BaseUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: guangrongyang
 * @Date: 2020/10/20 14:16
 */
@Repository
public class BaseUserInfoDao {
    @Autowired
    MySqlJdbcHelper jdbcHelper;

    public List<BaseUserInfo> queryBaseUserInfo(BaseUserInfo form) {

        Sql sql = Sql.select()
                .field("a.*")
                .field("b.*")
                .field("o.orgId, o.orgName,o.chairman,o.contact,o.telephone, o.orgTypeCode, o.orgTypeName,o.orgClassify, o.parentId, o.level orgLevel,  o.orgManageUserIdList, o.orgIdTag, o.orgIdLevel, o.orgNameLevel")
                .field("c.*")
                .field("e.departmentId, e.parentId, e.deptName")
                .field("d.womenPosition,d.womenPositionId")
                .from("base_account", "a")
                .join("base_user", "b")
                .on("a.id", "b.userId")

                .join("t_user_org", "d")
                .on("d.userId", "b.userId").andEqIfNotNull("d.orgId", form.getOrgId())

                .join("t_organization", "o")
                .on("o.orgId", "d.orgId")

                .join("t_area", "c")
                .on("c.areaCode", "o.areaCode")

                //e.id可能为空
                .leftJoin("t_department", "e")
                .on("e.departmentId", "d.deptId")

                .where()
                .andEq("b.userId", form.getUserId())
                .andEq("d.del", 0);
        return jdbcHelper.queryForListBean(sql, BaseUserInfo.class);
    }
}
