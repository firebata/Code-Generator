package com.cnfwsy.freemarker.creator;

import com.cnfwsy.freemarker.bean.Conf;
import com.cnfwsy.freemarker.bean.TableInfo;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 *
 */
public interface FileCreator {
    String separator = File.separator;
    void createFile(TableInfo tableInfo) throws IOException, TemplateException;

}
