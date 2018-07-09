package com.zlinks.com.zlinks.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.com.zlinks.domain.CltComplaintReply;
import com.zlinks.com.zlinks.service.CltComplaintReplyService;
import com.zlinks.com.zlinks.mapper.CltComplaintReplyDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * Copyright (C), 2017-2020, BBG
 * FileName: AccountController
 * Author:   zhangjh
 * Date:     2018-7-9 18:51:42
 * Description:业务
 */
@Service("cltComplaintReplyService")
public class CltComplaintReplyServiceImpl extends BaseMybatisDao<CltComplaintReplyDao> implements CltComplaintReplyService {

	@Autowired
	private CltComplaintReplyDao cltComplaintReplyDao;

	@Override
	public CltComplaintReply getById(int id) {
		return cltComplaintReplyDao.getById(id);
	}

	@Override
	public int getListCount(CltComplaintReply entity) {
		return cltComplaintReplyDao.getListCount(entity);
	}

	@Override
	public List<CltComplaintReply> getList(CltComplaintReply entity) {
		List<CltComplaintReply> resut = null;
		resut = cltComplaintReplyDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return cltComplaintReplyDao.getListByMapCount(paramMap);
	}

	@Override
	public List<CltComplaintReply> getListByMap(Map<String, Object> paramMap) {
		List<CltComplaintReply> resut = null;
		resut = cltComplaintReplyDao.getListByMap(paramMap);
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(CltComplaintReply entity) {
		return cltComplaintReplyDao.update(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return cltComplaintReplyDao.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(CltComplaintReply entity) {
		return cltComplaintReplyDao.add(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<CltComplaintReply> entityList) {
		return cltComplaintReplyDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<CltComplaintReply> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<CltComplaintReply> getActivedList() {
		List<CltComplaintReply> resut = null;
		CltComplaintReply entity = new CltComplaintReply();
		entity.setIsDeleted(0);
		resut = cltComplaintReplyDao.getList(entity);
		return resut;
	}
}