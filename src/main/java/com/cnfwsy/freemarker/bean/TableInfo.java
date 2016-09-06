package com.cnfwsy.freemarker.bean;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

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
	 * 前缀
	 */
	private String prefix;

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
	@Deprecated
	private Map<String, String> properties;
	
	/**
	 * 属性,属性类型
	 */
	private Map<String, BeanInfo> propInfoMap;

	/**
	 * 属性,属性类型,属性描述
	 */
	private List<BeanInfo> allPropInfo;
	/**
	 * 属性,属性类型
	 */
	private Map<String, String> propertiesAnColumns;

	/**
	 * 属性,属性类型
	 */
	private Map<String, String> insertPropertiesAnColumns;

	/**
	 * bean类导入的包,如java.util.Date，java.math.BigDecimal;等
	 */
	private Set<String> propTypePackages;

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

	@Deprecated
	public Map<String, String> getProperties() {
		return properties;
	}

	@Deprecated
	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public Set<String> getPropTypePackages() {
		return propTypePackages;
	}

	public void setPropTypePackages(Set<String> propTypePackages) {
		this.propTypePackages = propTypePackages;
	}

	public List<BeanInfo> getAllPropInfo() {
		return allPropInfo;
	}

	public void setAllPropInfo(List<BeanInfo> allPropInfo) {
		this.allPropInfo = allPropInfo;
	}

	public Map<String, BeanInfo> getPropInfoMap() {
		return propInfoMap;
	}

	public void setPropInfoMap(Map<String, BeanInfo> propInfoMap) {
		this.propInfoMap = propInfoMap;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
}
