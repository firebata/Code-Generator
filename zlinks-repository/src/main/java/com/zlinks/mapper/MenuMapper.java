package com.zlinks.mapper;

import com.zlinks.domain.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * Copyright (C), 2017-2018, cn.zlinks
 * FileName: AccountMapper
 * Author:   zhangjh
 * Date:     2018-7-10 19:31:43
 * Description: MenuMapper
 */
@Mapper
public interface MenuMapper{



Menu queryInfoById(Long id);

	int selectCount();

	int selectCountByCondition(Menu entity);

	List<Menu> selectByCondition(Menu entity);

	int updateById(Menu entity);

	int deleteById(int id);

	int insert(Menu entity);

	int insertList(List<Menu> entityList);

	List<Menu>  getList();




}