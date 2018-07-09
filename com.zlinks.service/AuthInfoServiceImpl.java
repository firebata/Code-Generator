package com.zlinks.com.zlinks.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.com.zlinks.domain.AuthInfo;
import com.zlinks.com.zlinks.service.AuthInfoService;
import com.zlinks.com.zlinks.mapper.AuthInfoDao;
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
@Service("authInfoService")
public class AuthInfoServiceImpl extends BaseMybatisDao<AuthInfoDao> implements AuthInfoService {

	@Autowired
	private AuthInfoDao authInfoDao;

	@Override
	public AuthInfo getById(int id) {
		return authInfoDao.getById(id);
	}

	@Override
	public int getListCount(AuthInfo entity) {
		return authInfoDao.getListCount(entity);
	}

	@Override
	public List<AuthInfo> getList(AuthInfo entity) {
		List<AuthInfo> resut = null;
		resut = authInfoDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return authInfoDao.getListByMapCount(paramMap);
	}

	@Override
	public List<AuthInfo> getListByMap(Map<String, Object> paramMap) {
		List<AuthInfo> resut = null;
		resut = authInfoDao.getListByMap(paramMap);
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(AuthInfo entity) {
		return authInfoDao.update(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return authInfoDao.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(AuthInfo entity) {
		return authInfoDao.add(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<AuthInfo> entityList) {
		return authInfoDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<AuthInfo> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<AuthInfo> getActivedList() {
		List<AuthInfo> resut = null;
		AuthInfo entity = new AuthInfo();
		entity.setIsDeleted(0);
		resut = authInfoDao.getList(entity);
		return resut;
	}
}