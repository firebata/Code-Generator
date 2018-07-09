package com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/domain/.KeyThird;
import com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.KeyThirdService;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/mapper/.KeyThirdDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * 类说明:
 *
 * Created by noname on 2018-7-7 15:34:58
 */
@Service("keyThirdService")
public class KeyThirdServiceImpl extends BaseMybatisDao<KeyThirdDao> implements KeyThirdService {

	@Autowired
	private KeyThirdDao keyThirdDao;

	@Override
	public KeyThird getById(int id) {
		return keyThirdDao.getById(id);
	}

	@Override
	public int getListCount(KeyThird entity) {
		return keyThirdDao.getListCount(entity);
	}

	@Override
	public List<KeyThird> getList(KeyThird entity) {
		List<KeyThird> resut = null;
		resut = keyThirdDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return keyThirdDao.getListByMapCount(paramMap);
	}

	@Override
	public List<KeyThird> getListByMap(Map<String, Object> paramMap) {
		List<KeyThird> resut = null;
		resut = keyThirdDao.getListByMap(paramMap);
		return resut;
	}

	@Override
	public int update(KeyThird entity) {
		return keyThirdDao.update(entity);
	}

	@Override
	public int deleteById(int id) {
		return keyThirdDao.deleteById(id);
	}

	@Override
	public int add(KeyThird entity) {
		return keyThirdDao.add(entity);
	}

	@Override
	public int addList(List<KeyThird> entityList) {
		return keyThirdDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<KeyThird> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<KeyThird> getActivedList() {
		List<KeyThird> resut = null;
		KeyThird entity = new KeyThird();
		entity.setIsDeleted(0);
		resut = keyThirdDao.getList(entity);
		return resut;
	}
}