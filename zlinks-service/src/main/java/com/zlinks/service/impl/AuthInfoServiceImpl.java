package com.zlinks.service.impl;

import com.zlinks.common.db.SqlPageDoing;
import com.zlinks.common.enums.Whether;
import com.zlinks.common.web.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.domain.AuthInfo;
import com.zlinks.service.AuthInfoService;
import com.zlinks.mapper.AuthInfoMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * Copyright (C), 2017-2020, cn.zlinks
 * FileName: AuthInfoServiceImpl
 * Author:   zhangjh
 * Date:     2018-7-10 19:53:10
 * Description:AuthInfoService接口
 */
@Service
public class AuthInfoServiceImpl implements AuthInfoService {

	private static Logger logger = LoggerFactory.getLogger(AuthInfoServiceImpl.class);


	@Autowired
	private AuthInfoMapper authInfoMapper;

	@Override
	public AuthInfo queryInfoById(Long id) {
		return authInfoMapper.queryInfoById(id);
	}

	@Override
	public int getListCount(AuthInfo entity) {
		return authInfoMapper.selectCountByCondition(entity);
	}

	@Override
	public List<AuthInfo> selectByCondition(AuthInfo entity) {
		List<AuthInfo> resut = null;
		resut = authInfoMapper.selectByCondition(entity);
		return resut;
	}

	@Override
	public List<AuthInfo> getList() {
		List<AuthInfo> resut = null;
		resut = authInfoMapper.getList();
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(AuthInfo entity) {
		return authInfoMapper.updateById(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return authInfoMapper.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(AuthInfo entity) {
		return authInfoMapper.insert(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<AuthInfo> entityList) {
		return authInfoMapper.insertList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
    public PageResult<AuthInfo> findPage(AuthInfo pageInfo){
  		SqlPageDoing doing = pageResult -> {
            //查记录数
            Integer totalCount = authInfoMapper.selectCountByCondition(pageInfo);

            List<AuthInfo> list = authInfoMapper.selectByCondition(pageInfo);

   		 	pageResult.list = list;
    		pageResult.totalCount = totalCount;
    	};
    	return doing.go(pageInfo, logger);
	}

	@Override
	public List<AuthInfo> getActivedList() {
		List<AuthInfo> resut = null;
		AuthInfo entity = new AuthInfo();
        entity.setDeleteFlag(Whether.NO);
		resut = authInfoMapper.selectByCondition(entity);
		return resut;
	}
}