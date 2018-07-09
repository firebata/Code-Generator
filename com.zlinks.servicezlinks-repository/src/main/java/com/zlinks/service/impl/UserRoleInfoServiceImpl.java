package com.zlinks.com.zlinks.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.com.zlinks.domain.UserRoleInfo;
import com.zlinks.com.zlinks.service.UserRoleInfoService;
import com.zlinks.com.zlinks.mapper.UserRoleInfoDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * Copyright (C), 2017-2020, BBG
 * FileName: AccountController
 * Author:   zhangjh
 * Date:     2018-7-9 18:51:43
 * Description:业务
 */
@Service("userRoleInfoService")
public class UserRoleInfoServiceImpl extends BaseMybatisDao<UserRoleInfoDao> implements UserRoleInfoService {

	@Autowired
	private UserRoleInfoDao userRoleInfoDao;

	@Override
	public UserRoleInfo getById(int id) {
		return userRoleInfoDao.getById(id);
	}

	@Override
	public int getListCount(UserRoleInfo entity) {
		return userRoleInfoDao.getListCount(entity);
	}

	@Override
	public List<UserRoleInfo> getList(UserRoleInfo entity) {
		List<UserRoleInfo> resut = null;
		resut = userRoleInfoDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return userRoleInfoDao.getListByMapCount(paramMap);
	}

	@Override
	public List<UserRoleInfo> getListByMap(Map<String, Object> paramMap) {
		List<UserRoleInfo> resut = null;
		resut = userRoleInfoDao.getListByMap(paramMap);
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(UserRoleInfo entity) {
		return userRoleInfoDao.update(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return userRoleInfoDao.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(UserRoleInfo entity) {
		return userRoleInfoDao.add(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<UserRoleInfo> entityList) {
		return userRoleInfoDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<UserRoleInfo> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<UserRoleInfo> getActivedList() {
		List<UserRoleInfo> resut = null;
		UserRoleInfo entity = new UserRoleInfo();
		entity.setIsDeleted(0);
		resut = userRoleInfoDao.getList(entity);
		return resut;
	}
}