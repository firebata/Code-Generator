package ${conf.base_package}.${conf.service_package}<#if prefixName??>.${prefixName}</#if>;
<#assign beanName = table.beanName/>
import com.hpxs.base.BaseService;
import ${conf.base_package}.${conf.bean_package}<#if prefixName??>.${prefixName}</#if>.${beanName};

/**
* 类说明:
* Created by noname on ${.now}
*/
public interface ${beanName}Service extends BaseService<${table.beanName}> {

}