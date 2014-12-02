package com.gome.gmhx.webservice.wsdl.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.gome.gmhx.entity.CrmWebsite;
import com.gome.gmhx.entity.CustomerserviceSaleMapping;
import com.gome.gmhx.service.wsdl.service.CrmWebsiteService;
import com.gome.gmhx.webservice.wsdl.CrmWebsiteWService;

@WebService  
@SOAPBinding(style = Style.DOCUMENT)
@Component("crmWebsiteWServiceBean")
public class CrmWebsiteWServiceImpl implements CrmWebsiteWService {
	@Resource
	private CrmWebsiteService crmWebsiteService;
	
	
	@Override
	public void handleCrmwebsite(List<CrmWebsite> list){
		//全量
		//crmWebsiteService.delCrmwebsite();
		//crmWebsiteService.insertCrmwebsite(list);
		//增量
		List<Map<String, Object>> result = crmWebsiteService.queryAllWebsiteList();
		List<String> iddataList = new ArrayList<String>();
		for(Map<String, Object> mapData : result){
			String azwd01 = (String) mapData.get("azwd01");
			String gsxx01 = (String) mapData.get("gsxx01");
			String id = "";
			if(StringUtils.isNotBlank(azwd01)&&StringUtils.isNotBlank(gsxx01)){
				id = azwd01 + "_" + gsxx01;
				iddataList.add(id);
			}
		}
		for(CrmWebsite crmWebsite : list){
			String partner = crmWebsite.getPartner();// 网点编码
			String sales_org = crmWebsite.getSales_org(); // 公司代码
			String id = partner + "_" + sales_org;
			if(iddataList.contains(id)){
				crmWebsiteService.updateCrmwebsite(crmWebsite);
			}else{
				crmWebsiteService.addCrmwebsite(crmWebsite);
			}
		}
	}

	@Override
	public boolean validateBarCode(String brand,String category, String productCode, String innerCode, String outerCode) {
		return crmWebsiteService.validateBarCode(brand, category, productCode, innerCode, outerCode);
	}

	@Override
	public void handleCustomerserviceSaleMapping(
			List<CustomerserviceSaleMapping> list) {
		// 全量
		// crmWebsiteService.delCustomerserviceSaleMapping();
		// crmWebsiteService.insertCustomerserviceSaleMapping(list);
		// 增量
		List<Map<String, Object>> result = crmWebsiteService
				.queryAllCustomerserviceSaleMappingList();
		List<String> iddataList = new ArrayList<String>();
		for (Map<String, Object> mapData : result) {
			String number_int = (String) mapData.get("number_int");
			if (StringUtils.isNotBlank(number_int)) {
				iddataList.add(number_int);
			}
		}
		for (CustomerserviceSaleMapping customerserviceSaleMapping : list) {
			String number_int = customerserviceSaleMapping.getNumber_int();// 网点编码
			if (iddataList.contains(number_int)) {
				crmWebsiteService.updateCustomerserviceSaleMapping(customerserviceSaleMapping);
			} else {
				crmWebsiteService.addCustomerserviceSaleMapping(customerserviceSaleMapping);
			}
		}
	}

	@Override
	public String handleResetPassword(String xmlData) {
		return crmWebsiteService.insertResetPassword(xmlData);
	}
    
}
