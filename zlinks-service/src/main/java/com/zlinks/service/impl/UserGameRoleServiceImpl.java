package com.zlinks.service.impl;

import com.zlinks.common.db.SqlPageDoing;
import com.zlinks.common.enums.Whether;
import com.zlinks.common.web.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.domain.UserGameRole;
import com.zlinks.service.UserGameRoleService;
import com.zlinks.mapper.UserGameRoleMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * Copyright (C), 2017-2020, cn.zlinks
 * FileName: UserGameRoleServiceImpl
 * Author:   zhangjh
 * Date:     2018-7-10 19:31:43
 * Description:UserGameRoleService接口
 */
@Service
public class UserGameRoleServiceImpl implements UserGameRoleService {

	private static Logger logger = LoggerFactory.getLogger(UserGameRoleServiceImpl.class);


	@Autowired
	private UserGameRoleMapper userGameRoleMapper;

	@Override
	public UserGameRole queryInfoById(Long id) {
		return userGameRoleMapper.queryInfoById(id);
	}

	@Override
	public int getListCount(UserGameRole entity) {
		return userGameRoleMapper.selectCountByCondition(entity);
	}

	@Override
	public List<UserGameRole> selectByCondition(UserGameRole entity) {
		List<UserGameRole> resut = null;
		resut = userGameRoleMapper.selectByCondition(entity);
		return resut;
	}

	@Override
	public List<UserGameRole> getList() {
		List<UserGameRole> resut = null;
		resut = userGameRoleMapper.getList();
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(UserGameRole entity) {
		return userGameRoleMapper.updateById(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return userGameRoleMapper.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(UserGameRole entity) {
		return userGameRoleMapper.insert(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<UserGameRole> entityList) {
		return userGameRoleMapper.insertList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
    public PageResult<UserGameRole> findPage(UserGameRole pageInfo){
  		SqlPageDoing doing = pageResult -> {
            //查记录数
            Integer totalCount = userGameRoleMapper.selectCountByCondition(pageInfo);

            List<UserGameRole> list = userGameRoleMapper.selectByCondition(pageInfo);

   		 	pageResult.list = list;
    		pageResult.totalCount = totalCount;
    	};
    	return doing.go(pageInfo, logger);
	}

	@Override
	public List<UserGameRole> getActivedList() {
		List<UserGameRole> resut = null;
		UserGameRole entity = new UserGameRole();
        entity.setDeleteFlag(Whether.NO);
		resut = userGameRoleMapper.selectByCondition(entity);
		return resut;
	}
}