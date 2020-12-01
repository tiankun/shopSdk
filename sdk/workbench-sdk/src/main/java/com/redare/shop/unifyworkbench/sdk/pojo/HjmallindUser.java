package com.redare.shop.unifyworkbench.sdk.pojo;

import java.io.Serializable;
import java.math.BigDecimal;import java.util.Date;

/**
 * 用户
 *
 * @date 2020-12-01 15:53:13
 * Created by tiankun
 */
public class HjmallindUser implements Serializable {

    /**
     * 自增主键
     */
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

    public HjmallindUser setId(Long id) {
        this.id = id;
        return this;
    }


    public Integer getType() {
        return type;
    }

    public HjmallindUser setType(Integer type) {
        this.type = type;
        return this;
    }


    public String getUsername() {
        return username;
    }

    public HjmallindUser setUsername(String username) {
        this.username = username;
        return this;
    }


    public String getPassword() {
        return password;
    }

    public HjmallindUser setPassword(String password) {
        this.password = password;
        return this;
    }


    public String getAuthKey() {
        return authKey;
    }

    public HjmallindUser setAuthKey(String authKey) {
        this.authKey = authKey;
        return this;
    }


    public String getAccessToken() {
        return accessToken;
    }

    public HjmallindUser setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }


    public Integer getAddtime() {
        return addtime;
    }

    public HjmallindUser setAddtime(Integer addtime) {
        this.addtime = addtime;
        return this;
    }


    public Integer getIsDelete() {
        return isDelete;
    }

    public HjmallindUser setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
        return this;
    }


    public String getWechatOpenId() {
        return wechatOpenId;
    }

    public HjmallindUser setWechatOpenId(String wechatOpenId) {
        this.wechatOpenId = wechatOpenId;
        return this;
    }


    public String getWechatUnionId() {
        return wechatUnionId;
    }

    public HjmallindUser setWechatUnionId(String wechatUnionId) {
        this.wechatUnionId = wechatUnionId;
        return this;
    }


    public String getNickname() {
        return nickname;
    }

    public HjmallindUser setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }


    public String getAvatarUrl() {
        return avatarUrl;
    }

    public HjmallindUser setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        return this;
    }


    public Integer getStoreId() {
        return storeId;
    }

    public HjmallindUser setStoreId(Integer storeId) {
        this.storeId = storeId;
        return this;
    }


    public Integer getIsDistributor() {
        return isDistributor;
    }

    public HjmallindUser setIsDistributor(Integer isDistributor) {
        this.isDistributor = isDistributor;
        return this;
    }


    public Integer getParentId() {
        return parentId;
    }

    public HjmallindUser setParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }


    public Integer getTime() {
        return time;
    }

    public HjmallindUser setTime(Integer time) {
        this.time = time;
        return this;
    }


    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public HjmallindUser setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public HjmallindUser setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }


    public Integer getIsClerk() {
        return isClerk;
    }

    public HjmallindUser setIsClerk(Integer isClerk) {
        this.isClerk = isClerk;
        return this;
    }


    public Integer getWe7Uid() {
        return we7Uid;
    }

    public HjmallindUser setWe7Uid(Integer we7Uid) {
        this.we7Uid = we7Uid;
        return this;
    }


    public Integer getShopId() {
        return shopId;
    }

    public HjmallindUser setShopId(Integer shopId) {
        this.shopId = shopId;
        return this;
    }


    public Integer getLevel() {
        return level;
    }

    public HjmallindUser setLevel(Integer level) {
        this.level = level;
        return this;
    }


    public Integer getIntegral() {
        return integral;
    }

    public HjmallindUser setIntegral(Integer integral) {
        this.integral = integral;
        return this;
    }


    public Integer getTotalIntegral() {
        return totalIntegral;
    }

    public HjmallindUser setTotalIntegral(Integer totalIntegral) {
        this.totalIntegral = totalIntegral;
        return this;
    }


    public BigDecimal getMoney() {
        return money;
    }

    public HjmallindUser setMoney(BigDecimal money) {
        this.money = money;
        return this;
    }


    public String getContactWay() {
        return contactWay;
    }

    public HjmallindUser setContactWay(String contactWay) {
        this.contactWay = contactWay;
        return this;
    }


    public String getComments() {
        return comments;
    }

    public HjmallindUser setComments(String comments) {
        this.comments = comments;
        return this;
    }


    public String getBinding() {
        return binding;
    }

    public HjmallindUser setBinding(String binding) {
        this.binding = binding;
        return this;
    }


    public String getWechatPlatformOpenId() {
        return wechatPlatformOpenId;
    }

    public HjmallindUser setWechatPlatformOpenId(String wechatPlatformOpenId) {
        this.wechatPlatformOpenId = wechatPlatformOpenId;
        return this;
    }


    public Integer getPlatform() {
        return platform;
    }

    public HjmallindUser setPlatform(Integer platform) {
        this.platform = platform;
        return this;
    }


    public Integer getBlacklist() {
        return blacklist;
    }

    public HjmallindUser setBlacklist(Integer blacklist) {
        this.blacklist = blacklist;
        return this;
    }


    public Integer getParentUserId() {
        return parentUserId;
    }

    public HjmallindUser setParentUserId(Integer parentUserId) {
        this.parentUserId = parentUserId;
        return this;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public HjmallindUser setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public HjmallindUser setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

}