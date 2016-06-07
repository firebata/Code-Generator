package com.cnfwsy.freemarker.creator;

import com.cnfwsy.freemarker.bean.Conf;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Map;

/**
 * 说明:
 * Created by zhangjh on 2016-06-01.
 */
public abstract class AbstractFileCreator implements FileCreator {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    protected static Configuration cfg; // 模版配置对象
    protected static String javabasePath = new StringBuilder().append(System.getProperty("user.dir")).append(separator).append("src").append(separator).append("main").append(separator).append("java").append(separator).toString();
    protected static String resourcesbasePath = new StringBuilder().append(System.getProperty("user.dir")).append(separator).append("src").append(separator).append("main").append(separator).append("resources").append(separator).toString();
    protected static String javaPath;
    protected static Conf conf = null;

    static {
        cfg = new Configuration(Configuration.VERSION_2_3_22);
        cfg.setClassLoaderForTemplateLoading(AbstractFileCreator.class.getClassLoader(), "templates");
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

    }

    protected void createFile(boolean force, String fileName, Map<String, Object> root, Template temp) throws IOException, TemplateException {
        File file = new File(fileName);
        String directoryPath = fileName.substring(0, fileName.lastIndexOf(separator));
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            file.mkdirs();
        }
        logger.info(" file path =" + fileName);
        boolean needCreatFile = false;
        if (!file.exists()) {
            file.createNewFile();
            needCreatFile = true;
        } else {
            if (force) { //
                file.delete();
                file.createNewFile();
                needCreatFile = true;
            }
        }
        if (needCreatFile) {
            OutputStream os = new FileOutputStream(file);
            Writer out = new OutputStreamWriter(os);
            temp.process(root, out);
        }
    }

    public static void init(Conf _conf) {
        if (conf == null) {
            conf = _conf;
            javaPath = javabasePath + conf.getBase_package().replace(".", separator) + separator;
        }
    }
}
