package com.zlinks.service/.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.domain/.EveUsersConsumptionCapacity;
import com.zlinks.service/.EveUsersConsumptionCapacityService;
import com.zlinks.mapper/.EveUsersConsumptionCapacityDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * Copyright (C), 2017-2020, BBG
 * FileName: AccountController
 * Author:   zhangjh
 * Date:     2018-7-9 16:20:13
 * Description:业务
 */
@Service("eveUsersConsumptionCapacityService")
public class EveUsersConsumptionCapacityServiceImpl extends BaseMybatisDao<EveUsersConsumptionCapacityDao> implements EveUsersConsumptionCapacityService {

	@Autowired
	private EveUsersConsumptionCapacityDao eveUsersConsumptionCapacityDao;

	@Override
	public EveUsersConsumptionCapacity getById(int id) {
		return eveUsersConsumptionCapacityDao.getById(id);
	}

	@Override
	public int getListCount(EveUsersConsumptionCapacity entity) {
		return eveUsersConsumptionCapacityDao.getListCount(entity);
	}

	@Override
	public List<EveUsersConsumptionCapacity> getList(EveUsersConsumptionCapacity entity) {
		List<EveUsersConsumptionCapacity> resut = null;
		resut = eveUsersConsumptionCapacityDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return eveUsersConsumptionCapacityDao.getListByMapCount(paramMap);
	}

	@Override
	public List<EveUsersConsumptionCapacity> getListByMap(Map<String, Object> paramMap) {
		List<EveUsersConsumptionCapacity> resut = null;
		resut = eveUsersConsumptionCapacityDao.getListByMap(paramMap);
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(EveUsersConsumptionCapacity entity) {
		return eveUsersConsumptionCapacityDao.update(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return eveUsersConsumptionCapacityDao.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(EveUsersConsumptionCapacity entity) {
		return eveUsersConsumptionCapacityDao.add(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<EveUsersConsumptionCapacity> entityList) {
		return eveUsersConsumptionCapacityDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<EveUsersConsumptionCapacity> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<EveUsersConsumptionCapacity> getActivedList() {
		List<EveUsersConsumptionCapacity> resut = null;
		EveUsersConsumptionCapacity entity = new EveUsersConsumptionCapacity();
		entity.setIsDeleted(0);
		resut = eveUsersConsumptionCapacityDao.getList(entity);
		return resut;
	}
}