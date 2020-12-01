package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

;import java.math.BigDecimal;

/**
 * 商品
 *
 * @date 2020-12-01 16:20:57
 * Created by tiankun
 */
public class HjmallindGoodsForm {

    public static class Add {
        /**
         *
         */
        @NotNull(message = "不能为空")
        private Integer storeId;

        /**
         * 商品名称
         */
        @NotBlank(message = "商品名称不能为空")
        private String name;

        /**
         * 售价
         */
        @NotNull(message = "售价不能为空")
        private BigDecimal price;

        /**
         * 原价（只做显示用）
         */
        @NotNull(message = "原价（只做显示用）不能为空")
        private BigDecimal originalPrice;

        /**
         * 商品详情，图文
         */
        @NotBlank(message = "商品详情，图文不能为空")
        private String detail;

        /**
         * 商品类别
         */
        @NotNull(message = "商品类别不能为空")
        private Integer catId;

        /**
         * 上架状态：0=下架，1=上架
         */
        @NotNull(message = "上架状态：0=下架，1=上架不能为空")
        private Integer status;

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
         * 规格的库存及价格
         */
        @NotBlank(message = "规格的库存及价格不能为空")
        private String attr;

        /**
         * 商品服务选项
         */
        @NotBlank(message = "商品服务选项不能为空")
        private String service;

        /**
         * 排序  升序
         */
        @NotNull(message = "排序  升序不能为空")
        private Integer sort;

        /**
         * 虚拟销量
         */
        @NotNull(message = "虚拟销量不能为空")
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
        @NotBlank(message = "单位不能为空")
        private String unit;

        /**
         * 是否单独分销设置：0=否，1=是
         */
        @NotNull(message = "是否单独分销设置：0=否，1=是不能为空")
        private Integer individualShare;

        /**
         * 一级分销佣金比例
         */
        @NotNull(message = "一级分销佣金比例不能为空")
        private BigDecimal shareCommissionFirst;

        /**
         * 二级分销佣金比例
         */
        @NotNull(message = "二级分销佣金比例不能为空")
        private BigDecimal shareCommissionSecond;

        /**
         * 三级分销佣金比例
         */
        @NotNull(message = "三级分销佣金比例不能为空")
        private BigDecimal shareCommissionThird;

        /**
         * 重量
         */
        private Double weight;

        /**
         * 运费模板ID
         */
        @NotNull(message = "运费模板ID不能为空")
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
        @NotNull(message = "是否使用规格：0=不使用，1=使用不能为空")
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
        @NotNull(message = "是否参与会员折扣  0=参与   1=不参与不能为空")
        private Integer memberDiscount;

        /**
         * 自购返利
         */
        private BigDecimal rebate;

        /**
         * 入驻商户的id
         */
        @NotNull(message = "入驻商户的id不能为空")
        private Integer mchId;

        /**
         * 商品总库存
         */
        @NotNull(message = "商品总库存不能为空")
        private Integer goodsNum;

        /**
         * 多商户自己的排序
         */
        @NotNull(message = "多商户自己的排序不能为空")
        private Integer mchSort;

        /**
         * 购买限制:0.不限制|大于0等于限购数量
         */
        @NotNull(message = "购买限制:0.不限制|大于0等于限购数量不能为空")
        private Integer confineCount;

        /**
         * 是否享受会员折扣 0-不享受 1--享受
         */
        @NotNull(message = "是否享受会员折扣 0-不享受 1--享受不能为空")
        private Integer isLevel;

        /**
         * 类型 0--商城或多商户 2--砍价商品
         */
        @NotNull(message = "类型 0--商城或多商户 2--砍价商品不能为空")
        private Integer type;

        /**
         * 是否面议 0 不面议 1面议
         */
        @NotNull(message = "是否面议 0 不面议 1面议不能为空")
        private Integer isNegotiable;

        /**
         * 分销设置类型 0.普通设置|1.详细设置
         */
        @NotNull(message = "分销设置类型 0.普通设置|1.详细设置不能为空")
        private Integer attrSettingType;

        /**
         *
         */
        private String barcode;


        public Integer getStoreId() {
            return storeId;
        }

        public Add setStoreId(Integer storeId) {
            this.storeId = storeId;
            return this;
        }


        public String getName() {
            return name;
        }

        public Add setName(String name) {
            this.name = name;
            return this;
        }


        public BigDecimal getPrice() {
            return price;
        }

        public Add setPrice(BigDecimal price) {
            this.price = price;
            return this;
        }


        public BigDecimal getOriginalPrice() {
            return originalPrice;
        }

        public Add setOriginalPrice(BigDecimal originalPrice) {
            this.originalPrice = originalPrice;
            return this;
        }


        public String getDetail() {
            return detail;
        }

        public Add setDetail(String detail) {
            this.detail = detail;
            return this;
        }


        public Integer getCatId() {
            return catId;
        }

        public Add setCatId(Integer catId) {
            this.catId = catId;
            return this;
        }


        public Integer getStatus() {
            return status;
        }

        public Add setStatus(Integer status) {
            this.status = status;
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


        public String getAttr() {
            return attr;
        }

        public Add setAttr(String attr) {
            this.attr = attr;
            return this;
        }


        public String getService() {
            return service;
        }

        public Add setService(String service) {
            this.service = service;
            return this;
        }


        public Integer getSort() {
            return sort;
        }

        public Add setSort(Integer sort) {
            this.sort = sort;
            return this;
        }


        public Integer getVirtualSales() {
            return virtualSales;
        }

        public Add setVirtualSales(Integer virtualSales) {
            this.virtualSales = virtualSales;
            return this;
        }


        public String getCoverPic() {
            return coverPic;
        }

        public Add setCoverPic(String coverPic) {
            this.coverPic = coverPic;
            return this;
        }


        public String getVideoUrl() {
            return videoUrl;
        }

        public Add setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
            return this;
        }


        public String getUnit() {
            return unit;
        }

        public Add setUnit(String unit) {
            this.unit = unit;
            return this;
        }


        public Integer getIndividualShare() {
            return individualShare;
        }

        public Add setIndividualShare(Integer individualShare) {
            this.individualShare = individualShare;
            return this;
        }


        public BigDecimal getShareCommissionFirst() {
            return shareCommissionFirst;
        }

        public Add setShareCommissionFirst(BigDecimal shareCommissionFirst) {
            this.shareCommissionFirst = shareCommissionFirst;
            return this;
        }


        public BigDecimal getShareCommissionSecond() {
            return shareCommissionSecond;
        }

        public Add setShareCommissionSecond(BigDecimal shareCommissionSecond) {
            this.shareCommissionSecond = shareCommissionSecond;
            return this;
        }


        public BigDecimal getShareCommissionThird() {
            return shareCommissionThird;
        }

        public Add setShareCommissionThird(BigDecimal shareCommissionThird) {
            this.shareCommissionThird = shareCommissionThird;
            return this;
        }


        public Double getWeight() {
            return weight;
        }

        public Add setWeight(Double weight) {
            this.weight = weight;
            return this;
        }


        public Integer getFreight() {
            return freight;
        }

        public Add setFreight(Integer freight) {
            this.freight = freight;
            return this;
        }


        public String getFullCut() {
            return fullCut;
        }

        public Add setFullCut(String fullCut) {
            this.fullCut = fullCut;
            return this;
        }


        public String getIntegral() {
            return integral;
        }

        public Add setIntegral(String integral) {
            this.integral = integral;
            return this;
        }


        public Integer getUseAttr() {
            return useAttr;
        }

        public Add setUseAttr(Integer useAttr) {
            this.useAttr = useAttr;
            return this;
        }


        public Integer getShareType() {
            return shareType;
        }

        public Add setShareType(Integer shareType) {
            this.shareType = shareType;
            return this;
        }


        public Integer getQuickPurchase() {
            return quickPurchase;
        }

        public Add setQuickPurchase(Integer quickPurchase) {
            this.quickPurchase = quickPurchase;
            return this;
        }


        public Integer getHotCakes() {
            return hotCakes;
        }

        public Add setHotCakes(Integer hotCakes) {
            this.hotCakes = hotCakes;
            return this;
        }


        public BigDecimal getCostPrice() {
            return costPrice;
        }

        public Add setCostPrice(BigDecimal costPrice) {
            this.costPrice = costPrice;
            return this;
        }


        public Integer getMemberDiscount() {
            return memberDiscount;
        }

        public Add setMemberDiscount(Integer memberDiscount) {
            this.memberDiscount = memberDiscount;
            return this;
        }


        public BigDecimal getRebate() {
            return rebate;
        }

        public Add setRebate(BigDecimal rebate) {
            this.rebate = rebate;
            return this;
        }


        public Integer getMchId() {
            return mchId;
        }

        public Add setMchId(Integer mchId) {
            this.mchId = mchId;
            return this;
        }


        public Integer getGoodsNum() {
            return goodsNum;
        }

        public Add setGoodsNum(Integer goodsNum) {
            this.goodsNum = goodsNum;
            return this;
        }


        public Integer getMchSort() {
            return mchSort;
        }

        public Add setMchSort(Integer mchSort) {
            this.mchSort = mchSort;
            return this;
        }


        public Integer getConfineCount() {
            return confineCount;
        }

        public Add setConfineCount(Integer confineCount) {
            this.confineCount = confineCount;
            return this;
        }


        public Integer getIsLevel() {
            return isLevel;
        }

        public Add setIsLevel(Integer isLevel) {
            this.isLevel = isLevel;
            return this;
        }


        public Integer getType() {
            return type;
        }

        public Add setType(Integer type) {
            this.type = type;
            return this;
        }


        public Integer getIsNegotiable() {
            return isNegotiable;
        }

        public Add setIsNegotiable(Integer isNegotiable) {
            this.isNegotiable = isNegotiable;
            return this;
        }


        public Integer getAttrSettingType() {
            return attrSettingType;
        }

        public Add setAttrSettingType(Integer attrSettingType) {
            this.attrSettingType = attrSettingType;
            return this;
        }


        public String getBarcode() {
            return barcode;
        }

        public Add setBarcode(String barcode) {
            this.barcode = barcode;
            return this;
        }


    }

    public static class Edit {

        @NotNull(message = "请传入id")
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

        public Long getId() {
            return id;
        }

        public Edit setId(Long id) {
            this.id = id;
            return this;
        }


        public Integer getStoreId() {
            return storeId;
        }

        public Edit setStoreId(Integer storeId) {
            this.storeId = storeId;
            return this;
        }

        public String getName() {
            return name;
        }

        public Edit setName(String name) {
            this.name = name;
            return this;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public Edit setPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public BigDecimal getOriginalPrice() {
            return originalPrice;
        }

        public Edit setOriginalPrice(BigDecimal originalPrice) {
            this.originalPrice = originalPrice;
            return this;
        }

        public String getDetail() {
            return detail;
        }

        public Edit setDetail(String detail) {
            this.detail = detail;
            return this;
        }

        public Integer getCatId() {
            return catId;
        }

        public Edit setCatId(Integer catId) {
            this.catId = catId;
            return this;
        }

        public Integer getStatus() {
            return status;
        }

        public Edit setStatus(Integer status) {
            this.status = status;
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

        public String getAttr() {
            return attr;
        }

        public Edit setAttr(String attr) {
            this.attr = attr;
            return this;
        }

        public String getService() {
            return service;
        }

        public Edit setService(String service) {
            this.service = service;
            return this;
        }

        public Integer getSort() {
            return sort;
        }

        public Edit setSort(Integer sort) {
            this.sort = sort;
            return this;
        }

        public Integer getVirtualSales() {
            return virtualSales;
        }

        public Edit setVirtualSales(Integer virtualSales) {
            this.virtualSales = virtualSales;
            return this;
        }

        public String getCoverPic() {
            return coverPic;
        }

        public Edit setCoverPic(String coverPic) {
            this.coverPic = coverPic;
            return this;
        }

        public String getVideoUrl() {
            return videoUrl;
        }

        public Edit setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
            return this;
        }

        public String getUnit() {
            return unit;
        }

        public Edit setUnit(String unit) {
            this.unit = unit;
            return this;
        }

        public Integer getIndividualShare() {
            return individualShare;
        }

        public Edit setIndividualShare(Integer individualShare) {
            this.individualShare = individualShare;
            return this;
        }

        public BigDecimal getShareCommissionFirst() {
            return shareCommissionFirst;
        }

        public Edit setShareCommissionFirst(BigDecimal shareCommissionFirst) {
            this.shareCommissionFirst = shareCommissionFirst;
            return this;
        }

        public BigDecimal getShareCommissionSecond() {
            return shareCommissionSecond;
        }

        public Edit setShareCommissionSecond(BigDecimal shareCommissionSecond) {
            this.shareCommissionSecond = shareCommissionSecond;
            return this;
        }

        public BigDecimal getShareCommissionThird() {
            return shareCommissionThird;
        }

        public Edit setShareCommissionThird(BigDecimal shareCommissionThird) {
            this.shareCommissionThird = shareCommissionThird;
            return this;
        }

        public Double getWeight() {
            return weight;
        }

        public Edit setWeight(Double weight) {
            this.weight = weight;
            return this;
        }

        public Integer getFreight() {
            return freight;
        }

        public Edit setFreight(Integer freight) {
            this.freight = freight;
            return this;
        }

        public String getFullCut() {
            return fullCut;
        }

        public Edit setFullCut(String fullCut) {
            this.fullCut = fullCut;
            return this;
        }

        public String getIntegral() {
            return integral;
        }

        public Edit setIntegral(String integral) {
            this.integral = integral;
            return this;
        }

        public Integer getUseAttr() {
            return useAttr;
        }

        public Edit setUseAttr(Integer useAttr) {
            this.useAttr = useAttr;
            return this;
        }

        public Integer getShareType() {
            return shareType;
        }

        public Edit setShareType(Integer shareType) {
            this.shareType = shareType;
            return this;
        }

        public Integer getQuickPurchase() {
            return quickPurchase;
        }

        public Edit setQuickPurchase(Integer quickPurchase) {
            this.quickPurchase = quickPurchase;
            return this;
        }

        public Integer getHotCakes() {
            return hotCakes;
        }

        public Edit setHotCakes(Integer hotCakes) {
            this.hotCakes = hotCakes;
            return this;
        }

        public BigDecimal getCostPrice() {
            return costPrice;
        }

        public Edit setCostPrice(BigDecimal costPrice) {
            this.costPrice = costPrice;
            return this;
        }

        public Integer getMemberDiscount() {
            return memberDiscount;
        }

        public Edit setMemberDiscount(Integer memberDiscount) {
            this.memberDiscount = memberDiscount;
            return this;
        }

        public BigDecimal getRebate() {
            return rebate;
        }

        public Edit setRebate(BigDecimal rebate) {
            this.rebate = rebate;
            return this;
        }

        public Integer getMchId() {
            return mchId;
        }

        public Edit setMchId(Integer mchId) {
            this.mchId = mchId;
            return this;
        }

        public Integer getGoodsNum() {
            return goodsNum;
        }

        public Edit setGoodsNum(Integer goodsNum) {
            this.goodsNum = goodsNum;
            return this;
        }

        public Integer getMchSort() {
            return mchSort;
        }

        public Edit setMchSort(Integer mchSort) {
            this.mchSort = mchSort;
            return this;
        }

        public Integer getConfineCount() {
            return confineCount;
        }

        public Edit setConfineCount(Integer confineCount) {
            this.confineCount = confineCount;
            return this;
        }

        public Integer getIsLevel() {
            return isLevel;
        }

        public Edit setIsLevel(Integer isLevel) {
            this.isLevel = isLevel;
            return this;
        }

        public Integer getType() {
            return type;
        }

        public Edit setType(Integer type) {
            this.type = type;
            return this;
        }

        public Integer getIsNegotiable() {
            return isNegotiable;
        }

        public Edit setIsNegotiable(Integer isNegotiable) {
            this.isNegotiable = isNegotiable;
            return this;
        }

        public Integer getAttrSettingType() {
            return attrSettingType;
        }

        public Edit setAttrSettingType(Integer attrSettingType) {
            this.attrSettingType = attrSettingType;
            return this;
        }

        public String getBarcode() {
            return barcode;
        }

        public Edit setBarcode(String barcode) {
            this.barcode = barcode;
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