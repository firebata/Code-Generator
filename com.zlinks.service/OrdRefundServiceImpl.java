package com.zlinks.com.zlinks.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.com.zlinks.domain.OrdRefund;
import com.zlinks.com.zlinks.service.OrdRefundService;
import com.zlinks.com.zlinks.mapper.OrdRefundDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * Copyright (C), 2017-2020, BBG
 * FileName: AccountController
 * Author:   zhangjh
 * Date:     2018-7-9 16:30:11
 * Description:业务
 */
@Service("ordRefundService")
public class OrdRefundServiceImpl extends BaseMybatisDao<OrdRefundDao> implements OrdRefundService {

	@Autowired
	private OrdRefundDao ordRefundDao;

	@Override
	public OrdRefund getById(int id) {
		return ordRefundDao.getById(id);
	}

	@Override
	public int getListCount(OrdRefund entity) {
		return ordRefundDao.getListCount(entity);
	}

	@Override
	public List<OrdRefund> getList(OrdRefund entity) {
		List<OrdRefund> resut = null;
		resut = ordRefundDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return ordRefundDao.getListByMapCount(paramMap);
	}

	@Override
	public List<OrdRefund> getListByMap(Map<String, Object> paramMap) {
		List<OrdRefund> resut = null;
		resut = ordRefundDao.getListByMap(paramMap);
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(OrdRefund entity) {
		return ordRefundDao.update(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return ordRefundDao.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(OrdRefund entity) {
		return ordRefundDao.add(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<OrdRefund> entityList) {
		return ordRefundDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<OrdRefund> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<OrdRefund> getActivedList() {
		List<OrdRefund> resut = null;
		OrdRefund entity = new OrdRefund();
		entity.setIsDeleted(0);
		resut = ordRefundDao.getList(entity);
		return resut;
	}
}