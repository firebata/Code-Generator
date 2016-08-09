<#import "base/date.ftl" as dt>
package ${conf.base_package}.${conf.service_package}<#if prefixName??>.${prefixName}</#if>.impl;
<#assign beanName = table.beanName/>
<#assign beanNameUncap_first = beanName?uncap_first/>
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import ${conf.base_package}.${conf.bean_package}<#if prefixName??>.${prefixName}</#if>.${beanName};
import ${conf.base_package}.${conf.service_package}<#if prefixName??>.${prefixName}</#if>.${beanName}Service;
import ${conf.base_package}.${conf.mapper_package}<#if prefixName??>.${prefixName}</#if>.${beanName}Dao;
import java.util.List;
import java.util.Map;

import com.sojson.core.mybatis.BaseMybatisDao;
import com.sojson.core.mybatis.page.Pagination;

/**
* 类说明:
* Created by noname on ${.now}
*/
@Service("${beanNameUncap_first}Service")
public class ${beanName}ServiceImpl extends BaseMybatisDao<${beanName}Dao> implements ${beanName}Service {
	@Resource(name = "${beanNameUncap_first}Dao")
    private ${beanName}Dao ${beanNameUncap_first}Dao;

	@Override
	public ${beanName} getById(int id){
		return ${beanNameUncap_first}Dao.selectById(id);
	}
	
	@Override
	public int getCount(){
		return ${beanNameUncap_first}Dao.selectCount();
	}
	
	@Override
	public int queryCount(${beanName} entity){
		return ${beanNameUncap_first}Dao.selectCountByCondition(entity);
	}
	
    @Override
    public List<${beanName}> query(${beanName} entity) {
        List<${beanName}> resut = null;
        resut= ${beanNameUncap_first}Dao.selectByCondition(entity);
        return resut;
    }
    
    @Override
    public int update(${beanName} entity) {
        return ${beanNameUncap_first}Dao.updateById(entity);
    }

    @Override
    public int delete(int id) {
        return ${beanNameUncap_first}Dao.deleteById(id);
    }

    @Override
    public int add(${beanName} entity) {
        return ${beanNameUncap_first}Dao.insert(entity);
    }

    @Override
    public int addList(List<${beanName}> entityList) {
        return ${beanNameUncap_first}Dao.insertList(entityList);
    }

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<${beanName}> findPage(Map<String,Object> resultMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(resultMap, pageNo, pageSize);
	}
}