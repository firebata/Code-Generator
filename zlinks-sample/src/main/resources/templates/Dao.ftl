package ${conf.daoPackage}<#if table.prefix!="">.${table.prefix}</#if>;

<#--
import java.util.List;
-->
import ${conf.entityPackage}<#if table.prefix!="">.${table.prefix}</#if>.${table.beanName};
import org.apache.ibatis.annotations.Mapper;

/**
 * Copyright (C), 2017-2018, BBG
 * FileName: AccountMapper
 * Author:   zhangjh
 * Date:     ${.now}
 * Description: 账号
 */
@Mapper
public interface ${table.beanName}Mapper{

<#--

	${table.beanName} selectById(int id);

	int selectCount();

	int selectCountByCondition();

	List<${table.beanName}> selectByCondition();

	int updateById(${table.beanName} entity);

	int deleteById(int id);

	int insert(${table.beanName} entity);

	int insertList(List<${table.beanName}> entityList);

-->
}