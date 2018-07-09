package com.zlinks.samples.creator.impl;

import com.zlinks.samples.bean.Conf;
import com.zlinks.samples.bean.Constants;
import com.zlinks.samples.bean.TableInfo;
import com.zlinks.samples.creator.AbstractFileCreator;

/**
 * 创建bean
 *
 * @author zhangjh
 */
public class EntityClassCreator extends AbstractFileCreator {

	private static EntityClassCreator creator;

	private EntityClassCreator() {
		super();
	}

	private EntityClassCreator(Conf conf) {
		super();
		init(conf);
	}

	public static synchronized EntityClassCreator getInstance(Conf conf) {
		if (null == creator) {
			creator = new EntityClassCreator(conf);
		}
		return creator;
	}

	@Override
	public String getFileName(TableInfo tableInfo) {
		return tableInfo.getBeanName() + Constants.JAVA_SUFFIX;
	}

	@Override
	public String getTempletName() {
		return ModuleEnum.Entity.name() + Constants.TEMPLET_SUFFIX;
	}

	@Override
	public String getDirPath() {
		return javaPath + conf.getEntityPackage();
	}

	@Override
	public void setPackageName(TableInfo tableInfo) {
		String entityPackage = conf.getBasePackage() + Constants.PACKAGE_SEPARATOR + conf.getEntityPackage();
		tableInfo.setEntityPackage(entityPackage);
	}

}
