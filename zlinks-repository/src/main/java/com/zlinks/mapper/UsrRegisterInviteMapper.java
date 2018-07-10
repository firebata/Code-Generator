package com.zlinks.mapper;

import com.zlinks.domain.UsrRegisterInvite;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * Copyright (C), 2017-2018, cn.zlinks
 * FileName: AccountMapper
 * Author:   zhangjh
 * Date:     2018-7-10 19:53:10
 * Description: UsrRegisterInviteMapper
 */
@Mapper
public interface UsrRegisterInviteMapper{



UsrRegisterInvite queryInfoById(Long id);

	int selectCount();

	int selectCountByCondition(UsrRegisterInvite entity);

	List<UsrRegisterInvite> selectByCondition(UsrRegisterInvite entity);

	int updateById(UsrRegisterInvite entity);

	int deleteById(int id);

	int insert(UsrRegisterInvite entity);

	int insertList(List<UsrRegisterInvite> entityList);

	List<UsrRegisterInvite>  getList();




}