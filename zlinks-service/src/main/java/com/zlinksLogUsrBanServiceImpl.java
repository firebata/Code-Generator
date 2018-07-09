package com.zlinks.zlinks-service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.entity.LogUsrBan;
import com.zlinks.zlinks-service.LogUsrBanService;
import com.zlinks.zlinks-repsitory.LogUsrBanDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * 类说明:
 *
 * Created by noname on 2018-7-7 15:28:42
 */
@Service("logUsrBanService")
public class LogUsrBanServiceImpl extends BaseMybatisDao<LogUsrBanDao> implements LogUsrBanService {

	@Autowired
	private LogUsrBanDao logUsrBanDao;

	@Override
	public LogUsrBan getById(int id) {
		return logUsrBanDao.getById(id);
	}

	@Override
	public int getListCount(LogUsrBan entity) {
		return logUsrBanDao.getListCount(entity);
	}

	@Override
	public List<LogUsrBan> getList(LogUsrBan entity) {
		List<LogUsrBan> resut = null;
		resut = logUsrBanDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return logUsrBanDao.getListByMapCount(paramMap);
	}

	@Override
	public List<LogUsrBan> getListByMap(Map<String, Object> paramMap) {
		List<LogUsrBan> resut = null;
		resut = logUsrBanDao.getListByMap(paramMap);
		return resut;
	}

	@Override
	public int update(LogUsrBan entity) {
		return logUsrBanDao.update(entity);
	}

	@Override
	public int deleteById(int id) {
		return logUsrBanDao.deleteById(id);
	}

	@Override
	public int add(LogUsrBan entity) {
		return logUsrBanDao.add(entity);
	}

	@Override
	public int addList(List<LogUsrBan> entityList) {
		return logUsrBanDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<LogUsrBan> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<LogUsrBan> getActivedList() {
		List<LogUsrBan> resut = null;
		LogUsrBan entity = new LogUsrBan();
		entity.setIsDeleted(0);
		resut = logUsrBanDao.getList(entity);
		return resut;
	}
}