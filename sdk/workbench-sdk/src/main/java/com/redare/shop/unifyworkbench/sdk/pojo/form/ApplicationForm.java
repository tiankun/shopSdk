package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * ApplicationForm
 * 表：t_application
 *
 * @Author zlx
 * @Date 2020/4/23 10:54
 */
public class ApplicationForm {

    public static class Search{
        private String sysCode;
        private String key;
        private String name;
        private String icon;
        private Long userId;
        private String classify;
        private Integer isShowApp;
        private Integer isShowPC;

        public Integer getIsShowPC() {
            return isShowPC;
        }

        public Search setIsShowPC(Integer isShowPC) {
            this.isShowPC = isShowPC;
            return this;
        }

        public Integer getIsShowApp() {
            return isShowApp;
        }

        public Search setIsShowApp(Integer isShowApp) {
            this.isShowApp = isShowApp;
            return this;
        }

        public String getSysCode() {
            return sysCode;
        }

        public Search setSysCode(String sysCode) {
            this.sysCode = sysCode;
            return this;
        }

        public String getClassify() {
            return classify;
        }

        public Search setClassify(String classify) {
            this.classify = classify;
            return this;
        }

        public Long getUserId() {
            return userId;
        }

        public Search setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public String getKey() {
            return key;
        }

        public Search setKey(String key) {
            this.key = key;
            return this;
        }

        public String getName() {
            return name;
        }

        public Search setName(String name) {
            this.name = name;
            return this;
        }

        public String getIcon() {
            return icon;
        }

        public Search setIcon(String icon) {
            this.icon = icon;
            return this;
        }
    }

    public static  class Get{
        @NotNull(message = "主键不能为空")
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
        @NotBlank(message = "sysCode不能为空")
        private String sysCode;
        @NotBlank(message = "应用名称不能为空")
        private String name;
        private String icon;
        @NotBlank(message = "分类不能为空")
        private String classify;
        @NotBlank(message = "访问Code不能为空")
        private String accessCode;
        @NotBlank(message = "访问密钥不能为空")
        private String accessKey;
        @NotBlank(message = "应用访问链接不能为空")
        private String appAccessUrl;
        private String appAccessHeadParam;
        private String appAccessBodyParam;
        @NotBlank(message = "验证用户名密码的请求地址不能为空")
        private String verifyUrl;
        private String verifyHeadParam;
        @NotBlank(message = "验证账号密码请求体参数不能为空")
        private String verifyBodyParam;
        @NotBlank(message = "验证账号密码响应参数不能为空")
        private String verifyResponseParam;
        @NotBlank(message = "待办事项请求地址不能为空")
        private String gtasksUrl;
        private String gtasksHeadParam;
        private String gtasksBodyParam;
        private String remark;
        private String roleIds;
        private List<Long> roleIdList;
        private String roleNames;
        private Date createTime;
        private Integer sort;
        private Integer showApp;
        private Integer showPage;
        private String pageUrl;
        private Integer status;
        private String appPage;
        private Integer isShowApp;
        private String orgIds;
        private String orgNames;
        private List<Long> orgIdList;
        private Integer isShowPC;
        private Integer verifyAccountAndPwd;
        private String pcRoleIds;
        private String pcOrgIds;
        private List<Long> pcRoleIdList;
        private List<Long> pcOrgIdList;

        public String getPcRoleIds() {
            return pcRoleIds;
        }

        public Add setPcRoleIds(String pcRoleIds) {
            this.pcRoleIds = pcRoleIds;
            return this;
        }

        public String getPcOrgIds() {
            return pcOrgIds;
        }

        public Add setPcOrgIds(String pcOrgIds) {
            this.pcOrgIds = pcOrgIds;
            return this;
        }

        public List<Long> getPcRoleIdList() {
            return pcRoleIdList;
        }

        public Add setPcRoleIdList(List<Long> pcRoleIdList) {
            this.pcRoleIdList = pcRoleIdList;
            return this;
        }

        public List<Long> getPcOrgIdList() {
            return pcOrgIdList;
        }

        public Add setPcOrgIdList(List<Long> pcOrgIdList) {
            this.pcOrgIdList = pcOrgIdList;
            return this;
        }

        public Integer getVerifyAccountAndPwd() {
            return verifyAccountAndPwd;
        }

        public Add setVerifyAccountAndPwd(Integer verifyAccountAndPwd) {
            this.verifyAccountAndPwd = verifyAccountAndPwd;
            return this;
        }

        public Integer getIsShowPC() {
            return isShowPC;
        }

        public Add setIsShowPC(Integer isShowPC) {
            this.isShowPC = isShowPC;
            return this;
        }

        public String getOrgIds() {
            return orgIds;
        }

        public Add setOrgIds(String orgIds) {
            this.orgIds = orgIds;
            return this;
        }

        public String getOrgNames() {
            return orgNames;
        }

        public Add setOrgNames(String orgNames) {
            this.orgNames = orgNames;
            return this;
        }

        public List<Long> getOrgIdList() {
            return orgIdList;
        }

        public Add setOrgIdList(List<Long> orgIdList) {
            this.orgIdList = orgIdList;
            return this;
        }

        public String getAppPage() {
            return appPage;
        }

        public Add setAppPage(String appPage) {
            this.appPage = appPage;
            return this;
        }

        public Integer getIsShowApp() {
            return isShowApp;
        }

        public Add setIsShowApp(Integer isShowApp) {
            this.isShowApp = isShowApp;
            return this;
        }

        public Integer getShowApp() {
            return showApp;
        }

        public Add setShowApp(Integer showApp) {
            this.showApp = showApp;
            return this;
        }

        public Integer getShowPage() {
            return showPage;
        }

        public Add setShowPage(Integer showPage) {
            this.showPage = showPage;
            return this;
        }

        public String getPageUrl() {
            return pageUrl;
        }

        public Add setPageUrl(String pageUrl) {
            this.pageUrl = pageUrl;
            return this;
        }

        public Integer getStatus() {
            return status;
        }

        public Add setStatus(Integer status) {
            this.status = status;
            return this;
        }

        public String getSysCode() {
            return sysCode;
        }

        public Add setSysCode(String sysCode) {
            this.sysCode = sysCode;
            return this;
        }

        public String getName() {
            return name;
        }

        public Add setName(String name) {
            this.name = name;
            return this;
        }

        public String getIcon() {
            return icon;
        }

        public Add setIcon(String icon) {
            this.icon = icon;
            return this;
        }

        public String getClassify() {
            return classify;
        }

        public Add setClassify(String classify) {
            this.classify = classify;
            return this;
        }

        public String getAccessCode() {
            return accessCode;
        }

        public Add setAccessCode(String accessCode) {
            this.accessCode = accessCode;
            return this;
        }

        public String getAccessKey() {
            return accessKey;
        }

        public Add setAccessKey(String accessKey) {
            this.accessKey = accessKey;
            return this;
        }

        public String getAppAccessUrl() {
            return appAccessUrl;
        }

        public Add setAppAccessUrl(String appAccessUrl) {
            this.appAccessUrl = appAccessUrl;
            return this;
        }

        public String getAppAccessHeadParam() {
            return appAccessHeadParam;
        }

        public Add setAppAccessHeadParam(String appAccessHeadParam) {
            this.appAccessHeadParam = appAccessHeadParam;
            return this;
        }

        public String getAppAccessBodyParam() {
            return appAccessBodyParam;
        }

        public Add setAppAccessBodyParam(String appAccessBodyParam) {
            this.appAccessBodyParam = appAccessBodyParam;
            return this;
        }

        public String getVerifyUrl() {
            return verifyUrl;
        }

        public Add setVerifyUrl(String verifyUrl) {
            this.verifyUrl = verifyUrl;
            return this;
        }

        public String getVerifyHeadParam() {
            return verifyHeadParam;
        }

        public Add setVerifyHeadParam(String verifyHeadParam) {
            this.verifyHeadParam = verifyHeadParam;
            return this;
        }

        public String getVerifyBodyParam() {
            return verifyBodyParam;
        }

        public Add setVerifyBodyParam(String verifyBodyParam) {
            this.verifyBodyParam = verifyBodyParam;
            return this;
        }

        public String getVerifyResponseParam() {
            return verifyResponseParam;
        }

        public Add setVerifyResponseParam(String verifyResponseParam) {
            this.verifyResponseParam = verifyResponseParam;
            return this;
        }

        public String getGtasksUrl() {
            return gtasksUrl;
        }

        public Add setGtasksUrl(String gtasksUrl) {
            this.gtasksUrl = gtasksUrl;
            return this;
        }

        public String getGtasksHeadParam() {
            return gtasksHeadParam;
        }

        public Add setGtasksHeadParam(String gtasksHeadParam) {
            this.gtasksHeadParam = gtasksHeadParam;
            return this;
        }

        public String getGtasksBodyParam() {
            return gtasksBodyParam;
        }

        public Add setGtasksBodyParam(String gtasksBodyParam) {
            this.gtasksBodyParam = gtasksBodyParam;
            return this;
        }

        public String getRemark() {
            return remark;
        }

        public Add setRemark(String remark) {
            this.remark = remark;
            return this;
        }

        public String getRoleIds() {
            return roleIds;
        }

        public Add setRoleIds(String roleIds) {
            this.roleIds = roleIds;
            return this;
        }

        public List<Long> getRoleIdList() {
            return roleIdList;
        }

        public Add setRoleIdList(List<Long> roleIdList) {
            this.roleIdList = roleIdList;
            return this;
        }

        public String getRoleNames() {
            return roleNames;
        }

        public Add setRoleNames(String roleNames) {
            this.roleNames = roleNames;
            return this;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public Add setCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public Integer getSort() {
            return sort;
        }

        public Add setSort(Integer sort) {
            this.sort = sort;
            return this;
        }
    }

    public static class Edit{
        @NotNull(message = "主键不能为空")
        private Long id;
        @NotBlank(message = "sysCode不能为空")
        private String sysCode;
        @NotBlank(message = "应用名称不能为空")
        private String name;
        private String icon;
        @NotBlank(message = "分类不能为空")
        private String classify;
        @NotBlank(message = "访问Code不能为空")
        private String accessCode;
        @NotBlank(message = "访问密钥不能为空")
        private String accessKey;
        @NotBlank(message = "应用访问链接不能为空")
        private String appAccessUrl;
        private String appAccessHeadParam;
        private String appAccessBodyParam;
        @NotBlank(message = "验证用户名密码的请求地址不能为空")
        private String verifyUrl;
        private String verifyHeadParam;
        @NotBlank(message = "验证账号密码请求体参数不能为空")
        private String verifyBodyParam;
        @NotBlank(message = "验证账号密码响应参数不能为空")
        private String verifyResponseParam;
        @NotBlank(message = "待办事项请求地址不能为空")
        private String gtasksUrl;
        private String gtasksHeadParam;
        private String gtasksBodyParam;
        private String remark;
        private String roleIds;
        private List<Long> roleIdList;
        private String roleNames;
        private Date createTime;
        private Integer sort;
        private Integer showApp;
        private Integer showPage;
        private String pageUrl;
        private Integer status;
        private String appPage;
        private Integer isShowApp;
        private String orgIds;
        private String orgNames;
        private List<Long> orgIdList;
        private Integer isShowPC;
        private Integer verifyAccountAndPwd;
        private String pcRoleIds;
        private String pcOrgIds;
        private List<Long> pcRoleIdList;
        private List<Long> pcOrgIdList;

        public String getPcRoleIds() {
            return pcRoleIds;
        }

        public Edit setPcRoleIds(String pcRoleIds) {
            this.pcRoleIds = pcRoleIds;
            return this;
        }

        public String getPcOrgIds() {
            return pcOrgIds;
        }

        public Edit setPcOrgIds(String pcOrgIds) {
            this.pcOrgIds = pcOrgIds;
            return this;
        }

        public List<Long> getPcRoleIdList() {
            return pcRoleIdList;
        }

        public Edit setPcRoleIdList(List<Long> pcRoleIdList) {
            this.pcRoleIdList = pcRoleIdList;
            return this;
        }

        public List<Long> getPcOrgIdList() {
            return pcOrgIdList;
        }

        public Edit setPcOrgIdList(List<Long> pcOrgIdList) {
            this.pcOrgIdList = pcOrgIdList;
            return this;
        }

        public Integer getVerifyAccountAndPwd() {
            return verifyAccountAndPwd;
        }

        public Edit setVerifyAccountAndPwd(Integer verifyAccountAndPwd) {
            this.verifyAccountAndPwd = verifyAccountAndPwd;
            return this;
        }

        public Integer getIsShowPC() {
            return isShowPC;
        }

        public Edit setIsShowPC(Integer isShowPC) {
            this.isShowPC = isShowPC;
            return this;
        }

        public String getOrgIds() {
            return orgIds;
        }

        public Edit setOrgIds(String orgIds) {
            this.orgIds = orgIds;
            return this;
        }

        public String getOrgNames() {
            return orgNames;
        }

        public Edit setOrgNames(String orgNames) {
            this.orgNames = orgNames;
            return this;
        }

        public List<Long> getOrgIdList() {
            return orgIdList;
        }

        public Edit setOrgIdList(List<Long> orgIdList) {
            this.orgIdList = orgIdList;
            return this;
        }

        public String getAppPage() {
            return appPage;
        }

        public Edit setAppPage(String appPage) {
            this.appPage = appPage;
            return this;
        }

        public Integer getIsShowApp() {
            return isShowApp;
        }

        public Edit setIsShowApp(Integer isShowApp) {
            this.isShowApp = isShowApp;
            return this;
        }

        public Integer getShowApp() {
            return showApp;
        }

        public Edit setShowApp(Integer showApp) {
            this.showApp = showApp;
            return this;
        }

        public Integer getShowPage() {
            return showPage;
        }

        public Edit setShowPage(Integer showPage) {
            this.showPage = showPage;
            return this;
        }

        public String getPageUrl() {
            return pageUrl;
        }

        public Edit setPageUrl(String pageUrl) {
            this.pageUrl = pageUrl;
            return this;
        }

        public Integer getStatus() {
            return status;
        }

        public Edit setStatus(Integer status) {
            this.status = status;
            return this;
        }

        public Long getId() {
            return id;
        }

        public Edit setId(Long id) {
            this.id = id;
            return this;
        }

        public String getSysCode() {
            return sysCode;
        }

        public Edit setSysCode(String sysCode) {
            this.sysCode = sysCode;
            return this;
        }

        public String getName() {
            return name;
        }

        public Edit setName(String name) {
            this.name = name;
            return this;
        }

        public String getIcon() {
            return icon;
        }

        public Edit setIcon(String icon) {
            this.icon = icon;
            return this;
        }

        public String getClassify() {
            return classify;
        }

        public Edit setClassify(String classify) {
            this.classify = classify;
            return this;
        }

        public String getAccessCode() {
            return accessCode;
        }

        public Edit setAccessCode(String accessCode) {
            this.accessCode = accessCode;
            return this;
        }

        public String getAccessKey() {
            return accessKey;
        }

        public Edit setAccessKey(String accessKey) {
            this.accessKey = accessKey;
            return this;
        }

        public String getAppAccessUrl() {
            return appAccessUrl;
        }

        public Edit setAppAccessUrl(String appAccessUrl) {
            this.appAccessUrl = appAccessUrl;
            return this;
        }

        public String getAppAccessHeadParam() {
            return appAccessHeadParam;
        }

        public Edit setAppAccessHeadParam(String appAccessHeadParam) {
            this.appAccessHeadParam = appAccessHeadParam;
            return this;
        }

        public String getAppAccessBodyParam() {
            return appAccessBodyParam;
        }

        public Edit setAppAccessBodyParam(String appAccessBodyParam) {
            this.appAccessBodyParam = appAccessBodyParam;
            return this;
        }

        public String getVerifyUrl() {
            return verifyUrl;
        }

        public Edit setVerifyUrl(String verifyUrl) {
            this.verifyUrl = verifyUrl;
            return this;
        }

        public String getVerifyHeadParam() {
            return verifyHeadParam;
        }

        public Edit setVerifyHeadParam(String verifyHeadParam) {
            this.verifyHeadParam = verifyHeadParam;
            return this;
        }

        public String getVerifyBodyParam() {
            return verifyBodyParam;
        }

        public Edit setVerifyBodyParam(String verifyBodyParam) {
            this.verifyBodyParam = verifyBodyParam;
            return this;
        }

        public String getVerifyResponseParam() {
            return verifyResponseParam;
        }

        public Edit setVerifyResponseParam(String verifyResponseParam) {
            this.verifyResponseParam = verifyResponseParam;
            return this;
        }

        public String getGtasksUrl() {
            return gtasksUrl;
        }

        public Edit setGtasksUrl(String gtasksUrl) {
            this.gtasksUrl = gtasksUrl;
            return this;
        }

        public String getGtasksHeadParam() {
            return gtasksHeadParam;
        }

        public Edit setGtasksHeadParam(String gtasksHeadParam) {
            this.gtasksHeadParam = gtasksHeadParam;
            return this;
        }

        public String getGtasksBodyParam() {
            return gtasksBodyParam;
        }

        public Edit setGtasksBodyParam(String gtasksBodyParam) {
            this.gtasksBodyParam = gtasksBodyParam;
            return this;
        }

        public String getRemark() {
            return remark;
        }

        public Edit setRemark(String remark) {
            this.remark = remark;
            return this;
        }

        public String getRoleIds() {
            return roleIds;
        }

        public Edit setRoleIds(String roleIds) {
            this.roleIds = roleIds;
            return this;
        }

        public List<Long> getRoleIdList() {
            return roleIdList;
        }

        public Edit setRoleIdList(List<Long> roleIdList) {
            this.roleIdList = roleIdList;
            return this;
        }

        public String getRoleNames() {
            return roleNames;
        }

        public Edit setRoleNames(String roleNames) {
            this.roleNames = roleNames;
            return this;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public Edit setCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public Integer getSort() {
            return sort;
        }

        public Edit setSort(Integer sort) {
            this.sort = sort;
            return this;
        }
    }

    public static class Del{
        @NotNull(message = "主键不能为空")
        private Long id;

        public Long getId() {
            return id;
        }

        public Del setId(Long id) {
            this.id = id;
            return this;
        }
    }
}
