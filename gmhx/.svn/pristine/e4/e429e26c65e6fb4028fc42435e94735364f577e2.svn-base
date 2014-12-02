package com.gome.gmhx.controller.materialmanage;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gome.common.Constrants;
import com.gome.common.page.Page;
import com.gome.common.util.BeanMapUtils;
import com.gome.common.util.JsonUtil;
import com.gome.gmhx.entity.HxMaterialManage;
import com.gome.gmhx.entity.HxParcelDelivery;
import com.gome.gmhx.entity.SysUser;
import com.gome.gmhx.service.materialmanage.HxMaterialService;

@Controller
@RequestMapping(value="/hxMaterialHistory")
public class HxMaterialHistoryController {

	@Resource
	private HxMaterialService hxMaterialService;
	
	@RequestMapping(value="/hxMaterialHistoryView")
	private String ParcelDeliveryView(){//配件 申请历史
		return "materialmanage/hxMaterialHistory/hxMaterialHistoryList";
	} 
	
	@RequestMapping(value="/hxParcelView") //查询邮包收发货历史
	public String hxParcelView(){
		return "materialmanage/hxMaterialHistory/hxParcelHistoryList";
	}
	
	
	@RequestMapping(value="/getHxMaterialHistoryPageList", produces="text/plain;charset=utf-8")
	@ResponseBody
	public String getHxMaterialPageList(HttpServletRequest request, Page page, HxMaterialManage hxMaterialManage,
			@DateTimeFormat(pattern="yyyy-MM-dd")Date ksrq, @DateTimeFormat(pattern="yyyy-MM-dd")Date jsrq) throws Exception{
		SysUser sysUser = (SysUser)request.getSession().getAttribute(Constrants.USER_INFO);
		Map<String, Object> map = BeanMapUtils.convertBean(hxMaterialManage);
		map.put("ksrq", ksrq);
		map.put("jsrq", jsrq);
		map.put("fittingPositionId", sysUser.getFittingPositionId());
		map.put("fittingOrgId", sysUser.getFittingOrgId());
		map.put("userAccount", sysUser.getUserAccount());
		page.setParam(map);
		List<Map<String, Object>> list = hxMaterialService.getHxMaterialHistoryPageList(page);
		return JsonUtil.writeListToDataGrid(page.getTotalResult(), list);
	}
	
	@RequestMapping(value="/getHxParcelPageList", produces="text/plain;charset=utf-8")
	@ResponseBody
	public String getHxParcelPageList(HttpServletRequest request,Page page, HxParcelDelivery hxParcelReceipt,
			@DateTimeFormat(pattern="yyyy-MM-dd")Date sendDate_sta,
			@DateTimeFormat(pattern="yyyy-MM-dd")Date sendDate_end) throws Exception{
		SysUser sysUser = (SysUser) request.getSession().getAttribute(Constrants.USER_INFO);
		Map <String , Object> map =BeanMapUtils.convertBean(hxParcelReceipt);
		map.put("sendDate_sta", sendDate_sta);
		map.put("sendDate_sta", sendDate_sta);
		map.put("founders", sysUser.getUserAccount());
		map.put("fittingPositionId", sysUser.getFittingPositionId());
		page.setParam(map);
		List<Map<String, Object>> list = hxMaterialService.getHxParcelPageList(page);
		return JsonUtil.writeListToDataGrid(page.getTotalResult(), list);
	}
}
