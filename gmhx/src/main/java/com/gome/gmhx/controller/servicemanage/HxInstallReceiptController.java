package com.gome.gmhx.controller.servicemanage;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
import com.gome.common.util.DecoderUtil;
import com.gome.common.util.JsonUtil;
import com.gome.gmhx.entity.HxServiceCustomer;
import com.gome.gmhx.entity.SysUser;
import com.gome.gmhx.entity.vo.HxServiceTicketVO;
import com.gome.gmhx.service.basicdata.HxProductDetailService;
import com.gome.gmhx.service.servicemanage.HxInstallReceiptService;
import com.gome.gmhx.service.servicemanage.HxServiceCustomerService;
import com.gome.gmhx.service.servicemanage.JlCustomerProductService;
import com.gome.gmhx.service.sysconfig.HxOrganizationService;

@Controller
@RequestMapping(value="/installReceipt")
public class HxInstallReceiptController {
	
	@Resource
	private JlCustomerProductService jlCustomerProductService;
	
	@Resource
	private HxInstallReceiptService installReceiptService;
	
	@Resource
	HxOrganizationService hxOrganizationService;
	
	@Resource
	private HxServiceCustomerService hxServiceCustomerService; 
	
	@Resource
	private HxProductDetailService hxProductDetailService;
	
	@RequestMapping(value="/installReceiptView")
	public String installReceiptView(){
		return "servicemanage/InstallReceipt/InstallReceiptList";
	}
	
	@RequestMapping(value="/addview")
	public String ServiceTicketAdd(){
		return "servicemanage/InstallReceipt/SelectCustomer";
	}
	
	@RequestMapping(value="/addInstallReceiptView")
	public String airConditionAdd(){
		return "servicemanage/InstallReceipt/InstallReceiptAdd";
	}
	
	@RequestMapping(value="/getCustomer", produces = "text/plain;charset=utf-8")
	@ResponseBody 
	public ModelAndView getCustomer(HxServiceCustomer customer){
		ModelAndView mav = new ModelAndView("servicemanage/InstallReceipt/InstallReceiptAdd");
		customer = hxServiceCustomerService.getCustomerById(customer.getCustomerId());
		mav.addObject("customerProduct", customer);
		return mav;
	}
	
	@RequestMapping(value="/selectCustomer", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public ModelAndView selectCustomer(Page page,HxServiceCustomer customer,String machineCode,String installNum) throws Exception{
		new DecoderUtil<HxServiceCustomer>().decodeURI(customer);
		ModelAndView mav = new ModelAndView("servicemanage/InstallReceipt/Customers");
		Map <String , Object> map = BeanMapUtils.convertBean(customer);
		map.put("machineCode", machineCode);
		map.put("installNum", installNum);
		page.setParam(map);
		List<Map<String,Object>> list = hxServiceCustomerService.getCustomerList(page);
		mav.addObject("list", JsonUtil.writeListToDataGrid(list.size(),list));
		return mav;
	}
	
	@RequestMapping(value="/getInstallReceiptPageList", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String getInstallReceiptPageList(Page page,HxServiceTicketVO serviceTicketVO,HttpServletRequest request,
			@DateTimeFormat(pattern="yyyy-MM-dd")Date mod_createTime_st,
			@DateTimeFormat(pattern="yyyy-MM-dd")Date mod_createTime_end,
			@DateTimeFormat(pattern="yyyy-MM-dd")Date mod_installDate_st,
			@DateTimeFormat(pattern="yyyy-MM-dd")Date mod_installDate_end
			) throws Exception{
		SysUser sysUser = (SysUser) request.getSession().getAttribute(Constrants.USER_INFO);
		Map <String , Object> map =BeanMapUtils.convertBean(serviceTicketVO);
		map.put("mod_createTime_st", mod_createTime_st);
		map.put("mod_createTime_end", mod_createTime_end);
		map.put("mod_installDate_st", mod_installDate_st);
		map.put("mod_installDate_end", mod_installDate_end);
		map.put("serviceStatus","04");
		// 个人安装服务
		map.put("serviceType", "02");
		map.put("customerType", "01");
		map.put("createOrganization", hxOrganizationService.getChild(sysUser.getCompanyId()));
		page.setParam(map);
		List<Map<String, Object>> list = installReceiptService.getServiceInstallReceiptPageList(page);
		return JsonUtil.writeListToDataGrid(page.getTotalResult(), list);
	}
	
	@RequestMapping(value="/saveInstallReceipt", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String saveInstallReceipt(HttpServletRequest request,@RequestBody HxServiceTicketVO serviceTicketVO){
		SysUser sysUser = (SysUser) request.getSession().getAttribute(Constrants.USER_INFO);
		try {
			String serviceId = installReceiptService.saveInstallReceipt(serviceTicketVO,sysUser);
            return "{\"flag\" : \"success\",\"serviceId\" : \""+serviceId+"\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"flag\" : \"failure\"}";
        }
	}
	
	@RequestMapping(value="/installReceiptView/{serviceId}", produces = "text/plain;charset=utf-8")
	public ModelAndView installReceiptView(@PathVariable String serviceId){
		ModelAndView mav = new ModelAndView("servicemanage/InstallReceipt/InstallReceiptShow");
		Map<String, Object> map = installReceiptService.getInstallReceiptById(serviceId);
		mav.addObject("map", map);
		return mav;
	}
	
	@RequestMapping(value="/updateInstallReceiptView/{serviceId}", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public ModelAndView updateInstallReceiptView(@PathVariable String serviceId){
		ModelAndView mav = new ModelAndView("servicemanage/InstallReceipt/InstallReceiptUpdate");
		Map<String, Object> map = installReceiptService.getInstallReceiptById(serviceId);
		mav.addObject("map", map);
		return mav;
	}
	
	@RequestMapping(value="/updateInstallReceipt", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String updateInstallReceipt(HttpServletRequest request,HxServiceTicketVO serviceTicketVO){
		SysUser sysUser = (SysUser) request.getSession().getAttribute(Constrants.USER_INFO);
		try {
			installReceiptService.updateInstallReceipt(serviceTicketVO,sysUser);
            return "{\"flag\" : \"success\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"flag\" : \"failure\"}";
        }
	}
	
	@RequestMapping(value="/deleteInstallReceipt/{serviceId}", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String deleteInstallReceipt(@PathVariable String serviceId){
		try {
			installReceiptService.deleteServiceInstallReceipt(serviceId);
			return "{\"flag\" : \"success\"}";
		} catch (Exception e){
			e.printStackTrace();
			return "{\"flag\" : \"failure\"}";
		}
	}
	
	@RequestMapping(value="/affirmInstallReceipt/{serviceId}", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String affirmInstallReceipt(@PathVariable String serviceId){
		try {
			installReceiptService.submit(serviceId);
			return "{\"flag\" : \"success\"}";
		} catch (Exception e){
			e.printStackTrace();
			return "{\"flag\" : \"failure\"}";
		}
	}
	
	@RequestMapping(value="/getModel", produces="text/plain;charset=utf-8")
	@ResponseBody
	public String getModel(String machineType){
		List<Map<String, Object>> list = hxProductDetailService.getModel();
		JSONArray array = new JSONArray();
		for(Map<String, Object> map : list){
			JSONObject object = new JSONObject();
			object.put("value", map.get("model"));
			object.put("text", map.get("model"));
			object.put("gomeCode",map.get("gome_code"));
			object.put("brand",map.get("brand"));
			array.add(object);
		}
		return array.toString();
	}
	
	@RequestMapping(value="/getStore", produces="text/plain;charset=utf-8")
	@ResponseBody
	public String getStore(String center){
		List<Map<String, Object>> list = installReceiptService.getStore(center);
		JSONArray array = new JSONArray();
		for(Map<String, Object> map : list){
			JSONObject object = new JSONObject();
			object.put("value", map.get("id"));
			object.put("text", map.get("name"));
			array.add(object);
		}
		return array.toString();
	}
	
	@RequestMapping(value="/getServices", produces="text/plain;charset=utf-8")
	@ResponseBody
	public String getServices(String pid){
		List<Map<String, Object>> list = installReceiptService.getServices(pid);
		JSONArray array = new JSONArray();
		for(Map<String, Object> map : list){
			JSONObject object = new JSONObject();
			object.put("value", map.get("id"));
			object.put("text", map.get("name"));
			array.add(object);
		}
		return array.toString();
	}
	
	@RequestMapping(value="/getWD", produces="text/plain;charset=utf-8")
	@ResponseBody
	public String getWD(){
		List<Map<String, Object>> list = installReceiptService.getWD();
		JSONArray array = new JSONArray();
		for(Map<String, Object> map : list){
			JSONObject object = new JSONObject();
			object.put("value", map.get("org_code"));
			object.put("text", map.get("org_name"));
			array.add(object);
		}
		return array.toString();
	}
	
	@RequestMapping(value="/getServiceUnit", produces="text/plain;charset=utf-8")
	@ResponseBody
	public String getServiceUnit(String wd){
		List<Map<String, Object>> list = installReceiptService.getServiceUnit(wd);
		JSONArray array = new JSONArray();
		for(Map<String, Object> map : list){
			JSONObject object = new JSONObject();
			object.put("value", map.get("serviceUnit"));
			object.put("text", map.get("unitName"));
			array.add(object);
		}
		return array.toString();
	}
}
