package com.zlinks.mapper;

import com.zlinks.domain.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * Copyright (C), 2017-2018, cn.zlinks
 * FileName: AccountMapper
 * Author:   zhangjh
 * Date:     2018-7-10 19:31:43
 * Description: UserInfoMapper
 */
@Mapper
public interface UserInfoMapper{



UserInfo queryInfoById(Long id);

	int selectCount();

	int selectCountByCondition(UserInfo entity);

	List<UserInfo> selectByCondition(UserInfo entity);

	int updateById(UserInfo entity);

	int deleteById(int id);

	int insert(UserInfo entity);

	int insertList(List<UserInfo> entityList);

	List<UserInfo>  getList();




}