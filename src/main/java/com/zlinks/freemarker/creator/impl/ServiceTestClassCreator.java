package com.zlinks.freemarker.creator.impl;

import com.zlinks.freemarker.bean.Conf;
import com.zlinks.freemarker.bean.Constants;
import com.zlinks.freemarker.bean.TableInfo;
import com.zlinks.freemarker.creator.AbstractFileCreator;

/**
 * 创建业务接口实例类
 *
 * @author zhangjh
 */
public class ServiceTestClassCreator extends AbstractFileCreator {
	private static ServiceTestClassCreator creator;

	private ServiceTestClassCreator() {
		super();
	}

	private ServiceTestClassCreator(Conf conf) {
		super();
		init(conf);
	}

	public static synchronized ServiceTestClassCreator getInstance(Conf conf) {
		if (null == creator) {
			creator = new ServiceTestClassCreator(conf);
		}
		return creator;
	}

	@Override
	public String getFileName(TableInfo tableInfo) {
		return tableInfo.getBeanName() + conf.getServiceName() + conf.getTestSuffix() + Constants.JAVA_SUFFIX;
	}

	@Override
	public String getTempletName() {
		return ModuleEnum.ServiceTest.name() + Constants.TEMPLET_SUFFIX;
	}

	@Override
	public String getDirPath() {
		return javaPath + conf.getServicePackage();
	}

	@Override
	public void setPackageName(TableInfo tableInfo) {
		String serviceTestPackage = conf.getBasePackage() + Constants.PACKAGE_SEPARATOR + conf.getServicePackage();
		tableInfo.setServiceTestPackage(serviceTestPackage);
	}

}
