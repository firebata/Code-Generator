package com.zlinks.service;

import java.util.List;
import java.util.Map;

import com.zlinks.common.web.PageResult;
import com.zlinks.domain.UserGameRole;

/**
 * Copyright (C), 2017-2020, cn.zlinks
 * FileName: UserGameRoleService
 * Author:   zhangjh
 * Date:     2018-7-10 19:31:43
 * Description:UserGameRoleService接口
 */
public interface UserGameRoleService {


	UserGameRole queryInfoById(Long id);

	int getListCount(UserGameRole entity);

	public List<UserGameRole> selectByCondition(UserGameRole entity) ;

	public List<UserGameRole> getList();

	int update(UserGameRole entity);

	int deleteById(int id);

	int add(UserGameRole entity);

	int addList(List<UserGameRole> entityList);

    PageResult<UserGameRole> findPage(UserGameRole pageInfo);

	List<UserGameRole> getActivedList();
}