package com.cnfwsy.freemarker.factory;

import com.cnfwsy.freemarker.bean.Conf;
import com.cnfwsy.freemarker.creator.FileCreator;
import com.cnfwsy.freemarker.creator.impl.*;

/**
 * 生成代码
 */
public class SimpleFactory {
    private SimpleFactory() {
        super();
    }

    public static FileCreator create(String module, Conf conf) {

        FileCreator creator = null;
        if (module.equals("entity")) {
            creator = EntityClassCreator.getInstance(conf);
        } else if (module.equals("controller")) {
            creator = ControllerClassCreator.getInstance(conf);
        } else if (module.equals("service")) {
            creator = ServiceClassCreator.getInstance(conf);
        } else if (module.equals("serviceTest")) {
            creator = ServiceTestClassCreator.getInstance(conf);
        } else if (module.equals("serviceImpl")) {
            creator = ServiceImplClassCreator.getInstance(conf);
        } else if (module.equals("dao")) {
            creator = DaoClassCreator.getInstance(conf);
        } else if (module.equals("mapperXml")) {
            creator = XmlCreator.getInstance(conf);
        }
        return creator;

    }
}
