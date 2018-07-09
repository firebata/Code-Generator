package com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/domain/.CusAppPackageReport;
import com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.CusAppPackageReportService;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/mapper/.CusAppPackageReportDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * 类说明:
 *
 * Created by noname on 2018-7-7 15:34:58
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
	public int update(CusAppPackageReport entity) {
		return cusAppPackageReportDao.update(entity);
	}

	@Override
	public int deleteById(int id) {
		return cusAppPackageReportDao.deleteById(id);
	}

	@Override
	public int add(CusAppPackageReport entity) {
		return cusAppPackageReportDao.add(entity);
	}

	@Override
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