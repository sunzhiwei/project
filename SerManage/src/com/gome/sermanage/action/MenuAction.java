package com.gome.sermanage.action;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.gome.sermanage.base.ModelDrivenBaseAction;
import com.gome.sermanage.entity.SerManage_Privilege;
import com.gome.sermanage.service.PrivilegeService;
import com.gome.sermanage.util.JsonUtil;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class MenuAction extends ModelDrivenBaseAction<SerManage_Privilege> {

	static Logger log = Logger.getLogger(MenuAction.class);
	private static String MENU_ALL = "all";
	
	@Resource
	private PrivilegeService privilegeService;
	
	public void list(){
		String result = null;
		try {
			Map<String, Object> map = null;
			String show = request.getParameter("show");
			if(MENU_ALL.equals(show)){
				map = new HashMap<String,Object>();
			}else{
//				map = UserController.getUserInfo(request);
			}
//			map.putAll(UserController.getParam(request));
			List list = privilegeService.list(map);
			result = JsonUtil.javaObjectToJsonString(list);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
