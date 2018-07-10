package com.zlinks.service;

import java.util.List;
import java.util.Map;

import com.zlinks.common.web.PageResult;
import com.zlinks.domain.GameInfo;

/**
 * Copyright (C), 2017-2020, cn.zlinks
 * FileName: GameInfoService
 * Author:   zhangjh
 * Date:     2018-7-10 19:53:10
 * Description:GameInfoService接口
 */
public interface GameInfoService {


	GameInfo queryInfoById(Long id);

	int getListCount(GameInfo entity);

	public List<GameInfo> selectByCondition(GameInfo entity) ;

	public List<GameInfo> getList();

	int update(GameInfo entity);

	int deleteById(int id);

	int add(GameInfo entity);

	int addList(List<GameInfo> entityList);

    PageResult<GameInfo> findPage(GameInfo pageInfo);

	List<GameInfo> getActivedList();
}