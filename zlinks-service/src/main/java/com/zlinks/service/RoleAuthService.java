package com.zlinks.service;

import java.util.List;
import java.util.Map;

import com.zlinks.common.web.PageResult;
import com.zlinks.domain.RoleAuth;

/**
 * Copyright (C), 2017-2020, cn.zlinks
 * FileName: RoleAuthService
 * Author:   zhangjh
 * Date:     2018-7-10 19:53:10
 * Description:RoleAuthService接口
 */
public interface RoleAuthService {


	RoleAuth queryInfoById(Long id);

	int getListCount(RoleAuth entity);

	public List<RoleAuth> selectByCondition(RoleAuth entity) ;

	public List<RoleAuth> getList();

	int update(RoleAuth entity);

	int deleteById(int id);

	int add(RoleAuth entity);

	int addList(List<RoleAuth> entityList);

    PageResult<RoleAuth> findPage(RoleAuth pageInfo);

	List<RoleAuth> getActivedList();
}