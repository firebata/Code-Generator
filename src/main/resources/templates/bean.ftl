<#-- bean template -->
package ${conf.base_package}.${conf.bean_package}<#if prefixName??>.${prefixName}</#if>;
import com.hpxs.base.BaseEntity;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
<#list table.packages as package>
${package}
</#list>
/**
* 实体bean
* Created by noname on ${.now}
*/
public class ${table.beanName} extends BaseEntity implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
<#assign properties = table.properties/>
<#assign properties2 = table.properties2/>
<#assign keys = properties?keys/>
<#list properties2 as bean>
    /**
    *${bean.propertyDesc}
    */
    private ${bean.propertyType} ${bean.propertyName};
</#list>

<#list keys as key>
    /**
    *
    */
    public  ${properties["${key}"]} get${key?cap_first}(){
        return this.${key};
    }

    /**
    *
    */
    public  void set${key?cap_first}(${properties["${key}"]} ${key}){
        this.${key} = ${key};
    }

</#list>

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
