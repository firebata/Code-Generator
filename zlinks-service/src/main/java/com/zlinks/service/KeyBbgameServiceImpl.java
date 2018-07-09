package com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/domain/.KeyBbgame;
import com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.KeyBbgameService;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/mapper/.KeyBbgameDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * 类说明:
 *
 * Created by noname on 2018-7-7 15:34:58
 */
@Service("keyBbgameService")
public class KeyBbgameServiceImpl extends BaseMybatisDao<KeyBbgameDao> implements KeyBbgameService {

	@Autowired
	private KeyBbgameDao keyBbgameDao;

	@Override
	public KeyBbgame getById(int id) {
		return keyBbgameDao.getById(id);
	}

	@Override
	public int getListCount(KeyBbgame entity) {
		return keyBbgameDao.getListCount(entity);
	}

	@Override
	public List<KeyBbgame> getList(KeyBbgame entity) {
		List<KeyBbgame> resut = null;
		resut = keyBbgameDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return keyBbgameDao.getListByMapCount(paramMap);
	}

	@Override
	public List<KeyBbgame> getListByMap(Map<String, Object> paramMap) {
		List<KeyBbgame> resut = null;
		resut = keyBbgameDao.getListByMap(paramMap);
		return resut;
	}

	@Override
	public int update(KeyBbgame entity) {
		return keyBbgameDao.update(entity);
	}

	@Override
	public int deleteById(int id) {
		return keyBbgameDao.deleteById(id);
	}

	@Override
	public int add(KeyBbgame entity) {
		return keyBbgameDao.add(entity);
	}

	@Override
	public int addList(List<KeyBbgame> entityList) {
		return keyBbgameDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<KeyBbgame> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<KeyBbgame> getActivedList() {
		List<KeyBbgame> resut = null;
		KeyBbgame entity = new KeyBbgame();
		entity.setIsDeleted(0);
		resut = keyBbgameDao.getList(entity);
		return resut;
	}
}