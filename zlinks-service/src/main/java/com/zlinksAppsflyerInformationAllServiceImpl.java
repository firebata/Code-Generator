package com.zlinks.zlinks-service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.entity.AppsflyerInformationAll;
import com.zlinks.zlinks-service.AppsflyerInformationAllService;
import com.zlinks.zlinks-repsitory.AppsflyerInformationAllDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * 类说明:
 *
 * Created by noname on 2018-7-7 15:28:42
 */
@Service("appsflyerInformationAllService")
public class AppsflyerInformationAllServiceImpl extends BaseMybatisDao<AppsflyerInformationAllDao> implements AppsflyerInformationAllService {

	@Autowired
	private AppsflyerInformationAllDao appsflyerInformationAllDao;

	@Override
	public AppsflyerInformationAll getById(int id) {
		return appsflyerInformationAllDao.getById(id);
	}

	@Override
	public int getListCount(AppsflyerInformationAll entity) {
		return appsflyerInformationAllDao.getListCount(entity);
	}

	@Override
	public List<AppsflyerInformationAll> getList(AppsflyerInformationAll entity) {
		List<AppsflyerInformationAll> resut = null;
		resut = appsflyerInformationAllDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return appsflyerInformationAllDao.getListByMapCount(paramMap);
	}

	@Override
	public List<AppsflyerInformationAll> getListByMap(Map<String, Object> paramMap) {
		List<AppsflyerInformationAll> resut = null;
		resut = appsflyerInformationAllDao.getListByMap(paramMap);
		return resut;
	}

	@Override
	public int update(AppsflyerInformationAll entity) {
		return appsflyerInformationAllDao.update(entity);
	}

	@Override
	public int deleteById(int id) {
		return appsflyerInformationAllDao.deleteById(id);
	}

	@Override
	public int add(AppsflyerInformationAll entity) {
		return appsflyerInformationAllDao.add(entity);
	}

	@Override
	public int addList(List<AppsflyerInformationAll> entityList) {
		return appsflyerInformationAllDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<AppsflyerInformationAll> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<AppsflyerInformationAll> getActivedList() {
		List<AppsflyerInformationAll> resut = null;
		AppsflyerInformationAll entity = new AppsflyerInformationAll();
		entity.setIsDeleted(0);
		resut = appsflyerInformationAllDao.getList(entity);
		return resut;
	}
}