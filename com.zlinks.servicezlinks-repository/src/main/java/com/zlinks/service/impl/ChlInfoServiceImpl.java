package com.zlinks.com.zlinks.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.com.zlinks.domain.ChlInfo;
import com.zlinks.com.zlinks.service.ChlInfoService;
import com.zlinks.com.zlinks.mapper.ChlInfoDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * Copyright (C), 2017-2020, BBG
 * FileName: AccountController
 * Author:   zhangjh
 * Date:     2018-7-9 18:51:42
 * Description:业务
 */
@Service("chlInfoService")
public class ChlInfoServiceImpl extends BaseMybatisDao<ChlInfoDao> implements ChlInfoService {

	@Autowired
	private ChlInfoDao chlInfoDao;

	@Override
	public ChlInfo getById(int id) {
		return chlInfoDao.getById(id);
	}

	@Override
	public int getListCount(ChlInfo entity) {
		return chlInfoDao.getListCount(entity);
	}

	@Override
	public List<ChlInfo> getList(ChlInfo entity) {
		List<ChlInfo> resut = null;
		resut = chlInfoDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return chlInfoDao.getListByMapCount(paramMap);
	}

	@Override
	public List<ChlInfo> getListByMap(Map<String, Object> paramMap) {
		List<ChlInfo> resut = null;
		resut = chlInfoDao.getListByMap(paramMap);
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(ChlInfo entity) {
		return chlInfoDao.update(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return chlInfoDao.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(ChlInfo entity) {
		return chlInfoDao.add(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<ChlInfo> entityList) {
		return chlInfoDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<ChlInfo> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<ChlInfo> getActivedList() {
		List<ChlInfo> resut = null;
		ChlInfo entity = new ChlInfo();
		entity.setIsDeleted(0);
		resut = chlInfoDao.getList(entity);
		return resut;
	}
}