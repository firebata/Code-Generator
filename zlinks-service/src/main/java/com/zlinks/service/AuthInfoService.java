package com.zlinks.service;

import java.util.List;
import java.util.Map;

import com.zlinks.common.web.PageResult;
import com.zlinks.domain.AuthInfo;

/**
 * Copyright (C), 2017-2020, cn.zlinks
 * FileName: AuthInfoService
 * Author:   zhangjh
 * Date:     2018-7-10 19:53:10
 * Description:AuthInfoService接口
 */
public interface AuthInfoService {


	AuthInfo queryInfoById(Long id);

	int getListCount(AuthInfo entity);

	public List<AuthInfo> selectByCondition(AuthInfo entity) ;

	public List<AuthInfo> getList();

	int update(AuthInfo entity);

	int deleteById(int id);

	int add(AuthInfo entity);

	int addList(List<AuthInfo> entityList);

    PageResult<AuthInfo> findPage(AuthInfo pageInfo);

	List<AuthInfo> getActivedList();
}