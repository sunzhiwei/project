package com.gome.gmhx.webservice.wsdl.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import org.springframework.stereotype.Component;

import com.gome.gmhx.entity.JlInstall;
import com.gome.gmhx.entity.JlAccount;
import com.gome.gmhx.entity.JlRepair;
import com.gome.gmhx.entity.JlRepairMeasures;
import com.gome.gmhx.entity.JlRepairParts;
import com.gome.gmhx.service.wsdl.service.JlInstallService;
import com.gome.gmhx.service.wsdl.service.JlAccountService;
import com.gome.gmhx.service.wsdl.service.JlRepaireService;
import com.gome.gmhx.webservice.wsdl.JlWService;

@WebService  
@SOAPBinding(style = Style.DOCUMENT) 
@Component("jlWServiceBean")
public class JlWServiceImpl implements JlWService {
	
	@Resource
	private JlInstallService installService;
	
	@Resource
	private JlAccountService accountService;
	
	@Resource
	private JlRepaireService repaireService;

	@Override
	public String saveInstall(List<JlInstall> installs) {
		for(JlInstall install:installs){
			installService.insertInstall(install);
		}
		return "ok";
	}

	@Override
	public String saveAccount(List<JlAccount> accounts) {
		for(JlAccount account:accounts){
			accountService.insertAccount(account);
		}
		return "ok";
	}

	@Override
	public String saveRepair(List<JlRepair> repairs) {
		for(JlRepair repair:repairs){
			repaireService.insertRepair(repair);
		}
		return "ok";
	}

	@Override
	public String saveRepairParts(List<JlRepairParts> repairParts) {
		for(JlRepairParts repairPart:repairParts){
			repaireService.insertRepairPart(repairPart);
		}
		return "ok";
	}

	@Override
	public String saveRepairMeasures(List<JlRepairMeasures> repairMeasures) {
		for(JlRepairMeasures repairMeasure:repairMeasures){
			repaireService.insertRepairMeasure(repairMeasure);
		}
		return "ok";
	}

}
