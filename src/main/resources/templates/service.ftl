package ${conf.base_package}.${conf.service_package};
<#assign beanName = table.beanName/>
import com.cnfwsy.core.model.common.ICommonService;
import ${conf.base_package}.${conf.bean_package}.${beanName};

/**
* 类说明:
* Created by zhangjh on ${.now}
*/
public interface I${beanName}Service extends ICommonService<${beanName}> {

}