package com.gome.gmhx.service.storeinfo.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gome.common.page.Page;
import com.gome.gmhx.dao.storeinfo.HxInoutStockDao;
import com.gome.gmhx.service.storeinfo.HxInoutStockService;

@Service("hxInoutStockService")
public class HxInoutStockServiceImpl implements HxInoutStockService {
	
	@Resource
	private HxInoutStockDao hxInoutStockDao;
	@Override
	public List<Map<String, Object>> getInoutSotckHistoryPageList(Page page) {
		return this.hxInoutStockDao.getInoutSotckHistoryPageList(page);
	}

}
