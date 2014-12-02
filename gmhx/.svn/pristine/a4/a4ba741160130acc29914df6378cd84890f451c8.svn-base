package com.gome.gmhx.controller.orgmanage;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gome.common.page.Page;
import com.gome.common.util.BeanMapUtils;
import com.gome.common.util.JsonUtil;
import com.gome.gmhx.entity.HxExamineSettlementTicket;
import com.gome.gmhx.service.orgmanage.HxExamineSettlementService;
import com.gome.gmhx.service.servicemanage.HxInstallReceiptService;
import com.gome.gmhx.service.servicemanage.HxRepairReceiptService;

@Controller
@RequestMapping(value="/hxExamineSettlement")
public class HxExamineSettlementController {
	
	@Resource
	HxExamineSettlementService hxExamineSettlementService;
	
	@Resource
	private HxInstallReceiptService installReceiptService;
	
	@Resource
	private HxRepairReceiptService repairReceiptService;
	
	@RequestMapping(value="/examineSettlementView")
	public String limitView(){
		return "orgmanage/hxExamineSettlement/examineSettlementList";
	}
	
	@RequestMapping(value="/goTest")
	public String goTest(){
		return "orgmanage/hxExamineSettlement/test";
	}
	
	@RequestMapping(value="/test",produces="text/plain;charset=utf-8")
	@ResponseBody
	public void test(){
		Date date = new Date();
		hxExamineSettlementService.settlementFee(date);
	}
	
	@RequestMapping(value="/getExamineSettlementPageList", produces="text/plain;charset=utf-8")
	@ResponseBody
	public String getExamineSettlementPageList(HttpServletResponse response, Page page, HxExamineSettlementTicket hxExamineSettlementTicket,
			String serviceUnitName,
			@DateTimeFormat(pattern="yyyy-MM-dd")Date settlementTime_st,
			@DateTimeFormat(pattern="yyyy-MM-dd")Date settlementTime_end,
			@DateTimeFormat(pattern="yyyy-MM-dd")Date headquartersCheckTime_st,
			@DateTimeFormat(pattern="yyyy-MM-dd")Date headquartersCheckTime_end,
			@DateTimeFormat(pattern="yyyy-MM-dd")Date settlementUnitConfirmTime_st,
			@DateTimeFormat(pattern="yyyy-MM-dd")Date settlementUnitConfirmTime_end,
			@DateTimeFormat(pattern="yyyy-MM-dd")Date createTime_st,
			@DateTimeFormat(pattern="yyyy-MM-dd")Date createTime_end,
			@DateTimeFormat(pattern="yyyy-MM-dd")Date alterTime_st,
			@DateTimeFormat(pattern="yyyy-MM-dd")Date alterTime_end
			) throws Exception{
		Map <String , Object> map =BeanMapUtils.convertBean(hxExamineSettlementTicket);
		map.put("settlementTime_st", settlementTime_st);
		map.put("settlementTime_end", settlementTime_end);
		map.put("headquartersCheckTime_st", headquartersCheckTime_st);
		map.put("headquartersCheckTime_end", headquartersCheckTime_end);
		map.put("settlementUnitConfirmTime_st", settlementUnitConfirmTime_st);
		map.put("settlementUnitConfirmTime_end", settlementUnitConfirmTime_end);
		map.put("createTime_st", createTime_st);
		map.put("createTime_end", createTime_end);
		map.put("alterTime_st", alterTime_st);
		map.put("alterTime_end", alterTime_end);
		page.setParam(map);
		List<Map<String, Object>> list = hxExamineSettlementService.getExamineSettlementPageList(page);
		return JsonUtil.writeListToDataGrid(page.getTotalResult(), list);
	}
	
	@RequestMapping(value="/examineSettlementShow/{settlementId}")
	@ResponseBody
	public ModelAndView examineSettlementShow(@PathVariable String settlementId){
		ModelAndView mav = new ModelAndView("orgmanage/hxExamineSettlement/examineSettlementShow");
		HxExamineSettlementTicket es = hxExamineSettlementService.geExamineSettlementById(settlementId);
		mav.addObject("es", es);
		return mav;
	}
	
	@RequestMapping(value="/getSettlementFeeDetailGrid/{settlementId}", produces="text/plain;charset=utf-8")
	@ResponseBody
	public String getSettlementFeeDetailGrid(@PathVariable String settlementId) throws Exception{
		List<Map<String, Object>> list = hxExamineSettlementService.getSettlementFeeDetailGrid(settlementId);
		return JsonUtil.writeListToDataGrid(list.size(), list);
	}
	
	@RequestMapping(value="/getOtherFeeGrid/{settlementId}", produces="text/plain;charset=utf-8")
	@ResponseBody
	public String getOtherFeeGrid(@PathVariable String settlementId) throws Exception{
		List<Map<String, Object>> list = hxExamineSettlementService.getOtherFeeGridById(settlementId);
		return JsonUtil.writeListToDataGrid(list.size(), list);
	}
	
	@RequestMapping(value="/examineSettlementInstallDetail")
	@ResponseBody
	public ModelAndView examineSettlementInstallDetail(String serviceId,String settlementId){
		ModelAndView mav = new ModelAndView("orgmanage/hxExamineSettlement/installServiceTicketDetailShow");
		Map<String, Object> map = installReceiptService.getInstallReceiptById(serviceId);
		map.put("settlementId", settlementId);
		mav.addObject("map", map);
		return mav;
	}
	
	@RequestMapping(value="/examineSettlementRepairDetail")
	@ResponseBody
	public ModelAndView examineSettlementRepairDetail(String serviceId,String settlementId){
		ModelAndView mav = new ModelAndView("orgmanage/hxExamineSettlement/repairServiceTicketDetailShow");
		Map<String, Object> map = repairReceiptService.getRepairReceiptById(serviceId);
		map.put("settlementId", settlementId);
		mav.addObject("map", map);
		return mav;
	}
	
}
