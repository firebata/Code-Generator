package com.zlinks.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.domain.UsrThird;
import com.zlinks.service.UsrThirdService;
import com.zlinks.mapper.UsrThirdDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * Copyright (C), 2017-2020, BBG
 * FileName: AccountController
 * Author:   zhangjh
 * Date:     2018-7-9 19:08:16
 * Description:业务
 */
@Service
public class UsrThirdServiceImpl implements UsrThirdService {

	@Autowired
	private UsrThirdMapper usrThirdMapper;

	@Override
	public UsrThird getById(int id) {
		return usrThirdMapper.getById(id);
	}

	@Override
	public int getListCount(UsrThird entity) {
		return usrThirdMapper.getListCount(entity);
	}

	@Override
	public List<UsrThird> getList(UsrThird entity) {
		List<UsrThird> resut = null;
		resut = usrThirdMapper.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return usrThirdMapper.getListByMapCount(paramMap);
	}

	@Override
	public List<UsrThird> getListByMap(Map<String, Object> paramMap) {
		List<UsrThird> resut = null;
		resut = usrThirdMapper.getListByMap(paramMap);
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(UsrThird entity) {
		return usrThirdMapper.update(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return usrThirdMapper.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(UsrThird entity) {
		return usrThirdMapper.add(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<UsrThird> entityList) {
		return usrThirdMapper.addList(entityList);
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
		resut = usrThirdMapper.getList(entity);
		return resut;
	}
}