package com.zlinks.service.impl;

import com.zlinks.common.db.SqlPageDoing;
import com.zlinks.common.enums.Whether;
import com.zlinks.common.web.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.domain.RoleAuth;
import com.zlinks.service.RoleAuthService;
import com.zlinks.mapper.RoleAuthMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * Copyright (C), 2017-2020, cn.zlinks
 * FileName: RoleAuthServiceImpl
 * Author:   zhangjh
 * Date:     2018-7-10 19:53:10
 * Description:RoleAuthService接口
 */
@Service
public class RoleAuthServiceImpl implements RoleAuthService {

	private static Logger logger = LoggerFactory.getLogger(RoleAuthServiceImpl.class);


	@Autowired
	private RoleAuthMapper roleAuthMapper;

	@Override
	public RoleAuth queryInfoById(Long id) {
		return roleAuthMapper.queryInfoById(id);
	}

	@Override
	public int getListCount(RoleAuth entity) {
		return roleAuthMapper.selectCountByCondition(entity);
	}

	@Override
	public List<RoleAuth> selectByCondition(RoleAuth entity) {
		List<RoleAuth> resut = null;
		resut = roleAuthMapper.selectByCondition(entity);
		return resut;
	}

	@Override
	public List<RoleAuth> getList() {
		List<RoleAuth> resut = null;
		resut = roleAuthMapper.getList();
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(RoleAuth entity) {
		return roleAuthMapper.updateById(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return roleAuthMapper.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(RoleAuth entity) {
		return roleAuthMapper.insert(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<RoleAuth> entityList) {
		return roleAuthMapper.insertList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
    public PageResult<RoleAuth> findPage(RoleAuth pageInfo){
  		SqlPageDoing doing = pageResult -> {
            //查记录数
            Integer totalCount = roleAuthMapper.selectCountByCondition(pageInfo);

            List<RoleAuth> list = roleAuthMapper.selectByCondition(pageInfo);

   		 	pageResult.list = list;
    		pageResult.totalCount = totalCount;
    	};
    	return doing.go(pageInfo, logger);
	}

	@Override
	public List<RoleAuth> getActivedList() {
		List<RoleAuth> resut = null;
		RoleAuth entity = new RoleAuth();
        entity.setDeleteFlag(Whether.NO);
		resut = roleAuthMapper.selectByCondition(entity);
		return resut;
	}
}