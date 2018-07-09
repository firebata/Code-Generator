package com.zlinks.com.zlinks.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.com.zlinks.domain.LogOrdNotify;
import com.zlinks.com.zlinks.service.LogOrdNotifyService;
import com.zlinks.com.zlinks.mapper.LogOrdNotifyDao;
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
@Service("logOrdNotifyService")
public class LogOrdNotifyServiceImpl extends BaseMybatisDao<LogOrdNotifyDao> implements LogOrdNotifyService {

	@Autowired
	private LogOrdNotifyDao logOrdNotifyDao;

	@Override
	public LogOrdNotify getById(int id) {
		return logOrdNotifyDao.getById(id);
	}

	@Override
	public int getListCount(LogOrdNotify entity) {
		return logOrdNotifyDao.getListCount(entity);
	}

	@Override
	public List<LogOrdNotify> getList(LogOrdNotify entity) {
		List<LogOrdNotify> resut = null;
		resut = logOrdNotifyDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return logOrdNotifyDao.getListByMapCount(paramMap);
	}

	@Override
	public List<LogOrdNotify> getListByMap(Map<String, Object> paramMap) {
		List<LogOrdNotify> resut = null;
		resut = logOrdNotifyDao.getListByMap(paramMap);
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(LogOrdNotify entity) {
		return logOrdNotifyDao.update(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return logOrdNotifyDao.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(LogOrdNotify entity) {
		return logOrdNotifyDao.add(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<LogOrdNotify> entityList) {
		return logOrdNotifyDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<LogOrdNotify> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<LogOrdNotify> getActivedList() {
		List<LogOrdNotify> resut = null;
		LogOrdNotify entity = new LogOrdNotify();
		entity.setIsDeleted(0);
		resut = logOrdNotifyDao.getList(entity);
		return resut;
	}
}