package ${conf.basePackage}.${conf.servicePackage}<#if table.prefix!="">.${table.prefix}</#if>;

<#assign beanName = table.beanName/>
import com.hpxs.base.BaseService;
import ${conf.basePackage}.${conf.entityPackage}<#if table.prefix!="">.${table.prefix}</#if>.${beanName};

/**
 * Copyright (C), 2017-2020, BBG
 * FileName: AccountController
 * Author:   zhangjh
 * Date:     ${.now}
 * Description:
 */
public interface ${beanName}Service extends BaseService<${table.beanName}> {

}