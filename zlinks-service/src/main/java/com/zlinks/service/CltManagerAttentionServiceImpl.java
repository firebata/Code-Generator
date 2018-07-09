package com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/domain/.CltManagerAttention;
import com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.CltManagerAttentionService;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/mapper/.CltManagerAttentionDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * 类说明:
 *
 * Created by noname on 2018-7-7 15:34:58
 */
@Service("cltManagerAttentionService")
public class CltManagerAttentionServiceImpl extends BaseMybatisDao<CltManagerAttentionDao> implements CltManagerAttentionService {

	@Autowired
	private CltManagerAttentionDao cltManagerAttentionDao;

	@Override
	public CltManagerAttention getById(int id) {
		return cltManagerAttentionDao.getById(id);
	}

	@Override
	public int getListCount(CltManagerAttention entity) {
		return cltManagerAttentionDao.getListCount(entity);
	}

	@Override
	public List<CltManagerAttention> getList(CltManagerAttention entity) {
		List<CltManagerAttention> resut = null;
		resut = cltManagerAttentionDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return cltManagerAttentionDao.getListByMapCount(paramMap);
	}

	@Override
	public List<CltManagerAttention> getListByMap(Map<String, Object> paramMap) {
		List<CltManagerAttention> resut = null;
		resut = cltManagerAttentionDao.getListByMap(paramMap);
		return resut;
	}

	@Override
	public int update(CltManagerAttention entity) {
		return cltManagerAttentionDao.update(entity);
	}

	@Override
	public int deleteById(int id) {
		return cltManagerAttentionDao.deleteById(id);
	}

	@Override
	public int add(CltManagerAttention entity) {
		return cltManagerAttentionDao.add(entity);
	}

	@Override
	public int addList(List<CltManagerAttention> entityList) {
		return cltManagerAttentionDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<CltManagerAttention> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<CltManagerAttention> getActivedList() {
		List<CltManagerAttention> resut = null;
		CltManagerAttention entity = new CltManagerAttention();
		entity.setIsDeleted(0);
		resut = cltManagerAttentionDao.getList(entity);
		return resut;
	}
}