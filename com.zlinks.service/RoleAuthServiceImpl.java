package com.zlinks.com.zlinks.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.com.zlinks.domain.RoleAuth;
import com.zlinks.com.zlinks.service.RoleAuthService;
import com.zlinks.com.zlinks.mapper.RoleAuthDao;
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
@Service("roleAuthService")
public class RoleAuthServiceImpl extends BaseMybatisDao<RoleAuthDao> implements RoleAuthService {

	@Autowired
	private RoleAuthDao roleAuthDao;

	@Override
	public RoleAuth getById(int id) {
		return roleAuthDao.getById(id);
	}

	@Override
	public int getListCount(RoleAuth entity) {
		return roleAuthDao.getListCount(entity);
	}

	@Override
	public List<RoleAuth> getList(RoleAuth entity) {
		List<RoleAuth> resut = null;
		resut = roleAuthDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return roleAuthDao.getListByMapCount(paramMap);
	}

	@Override
	public List<RoleAuth> getListByMap(Map<String, Object> paramMap) {
		List<RoleAuth> resut = null;
		resut = roleAuthDao.getListByMap(paramMap);
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(RoleAuth entity) {
		return roleAuthDao.update(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return roleAuthDao.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(RoleAuth entity) {
		return roleAuthDao.add(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<RoleAuth> entityList) {
		return roleAuthDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<RoleAuth> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<RoleAuth> getActivedList() {
		List<RoleAuth> resut = null;
		RoleAuth entity = new RoleAuth();
		entity.setIsDeleted(0);
		resut = roleAuthDao.getList(entity);
		return resut;
	}
}