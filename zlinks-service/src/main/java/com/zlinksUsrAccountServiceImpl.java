package com.zlinks.zlinks-service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.entity.UsrAccount;
import com.zlinks.zlinks-service.UsrAccountService;
import com.zlinks.zlinks-repsitory.UsrAccountDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * 类说明:
 *
 * Created by noname on 2018-7-7 15:28:43
 */
@Service("usrAccountService")
public class UsrAccountServiceImpl extends BaseMybatisDao<UsrAccountDao> implements UsrAccountService {

	@Autowired
	private UsrAccountDao usrAccountDao;

	@Override
	public UsrAccount getById(int id) {
		return usrAccountDao.getById(id);
	}

	@Override
	public int getListCount(UsrAccount entity) {
		return usrAccountDao.getListCount(entity);
	}

	@Override
	public List<UsrAccount> getList(UsrAccount entity) {
		List<UsrAccount> resut = null;
		resut = usrAccountDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return usrAccountDao.getListByMapCount(paramMap);
	}

	@Override
	public List<UsrAccount> getListByMap(Map<String, Object> paramMap) {
		List<UsrAccount> resut = null;
		resut = usrAccountDao.getListByMap(paramMap);
		return resut;
	}

	@Override
	public int update(UsrAccount entity) {
		return usrAccountDao.update(entity);
	}

	@Override
	public int deleteById(int id) {
		return usrAccountDao.deleteById(id);
	}

	@Override
	public int add(UsrAccount entity) {
		return usrAccountDao.add(entity);
	}

	@Override
	public int addList(List<UsrAccount> entityList) {
		return usrAccountDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<UsrAccount> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<UsrAccount> getActivedList() {
		List<UsrAccount> resut = null;
		UsrAccount entity = new UsrAccount();
		entity.setIsDeleted(0);
		resut = usrAccountDao.getList(entity);
		return resut;
	}
}