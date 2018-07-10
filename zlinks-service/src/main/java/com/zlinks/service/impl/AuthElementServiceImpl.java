package com.zlinks.service.impl;

import com.zlinks.common.db.SqlPageDoing;
import com.zlinks.common.enums.Whether;
import com.zlinks.common.web.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.domain.AuthElement;
import com.zlinks.service.AuthElementService;
import com.zlinks.mapper.AuthElementMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * Copyright (C), 2017-2020, cn.zlinks
 * FileName: AuthElementServiceImpl
 * Author:   zhangjh
 * Date:     2018-7-10 19:31:43
 * Description:AuthElementService接口
 */
@Service
public class AuthElementServiceImpl implements AuthElementService {

	private static Logger logger = LoggerFactory.getLogger(AuthElementServiceImpl.class);


	@Autowired
	private AuthElementMapper authElementMapper;

	@Override
	public AuthElement queryInfoById(Long id) {
		return authElementMapper.queryInfoById(id);
	}

	@Override
	public int getListCount(AuthElement entity) {
		return authElementMapper.selectCountByCondition(entity);
	}

	@Override
	public List<AuthElement> selectByCondition(AuthElement entity) {
		List<AuthElement> resut = null;
		resut = authElementMapper.selectByCondition(entity);
		return resut;
	}

	@Override
	public List<AuthElement> getList() {
		List<AuthElement> resut = null;
		resut = authElementMapper.getList();
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(AuthElement entity) {
		return authElementMapper.updateById(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return authElementMapper.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(AuthElement entity) {
		return authElementMapper.insert(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<AuthElement> entityList) {
		return authElementMapper.insertList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
    public PageResult<AuthElement> findPage(AuthElement pageInfo){
  		SqlPageDoing doing = pageResult -> {
            //查记录数
            Integer totalCount = authElementMapper.selectCountByCondition(pageInfo);

            List<AuthElement> list = authElementMapper.selectByCondition(pageInfo);

   		 	pageResult.list = list;
    		pageResult.totalCount = totalCount;
    	};
    	return doing.go(pageInfo, logger);
	}

	@Override
	public List<AuthElement> getActivedList() {
		List<AuthElement> resut = null;
		AuthElement entity = new AuthElement();
        entity.setDeleteFlag(Whether.NO);
		resut = authElementMapper.selectByCondition(entity);
		return resut;
	}
}