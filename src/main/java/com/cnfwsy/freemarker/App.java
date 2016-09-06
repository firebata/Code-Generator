package com.cnfwsy.freemarker;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cnfwsy.freemarker.bean.Conf;
import com.cnfwsy.freemarker.bean.TableInfo;
import com.cnfwsy.freemarker.creator.FileCreator;
import com.cnfwsy.freemarker.factory.SimpleFactory;
import com.cnfwsy.freemarker.util.DbUtils;

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

	private static List<TableInfo> tableInfos = null;

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
		// List<TableInfo> tableInfos = getTableInfos(conf);
		getTableInfos(conf);
		LOGGER.info("tableInfos ==>" + tableInfos);
		// 生成文件
		createFile(conf, tableInfos);
	}

	/**
	 * 需要生成代码的表
	 *
	 * @param conf
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private List<TableInfo> getTableInfos(Conf conf) throws ClassNotFoundException, SQLException {
		if (tableInfos != null) {
			return tableInfos;
		}
		boolean underline2Camel = conf.isUnderline2Camel();
		Connection connection = DbUtils.getInstance().getConnection();
		DatabaseMetaData metaData = DbUtils.getInstance().getMetaData(connection);
		List<String> tableNames = Arrays.asList(conf.getTables().split(","));
		tableInfos = DbUtils.getInstance().getAllTables(metaData, tableNames, underline2Camel, conf.getEntitySuffix(),
				conf.isPrefix());
		return tableInfos;
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
				creator = SimpleFactory.create(module, conf);
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
