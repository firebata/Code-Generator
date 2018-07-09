package com.zlinks.com.zlinks.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.com.zlinks.domain.GmeVersion;
import com.zlinks.com.zlinks.service.GmeVersionService;
import com.zlinks.com.zlinks.mapper.GmeVersionDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * Copyright (C), 2017-2020, BBG
 * FileName: AccountController
 * Author:   zhangjh
 * Date:     2018-7-9 18:51:43
 * Description:业务
 */
@Service("gmeVersionService")
public class GmeVersionServiceImpl extends BaseMybatisDao<GmeVersionDao> implements GmeVersionService {

	@Autowired
	private GmeVersionDao gmeVersionDao;

	@Override
	public GmeVersion getById(int id) {
		return gmeVersionDao.getById(id);
	}

	@Override
	public int getListCount(GmeVersion entity) {
		return gmeVersionDao.getListCount(entity);
	}

	@Override
	public List<GmeVersion> getList(GmeVersion entity) {
		List<GmeVersion> resut = null;
		resut = gmeVersionDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return gmeVersionDao.getListByMapCount(paramMap);
	}

	@Override
	public List<GmeVersion> getListByMap(Map<String, Object> paramMap) {
		List<GmeVersion> resut = null;
		resut = gmeVersionDao.getListByMap(paramMap);
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(GmeVersion entity) {
		return gmeVersionDao.update(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return gmeVersionDao.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(GmeVersion entity) {
		return gmeVersionDao.add(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<GmeVersion> entityList) {
		return gmeVersionDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<GmeVersion> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<GmeVersion> getActivedList() {
		List<GmeVersion> resut = null;
		GmeVersion entity = new GmeVersion();
		entity.setIsDeleted(0);
		resut = gmeVersionDao.getList(entity);
		return resut;
	}
}