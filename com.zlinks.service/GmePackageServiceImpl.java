package com.zlinks.com.zlinks.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.com.zlinks.domain.GmePackage;
import com.zlinks.com.zlinks.service.GmePackageService;
import com.zlinks.com.zlinks.mapper.GmePackageDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * Copyright (C), 2017-2020, BBG
 * FileName: AccountController
 * Author:   zhangjh
 * Date:     2018-7-9 16:30:11
 * Description:业务
 */
@Service("gmePackageService")
public class GmePackageServiceImpl extends BaseMybatisDao<GmePackageDao> implements GmePackageService {

	@Autowired
	private GmePackageDao gmePackageDao;

	@Override
	public GmePackage getById(int id) {
		return gmePackageDao.getById(id);
	}

	@Override
	public int getListCount(GmePackage entity) {
		return gmePackageDao.getListCount(entity);
	}

	@Override
	public List<GmePackage> getList(GmePackage entity) {
		List<GmePackage> resut = null;
		resut = gmePackageDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return gmePackageDao.getListByMapCount(paramMap);
	}

	@Override
	public List<GmePackage> getListByMap(Map<String, Object> paramMap) {
		List<GmePackage> resut = null;
		resut = gmePackageDao.getListByMap(paramMap);
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(GmePackage entity) {
		return gmePackageDao.update(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return gmePackageDao.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(GmePackage entity) {
		return gmePackageDao.add(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<GmePackage> entityList) {
		return gmePackageDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<GmePackage> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<GmePackage> getActivedList() {
		List<GmePackage> resut = null;
		GmePackage entity = new GmePackage();
		entity.setIsDeleted(0);
		resut = gmePackageDao.getList(entity);
		return resut;
	}
}