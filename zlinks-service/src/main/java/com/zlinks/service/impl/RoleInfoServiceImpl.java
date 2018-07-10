package com.zlinks.service.impl;

import com.zlinks.common.db.SqlPageDoing;
import com.zlinks.common.enums.Whether;
import com.zlinks.common.web.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.domain.RoleInfo;
import com.zlinks.service.RoleInfoService;
import com.zlinks.mapper.RoleInfoMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * Copyright (C), 2017-2020, cn.zlinks
 * FileName: RoleInfoServiceImpl
 * Author:   zhangjh
 * Date:     2018-7-10 19:31:43
 * Description:RoleInfoService接口
 */
@Service
public class RoleInfoServiceImpl implements RoleInfoService {

	private static Logger logger = LoggerFactory.getLogger(RoleInfoServiceImpl.class);


	@Autowired
	private RoleInfoMapper roleInfoMapper;

	@Override
	public RoleInfo queryInfoById(Long id) {
		return roleInfoMapper.queryInfoById(id);
	}

	@Override
	public int getListCount(RoleInfo entity) {
		return roleInfoMapper.selectCountByCondition(entity);
	}

	@Override
	public List<RoleInfo> selectByCondition(RoleInfo entity) {
		List<RoleInfo> resut = null;
		resut = roleInfoMapper.selectByCondition(entity);
		return resut;
	}

	@Override
	public List<RoleInfo> getList() {
		List<RoleInfo> resut = null;
		resut = roleInfoMapper.getList();
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(RoleInfo entity) {
		return roleInfoMapper.updateById(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return roleInfoMapper.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(RoleInfo entity) {
		return roleInfoMapper.insert(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<RoleInfo> entityList) {
		return roleInfoMapper.insertList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
    public PageResult<RoleInfo> findPage(RoleInfo pageInfo){
  		SqlPageDoing doing = pageResult -> {
            //查记录数
            Integer totalCount = roleInfoMapper.selectCountByCondition(pageInfo);

            List<RoleInfo> list = roleInfoMapper.selectByCondition(pageInfo);

   		 	pageResult.list = list;
    		pageResult.totalCount = totalCount;
    	};
    	return doing.go(pageInfo, logger);
	}

	@Override
	public List<RoleInfo> getActivedList() {
		List<RoleInfo> resut = null;
		RoleInfo entity = new RoleInfo();
        entity.setDeleteFlag(Whether.NO);
		resut = roleInfoMapper.selectByCondition(entity);
		return resut;
	}
}