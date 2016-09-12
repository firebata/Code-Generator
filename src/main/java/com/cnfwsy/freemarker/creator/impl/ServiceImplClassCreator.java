package com.cnfwsy.freemarker.creator.impl;

import com.cnfwsy.freemarker.bean.Conf;
import com.cnfwsy.freemarker.bean.Constants;
import com.cnfwsy.freemarker.bean.TableInfo;
import com.cnfwsy.freemarker.creator.AbstractFileCreator;

/**
 * 创建业务接口实例类
 *
 * @author zhangjh
 */
public class ServiceImplClassCreator extends AbstractFileCreator {
	private static ServiceImplClassCreator creator;

	private ServiceImplClassCreator() {
		super();
	}

	private ServiceImplClassCreator(Conf conf) {
		super();
		init(conf);
	}

	public static synchronized ServiceImplClassCreator getInstance(Conf conf) {
		if (null == creator) {
			creator = new ServiceImplClassCreator(conf);
		}
		return creator;
	}

	@Override
	public String getFileName(TableInfo tableInfo) {
		return tableInfo.getBeanName() + conf.getServiceName() + conf.getImplSuffix() + Constants.JAVA_SUFFIX;
	}

	@Override
	public String getTempletName() {
		return ModuleEnum.ServiceImpl.name() + Constants.TEMPLET_SUFFIX;
	}

	@Override
	public String getDirPath() {
		return javaPath + conf.getServicePackage() + conf.getServiceImplPackage();
	}

	@Override
	public void setPackageName(TableInfo tableInfo) {
		String serviceImplPackage = conf.getBasePackage() + Constants.PACKAGE_SEPARATOR + conf.getServicePackage()
				+ Constants.PACKAGE_SEPARATOR + conf.getServiceImplPackage();
		tableInfo.setServiceImplPackage(serviceImplPackage);
	}

}
