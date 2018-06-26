package com.zlinks.freemarker;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.zlinks.freemarker.bean.Conf;
import com.zlinks.freemarker.creator.FileCreator;
import com.zlinks.freemarker.util.DbUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zlinks.freemarker.bean.TableInfo;
import com.zlinks.freemarker.factory.SimpleFactory;

import freemarker.template.TemplateException;

/**
 * 代码生成执行类
 *
 * @author zhangjh
 */
public class App {

	/**
	 *
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	/**
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws TemplateException
	 */
	public void doCreate() throws SQLException, ClassNotFoundException, IOException, TemplateException {
		// 基础信息
		Conf conf = new Conf().getConf();
		// 表集合
		List<TableInfo> tableInfos = DbUtils.getInstance().getAllTables(conf);
		//LOGGER.info("tableInfos ==>" + tableInfos);
		// 生成文件
		createFile(conf, tableInfos);
	}

	/**
	 * @param conf
	 * @param tableInfos
	 * @throws IOException
	 * @throws TemplateException
	 */
	private void createFile(Conf conf, List<TableInfo> tableInfos) throws IOException, TemplateException {
		List<String> modules = conf.getModules();
		FileCreator creator = null;
		for (TableInfo tableInfo : tableInfos) {
			LOGGER.info("tableInfo ==>" + tableInfo);
			for (String module : modules) {
				creator = SimpleFactory.create(module, conf, tableInfo);
				creator.createFile(tableInfo);
			}
		}
	}

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws TemplateException
	 * @throws IOException
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException, TemplateException, IOException {
		new App().doCreate();
	}

}
