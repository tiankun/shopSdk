package com.redare.shop.unifyworkbench.sdk.pojo.form;

import com.redare.devframework.common.pojo.LevelTreeQuery;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/7/3 11:23
 * @version: 1.1
 */
public class OrganizationMenuForm {

    public static class Search{
        private String orgId;
        private String menuId;
        private Long platformMenuId;
        private String parentMenuId;
        private Boolean enabled;
        private Boolean refPage;
        private Boolean refComponent;
        private boolean excRoot;
        private boolean sortToTree;
        private LevelTreeQuery levelTreeQuery;
        private String platform;
        private String userPlatform;

        public String getOrgId() {
            return orgId;
        }

        public Search setOrgId(String orgId) {
            this.orgId = orgId;
            return this;
        }

        public String getMenuId() {
            return menuId;
        }

        public Search setMenuId(String menuId) {
            this.menuId = menuId;
            return this;
        }

        public Long getPlatformMenuId() {
            return platformMenuId;
        }

        public Search setPlatformMenuId(Long platformMenuId) {
            this.platformMenuId = platformMenuId;
            return this;
        }

        public String getParentMenuId() {
            return parentMenuId;
        }

        public Search setParentMenuId(String parentMenuId) {
            this.parentMenuId = parentMenuId;
            return this;
        }

        public Boolean getEnabled() {
            return enabled;
        }

        public Search setEnabled(Boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public Boolean getRefPage() {
            return refPage;
        }

        public Search setRefPage(Boolean refPage) {
            this.refPage = refPage;
            return this;
        }

        public Boolean getRefComponent() {
            return refComponent;
        }

        public Search setRefComponent(Boolean refComponent) {
            this.refComponent = refComponent;
            return this;
        }

        public boolean isExcRoot() {
            return excRoot;
        }

        public Search setExcRoot(boolean excRoot) {
            this.excRoot = excRoot;
            return this;
        }

        public boolean isSortToTree() {
            return sortToTree;
        }

        public Search setSortToTree(boolean sortToTree) {
            this.sortToTree = sortToTree;
            return this;
        }

        public LevelTreeQuery getLevelTreeQuery() {
            return levelTreeQuery;
        }

        public Search setLevelTreeQuery(LevelTreeQuery levelTreeQuery) {
            this.levelTreeQuery = levelTreeQuery;
            return this;
        }

        public String getPlatform() {
            return platform;
        }

        public Search setPlatform(String platform) {
            this.platform = platform;
            return this;
        }

        public String getUserPlatform() {
            return userPlatform;
        }

        public Search setUserPlatform(String userPlatform) {
            this.userPlatform = userPlatform;
            return this;
        }
    }

    public static class DelMenu{
        private String orgId;
        private List<String> menuIds;

        public String getOrgId() {
            return orgId;
        }

        public DelMenu setOrgId(String orgId) {
            this.orgId = orgId;
            return this;
        }

        public List<String> getMenuIds() {
            return menuIds;
        }

        public DelMenu setMenuIds(List<String> menuIds) {
            this.menuIds = menuIds;
            return this;
        }
    }

    public static class AddMenu{
        private String orgId;
        private List<String> menuIds;

        public String getOrgId() {
            return orgId;
        }

        public AddMenu setOrgId(String orgId) {
            this.orgId = orgId;
            return this;
        }

        public List<String> getMenuIds() {
            return menuIds;
        }

        public AddMenu setMenuIds(List<String> menuIds) {
            this.menuIds = menuIds;
            return this;
        }
    }
}
