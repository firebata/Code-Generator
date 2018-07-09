package com.zlinks.com.zlinks.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.com.zlinks.domain.HisUsrGmeAccLvl;
import com.zlinks.com.zlinks.service.HisUsrGmeAccLvlService;
import com.zlinks.com.zlinks.mapper.HisUsrGmeAccLvlDao;
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
@Service("hisUsrGmeAccLvlService")
public class HisUsrGmeAccLvlServiceImpl extends BaseMybatisDao<HisUsrGmeAccLvlDao> implements HisUsrGmeAccLvlService {

	@Autowired
	private HisUsrGmeAccLvlDao hisUsrGmeAccLvlDao;

	@Override
	public HisUsrGmeAccLvl getById(int id) {
		return hisUsrGmeAccLvlDao.getById(id);
	}

	@Override
	public int getListCount(HisUsrGmeAccLvl entity) {
		return hisUsrGmeAccLvlDao.getListCount(entity);
	}

	@Override
	public List<HisUsrGmeAccLvl> getList(HisUsrGmeAccLvl entity) {
		List<HisUsrGmeAccLvl> resut = null;
		resut = hisUsrGmeAccLvlDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return hisUsrGmeAccLvlDao.getListByMapCount(paramMap);
	}

	@Override
	public List<HisUsrGmeAccLvl> getListByMap(Map<String, Object> paramMap) {
		List<HisUsrGmeAccLvl> resut = null;
		resut = hisUsrGmeAccLvlDao.getListByMap(paramMap);
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(HisUsrGmeAccLvl entity) {
		return hisUsrGmeAccLvlDao.update(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return hisUsrGmeAccLvlDao.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(HisUsrGmeAccLvl entity) {
		return hisUsrGmeAccLvlDao.add(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<HisUsrGmeAccLvl> entityList) {
		return hisUsrGmeAccLvlDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<HisUsrGmeAccLvl> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<HisUsrGmeAccLvl> getActivedList() {
		List<HisUsrGmeAccLvl> resut = null;
		HisUsrGmeAccLvl entity = new HisUsrGmeAccLvl();
		entity.setIsDeleted(0);
		resut = hisUsrGmeAccLvlDao.getList(entity);
		return resut;
	}
}