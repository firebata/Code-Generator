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
public class MapperXmlCreator extends AbstractFileCreator {
    private static MapperXmlCreator creator;

    private MapperXmlCreator() {
        super();
    }

    private MapperXmlCreator(Conf conf) {
        super();
        init(conf);
    }

    public static synchronized MapperXmlCreator getInstance(Conf conf) {
        if (null == creator) {
            creator = new MapperXmlCreator(conf);
        }
        return creator;
    }

    @Override
    public void createFile(TableInfo tableInfo) throws IOException, TemplateException {
        String ftl = "xml.ftl";
        String fileName = tableInfo.getBeanName() + "Mapper.xml";
        String selfPath = conf.getMapperxml_package();
        String prefixName = tableInfo.getBeanName().substring(0, 3).toLowerCase();
        Map<String, Object> root = new HashMap<String, Object>();
        root.put("table", tableInfo);
        root.put("conf", conf);
        if (conf.isPrefix()) {//有表名类别
            root.put("prefixName", prefixName);
        }
        Template temp = cfg.getTemplate(ftl);
        fileName = resourcesbasePath + selfPath + separator + prefixName + separator + fileName;
        createFile(fileName, root, temp);
    }

}
