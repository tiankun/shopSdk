package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/10/16 16:23
 * @version:
 */
public class DepartmentForm {

    public static class Search{
        private String key;
        private String orgId;
        private Integer status;

        public Integer getStatus() {
            return status;
        }

        public Search setStatus(Integer status) {
            this.status = status;
            return this;
        }

        public String getKey() {
            return key;
        }

        public Search setKey(String key) {
            this.key = key;
            return this;
        }

        public String getOrgId() {
            return orgId;
        }

        public Search setOrgId(String orgId) {
            this.orgId = orgId;
            return this;
        }
    }

    public static class Get{
        private Long id;
        private String departmentId;

        public Long getId() {
            return id;
        }

        public Get setId(Long id) {
            this.id = id;
            return this;
        }

        public String getDepartmentId() {
            return departmentId;
        }

        public Get setDepartmentId(String departmentId) {
            this.departmentId = departmentId;
            return this;
        }
    }

    public static class Add{
        private String orgId;
        private String orgName;
        private String departmentId;
        private String parentId;
        private String deptName;
        private Long userId;
        private String userName;
        private String departManageUserIdList;
        private String departIdTag;
        private String departIdLevel;
        private String departNameLevel;
        private Date createTime;
        private Date updateTime;
        private Integer status;

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

        public String getDepartmentId() {
            return departmentId;
        }

        public Add setDepartmentId(String departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public String getParentId() {
            return parentId;
        }

        public Add setParentId(String parentId) {
            this.parentId = parentId;
            return this;
        }

        public String getDeptName() {
            return deptName;
        }

        public Add setDeptName(String deptName) {
            this.deptName = deptName;
            return this;
        }

        public Long getUserId() {
            return userId;
        }

        public Add setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public String getUserName() {
            return userName;
        }

        public Add setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public String getDepartManageUserIdList() {
            return departManageUserIdList;
        }

        public Add setDepartManageUserIdList(String departManageUserIdList) {
            this.departManageUserIdList = departManageUserIdList;
            return this;
        }

        public String getDepartIdTag() {
            return departIdTag;
        }

        public Add setDepartIdTag(String departIdTag) {
            this.departIdTag = departIdTag;
            return this;
        }

        public String getDepartIdLevel() {
            return departIdLevel;
        }

        public Add setDepartIdLevel(String departIdLevel) {
            this.departIdLevel = departIdLevel;
            return this;
        }

        public String getDepartNameLevel() {
            return departNameLevel;
        }

        public Add setDepartNameLevel(String departNameLevel) {
            this.departNameLevel = departNameLevel;
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

        public Integer getStatus() {
            return status;
        }

        public Add setStatus(Integer status) {
            this.status = status;
            return this;
        }
    }

    public static class Edit{
        private Long id;
        private String orgId;
        private String orgName;
        private String departmentId;
        private String parentId;
        private String deptName;
        private Long userId;
        private String userName;
        private String departManageUserIdList;
        private String departIdTag;
        private String departIdLevel;
        private String departNameLevel;
        private Date createTime;
        private Date updateTime;
        private Integer status;

        public Long getId() {
            return id;
        }

        public Edit setId(Long id) {
            this.id = id;
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

        public String getDepartmentId() {
            return departmentId;
        }

        public Edit setDepartmentId(String departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public String getParentId() {
            return parentId;
        }

        public Edit setParentId(String parentId) {
            this.parentId = parentId;
            return this;
        }

        public String getDeptName() {
            return deptName;
        }

        public Edit setDeptName(String deptName) {
            this.deptName = deptName;
            return this;
        }

        public Long getUserId() {
            return userId;
        }

        public Edit setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public String getUserName() {
            return userName;
        }

        public Edit setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public String getDepartManageUserIdList() {
            return departManageUserIdList;
        }

        public Edit setDepartManageUserIdList(String departManageUserIdList) {
            this.departManageUserIdList = departManageUserIdList;
            return this;
        }

        public String getDepartIdTag() {
            return departIdTag;
        }

        public Edit setDepartIdTag(String departIdTag) {
            this.departIdTag = departIdTag;
            return this;
        }

        public String getDepartIdLevel() {
            return departIdLevel;
        }

        public Edit setDepartIdLevel(String departIdLevel) {
            this.departIdLevel = departIdLevel;
            return this;
        }

        public String getDepartNameLevel() {
            return departNameLevel;
        }

        public Edit setDepartNameLevel(String departNameLevel) {
            this.departNameLevel = departNameLevel;
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

        public Integer getStatus() {
            return status;
        }

        public Edit setStatus(Integer status) {
            this.status = status;
            return this;
        }
    }

    public static class Del{
        @NotNull(message = "主键id不能为空")
        private Long id;

        public Long getId() {
            return id;
        }

        public Del setId(Long id) {
            this.id = id;
            return this;
        }
    }

    public static class BatchAdd{
        private List<DepartmentForm.Add> list;
        private String orgId;
        private String orgName;
        private Long userId;
        private String userName;

        public Long getUserId() {
            return userId;
        }

        public BatchAdd setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public String getUserName() {
            return userName;
        }

        public BatchAdd setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public String getOrgName() {
            return orgName;
        }

        public BatchAdd setOrgName(String orgName) {
            this.orgName = orgName;
            return this;
        }

        public List<Add> getList() {
            return list;
        }

        public BatchAdd setList(List<Add> list) {
            this.list = list;
            return this;
        }

        public String getOrgId() {
            return orgId;
        }

        public BatchAdd setOrgId(String orgId) {
            this.orgId = orgId;
            return this;
        }
    }

    public static class DelByOrgId{
        private String orgId;

        public String getOrgId() {
            return orgId;
        }

        public DelByOrgId setOrgId(String orgId) {
            this.orgId = orgId;
            return this;
        }
    }
}
