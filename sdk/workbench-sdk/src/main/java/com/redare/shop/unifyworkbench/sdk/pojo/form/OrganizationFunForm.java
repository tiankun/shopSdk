package com.redare.shop.unifyworkbench.sdk.pojo.form;

import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/7/3 14:23
 * @version: 1.1
 */
public class OrganizationFunForm {

    public static class Search{
        private String orgId;
        private String menuId;

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
    }

    public static class AddFun{
        private String orgId;
        private List<String> funIds;

        public String getOrgId() {
            return orgId;
        }

        public AddFun setOrgId(String orgId) {
            this.orgId = orgId;
            return this;
        }

        public List<String> getFunIds() {
            return funIds;
        }

        public AddFun setFunIds(List<String> funIds) {
            this.funIds = funIds;
            return this;
        }
    }

    public static class DelFun{
        private String orgId;
        private List<String> funIds;

        public String getOrgId() {
            return orgId;
        }

        public DelFun setOrgId(String orgId) {
            this.orgId = orgId;
            return this;
        }

        public List<String> getFunIds() {
            return funIds;
        }

        public DelFun setFunIds(List<String> funIds) {
            this.funIds = funIds;
            return this;
        }
    }
}
