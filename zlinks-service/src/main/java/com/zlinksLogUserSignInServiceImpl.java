package com.zlinks.zlinks-service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.entity.LogUserSignIn;
import com.zlinks.zlinks-service.LogUserSignInService;
import com.zlinks.zlinks-repsitory.LogUserSignInDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * 类说明:
 *
 * Created by noname on 2018-7-7 15:28:42
 */
@Service("logUserSignInService")
public class LogUserSignInServiceImpl extends BaseMybatisDao<LogUserSignInDao> implements LogUserSignInService {

	@Autowired
	private LogUserSignInDao logUserSignInDao;

	@Override
	public LogUserSignIn getById(int id) {
		return logUserSignInDao.getById(id);
	}

	@Override
	public int getListCount(LogUserSignIn entity) {
		return logUserSignInDao.getListCount(entity);
	}

	@Override
	public List<LogUserSignIn> getList(LogUserSignIn entity) {
		List<LogUserSignIn> resut = null;
		resut = logUserSignInDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return logUserSignInDao.getListByMapCount(paramMap);
	}

	@Override
	public List<LogUserSignIn> getListByMap(Map<String, Object> paramMap) {
		List<LogUserSignIn> resut = null;
		resut = logUserSignInDao.getListByMap(paramMap);
		return resut;
	}

	@Override
	public int update(LogUserSignIn entity) {
		return logUserSignInDao.update(entity);
	}

	@Override
	public int deleteById(int id) {
		return logUserSignInDao.deleteById(id);
	}

	@Override
	public int add(LogUserSignIn entity) {
		return logUserSignInDao.add(entity);
	}

	@Override
	public int addList(List<LogUserSignIn> entityList) {
		return logUserSignInDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<LogUserSignIn> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<LogUserSignIn> getActivedList() {
		List<LogUserSignIn> resut = null;
		LogUserSignIn entity = new LogUserSignIn();
		entity.setIsDeleted(0);
		resut = logUserSignInDao.getList(entity);
		return resut;
	}
}