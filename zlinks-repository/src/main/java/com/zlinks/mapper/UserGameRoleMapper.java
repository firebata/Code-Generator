package com.zlinks.mapper;

import com.zlinks.domain.UserGameRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * Copyright (C), 2017-2018, cn.zlinks
 * FileName: AccountMapper
 * Author:   zhangjh
 * Date:     2018-7-10 19:53:10
 * Description: UserGameRoleMapper
 */
@Mapper
public interface UserGameRoleMapper{



UserGameRole queryInfoById(Long id);

	int selectCount();

	int selectCountByCondition(UserGameRole entity);

	List<UserGameRole> selectByCondition(UserGameRole entity);

	int updateById(UserGameRole entity);

	int deleteById(int id);

	int insert(UserGameRole entity);

	int insertList(List<UserGameRole> entityList);

	List<UserGameRole>  getList();




}