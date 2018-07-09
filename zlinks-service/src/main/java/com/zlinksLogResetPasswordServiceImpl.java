package com.zlinks.zlinks-service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.entity.LogResetPassword;
import com.zlinks.zlinks-service.LogResetPasswordService;
import com.zlinks.zlinks-repsitory.LogResetPasswordDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * 类说明:
 *
 * Created by noname on 2018-7-7 15:28:42
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
	public int update(LogResetPassword entity) {
		return logResetPasswordDao.update(entity);
	}

	@Override
	public int deleteById(int id) {
		return logResetPasswordDao.deleteById(id);
	}

	@Override
	public int add(LogResetPassword entity) {
		return logResetPasswordDao.add(entity);
	}

	@Override
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