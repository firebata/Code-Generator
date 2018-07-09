package com.zlinks.com.zlinks.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.com.zlinks.domain.GoogleBuy;
import com.zlinks.com.zlinks.service.GoogleBuyService;
import com.zlinks.com.zlinks.mapper.GoogleBuyDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * Copyright (C), 2017-2020, BBG
 * FileName: AccountController
 * Author:   zhangjh
 * Date:     2018-7-9 18:51:43
 * Description:业务
 */
@Service("googleBuyService")
public class GoogleBuyServiceImpl extends BaseMybatisDao<GoogleBuyDao> implements GoogleBuyService {

	@Autowired
	private GoogleBuyDao googleBuyDao;

	@Override
	public GoogleBuy getById(int id) {
		return googleBuyDao.getById(id);
	}

	@Override
	public int getListCount(GoogleBuy entity) {
		return googleBuyDao.getListCount(entity);
	}

	@Override
	public List<GoogleBuy> getList(GoogleBuy entity) {
		List<GoogleBuy> resut = null;
		resut = googleBuyDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return googleBuyDao.getListByMapCount(paramMap);
	}

	@Override
	public List<GoogleBuy> getListByMap(Map<String, Object> paramMap) {
		List<GoogleBuy> resut = null;
		resut = googleBuyDao.getListByMap(paramMap);
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(GoogleBuy entity) {
		return googleBuyDao.update(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return googleBuyDao.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(GoogleBuy entity) {
		return googleBuyDao.add(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<GoogleBuy> entityList) {
		return googleBuyDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<GoogleBuy> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<GoogleBuy> getActivedList() {
		List<GoogleBuy> resut = null;
		GoogleBuy entity = new GoogleBuy();
		entity.setIsDeleted(0);
		resut = googleBuyDao.getList(entity);
		return resut;
	}
}