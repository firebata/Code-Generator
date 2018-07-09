package com.zlinks.zlinks-service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.entity.OrdNotify;
import com.zlinks.zlinks-service.OrdNotifyService;
import com.zlinks.zlinks-repsitory.OrdNotifyDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * 类说明:
 *
 * Created by noname on 2018-7-7 15:28:42
 */
@Service("ordNotifyService")
public class OrdNotifyServiceImpl extends BaseMybatisDao<OrdNotifyDao> implements OrdNotifyService {

	@Autowired
	private OrdNotifyDao ordNotifyDao;

	@Override
	public OrdNotify getById(int id) {
		return ordNotifyDao.getById(id);
	}

	@Override
	public int getListCount(OrdNotify entity) {
		return ordNotifyDao.getListCount(entity);
	}

	@Override
	public List<OrdNotify> getList(OrdNotify entity) {
		List<OrdNotify> resut = null;
		resut = ordNotifyDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return ordNotifyDao.getListByMapCount(paramMap);
	}

	@Override
	public List<OrdNotify> getListByMap(Map<String, Object> paramMap) {
		List<OrdNotify> resut = null;
		resut = ordNotifyDao.getListByMap(paramMap);
		return resut;
	}

	@Override
	public int update(OrdNotify entity) {
		return ordNotifyDao.update(entity);
	}

	@Override
	public int deleteById(int id) {
		return ordNotifyDao.deleteById(id);
	}

	@Override
	public int add(OrdNotify entity) {
		return ordNotifyDao.add(entity);
	}

	@Override
	public int addList(List<OrdNotify> entityList) {
		return ordNotifyDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<OrdNotify> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<OrdNotify> getActivedList() {
		List<OrdNotify> resut = null;
		OrdNotify entity = new OrdNotify();
		entity.setIsDeleted(0);
		resut = ordNotifyDao.getList(entity);
		return resut;
	}
}