package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

;import java.math.BigDecimal;

/**
 * 用户
 *
 * @date 2020-12-01 15:53:13
 * Created by tiankun
 */
public class HjmallindUserForm {

    public static class Add {
        /**
         * 用户类型：0=管理员，1=普通用户
         */
        @NotNull(message = "用户类型：0=管理员，1=普通用户不能为空")
        private Integer type;

        /**
         *
         */
        @NotBlank(message = "不能为空")
        private String username;

        /**
         *
         */
        @NotBlank(message = "不能为空")
        private String password;

        /**
         *
         */
        @NotBlank(message = "不能为空")
        private String authKey;

        /**
         *
         */
        @NotBlank(message = "不能为空")
        private String accessToken;

        /**
         *
         */
        @NotNull(message = "不能为空")
        private Integer addtime;

        /**
         *
         */
        @NotNull(message = "不能为空")
        private Integer isDelete;

        /**
         * 微信openid
         */
        @NotBlank(message = "微信openid不能为空")
        private String wechatOpenId;

        /**
         * 微信用户union id
         */
        @NotBlank(message = "微信用户union id不能为空")
        private String wechatUnionId;

        /**
         * 昵称
         */
        @NotBlank(message = "昵称不能为空")
        private String nickname;

        /**
         * 头像url
         */
        @NotBlank(message = "头像url不能为空")
        private String avatarUrl;

        /**
         * 商城id
         */
        @NotNull(message = "商城id不能为空")
        private Integer storeId;

        /**
         * 是否是分销商 0--不是 1--是 2--申请中
         */
        @NotNull(message = "是否是分销商 0--不是 1--是 2--申请中不能为空")
        private Integer isDistributor;

        /**
         * 父级ID
         */
        @NotNull(message = "父级ID不能为空")
        private Integer parentId;

        /**
         * 成为分销商的时间
         */
        @NotNull(message = "成为分销商的时间不能为空")
        private Integer time;

        /**
         * 累计佣金
         */
        private BigDecimal totalPrice;

        /**
         * 可提现佣金
         */
        private BigDecimal price;

        /**
         * 是否是核销员 0--不是 1--是
         */
        @NotNull(message = "是否是核销员 0--不是 1--是不能为空")
        private Integer isClerk;

        /**
         * 微擎账户id
         */
        @NotNull(message = "微擎账户id不能为空")
        private Integer we7Uid;

        /**
         *
         */
        private Integer shopId;

        /**
         * 会员等级
         */
        private Integer level;

        /**
         * 用户当前积分
         */
        @NotNull(message = "用户当前积分不能为空")
        private Integer integral;

        /**
         * 用户总获得积分
         */
        @NotNull(message = "用户总获得积分不能为空")
        private Integer totalIntegral;

        /**
         * 余额
         */
        private BigDecimal money;

        /**
         * 联系方式
         */
        private String contactWay;

        /**
         * 备注
         */
        private String comments;

        /**
         * 授权手机号
         */
        private String binding;

        /**
         * 微信公众号openid
         */
        @NotBlank(message = "微信公众号openid不能为空")
        private String wechatPlatformOpenId;

        /**
         * 小程序平台 0 => 微信, 1 => 支付宝
         */
        @NotNull(message = "小程序平台 0 => 微信, 1 => 支付宝不能为空")
        private Integer platform;

        /**
         * 黑名单 0.否 | 1.是
         */
        @NotNull(message = "黑名单 0.否 | 1.是不能为空")
        private Integer blacklist;

        /**
         * 可能成为上级的ID
         */
        @NotNull(message = "可能成为上级的ID不能为空")
        private Integer parentUserId;


        public Integer getType() {
            return type;
        }

        public Add setType(Integer type) {
            this.type = type;
            return this;
        }


        public String getUsername() {
            return username;
        }

        public Add setUsername(String username) {
            this.username = username;
            return this;
        }


        public String getPassword() {
            return password;
        }

        public Add setPassword(String password) {
            this.password = password;
            return this;
        }


        public String getAuthKey() {
            return authKey;
        }

        public Add setAuthKey(String authKey) {
            this.authKey = authKey;
            return this;
        }


        public String getAccessToken() {
            return accessToken;
        }

        public Add setAccessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }


        public Integer getAddtime() {
            return addtime;
        }

        public Add setAddtime(Integer addtime) {
            this.addtime = addtime;
            return this;
        }


        public Integer getIsDelete() {
            return isDelete;
        }

        public Add setIsDelete(Integer isDelete) {
            this.isDelete = isDelete;
            return this;
        }


        public String getWechatOpenId() {
            return wechatOpenId;
        }

        public Add setWechatOpenId(String wechatOpenId) {
            this.wechatOpenId = wechatOpenId;
            return this;
        }


        public String getWechatUnionId() {
            return wechatUnionId;
        }

        public Add setWechatUnionId(String wechatUnionId) {
            this.wechatUnionId = wechatUnionId;
            return this;
        }


        public String getNickname() {
            return nickname;
        }

        public Add setNickname(String nickname) {
            this.nickname = nickname;
            return this;
        }


        public String getAvatarUrl() {
            return avatarUrl;
        }

        public Add setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
            return this;
        }


        public Integer getStoreId() {
            return storeId;
        }

        public Add setStoreId(Integer storeId) {
            this.storeId = storeId;
            return this;
        }


        public Integer getIsDistributor() {
            return isDistributor;
        }

        public Add setIsDistributor(Integer isDistributor) {
            this.isDistributor = isDistributor;
            return this;
        }


        public Integer getParentId() {
            return parentId;
        }

        public Add setParentId(Integer parentId) {
            this.parentId = parentId;
            return this;
        }


        public Integer getTime() {
            return time;
        }

        public Add setTime(Integer time) {
            this.time = time;
            return this;
        }


        public BigDecimal getTotalPrice() {
            return totalPrice;
        }

        public Add setTotalPrice(BigDecimal totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }


        public BigDecimal getPrice() {
            return price;
        }

        public Add setPrice(BigDecimal price) {
            this.price = price;
            return this;
        }


        public Integer getIsClerk() {
            return isClerk;
        }

        public Add setIsClerk(Integer isClerk) {
            this.isClerk = isClerk;
            return this;
        }


        public Integer getWe7Uid() {
            return we7Uid;
        }

        public Add setWe7Uid(Integer we7Uid) {
            this.we7Uid = we7Uid;
            return this;
        }


        public Integer getShopId() {
            return shopId;
        }

        public Add setShopId(Integer shopId) {
            this.shopId = shopId;
            return this;
        }


        public Integer getLevel() {
            return level;
        }

        public Add setLevel(Integer level) {
            this.level = level;
            return this;
        }


        public Integer getIntegral() {
            return integral;
        }

        public Add setIntegral(Integer integral) {
            this.integral = integral;
            return this;
        }


        public Integer getTotalIntegral() {
            return totalIntegral;
        }

        public Add setTotalIntegral(Integer totalIntegral) {
            this.totalIntegral = totalIntegral;
            return this;
        }


        public BigDecimal getMoney() {
            return money;
        }

        public Add setMoney(BigDecimal money) {
            this.money = money;
            return this;
        }


        public String getContactWay() {
            return contactWay;
        }

        public Add setContactWay(String contactWay) {
            this.contactWay = contactWay;
            return this;
        }


        public String getComments() {
            return comments;
        }

        public Add setComments(String comments) {
            this.comments = comments;
            return this;
        }


        public String getBinding() {
            return binding;
        }

        public Add setBinding(String binding) {
            this.binding = binding;
            return this;
        }


        public String getWechatPlatformOpenId() {
            return wechatPlatformOpenId;
        }

        public Add setWechatPlatformOpenId(String wechatPlatformOpenId) {
            this.wechatPlatformOpenId = wechatPlatformOpenId;
            return this;
        }


        public Integer getPlatform() {
            return platform;
        }

        public Add setPlatform(Integer platform) {
            this.platform = platform;
            return this;
        }


        public Integer getBlacklist() {
            return blacklist;
        }

        public Add setBlacklist(Integer blacklist) {
            this.blacklist = blacklist;
            return this;
        }


        public Integer getParentUserId() {
            return parentUserId;
        }

        public Add setParentUserId(Integer parentUserId) {
            this.parentUserId = parentUserId;
            return this;
        }


    }

    public static class Edit {

        @NotNull(message = "请传入id")
        private Long id;

        /**
         * 用户类型：0=管理员，1=普通用户
         */
        private Integer type;
        /**
         *
         */
        private String username;
        /**
         *
         */
        private String password;
        /**
         *
         */
        private String authKey;
        /**
         *
         */
        private String accessToken;
        /**
         *
         */
        private Integer addtime;
        /**
         *
         */
        private Integer isDelete;
        /**
         * 微信openid
         */
        private String wechatOpenId;
        /**
         * 微信用户union id
         */
        private String wechatUnionId;
        /**
         * 昵称
         */
        private String nickname;
        /**
         * 头像url
         */
        private String avatarUrl;
        /**
         * 商城id
         */
        private Integer storeId;
        /**
         * 是否是分销商 0--不是 1--是 2--申请中
         */
        private Integer isDistributor;
        /**
         * 父级ID
         */
        private Integer parentId;
        /**
         * 成为分销商的时间
         */
        private Integer time;
        /**
         * 累计佣金
         */
        private BigDecimal totalPrice;
        /**
         * 可提现佣金
         */
        private BigDecimal price;
        /**
         * 是否是核销员 0--不是 1--是
         */
        private Integer isClerk;
        /**
         * 微擎账户id
         */
        private Integer we7Uid;
        /**
         *
         */
        private Integer shopId;
        /**
         * 会员等级
         */
        private Integer level;
        /**
         * 用户当前积分
         */
        private Integer integral;
        /**
         * 用户总获得积分
         */
        private Integer totalIntegral;
        /**
         * 余额
         */
        private BigDecimal money;
        /**
         * 联系方式
         */
        private String contactWay;
        /**
         * 备注
         */
        private String comments;
        /**
         * 授权手机号
         */
        private String binding;
        /**
         * 微信公众号openid
         */
        private String wechatPlatformOpenId;
        /**
         * 小程序平台 0 => 微信, 1 => 支付宝
         */
        private Integer platform;
        /**
         * 黑名单 0.否 | 1.是
         */
        private Integer blacklist;
        /**
         * 可能成为上级的ID
         */
        private Integer parentUserId;

        public Long getId() {
            return id;
        }

        public Edit setId(Long id) {
            this.id = id;
            return this;
        }


        public Integer getType() {
            return type;
        }

        public Edit setType(Integer type) {
            this.type = type;
            return this;
        }

        public String getUsername() {
            return username;
        }

        public Edit setUsername(String username) {
            this.username = username;
            return this;
        }

        public String getPassword() {
            return password;
        }

        public Edit setPassword(String password) {
            this.password = password;
            return this;
        }

        public String getAuthKey() {
            return authKey;
        }

        public Edit setAuthKey(String authKey) {
            this.authKey = authKey;
            return this;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public Edit setAccessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        public Integer getAddtime() {
            return addtime;
        }

        public Edit setAddtime(Integer addtime) {
            this.addtime = addtime;
            return this;
        }

        public Integer getIsDelete() {
            return isDelete;
        }

        public Edit setIsDelete(Integer isDelete) {
            this.isDelete = isDelete;
            return this;
        }

        public String getWechatOpenId() {
            return wechatOpenId;
        }

        public Edit setWechatOpenId(String wechatOpenId) {
            this.wechatOpenId = wechatOpenId;
            return this;
        }

        public String getWechatUnionId() {
            return wechatUnionId;
        }

        public Edit setWechatUnionId(String wechatUnionId) {
            this.wechatUnionId = wechatUnionId;
            return this;
        }

        public String getNickname() {
            return nickname;
        }

        public Edit setNickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public Edit setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
            return this;
        }

        public Integer getStoreId() {
            return storeId;
        }

        public Edit setStoreId(Integer storeId) {
            this.storeId = storeId;
            return this;
        }

        public Integer getIsDistributor() {
            return isDistributor;
        }

        public Edit setIsDistributor(Integer isDistributor) {
            this.isDistributor = isDistributor;
            return this;
        }

        public Integer getParentId() {
            return parentId;
        }

        public Edit setParentId(Integer parentId) {
            this.parentId = parentId;
            return this;
        }

        public Integer getTime() {
            return time;
        }

        public Edit setTime(Integer time) {
            this.time = time;
            return this;
        }

        public BigDecimal getTotalPrice() {
            return totalPrice;
        }

        public Edit setTotalPrice(BigDecimal totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public Edit setPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Integer getIsClerk() {
            return isClerk;
        }

        public Edit setIsClerk(Integer isClerk) {
            this.isClerk = isClerk;
            return this;
        }

        public Integer getWe7Uid() {
            return we7Uid;
        }

        public Edit setWe7Uid(Integer we7Uid) {
            this.we7Uid = we7Uid;
            return this;
        }

        public Integer getShopId() {
            return shopId;
        }

        public Edit setShopId(Integer shopId) {
            this.shopId = shopId;
            return this;
        }

        public Integer getLevel() {
            return level;
        }

        public Edit setLevel(Integer level) {
            this.level = level;
            return this;
        }

        public Integer getIntegral() {
            return integral;
        }

        public Edit setIntegral(Integer integral) {
            this.integral = integral;
            return this;
        }

        public Integer getTotalIntegral() {
            return totalIntegral;
        }

        public Edit setTotalIntegral(Integer totalIntegral) {
            this.totalIntegral = totalIntegral;
            return this;
        }

        public BigDecimal getMoney() {
            return money;
        }

        public Edit setMoney(BigDecimal money) {
            this.money = money;
            return this;
        }

        public String getContactWay() {
            return contactWay;
        }

        public Edit setContactWay(String contactWay) {
            this.contactWay = contactWay;
            return this;
        }

        public String getComments() {
            return comments;
        }

        public Edit setComments(String comments) {
            this.comments = comments;
            return this;
        }

        public String getBinding() {
            return binding;
        }

        public Edit setBinding(String binding) {
            this.binding = binding;
            return this;
        }

        public String getWechatPlatformOpenId() {
            return wechatPlatformOpenId;
        }

        public Edit setWechatPlatformOpenId(String wechatPlatformOpenId) {
            this.wechatPlatformOpenId = wechatPlatformOpenId;
            return this;
        }

        public Integer getPlatform() {
            return platform;
        }

        public Edit setPlatform(Integer platform) {
            this.platform = platform;
            return this;
        }

        public Integer getBlacklist() {
            return blacklist;
        }

        public Edit setBlacklist(Integer blacklist) {
            this.blacklist = blacklist;
            return this;
        }

        public Integer getParentUserId() {
            return parentUserId;
        }

        public Edit setParentUserId(Integer parentUserId) {
            this.parentUserId = parentUserId;
            return this;
        }

    }

    public static class Search {

        private String queryFields;

        private String key;


        public String getKey() {
            return key;
        }

        public Search setKey(String key) {
            this.key = key;
            return this;
        }

        public String getQueryFields() {
            return queryFields;
        }

        public Search setQueryFields(String queryFields) {
            this.queryFields = queryFields;
            return this;
        }


    }


    public static class Get {
        @NotNull(message = "请传入id")
        private Long id;

        private String queryFields;


        public Long getId() {
            return id;
        }

        public Get setId(Long id) {
            this.id = id;
            return this;
        }

        public String getQueryFields() {
            return queryFields;
        }

        public Get setQueryFields(String queryFields) {
            this.queryFields = queryFields;
            return this;
        }

    }

    public static class Del {
        @NotNull(message = "请传入id")
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