package com.zlinks.com.zlinks.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.com.zlinks.domain.GmeNotifyUrl;
import com.zlinks.com.zlinks.service.GmeNotifyUrlService;
import com.zlinks.com.zlinks.mapper.GmeNotifyUrlDao;
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
@Service("gmeNotifyUrlService")
public class GmeNotifyUrlServiceImpl extends BaseMybatisDao<GmeNotifyUrlDao> implements GmeNotifyUrlService {

	@Autowired
	private GmeNotifyUrlDao gmeNotifyUrlDao;

	@Override
	public GmeNotifyUrl getById(int id) {
		return gmeNotifyUrlDao.getById(id);
	}

	@Override
	public int getListCount(GmeNotifyUrl entity) {
		return gmeNotifyUrlDao.getListCount(entity);
	}

	@Override
	public List<GmeNotifyUrl> getList(GmeNotifyUrl entity) {
		List<GmeNotifyUrl> resut = null;
		resut = gmeNotifyUrlDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return gmeNotifyUrlDao.getListByMapCount(paramMap);
	}

	@Override
	public List<GmeNotifyUrl> getListByMap(Map<String, Object> paramMap) {
		List<GmeNotifyUrl> resut = null;
		resut = gmeNotifyUrlDao.getListByMap(paramMap);
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(GmeNotifyUrl entity) {
		return gmeNotifyUrlDao.update(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return gmeNotifyUrlDao.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(GmeNotifyUrl entity) {
		return gmeNotifyUrlDao.add(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<GmeNotifyUrl> entityList) {
		return gmeNotifyUrlDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<GmeNotifyUrl> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<GmeNotifyUrl> getActivedList() {
		List<GmeNotifyUrl> resut = null;
		GmeNotifyUrl entity = new GmeNotifyUrl();
		entity.setIsDeleted(0);
		resut = gmeNotifyUrlDao.getList(entity);
		return resut;
	}
}