package com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/domain/.PrdInfo;
import com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.PrdInfoService;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/mapper/.PrdInfoDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * 类说明:
 *
 * Created by noname on 2018-7-7 15:34:59
 */
@Service("prdInfoService")
public class PrdInfoServiceImpl extends BaseMybatisDao<PrdInfoDao> implements PrdInfoService {

	@Autowired
	private PrdInfoDao prdInfoDao;

	@Override
	public PrdInfo getById(int id) {
		return prdInfoDao.getById(id);
	}

	@Override
	public int getListCount(PrdInfo entity) {
		return prdInfoDao.getListCount(entity);
	}

	@Override
	public List<PrdInfo> getList(PrdInfo entity) {
		List<PrdInfo> resut = null;
		resut = prdInfoDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return prdInfoDao.getListByMapCount(paramMap);
	}

	@Override
	public List<PrdInfo> getListByMap(Map<String, Object> paramMap) {
		List<PrdInfo> resut = null;
		resut = prdInfoDao.getListByMap(paramMap);
		return resut;
	}

	@Override
	public int update(PrdInfo entity) {
		return prdInfoDao.update(entity);
	}

	@Override
	public int deleteById(int id) {
		return prdInfoDao.deleteById(id);
	}

	@Override
	public int add(PrdInfo entity) {
		return prdInfoDao.add(entity);
	}

	@Override
	public int addList(List<PrdInfo> entityList) {
		return prdInfoDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<PrdInfo> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<PrdInfo> getActivedList() {
		List<PrdInfo> resut = null;
		PrdInfo entity = new PrdInfo();
		entity.setIsDeleted(0);
		resut = prdInfoDao.getList(entity);
		return resut;
	}
}