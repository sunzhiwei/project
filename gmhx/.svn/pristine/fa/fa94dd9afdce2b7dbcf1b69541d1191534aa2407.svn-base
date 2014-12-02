package com.gome.gmhx.controller.sysconfig;

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
import com.gome.common.util.UUIDGenerator;
import com.gome.gmhx.entity.HxRole;
import com.gome.gmhx.service.sysconfig.RoleService;

@Controller
@RequestMapping(value="/hxRole")
public class HxRoleController {
	@Resource
	private RoleService roleService;
	
	@RequestMapping(value="/roleView")
	public String roleView(){
		return "sysconfig/hxRole/roleList";
	}
	
	@RequestMapping(value="/getRolePageList", produces="text/plain;charset=utf-8")
	@ResponseBody
	public String getRoleList(HttpServletResponse response, Page page, HxRole role) throws Exception{
		page.setParam(role);
		List<Map<String, Object>> list = roleService.getRolePageList(page);
		return JsonUtil.writeListToDataGrid(page.getTotalResult(), list);
	}
	
	@RequestMapping(value="/addView")
	public String addView(){
		return "sysconfig/hxRole/roleAdd";
	}
	
	@RequestMapping(value="addRole")
	@ResponseBody
	public String addRole(HxRole role) {
        try {
        	String roleId = UUIDGenerator.getUUID();
        	role.setRoleId(roleId);//设置主键
        	roleService.addRole(role);
            return "{\"flag\" : \"success\"}";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	@RequestMapping(value="/updateView/{roleId}")
	public ModelAndView updateView(@PathVariable(value = "roleId") String roleId){
		ModelAndView mav = new ModelAndView("sysconfig/hxRole/roleUpdate");
		HxRole role = roleService.getRoleById(roleId);
		mav.addObject("role", role);
		return mav;
	}
	
	@RequestMapping(value="/updateRole")
	@ResponseBody
	public String updateRole(HxRole role){
		try {
			roleService.updateRole(role);
            return "{\"flag\" : \"success\"}";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}
	
	@RequestMapping(value="/showView/{roleId}")
	public ModelAndView showView(@PathVariable(value = "roleId") String roleId){
		ModelAndView mav = new ModelAndView("sysconfig/hxRole/roleShow");
		HxRole role = roleService.getRoleById(roleId);
		mav.addObject("role", role);
		return mav;
	}
}