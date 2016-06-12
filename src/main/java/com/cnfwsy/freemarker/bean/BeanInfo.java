package com.cnfwsy.freemarker.bean;

/**
 * 表对应的属性
 * Created by zhangjh on 16/6/12.
 */
public class BeanInfo {
    /**
     * 属性名
     */
    private String propertyName;
    /**
     * 属性类型
     */
    private String propertyType;
    /**
     * 属性描述
     */
    private String propertyDesc;

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getPropertyDesc() {
        return propertyDesc;
    }

    public void setPropertyDesc(String propertyDesc) {
        this.propertyDesc = propertyDesc;
    }
}
