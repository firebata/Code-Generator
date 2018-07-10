package com.zlinks.service.impl;

import com.zlinks.common.db.SqlPageDoing;
import com.zlinks.common.enums.Whether;
import com.zlinks.common.web.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.domain.UserInfo;
import com.zlinks.service.UserInfoService;
import com.zlinks.mapper.UserInfoMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * Copyright (C), 2017-2020, cn.zlinks
 * FileName: UserInfoServiceImpl
 * Author:   zhangjh
 * Date:     2018-7-10 19:31:43
 * Description:UserInfoService接口
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

	private static Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);


	@Autowired
	private UserInfoMapper userInfoMapper;

	@Override
	public UserInfo queryInfoById(Long id) {
		return userInfoMapper.queryInfoById(id);
	}

	@Override
	public int getListCount(UserInfo entity) {
		return userInfoMapper.selectCountByCondition(entity);
	}

	@Override
	public List<UserInfo> selectByCondition(UserInfo entity) {
		List<UserInfo> resut = null;
		resut = userInfoMapper.selectByCondition(entity);
		return resut;
	}

	@Override
	public List<UserInfo> getList() {
		List<UserInfo> resut = null;
		resut = userInfoMapper.getList();
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(UserInfo entity) {
		return userInfoMapper.updateById(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return userInfoMapper.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(UserInfo entity) {
		return userInfoMapper.insert(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<UserInfo> entityList) {
		return userInfoMapper.insertList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
    public PageResult<UserInfo> findPage(UserInfo pageInfo){
  		SqlPageDoing doing = pageResult -> {
            //查记录数
            Integer totalCount = userInfoMapper.selectCountByCondition(pageInfo);

            List<UserInfo> list = userInfoMapper.selectByCondition(pageInfo);

   		 	pageResult.list = list;
    		pageResult.totalCount = totalCount;
    	};
    	return doing.go(pageInfo, logger);
	}

	@Override
	public List<UserInfo> getActivedList() {
		List<UserInfo> resut = null;
		UserInfo entity = new UserInfo();
        entity.setDeleteFlag(Whether.NO);
		resut = userInfoMapper.selectByCondition(entity);
		return resut;
	}
}