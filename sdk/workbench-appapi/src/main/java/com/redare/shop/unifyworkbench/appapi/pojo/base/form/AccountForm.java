package com.redare.shop.unifyworkbench.appapi.pojo.base.form;

import com.redare.devframework.common.validation.validator.Mobile;

import javax.validation.constraints.NotBlank;


/**
 * Created by tiankun on 2019-04-12
 */
public class AccountForm {
    public static class checkPhoneExist {
        @NotBlank(message = "请传入手机号")
        @Mobile
        private String phoneNum;
        private Long userId;
        private String operate;

        public String getPhoneNum() {
            return phoneNum;
        }

        public checkPhoneExist setPhoneNum(String phoneNum) {
            this.phoneNum = phoneNum;
            return this;
        }

        public Long getUserId() {
            return userId;
        }

        public checkPhoneExist setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public String getOperate() {
            return operate;
        }

        public checkPhoneExist setOperate(String operate) {
            this.operate = operate;
            return this;
        }
    }
    public static class verifyPwd {
        @NotBlank(message = "请传入密码")
        private String pwd;
        @NotBlank(message = "请传入确认密码")
        private String confirmPwd;
        @Mobile
        private String phoneNum;

        public String getPwd() {
            return pwd;
        }

        public verifyPwd setPwd(String pwd) {
            this.pwd = pwd;
            return this;
        }

        public String getConfirmPwd() {
            return confirmPwd;
        }

        public verifyPwd setConfirmPwd(String confirmPwd) {
            this.confirmPwd = confirmPwd;
            return this;
        }

        public String getPhoneNum() {
            return phoneNum;
        }

        public verifyPwd setPhoneNum(String phoneNum) {
            this.phoneNum = phoneNum;
            return this;
        }
    }
}
