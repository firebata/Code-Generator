package com.zlinks.samples.creator.impl;

import com.zlinks.samples.ModuleEnum;
import com.zlinks.samples.bean.Conf;
import com.zlinks.samples.bean.Constants;
import com.zlinks.samples.bean.TableInfo;
import com.zlinks.samples.creator.AbstractFileCreator;

/**
 * 创建mapperClass
 *
 * @author zhangjh
 */
public class DaoClassCreator extends AbstractFileCreator {
    private static DaoClassCreator creator;

    private DaoClassCreator() {
        super();
    }

    private DaoClassCreator(Conf conf) {
        super();
        init(conf);
    }

    public static synchronized DaoClassCreator getInstance(Conf conf) {
        if (null == creator) {
            creator = new DaoClassCreator(conf);
        }
        return creator;
    }

    @Override
    public String getFileName(TableInfo tableInfo) {
        return tableInfo.getBeanName() + conf.getDaoName() + Constants.JAVA_SUFFIX;
    }

    @Override
    public String getTempletName() {
        return ModuleEnum.Dao.name() + Constants.TEMPLET_SUFFIX;
    }

    @Override
    public String getDirPath() {
        return javaPath + conf.getDao_dir();
    }

    @Override
    public void setPackageName(TableInfo tableInfo) {
        String daoPackage = conf.getBasePackage() + Constants.PACKAGE_SEPARATOR + conf.getDaoPackage();
        tableInfo.setDaoPackage(daoPackage);
    }

}
