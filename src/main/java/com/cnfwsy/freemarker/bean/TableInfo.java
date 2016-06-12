package com.cnfwsy.freemarker.bean;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 表对象
 *
 * @author zhangjh
 */
public class TableInfo {
    /**
     * 表名
     */
    private String tableName;

    /**
     * bean
     */
    private String beanName;

    /**
     * 表名
     */
    private String tableDesc;

    /**
     * 主键映射
     */
    private Map<String, String> primaryKey;
    /**
     * 字段类型映射
     */
    private List<ColumnInfo> columns;

    /**
     * 属性,属性类型
     */
    private Map<String, String> properties;

    /**
     * 属性,属性类型
     */
    private List<BeanInfo> properties2;
    /**
     * 属性,属性类型
     */
    private Map<String, String> propertiesAnColumns;

    /**
     * 属性,属性类型
     */
    private Map<String, String> insertPropertiesAnColumns;

    /**
     * bean类导入的包
     */
    private Set<String> packages;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getTableDesc() {
        return tableDesc;
    }

    public void setTableDesc(String tableDesc) {
        this.tableDesc = tableDesc;
    }

    public Map<String, String> getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(Map<String, String> primaryKey) {
        this.primaryKey = primaryKey;
    }

    public List<ColumnInfo> getColumns() {
        return columns;
    }

    public void setColumns(List<ColumnInfo> columns) {
        this.columns = columns;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public List<BeanInfo> getProperties2() {
        return properties2;
    }

    public void setProperties2(List<BeanInfo> properties2) {
        this.properties2 = properties2;
    }

    public Map<String, String> getPropertiesAnColumns() {
        return propertiesAnColumns;
    }

    public void setPropertiesAnColumns(Map<String, String> propertiesAnColumns) {
        this.propertiesAnColumns = propertiesAnColumns;
    }

    public Map<String, String> getInsertPropertiesAnColumns() {
        return insertPropertiesAnColumns;
    }

    public void setInsertPropertiesAnColumns(Map<String, String> insertPropertiesAnColumns) {
        this.insertPropertiesAnColumns = insertPropertiesAnColumns;
    }

    public Set<String> getPackages() {
        return packages;
    }

    public void setPackages(Set<String> packages) {
        this.packages = packages;
    }
}
