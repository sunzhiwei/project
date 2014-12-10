package com.gome.gmhx.service.servicemanage.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gome.common.page.Page;
import com.gome.gmhx.dao.servicemanage.HxServiceRetreatReplacementDao;
import com.gome.gmhx.entity.HxServiceRetreatReplacement;
import com.gome.gmhx.entity.SysUser;
import com.gome.gmhx.jbpm.JbpmProcessDefinations;
import com.gome.gmhx.jbpm.JbpmService;
import com.gome.gmhx.service.servicemanage.HxRetreatReplacementCreateService;

@Service("hxRetreatReplacementCreateService")
public class HxRetreatReplacementCreateServiceImpl implements HxRetreatReplacementCreateService {
	@Resource
	private HxServiceRetreatReplacementDao hxRetreatReplacementCreateDao;
	
	@Resource
	private JbpmService jbpmService;

	@Override
	public List<Map<String, Object>> getRetreatReplacementCreatePageList(Page page) {
		return hxRetreatReplacementCreateDao.getRetreatReplacementCreatePageList(page);
	}

	@Override
	public String saveRetreatReplacement(HxServiceRetreatReplacement retreatReplacement, SysUser sysUser) {
		SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
		String currentDateString = format.format(new Date());
		Integer sequence = hxRetreatReplacementCreateDao.getMaxSequence();
		String str = "";
		if(sequence!=null){
			str = String.format("%04d", ++sequence); 
		}else{
			sequence = 1 ;
			str = String.format("%04d", sequence); 
		}
		String applyId = "TR-"+currentDateString + str;
		retreatReplacement.setApplyId(applyId);
		retreatReplacement.setSequence(sequence);
		retreatReplacement.setStatus("S1");
		retreatReplacement.setIsPassCheck(false);
		retreatReplacement.setCreateMan(sysUser.getUserAccount());
		retreatReplacement.setCreateOrganization(sysUser.getCompanyId());
		retreatReplacement.setCreateTime(new Date());
		hxRetreatReplacementCreateDao.insertRetreatReplacement(retreatReplacement);
		return applyId;
	}

	@Override
	public HxServiceRetreatReplacement getRetreatReplacementById(String applyId) {
		return hxRetreatReplacementCreateDao.selectRetreatReplacementById(applyId);
	}

	@Override
	public String updateRetreatReplacement(HxServiceRetreatReplacement retreatReplacement, SysUser sysUser) {
		retreatReplacement.setAlterMan(sysUser.getUserAccount());
		retreatReplacement.setAlterOrganization(sysUser.getCompanyId());
		retreatReplacement.setAlterTime(new Date());
		hxRetreatReplacementCreateDao.updateRetreatReplacementById(retreatReplacement);
		return retreatReplacement.getApplyId();
	}

	@Override
	public void deleteRetreatReplacement(String serviceId) {
		hxRetreatReplacementCreateDao.deleteServiceTicketByPrimaryKey(serviceId);
	}

	@Override
	public void sendServiceTicket(String serviceId) {
		HxServiceRetreatReplacement retreatReplacement = hxRetreatReplacementCreateDao.selectRetreatReplacementById(serviceId);
		this.jbpmService.startProcessInstanceByKey(JbpmProcessDefinations.returnMachineApply, retreatReplacement);
		hxRetreatReplacementCreateDao.updateRetreatReplacementById(retreatReplacement);
	}
}
