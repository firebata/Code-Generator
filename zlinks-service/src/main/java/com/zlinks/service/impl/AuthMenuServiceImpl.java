package com.zlinks.service.impl;

import com.zlinks.common.db.SqlPageDoing;
import com.zlinks.common.enums.Whether;
import com.zlinks.common.web.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.domain.AuthMenu;
import com.zlinks.service.AuthMenuService;
import com.zlinks.mapper.AuthMenuMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * Copyright (C), 2017-2020, cn.zlinks
 * FileName: AuthMenuServiceImpl
 * Author:   zhangjh
 * Date:     2018-7-10 19:53:10
 * Description:AuthMenuService接口
 */
@Service
public class AuthMenuServiceImpl implements AuthMenuService {

	private static Logger logger = LoggerFactory.getLogger(AuthMenuServiceImpl.class);


	@Autowired
	private AuthMenuMapper authMenuMapper;

	@Override
	public AuthMenu queryInfoById(Long id) {
		return authMenuMapper.queryInfoById(id);
	}

	@Override
	public int getListCount(AuthMenu entity) {
		return authMenuMapper.selectCountByCondition(entity);
	}

	@Override
	public List<AuthMenu> selectByCondition(AuthMenu entity) {
		List<AuthMenu> resut = null;
		resut = authMenuMapper.selectByCondition(entity);
		return resut;
	}

	@Override
	public List<AuthMenu> getList() {
		List<AuthMenu> resut = null;
		resut = authMenuMapper.getList();
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(AuthMenu entity) {
		return authMenuMapper.updateById(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return authMenuMapper.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(AuthMenu entity) {
		return authMenuMapper.insert(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<AuthMenu> entityList) {
		return authMenuMapper.insertList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
    public PageResult<AuthMenu> findPage(AuthMenu pageInfo){
  		SqlPageDoing doing = pageResult -> {
            //查记录数
            Integer totalCount = authMenuMapper.selectCountByCondition(pageInfo);

            List<AuthMenu> list = authMenuMapper.selectByCondition(pageInfo);

   		 	pageResult.list = list;
    		pageResult.totalCount = totalCount;
    	};
    	return doing.go(pageInfo, logger);
	}

	@Override
	public List<AuthMenu> getActivedList() {
		List<AuthMenu> resut = null;
		AuthMenu entity = new AuthMenu();
        entity.setDeleteFlag(Whether.NO);
		resut = authMenuMapper.selectByCondition(entity);
		return resut;
	}
}