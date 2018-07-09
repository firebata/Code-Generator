package com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/domain/.UsrGameAccountLevel;
import com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.UsrGameAccountLevelService;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/mapper/.UsrGameAccountLevelDao;
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
@Service("usrGameAccountLevelService")
public class UsrGameAccountLevelServiceImpl extends BaseMybatisDao<UsrGameAccountLevelDao> implements UsrGameAccountLevelService {

	@Autowired
	private UsrGameAccountLevelDao usrGameAccountLevelDao;

	@Override
	public UsrGameAccountLevel getById(int id) {
		return usrGameAccountLevelDao.getById(id);
	}

	@Override
	public int getListCount(UsrGameAccountLevel entity) {
		return usrGameAccountLevelDao.getListCount(entity);
	}

	@Override
	public List<UsrGameAccountLevel> getList(UsrGameAccountLevel entity) {
		List<UsrGameAccountLevel> resut = null;
		resut = usrGameAccountLevelDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return usrGameAccountLevelDao.getListByMapCount(paramMap);
	}

	@Override
	public List<UsrGameAccountLevel> getListByMap(Map<String, Object> paramMap) {
		List<UsrGameAccountLevel> resut = null;
		resut = usrGameAccountLevelDao.getListByMap(paramMap);
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(UsrGameAccountLevel entity) {
		return usrGameAccountLevelDao.update(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return usrGameAccountLevelDao.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(UsrGameAccountLevel entity) {
		return usrGameAccountLevelDao.add(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<UsrGameAccountLevel> entityList) {
		return usrGameAccountLevelDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<UsrGameAccountLevel> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<UsrGameAccountLevel> getActivedList() {
		List<UsrGameAccountLevel> resut = null;
		UsrGameAccountLevel entity = new UsrGameAccountLevel();
		entity.setIsDeleted(0);
		resut = usrGameAccountLevelDao.getList(entity);
		return resut;
	}
}