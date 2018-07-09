package com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/domain/.RoleInfo;
import com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.RoleInfoService;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/mapper/.RoleInfoDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * 类说明:
 *
 * Created by noname on 2018-7-7 15:34:59
 */
@Service("roleInfoService")
public class RoleInfoServiceImpl extends BaseMybatisDao<RoleInfoDao> implements RoleInfoService {

	@Autowired
	private RoleInfoDao roleInfoDao;

	@Override
	public RoleInfo getById(int id) {
		return roleInfoDao.getById(id);
	}

	@Override
	public int getListCount(RoleInfo entity) {
		return roleInfoDao.getListCount(entity);
	}

	@Override
	public List<RoleInfo> getList(RoleInfo entity) {
		List<RoleInfo> resut = null;
		resut = roleInfoDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return roleInfoDao.getListByMapCount(paramMap);
	}

	@Override
	public List<RoleInfo> getListByMap(Map<String, Object> paramMap) {
		List<RoleInfo> resut = null;
		resut = roleInfoDao.getListByMap(paramMap);
		return resut;
	}

	@Override
	public int update(RoleInfo entity) {
		return roleInfoDao.update(entity);
	}

	@Override
	public int deleteById(int id) {
		return roleInfoDao.deleteById(id);
	}

	@Override
	public int add(RoleInfo entity) {
		return roleInfoDao.add(entity);
	}

	@Override
	public int addList(List<RoleInfo> entityList) {
		return roleInfoDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<RoleInfo> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<RoleInfo> getActivedList() {
		List<RoleInfo> resut = null;
		RoleInfo entity = new RoleInfo();
		entity.setIsDeleted(0);
		resut = roleInfoDao.getList(entity);
		return resut;
	}
}