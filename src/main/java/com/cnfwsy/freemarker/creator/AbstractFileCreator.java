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

    /**
     * @param filePath 文件路径
     * @param root     data
     * @param temp     模板
     * @throws IOException
     * @throws TemplateException
     */
    protected void createFile(String filePath, Map<String, Object> root, Template temp) throws IOException, TemplateException {
        boolean force = conf.isForce();
//        boolean prefix = conf.isPrefix();
        String fileName = filePath.substring(filePath.lastIndexOf(separator) + 1);
        String subPath;
//        if (prefix) {
//            String sub = filePath.substring(filePath.lastIndexOf(separator) + 1, filePath.lastIndexOf(separator) + 4).toLowerCase();//分模块存放
//            String directoryPath = filePath.substring(0, filePath.lastIndexOf(separator));
//            subPath = directoryPath + separator + sub;
//        } else {
//            File file = new File(filePath);
//            subPath = filePath.substring(0, filePath.lastIndexOf(separator));
//            File directory = new File(subPath);
//            if (!directory.exists()) {
//                file.mkdirs();
//            }
//        }


        subPath = filePath.substring(0, filePath.lastIndexOf(separator));
        File directory = new File(subPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }


        File file = new File(filePath);
        logger.info(" file path =" + filePath);
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
