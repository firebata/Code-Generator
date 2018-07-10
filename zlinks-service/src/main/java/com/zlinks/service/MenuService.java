package com.zlinks.service;

import java.util.List;
import java.util.Map;

import com.zlinks.common.web.PageResult;
import com.zlinks.domain.Menu;

/**
 * Copyright (C), 2017-2020, cn.zlinks
 * FileName: MenuService
 * Author:   zhangjh
 * Date:     2018-7-10 19:53:10
 * Description:MenuService接口
 */
public interface MenuService {


	Menu queryInfoById(Long id);

	int getListCount(Menu entity);

	public List<Menu> selectByCondition(Menu entity) ;

	public List<Menu> getList();

	int update(Menu entity);

	int deleteById(int id);

	int add(Menu entity);

	int addList(List<Menu> entityList);

    PageResult<Menu> findPage(Menu pageInfo);

	List<Menu> getActivedList();
}