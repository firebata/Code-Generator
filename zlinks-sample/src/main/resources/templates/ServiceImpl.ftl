<#import "base/date.ftl" as dt>
package ${conf.servicePackage}.impl<#if table.prefix!="">.${table.prefix}</#if>;

<#assign beanName = table.beanName/>
<#assign beanNameUncap_first = beanName?uncap_first/>
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import ${conf.entityPackage}<#if table.prefix!="">.${table.prefix}</#if>.${beanName};
import ${conf.servicePackage}<#if table.prefix!="">.${table.prefix}</#if>.${beanName}Service;
import ${conf.daoPackage}<#if table.prefix!="">.${table.prefix}</#if>.${beanName}Dao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * Copyright (C), 2017-2020, BBG
 * FileName: AccountController
 * Author:   zhangjh
 * Date:     ${.now}
 * Description:业务
 */
@Service
public class ${beanName}ServiceImpl implements ${beanName}Service {

	@Autowired
	private ${beanName}Mapper ${beanNameUncap_first}Mapper;

	@Override
	public ${beanName} getById(int id) {
		return ${beanNameUncap_first}Mapper.getById(id);
	}

	@Override
	public int getListCount(${beanName} entity) {
		return ${beanNameUncap_first}Mapper.getListCount(entity);
	}

	@Override
	public List<${beanName}> getList(${beanName} entity) {
		List<${beanName}> resut = null;
		resut = ${beanNameUncap_first}Mapper.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return ${beanNameUncap_first}Mapper.getListByMapCount(paramMap);
	}

	@Override
	public List<${beanName}> getListByMap(Map<String, Object> paramMap) {
		List<${beanName}> resut = null;
		resut = ${beanNameUncap_first}Mapper.getListByMap(paramMap);
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(${beanName} entity) {
		return ${beanNameUncap_first}Mapper.update(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return ${beanNameUncap_first}Mapper.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(${beanName} entity) {
		return ${beanNameUncap_first}Mapper.add(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<${beanName}> entityList) {
		return ${beanNameUncap_first}Mapper.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<${beanName}> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<${beanName}> getActivedList() {
		List<${beanName}> resut = null;
		${beanName} entity = new ${beanName}();
		entity.setIsDeleted(0);
		resut = ${beanNameUncap_first}Mapper.getList(entity);
		return resut;
	}
}