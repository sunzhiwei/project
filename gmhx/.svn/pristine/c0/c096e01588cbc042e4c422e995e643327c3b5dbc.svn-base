package com.gome.gmhx.service.orgmanage.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gome.common.page.Page;
import com.gome.common.util.UUIDGenerator;
import com.gome.gmhx.dao.orgmanage.HxExamineSettlementTicketDao;
import com.gome.gmhx.dao.servicemanage.HxServiceTicketDao;
import com.gome.gmhx.entity.HxExamineSettlementTicket;
import com.gome.gmhx.entity.HxSettlementDetail;
import com.gome.gmhx.service.orgmanage.HxExamineSettlementService;

@Service("hxExamineSettlementService")
public class HxExamineSettlementServiceImpl implements HxExamineSettlementService {
	
	@Resource
	HxServiceTicketDao serviceTicketDao;
	
	@Resource
	HxExamineSettlementTicketDao hxExamineSettlementTicketDao;
	
	@Override
	public List<Map<String, Object>> getExamineSettlementPageList(Page page) {
		return hxExamineSettlementTicketDao.getExamineSettlementPageList(page);
	}

	@Override
	public HxExamineSettlementTicket geExamineSettlementById(String settlementId) {
		return hxExamineSettlementTicketDao.geExamineSettlementById(settlementId);
	}

	@Override
	public List<Map<String, Object>> getOtherFeeGridById(String settlementId) {
		return hxExamineSettlementTicketDao.getOtherFeeGridById(settlementId);
	}

	@Override
	public List<Map<String, Object>> getSettlementFeeDetailGrid(String settlementId) {
		return hxExamineSettlementTicketDao.getSettlementFeeDetailGrid(settlementId);
	}

	@Override
	public void settlementFee(Date date) {
		//1、获取所有的网点信息（用户Id，公司Id，上级机构Id）
		//Date date = new Date();
		List<Map<String, Object>> list = serviceTicketDao.getExistWD(date);
		if(list.size()!=0){
			for(Map<String, Object> map : list){
				Object orgCode = map.get("serviceUnit");
				Object orgName = map.get("unitName");
				HxExamineSettlementTicket est = new HxExamineSettlementTicket();
				est.setServiceUnit(orgCode.toString());
				est.setSettlementTime(date);
				
				// 维修单
				est.setSettlementType("01");
				createSettlementTicket(est);
				
				// 安装单
				est.setSettlementType("02");
				createSettlementTicket(est);
				
				// 保外销售单
				//est.setSettlementType("03");
				//createSettlementTicket(est);
				
			}
		}
	}
	
	public void createSettlementTicket(HxExamineSettlementTicket est){
		List<HxSettlementDetail> RTickets = getServiceTicket(est);
		if(RTickets.size()!=0){
			
			String unit = est.getServiceUnit();
			List<Map<String, Object>> list = serviceTicketDao.getServiceUnit(unit);
			if(list.size()!=0){
				Map<String, Object> m = list.get(0);
				Object o = m.get("serviceUnit");
				String s = o.toString();
				est.setParentOrganization(s);
			}
			// 生成结算单号
			est.setSettlementId(UUIDGenerator.getUUID());
			
			List<HxSettlementDetail> hsds = new ArrayList<HxSettlementDetail>();
			Float settlementFee = new Float(0.0);
			Float manageFee = new Float(0.0);
			Float serviceFee = new Float(0.0);
			for(HxSettlementDetail mp : RTickets){
				mp.setSettlementId(est.getSettlementId());
				if(mp.getSettlementFee()!=null){
					settlementFee += mp.getSettlementFee();
				}
				if(mp.getManagementFee()!=null){
					manageFee += mp.getManagementFee();
				}
				if(mp.getServiceFee()!=null){
					serviceFee += mp.getServiceFee();
				}
				hsds.add(mp);
			}
			est.setSettlementFee(settlementFee);
			est.setSettlementFactor(1);
			est.setServiceFee(serviceFee);
			est.setOtherFee(new Float(0.0));
			est.setFakeDeductFactor(0);
			est.setSettlementStatus("S1");
			est.setCreateMan("系统管理员");
			est.setCreateTime(new Date());
			
			hxExamineSettlementTicketDao.insertExamineSettlementTicket(est);
			hxExamineSettlementTicketDao.insertSettlementDetails(hsds);
		}
		
		
		
	}
	
	public List<HxSettlementDetail> getServiceTicket(HxExamineSettlementTicket est){
		if(est.getSettlementType()=="01"||est.getSettlementType()=="02"){
			List<HxSettlementDetail> settlementTickets= serviceTicketDao.getStandardSettlementTicket(est);
			return settlementTickets;
		}else if(est.getSettlementType()=="03"){
			List<HxSettlementDetail> settlementTickets= serviceTicketDao.getOverproofSettlementTicket(est);
			return settlementTickets;
		}
		return null;
	}
	
}
