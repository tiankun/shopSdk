package com.redare.shop.unifyworkbench.sdk.pojo.enumpackage;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/6/12 14:55
 * @version: 1
 */
public enum ClassifyEnum {
    EVENTCENTER("eventcenter","事件中心"),
    APPLICATION("application","应用"),
    DATACENTER("datacenter","数据中心");

    private String code;
    private String name;

    ClassifyEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public ClassifyEnum setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public ClassifyEnum setName(String name) {
        this.name = name;
        return this;
    }

    public static String getName(String code) {
        for (ClassifyEnum c : ClassifyEnum.values()) {
            if (c.getCode().equals(code)) {
                return c.name;
            }
        }
        return null;
    }
}
