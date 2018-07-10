package com.zlinks.mapper;

import com.zlinks.domain.AuthInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * Copyright (C), 2017-2018, cn.zlinks
 * FileName: AccountMapper
 * Author:   zhangjh
 * Date:     2018-7-10 19:31:43
 * Description: AuthInfoMapper
 */
@Mapper
public interface AuthInfoMapper{



AuthInfo queryInfoById(Long id);

	int selectCount();

	int selectCountByCondition(AuthInfo entity);

	List<AuthInfo> selectByCondition(AuthInfo entity);

	int updateById(AuthInfo entity);

	int deleteById(int id);

	int insert(AuthInfo entity);

	int insertList(List<AuthInfo> entityList);

	List<AuthInfo>  getList();




}