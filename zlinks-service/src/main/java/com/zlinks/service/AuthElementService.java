package com.zlinks.service;

import java.util.List;
import java.util.Map;

import com.zlinks.common.web.PageResult;
import com.zlinks.domain.AuthElement;

/**
 * Copyright (C), 2017-2020, cn.zlinks
 * FileName: AuthElementService
 * Author:   zhangjh
 * Date:     2018-7-10 19:53:10
 * Description:AuthElementService接口
 */
public interface AuthElementService {


	AuthElement queryInfoById(Long id);

	int getListCount(AuthElement entity);

	public List<AuthElement> selectByCondition(AuthElement entity) ;

	public List<AuthElement> getList();

	int update(AuthElement entity);

	int deleteById(int id);

	int add(AuthElement entity);

	int addList(List<AuthElement> entityList);

    PageResult<AuthElement> findPage(AuthElement pageInfo);

	List<AuthElement> getActivedList();
}