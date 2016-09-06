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
 * 创建xml映射文件
 *
 * @author zhangjh
 */
public class XmlCreator extends AbstractFileCreator {
    private static XmlCreator creator;

    private XmlCreator() {
        super();
    }

    private XmlCreator(Conf conf) {
        super();
        init(conf);
    }

    public static synchronized XmlCreator getInstance(Conf conf) {
        if (null == creator) {
            creator = new XmlCreator(conf);
        }
        return creator;
    }

    @Override
    public void createFile(TableInfo tableInfo) throws IOException, TemplateException {
        String ftl = "xml.ftl";
        String fileName = tableInfo.getBeanName() + "Mapper.xml";
        String selfPath = conf.getXmlPackage();
        Map<String, Object> root = new HashMap<String, Object>();
        root.put("table", tableInfo);
        root.put("conf", conf);
        Template temp = cfg.getTemplate(ftl);
        String filePath = resourcesbasePath + selfPath;
		if (conf.isPrefix()) {
			filePath = filePath + separator + tableInfo.getPrefix();
		}
		fileName = filePath + separator + fileName;
        createFile(fileName, root, temp);
    }

}
