package com.cnfwsy.freemarker.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cnfwsy.freemarker.bean.BeanInfo;
import com.cnfwsy.freemarker.bean.ColumnInfo;
import com.cnfwsy.freemarker.bean.TableInfo;

/**
 * 支持单主键的表，建议主键设置在
 *
 * @author zhangjh
 */
public class DbUtils {
	private static DbUtils dbUtils = new DbUtils();

	private DbUtils() {

	}

	public static DbUtils getInstance() {
		return dbUtils;
	}

	static Logger logging = LoggerFactory.getLogger(DbUtils.class);

	/**
	 * 返回一个与特定数据库的连接
	 *
	 * @throws ClassNotFoundException
	 */
	public Connection getConnection() throws ClassNotFoundException {
		Connection connection = null;
		try {
			// 加载属性文件，读取数据库连接配置信息
			Properties pro = new Properties();
			try {
				pro.load(DbUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
			} catch (IOException e) {
				System.out.println("未找到配置文件！！！");
			}
			String driverClass = pro.getProperty("jdbc_driverClassName");
			String url = pro.getProperty("jdbc_url");
			String user = pro.getProperty("jdbc_username");
			String password = pro.getProperty("jdbc_password");
			Class.forName(driverClass);
			//connection = DriverManager.getConnection(url, user, password);
			Properties props =new Properties();
			props.setProperty("user", user);
            props.setProperty("password", password);
            props.setProperty("remarks", "true"); //设置可以获取remarks信息 
            props.setProperty("useInformationSchema", "true");//设置可以获取tables remarks信息
			connection = DriverManager.getConnection(url, props);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * 只做单主键代码的生成
	 *
	 * @param metaData
	 * @param tableName
	 * @return
	 * @throws SQLException
	 */
	public String primaryKeyColumnName(DatabaseMetaData metaData, String tableName) throws SQLException {
		String primaryKeyColumnName = null;
		ResultSet primaryKeyResultSet = metaData.getPrimaryKeys(null, null, tableName);
		while (primaryKeyResultSet.next()) {
			primaryKeyColumnName = primaryKeyResultSet.getString("COLUMN_NAME");
			break;
		}
		if (primaryKeyColumnName == null) {
			primaryKeyColumnName = "id";
		}
		return primaryKeyColumnName;
	}

	/**
	 * 获取需要生成代码的表信息
	 *
	 * @param metaData
	 * @param tableNames
	 * @return
	 * @throws SQLException
	 */
	public List<TableInfo> getAllTables(DatabaseMetaData metaData, List<String> tableNames, boolean underline2Camel)
			throws SQLException {
		List<TableInfo> tables = new ArrayList<TableInfo>();
		ResultSet tableRet = getTableResultSet(metaData);
		while (tableRet.next()) {
			TableInfo tableInfo = new TableInfo();
			String tableName = tableRet.getString("TABLE_NAME");// 表明
			String tableDesc = tableRet.getString("REMARKS");// 表注释
			//String tableDesc = tableRet.getString("TABLE_COMMENT");// 表注释
			System.out.println("===tableName:" + tableName + "-tableDesc:" + tableDesc);
			for (String _tableName : tableNames) {
				if (_tableName.equals("all") || tableName.trim().equals(_tableName)) {
					// 字段处理
					List<ColumnInfo> columns = getAllColumns(metaData, tableName);// 表的所有字段
					Set<String> packages = new HashSet<String>();
					Map<String, Object> pros = columns2Properties(columns, packages, underline2Camel);// 字段转属性
					Map<String, String> properties = (Map<String, String>) pros.get("properties");
					List<BeanInfo> properties2 = (List<BeanInfo>) pros.get("properties2");
					Map<String, String> propertiesAnColumns = (Map<String, String>) pros.get("propertiesAnColumns");
					Map<String, String> insertPropertiesAnColumns = (Map<String, String>) pros
							.get("insertPropertiesAnColumns");
					// 主键处理(主键唯一)
					String primaryKey = primaryKeyColumnName(metaData, tableName);

					String primaryKeyProperty = primaryKey;
					if (underline2Camel) {
						primaryKeyProperty = Underline2CamelUtils.underline2Camel2(primaryKey);
					}
					Map<String, String> primaryKeyMap = new HashMap<String, String>();
					primaryKeyMap.put(primaryKey, primaryKeyProperty);

					// beanClass
					String beanName = getClassName(tableName, underline2Camel);
					tableInfo.setTableName(tableName);
					tableInfo.setTableDesc(tableDesc);
					tableInfo.setColumns(columns);
					tableInfo.setBeanName(beanName);
					tableInfo.setProperties(properties);
					tableInfo.setProperties2(properties2);
					tableInfo.setPrimaryKey(primaryKeyMap);
					tableInfo.setPackages(packages);
					tableInfo.setPropertiesAnColumns(propertiesAnColumns);
					tableInfo.setInsertPropertiesAnColumns(insertPropertiesAnColumns);

					tables.add(tableInfo);
				}
			}

		}

		return tables;
	}

	/**
	 * 表字段转换为属性字段
	 *
	 * @param columns
	 * @return
	 */
	private Map<String, Object> columns2Properties(List<ColumnInfo> columns, Set<String> packages,
			boolean underline2Camel) {
		Map<String, String> properties = new HashMap<String, String>();
		List<BeanInfo> properties2 = new ArrayList<>();
		Map<String, String> propertiesAnColumns = new HashMap<String, String>();
		Map<String, String> insertPropertiesAnColumns = new HashMap<String, String>();

		for (ColumnInfo entry : columns) {
			String columnName = entry.getColumnName();// 字段名
			String columnType = entry.getColumnType();// 字段类型
			String columnRemarks = entry.getColumnRemarks();// 字段类型
			String propertyName = columnName;
			if (underline2Camel) {
				propertyName = Underline2CamelUtils.underline2Camel2(columnName);
			}
			String propertyType = getFieldType(columnType, packages);
			properties.put(propertyName, propertyType);
			BeanInfo beanInfo = new BeanInfo();
			beanInfo.setPropertyName(propertyName);
			beanInfo.setPropertyType(propertyType);
			beanInfo.setPropertyDesc(columnRemarks);
			properties2.add(beanInfo);
			propertiesAnColumns.put(propertyName, columnName);
			if (!excludeInsertProperties(propertyName)) {
				insertPropertiesAnColumns.put(propertyName, columnName);
			}
		}

		Map<String, Object> pros = new HashMap<>();
		pros.put("properties", properties);
		pros.put("properties2", properties2);
		pros.put("propertiesAnColumns", propertiesAnColumns);
		pros.put("insertPropertiesAnColumns", insertPropertiesAnColumns);

		return pros;
	}

	public boolean excludeInsertProperties(String propertyName) {
//		return "id".equals(propertyName) || "createTime".equals(propertyName) || "updateTime".equals(propertyName)
//				|| "delFlag".equals(propertyName);
		return "id".equals(propertyName);
	}

	/**
	 * 获取表所有字段
	 *
	 * @param metaData
	 * @param tableName
	 * @return
	 * @throws SQLException
	 */
	public List<ColumnInfo> getAllColumns(DatabaseMetaData metaData, String tableName) throws SQLException {
		String columnName;
		String columnType;
		String remarks;
		ResultSet colRet = metaData.getColumns(null, "%", tableName, "%");
		List<ColumnInfo> columns = new ArrayList<>();
		while (colRet.next()) {
			columnName = colRet.getString("COLUMN_NAME");
			columnType = colRet.getString("TYPE_NAME");
			int datasize = colRet.getInt("COLUMN_SIZE");
			int digits = colRet.getInt("DECIMAL_DIGITS");
			int nullable = colRet.getInt("NULLABLE");
			remarks = colRet.getString("remarks");
			ColumnInfo info = new ColumnInfo();
			info.setColumnName(columnName);
			info.setColumnType(columnType);
			info.setColumnRemarks(remarks);
			columns.add(info);
			System.out.println(
					remarks + "-" + columnName + "-" + columnType + "-" + datasize + "-" + digits + "-" + nullable);
		}
		return columns;
	}

	/**
	 * 获取TableResultSet
	 *
	 * @return
	 * @throws SQLException
	 */
	public ResultSet getTableResultSet(DatabaseMetaData metaData) throws SQLException {
		// DatabaseMetaData metaData = connection.getMetaData();
		// ResultSet tableRet = metaData.getTables(null, "%", "%", new String[]
		// { "TABLE" });
		String tableName = "%";
		return getTableResultSet(metaData, tableName);

	}

	/**
	 * 获取TableResultSet
	 *
	 * @param tableName
	 * @return
	 * @throws SQLException
	 */
	public ResultSet getTableResultSet(DatabaseMetaData metaData, String tableName) throws SQLException {
		ResultSet tableRet = metaData.getTables(null, "%", tableName, new String[] { "TABLE" });
		return tableRet;
	}

	/**
	 * 获取DatabaseMetaData
	 *
	 * @param connection
	 * @return
	 * @throws SQLException
	 */
	public DatabaseMetaData getMetaData(Connection connection) throws SQLException {
		DatabaseMetaData metaData = connection.getMetaData();
		return metaData;
	}

	/**
	 * 如果table名是t_开头，则去掉t_,其他_变驼峰，第一个字母大写。
	 *
	 * @param tableName
	 * @return
	 */
	public static String getClassName(String tableName, boolean underline2Camel) {
		String res = tableName;
		// 去t_
		if (res.startsWith("t_")) {
			res = res.substring(2);
		}

		if (underline2Camel) {
			// 变驼峰
			res = Underline2CamelUtils.underline2Camel2(res);
		}
		// 首字符大写
		res = res.substring(0, 1).toUpperCase() + res.substring(1);
		return res;
	}

	/**
	 * 设置字段类型 MySql数据类型
	 *
	 * @param columnType
	 *            列类型字符串
	 * @param packages
	 *            封装包信息
	 * @return
	 */
	public static String getFieldType(String columnType, Set<String> packages) {

		columnType = columnType.toLowerCase();
		if (columnType.equals("varchar") || columnType.equals("nvarchar") || columnType.equals("char")
				|| columnType.equals("text") || columnType.equals("mediumtext")) // ||
		// columnType.equals("tinytext")||columnType.equals("mediumtext")||columnType.equals("longtext")
		{
			return "String";
		} else if (columnType.equals("tinyblob") || columnType.equals("blob") || columnType.equals("mediumblob")
				|| columnType.equals("longblob")) {
			return "byte[]";
		} else if (columnType.equals("datetime") || columnType.equals("date") || columnType.equals("timestamp")
				|| columnType.equals("time") || columnType.equals("year")) {
			packages.add("import java.util.Date;");
			return "Date";
		} else if (columnType.equals("bit") || columnType.equals("int") || columnType.equals("tinyint")
				|| columnType.equals("smallint")) // ||columnType.equals("bool")||columnType.equals("mediumint")
		{
			return "Integer";
		} else if (columnType.equals("int unsigned")||columnType.equals("tinyint unsigned")) {
			return "Integer";
		} else if (columnType.equals("bigint unsigned") || columnType.equals("bigint")) {
			packages.add("import java.math.BigInteger;");
			return "BigInteger";
		} else if (columnType.equals("float")||columnType.equals("float unsigned")) {
			packages.add("import java.math.BigDecimal;");
			return "BigDecimal";
		} else if (columnType.equals("double")||columnType.equals("double unsigned")) {
			packages.add("import java.math.BigDecimal;");
			return "BigDecimal";
		} else if (columnType.equals("decimal")||columnType.equals("double unsigned")) {
			packages.add("import java.math.BigDecimal;");
			return "BigDecimal";
		}
		logging.debug("error type is :"+columnType);
		System.out.println("error type is :"+columnType);
		return "ErrorType";
	}

	/**
	 * 设置类标题注释
	 *
	 * @param packages
	 * @param className
	 */
	public static void getTitle(StringBuilder packages, String className) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
		packages.append("\r\n/**\r\n");
		packages.append("*\r\n");
		packages.append("* 标题: " + className + "<br/>\r\n");
		packages.append("* 说明: <br/>\r\n");
		packages.append("*\r\n");
		packages.append("* 作成信息: DATE: " + format.format(new Date()) + " NAME: author\r\n");
		packages.append("*\r\n");
		packages.append("* 修改信息<br/>\r\n");
		packages.append("* 修改日期 修改者 修改ID 修改内容<br/>\r\n");
		packages.append("*\r\n");
		packages.append("*/\r\n");
	}

}
