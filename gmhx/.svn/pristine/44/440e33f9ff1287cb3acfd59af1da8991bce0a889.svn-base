package com.gome.gmhx.controller.orgmanage;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gome.common.Constrants;
import com.gome.common.page.Page;
import com.gome.common.util.BeanMapUtils;
import com.gome.common.util.JsonUtil;
import com.gome.gmhx.entity.HxExamineSettlementTicket;
import com.gome.gmhx.entity.SysUser;
import com.gome.gmhx.entity.vo.HxServiceTicketVO;
import com.gome.gmhx.entity.vo.HxSettlementVO;
import com.gome.gmhx.service.orgmanage.HxExamineSettlementService;
import com.gome.gmhx.service.servicemanage.HxInstallReceiptService;
import com.gome.gmhx.service.servicemanage.HxRepairReceiptService;

@Controller
@RequestMapping(value="/hxConfirmSettlement")
public class HxConfirmSettlementController {

	@Resource
	HxExamineSettlementService hxExamineSettlementService;
	
	@Resource
	private HxInstallReceiptService installReceiptService;
	
	@Resource
	private HxRepairReceiptService repairReceiptService;
	
	@RequestMapping(value="/confirmSettlementView")
	public String limitView(){
		return "orgmanage/hxConfirmSettlement/confirmSettlementList";
	}
	
	@RequestMapping(value="/getConfirmSettlementPageList", produces="text/plain;charset=utf-8")
	@ResponseBody
	public String getConfirmSettlementPageList(HttpServletResponse response, Page page, HxExamineSettlementTicket hxExamineSettlementTicket,
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
	
	@RequestMapping(value="/confirmSettlementUpdateView/{settlementId}")
	@ResponseBody
	public ModelAndView confirmSettlementUpdateView(@PathVariable String settlementId){
		ModelAndView mav = new ModelAndView("orgmanage/hxConfirmSettlement/confirmSettlementUpdateShow");
		HxExamineSettlementTicket es = hxExamineSettlementService.geExamineSettlementById(settlementId);
		mav.addObject("es", es);
		return mav;
	}

	@RequestMapping(value="/confirmSettlementUpdate", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String confirmSettlementUpdate(HttpServletRequest request,@RequestBody HxSettlementVO settlementVO){
		SysUser sysUser = (SysUser) request.getSession().getAttribute(Constrants.USER_INFO);
		try {
			String settlementId = hxExamineSettlementService.updateSettlement(sysUser,settlementVO);
            return "{\"flag\" : \"success\",\"settlementId\" : \""+settlementId+"\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"flag\" : \"failure\"}";
        }
	}	 

	@RequestMapping(value="/confirmSettlementView/{settlementId}")
	@ResponseBody
	public ModelAndView confirmSettlementView(@PathVariable String settlementId){
		ModelAndView mav = new ModelAndView("orgmanage/hxConfirmSettlement/confirmSettlementShow");
		HxExamineSettlementTicket es = hxExamineSettlementService.geExamineSettlementById(settlementId);
		mav.addObject("es", es);
		return mav;
	}
	
}
	




























