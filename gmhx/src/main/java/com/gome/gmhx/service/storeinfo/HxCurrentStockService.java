package com.gome.gmhx.service.storeinfo;

import java.util.List;
import java.util.Map;

import com.gome.common.page.Page;

public interface HxCurrentStockService {

	public List<Map<String, Object>> getHxCurrentStockPageList(Page page);
}
