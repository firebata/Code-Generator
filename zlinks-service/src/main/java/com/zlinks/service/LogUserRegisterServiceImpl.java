package com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/domain/.LogUserRegister;
import com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.LogUserRegisterService;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/mapper/.LogUserRegisterDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * Copyright (C), 2017-2020, BBG
 * FileName: AccountController
 * Author:   zhangjh
 * Date:     2018-7-9 16:02:01
 * Description:业务
 */
@Service("logUserRegisterService")
public class LogUserRegisterServiceImpl extends BaseMybatisDao<LogUserRegisterDao> implements LogUserRegisterService {

	@Autowired
	private LogUserRegisterDao logUserRegisterDao;

	@Override
	public LogUserRegister getById(int id) {
		return logUserRegisterDao.getById(id);
	}

	@Override
	public int getListCount(LogUserRegister entity) {
		return logUserRegisterDao.getListCount(entity);
	}

	@Override
	public List<LogUserRegister> getList(LogUserRegister entity) {
		List<LogUserRegister> resut = null;
		resut = logUserRegisterDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return logUserRegisterDao.getListByMapCount(paramMap);
	}

	@Override
	public List<LogUserRegister> getListByMap(Map<String, Object> paramMap) {
		List<LogUserRegister> resut = null;
		resut = logUserRegisterDao.getListByMap(paramMap);
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(LogUserRegister entity) {
		return logUserRegisterDao.update(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return logUserRegisterDao.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(LogUserRegister entity) {
		return logUserRegisterDao.add(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<LogUserRegister> entityList) {
		return logUserRegisterDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<LogUserRegister> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<LogUserRegister> getActivedList() {
		List<LogUserRegister> resut = null;
		LogUserRegister entity = new LogUserRegister();
		entity.setIsDeleted(0);
		resut = logUserRegisterDao.getList(entity);
		return resut;
	}
}