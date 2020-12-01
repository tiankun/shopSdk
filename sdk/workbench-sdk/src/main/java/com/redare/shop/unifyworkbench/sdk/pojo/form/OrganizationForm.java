package com.redare.shop.unifyworkbench.sdk.pojo.form;

import com.redare.shop.unifyworkbench.sdk.common.pojo.BaseLevelTreeQuery;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * 组织机构表(Organization)Form
 *
 * @author makejava
 * @since 2020-10-16 11:48:28
 */
public class OrganizationForm {

    public static class Search extends CommonForm.Search {

        /**
         * 自增主键，不要用
         */
        private Long id;
        /**
         * 组织机构Id
         */
        private String orgId;
        /**
         * 机构名称
         */
        private String orgName;
        /**
         * 机构简称
         */
        private String shortName;
        /**
         * 行政编码
         */
        private String areaCode;
        /**
         * 行政名称
         */
        private String areaName;
        /**
         * 机构类型code
         */
        private String orgTypeCode;
        /**
         * 组织分类：hx-横向组织；zx-纵向组织
         */
        private String orgClassify;
        /**
         * 机构类型名称
         */
        private String orgTypeName;
        /**
         * 组织介绍
         */
        private String orgIntroduce;
        /**
         * 妇联主席
         */
        private String chairman;
        /**
         * 联系人
         */
        private String contact;
        /**
         * 联系人电话
         */
        private String telephone;
        /**
         * 父Id
         */
        private String parentId;
        /**
         * 层级
         */
        private Integer level;
        /**
         * 是否节点
         */
        private Integer isLeaf;
        /**
         * 备注
         */
        private String remark;
        /**
         * 组织机构的管理人员列表
         */
        private String orgManageUserIdList;
        /**
         * 组织机构Id层级标识
         */
        private String orgIdTag;
        /**
         * 组织机构IDLevel
         */
        private String orgIdLevel;
        /**
         * 组织机构名称层级
         */
        private String orgNameLevel;
        /**
         * 操作人员id
         */
        private Long userId;
        /**
         * 操作人员名称
         */
        private String userName;
        /**
         * 创建时间
         */
        private Date createTime;
        /**
         * 修改时间
         */
        private Date updateTime;
        /**
         * 状态1：正常，0：，-1:删除
         */
        private Integer status;

        private List<String> orgIds;

        private List<String> areaCodes;

        private List<String> orgTypeCodeList;

        private BaseLevelTreeQuery baseLevelTreeQuery;

        public BaseLevelTreeQuery getBaseLevelTreeQuery() {
            return baseLevelTreeQuery;
        }

        public Search setBaseLevelTreeQuery(BaseLevelTreeQuery baseLevelTreeQuery) {
            this.baseLevelTreeQuery = baseLevelTreeQuery;
            return this;
        }

        public List<String> getOrgIds() {
            return orgIds;
        }

        public Search setOrgIds(List<String> orgIds) {
            this.orgIds = orgIds;
            return this;
        }

        public List<String> getAreaCodes() {
            return areaCodes;
        }

        public Search setAreaCodes(List<String> areaCodes) {
            this.areaCodes = areaCodes;
            return this;
        }

        public Long getId() {
            return id;
        }

        public Search setId(Long id) {
            this.id = id;
            return this;
        }

        public String getOrgId() {
            return orgId;
        }

        public Search setOrgId(String orgId) {
            this.orgId = orgId;
            return this;
        }

        public String getOrgName() {
            return orgName;
        }

        public Search setOrgName(String orgName) {
            this.orgName = orgName;
            return this;
        }

        public String getShortName() {
            return shortName;
        }

        public Search setShortName(String shortName) {
            this.shortName = shortName;
            return this;
        }

        public String getAreaCode() {
            return areaCode;
        }

        public Search setAreaCode(String areaCode) {
            this.areaCode = areaCode;
            return this;
        }

        public String getAreaName() {
            return areaName;
        }

        public Search setAreaName(String areaName) {
            this.areaName = areaName;
            return this;
        }

        public String getOrgTypeCode() {
            return orgTypeCode;
        }

        public Search setOrgTypeCode(String orgTypeCode) {
            this.orgTypeCode = orgTypeCode;
            return this;
        }

        public String getOrgClassify() {
            return orgClassify;
        }

        public Search setOrgClassify(String orgClassify) {
            this.orgClassify = orgClassify;
            return this;
        }

        public String getOrgTypeName() {
            return orgTypeName;
        }

        public Search setOrgTypeName(String orgTypeName) {
            this.orgTypeName = orgTypeName;
            return this;
        }

        public String getOrgIntroduce() {
            return orgIntroduce;
        }

        public Search setOrgIntroduce(String orgIntroduce) {
            this.orgIntroduce = orgIntroduce;
            return this;
        }

        public String getChairman() {
            return chairman;
        }

        public Search setChairman(String chairman) {
            this.chairman = chairman;
            return this;
        }

        public String getContact() {
            return contact;
        }

        public Search setContact(String contact) {
            this.contact = contact;
            return this;
        }

        public String getTelephone() {
            return telephone;
        }

        public Search setTelephone(String telephone) {
            this.telephone = telephone;
            return this;
        }

        public String getParentId() {
            return parentId;
        }

        public Search setParentId(String parentId) {
            this.parentId = parentId;
            return this;
        }

        public Integer getLevel() {
            return level;
        }

        public Search setLevel(Integer level) {
            this.level = level;
            return this;
        }

        public Integer getIsLeaf() {
            return isLeaf;
        }

        public Search setIsLeaf(Integer isLeaf) {
            this.isLeaf = isLeaf;
            return this;
        }

        public String getRemark() {
            return remark;
        }

        public Search setRemark(String remark) {
            this.remark = remark;
            return this;
        }

        public String getOrgManageUserIdList() {
            return orgManageUserIdList;
        }

        public Search setOrgManageUserIdList(String orgManageUserIdList) {
            this.orgManageUserIdList = orgManageUserIdList;
            return this;
        }

        public String getOrgIdTag() {
            return orgIdTag;
        }

        public Search setOrgIdTag(String orgIdTag) {
            this.orgIdTag = orgIdTag;
            return this;
        }

        public String getOrgIdLevel() {
            return orgIdLevel;
        }

        public Search setOrgIdLevel(String orgIdLevel) {
            this.orgIdLevel = orgIdLevel;
            return this;
        }

        public String getOrgNameLevel() {
            return orgNameLevel;
        }

        public Search setOrgNameLevel(String orgNameLevel) {
            this.orgNameLevel = orgNameLevel;
            return this;
        }

        public Long getUserId() {
            return userId;
        }

        public Search setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public String getUserName() {
            return userName;
        }

        public Search setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public Search setCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public Date getUpdateTime() {
            return updateTime;
        }

        public Search setUpdateTime(Date updateTime) {
            this.updateTime = updateTime;
            return this;
        }

        public Integer getStatus() {
            return status;
        }

        public Search setStatus(Integer status) {
            this.status = status;
            return this;
        }

        public List<String> getOrgTypeCodeList() {
            return orgTypeCodeList;
        }

        public Search setOrgTypeCodeList(List<String> orgTypeCodeList) {
            this.orgTypeCodeList = orgTypeCodeList;
            return this;
        }
    }

    public static class Get{
        private Long id;
        @NotBlank(message = "组织机构id不能为空")
        private String orgId;

        public Long getId() {
            return id;
        }

        public Get setId(Long id) {
            this.id = id;
            return this;
        }

        public String getOrgId() {
            return orgId;
        }

        public Get setOrgId(String orgId) {
            this.orgId = orgId;
            return this;
        }
    }

    public static class Add{
        private String orgId;
        private String orgName;
        private String shortName;
        private String areaCode;
        private Integer areaLevel;
        private String areaName;
        private String orgTypeCode;
        private String orgClassify;
        private String orgTypeName;
        private String orgIntroduce;
        private String chairman;
        private String contact;
        private String telephone;
        private String parentId;
        private Integer level;
        private Integer isLeaf;
        private String remark;
        private String orgManageUserIdList;
        private String orgIdTag;
        private String orgIdLevel;
        private String orgNameLevel;
        private Long userId;
        private String userName;
        private Date createTime;
        private Date updateTime;
        private Integer status;
        //添加部门集合
        private List<DepartmentForm.Add> addDepartmentList;
        //编辑部门集合
        private List<DepartmentForm.Edit> editDepartmentList;
        //删除部门集合
        private List<String> delDepartmentList;
        private List<OrganizeChangeTermForm.Add> organizeChangeTermList;
        private List<OrganizeHonorForm.Add> organizeHonorList;

        public List<DepartmentForm.Add> getAddDepartmentList() {
            return addDepartmentList;
        }

        public Add setAddDepartmentList(List<DepartmentForm.Add> addDepartmentList) {
            this.addDepartmentList = addDepartmentList;
            return this;
        }

        public List<DepartmentForm.Edit> getEditDepartmentList() {
            return editDepartmentList;
        }

        public Add setEditDepartmentList(List<DepartmentForm.Edit> editDepartmentList) {
            this.editDepartmentList = editDepartmentList;
            return this;
        }

        public List<String> getDelDepartmentList() {
            return delDepartmentList;
        }

        public Add setDelDepartmentList(List<String> delDepartmentList) {
            this.delDepartmentList = delDepartmentList;
            return this;
        }

        public List<OrganizeChangeTermForm.Add> getOrganizeChangeTermList() {
            return organizeChangeTermList;
        }

        public Add setOrganizeChangeTermList(List<OrganizeChangeTermForm.Add> organizeChangeTermList) {
            this.organizeChangeTermList = organizeChangeTermList;
            return this;
        }

        public List<OrganizeHonorForm.Add> getOrganizeHonorList() {
            return organizeHonorList;
        }

        public Add setOrganizeHonorList(List<OrganizeHonorForm.Add> organizeHonorList) {
            this.organizeHonorList = organizeHonorList;
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

        public String getShortName() {
            return shortName;
        }

        public Add setShortName(String shortName) {
            this.shortName = shortName;
            return this;
        }

        public String getAreaCode() {
            return areaCode;
        }

        public Add setAreaCode(String areaCode) {
            this.areaCode = areaCode;
            return this;
        }

        public Integer getAreaLevel() {
            return areaLevel;
        }

        public Add setAreaLevel(Integer areaLevel) {
            this.areaLevel = areaLevel;
            return this;
        }

        public String getAreaName() {
            return areaName;
        }

        public Add setAreaName(String areaName) {
            this.areaName = areaName;
            return this;
        }

        public String getOrgTypeCode() {
            return orgTypeCode;
        }

        public Add setOrgTypeCode(String orgTypeCode) {
            this.orgTypeCode = orgTypeCode;
            return this;
        }

        public String getOrgClassify() {
            return orgClassify;
        }

        public Add setOrgClassify(String orgClassify) {
            this.orgClassify = orgClassify;
            return this;
        }

        public String getOrgTypeName() {
            return orgTypeName;
        }

        public Add setOrgTypeName(String orgTypeName) {
            this.orgTypeName = orgTypeName;
            return this;
        }

        public String getOrgIntroduce() {
            return orgIntroduce;
        }

        public Add setOrgIntroduce(String orgIntroduce) {
            this.orgIntroduce = orgIntroduce;
            return this;
        }

        public String getChairman() {
            return chairman;
        }

        public Add setChairman(String chairman) {
            this.chairman = chairman;
            return this;
        }

        public String getContact() {
            return contact;
        }

        public Add setContact(String contact) {
            this.contact = contact;
            return this;
        }

        public String getTelephone() {
            return telephone;
        }

        public Add setTelephone(String telephone) {
            this.telephone = telephone;
            return this;
        }

        public String getParentId() {
            return parentId;
        }

        public Add setParentId(String parentId) {
            this.parentId = parentId;
            return this;
        }

        public Integer getLevel() {
            return level;
        }

        public Add setLevel(Integer level) {
            this.level = level;
            return this;
        }

        public Integer getIsLeaf() {
            return isLeaf;
        }

        public Add setIsLeaf(Integer isLeaf) {
            this.isLeaf = isLeaf;
            return this;
        }

        public String getRemark() {
            return remark;
        }

        public Add setRemark(String remark) {
            this.remark = remark;
            return this;
        }

        public String getOrgManageUserIdList() {
            return orgManageUserIdList;
        }

        public Add setOrgManageUserIdList(String orgManageUserIdList) {
            this.orgManageUserIdList = orgManageUserIdList;
            return this;
        }

        public String getOrgIdTag() {
            return orgIdTag;
        }

        public Add setOrgIdTag(String orgIdTag) {
            this.orgIdTag = orgIdTag;
            return this;
        }

        public String getOrgIdLevel() {
            return orgIdLevel;
        }

        public Add setOrgIdLevel(String orgIdLevel) {
            this.orgIdLevel = orgIdLevel;
            return this;
        }

        public String getOrgNameLevel() {
            return orgNameLevel;
        }

        public Add setOrgNameLevel(String orgNameLevel) {
            this.orgNameLevel = orgNameLevel;
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
        @NotNull(message = "主键id不能为空")
        private Long id;
        private String orgId;
        private String orgName;
        private String shortName;
        private String areaCode;
        private Integer areaLevel;
        private String areaName;
        private String orgTypeCode;
        private String orgClassify;
        private String orgTypeName;
        private String orgIntroduce;
        private String chairman;
        private String contact;
        private String telephone;
        private String parentId;
        private Integer level;
        private Integer isLeaf;
        private String remark;
        private String orgManageUserIdList;
        private String orgIdTag;
        private String orgIdLevel;
        private String orgNameLevel;
        private Long userId;
        private String userName;
        private Date createTime;
        private Date updateTime;
        private Integer status;
        //添加部门集合
        private List<DepartmentForm.Add> addDepartmentList;
        //编辑部门集合
        private List<DepartmentForm.Edit> editDepartmentList;
        //删除部门集合
        private List<String> delDepartmentList;
        private List<OrganizeChangeTermForm.Edit> organizeChangeTermList;
        private List<OrganizeHonorForm.Edit> organizeHonorList;

        public List<DepartmentForm.Add> getAddDepartmentList() {
            return addDepartmentList;
        }

        public Edit setAddDepartmentList(List<DepartmentForm.Add> addDepartmentList) {
            this.addDepartmentList = addDepartmentList;
            return this;
        }

        public List<DepartmentForm.Edit> getEditDepartmentList() {
            return editDepartmentList;
        }

        public Edit setEditDepartmentList(List<DepartmentForm.Edit> editDepartmentList) {
            this.editDepartmentList = editDepartmentList;
            return this;
        }

        public List<String> getDelDepartmentList() {
            return delDepartmentList;
        }

        public Edit setDelDepartmentList(List<String> delDepartmentList) {
            this.delDepartmentList = delDepartmentList;
            return this;
        }

        public List<OrganizeChangeTermForm.Edit> getOrganizeChangeTermList() {
            return organizeChangeTermList;
        }

        public Edit setOrganizeChangeTermList(List<OrganizeChangeTermForm.Edit> organizeChangeTermList) {
            this.organizeChangeTermList = organizeChangeTermList;
            return this;
        }

        public List<OrganizeHonorForm.Edit> getOrganizeHonorList() {
            return organizeHonorList;
        }

        public Edit setOrganizeHonorList(List<OrganizeHonorForm.Edit> organizeHonorList) {
            this.organizeHonorList = organizeHonorList;
            return this;
        }

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

        public String getShortName() {
            return shortName;
        }

        public Edit setShortName(String shortName) {
            this.shortName = shortName;
            return this;
        }

        public String getAreaCode() {
            return areaCode;
        }

        public Edit setAreaCode(String areaCode) {
            this.areaCode = areaCode;
            return this;
        }

        public Integer getAreaLevel() {
            return areaLevel;
        }

        public Edit setAreaLevel(Integer areaLevel) {
            this.areaLevel = areaLevel;
            return this;
        }

        public String getAreaName() {
            return areaName;
        }

        public Edit setAreaName(String areaName) {
            this.areaName = areaName;
            return this;
        }

        public String getOrgTypeCode() {
            return orgTypeCode;
        }

        public Edit setOrgTypeCode(String orgTypeCode) {
            this.orgTypeCode = orgTypeCode;
            return this;
        }

        public String getOrgClassify() {
            return orgClassify;
        }

        public Edit setOrgClassify(String orgClassify) {
            this.orgClassify = orgClassify;
            return this;
        }

        public String getOrgTypeName() {
            return orgTypeName;
        }

        public Edit setOrgTypeName(String orgTypeName) {
            this.orgTypeName = orgTypeName;
            return this;
        }

        public String getOrgIntroduce() {
            return orgIntroduce;
        }

        public Edit setOrgIntroduce(String orgIntroduce) {
            this.orgIntroduce = orgIntroduce;
            return this;
        }

        public String getChairman() {
            return chairman;
        }

        public Edit setChairman(String chairman) {
            this.chairman = chairman;
            return this;
        }

        public String getContact() {
            return contact;
        }

        public Edit setContact(String contact) {
            this.contact = contact;
            return this;
        }

        public String getTelephone() {
            return telephone;
        }

        public Edit setTelephone(String telephone) {
            this.telephone = telephone;
            return this;
        }

        public String getParentId() {
            return parentId;
        }

        public Edit setParentId(String parentId) {
            this.parentId = parentId;
            return this;
        }

        public Integer getLevel() {
            return level;
        }

        public Edit setLevel(Integer level) {
            this.level = level;
            return this;
        }

        public Integer getIsLeaf() {
            return isLeaf;
        }

        public Edit setIsLeaf(Integer isLeaf) {
            this.isLeaf = isLeaf;
            return this;
        }

        public String getRemark() {
            return remark;
        }

        public Edit setRemark(String remark) {
            this.remark = remark;
            return this;
        }

        public String getOrgManageUserIdList() {
            return orgManageUserIdList;
        }

        public Edit setOrgManageUserIdList(String orgManageUserIdList) {
            this.orgManageUserIdList = orgManageUserIdList;
            return this;
        }

        public String getOrgIdTag() {
            return orgIdTag;
        }

        public Edit setOrgIdTag(String orgIdTag) {
            this.orgIdTag = orgIdTag;
            return this;
        }

        public String getOrgIdLevel() {
            return orgIdLevel;
        }

        public Edit setOrgIdLevel(String orgIdLevel) {
            this.orgIdLevel = orgIdLevel;
            return this;
        }

        public String getOrgNameLevel() {
            return orgNameLevel;
        }

        public Edit setOrgNameLevel(String orgNameLevel) {
            this.orgNameLevel = orgNameLevel;
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

    public static class BatchDel {
        @NotEmpty(message = "组织机构id不能为空")
        List<String> orgIdList;

        public List<String> getOrgIdList() {
            return orgIdList;
        }

        public BatchDel setOrgIdList(List<String> orgIdList) {
            this.orgIdList = orgIdList;
            return this;
        }

    }

}