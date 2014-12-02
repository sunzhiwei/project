package com.gome.gmhx.service.basicdata.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gome.common.page.Page;
import com.gome.gmhx.dao.basicdata.HxFittingDao;
import com.gome.gmhx.entity.HxFitting;
import com.gome.gmhx.entity.HxFittingModel;
import com.gome.gmhx.entity.HxFittingProvider;
import com.gome.gmhx.entity.vo.HxFittingVO;
import com.gome.gmhx.service.basicdata.HxFittingService;

@Service("hxFittingService")
public class HxFittingServiceImpl implements HxFittingService {
	
	@Resource
	private HxFittingDao hxFittingDao;

	@Override
	public List<Map<String, Object>> getHxFittingPageList(Page page) {
		return hxFittingDao.getHxFittingPageList(page);
	}

	@Override
	public void addHxFitting(HxFittingVO hxFittingVO) {
		HxFitting hxFitting = hxFittingVO.getFitting();
		List<HxFittingModel> suits = hxFittingVO.getSuits();
		List<HxFittingProvider> providers = hxFittingVO.getProviders();
		
		hxFittingDao.addHxFitting(hxFitting);
		
		if(suits != null && !suits.isEmpty()){
			Map<String, Object> suitMap = new HashMap<String, Object>();
			suitMap.put("fittingCode", hxFitting.getFittingCode());
			suitMap.put("list", suits);
			hxFittingDao.addHxFittingModel(suitMap);
		}
		
		if(providers != null && !providers.isEmpty()){
			Map<String, Object> providerMap = new HashMap<String, Object>();
			providerMap.put("fittingCode", hxFitting.getFittingCode());
			providerMap.put("list", hxFittingVO.getProviders());
			hxFittingDao.addHxFittingProvider(providerMap);
		}
	}


	public HxFitting getHxFittingByFittingCode(String fittingCode) {
		return hxFittingDao.getHxFittingByFittingCode(fittingCode);
	}

	public List<Map<String, Object>> getHxFittingModelByFittingCode(String fittingCode) {
		return hxFittingDao.getHxFittingModelByFittingCode(fittingCode);
	}

	public List<Map<String, Object>> getHxFittingProviderByFittingCode(String fittingCode) {
		return hxFittingDao.getHxFittingProviderByFittingCode(fittingCode);
	}

	@Override
	public void updateHxFitting(HxFittingVO hxFittingVO) {
		HxFitting hxFitting = hxFittingVO.getFitting();
		List<HxFittingModel> suits = hxFittingVO.getSuits();
		List<HxFittingProvider> providers = hxFittingVO.getProviders();
		
		hxFitting.setUpdateTime(new Date());
		hxFittingDao.updateHxFitting(hxFitting);
		
		if(suits != null && !suits.isEmpty()){
			Map<String, Object> suitMap = new HashMap<String, Object>();
			suitMap.put("fittingCode", hxFitting.getFittingCode());
			suitMap.put("list", suits);
			hxFittingDao.deleteModelByFittingCode(hxFitting.getFittingCode());
			hxFittingDao.addHxFittingModel(suitMap);
		}
		
		if(providers != null && !providers.isEmpty()){
			Map<String, Object> providerMap = new HashMap<String, Object>();
			providerMap.put("fittingCode", hxFitting.getFittingCode());
			providerMap.put("list", hxFittingVO.getProviders());
			hxFittingDao.deleteProviderByFittingCode(hxFitting.getFittingCode());
			hxFittingDao.addHxFittingProvider(providerMap);
		}
	}

	
}
