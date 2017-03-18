<#-- bean template -->
package ${conf.basePackage}.${conf.entityPackage}<#if table.prefix!="">.${table.prefix}</#if>;

import com.hpxs.base.BaseEntity;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
<#list table.propTypePackages as package>
${package}
</#list>

/**
 * 实体bean
 * <p>
 * 表名：${table.tableName}
 * <p>
 * 描述：${table.tableDesc}
 */
public class ${table.beanName} extends BaseEntity implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
<#assign properties = table.properties/>
<#assign propInfoMap = table.propInfoMap/>
<#assign allPropInfo = table.allPropInfo/>
<#assign keys = propInfoMap?keys/>
<#list allPropInfo as prop>
	/**
	 * ${prop.propertyDesc}
	 */
	private ${prop.propertyType} ${prop.propertyName};
</#list>

<#list allPropInfo as prop>
	/**
	 * 获取${prop.propertyDesc}
	 */
	public ${prop.propertyType} get${prop.propertyName?cap_first}() {
		return this.${prop.propertyName};
	}

	/**
	 * 设置${prop.propertyDesc}
	 */
	public void set${prop.propertyName?cap_first}(${prop.propertyType} ${prop.propertyName}) {
		this.${prop.propertyName} = ${prop.propertyName};
	}

</#list>
<#--
<#list keys as key>
	/**
	 * 获取${propInfoMap["${key}"].propertyDesc}
	 */
	public ${properties["${key}"]} get${key?cap_first}() {
		return this.${key};
	}

	/**
	 * 设置${propInfoMap["${key}"].propertyDesc}
	 */
	public void set${key?cap_first}(${properties["${key}"]} ${key}) {
		this.${key} = ${key};
	}

</#list>
-->
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
