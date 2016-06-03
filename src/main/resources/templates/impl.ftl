<#import "base/date.ftl" as dt>
package ${conf.base_package}.${conf.service_package}.impl;
<#assign beanName = table.beanName/>
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import com.cnfwsy.core.model.common.impl.CommonServiceImpl;
import ${conf.base_package}.${conf.bean_package}.${beanName};
import ${conf.base_package}.${conf.service_package}.I${beanName}Service;
import ${conf.base_package}.${conf.mapper_package}.${beanName}Mapper;
/**
* 类说明:
* Created by zhangjh on ${.now}
*/
@Service("${beanName?uncap_first}ServiceImpl")
public class ${beanName}ServiceImpl extends CommonServiceImpl<${beanName}> implements I${beanName}Service, InitializingBean {
    @Resource(name = "${beanName?uncap_first}Mapper")
    private ${beanName}Mapper ${beanName?uncap_first}Mapper;

    @Override
    public void afterPropertiesSet() {
        commonMapper = ${beanName?uncap_first}Mapper;
    }

}