<#-- bean template -->
package ${conf.base_package}.${conf.bean_package};
import com.cnfwsy.core.bean.BaseForm;
<#list table.packages as package>
${package}
</#list>
/**
* 实体bean
* Created by zhangjh on ${.now}
*/
public class ${table.beanName} extends BaseForm{
<#assign properties = table.properties/>
<#assign keys = properties?keys/>
<#list keys as key>
    /**
    *
    */
    private ${properties["${key}"]} ${key};
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
}
