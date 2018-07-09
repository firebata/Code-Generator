package com.zlinks.common;

import com.zlinks.common.domain.SelectItem;
import com.zlinks.common.dto.BaseQueryFormDto;
import com.zlinks.common.dto.pager.DataTablesInfo;
import com.zlinks.common.mapper.BaseDeleteMapper;
import com.zlinks.common.mapper.BaseInsertMapper;
import com.zlinks.common.mapper.BaseSelectMapper;
import com.zlinks.common.mapper.BaseUpdateMapper;

import java.io.Serializable;
import java.util.List;

/**
 * Copyright (C), 2017-2018, BBG
 * FileName: BaseMapper
 * Author:   zhangjh
 * Date:     2018/6/6 20:10
 * Description: 基础接口
 */
public interface BaseMapper<T, ID extends Serializable> extends BaseInsertMapper,BaseSelectMapper,BaseUpdateMapper,BaseDeleteMapper {

    int listInfosCounts();

    int listFilteredInfosCounts(DataTablesInfo dataTablesInfo);

    List<T> searchInfos(DataTablesInfo dataTablesInfo);

    void updateInfo(T t);

    <T> T queryInfo(String natrualKey);

    T getOne(ID id);

    void add(T t);

    void del(String natrualKey);

    String queryCurrentSeqNo();

    List<SelectItem> querySelectList(String name);

    void addBatch(List<T> infos);

    void updateBatch(List<T> infos);

    List<SelectItem> querySelectListByParentId(String parentId);

    <T> List<T> searchInfos(BaseQueryFormDto baseQueyrForm);

    int listFilteredInfosCounts(BaseQueryFormDto baseQueyrForm);

}
