package com.zlinks.zlinks-service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.entity.HisUsrGmeAccLvl;
import com.zlinks.zlinks-service.HisUsrGmeAccLvlService;
import com.zlinks.zlinks-repsitory.HisUsrGmeAccLvlDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * 类说明:
 *
 * Created by noname on 2018-7-7 15:28:42
 */
@Service("hisUsrGmeAccLvlService")
public class HisUsrGmeAccLvlServiceImpl extends BaseMybatisDao<HisUsrGmeAccLvlDao> implements HisUsrGmeAccLvlService {

	@Autowired
	private HisUsrGmeAccLvlDao hisUsrGmeAccLvlDao;

	@Override
	public HisUsrGmeAccLvl getById(int id) {
		return hisUsrGmeAccLvlDao.getById(id);
	}

	@Override
	public int getListCount(HisUsrGmeAccLvl entity) {
		return hisUsrGmeAccLvlDao.getListCount(entity);
	}

	@Override
	public List<HisUsrGmeAccLvl> getList(HisUsrGmeAccLvl entity) {
		List<HisUsrGmeAccLvl> resut = null;
		resut = hisUsrGmeAccLvlDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return hisUsrGmeAccLvlDao.getListByMapCount(paramMap);
	}

	@Override
	public List<HisUsrGmeAccLvl> getListByMap(Map<String, Object> paramMap) {
		List<HisUsrGmeAccLvl> resut = null;
		resut = hisUsrGmeAccLvlDao.getListByMap(paramMap);
		return resut;
	}

	@Override
	public int update(HisUsrGmeAccLvl entity) {
		return hisUsrGmeAccLvlDao.update(entity);
	}

	@Override
	public int deleteById(int id) {
		return hisUsrGmeAccLvlDao.deleteById(id);
	}

	@Override
	public int add(HisUsrGmeAccLvl entity) {
		return hisUsrGmeAccLvlDao.add(entity);
	}

	@Override
	public int addList(List<HisUsrGmeAccLvl> entityList) {
		return hisUsrGmeAccLvlDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<HisUsrGmeAccLvl> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<HisUsrGmeAccLvl> getActivedList() {
		List<HisUsrGmeAccLvl> resut = null;
		HisUsrGmeAccLvl entity = new HisUsrGmeAccLvl();
		entity.setIsDeleted(0);
		resut = hisUsrGmeAccLvlDao.getList(entity);
		return resut;
	}
}