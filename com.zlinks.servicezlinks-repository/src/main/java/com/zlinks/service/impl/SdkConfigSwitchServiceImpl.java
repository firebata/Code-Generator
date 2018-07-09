package com.zlinks.com.zlinks.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.com.zlinks.domain.SdkConfigSwitch;
import com.zlinks.com.zlinks.service.SdkConfigSwitchService;
import com.zlinks.com.zlinks.mapper.SdkConfigSwitchDao;
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
@Service("sdkConfigSwitchService")
public class SdkConfigSwitchServiceImpl extends BaseMybatisDao<SdkConfigSwitchDao> implements SdkConfigSwitchService {

	@Autowired
	private SdkConfigSwitchDao sdkConfigSwitchDao;

	@Override
	public SdkConfigSwitch getById(int id) {
		return sdkConfigSwitchDao.getById(id);
	}

	@Override
	public int getListCount(SdkConfigSwitch entity) {
		return sdkConfigSwitchDao.getListCount(entity);
	}

	@Override
	public List<SdkConfigSwitch> getList(SdkConfigSwitch entity) {
		List<SdkConfigSwitch> resut = null;
		resut = sdkConfigSwitchDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return sdkConfigSwitchDao.getListByMapCount(paramMap);
	}

	@Override
	public List<SdkConfigSwitch> getListByMap(Map<String, Object> paramMap) {
		List<SdkConfigSwitch> resut = null;
		resut = sdkConfigSwitchDao.getListByMap(paramMap);
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(SdkConfigSwitch entity) {
		return sdkConfigSwitchDao.update(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return sdkConfigSwitchDao.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(SdkConfigSwitch entity) {
		return sdkConfigSwitchDao.add(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<SdkConfigSwitch> entityList) {
		return sdkConfigSwitchDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<SdkConfigSwitch> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<SdkConfigSwitch> getActivedList() {
		List<SdkConfigSwitch> resut = null;
		SdkConfigSwitch entity = new SdkConfigSwitch();
		entity.setIsDeleted(0);
		resut = sdkConfigSwitchDao.getList(entity);
		return resut;
	}
}