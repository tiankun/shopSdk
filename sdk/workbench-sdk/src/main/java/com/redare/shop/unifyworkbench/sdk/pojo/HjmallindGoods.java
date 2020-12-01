package com.redare.shop.unifyworkbench.sdk.pojo;

import java.io.Serializable;
import java.math.BigDecimal;import java.util.Date;

/**
 * 商品
 *
 * @date 2020-12-01 16:20:57
 * Created by tiankun
 */
public class HjmallindGoods implements Serializable {

    /**
     * 自增主键
     */
    private Long id;

    /**
     *
     */
    private Integer storeId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 售价
     */
    private BigDecimal price;

    /**
     * 原价（只做显示用）
     */
    private BigDecimal originalPrice;

    /**
     * 商品详情，图文
     */
    private String detail;

    /**
     * 商品类别
     */
    private Integer catId;

    /**
     * 上架状态：0=下架，1=上架
     */
    private Integer status;

    /**
     *
     */
    private Integer addtime;

    /**
     *
     */
    private Integer isDelete;

    /**
     * 规格的库存及价格
     */
    private String attr;

    /**
     * 商品服务选项
     */
    private String service;

    /**
     * 排序  升序
     */
    private Integer sort;

    /**
     * 虚拟销量
     */
    private Integer virtualSales;

    /**
     * 商品缩略图
     */
    private String coverPic;

    /**
     * 视频
     */
    private String videoUrl;

    /**
     * 单位
     */
    private String unit;

    /**
     * 是否单独分销设置：0=否，1=是
     */
    private Integer individualShare;

    /**
     * 一级分销佣金比例
     */
    private BigDecimal shareCommissionFirst;

    /**
     * 二级分销佣金比例
     */
    private BigDecimal shareCommissionSecond;

    /**
     * 三级分销佣金比例
     */
    private BigDecimal shareCommissionThird;

    /**
     * 重量
     */
    private Double weight;

    /**
     * 运费模板ID
     */
    private Integer freight;

    /**
     * 满减
     */
    private String fullCut;

    /**
     * 积分设置
     */
    private String integral;

    /**
     * 是否使用规格：0=不使用，1=使用
     */
    private Integer useAttr;

    /**
     * 佣金配比 0--百分比 1--固定金额
     */
    private Integer shareType;

    /**
     * 是否加入快速购买  0--关闭   1--开启
     */
    private Integer quickPurchase;

    /**
     * 是否加入热销  0--关闭   1--开启
     */
    private Integer hotCakes;

    /**
     *
     */
    private BigDecimal costPrice;

    /**
     * 是否参与会员折扣  0=参与   1=不参与
     */
    private Integer memberDiscount;

    /**
     * 自购返利
     */
    private BigDecimal rebate;

    /**
     * 入驻商户的id
     */
    private Integer mchId;

    /**
     * 商品总库存
     */
    private Integer goodsNum;

    /**
     * 多商户自己的排序
     */
    private Integer mchSort;

    /**
     * 购买限制:0.不限制|大于0等于限购数量
     */
    private Integer confineCount;

    /**
     * 是否享受会员折扣 0-不享受 1--享受
     */
    private Integer isLevel;

    /**
     * 类型 0--商城或多商户 2--砍价商品
     */
    private Integer type;

    /**
     * 是否面议 0 不面议 1面议
     */
    private Integer isNegotiable;

    /**
     * 分销设置类型 0.普通设置|1.详细设置
     */
    private Integer attrSettingType;

    /**
     *
     */
    private String barcode;

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

    public HjmallindGoods setId(Long id) {
        this.id = id;
        return this;
    }


    public Integer getStoreId() {
        return storeId;
    }

    public HjmallindGoods setStoreId(Integer storeId) {
        this.storeId = storeId;
        return this;
    }


    public String getName() {
        return name;
    }

    public HjmallindGoods setName(String name) {
        this.name = name;
        return this;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public HjmallindGoods setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }


    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public HjmallindGoods setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
        return this;
    }


    public String getDetail() {
        return detail;
    }

    public HjmallindGoods setDetail(String detail) {
        this.detail = detail;
        return this;
    }


    public Integer getCatId() {
        return catId;
    }

    public HjmallindGoods setCatId(Integer catId) {
        this.catId = catId;
        return this;
    }


    public Integer getStatus() {
        return status;
    }

    public HjmallindGoods setStatus(Integer status) {
        this.status = status;
        return this;
    }


    public Integer getAddtime() {
        return addtime;
    }

    public HjmallindGoods setAddtime(Integer addtime) {
        this.addtime = addtime;
        return this;
    }


    public Integer getIsDelete() {
        return isDelete;
    }

    public HjmallindGoods setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
        return this;
    }


    public String getAttr() {
        return attr;
    }

    public HjmallindGoods setAttr(String attr) {
        this.attr = attr;
        return this;
    }


    public String getService() {
        return service;
    }

    public HjmallindGoods setService(String service) {
        this.service = service;
        return this;
    }


    public Integer getSort() {
        return sort;
    }

    public HjmallindGoods setSort(Integer sort) {
        this.sort = sort;
        return this;
    }


    public Integer getVirtualSales() {
        return virtualSales;
    }

    public HjmallindGoods setVirtualSales(Integer virtualSales) {
        this.virtualSales = virtualSales;
        return this;
    }


    public String getCoverPic() {
        return coverPic;
    }

    public HjmallindGoods setCoverPic(String coverPic) {
        this.coverPic = coverPic;
        return this;
    }


    public String getVideoUrl() {
        return videoUrl;
    }

    public HjmallindGoods setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }


    public String getUnit() {
        return unit;
    }

    public HjmallindGoods setUnit(String unit) {
        this.unit = unit;
        return this;
    }


    public Integer getIndividualShare() {
        return individualShare;
    }

    public HjmallindGoods setIndividualShare(Integer individualShare) {
        this.individualShare = individualShare;
        return this;
    }


    public BigDecimal getShareCommissionFirst() {
        return shareCommissionFirst;
    }

    public HjmallindGoods setShareCommissionFirst(BigDecimal shareCommissionFirst) {
        this.shareCommissionFirst = shareCommissionFirst;
        return this;
    }


    public BigDecimal getShareCommissionSecond() {
        return shareCommissionSecond;
    }

    public HjmallindGoods setShareCommissionSecond(BigDecimal shareCommissionSecond) {
        this.shareCommissionSecond = shareCommissionSecond;
        return this;
    }


    public BigDecimal getShareCommissionThird() {
        return shareCommissionThird;
    }

    public HjmallindGoods setShareCommissionThird(BigDecimal shareCommissionThird) {
        this.shareCommissionThird = shareCommissionThird;
        return this;
    }


    public Double getWeight() {
        return weight;
    }

    public HjmallindGoods setWeight(Double weight) {
        this.weight = weight;
        return this;
    }


    public Integer getFreight() {
        return freight;
    }

    public HjmallindGoods setFreight(Integer freight) {
        this.freight = freight;
        return this;
    }


    public String getFullCut() {
        return fullCut;
    }

    public HjmallindGoods setFullCut(String fullCut) {
        this.fullCut = fullCut;
        return this;
    }


    public String getIntegral() {
        return integral;
    }

    public HjmallindGoods setIntegral(String integral) {
        this.integral = integral;
        return this;
    }


    public Integer getUseAttr() {
        return useAttr;
    }

    public HjmallindGoods setUseAttr(Integer useAttr) {
        this.useAttr = useAttr;
        return this;
    }


    public Integer getShareType() {
        return shareType;
    }

    public HjmallindGoods setShareType(Integer shareType) {
        this.shareType = shareType;
        return this;
    }


    public Integer getQuickPurchase() {
        return quickPurchase;
    }

    public HjmallindGoods setQuickPurchase(Integer quickPurchase) {
        this.quickPurchase = quickPurchase;
        return this;
    }


    public Integer getHotCakes() {
        return hotCakes;
    }

    public HjmallindGoods setHotCakes(Integer hotCakes) {
        this.hotCakes = hotCakes;
        return this;
    }


    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public HjmallindGoods setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
        return this;
    }


    public Integer getMemberDiscount() {
        return memberDiscount;
    }

    public HjmallindGoods setMemberDiscount(Integer memberDiscount) {
        this.memberDiscount = memberDiscount;
        return this;
    }


    public BigDecimal getRebate() {
        return rebate;
    }

    public HjmallindGoods setRebate(BigDecimal rebate) {
        this.rebate = rebate;
        return this;
    }


    public Integer getMchId() {
        return mchId;
    }

    public HjmallindGoods setMchId(Integer mchId) {
        this.mchId = mchId;
        return this;
    }


    public Integer getGoodsNum() {
        return goodsNum;
    }

    public HjmallindGoods setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
        return this;
    }


    public Integer getMchSort() {
        return mchSort;
    }

    public HjmallindGoods setMchSort(Integer mchSort) {
        this.mchSort = mchSort;
        return this;
    }


    public Integer getConfineCount() {
        return confineCount;
    }

    public HjmallindGoods setConfineCount(Integer confineCount) {
        this.confineCount = confineCount;
        return this;
    }


    public Integer getIsLevel() {
        return isLevel;
    }

    public HjmallindGoods setIsLevel(Integer isLevel) {
        this.isLevel = isLevel;
        return this;
    }


    public Integer getType() {
        return type;
    }

    public HjmallindGoods setType(Integer type) {
        this.type = type;
        return this;
    }


    public Integer getIsNegotiable() {
        return isNegotiable;
    }

    public HjmallindGoods setIsNegotiable(Integer isNegotiable) {
        this.isNegotiable = isNegotiable;
        return this;
    }


    public Integer getAttrSettingType() {
        return attrSettingType;
    }

    public HjmallindGoods setAttrSettingType(Integer attrSettingType) {
        this.attrSettingType = attrSettingType;
        return this;
    }


    public String getBarcode() {
        return barcode;
    }

    public HjmallindGoods setBarcode(String barcode) {
        this.barcode = barcode;
        return this;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public HjmallindGoods setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public HjmallindGoods setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

}