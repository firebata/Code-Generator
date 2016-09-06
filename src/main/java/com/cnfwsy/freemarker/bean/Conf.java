package com.cnfwsy.freemarker.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cnfwsy.freemarker.util.DbUtils;

/**
 * @author zhangjh
 */
public class Conf {
	private static final Logger LOGGER = LoggerFactory.getLogger(Conf.class);
//	private static final List<String> allModules = Arrays.asList("bean", "controller", "controllerTest", "model",
//			"modelTest", "service", "serviceTest", "impl", "mapper", "mapperTest", "xml");
	private static final List<String> allModules = new ArrayList<String>();
	private static final String ENTITY = "entity";
	private static final String DAO = "dao";
	private static final String DAOTEST = "daoTest";
	private static final String MAPPERXML = "mapperXml";
	private static final String MODEL = "model";
	private static final String MODELTEST= "modelTest";
	private static final String SERVICE = "service";
	private static final String SERVICETEST = "serviceTest";
	private static final String SERVICEIMPL = "serviceImpl";
	private static final String CONTROLLER = "controller";
	private static final String CONTROLLERTEST = "controllerTest";
	
	static {
		allModules.add(ENTITY);
		allModules.add(DAO);
		allModules.add(MAPPERXML);
//		allModules.add(DAOTEST);
//		allModules.add(MODEL);
//		allModules.add(MODELTEST);
		allModules.add(SERVICE);
//		allModules.add(SERVICETEST);
		allModules.add(SERVICEIMPL);
		allModules.add(CONTROLLER);
//		allModules.add(CONTROLLERTEST);
	}
	private String basePackage;
	private String entityPackage;
	private String daoPackage;
	private String modelPackage;
	private String xmlPackage;
	private String servicePackage;
	private String controllerPackage;
	
	private String entitySuffix;
	private String daoName;
	private String implSuffix;
	private String serviceImplPackage;
	private String serviceName;
	private String controllerName;
	private String mapperXmlName;
	private boolean serviceNeedI;
	private String testSuffix;
	
	private String tables;
	private String needModules;
	private List<String> modules;
	private boolean force;// 重新生成文件
	private boolean prefix;// 表名前缀
	private boolean underline2Camel;// 是否需要将表字段转成驼峰

	public static List<String> getAllModules() {
		return allModules;
	}

	// public static void setAllModules(List<String> allModules) {
	// Conf.allModules = allModules;
	// }

	public boolean isForce() {
		return force;
	}

	public void setForce(boolean force) {
		this.force = force;
	}

	public boolean isPrefix() {
		return prefix;
	}

	public void setPrefix(boolean prefix) {
		this.prefix = prefix;
	}

	public String getTables() {
		return tables;
	}

	public void setTables(String tables) {
		this.tables = tables;
	}

	public String getNeedModules() {
		return needModules;
	}

	public void setNeedModules(String needModules) {
		this.needModules = needModules;
	}

	public List<String> getModules() {
		List<String> modules = new ArrayList<>();
		if (StringUtils.isBlank(needModules) || needModules.equals("all")) {
			modules = allModules;
		} else {
			String needModules = getNeedModules();
			modules = Arrays.asList(needModules.split(","));
		}
		return modules;
	}

	public void setModules(List<String> modules) {
		this.modules = modules;
	}

	/**
	 * @return
	 */
	public Conf getConf() {
		Properties pro = new Properties();
		try {
			pro.load(DbUtils.class.getClassLoader().getResourceAsStream("conf.properties"));
		} catch (IOException e) {
			LOGGER.error("未找到配置文件", e);
		}

		String basePackage = pro.getProperty("base_package");
		String entityPackage = pro.getProperty("entity_package");
		String daoPackage = pro.getProperty("dao_package");
		String modelPackage = pro.getProperty("model_package");
		String xmlPackage = pro.getProperty("xml_package");
		String servicePackage = pro.getProperty("service_package");
		String controllerPackage = pro.getProperty("controller_package");
		String tables = pro.getProperty("tables");
		String needModules = pro.getProperty("needModules");
		String forceStr = pro.getProperty("force");
		String prefixStr = pro.getProperty("prefix");
		String underline2CamelStr = pro.getProperty("underline2Camel");
		
		String entitySuffix = pro.getProperty("eneity_suffix");
		String daoName = pro.getProperty("dao_name");
		
		String implSuffix = pro.getProperty("impl_suffix");
		String serviceImplPackage = pro.getProperty("serviceimpl_package");
		String serviceName = pro.getProperty("service_name");
		String controllerName = pro.getProperty("controller_name");
		String mapperXmlName = pro.getProperty("mapperxml_name");
		String testSuffix = pro.getProperty("test_suffix");
		
		this.setBasePackage(basePackage);
		this.setEntityPackage(entityPackage);
		this.setDaoPackage(daoPackage);
		this.setXmlPackage(xmlPackage);
		this.setModelPackage(modelPackage);
		this.setServicePackage(servicePackage);
		this.setControllerPackage(controllerPackage);
		this.setTables(tables);
		this.setNeedModules(needModules);
		this.setEntitySuffix(entitySuffix);
		this.setDaoName(daoName);
		this.setImplSuffix(implSuffix);
		this.setServiceImplPackage(serviceImplPackage);
		this.setServiceName(serviceName);
		this.setControllerName(controllerName);
		this.setMapperXmlName(mapperXmlName);
		this.setTestSuffix(testSuffix);
		
		String serviceNeedIStr = pro.getProperty("service_need_i");
		
		boolean force = false;
		boolean prefix = true;
		boolean underline2Camel = true;
		boolean serviceNeedI = false;
		
		if (StringUtils.isNotBlank(serviceNeedIStr) && (serviceNeedIStr.equals("true") || serviceNeedIStr.equals("false"))) {
			serviceNeedI = Boolean.parseBoolean(serviceNeedIStr);
		}
		if (StringUtils.isNotBlank(forceStr) && (forceStr.equals("true") || forceStr.equals("false"))) {
			force = Boolean.parseBoolean(forceStr);
		}
		if (StringUtils.isNotBlank(prefixStr) && (prefixStr.equals("true") || prefixStr.equals("false"))) {
			prefix = Boolean.parseBoolean(prefixStr);
		}
		if (StringUtils.isNotBlank(underline2CamelStr)
				&& (underline2CamelStr.equals("true") || underline2CamelStr.equals("false"))) {
			underline2Camel = Boolean.parseBoolean(underline2CamelStr);
		}

		this.setForce(force);
		this.setPrefix(prefix);
		this.setUnderline2Camel(underline2Camel);
		this.setServiceNeedI(serviceNeedI);

		return this;
	}

	public boolean isUnderline2Camel() {
		return underline2Camel;
	}

	public void setUnderline2Camel(boolean underline2Camel) {
		this.underline2Camel = underline2Camel;
	}

	public String getBasePackage() {
		return basePackage;
	}

	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}

	public String getEntityPackage() {
		return entityPackage;
	}

	public void setEntityPackage(String entityPackage) {
		this.entityPackage = entityPackage;
	}

	public String getDaoPackage() {
		return daoPackage;
	}

	public void setDaoPackage(String daoPackage) {
		this.daoPackage = daoPackage;
	}

	public String getModelPackage() {
		return modelPackage;
	}

	public void setModelPackage(String modelPackage) {
		this.modelPackage = modelPackage;
	}

	public String getXmlPackage() {
		return xmlPackage;
	}

	public void setXmlPackage(String xmlPackage) {
		this.xmlPackage = xmlPackage;
	}

	public String getServicePackage() {
		return servicePackage;
	}

	public void setServicePackage(String servicePackage) {
		this.servicePackage = servicePackage;
	}

	public String getControllerPackage() {
		return controllerPackage;
	}

	public void setControllerPackage(String controllerPackage) {
		this.controllerPackage = controllerPackage;
	}

	public String getEntitySuffix() {
		return entitySuffix;
	}

	public void setEntitySuffix(String entitySuffix) {
		this.entitySuffix = entitySuffix;
	}

	public String getDaoName() {
		return daoName;
	}

	public void setDaoName(String daoName) {
		this.daoName = daoName;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public String getImplSuffix() {
		return implSuffix;
	}

	public void setImplSuffix(String implSuffix) {
		this.implSuffix = implSuffix;
	}

	public String getServiceImplPackage() {
		return serviceImplPackage;
	}

	public void setServiceImplPackage(String serviceImplPackage) {
		this.serviceImplPackage = serviceImplPackage;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getControllerName() {
		return controllerName;
	}

	public void setControllerName(String controllerName) {
		this.controllerName = controllerName;
	}

	public String getMapperXmlName() {
		return mapperXmlName;
	}

	public void setMapperXmlName(String mapperXmlName) {
		this.mapperXmlName = mapperXmlName;
	}

	public boolean isServiceNeedI() {
		return serviceNeedI;
	}

	public void setServiceNeedI(boolean serviceNeedI) {
		this.serviceNeedI = serviceNeedI;
	}

	public String getTestSuffix() {
		return testSuffix;
	}

	public void setTestSuffix(String testSuffix) {
		this.testSuffix = testSuffix;
	}
}
