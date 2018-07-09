package com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/domain/.OrdPayDetail;
import com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.OrdPayDetailService;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/mapper/.OrdPayDetailDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * 类说明:
 *
 * Created by noname on 2018-7-7 15:34:59
 */
@Service("ordPayDetailService")
public class OrdPayDetailServiceImpl extends BaseMybatisDao<OrdPayDetailDao> implements OrdPayDetailService {

	@Autowired
	private OrdPayDetailDao ordPayDetailDao;

	@Override
	public OrdPayDetail getById(int id) {
		return ordPayDetailDao.getById(id);
	}

	@Override
	public int getListCount(OrdPayDetail entity) {
		return ordPayDetailDao.getListCount(entity);
	}

	@Override
	public List<OrdPayDetail> getList(OrdPayDetail entity) {
		List<OrdPayDetail> resut = null;
		resut = ordPayDetailDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return ordPayDetailDao.getListByMapCount(paramMap);
	}

	@Override
	public List<OrdPayDetail> getListByMap(Map<String, Object> paramMap) {
		List<OrdPayDetail> resut = null;
		resut = ordPayDetailDao.getListByMap(paramMap);
		return resut;
	}

	@Override
	public int update(OrdPayDetail entity) {
		return ordPayDetailDao.update(entity);
	}

	@Override
	public int deleteById(int id) {
		return ordPayDetailDao.deleteById(id);
	}

	@Override
	public int add(OrdPayDetail entity) {
		return ordPayDetailDao.add(entity);
	}

	@Override
	public int addList(List<OrdPayDetail> entityList) {
		return ordPayDetailDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<OrdPayDetail> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<OrdPayDetail> getActivedList() {
		List<OrdPayDetail> resut = null;
		OrdPayDetail entity = new OrdPayDetail();
		entity.setIsDeleted(0);
		resut = ordPayDetailDao.getList(entity);
		return resut;
	}
}