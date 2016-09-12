package com.cnfwsy.freemarker.creator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cnfwsy.freemarker.bean.TempBeanInfo;
import com.cnfwsy.freemarker.bean.Conf;
import com.cnfwsy.freemarker.bean.TableInfo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * 说明: Created by zhangjh on 2016-06-01.
 */
public abstract class AbstractFileCreator implements FileCreator {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	protected static Configuration cfg; // 模版配置对象
	protected static String javabasePath = new StringBuilder().append(System.getProperty("user.dir")).append(separator)
			.append("src").append(separator).append("main").append(separator).append("java").append(separator)
			.toString();
	protected static String resourcesbasePath = new StringBuilder().append(System.getProperty("user.dir"))
			.append(separator).append("src").append(separator).append("main").append(separator).append("resources")
			.append(separator).toString();
	protected static String javaPath;
	protected static Conf conf = null;

	static {
		cfg = new Configuration(Configuration.VERSION_2_3_22);
		cfg.setClassLoaderForTemplateLoading(AbstractFileCreator.class.getClassLoader(), "templates");
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

	}

	/**
	 * @param filePath
	 *            文件路径
	 * @param root
	 *            data
	 * @param temp
	 *            模板
	 * @param tableInfo2
	 * @throws IOException
	 * @throws TemplateException
	 */
	protected void createFile(Template temp, TableInfo tableInfo) throws IOException, TemplateException {
		boolean force = conf.isForce();
		// String directoryStr = StringUtils.substringBeforeLast(filePath,
		// separator);
		// String directoryStr = FilenameUtils.getFullPath(filePath);
		String directoryStr = getFilePath(tableInfo);
		File directory = new File(directoryStr);
		if (!directory.exists()) {
			directory.mkdirs();
		}

		String filePath = directoryStr + getFileName(tableInfo);
		File file = new File(filePath);
		logger.info(" file path =" + filePath);
		boolean needCreatFile = false;
		if (file.exists()) {
			if (force) { //
				file.delete();
				file.createNewFile();
				needCreatFile = true;
			}
		} else {
			file.createNewFile();
			needCreatFile = true;
		}
		if (needCreatFile) {
			// OutputStream os = new FileOutputStream(file);
			// Writer out = new OutputStreamWriter(os);
			Map<String, Object> dataModel = new HashMap<String, Object>();
			//TempBeanInfo beanInfo = new TempBeanInfo(conf, tableInfo);
			dataModel.put("table", tableInfo);
			dataModel.put("conf", conf);
			temp.process(dataModel, new FileWriter(file));
		}
	}

	private String getFilePath(TableInfo tableInfo) {
		String dirPath = getDirPath();
		dirPath = StringUtils.appendIfMissing(dirPath, separator, separator);

		if (StringUtils.isNoneBlank(tableInfo.getPrefix())) {
			dirPath = dirPath + tableInfo.getPrefix() + separator;
		}
		return dirPath;
	}

	@Override
	public void createFile(TableInfo tableInfo) throws IOException, TemplateException {
		String ftl = getTempletName();
		// String fileName = getFilePath(tableInfo);
		Template temp = cfg.getTemplate(ftl);
		setPackageName(tableInfo);
		createFile(temp, tableInfo);
	}

	public static void init(Conf _conf) {
		if (conf == null) {
			conf = _conf;
			javaPath = javabasePath + conf.getBasePackage().replace(".", separator) + separator;
		}
	}
}
