package com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/domain/.SdkSwitch;
import com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.SdkSwitchService;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/mapper/.SdkSwitchDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * Copyright (C), 2017-2020, BBG
 * FileName: AccountController
 * Author:   zhangjh
 * Date:     2018-7-9 16:02:01
 * Description:业务
 */
@Service("sdkSwitchService")
public class SdkSwitchServiceImpl extends BaseMybatisDao<SdkSwitchDao> implements SdkSwitchService {

	@Autowired
	private SdkSwitchDao sdkSwitchDao;

	@Override
	public SdkSwitch getById(int id) {
		return sdkSwitchDao.getById(id);
	}

	@Override
	public int getListCount(SdkSwitch entity) {
		return sdkSwitchDao.getListCount(entity);
	}

	@Override
	public List<SdkSwitch> getList(SdkSwitch entity) {
		List<SdkSwitch> resut = null;
		resut = sdkSwitchDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return sdkSwitchDao.getListByMapCount(paramMap);
	}

	@Override
	public List<SdkSwitch> getListByMap(Map<String, Object> paramMap) {
		List<SdkSwitch> resut = null;
		resut = sdkSwitchDao.getListByMap(paramMap);
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(SdkSwitch entity) {
		return sdkSwitchDao.update(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return sdkSwitchDao.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(SdkSwitch entity) {
		return sdkSwitchDao.add(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<SdkSwitch> entityList) {
		return sdkSwitchDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<SdkSwitch> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<SdkSwitch> getActivedList() {
		List<SdkSwitch> resut = null;
		SdkSwitch entity = new SdkSwitch();
		entity.setIsDeleted(0);
		resut = sdkSwitchDao.getList(entity);
		return resut;
	}
}