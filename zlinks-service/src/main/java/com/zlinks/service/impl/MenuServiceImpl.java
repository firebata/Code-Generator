package com.zlinks.service.impl;

import com.zlinks.common.db.SqlPageDoing;
import com.zlinks.common.enums.Whether;
import com.zlinks.common.web.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.domain.Menu;
import com.zlinks.service.MenuService;
import com.zlinks.mapper.MenuMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * Copyright (C), 2017-2020, cn.zlinks
 * FileName: MenuServiceImpl
 * Author:   zhangjh
 * Date:     2018-7-10 19:53:10
 * Description:MenuService接口
 */
@Service
public class MenuServiceImpl implements MenuService {

	private static Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);


	@Autowired
	private MenuMapper menuMapper;

	@Override
	public Menu queryInfoById(Long id) {
		return menuMapper.queryInfoById(id);
	}

	@Override
	public int getListCount(Menu entity) {
		return menuMapper.selectCountByCondition(entity);
	}

	@Override
	public List<Menu> selectByCondition(Menu entity) {
		List<Menu> resut = null;
		resut = menuMapper.selectByCondition(entity);
		return resut;
	}

	@Override
	public List<Menu> getList() {
		List<Menu> resut = null;
		resut = menuMapper.getList();
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(Menu entity) {
		return menuMapper.updateById(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return menuMapper.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(Menu entity) {
		return menuMapper.insert(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<Menu> entityList) {
		return menuMapper.insertList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
    public PageResult<Menu> findPage(Menu pageInfo){
  		SqlPageDoing doing = pageResult -> {
            //查记录数
            Integer totalCount = menuMapper.selectCountByCondition(pageInfo);

            List<Menu> list = menuMapper.selectByCondition(pageInfo);

   		 	pageResult.list = list;
    		pageResult.totalCount = totalCount;
    	};
    	return doing.go(pageInfo, logger);
	}

	@Override
	public List<Menu> getActivedList() {
		List<Menu> resut = null;
		Menu entity = new Menu();
        entity.setDeleteFlag(Whether.NO);
		resut = menuMapper.selectByCondition(entity);
		return resut;
	}
}