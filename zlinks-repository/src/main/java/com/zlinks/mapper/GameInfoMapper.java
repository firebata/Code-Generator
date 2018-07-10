package com.zlinks.mapper;

import com.zlinks.domain.GameInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * Copyright (C), 2017-2018, cn.zlinks
 * FileName: AccountMapper
 * Author:   zhangjh
 * Date:     2018-7-10 19:53:10
 * Description: GameInfoMapper
 */
@Mapper
public interface GameInfoMapper{



GameInfo queryInfoById(Long id);

	int selectCount();

	int selectCountByCondition(GameInfo entity);

	List<GameInfo> selectByCondition(GameInfo entity);

	int updateById(GameInfo entity);

	int deleteById(int id);

	int insert(GameInfo entity);

	int insertList(List<GameInfo> entityList);

	List<GameInfo>  getList();




}