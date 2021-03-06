package com.gome.gmhx.service.orgmanage.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gome.common.page.Page;
import com.gome.gmhx.dao.orgmanage.HxLimitDao;
import com.gome.gmhx.entity.HxLimit;
import com.gome.gmhx.service.orgmanage.HxLimitService;

@Service("hxLimitService")
public class HxLimitServiceImpl implements HxLimitService {
	@Resource
	private HxLimitDao hxLimitDao;

	@Override
	public List<Map<String, Object>> getLimitPageList(Page page) {
		return hxLimitDao.getLimitPageList(page);
	}

	@Override
	public void addLimit(HxLimit limit) {
		
		hxLimitDao.addLimit(limit);
	}
	
	@Override
	public HxLimit getLimitById(String limitId) {
		return hxLimitDao.getLimitById(limitId);
	}

	@Override
	public void updateLimit(HxLimit limit) {
		//关联初始化的记录主键
		limit.setLimitOriginId(getOriLimitByOrg(limit.getLimitOrgId()).getLimitId());
		hxLimitDao.addLimit(limit);
	}
	@Override
	public List<Map<String, Object>> getLimitHistoryPageList(Page page) {
		return hxLimitDao.getLimitHistoryPageList(page);
	}

	@Override
	public HxLimit getOriLimitByOrg(String limitOrgId) {
		return hxLimitDao.getOriLimitByOrg(limitOrgId);
	}

}
