package com.zlinks.service/.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.domain/.RoleUser;
import com.zlinks.service/.RoleUserService;
import com.zlinks.mapper/.RoleUserDao;
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
@Service("roleUserService")
public class RoleUserServiceImpl extends BaseMybatisDao<RoleUserDao> implements RoleUserService {

	@Autowired
	private RoleUserDao roleUserDao;

	@Override
	public RoleUser getById(int id) {
		return roleUserDao.getById(id);
	}

	@Override
	public int getListCount(RoleUser entity) {
		return roleUserDao.getListCount(entity);
	}

	@Override
	public List<RoleUser> getList(RoleUser entity) {
		List<RoleUser> resut = null;
		resut = roleUserDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return roleUserDao.getListByMapCount(paramMap);
	}

	@Override
	public List<RoleUser> getListByMap(Map<String, Object> paramMap) {
		List<RoleUser> resut = null;
		resut = roleUserDao.getListByMap(paramMap);
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(RoleUser entity) {
		return roleUserDao.update(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return roleUserDao.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(RoleUser entity) {
		return roleUserDao.add(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<RoleUser> entityList) {
		return roleUserDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<RoleUser> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<RoleUser> getActivedList() {
		List<RoleUser> resut = null;
		RoleUser entity = new RoleUser();
		entity.setIsDeleted(0);
		resut = roleUserDao.getList(entity);
		return resut;
	}
}