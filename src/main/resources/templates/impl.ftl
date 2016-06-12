<#import "base/date.ftl" as dt>
package ${conf.base_package}.${conf.service_package}<#if prefixName??>.${prefixName}</#if>.impl;
<#assign beanName = table.beanName/>
<#assign beanNameUncap_first = beanName?uncap_first/>
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import com.cnfwsy.core.model.common.impl.CommonServiceImpl;
import com.cnfwsy.core.bean.BaseForm;
import ${conf.base_package}.${conf.bean_package}<#if prefixName??>.${prefixName}</#if>.${beanName};
import ${conf.base_package}.${conf.service_package}<#if prefixName??>.${prefixName}</#if>.I${beanName}Service;
import ${conf.base_package}.${conf.mapper_package}<#if prefixName??>.${prefixName}</#if>.${beanName}Mapper;
import java.util.List;
/**
* 类说明:
* Created by zhangjh on ${.now}
*/
@Service("${beanNameUncap_first}ServiceImpl")
public class ${beanName}ServiceImpl extends CommonServiceImpl<${beanName}> implements I${beanName}Service, InitializingBean {
        @Resource(name = "${beanNameUncap_first}Mapper")
        private ${beanName}Mapper ${beanNameUncap_first}Mapper;

        @Override
        public void afterPropertiesSet() {
            commonMapper = ${beanNameUncap_first}Mapper;
        }

        @Override
        public List<${beanName}> searchInfos(BaseForm info) {
            List<${beanName}> resut = null;
            resut= super.searchInfos(info);
            return resut;
        }


        @Override
        public void add(${beanName} info) {
            super.add(info);
        }

        @Override
        public void edit(${beanName} info) {
            super.edit(info);
        }

        @Override
        public ${beanName} queryInfoByNatrualKey(String natrualKey) {
            return super.queryInfoByNatrualKey(natrualKey);
        }

        @Override
        public void del(String natrualKey) {
            super.del(natrualKey);
        }

}