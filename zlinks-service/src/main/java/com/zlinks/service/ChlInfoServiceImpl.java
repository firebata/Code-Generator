package com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/domain/.ChlInfo;
import com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.ChlInfoService;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/mapper/.ChlInfoDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * 类说明:
 *
 * Created by noname on 2018-7-7 15:34:58
 */
@Service("chlInfoService")
public class ChlInfoServiceImpl extends BaseMybatisDao<ChlInfoDao> implements ChlInfoService {

	@Autowired
	private ChlInfoDao chlInfoDao;

	@Override
	public ChlInfo getById(int id) {
		return chlInfoDao.getById(id);
	}

	@Override
	public int getListCount(ChlInfo entity) {
		return chlInfoDao.getListCount(entity);
	}

	@Override
	public List<ChlInfo> getList(ChlInfo entity) {
		List<ChlInfo> resut = null;
		resut = chlInfoDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return chlInfoDao.getListByMapCount(paramMap);
	}

	@Override
	public List<ChlInfo> getListByMap(Map<String, Object> paramMap) {
		List<ChlInfo> resut = null;
		resut = chlInfoDao.getListByMap(paramMap);
		return resut;
	}

	@Override
	public int update(ChlInfo entity) {
		return chlInfoDao.update(entity);
	}

	@Override
	public int deleteById(int id) {
		return chlInfoDao.deleteById(id);
	}

	@Override
	public int add(ChlInfo entity) {
		return chlInfoDao.add(entity);
	}

	@Override
	public int addList(List<ChlInfo> entityList) {
		return chlInfoDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<ChlInfo> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<ChlInfo> getActivedList() {
		List<ChlInfo> resut = null;
		ChlInfo entity = new ChlInfo();
		entity.setIsDeleted(0);
		resut = chlInfoDao.getList(entity);
		return resut;
	}
}