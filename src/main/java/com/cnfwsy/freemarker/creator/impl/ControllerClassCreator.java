package com.cnfwsy.freemarker.creator.impl;

import com.cnfwsy.freemarker.bean.Conf;
import com.cnfwsy.freemarker.bean.TableInfo;
import com.cnfwsy.freemarker.creator.AbstractFileCreator;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
	public void createFile(TableInfo tableInfo) throws IOException, TemplateException {
		String ftl = "controller.ftl";
		String fileName = tableInfo.getBeanName() + conf.getControllerName() + ".java";
		String selfPath = conf.getControllerPackage();
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("table", tableInfo);
		root.put("conf", conf);
		Template temp = cfg.getTemplate(ftl);
		String filePath = javaPath + selfPath;
		if (conf.isPrefix()) {
			filePath = filePath + separator + tableInfo.getPrefix();
		}
		fileName = filePath + separator + fileName;
		createFile(fileName, root, temp);
	}

}
