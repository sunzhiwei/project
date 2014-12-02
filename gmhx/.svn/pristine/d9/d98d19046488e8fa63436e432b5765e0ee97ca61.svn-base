package com.gome.gmhx.webservice.wsdl;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.gome.gmhx.entity.CrmWebsite;
import com.gome.gmhx.entity.CustomerserviceSaleMapping;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface CrmWebsiteWService {
	public void handleCrmwebsite(List<CrmWebsite> list);
	
	public boolean validateBarCode(String brand,String category, String productCode, String innerCode, String outerCode);
	
	public void handleCustomerserviceSaleMapping(List<CustomerserviceSaleMapping> list);
	
	public String handleResetPassword(String xmlData);
}
