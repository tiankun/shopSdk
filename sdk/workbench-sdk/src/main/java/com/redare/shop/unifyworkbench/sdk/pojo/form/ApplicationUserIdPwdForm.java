package com.redare.shop.unifyworkbench.sdk.pojo.form;

public class ApplicationUserIdPwdForm {
    public static class ApplicationUserIdSearch{
        private String applicationUserId;

        public String getApplicationUserId() {
            return applicationUserId;
        }

        public ApplicationUserIdSearch setApplicationUserId(String applicationUserId) {
            this.applicationUserId = applicationUserId;
            return this;
        }
    }

    public static class ApplicationUserIdPwdSearch{
        private String applicationUserId;
        private String applicationUserPwd;

        public String getApplicationUserId() {
            return applicationUserId;
        }

        public ApplicationUserIdPwdSearch setApplicationUserId(String applicationUserId) {
            this.applicationUserId = applicationUserId;
            return this;
        }

        public String getApplicationUserPwd() {
            return applicationUserPwd;
        }

        public ApplicationUserIdPwdSearch setApplicationUserPwd(String applicationUserPwd) {
            this.applicationUserPwd = applicationUserPwd;
            return this;
        }
    }
}
