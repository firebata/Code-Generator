package com.zlinks.samples.creator.impl;

import com.zlinks.samples.ModuleEnum;
import com.zlinks.samples.bean.Conf;
import com.zlinks.samples.bean.Constants;
import com.zlinks.samples.bean.TableInfo;
import com.zlinks.samples.creator.AbstractFileCreator;

/**
 * 创建controller
 *
 * @author zhangjh
 */
public class ControllerClassCreator extends AbstractFileCreator {
	private static ControllerClassCreator creator;

	private ControllerClassCreator() {
		super();
	}

	private ControllerClassCreator(Conf conf) {
		super();
		init(conf);
	}

	public static synchronized ControllerClassCreator getInstance(Conf conf) {
		if (null == creator) {
			creator = new ControllerClassCreator(conf);
		}
		return creator;
	}

	@Override
	public String getFileName(TableInfo tableInfo) {
		return tableInfo.getBeanName() + conf.getControllerName() + Constants.JAVA_SUFFIX;
	}

	@Override
	public String getTempletName() {
		return ModuleEnum.Controller.name() + Constants.TEMPLET_SUFFIX;
	}

	@Override
	public String getDirPath() {
		return javaPath + conf.getController_dir();
	}

	@Override
	public void setPackageName(TableInfo tableInfo) {
		String controllerPackage = conf.getBasePackage() + Constants.PACKAGE_SEPARATOR + conf.getControllerPackage();
		tableInfo.setControllerPackage(controllerPackage);
	}

}
