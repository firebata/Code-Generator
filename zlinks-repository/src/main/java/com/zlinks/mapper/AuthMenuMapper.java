package com.zlinks.mapper;

import com.zlinks.domain.AuthMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * Copyright (C), 2017-2018, cn.zlinks
 * FileName: AccountMapper
 * Author:   zhangjh
 * Date:     2018-7-10 19:53:10
 * Description: AuthMenuMapper
 */
@Mapper
public interface AuthMenuMapper{



AuthMenu queryInfoById(Long id);

	int selectCount();

	int selectCountByCondition(AuthMenu entity);

	List<AuthMenu> selectByCondition(AuthMenu entity);

	int updateById(AuthMenu entity);

	int deleteById(int id);

	int insert(AuthMenu entity);

	int insertList(List<AuthMenu> entityList);

	List<AuthMenu>  getList();




}