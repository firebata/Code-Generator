package com.zlinks.freemarker.creator.impl;

import com.zlinks.freemarker.bean.Conf;
import com.zlinks.freemarker.bean.Constants;
import com.zlinks.freemarker.bean.TableInfo;
import com.zlinks.freemarker.creator.AbstractFileCreator;

/**
 * 创建业务接口类
 *
 * @author zhangjh
 */
public class ServiceClassCreator extends AbstractFileCreator {
	private static ServiceClassCreator creator;

	private ServiceClassCreator() {
		super();
	}

	private ServiceClassCreator(Conf conf) {
		super();
		init(conf);
	}

	public static synchronized ServiceClassCreator getInstance(Conf conf) {
		if (null == creator) {
			creator = new ServiceClassCreator(conf);
		}
		return creator;
	}

	@Override
	public String getFileName(TableInfo tableInfo) {
		return tableInfo.getBeanName() + conf.getServiceName() + Constants.JAVA_SUFFIX;
	}

	@Override
	public String getTempletName() {
		return ModuleEnum.Service.name() + Constants.TEMPLET_SUFFIX;
	}

	@Override
	public String getDirPath() {
		return javaPath + conf.getServicePackage();
	}

	@Override
	public void setPackageName(TableInfo tableInfo) {
		String servicePackage = conf.getBasePackage() + Constants.PACKAGE_SEPARATOR + conf.getServicePackage();
		tableInfo.setServicePackage(servicePackage);
	}

}
