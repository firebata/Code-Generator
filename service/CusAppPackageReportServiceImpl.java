package com.zlinks.service/.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.domain/.CusAppPackageReport;
import com.zlinks.service/.CusAppPackageReportService;
import com.zlinks.mapper/.CusAppPackageReportDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * Copyright (C), 2017-2020, BBG
 * FileName: AccountController
 * Author:   zhangjh
 * Date:     2018-7-9 16:20:13
 * Description:业务
 */
@Service("cusAppPackageReportService")
public class CusAppPackageReportServiceImpl extends BaseMybatisDao<CusAppPackageReportDao> implements CusAppPackageReportService {

	@Autowired
	private CusAppPackageReportDao cusAppPackageReportDao;

	@Override
	public CusAppPackageReport getById(int id) {
		return cusAppPackageReportDao.getById(id);
	}

	@Override
	public int getListCount(CusAppPackageReport entity) {
		return cusAppPackageReportDao.getListCount(entity);
	}

	@Override
	public List<CusAppPackageReport> getList(CusAppPackageReport entity) {
		List<CusAppPackageReport> resut = null;
		resut = cusAppPackageReportDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return cusAppPackageReportDao.getListByMapCount(paramMap);
	}

	@Override
	public List<CusAppPackageReport> getListByMap(Map<String, Object> paramMap) {
		List<CusAppPackageReport> resut = null;
		resut = cusAppPackageReportDao.getListByMap(paramMap);
		return resut;
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int update(CusAppPackageReport entity) {
		return cusAppPackageReportDao.update(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int deleteById(int id) {
		return cusAppPackageReportDao.deleteById(id);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int add(CusAppPackageReport entity) {
		return cusAppPackageReportDao.add(entity);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public int addList(List<CusAppPackageReport> entityList) {
		return cusAppPackageReportDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<CusAppPackageReport> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<CusAppPackageReport> getActivedList() {
		List<CusAppPackageReport> resut = null;
		CusAppPackageReport entity = new CusAppPackageReport();
		entity.setIsDeleted(0);
		resut = cusAppPackageReportDao.getList(entity);
		return resut;
	}
}