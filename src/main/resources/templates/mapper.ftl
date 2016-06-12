package ${conf.base_package}.${conf.mapper_package}<#if prefixName??>.${prefixName}</#if>;

import com.cnfwsy.core.mapper.CommonMapper;
import ${conf.base_package}.${conf.bean_package}<#if prefixName??>.${prefixName}</#if>.${table.beanName};
import org.springframework.stereotype.Repository;

/**
* 类说明:
* Created by zhangjh on ${.now}
*/
@Repository("${(table.beanName + "Mapper")?uncap_first}")
public interface ${table.beanName}Mapper  extends CommonMapper<${table.beanName}> {




}