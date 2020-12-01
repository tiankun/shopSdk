package com.redare.shop.unifyworkbench.appapi.pojo.base;

public class UserArg {

    public static class Login {

        private String account;//账号
        private String pwd;//密码

        public String getAccount() {
            return account;
        }

        public Login setAccount(String account) {
            this.account = account;
            return this;
        }

        public String getPwd() {
            return pwd;
        }

        public Login setPwd(String pwd) {
            this.pwd = pwd;
            return this;
        }
    }

    public static class LoginCode {
        private String mobile;

        public String getMobile() {
            return mobile;
        }

        public LoginCode setMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }
    }

    public static class LoginByPhone {
        private String mobile;

        public String getMobile() {
            return mobile;
        }

        public LoginByPhone setMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }
    }
}
