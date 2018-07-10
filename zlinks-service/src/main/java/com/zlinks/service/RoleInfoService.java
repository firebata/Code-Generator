package com.zlinks.service;

import java.util.List;
import java.util.Map;

import com.zlinks.common.web.PageResult;
import com.zlinks.domain.RoleInfo;

/**
 * Copyright (C), 2017-2020, cn.zlinks
 * FileName: RoleInfoService
 * Author:   zhangjh
 * Date:     2018-7-10 19:31:43
 * Description:RoleInfoService接口
 */
public interface RoleInfoService {


	RoleInfo queryInfoById(Long id);

	int getListCount(RoleInfo entity);

	public List<RoleInfo> selectByCondition(RoleInfo entity) ;

	public List<RoleInfo> getList();

	int update(RoleInfo entity);

	int deleteById(int id);

	int add(RoleInfo entity);

	int addList(List<RoleInfo> entityList);

    PageResult<RoleInfo> findPage(RoleInfo pageInfo);

	List<RoleInfo> getActivedList();
}