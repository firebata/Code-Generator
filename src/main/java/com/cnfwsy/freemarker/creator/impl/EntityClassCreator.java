package com.cnfwsy.freemarker.creator.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.cnfwsy.freemarker.bean.Conf;
import com.cnfwsy.freemarker.bean.TableInfo;
import com.cnfwsy.freemarker.creator.AbstractFileCreator;

import freemarker.template.Template;
import freemarker.template.TemplateException;

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
	public void createFile(TableInfo tableInfo) throws IOException, TemplateException {
		String ftl = "entity.ftl";
		String fileName = tableInfo.getBeanName() + ".java";
		String selfPath = conf.getEntityPackage();
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
