package com.zlinks.service/.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.domain/.UserGame;
import com.zlinks.service/.UserGameService;
import com.zlinks.mapper/.UserGameDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * Copyright (C), 2017-2020, BBG
 * FileName: AccountController
 * Author:   zhangjh
 * Date:     2018-7-9 16:20:14
 * Description:业务
 */
@Service("userGameService")
public class UserGameServiceImpl extends BaseMybatisDao<UserGameDao> implements UserGameService {

	@Autowired
	private UserGameDao userGameDao;

	@Override
	public UserGame getById(int id) {
		return userGameDao.getById(id);
	}

	@Override
	public int getListCount(UserGame entity) {
		return userGameDao.getListCount(entity);
	}

	@Override
	public List<UserGame> getList(UserGame entity) {
		List<UserGame> resut = null;
		resut = userGameDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return userGameDao.getListByMapCount(paramMap);
	}

	@Override
	public List<UserGame> getListByMap(Map<String, Object> paramMap) {
		List<UserGame> resut = null;
		resut = userGameDao.getListByMap(paramMap);
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(UserGame entity) {
		return userGameDao.update(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return userGameDao.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(UserGame entity) {
		return userGameDao.add(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<UserGame> entityList) {
		return userGameDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<UserGame> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<UserGame> getActivedList() {
		List<UserGame> resut = null;
		UserGame entity = new UserGame();
		entity.setIsDeleted(0);
		resut = userGameDao.getList(entity);
		return resut;
	}
}