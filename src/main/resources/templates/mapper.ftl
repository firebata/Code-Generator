package ${conf.basePackage}.${conf.daoPackage}<#if table.prefix!="">.${table.prefix}</#if>;
<#--
import java.util.List;
-->
import com.hpxs.base.BaseDao;
import ${conf.basePackage}.${conf.entityPackage}<#if table.prefix!="">.${table.prefix}</#if>.${table.beanName};


/**
* 类说明:
* Created by noname on ${.now}
*/
public interface ${table.beanName}Dao extends BaseDao<${table.beanName}> {

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