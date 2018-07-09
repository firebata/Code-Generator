package com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/domain/.LogOrdNotify;
import com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.LogOrdNotifyService;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/mapper/.LogOrdNotifyDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * 类说明:
 *
 * Created by noname on 2018-7-7 15:34:58
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
	public int update(LogOrdNotify entity) {
		return logOrdNotifyDao.update(entity);
	}

	@Override
	public int deleteById(int id) {
		return logOrdNotifyDao.deleteById(id);
	}

	@Override
	public int add(LogOrdNotify entity) {
		return logOrdNotifyDao.add(entity);
	}

	@Override
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