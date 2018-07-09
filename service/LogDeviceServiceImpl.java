package com.zlinks.service/.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.domain/.LogDevice;
import com.zlinks.service/.LogDeviceService;
import com.zlinks.mapper/.LogDeviceDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * Copyright (C), 2017-2020, BBG
 * FileName: AccountController
 * Author:   zhangjh
 * Date:     2018-7-9 16:20:14
 * Description:业务
 */
@Service("logDeviceService")
public class LogDeviceServiceImpl extends BaseMybatisDao<LogDeviceDao> implements LogDeviceService {

	@Autowired
	private LogDeviceDao logDeviceDao;

	@Override
	public LogDevice getById(int id) {
		return logDeviceDao.getById(id);
	}

	@Override
	public int getListCount(LogDevice entity) {
		return logDeviceDao.getListCount(entity);
	}

	@Override
	public List<LogDevice> getList(LogDevice entity) {
		List<LogDevice> resut = null;
		resut = logDeviceDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return logDeviceDao.getListByMapCount(paramMap);
	}

	@Override
	public List<LogDevice> getListByMap(Map<String, Object> paramMap) {
		List<LogDevice> resut = null;
		resut = logDeviceDao.getListByMap(paramMap);
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(LogDevice entity) {
		return logDeviceDao.update(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return logDeviceDao.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(LogDevice entity) {
		return logDeviceDao.add(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<LogDevice> entityList) {
		return logDeviceDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<LogDevice> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<LogDevice> getActivedList() {
		List<LogDevice> resut = null;
		LogDevice entity = new LogDevice();
		entity.setIsDeleted(0);
		resut = logDeviceDao.getList(entity);
		return resut;
	}
}