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

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hpxs.test.Junit4SpringTestBase;

/**
* 类说明:
* Created by noname on ${.now}
*/
public class ${beanName}ServiceTest extends Junit4SpringTestBase {

	@Resource(name = "${beanNameUncap_first}Service")
    private ${beanName}Service ${beanNameUncap_first}Service;
    
    static ${beanName} ${beanNameUncap_first};
	
	static Map<String, Object> paramMap = new LinkedHashMap<String, Object>();
	static int pageSize = 10;
	static int pageNo =1;
    
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		${beanNameUncap_first} = new ${beanName};
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void test() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public ${beanName} getById(int id){
		${beanName}  ${beanNameUncap_first} =  ${beanNameUncap_first}Service.selectById(id);
		return 
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
        ${beanName}  ${beanNameUncap_first} =  ${beanNameUncap_first}Service.add(${beanNameUncap_first});
		return 
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