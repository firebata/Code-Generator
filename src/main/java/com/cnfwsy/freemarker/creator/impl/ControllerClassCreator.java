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
 * ���ɿ��Ʋ�
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
    public void createFile(TableInfo tableInfo, Conf conf) throws IOException, TemplateException {
        boolean force = Boolean.parseBoolean(conf.getForce());
        String ftl = "controller.ftl";
        String fileName = tableInfo.getBeanName() + "Controller.java";
        String selfPath = conf.getController_package();

        Map<String, Object> root = new HashMap<String, Object>();
        root.put("table", tableInfo);
        root.put("conf", conf);
        Template temp = cfg.getTemplate(ftl);
        fileName = javaPath + selfPath + separator + fileName;
        createFile(force, fileName, root, temp);
    }


}
