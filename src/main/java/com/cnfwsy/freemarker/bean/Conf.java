package com.cnfwsy.freemarker.bean;

import com.cnfwsy.freemarker.util.DbUtils;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @author zhangjh
 */
public class Conf {
    private static List allModules = Arrays.asList("bean", "controller", "service", "impl", "mapper", "xml");
    String base_package;
    String bean_package;
    String mapper_package;
    String mapperxml_package;
    String service_package;
    String controller_package;
    String tables;
    String needModules;
    List<String> modules;
    String force;

    public String getBase_package() {
        return base_package;
    }

    public void setBase_package(String base_package) {
        this.base_package = base_package;
    }

    public String getBean_package() {
        return bean_package;
    }

    public void setBean_package(String bean_package) {
        this.bean_package = bean_package;
    }

    public String getMapper_package() {
        return mapper_package;
    }

    public void setMapper_package(String mapper_package) {
        this.mapper_package = mapper_package;
    }

    public String getMapperxml_package() {
        return mapperxml_package;
    }

    public void setMapperxml_package(String mapperxml_package) {
        this.mapperxml_package = mapperxml_package;
    }


    public String getService_package() {
        return service_package;
    }

    public void setService_package(String service_package) {
        this.service_package = service_package;
    }

    public String getController_package() {
        return controller_package;
    }

    public void setController_package(String controller_package) {
        this.controller_package = controller_package;
    }

    public String getTables() {
        return tables;
    }

    public void setTables(String tables) {
        this.tables = tables;
    }

    public String getNeedModules() {
        return needModules;
    }

    public void setNeedModules(String needModules) {
        this.needModules = needModules;
    }

    public String getForce() {
        return force;
    }

    public void setForce(String force) {
        this.force = force;
    }

    public List<String> getModules() {
        List<String> modules = new ArrayList<>();
        String needModules = getNeedModules();
        if (null == needModules || needModules.equals("all")) {
            modules = allModules;
        } else {
            modules = Arrays.asList(needModules.split(","));
        }
        return modules;
    }

    public void setModules(List<String> modules) {
        this.modules = modules;
    }

    /**
     * @return
     */
    public Conf getConf() {
        Properties pro = new Properties();
        try {
            pro.load(DbUtils.class.getClassLoader().getResourceAsStream("conf.properties"));
        } catch (IOException e) {
            System.out.println("未找到配置文件！！！");
        }

        String base_package = pro.getProperty("base_package");
        String bean_package = pro.getProperty("bean_package");
        String mapper_package = pro.getProperty("mapper_package");
        String mapperxml_package = pro.getProperty("mapperxml_package");
        String service_package = pro.getProperty("service_package");
        String controller_package = pro.getProperty("controller_package");
        String tables = pro.getProperty("tables");
        String needModules = pro.getProperty("needModules");
        String force = pro.getProperty("force");
        this.setBase_package(base_package);
        this.setBean_package(bean_package);
        this.setMapper_package(mapper_package);
        this.setMapperxml_package(mapperxml_package);
        this.setService_package(service_package);
        this.setController_package(controller_package);
        this.setTables(tables);
        this.setNeedModules(needModules);
        this.setForce(force);

        return this;
    }

    public static void main(String[] args) {
        Conf conf = new Conf();
        String proPath = System.getProperty("user.dir") + "/main/java/";
        URL path1 = conf.getClass().getResource("");

        URL path2 = conf.getClass().getResource("/");

        URL path3 = conf.getClass().getClassLoader().getResource("/");

        URL path4 = ClassLoader.getSystemResource("");

        URL path5 = Thread.currentThread().getContextClassLoader().getResource("");
        System.out.println("proPath==>" + proPath.toString());
        System.out.println("path1==>" + path1.toString());
        System.out.println("path2==>" + path2.toString());
        System.out.println("path3==>" + path3);
        System.out.println("path4==>" + path4.toString());
        System.out.println("path5==>" + path5.toString());
    }
}
