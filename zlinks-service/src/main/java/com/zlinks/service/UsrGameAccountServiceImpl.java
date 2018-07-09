package com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/domain/.UsrGameAccount;
import com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.UsrGameAccountService;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/mapper/.UsrGameAccountDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * 类说明:
 *
 * Created by noname on 2018-7-7 15:34:59
 */
@Service("usrGameAccountService")
public class UsrGameAccountServiceImpl extends BaseMybatisDao<UsrGameAccountDao> implements UsrGameAccountService {

	@Autowired
	private UsrGameAccountDao usrGameAccountDao;

	@Override
	public UsrGameAccount getById(int id) {
		return usrGameAccountDao.getById(id);
	}

	@Override
	public int getListCount(UsrGameAccount entity) {
		return usrGameAccountDao.getListCount(entity);
	}

	@Override
	public List<UsrGameAccount> getList(UsrGameAccount entity) {
		List<UsrGameAccount> resut = null;
		resut = usrGameAccountDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return usrGameAccountDao.getListByMapCount(paramMap);
	}

	@Override
	public List<UsrGameAccount> getListByMap(Map<String, Object> paramMap) {
		List<UsrGameAccount> resut = null;
		resut = usrGameAccountDao.getListByMap(paramMap);
		return resut;
	}

	@Override
	public int update(UsrGameAccount entity) {
		return usrGameAccountDao.update(entity);
	}

	@Override
	public int deleteById(int id) {
		return usrGameAccountDao.deleteById(id);
	}

	@Override
	public int add(UsrGameAccount entity) {
		return usrGameAccountDao.add(entity);
	}

	@Override
	public int addList(List<UsrGameAccount> entityList) {
		return usrGameAccountDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<UsrGameAccount> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<UsrGameAccount> getActivedList() {
		List<UsrGameAccount> resut = null;
		UsrGameAccount entity = new UsrGameAccount();
		entity.setIsDeleted(0);
		resut = usrGameAccountDao.getList(entity);
		return resut;
	}
}