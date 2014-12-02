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
		Map<String,Object> map = (Map<String, Object>) page.getParam();
		String inout = (String) map.get("inout");
		String fittingPositionType = (String) map.get("fittingPositionType");
		if("2".equals(inout) && "1".equals(fittingPositionType)){
			return this.hxInoutStockDao.getZbInStockHistoryPageList(page);
		}
		return this.hxInoutStockDao.getInoutSotckHistoryPageList(page);
	}

}
