package com.zlinks.zlinks-service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.entity.CltComplaint;
import com.zlinks.zlinks-service.CltComplaintService;
import com.zlinks.zlinks-repsitory.CltComplaintDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * 类说明:
 *
 * Created by noname on 2018-7-7 15:28:42
 */
@Service("cltComplaintService")
public class CltComplaintServiceImpl extends BaseMybatisDao<CltComplaintDao> implements CltComplaintService {

	@Autowired
	private CltComplaintDao cltComplaintDao;

	@Override
	public CltComplaint getById(int id) {
		return cltComplaintDao.getById(id);
	}

	@Override
	public int getListCount(CltComplaint entity) {
		return cltComplaintDao.getListCount(entity);
	}

	@Override
	public List<CltComplaint> getList(CltComplaint entity) {
		List<CltComplaint> resut = null;
		resut = cltComplaintDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return cltComplaintDao.getListByMapCount(paramMap);
	}

	@Override
	public List<CltComplaint> getListByMap(Map<String, Object> paramMap) {
		List<CltComplaint> resut = null;
		resut = cltComplaintDao.getListByMap(paramMap);
		return resut;
	}

	@Override
	public int update(CltComplaint entity) {
		return cltComplaintDao.update(entity);
	}

	@Override
	public int deleteById(int id) {
		return cltComplaintDao.deleteById(id);
	}

	@Override
	public int add(CltComplaint entity) {
		return cltComplaintDao.add(entity);
	}

	@Override
	public int addList(List<CltComplaint> entityList) {
		return cltComplaintDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<CltComplaint> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<CltComplaint> getActivedList() {
		List<CltComplaint> resut = null;
		CltComplaint entity = new CltComplaint();
		entity.setIsDeleted(0);
		resut = cltComplaintDao.getList(entity);
		return resut;
	}
}