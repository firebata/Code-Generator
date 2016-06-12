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
 * 创建mapperClass
 *
 * @author zhangjh
 */
public class MapperClassCreator extends AbstractFileCreator {
    private static MapperClassCreator creator;

    private MapperClassCreator() {
        super();
    }

    private MapperClassCreator(Conf conf) {
        super();
        init(conf);
    }

    public static synchronized MapperClassCreator getInstance(Conf conf) {
        if (null == creator) {
            creator = new MapperClassCreator(conf);
        }
        return creator;
    }

    @Override
    public void createFile(TableInfo tableInfo) throws IOException, TemplateException {

        String ftl = "mapper.ftl";
        String fileName = tableInfo.getBeanName() + "Mapper.java";
        String selfPath = conf.getMapper_package();
        String prefixName = tableInfo.getBeanName().substring(0, 3).toLowerCase();
        Map<String, Object> root = new HashMap<String, Object>();
        root.put("table", tableInfo);
        root.put("conf", conf);
        if (conf.isPrefix()) {//有表名类别
            root.put("prefixName", prefixName);
        }
        Template temp = cfg.getTemplate(ftl);
        fileName = javaPath + selfPath + separator + prefixName + separator + fileName;
        createFile(fileName, root, temp);
    }


}
