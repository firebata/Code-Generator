package com.zlinks.service;

import java.util.List;
import java.util.Map;

import com.zlinks.common.web.PageResult;
import com.zlinks.domain.AuthMenu;

/**
 * Copyright (C), 2017-2020, cn.zlinks
 * FileName: AuthMenuService
 * Author:   zhangjh
 * Date:     2018-7-10 19:31:43
 * Description:AuthMenuService接口
 */
public interface AuthMenuService {


	AuthMenu queryInfoById(Long id);

	int getListCount(AuthMenu entity);

	public List<AuthMenu> selectByCondition(AuthMenu entity) ;

	public List<AuthMenu> getList();

	int update(AuthMenu entity);

	int deleteById(int id);

	int add(AuthMenu entity);

	int addList(List<AuthMenu> entityList);

    PageResult<AuthMenu> findPage(AuthMenu pageInfo);

	List<AuthMenu> getActivedList();
}