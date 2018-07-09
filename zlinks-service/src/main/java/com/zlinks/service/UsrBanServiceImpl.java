package com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/domain/.UsrBan;
import com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.UsrBanService;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/mapper/.UsrBanDao;
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
@Service("usrBanService")
public class UsrBanServiceImpl extends BaseMybatisDao<UsrBanDao> implements UsrBanService {

	@Autowired
	private UsrBanDao usrBanDao;

	@Override
	public UsrBan getById(int id) {
		return usrBanDao.getById(id);
	}

	@Override
	public int getListCount(UsrBan entity) {
		return usrBanDao.getListCount(entity);
	}

	@Override
	public List<UsrBan> getList(UsrBan entity) {
		List<UsrBan> resut = null;
		resut = usrBanDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return usrBanDao.getListByMapCount(paramMap);
	}

	@Override
	public List<UsrBan> getListByMap(Map<String, Object> paramMap) {
		List<UsrBan> resut = null;
		resut = usrBanDao.getListByMap(paramMap);
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(UsrBan entity) {
		return usrBanDao.update(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return usrBanDao.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(UsrBan entity) {
		return usrBanDao.add(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<UsrBan> entityList) {
		return usrBanDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<UsrBan> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<UsrBan> getActivedList() {
		List<UsrBan> resut = null;
		UsrBan entity = new UsrBan();
		entity.setIsDeleted(0);
		resut = usrBanDao.getList(entity);
		return resut;
	}
}