package com.gome.gmhx.controller.sysconfig;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gome.gmhx.entity.HxMenu;
import com.gome.gmhx.entity.HxRole;
import com.gome.gmhx.entity.HxRoleMenu;
import com.gome.gmhx.service.sysconfig.RoleMenuService;
import com.gome.gmhx.service.sysconfig.RoleService;

@Controller
@RequestMapping(value="/hxRoleMenu")
public class HxRoleMenuController {
	
	@Resource
	private RoleMenuService roleMenuService;
	
	@Resource
	private RoleService roleService;
	
	@RequestMapping(value="/roleMenuView/{roleId}")
	public ModelAndView userRoleView(@PathVariable(value = "roleId") String roleId){
		ModelAndView mav = new ModelAndView("sysconfig/hxRoleMenu/roleMenuTree");
		HxRole role = roleService.getRoleById(roleId);
		mav.addObject("role", role);
		return mav;
	}
	
	@RequestMapping(value="/getMenuTree", produces="text/plain;charset=utf-8")
	@ResponseBody
	public String getMenuTree(){
		List<HxMenu> menuList = roleMenuService.getMenuTree();
        JSONArray array = new JSONArray();
        for (HxMenu menu : menuList) {
            JSONObject object = new JSONObject();
            object.put("id", menu.getMenuId());
            object.put("pId", menu.getParentId());
            object.put("name", menu.getMenuName());
            array.add(object);
        }
		return array.toString();
	}
	
	@RequestMapping(value="/getMenuTreeData/{roleId}", produces="text/plain;charset=utf-8")
	@ResponseBody
	public String getMenuTreeData(@PathVariable(value = "roleId") String roleId){
		List<HxMenu> roleList = roleMenuService.getMenuTreeData(roleId);
		JSONArray array = new JSONArray();
	    for (HxMenu menu : roleList) {
	         JSONObject object = new JSONObject();
	         object.put("id", menu.getMenuId());
	         array.add(object);
	     }
		return array.toString();
	}
	
	@RequestMapping(value="addRoleMenu")
	@ResponseBody
	public String addRoleMenu(HxRoleMenu roleMenu) {
        try {
        	String roleidTemp = roleMenu.getRoleId();
        	String menuidTemp = roleMenu.getMenuId();
        	if (StringUtils.isNotEmpty(roleidTemp)) {
        		roleMenuService.deleteCompleteByRoleId(roleidTemp);
        	}
        	if (StringUtils.isNotEmpty(roleidTemp)) {
    			String[] menuidTempArr = menuidTemp.split(",");
    			for(int i = 0; i < menuidTempArr.length; i++){
    				HxRoleMenu rm = new HxRoleMenu();
    				rm.setMenuId(menuidTempArr[i]);
    				rm.setRoleId(roleidTemp);
    				roleMenuService.addRoleMenu(rm);
    			}
    				
        	}
            return "{\"flag\" : \"success\"}";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	
}