package ${conf.basePackage}.${conf.servicePackage}<#if table.prefix!="">.${table.prefix}</#if>;

<#assign beanName = table.beanName/>
import com.hpxs.base.BaseService;
import ${conf.basePackage}.${conf.entityPackage}<#if table.prefix!="">.${table.prefix}</#if>.${beanName};

/**
 * 类说明:
 *
 * Created by noname on ${.now}
 */
public interface ${beanName}Service extends BaseService<${table.beanName}> {

}