package com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/domain/.GmeNotifyUrlCopy;
import com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.GmeNotifyUrlCopyService;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/mapper/.GmeNotifyUrlCopyDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * 类说明:
 *
 * Created by noname on 2018-7-7 15:34:58
 */
@Service("gmeNotifyUrlCopyService")
public class GmeNotifyUrlCopyServiceImpl extends BaseMybatisDao<GmeNotifyUrlCopyDao> implements GmeNotifyUrlCopyService {

	@Autowired
	private GmeNotifyUrlCopyDao gmeNotifyUrlCopyDao;

	@Override
	public GmeNotifyUrlCopy getById(int id) {
		return gmeNotifyUrlCopyDao.getById(id);
	}

	@Override
	public int getListCount(GmeNotifyUrlCopy entity) {
		return gmeNotifyUrlCopyDao.getListCount(entity);
	}

	@Override
	public List<GmeNotifyUrlCopy> getList(GmeNotifyUrlCopy entity) {
		List<GmeNotifyUrlCopy> resut = null;
		resut = gmeNotifyUrlCopyDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return gmeNotifyUrlCopyDao.getListByMapCount(paramMap);
	}

	@Override
	public List<GmeNotifyUrlCopy> getListByMap(Map<String, Object> paramMap) {
		List<GmeNotifyUrlCopy> resut = null;
		resut = gmeNotifyUrlCopyDao.getListByMap(paramMap);
		return resut;
	}

	@Override
	public int update(GmeNotifyUrlCopy entity) {
		return gmeNotifyUrlCopyDao.update(entity);
	}

	@Override
	public int deleteById(int id) {
		return gmeNotifyUrlCopyDao.deleteById(id);
	}

	@Override
	public int add(GmeNotifyUrlCopy entity) {
		return gmeNotifyUrlCopyDao.add(entity);
	}

	@Override
	public int addList(List<GmeNotifyUrlCopy> entityList) {
		return gmeNotifyUrlCopyDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<GmeNotifyUrlCopy> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<GmeNotifyUrlCopy> getActivedList() {
		List<GmeNotifyUrlCopy> resut = null;
		GmeNotifyUrlCopy entity = new GmeNotifyUrlCopy();
		entity.setIsDeleted(0);
		resut = gmeNotifyUrlCopyDao.getList(entity);
		return resut;
	}
}