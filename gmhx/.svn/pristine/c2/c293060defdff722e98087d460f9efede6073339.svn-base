package com.gome.gmhx.controller.storeinfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gome.common.Constrants;
import com.gome.common.page.Page;
import com.gome.common.util.BeanMapUtils;
import com.gome.common.util.JsonUtil;
import com.gome.gmhx.entity.HxPosition;
import com.gome.gmhx.entity.SysUser;
import com.gome.gmhx.entity.vo.HxCurrentStockVO;
import com.gome.gmhx.service.storeinfo.HxCurrentStockService;
import com.gome.gmhx.service.storeinfo.HxInoutStockService;
import com.gome.gmhx.service.sysconfig.HxOrganizationService;
import com.gome.gmhx.service.sysconfig.HxPositionService;

@Controller
@RequestMapping(value="/hxInoutStock")
public class HxInoutStockController {
	@Resource
	private HxInoutStockService hxInoutStockService;
	@Resource
	private HxPositionService hxPositoryService;
	
	@RequestMapping("/stockView")
	public ModelAndView stockView(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("storeinfo/inoutstock/inoutStockList");
		SysUser sysUser = (SysUser)request.getSession().getAttribute(Constrants.USER_INFO);
		HxPosition position = hxPositoryService.getPositionById(sysUser.getFittingPositionId());
		request.getSession().setAttribute("ptype",  position.getPositionType());
		mav.addObject("ptype", position.getPositionType());
		return mav;
//		return "storeinfo/inoutStock/inoutStockList";
	}
	
	@RequestMapping(value="/getInoutSotckHistoryPageList", produces="text/plain;charset=utf-8")
	@ResponseBody
	public String getInoutSotckHistoryPageList(HttpServletRequest request, Page page) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("fittingPositionType", request.getParameter("fittingPositionType"));
		map.put("inout", request.getParameter("inout"));
		map.put("isNew", request.getParameter("isNew"));
		page.setParam(map);
		List<Map<String, Object>> list =hxInoutStockService.getInoutSotckHistoryPageList(page);
		return JsonUtil.writeListToDataGrid(page.getTotalResult(), list);
	}
	
	@RequestMapping(value="/viewInoutSotock", produces="text/plain;charset=utf-8")
	@ResponseBody
	public ModelAndView viewInoutSotock(HttpServletRequest request, String listNumber) throws Exception{
		ModelAndView mav = new ModelAndView("storeinfo/inoutstock/inoutStockList");
		SysUser sysUser = (SysUser)request.getSession().getAttribute(Constrants.USER_INFO);
		HxPosition position = hxPositoryService.getPositionById(sysUser.getFittingPositionId());
		request.getSession().setAttribute("ptype",  position.getPositionType());
		mav.addObject("ptype", position.getPositionType());
		return mav;
	}
}
