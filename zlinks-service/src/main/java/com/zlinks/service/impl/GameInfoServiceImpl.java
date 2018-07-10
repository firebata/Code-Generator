package com.zlinks.service.impl;

import com.zlinks.common.db.SqlPageDoing;
import com.zlinks.common.enums.Whether;
import com.zlinks.common.web.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.domain.GameInfo;
import com.zlinks.service.GameInfoService;
import com.zlinks.mapper.GameInfoMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * Copyright (C), 2017-2020, cn.zlinks
 * FileName: GameInfoServiceImpl
 * Author:   zhangjh
 * Date:     2018-7-10 19:31:43
 * Description:GameInfoService接口
 */
@Service
public class GameInfoServiceImpl implements GameInfoService {

	private static Logger logger = LoggerFactory.getLogger(GameInfoServiceImpl.class);


	@Autowired
	private GameInfoMapper gameInfoMapper;

	@Override
	public GameInfo queryInfoById(Long id) {
		return gameInfoMapper.queryInfoById(id);
	}

	@Override
	public int getListCount(GameInfo entity) {
		return gameInfoMapper.selectCountByCondition(entity);
	}

	@Override
	public List<GameInfo> selectByCondition(GameInfo entity) {
		List<GameInfo> resut = null;
		resut = gameInfoMapper.selectByCondition(entity);
		return resut;
	}

	@Override
	public List<GameInfo> getList() {
		List<GameInfo> resut = null;
		resut = gameInfoMapper.getList();
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(GameInfo entity) {
		return gameInfoMapper.updateById(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return gameInfoMapper.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(GameInfo entity) {
		return gameInfoMapper.insert(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<GameInfo> entityList) {
		return gameInfoMapper.insertList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
    public PageResult<GameInfo> findPage(GameInfo pageInfo){
  		SqlPageDoing doing = pageResult -> {
            //查记录数
            Integer totalCount = gameInfoMapper.selectCountByCondition(pageInfo);

            List<GameInfo> list = gameInfoMapper.selectByCondition(pageInfo);

   		 	pageResult.list = list;
    		pageResult.totalCount = totalCount;
    	};
    	return doing.go(pageInfo, logger);
	}

	@Override
	public List<GameInfo> getActivedList() {
		List<GameInfo> resut = null;
		GameInfo entity = new GameInfo();
        entity.setDeleteFlag(Whether.NO);
		resut = gameInfoMapper.selectByCondition(entity);
		return resut;
	}
}