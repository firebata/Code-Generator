package com.zlinks.service;

import java.util.List;
import java.util.Map;

import com.zlinks.common.web.PageResult;
import com.zlinks.domain.UserInfo;

/**
 * Copyright (C), 2017-2020, cn.zlinks
 * FileName: UserInfoService
 * Author:   zhangjh
 * Date:     2018-7-10 19:53:10
 * Description:UserInfoService接口
 */
public interface UserInfoService {


	UserInfo queryInfoById(Long id);

	int getListCount(UserInfo entity);

	public List<UserInfo> selectByCondition(UserInfo entity) ;

	public List<UserInfo> getList();

	int update(UserInfo entity);

	int deleteById(int id);

	int add(UserInfo entity);

	int addList(List<UserInfo> entityList);

    PageResult<UserInfo> findPage(UserInfo pageInfo);

	List<UserInfo> getActivedList();
}