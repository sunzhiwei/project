package com.gome.gmhx.service.storeinfo.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gome.common.page.Page;
import com.gome.gmhx.dao.storeinfo.HxCurrentStockDao;
import com.gome.gmhx.service.storeinfo.HxCurrentStockService;

@Service("hxCurrentStockService")
public class HxCurrentStockServiceImpl implements HxCurrentStockService {

	@Resource
	private HxCurrentStockDao hxCurrentStockDao;
	
	@Override
	public List<Map<String, Object>> getHxCurrentStockPageList(Page page) {
		return hxCurrentStockDao.getHxCurrentStockPageList(page);
	}

}
