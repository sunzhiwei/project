package com.gome.gmhx.controller.orgmanage;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gome.common.page.Page;
import com.gome.common.util.JsonUtil;
import com.gome.gmhx.entity.HxNetWork;
import com.gome.gmhx.service.orgmanage.HxNetWorkService;

@Controller
@RequestMapping(value="/Network")
public class NetWorkController {   
    
	@Resource
	private HxNetWorkService networkService;
	
	@RequestMapping(value="/NetworkView")
	public String NetworkView(){
		return "orgmanage/NetworkInformation/NetworkList";
	}
	
	@RequestMapping(value="/getNetWorkPageList", produces="text/plain;charset=utf-8")
	@ResponseBody
	public String getNetWorkList(HttpServletResponse response, Page page, HxNetWork network) throws Exception{
		page.setParam(network);
		List<Map<String, Object>> list = networkService.getNetWorkPageList(page);
		return JsonUtil.writeListToDataGrid(page.getTotalResult(), list);
	}
	
	@RequestMapping(value="/showView/{id}")
	public ModelAndView showView(@PathVariable(value = "id") String aa){
		ModelAndView mav = new ModelAndView("orgmanage/NetworkInformation/NetworkShow");
		HxNetWork network = networkService.getShowById(aa);
		mav.addObject("network", network);
		return mav;
	}
}
