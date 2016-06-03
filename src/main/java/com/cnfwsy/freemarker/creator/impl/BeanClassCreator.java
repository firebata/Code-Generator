package com.cnfwsy.freemarker.creator.impl;

import com.cnfwsy.freemarker.bean.Conf;
import com.cnfwsy.freemarker.bean.TableInfo;
import com.cnfwsy.freemarker.creator.AbstractFileCreator;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Éú³Ébean
 *
 * @author zhangjh
 */
public class BeanClassCreator extends AbstractFileCreator {
    private static BeanClassCreator creator;

    private BeanClassCreator() {
        super();
    }

    private BeanClassCreator(Conf conf) {
        super();
        init(conf);
    }

    public static synchronized BeanClassCreator getInstance(Conf conf) {
        if (null == creator) {
            creator = new BeanClassCreator(conf);
        }
        return creator;
    }

    @Override
    public void createFile(TableInfo tableInfo, Conf _conf) throws IOException, TemplateException {
        boolean force = Boolean.parseBoolean(conf.getForce());
        String ftl = "bean.ftl";
        String fileName = tableInfo.getBeanName() + ".java";
        String selfPath = conf.getBean_package();

        Map<String, Object> root = new HashMap<String, Object>();
        root.put("table", tableInfo);
        root.put("conf", conf);
        Template temp = cfg.getTemplate(ftl);
        fileName = javaPath + selfPath + separator + fileName;
        createFile(force, fileName, root, temp);


    }


}
