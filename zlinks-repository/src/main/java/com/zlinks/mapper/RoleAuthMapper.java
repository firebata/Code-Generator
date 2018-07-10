package com.zlinks.mapper;

import com.zlinks.domain.RoleAuth;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * Copyright (C), 2017-2018, cn.zlinks
 * FileName: AccountMapper
 * Author:   zhangjh
 * Date:     2018-7-10 19:31:43
 * Description: RoleAuthMapper
 */
@Mapper
public interface RoleAuthMapper{



RoleAuth queryInfoById(Long id);

	int selectCount();

	int selectCountByCondition(RoleAuth entity);

	List<RoleAuth> selectByCondition(RoleAuth entity);

	int updateById(RoleAuth entity);

	int deleteById(int id);

	int insert(RoleAuth entity);

	int insertList(List<RoleAuth> entityList);

	List<RoleAuth>  getList();




}