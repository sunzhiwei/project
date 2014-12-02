package com.gome.sermanage.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.gome.sermanage.base.ModelDrivenBaseAction;
import com.gome.sermanage.entity.SerManage_Privilege;
import com.gome.sermanage.entity.SerManage_Role;
import com.gome.sermanage.entity.SerManage_User;
import com.gome.sermanage.entity.SerManage_User_Role;
import com.gome.sermanage.service.PrivilegeService;
import com.gome.sermanage.service.UserRoleService;
import com.gome.sermanage.service.UserService;
import com.gome.sermanage.util.ComparatorImpl;
import com.gome.sermanage.util.PageUtil;
import com.gome.sermanage.util.Pagination;
import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class UserAction extends ModelDrivenBaseAction<SerManage_User> {

	static Logger log = Logger.getLogger(UserAction.class);
	
	@Resource
	private UserService userService;
	@Resource
	private PrivilegeService privilegeService;
	@Resource
	private UserRoleService userroleService;
	
	private List<SerManage_Role> rolelist;
	
	private String roleidlist;
	
	private SerManage_User user;
	
	private List<Long> userroleidList;
	
	/** 登录 */
	@SuppressWarnings("unchecked")
	public String login() throws Exception {
		try {
			Map session = ActionContext.getContext().getSession();
			SerManage_User user = null;
			if (model != null && model.getUsername() != null
					&& model.getPassword() != null)
				user = userService.getByLoginNameAndPassword(
						model.getUsername(), model.getPassword());
				if (user == null) {
					request.setAttribute("msg",
							"<font color='red'>请检查用户名和密码是否正确!</font>");
					return "tologin";
				} else {
					// 用户id
					Integer userid = user.getId().intValue();
					// 用户的角色集合
					List<Integer> rolelist = userService
							.userRoleidList(userid);
					session.put("personrole", rolelist);// 将角色id集合存入session中
					if (rolelist.size() == 0 || rolelist == null) {
						request.setAttribute("msg",
								"<font color='red'>对不起你没有权限进入该系统!</font>");
						return "tologin";
					} else {
						// 该用户角色对应的所有菜单id集合
						List<Integer> functlist = new ArrayList<Integer>();
						for (int i = 0; i < rolelist.size(); i++) {
							Integer roleid = rolelist.get(i).intValue();
							List<Integer> list = userService
									.selectPrivilegeidByRoleid(roleid);
							functlist.addAll(list);

						}
						// 为避免多角色之间有重叠的菜单权限，将list转成set
						Set<Integer> functiset = new HashSet<Integer>(
								functlist);
						Iterator<Integer> it = functiset.iterator();
						List<SerManage_Privilege> listmenu1 = new ArrayList<SerManage_Privilege>();
						List<SerManage_Privilege> listmenu2 = new ArrayList<SerManage_Privilege>();
						List<SerManage_Privilege> findbylist1 = new ArrayList<SerManage_Privilege>();
						List<SerManage_Privilege> findbylist2 = new ArrayList<SerManage_Privilege>();
						// 根据菜单id查询菜单对象
						while (it.hasNext()) {
							Integer menuid = it.next().intValue();
							listmenu1 = findByLevel(menuid, 1);
							findbylist1.addAll(listmenu1);
							listmenu2 = findByLevel(menuid, 2);
							findbylist2.addAll(listmenu2);
						}
						ComparatorImpl c1 = new ComparatorImpl();
						Collections.sort(findbylist1, c1);
						Collections.sort(findbylist2, c1);

						session.put("user", user);
						session.put("firstLelelMenus", findbylist1);
						session.put("secondLelelMenus", findbylist2);

						log.info(user.getUsername() + "登陆系统！");
						return "home";
					}
				}
		} catch (Exception e) {
			log.error("登陆系统失败！");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 
	 * 描述：退出系统
	 * 
	 * @version
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String exitLogin() throws Exception {
		Map session = ActionContext.getContext().getSession();
		if (session instanceof org.apache.struts2.dispatcher.SessionMap) {
			((org.apache.struts2.dispatcher.SessionMap) session).invalidate();
		}
		ServletActionContext.getRequest().getSession().invalidate();
		return "tologin";
	}

	/**
	 * 
	 * 描述：根据级别查找菜单
	 * 
	 * @version
	 * @param level级别
	 * @return
	 */
	private List<SerManage_Privilege> findByLevel(Integer menuid, Integer level)
			throws Exception {
		List<SerManage_Privilege> menus = null;
		try {
			menus = privilegeService.findByLevel(menuid,level);
			log.info("查找菜单！");
		} catch (Exception e) {
			log.error("查找菜单失败！");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return menus;
	}
	
	@SuppressWarnings("unused")
	public void checkSuperadmin() throws Exception{
		try {
			int flag=userService.checkSuperadmin(currentUser);
			if(flag>0)
				flag=1;
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print(flag);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@SuppressWarnings({ "unchecked" })
	public String queryPageJson() throws Exception{
		int currentPage = PageUtil.strToPage(request.getParameter("page"));
		int pageSize = PageUtil.strToPageSize(request.getParameter("rows"));
		Map map = new HashMap();
		try {
			map.put("username", request.getParameter("username"));
			int totalCounts = userService.getTotalCountsByParams(map);
			Pagination page = new Pagination(currentPage,pageSize,totalCounts);
			//查询数据集
			Map map2 = PageUtil.getMap(page);
			map2.put("username", request.getParameter("username"));
			List list = userService.queryPageByParams(map2);
			List userMapList=new ArrayList();
			Iterator it=list.iterator();
			while(it.hasNext()){
				SerManage_User user=(SerManage_User) it.next();
				Map userMap=new HashMap();
				userMap.put("id", user.getId());
				userMap.put("username", user.getUsername());
				userMapList.add(userMap);
			}
			page.setRows(userMapList);
			this.pagination = page;
			log.info(this.getCurrentUser().getUsername()+"查看系统用户列表！");
		} catch (Exception e) {
			log.error(this.getCurrentUser().getUsername()+"查看系统用户列表失败");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return "queryPageJson";
	}
	
	public String addUserUI() throws Exception{
		try {
			rolelist=userService.selectRoleList(); // 所有角色集合
			log.info(currentUser.getUsername() + "打开添加用户页面!");
		} catch (Exception e) {
			log.error(currentUser.getUsername() + "打开添加用户页面失败!");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return "addUserUI";
	}
	
	public void addUser() throws Exception{
		try {
			String roleidlist1 = roleidlist.replaceAll(" ", "");
			userService.save(user);
			String[] rolechoseidlist = roleidlist1.split(",");
			for(int i=0;i<rolechoseidlist.length;i++){
				SerManage_User_Role userRole=new SerManage_User_Role();
				userRole.setUserid(user.getId());
				userRole.setRoleid(Long.parseLong(rolechoseidlist[i]));
				userroleService.save(userRole);
			}
			log.info(currentUser.getUsername() + "添加用户!");
		} catch (Exception e) {
			log.error(currentUser.getUsername() + "添加用户失败!");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public String editUserUI() throws Exception{
		try {
			user=userService.getById(user.getId());
			rolelist=userService.selectRoleList(); // 所有角色集合
			userroleidList=userroleService.userroleidlist(user.getId()); // 当前用户角色
			log.info(currentUser.getUsername() + "打开修改用户页面!");
		} catch (Exception e) {
			log.error(currentUser.getUsername() + "打开修改用户页面失败!");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return "editUserUI";
	}
	
	public void editUser() throws Exception{
		try {
			userService.update(user);
			userroleService.deleteUserRole(user.getId());
			
			String roleidlist1 = roleidlist.replaceAll(" ", "");
			String[] rolechoseidlist = roleidlist1.split(",");
			for(int i=0;i<rolechoseidlist.length;i++){
				SerManage_User_Role userRole=new SerManage_User_Role();
				userRole.setUserid(user.getId());
				userRole.setRoleid(Long.parseLong(rolechoseidlist[i]));
				userroleService.save(userRole);
			}
			log.info(currentUser.getUsername() + "更新用户!");
		} catch (Exception e) {
			log.error(currentUser.getUsername() + "更新用户失败!");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void deleteUser() throws Exception{
		try {
			userService.deleteUser(user);
			userroleService.deleteUserRole(user.getId());
			log.info(this.getCurrentUser().getUsername() + "删除用户！");
		} catch (Exception e) {
			log.error(this.getCurrentUser().getUsername() + "删除用户失败！");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 描述：判断用户是否已经存在
	 */
	@SuppressWarnings("unchecked")
	public void checkUserExist() throws Exception{
		try {
			int flag=0;
			Map map=new HashMap();
			map.put("username",request.getParameter("username"));
			map.put("id",request.getParameter("id"));
			flag=userService.checkUserExist(map);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print(flag);
			log.info(this.getCurrentUser().getUsername() + "验证用户是否存在!");
		} catch (Exception e) {
			log.error(this.getCurrentUser().getUsername() + "验证用户是否存在失败!");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public String toList(){
		return "toList";
	}
	
	public List<SerManage_Role> getRolelist() {
		return rolelist;
	}

	public void setRolelist(List<SerManage_Role> rolelist) {
		this.rolelist = rolelist;
	}

	public String getRoleidlist() {
		return roleidlist;
	}

	public void setRoleidlist(String roleidlist) {
		this.roleidlist = roleidlist;
	}

	public SerManage_User getUser() {
		return user;
	}

	public void setUser(SerManage_User user) {
		this.user = user;
	}

	public List<Long> getUserroleidList() {
		return userroleidList;
	}

	public void setUserroleidList(List<Long> userroleidList) {
		this.userroleidList = userroleidList;
	}
}
