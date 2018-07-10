package com.zlinks.service.impl;

import com.zlinks.common.db.SqlPageDoing;
import com.zlinks.common.enums.Whether;
import com.zlinks.common.web.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.domain.UsrRegisterInvite;
import com.zlinks.service.UsrRegisterInviteService;
import com.zlinks.mapper.UsrRegisterInviteMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * Copyright (C), 2017-2020, cn.zlinks
 * FileName: UsrRegisterInviteServiceImpl
 * Author:   zhangjh
 * Date:     2018-7-10 19:53:10
 * Description:UsrRegisterInviteService接口
 */
@Service
public class UsrRegisterInviteServiceImpl implements UsrRegisterInviteService {

	private static Logger logger = LoggerFactory.getLogger(UsrRegisterInviteServiceImpl.class);


	@Autowired
	private UsrRegisterInviteMapper usrRegisterInviteMapper;

	@Override
	public UsrRegisterInvite queryInfoById(Long id) {
		return usrRegisterInviteMapper.queryInfoById(id);
	}

	@Override
	public int getListCount(UsrRegisterInvite entity) {
		return usrRegisterInviteMapper.selectCountByCondition(entity);
	}

	@Override
	public List<UsrRegisterInvite> selectByCondition(UsrRegisterInvite entity) {
		List<UsrRegisterInvite> resut = null;
		resut = usrRegisterInviteMapper.selectByCondition(entity);
		return resut;
	}

	@Override
	public List<UsrRegisterInvite> getList() {
		List<UsrRegisterInvite> resut = null;
		resut = usrRegisterInviteMapper.getList();
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(UsrRegisterInvite entity) {
		return usrRegisterInviteMapper.updateById(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return usrRegisterInviteMapper.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(UsrRegisterInvite entity) {
		return usrRegisterInviteMapper.insert(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<UsrRegisterInvite> entityList) {
		return usrRegisterInviteMapper.insertList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
    public PageResult<UsrRegisterInvite> findPage(UsrRegisterInvite pageInfo){
  		SqlPageDoing doing = pageResult -> {
            //查记录数
            Integer totalCount = usrRegisterInviteMapper.selectCountByCondition(pageInfo);

            List<UsrRegisterInvite> list = usrRegisterInviteMapper.selectByCondition(pageInfo);

   		 	pageResult.list = list;
    		pageResult.totalCount = totalCount;
    	};
    	return doing.go(pageInfo, logger);
	}

	@Override
	public List<UsrRegisterInvite> getActivedList() {
		List<UsrRegisterInvite> resut = null;
		UsrRegisterInvite entity = new UsrRegisterInvite();
        entity.setDeleteFlag(Whether.NO);
		resut = usrRegisterInviteMapper.selectByCondition(entity);
		return resut;
	}
}