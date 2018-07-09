package com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/domain/.Temp;
import com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.TempService;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/mapper/.TempDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * 类说明:
 *
 * Created by noname on 2018-7-7 15:34:59
 */
@Service("tempService")
public class TempServiceImpl extends BaseMybatisDao<TempDao> implements TempService {

	@Autowired
	private TempDao tempDao;

	@Override
	public Temp getById(int id) {
		return tempDao.getById(id);
	}

	@Override
	public int getListCount(Temp entity) {
		return tempDao.getListCount(entity);
	}

	@Override
	public List<Temp> getList(Temp entity) {
		List<Temp> resut = null;
		resut = tempDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return tempDao.getListByMapCount(paramMap);
	}

	@Override
	public List<Temp> getListByMap(Map<String, Object> paramMap) {
		List<Temp> resut = null;
		resut = tempDao.getListByMap(paramMap);
		return resut;
	}

	@Override
	public int update(Temp entity) {
		return tempDao.update(entity);
	}

	@Override
	public int deleteById(int id) {
		return tempDao.deleteById(id);
	}

	@Override
	public int add(Temp entity) {
		return tempDao.add(entity);
	}

	@Override
	public int addList(List<Temp> entityList) {
		return tempDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<Temp> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<Temp> getActivedList() {
		List<Temp> resut = null;
		Temp entity = new Temp();
		entity.setIsDeleted(0);
		resut = tempDao.getList(entity);
		return resut;
	}
}