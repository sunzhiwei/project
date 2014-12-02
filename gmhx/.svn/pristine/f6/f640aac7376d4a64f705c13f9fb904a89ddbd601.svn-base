package com.gome.gmhx.service.wsdl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.gome.gmhx.dao.basicdata.HxBarCodeRulesDao;
import com.gome.gmhx.dao.basicdata.HxCodeBarDao;
import com.gome.gmhx.dao.basicdata.HxProductDetailDao;
import com.gome.gmhx.dao.wsdl.EccDao;
import com.gome.gmhx.entity.EccBrand;
import com.gome.gmhx.entity.EccGoods;
import com.gome.gmhx.entity.EccGoodsCategory;
import com.gome.gmhx.entity.EccRegional;
import com.gome.gmhx.entity.EccRegionalSection;
import com.gome.gmhx.entity.EccSalesOrg;
import com.gome.gmhx.entity.EccSectionMapping;
import com.gome.gmhx.entity.EccStore;
import com.gome.gmhx.entity.HxBarCodeRules;
import com.gome.gmhx.entity.HxCodeBar;
import com.gome.gmhx.entity.HxProductDetail;
import com.gome.gmhx.entity.ValidateEccBarCode;
import com.gome.gmhx.service.wsdl.service.EccService;

@Service("eccService")
public class EccServiceImpl implements EccService {
	@Resource
	private EccDao eccDao;
	@Resource
	private HxProductDetailDao hxProductDetailDao;
	@Resource
	private HxBarCodeRulesDao hxBarCodeRulesDao;
	
	private HxCodeBarDao hxCodeBarDao;

	@Override
	public void handleEccBrand(List<EccBrand> list) {
		eccDao.clearEccBrand();
		eccDao.insertEccBrand(list);
	}

	@Override
	public void handleEccGoods(List<EccGoods> list) {
		eccDao.replaceEccGoods(list);
	}

	@Override
	public void handleEccGoodsCategory(List<EccGoodsCategory> list) {
		eccDao.clearEccGoodsCategory();
		eccDao.insertEccGoodsCategory(list);
	}

	@Override
	public void handleEccRegional(List<EccRegional> list) {
		eccDao.clearEccRegional();
		eccDao.insertEccRegional(list);
	}

	@Override
	public void handleEccRegionalSection(List<EccRegionalSection> list) {
		eccDao.clearEccRegionalSection();
		eccDao.insertEccRegionalSection(list);
	}

	@Override
	public void handleEccSalesOrg(List<EccSalesOrg> list) {
		eccDao.clearEccSalesOrg();
		eccDao.insertEccSalesOrg(list);
	}

	@Override
	public void handleEccSectionMapping(List<EccSectionMapping> list) {
		eccDao.clearEccSectionMapping();
		eccDao.insertEccSectionMapping(list);
	}

	@Override
	public void handleEccStore(List<EccStore> list) {
		eccDao.clearEccStore();
		eccDao.insertEccStore(list);
	}

	@Override
	public String validateHxBarCode(ValidateEccBarCode vebc) {
		return null;
	}

}
