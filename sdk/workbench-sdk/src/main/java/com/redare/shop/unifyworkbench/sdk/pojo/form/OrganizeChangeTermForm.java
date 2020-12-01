package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/10/19 10:36
 * @version:
 */
public class OrganizeChangeTermForm {

    public static class Search{
        private String key;
        private String orgId;
        private Long userId;
        private Integer del;

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
        @NotNull(message = "主键id不能为空")
        private Long id;

        public Long getId() {
            return id;
        }

        public Get setId(Long id) {
            this.id = id;
            return this;
        }
    }

    public static class Add{
        /**
         * 组织机构id
         */
        private String orgId;
        /**
         * 组织机构名称
         */
        private String orgName;
        /**
         * 换届信息
         */
        private String changeInfo;
        /**
         * 操作人员id
         */
        private Long userId;
        /**
         * 操作人员名称
         */
        private String userName;
        /**
         * 是否删除0:正常，1:删除
         */
        private Integer del;
        /**
         * 换届时间
         */
        private Date changeTime;
        /**
         * 创建时间
         */
        private Date createTime;
        /**
         * 更新时间
         */
        private Date updateTime;

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

        public String getChangeInfo() {
            return changeInfo;
        }

        public Add setChangeInfo(String changeInfo) {
            this.changeInfo = changeInfo;
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

        public Integer getDel() {
            return del;
        }

        public Add setDel(Integer del) {
            this.del = del;
            return this;
        }

        public Date getChangeTime() {
            return changeTime;
        }

        public Add setChangeTime(Date changeTime) {
            this.changeTime = changeTime;
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

    public static class Edit{
        private Long id;
        /**
         * 组织机构id
         */
        private String orgId;
        /**
         * 组织机构名称
         */
        private String orgName;
        /**
         * 换届信息
         */
        private String changeInfo;
        /**
         * 操作人员id
         */
        private Long userId;
        /**
         * 操作人员名称
         */
        private String userName;
        /**
         * 是否删除0:正常，1:删除
         */
        private Integer del;
        /**
         * 换届时间
         */
        private Date changeTime;
        /**
         * 创建时间
         */
        private Date createTime;
        /**
         * 更新时间
         */
        private Date updateTime;

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

        public String getChangeInfo() {
            return changeInfo;
        }

        public Edit setChangeInfo(String changeInfo) {
            this.changeInfo = changeInfo;
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

        public Integer getDel() {
            return del;
        }

        public Edit setDel(Integer del) {
            this.del = del;
            return this;
        }

        public Date getChangeTime() {
            return changeTime;
        }

        public Edit setChangeTime(Date changeTime) {
            this.changeTime = changeTime;
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

    public static class Del{
        @NotNull(message = "主键id不能为空")
        private Long id;
        private Integer del;

        public Long getId() {
            return id;
        }

        public Del setId(Long id) {
            this.id = id;
            return this;
        }

        public Integer getDel() {
            return del;
        }

        public Del setDel(Integer del) {
            this.del = del;
            return this;
        }
    }

    public static class BatchAdd{
        private List<OrganizeChangeTermForm.Add> list;
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
