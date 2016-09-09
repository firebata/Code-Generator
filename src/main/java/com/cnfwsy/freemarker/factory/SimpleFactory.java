package com.cnfwsy.freemarker.factory;

import com.cnfwsy.freemarker.bean.Conf;
import com.cnfwsy.freemarker.bean.TableInfo;
import com.cnfwsy.freemarker.creator.FileCreator;
import com.cnfwsy.freemarker.creator.impl.*;

/**
 * 生成代码
 */
public class SimpleFactory {
	private SimpleFactory() {
		super();
	}

	public static FileCreator create(String module, Conf conf, TableInfo tableInfo) {

		FileCreator creator = null;
		if (module.equals(ModuleEnum.Entity.name())) {
			creator = EntityClassCreator.getInstance(conf);
		} else if (module.equals(ModuleEnum.Controller.name())) {
			creator = ControllerClassCreator.getInstance(conf);
		} else if (module.equals(ModuleEnum.Service.name())) {
			creator = ServiceClassCreator.getInstance(conf);
		} else if (module.equals(ModuleEnum.ServiceTest.name())) {
			creator = ServiceTestClassCreator.getInstance(conf);
		} else if (module.equals(ModuleEnum.ServiceImpl.name())) {
			creator = ServiceImplClassCreator.getInstance(conf);
		} else if (module.equals(ModuleEnum.Dao.name())) {
			creator = DaoClassCreator.getInstance(conf);
		} else if (module.equals(ModuleEnum.MapperXML.name())) {
			creator = XmlCreator.getInstance(conf);
		}
		return creator;

	}
}
