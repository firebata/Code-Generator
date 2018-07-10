package com.zlinks.service;

import java.util.List;
import java.util.Map;

import com.zlinks.common.web.PageResult;
import com.zlinks.domain.Element;

/**
 * Copyright (C), 2017-2020, cn.zlinks
 * FileName: ElementService
 * Author:   zhangjh
 * Date:     2018-7-10 19:31:43
 * Description:ElementService接口
 */
public interface ElementService {


	Element queryInfoById(Long id);

	int getListCount(Element entity);

	public List<Element> selectByCondition(Element entity) ;

	public List<Element> getList();

	int update(Element entity);

	int deleteById(int id);

	int add(Element entity);

	int addList(List<Element> entityList);

    PageResult<Element> findPage(Element pageInfo);

	List<Element> getActivedList();
}