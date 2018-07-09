package com.zlinks.service/.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.domain/.LogResetPassword;
import com.zlinks.service/.LogResetPasswordService;
import com.zlinks.mapper/.LogResetPasswordDao;
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
@Service("logResetPasswordService")
public class LogResetPasswordServiceImpl extends BaseMybatisDao<LogResetPasswordDao> implements LogResetPasswordService {

	@Autowired
	private LogResetPasswordDao logResetPasswordDao;

	@Override
	public LogResetPassword getById(int id) {
		return logResetPasswordDao.getById(id);
	}

	@Override
	public int getListCount(LogResetPassword entity) {
		return logResetPasswordDao.getListCount(entity);
	}

	@Override
	public List<LogResetPassword> getList(LogResetPassword entity) {
		List<LogResetPassword> resut = null;
		resut = logResetPasswordDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return logResetPasswordDao.getListByMapCount(paramMap);
	}

	@Override
	public List<LogResetPassword> getListByMap(Map<String, Object> paramMap) {
		List<LogResetPassword> resut = null;
		resut = logResetPasswordDao.getListByMap(paramMap);
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(LogResetPassword entity) {
		return logResetPasswordDao.update(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return logResetPasswordDao.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(LogResetPassword entity) {
		return logResetPasswordDao.add(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<LogResetPassword> entityList) {
		return logResetPasswordDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<LogResetPassword> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<LogResetPassword> getActivedList() {
		List<LogResetPassword> resut = null;
		LogResetPassword entity = new LogResetPassword();
		entity.setIsDeleted(0);
		resut = logResetPasswordDao.getList(entity);
		return resut;
	}
}