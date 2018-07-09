package com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/domain/.LogLimitRecord;
import com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.LogLimitRecordService;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/mapper/.LogLimitRecordDao;
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
@Service("logLimitRecordService")
public class LogLimitRecordServiceImpl extends BaseMybatisDao<LogLimitRecordDao> implements LogLimitRecordService {

	@Autowired
	private LogLimitRecordDao logLimitRecordDao;

	@Override
	public LogLimitRecord getById(int id) {
		return logLimitRecordDao.getById(id);
	}

	@Override
	public int getListCount(LogLimitRecord entity) {
		return logLimitRecordDao.getListCount(entity);
	}

	@Override
	public List<LogLimitRecord> getList(LogLimitRecord entity) {
		List<LogLimitRecord> resut = null;
		resut = logLimitRecordDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return logLimitRecordDao.getListByMapCount(paramMap);
	}

	@Override
	public List<LogLimitRecord> getListByMap(Map<String, Object> paramMap) {
		List<LogLimitRecord> resut = null;
		resut = logLimitRecordDao.getListByMap(paramMap);
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(LogLimitRecord entity) {
		return logLimitRecordDao.update(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return logLimitRecordDao.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(LogLimitRecord entity) {
		return logLimitRecordDao.add(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<LogLimitRecord> entityList) {
		return logLimitRecordDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<LogLimitRecord> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<LogLimitRecord> getActivedList() {
		List<LogLimitRecord> resut = null;
		LogLimitRecord entity = new LogLimitRecord();
		entity.setIsDeleted(0);
		resut = logLimitRecordDao.getList(entity);
		return resut;
	}
}