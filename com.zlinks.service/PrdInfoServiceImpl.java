package com.zlinks.com.zlinks.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.com.zlinks.domain.PrdInfo;
import com.zlinks.com.zlinks.service.PrdInfoService;
import com.zlinks.com.zlinks.mapper.PrdInfoDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * Copyright (C), 2017-2020, BBG
 * FileName: AccountController
 * Author:   zhangjh
 * Date:     2018-7-9 16:30:11
 * Description:业务
 */
@Service("prdInfoService")
public class PrdInfoServiceImpl extends BaseMybatisDao<PrdInfoDao> implements PrdInfoService {

	@Autowired
	private PrdInfoDao prdInfoDao;

	@Override
	public PrdInfo getById(int id) {
		return prdInfoDao.getById(id);
	}

	@Override
	public int getListCount(PrdInfo entity) {
		return prdInfoDao.getListCount(entity);
	}

	@Override
	public List<PrdInfo> getList(PrdInfo entity) {
		List<PrdInfo> resut = null;
		resut = prdInfoDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return prdInfoDao.getListByMapCount(paramMap);
	}

	@Override
	public List<PrdInfo> getListByMap(Map<String, Object> paramMap) {
		List<PrdInfo> resut = null;
		resut = prdInfoDao.getListByMap(paramMap);
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(PrdInfo entity) {
		return prdInfoDao.update(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return prdInfoDao.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(PrdInfo entity) {
		return prdInfoDao.add(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<PrdInfo> entityList) {
		return prdInfoDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<PrdInfo> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<PrdInfo> getActivedList() {
		List<PrdInfo> resut = null;
		PrdInfo entity = new PrdInfo();
		entity.setIsDeleted(0);
		resut = prdInfoDao.getList(entity);
		return resut;
	}
}