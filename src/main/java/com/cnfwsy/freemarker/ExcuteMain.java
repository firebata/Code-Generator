package com.cnfwsy.freemarker;
import com.cnfwsy.freemarker.bean.Conf;
import com.cnfwsy.freemarker.bean.TableInfo;
import com.cnfwsy.freemarker.creator.FileCreator;
import com.cnfwsy.freemarker.factory.SimpleFactory;
import com.cnfwsy.freemarker.util.DbUtils;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * 代码生成执行类
 *
 * @author zhangjh
 */
public class ExcuteMain {

    /**
     *
     */
    static Logger logging = LoggerFactory.getLogger(ExcuteMain.class);

    /**
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     * @throws TemplateException
     */
    public void doCreate() throws SQLException, ClassNotFoundException, IOException, TemplateException {
        //基础信息
        Conf conf = new Conf().getConf();
        //表集合
        List<TableInfo> tableInfos = getTableInfos(conf);
        logging.info("tableInfos ==>" + tableInfos);
        //生成文件
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
        Connection connection = DbUtils.getInstance().getConnection();
        DatabaseMetaData metaData = DbUtils.getInstance().getMetaData(connection);
        List<String> tableNames = Arrays.asList(conf.getTables().split(","));
        return DbUtils.getInstance().getAllTables(metaData, tableNames);
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
        new ExcuteMain().doCreate();
    }


}
