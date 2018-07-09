package com.zlinks.service/.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.domain/.OrdGoogleRefund;
import com.zlinks.service/.OrdGoogleRefundService;
import com.zlinks.mapper/.OrdGoogleRefundDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * Copyright (C), 2017-2020, BBG
 * FileName: AccountController
 * Author:   zhangjh
 * Date:     2018-7-9 16:20:14
 * Description:业务
 */
@Service("ordGoogleRefundService")
public class OrdGoogleRefundServiceImpl extends BaseMybatisDao<OrdGoogleRefundDao> implements OrdGoogleRefundService {

	@Autowired
	private OrdGoogleRefundDao ordGoogleRefundDao;

	@Override
	public OrdGoogleRefund getById(int id) {
		return ordGoogleRefundDao.getById(id);
	}

	@Override
	public int getListCount(OrdGoogleRefund entity) {
		return ordGoogleRefundDao.getListCount(entity);
	}

	@Override
	public List<OrdGoogleRefund> getList(OrdGoogleRefund entity) {
		List<OrdGoogleRefund> resut = null;
		resut = ordGoogleRefundDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return ordGoogleRefundDao.getListByMapCount(paramMap);
	}

	@Override
	public List<OrdGoogleRefund> getListByMap(Map<String, Object> paramMap) {
		List<OrdGoogleRefund> resut = null;
		resut = ordGoogleRefundDao.getListByMap(paramMap);
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(OrdGoogleRefund entity) {
		return ordGoogleRefundDao.update(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return ordGoogleRefundDao.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(OrdGoogleRefund entity) {
		return ordGoogleRefundDao.add(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<OrdGoogleRefund> entityList) {
		return ordGoogleRefundDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<OrdGoogleRefund> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<OrdGoogleRefund> getActivedList() {
		List<OrdGoogleRefund> resut = null;
		OrdGoogleRefund entity = new OrdGoogleRefund();
		entity.setIsDeleted(0);
		resut = ordGoogleRefundDao.getList(entity);
		return resut;
	}
}