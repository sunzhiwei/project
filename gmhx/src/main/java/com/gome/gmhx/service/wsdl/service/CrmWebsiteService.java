package com.gome.gmhx.service.wsdl.service;

import java.util.List;
import java.util.Map;

import com.gome.gmhx.entity.CrmWebsite;
import com.gome.gmhx.entity.CustomerserviceSaleMapping;

public interface CrmWebsiteService{
	
	public void insertCrmwebsite(List<CrmWebsite> list);
	 
	public void delCrmwebsite();

	public boolean validateBarCode(String brand, String category, String productCode, String innerCode, String outerCode);
	
	public void delCustomerserviceSaleMapping();
	 
	public void insertCustomerserviceSaleMapping(List<CustomerserviceSaleMapping> list);

	public String insertResetPassword(String xmlData);

	public List<Map<String, Object>> queryAllWebsiteList();

	public void updateCrmwebsite(CrmWebsite crmWebsite);

	public void addCrmwebsite(CrmWebsite crmWebsite);

	public List<Map<String, Object>> queryAllCustomerserviceSaleMappingList();

	public void updateCustomerserviceSaleMapping(
			CustomerserviceSaleMapping customerserviceSaleMapping);

	public void addCustomerserviceSaleMapping(
			CustomerserviceSaleMapping customerserviceSaleMapping);
	 
}
