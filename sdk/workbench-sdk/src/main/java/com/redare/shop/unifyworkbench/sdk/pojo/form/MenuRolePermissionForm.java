package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotNull;

/**
 * @description:MenuRolePermissionForm
 * @author: zlx
 * @date: Created in 2020/6/13 13:33
 * @version: 1.1
 */
public class MenuRolePermissionForm {
    public static class Search{
        @NotNull(message = "userId不能为空")
        private Long userId;

        public Long getUserId() {
            return userId;
        }

        public Search setUserId(Long userId) {
            this.userId = userId;
            return this;
        }
    }
}
