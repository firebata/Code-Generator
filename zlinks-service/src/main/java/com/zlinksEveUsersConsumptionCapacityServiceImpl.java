package com.zlinks.zlinks-service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.entity.EveUsersConsumptionCapacity;
import com.zlinks.zlinks-service.EveUsersConsumptionCapacityService;
import com.zlinks.zlinks-repsitory.EveUsersConsumptionCapacityDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * 类说明:
 *
 * Created by noname on 2018-7-7 15:28:42
 */
@Service("eveUsersConsumptionCapacityService")
public class EveUsersConsumptionCapacityServiceImpl extends BaseMybatisDao<EveUsersConsumptionCapacityDao> implements EveUsersConsumptionCapacityService {

	@Autowired
	private EveUsersConsumptionCapacityDao eveUsersConsumptionCapacityDao;

	@Override
	public EveUsersConsumptionCapacity getById(int id) {
		return eveUsersConsumptionCapacityDao.getById(id);
	}

	@Override
	public int getListCount(EveUsersConsumptionCapacity entity) {
		return eveUsersConsumptionCapacityDao.getListCount(entity);
	}

	@Override
	public List<EveUsersConsumptionCapacity> getList(EveUsersConsumptionCapacity entity) {
		List<EveUsersConsumptionCapacity> resut = null;
		resut = eveUsersConsumptionCapacityDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return eveUsersConsumptionCapacityDao.getListByMapCount(paramMap);
	}

	@Override
	public List<EveUsersConsumptionCapacity> getListByMap(Map<String, Object> paramMap) {
		List<EveUsersConsumptionCapacity> resut = null;
		resut = eveUsersConsumptionCapacityDao.getListByMap(paramMap);
		return resut;
	}

	@Override
	public int update(EveUsersConsumptionCapacity entity) {
		return eveUsersConsumptionCapacityDao.update(entity);
	}

	@Override
	public int deleteById(int id) {
		return eveUsersConsumptionCapacityDao.deleteById(id);
	}

	@Override
	public int add(EveUsersConsumptionCapacity entity) {
		return eveUsersConsumptionCapacityDao.add(entity);
	}

	@Override
	public int addList(List<EveUsersConsumptionCapacity> entityList) {
		return eveUsersConsumptionCapacityDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<EveUsersConsumptionCapacity> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<EveUsersConsumptionCapacity> getActivedList() {
		List<EveUsersConsumptionCapacity> resut = null;
		EveUsersConsumptionCapacity entity = new EveUsersConsumptionCapacity();
		entity.setIsDeleted(0);
		resut = eveUsersConsumptionCapacityDao.getList(entity);
		return resut;
	}
}