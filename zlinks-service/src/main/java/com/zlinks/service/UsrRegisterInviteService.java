package com.zlinks.service;

import java.util.List;
import java.util.Map;

import com.zlinks.common.web.PageResult;
import com.zlinks.domain.UsrRegisterInvite;

/**
 * Copyright (C), 2017-2020, cn.zlinks
 * FileName: UsrRegisterInviteService
 * Author:   zhangjh
 * Date:     2018-7-10 19:31:43
 * Description:UsrRegisterInviteService接口
 */
public interface UsrRegisterInviteService {


	UsrRegisterInvite queryInfoById(Long id);

	int getListCount(UsrRegisterInvite entity);

	public List<UsrRegisterInvite> selectByCondition(UsrRegisterInvite entity) ;

	public List<UsrRegisterInvite> getList();

	int update(UsrRegisterInvite entity);

	int deleteById(int id);

	int add(UsrRegisterInvite entity);

	int addList(List<UsrRegisterInvite> entityList);

    PageResult<UsrRegisterInvite> findPage(UsrRegisterInvite pageInfo);

	List<UsrRegisterInvite> getActivedList();
}