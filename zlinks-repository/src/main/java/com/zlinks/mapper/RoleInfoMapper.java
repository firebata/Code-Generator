package com.zlinks.mapper;

import com.zlinks.domain.RoleInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * Copyright (C), 2017-2018, cn.zlinks
 * FileName: AccountMapper
 * Author:   zhangjh
 * Date:     2018-7-10 19:53:10
 * Description: RoleInfoMapper
 */
@Mapper
public interface RoleInfoMapper{



RoleInfo queryInfoById(Long id);

	int selectCount();

	int selectCountByCondition(RoleInfo entity);

	List<RoleInfo> selectByCondition(RoleInfo entity);

	int updateById(RoleInfo entity);

	int deleteById(int id);

	int insert(RoleInfo entity);

	int insertList(List<RoleInfo> entityList);

	List<RoleInfo>  getList();




}