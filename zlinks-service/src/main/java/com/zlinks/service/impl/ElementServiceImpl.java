package com.zlinks.service.impl;

import com.zlinks.common.db.SqlPageDoing;
import com.zlinks.common.enums.Whether;
import com.zlinks.common.web.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.domain.Element;
import com.zlinks.service.ElementService;
import com.zlinks.mapper.ElementMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * Copyright (C), 2017-2020, cn.zlinks
 * FileName: ElementServiceImpl
 * Author:   zhangjh
 * Date:     2018-7-10 19:31:43
 * Description:ElementService接口
 */
@Service
public class ElementServiceImpl implements ElementService {

	private static Logger logger = LoggerFactory.getLogger(ElementServiceImpl.class);


	@Autowired
	private ElementMapper elementMapper;

	@Override
	public Element queryInfoById(Long id) {
		return elementMapper.queryInfoById(id);
	}

	@Override
	public int getListCount(Element entity) {
		return elementMapper.selectCountByCondition(entity);
	}

	@Override
	public List<Element> selectByCondition(Element entity) {
		List<Element> resut = null;
		resut = elementMapper.selectByCondition(entity);
		return resut;
	}

	@Override
	public List<Element> getList() {
		List<Element> resut = null;
		resut = elementMapper.getList();
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(Element entity) {
		return elementMapper.updateById(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return elementMapper.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(Element entity) {
		return elementMapper.insert(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<Element> entityList) {
		return elementMapper.insertList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
    public PageResult<Element> findPage(Element pageInfo){
  		SqlPageDoing doing = pageResult -> {
            //查记录数
            Integer totalCount = elementMapper.selectCountByCondition(pageInfo);

            List<Element> list = elementMapper.selectByCondition(pageInfo);

   		 	pageResult.list = list;
    		pageResult.totalCount = totalCount;
    	};
    	return doing.go(pageInfo, logger);
	}

	@Override
	public List<Element> getActivedList() {
		List<Element> resut = null;
		Element entity = new Element();
        entity.setDeleteFlag(Whether.NO);
		resut = elementMapper.selectByCondition(entity);
		return resut;
	}
}