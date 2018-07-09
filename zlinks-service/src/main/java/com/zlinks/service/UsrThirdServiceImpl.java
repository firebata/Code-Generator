package com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/domain/.UsrThird;
import com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.UsrThirdService;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/mapper/.UsrThirdDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * 类说明:
 *
 * Created by noname on 2018-7-7 15:34:59
 */
@Service("usrThirdService")
public class UsrThirdServiceImpl extends BaseMybatisDao<UsrThirdDao> implements UsrThirdService {

	@Autowired
	private UsrThirdDao usrThirdDao;

	@Override
	public UsrThird getById(int id) {
		return usrThirdDao.getById(id);
	}

	@Override
	public int getListCount(UsrThird entity) {
		return usrThirdDao.getListCount(entity);
	}

	@Override
	public List<UsrThird> getList(UsrThird entity) {
		List<UsrThird> resut = null;
		resut = usrThirdDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return usrThirdDao.getListByMapCount(paramMap);
	}

	@Override
	public List<UsrThird> getListByMap(Map<String, Object> paramMap) {
		List<UsrThird> resut = null;
		resut = usrThirdDao.getListByMap(paramMap);
		return resut;
	}

	@Override
	public int update(UsrThird entity) {
		return usrThirdDao.update(entity);
	}

	@Override
	public int deleteById(int id) {
		return usrThirdDao.deleteById(id);
	}

	@Override
	public int add(UsrThird entity) {
		return usrThirdDao.add(entity);
	}

	@Override
	public int addList(List<UsrThird> entityList) {
		return usrThirdDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<UsrThird> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<UsrThird> getActivedList() {
		List<UsrThird> resut = null;
		UsrThird entity = new UsrThird();
		entity.setIsDeleted(0);
		resut = usrThirdDao.getList(entity);
		return resut;
	}
}