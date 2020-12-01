package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

/**
 * @author : zhangsq
 * @version :
 * @description：人员与组织机构关联表(TUserOrg)Form
 * @date ：Created in 2020-10-19 12:11
 */
public class UserOrgForm {

    /**
     * @description: 添加
     * @author: zhangsq
     * @date: Created in 2020-10-19 15:45
     * @return:
     * @exception:
     */
    public static class Add{
        /**
         * 自增主键
         */
        private Long id;
        /**
         * 人员Id
         */
        private Long userId;
        /**
         * 组织机构Id
         */
        private String orgId;
        /**
         * 组织机构名称
         */
        private String orgName;
        /**
         * 部门Id
         */
        private String deptId;
        /**
         * 部门名称
         */
        private String deptName;
        /**
         * 妇联职位Id(字典表id)
         */
        private Integer womenPositionId;
        /**
         * 妇联职位
         */
        private String womenPosition;
        /**
         * 任职类型Code
         */
        private String positionTypeCode;
        /**
         * 任职类型名称
         */
        private String positionTypeName;
        /**
         * 任职时间
         */
        private Date servedTime;
        /**
         * 操作人
         */
        private String operator;
        /**
         * 是否删除0:正常,1:删除
         */
        private Integer del;
        /**
         * 创建时间
         */
        private Date createTime;
        /**
         * 修改时间
         */
        private Date updateTime;

        public Long getId() {
            return id;
        }

        public Add setId(Long id) {
            this.id = id;
            return this;
        }

        public Long getUserId() {
            return userId;
        }

        public Add setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public String getOrgId() {
            return orgId;
        }

        public Add setOrgId(String orgId) {
            this.orgId = orgId;
            return this;
        }

        public String getOrgName() {
            return orgName;
        }

        public Add setOrgName(String orgName) {
            this.orgName = orgName;
            return this;
        }

        public String getDeptId() {
            return deptId;
        }

        public Add setDeptId(String deptId) {
            this.deptId = deptId;
            return this;
        }

        public String getDeptName() {
            return deptName;
        }

        public Add setDeptName(String deptName) {
            this.deptName = deptName;
            return this;
        }

        public Integer getWomenPositionId() {
            return womenPositionId;
        }

        public Add setWomenPositionId(Integer womenPositionId) {
            this.womenPositionId = womenPositionId;
            return this;
        }

        public String getWomenPosition() {
            return womenPosition;
        }

        public Add setWomenPosition(String womenPosition) {
            this.womenPosition = womenPosition;
            return this;
        }

        public String getPositionTypeCode() {
            return positionTypeCode;
        }

        public Add setPositionTypeCode(String positionTypeCode) {
            this.positionTypeCode = positionTypeCode;
            return this;
        }

        public String getPositionTypeName() {
            return positionTypeName;
        }

        public Add setPositionTypeName(String positionTypeName) {
            this.positionTypeName = positionTypeName;
            return this;
        }

        public Date getServedTime() {
            return servedTime;
        }

        public Add setServedTime(Date servedTime) {
            this.servedTime = servedTime;
            return this;
        }

        public String getOperator() {
            return operator;
        }

        public Add setOperator(String operator) {
            this.operator = operator;
            return this;
        }

        public Integer getDel() {
            return del;
        }

        public Add setDel(Integer del) {
            this.del = del;
            return this;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public Add setCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public Date getUpdateTime() {
            return updateTime;
        }

        public Add setUpdateTime(Date updateTime) {
            this.updateTime = updateTime;
            return this;
        }
    }
    /**
     * @description: 批量添加
     * @author: zhangsq
     * @date: Created in 2020-10-21 11:17
     * @return:
     * @exception:
     */
    public static class BatchAdd {

        private List<UserOrgForm.Add> list;

        private Long userId;

        public List<Add> getList() {
            return list;
        }

        public BatchAdd setList(List<Add> list) {
            this.list = list;
            return this;
        }

        public Long getUserId() {
            return userId;
        }

        public BatchAdd setUserId(Long userId) {
            this.userId = userId;
            return this;
        }
    }

    /**
     * @description: 搜索
     * @author: zhangsq
     * @date: Created in 2020-10-19 15:25
     * @return:
     * @exception:
     */
    public static class Search{
        private String key;

        private Long userId;

        private Integer del;

        private List<String> orgIdList;

        public List<String> getOrgIdList() {
            return orgIdList;
        }

        public Search setOrgIdList(List<String> orgIdList) {
            this.orgIdList = orgIdList;
            return this;
        }

        public String getKey() {
            return key;
        }

        public Search setKey(String key) {
            this.key = key;
            return this;
        }

        public Long getUserId() {
            return userId;
        }

        public Search setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Integer getDel() {
            return del;
        }

        public Search setDel(Integer del) {
            this.del = del;
            return this;
        }
    }

    public static class Get{
        /**
         * 自增主键
         */
        private Long id;
        /**
         * 人员Id
         */
        private Long userId;
        /**
         * 组织机构Id
         */
        private String orgId;

        /**
         * 部门Id
         */
        private String deptId;

        /**
         * 妇联职位Id(字典表id)
         */
        private Integer womenPositionId;
        private String key;

        public Long getId() {
            return id;
        }

        public Get setId(Long id) {
            this.id = id;
            return this;
        }

        public String getKey() {
            return key;
        }

        public Get setKey(String key) {
            this.key = key;
            return this;
        }

        public Long getUserId() {
            return userId;
        }

        public Get setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public String getOrgId() {
            return orgId;
        }

        public Get setOrgId(String orgId) {
            this.orgId = orgId;
            return this;
        }

        public String getDeptId() {
            return deptId;
        }

        public Get setDeptId(String deptId) {
            this.deptId = deptId;
            return this;
        }

        public Integer getWomenPositionId() {
            return womenPositionId;
        }

        public Get setWomenPositionId(Integer womenPositionId) {
            this.womenPositionId = womenPositionId;
            return this;
        }
    }

    /**
     * @description: 编辑
     * @author: zhangsq
     * @date: Created in 2020-10-19 14:37
     * @return:
     * @exception:
     */
    public static class Edit{
        /**
         * 自增主键
         */
        private Long id;
        /**
         * 人员Id
         */
        private Long userId;
        /**
         * 组织机构Id
         */
        private String orgId;
        /**
         * 组织机构名称
         */
        private String orgName;
        /**
         * 部门Id
         */
        private String deptId;
        /**
         * 部门名称
         */
        private String deptName;
        /**
         * 妇联职位Id(字典表id)
         */
        private Integer womenPositionId;
        /**
         * 妇联职位
         */
        private String womenPosition;
        /**
         * 任职类型Code
         */
        private String positionTypeCode;
        /**
         * 任职类型名称
         */
        private String positionTypeName;
        /**
         * 任职时间
         */
        private Date servedTime;
        /**
         * 操作人
         */
        private String operator;
        /**
         * 是否删除0:正常,1:删除
         */
        private Integer del;
        /**
         * 创建时间
         */
        private Date createTime;
        /**
         * 修改时间
         */
        private Date updateTime;

        public Long getId() {
            return id;
        }

        public Edit setId(Long id) {
            this.id = id;
            return this;
        }

        public Long getUserId() {
            return userId;
        }

        public Edit setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public String getOrgId() {
            return orgId;
        }

        public Edit setOrgId(String orgId) {
            this.orgId = orgId;
            return this;
        }

        public String getOrgName() {
            return orgName;
        }

        public Edit setOrgName(String orgName) {
            this.orgName = orgName;
            return this;
        }

        public String getDeptId() {
            return deptId;
        }

        public Edit setDeptId(String deptId) {
            this.deptId = deptId;
            return this;
        }

        public String getDeptName() {
            return deptName;
        }

        public Edit setDeptName(String deptName) {
            this.deptName = deptName;
            return this;
        }

        public Integer getWomenPositionId() {
            return womenPositionId;
        }

        public Edit setWomenPositionId(Integer womenPositionId) {
            this.womenPositionId = womenPositionId;
            return this;
        }

        public String getWomenPosition() {
            return womenPosition;
        }

        public Edit setWomenPosition(String womenPosition) {
            this.womenPosition = womenPosition;
            return this;
        }

        public String getPositionTypeCode() {
            return positionTypeCode;
        }

        public Edit setPositionTypeCode(String positionTypeCode) {
            this.positionTypeCode = positionTypeCode;
            return this;
        }

        public String getPositionTypeName() {
            return positionTypeName;
        }

        public Edit setPositionTypeName(String positionTypeName) {
            this.positionTypeName = positionTypeName;
            return this;
        }

        public Date getServedTime() {
            return servedTime;
        }

        public Edit setServedTime(Date servedTime) {
            this.servedTime = servedTime;
            return this;
        }

        public String getOperator() {
            return operator;
        }

        public Edit setOperator(String operator) {
            this.operator = operator;
            return this;
        }

        public Integer getDel() {
            return del;
        }

        public Edit setDel(Integer del) {
            this.del = del;
            return this;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public Edit setCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public Date getUpdateTime() {
            return updateTime;
        }

        public Edit setUpdateTime(Date updateTime) {
            this.updateTime = updateTime;
            return this;
        }
    }

    /**
     * @description: 删除
     * @author: zhangsq
     * @date: Created in 2020-10-19 15:30
     * @return:
     * @exception:
     */
    public static class Del{
        /**
         * 自增主键
         */
        private Long userId;

        private Long id;

        public Long getUserId() {
            return userId;
        }

        public Del setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Long getId() {
            return id;
        }

        public Del setId(Long id) {
            this.id = id;
            return this;
        }
    }

    /**
     * @description: 批量删除
     * @author: zhangsq
     * @date: Created in 2020-10-21 10:58
     * @return:
     * @exception:
     */
    public static class batchDel{
        /**
         * '用户ID'
         */
        @NotEmpty(message = "主键不能为空")
        List<Long> userId;

        public List<Long> getUserId() {
            return userId;
        }

        public batchDel setUserId(List<Long> userId) {
            this.userId = userId;
            return this;
        }
    }

}
