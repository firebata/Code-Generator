package com.zlinks.zlinks-service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.entity.GmeVersion;
import com.zlinks.zlinks-service.GmeVersionService;
import com.zlinks.zlinks-repsitory.GmeVersionDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * 类说明:
 *
 * Created by noname on 2018-7-7 15:28:42
 */
@Service("gmeVersionService")
public class GmeVersionServiceImpl extends BaseMybatisDao<GmeVersionDao> implements GmeVersionService {

	@Autowired
	private GmeVersionDao gmeVersionDao;

	@Override
	public GmeVersion getById(int id) {
		return gmeVersionDao.getById(id);
	}

	@Override
	public int getListCount(GmeVersion entity) {
		return gmeVersionDao.getListCount(entity);
	}

	@Override
	public List<GmeVersion> getList(GmeVersion entity) {
		List<GmeVersion> resut = null;
		resut = gmeVersionDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return gmeVersionDao.getListByMapCount(paramMap);
	}

	@Override
	public List<GmeVersion> getListByMap(Map<String, Object> paramMap) {
		List<GmeVersion> resut = null;
		resut = gmeVersionDao.getListByMap(paramMap);
		return resut;
	}

	@Override
	public int update(GmeVersion entity) {
		return gmeVersionDao.update(entity);
	}

	@Override
	public int deleteById(int id) {
		return gmeVersionDao.deleteById(id);
	}

	@Override
	public int add(GmeVersion entity) {
		return gmeVersionDao.add(entity);
	}

	@Override
	public int addList(List<GmeVersion> entityList) {
		return gmeVersionDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<GmeVersion> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<GmeVersion> getActivedList() {
		List<GmeVersion> resut = null;
		GmeVersion entity = new GmeVersion();
		entity.setIsDeleted(0);
		resut = gmeVersionDao.getList(entity);
		return resut;
	}
}