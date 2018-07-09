package com.zlinks.zlinks-service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.entity.LogUserBan;
import com.zlinks.zlinks-service.LogUserBanService;
import com.zlinks.zlinks-repsitory.LogUserBanDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * 类说明:
 *
 * Created by noname on 2018-7-7 15:28:42
 */
@Service("logUserBanService")
public class LogUserBanServiceImpl extends BaseMybatisDao<LogUserBanDao> implements LogUserBanService {

	@Autowired
	private LogUserBanDao logUserBanDao;

	@Override
	public LogUserBan getById(int id) {
		return logUserBanDao.getById(id);
	}

	@Override
	public int getListCount(LogUserBan entity) {
		return logUserBanDao.getListCount(entity);
	}

	@Override
	public List<LogUserBan> getList(LogUserBan entity) {
		List<LogUserBan> resut = null;
		resut = logUserBanDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return logUserBanDao.getListByMapCount(paramMap);
	}

	@Override
	public List<LogUserBan> getListByMap(Map<String, Object> paramMap) {
		List<LogUserBan> resut = null;
		resut = logUserBanDao.getListByMap(paramMap);
		return resut;
	}

	@Override
	public int update(LogUserBan entity) {
		return logUserBanDao.update(entity);
	}

	@Override
	public int deleteById(int id) {
		return logUserBanDao.deleteById(id);
	}

	@Override
	public int add(LogUserBan entity) {
		return logUserBanDao.add(entity);
	}

	@Override
	public int addList(List<LogUserBan> entityList) {
		return logUserBanDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<LogUserBan> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<LogUserBan> getActivedList() {
		List<LogUserBan> resut = null;
		LogUserBan entity = new LogUserBan();
		entity.setIsDeleted(0);
		resut = logUserBanDao.getList(entity);
		return resut;
	}
}