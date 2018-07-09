package com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/domain/.AraInfo;
import com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.AraInfoService;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/mapper/.AraInfoDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * Copyright (C), 2017-2020, BBG
 * FileName: AccountController
 * Author:   zhangjh
 * Date:     2018-7-9 16:02:00
 * Description:业务
 */
@Service("araInfoService")
public class AraInfoServiceImpl extends BaseMybatisDao<AraInfoDao> implements AraInfoService {

	@Autowired
	private AraInfoDao araInfoDao;

	@Override
	public AraInfo getById(int id) {
		return araInfoDao.getById(id);
	}

	@Override
	public int getListCount(AraInfo entity) {
		return araInfoDao.getListCount(entity);
	}

	@Override
	public List<AraInfo> getList(AraInfo entity) {
		List<AraInfo> resut = null;
		resut = araInfoDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return araInfoDao.getListByMapCount(paramMap);
	}

	@Override
	public List<AraInfo> getListByMap(Map<String, Object> paramMap) {
		List<AraInfo> resut = null;
		resut = araInfoDao.getListByMap(paramMap);
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(AraInfo entity) {
		return araInfoDao.update(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return araInfoDao.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(AraInfo entity) {
		return araInfoDao.add(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<AraInfo> entityList) {
		return araInfoDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<AraInfo> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<AraInfo> getActivedList() {
		List<AraInfo> resut = null;
		AraInfo entity = new AraInfo();
		entity.setIsDeleted(0);
		resut = araInfoDao.getList(entity);
		return resut;
	}
}