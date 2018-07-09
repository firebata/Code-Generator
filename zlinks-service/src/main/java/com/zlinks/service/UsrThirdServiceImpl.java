package com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/domain/.UsrThird;
import com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.UsrThirdService;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/mapper/.UsrThirdDao;
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
@Service("usrThirdService")
public class UsrThirdServiceImpl extends BaseMybatisDao<UsrThirdDao> implements UsrThirdService {

	@Autowired
	private UsrThirdDao usrThirdDao;

	@Override
	public UsrThird getById(int id) {
		return usrThirdDao.getById(id);
	}

	@Override
	public int getListCount(UsrThird entity) {
		return usrThirdDao.getListCount(entity);
	}

	@Override
	public List<UsrThird> getList(UsrThird entity) {
		List<UsrThird> resut = null;
		resut = usrThirdDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return usrThirdDao.getListByMapCount(paramMap);
	}

	@Override
	public List<UsrThird> getListByMap(Map<String, Object> paramMap) {
		List<UsrThird> resut = null;
		resut = usrThirdDao.getListByMap(paramMap);
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(UsrThird entity) {
		return usrThirdDao.update(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return usrThirdDao.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(UsrThird entity) {
		return usrThirdDao.add(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<UsrThird> entityList) {
		return usrThirdDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<UsrThird> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<UsrThird> getActivedList() {
		List<UsrThird> resut = null;
		UsrThird entity = new UsrThird();
		entity.setIsDeleted(0);
		resut = usrThirdDao.getList(entity);
		return resut;
	}
}