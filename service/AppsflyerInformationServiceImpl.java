package com.zlinks.service/.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.domain/.AppsflyerInformation;
import com.zlinks.service/.AppsflyerInformationService;
import com.zlinks.mapper/.AppsflyerInformationDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * Copyright (C), 2017-2020, BBG
 * FileName: AccountController
 * Author:   zhangjh
 * Date:     2018-7-9 16:20:13
 * Description:业务
 */
@Service("appsflyerInformationService")
public class AppsflyerInformationServiceImpl extends BaseMybatisDao<AppsflyerInformationDao> implements AppsflyerInformationService {

	@Autowired
	private AppsflyerInformationDao appsflyerInformationDao;

	@Override
	public AppsflyerInformation getById(int id) {
		return appsflyerInformationDao.getById(id);
	}

	@Override
	public int getListCount(AppsflyerInformation entity) {
		return appsflyerInformationDao.getListCount(entity);
	}

	@Override
	public List<AppsflyerInformation> getList(AppsflyerInformation entity) {
		List<AppsflyerInformation> resut = null;
		resut = appsflyerInformationDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return appsflyerInformationDao.getListByMapCount(paramMap);
	}

	@Override
	public List<AppsflyerInformation> getListByMap(Map<String, Object> paramMap) {
		List<AppsflyerInformation> resut = null;
		resut = appsflyerInformationDao.getListByMap(paramMap);
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(AppsflyerInformation entity) {
		return appsflyerInformationDao.update(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return appsflyerInformationDao.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(AppsflyerInformation entity) {
		return appsflyerInformationDao.add(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<AppsflyerInformation> entityList) {
		return appsflyerInformationDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<AppsflyerInformation> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<AppsflyerInformation> getActivedList() {
		List<AppsflyerInformation> resut = null;
		AppsflyerInformation entity = new AppsflyerInformation();
		entity.setIsDeleted(0);
		resut = appsflyerInformationDao.getList(entity);
		return resut;
	}
}