package com.zlinks.service/.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.domain/.GmeInfo;
import com.zlinks.service/.GmeInfoService;
import com.zlinks.mapper/.GmeInfoDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * Copyright (C), 2017-2020, BBG
 * FileName: AccountController
 * Author:   zhangjh
 * Date:     2018-7-9 16:20:13
 * Description:业务
 */
@Service("gmeInfoService")
public class GmeInfoServiceImpl extends BaseMybatisDao<GmeInfoDao> implements GmeInfoService {

	@Autowired
	private GmeInfoDao gmeInfoDao;

	@Override
	public GmeInfo getById(int id) {
		return gmeInfoDao.getById(id);
	}

	@Override
	public int getListCount(GmeInfo entity) {
		return gmeInfoDao.getListCount(entity);
	}

	@Override
	public List<GmeInfo> getList(GmeInfo entity) {
		List<GmeInfo> resut = null;
		resut = gmeInfoDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return gmeInfoDao.getListByMapCount(paramMap);
	}

	@Override
	public List<GmeInfo> getListByMap(Map<String, Object> paramMap) {
		List<GmeInfo> resut = null;
		resut = gmeInfoDao.getListByMap(paramMap);
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(GmeInfo entity) {
		return gmeInfoDao.update(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return gmeInfoDao.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(GmeInfo entity) {
		return gmeInfoDao.add(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<GmeInfo> entityList) {
		return gmeInfoDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<GmeInfo> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<GmeInfo> getActivedList() {
		List<GmeInfo> resut = null;
		GmeInfo entity = new GmeInfo();
		entity.setIsDeleted(0);
		resut = gmeInfoDao.getList(entity);
		return resut;
	}
}