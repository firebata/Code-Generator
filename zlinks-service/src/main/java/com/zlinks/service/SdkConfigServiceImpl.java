package com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/domain/.SdkConfig;
import com.zlinks.zlinks-service/src/main/java/com/zlinks/service/.SdkConfigService;
import com.zlinks.zlinks-repository/src/main/java/com/zlinks/mapper/.SdkConfigDao;
import java.util.List;
import java.util.Map;

import com.hpxs.base.BaseMybatisDao;
import com.zlinks.core.mybatis.page.Pagination;

/**
 * 类说明:
 *
 * Created by noname on 2018-7-7 15:34:59
 */
@Service("sdkConfigService")
public class SdkConfigServiceImpl extends BaseMybatisDao<SdkConfigDao> implements SdkConfigService {

	@Autowired
	private SdkConfigDao sdkConfigDao;

	@Override
	public SdkConfig getById(int id) {
		return sdkConfigDao.getById(id);
	}

	@Override
	public int getListCount(SdkConfig entity) {
		return sdkConfigDao.getListCount(entity);
	}

	@Override
	public List<SdkConfig> getList(SdkConfig entity) {
		List<SdkConfig> resut = null;
		resut = sdkConfigDao.getList(entity);
		return resut;
	}

	@Override
	public int getListByMapCount(Map<String, Object> paramMap) {
		return sdkConfigDao.getListByMapCount(paramMap);
	}

	@Override
	public List<SdkConfig> getListByMap(Map<String, Object> paramMap) {
		List<SdkConfig> resut = null;
		resut = sdkConfigDao.getListByMap(paramMap);
		return resut;
	}

	@Override
	public int update(SdkConfig entity) {
		return sdkConfigDao.update(entity);
	}

	@Override
	public int deleteById(int id) {
		return sdkConfigDao.deleteById(id);
	}

	@Override
	public int add(SdkConfig entity) {
		return sdkConfigDao.add(entity);
	}

	@Override
	public int addList(List<SdkConfig> entityList) {
		return sdkConfigDao.addList(entityList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<SdkConfig> findPage(Map<String,Object> paramMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(paramMap, pageNo, pageSize);
	}

	@Override
	public List<SdkConfig> getActivedList() {
		List<SdkConfig> resut = null;
		SdkConfig entity = new SdkConfig();
		entity.setIsDeleted(0);
		resut = sdkConfigDao.getList(entity);
		return resut;
	}
}