package com.zlinks.com.zlinks.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.com.zlinks.domain.UserInfo;
import com.zlinks.com.zlinks.service.UserInfoService;
import com.zlinks.com.zlinks.mapper.UserInfoDao;
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
@Service("userInfoService")
public class UserInfoServiceImpl extends BaseMybatisDao<UserInfoDao> implements UserInfoService {

	@Autowired
	private UserInfoDao userInfoDao;

	@Override
	public UserInfo getById(int id) {
		return userInfoDao.getById(id);
	}

	@Override
	public int getListCount(UserInfo entity) {
		return userInfoDao.getListCount(entity);
	}

	@Override
	public List<UserInfo> getList(UserInfo entity) {
		List<UserInfo> resut = null;
		resut = userInfoDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return userInfoDao.getListByMapCount(paramMap);
	}

	@Override
	public List<UserInfo> getListByMap(Map<String, Object> paramMap) {
		List<UserInfo> resut = null;
		resut = userInfoDao.getListByMap(paramMap);
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(UserInfo entity) {
		return userInfoDao.update(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return userInfoDao.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(UserInfo entity) {
		return userInfoDao.add(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<UserInfo> entityList) {
		return userInfoDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<UserInfo> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<UserInfo> getActivedList() {
		List<UserInfo> resut = null;
		UserInfo entity = new UserInfo();
		entity.setIsDeleted(0);
		resut = userInfoDao.getList(entity);
		return resut;
	}
}