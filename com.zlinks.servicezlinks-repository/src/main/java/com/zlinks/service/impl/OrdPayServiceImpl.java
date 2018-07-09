package com.zlinks.com.zlinks.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.com.zlinks.domain.OrdPay;
import com.zlinks.com.zlinks.service.OrdPayService;
import com.zlinks.com.zlinks.mapper.OrdPayDao;
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
@Service("ordPayService")
public class OrdPayServiceImpl extends BaseMybatisDao<OrdPayDao> implements OrdPayService {

	@Autowired
	private OrdPayDao ordPayDao;

	@Override
	public OrdPay getById(int id) {
		return ordPayDao.getById(id);
	}

	@Override
	public int getListCount(OrdPay entity) {
		return ordPayDao.getListCount(entity);
	}

	@Override
	public List<OrdPay> getList(OrdPay entity) {
		List<OrdPay> resut = null;
		resut = ordPayDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return ordPayDao.getListByMapCount(paramMap);
	}

	@Override
	public List<OrdPay> getListByMap(Map<String, Object> paramMap) {
		List<OrdPay> resut = null;
		resut = ordPayDao.getListByMap(paramMap);
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(OrdPay entity) {
		return ordPayDao.update(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return ordPayDao.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(OrdPay entity) {
		return ordPayDao.add(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<OrdPay> entityList) {
		return ordPayDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<OrdPay> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<OrdPay> getActivedList() {
		List<OrdPay> resut = null;
		OrdPay entity = new OrdPay();
		entity.setIsDeleted(0);
		resut = ordPayDao.getList(entity);
		return resut;
	}
}