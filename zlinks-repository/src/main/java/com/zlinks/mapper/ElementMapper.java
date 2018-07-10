package com.zlinks.mapper;

import com.zlinks.domain.Element;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * Copyright (C), 2017-2018, cn.zlinks
 * FileName: AccountMapper
 * Author:   zhangjh
 * Date:     2018-7-10 19:53:10
 * Description: ElementMapper
 */
@Mapper
public interface ElementMapper{



Element queryInfoById(Long id);

	int selectCount();

	int selectCountByCondition(Element entity);

	List<Element> selectByCondition(Element entity);

	int updateById(Element entity);

	int deleteById(int id);

	int insert(Element entity);

	int insertList(List<Element> entityList);

	List<Element>  getList();




}