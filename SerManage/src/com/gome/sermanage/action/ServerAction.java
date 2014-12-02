package com.gome.sermanage.action;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.gome.sermanage.base.ModelDrivenBaseAction;
import com.gome.sermanage.entity.SerManage_Server;
import com.gome.sermanage.entity.SerManage_User;
import com.gome.sermanage.service.ServerService;
import com.gome.sermanage.service.UserService;
import com.gome.sermanage.util.ConstUtils;
import com.gome.sermanage.util.PageUtil;
import com.gome.sermanage.util.Pagination;
import com.gome.sermanage.util.StringUtil;

@Controller
@Scope("prototype")
public class ServerAction extends ModelDrivenBaseAction<SerManage_Server> {

	static Logger log = Logger.getLogger(ServerAction.class);
	
	@Resource
	private ServerService serverService;
	@Resource
	private UserService userService;
	// 当前系统的普通管理员（即系统管理员）
	private String administrators=""; 
	
	private SerManage_Server server;
	
	private String DBServerArray="";  // 数据库服务器数量集
	
	private String APPServerArray=""; // 应用服务器数量集
	
	private String column=""; // 图形报表x轴列值集合
	
	private String environment="生产环境";  // 默认环境
	
	private BigInteger total;  // 服务器总数量
	
	private String lastupdatetime=""; // 最后一台服务器更新时间
	
	@SuppressWarnings({ "unchecked" })
	public String queryPageJson() throws Exception{
		int currentPage = PageUtil.strToPage(request.getParameter("page"));
		int pageSize = PageUtil.strToPageSize(request.getParameter("rows"));
		Map map = new HashMap();
		try {
			int flag=userService.checkSuperadmin(currentUser);
			if(flag<1){
				map.put("administrator", currentUser.getUsername());
				map=setMapValueBycurrentUser(map);
			}else{
				 map = setMapValue(map);
			}
			int totalCounts = serverService.getTotalCountsByParams(map);
			Pagination page = new Pagination(currentPage,pageSize,totalCounts);
			//查询数据集
			Map map2 = PageUtil.getMap(page);
			if(flag<1){
				map2.put("administrator", currentUser.getUsername());
				map2=setMapValueBycurrentUser(map2);
			}else{
				map2 = setMapValue(map2);
			}
			List list = serverService.queryPageByParams(map2);
			List serverMapList=new ArrayList();
			Iterator it=list.iterator();
			while(it.hasNext()){
				SerManage_Server server=(SerManage_Server) it.next();
				Map serverMap=new HashMap();
				serverMap.put("id", server.getId());
				serverMap.put("environment", server.getEnvironment());
				serverMap.put("systemname", server.getSystemname());
				serverMap.put("pcname",server.getPcname());
				serverMap.put("ipurl",server.getIpurl());
				serverMap.put("os", server.getOs());
				serverMap.put("cpu", server.getCpu());
				serverMap.put("mem", server.getMem());
				serverMap.put("disk", server.getDisk());
				if (server.getApptype() != null && !("").equals(server.getApptype()))
					serverMap.put("apptype", ConstUtils.getServerByAppType(server.getApptype().intValue()));
				else
					serverMap.put("apptype", "");
				serverMap.put("appdescription", server.getAppdescription());
				serverMap.put("f5deploy", server.getF5deploy());
				serverMap.put("administrator", server.getAdministrator());
				serverMap.put("updatetime", server.getUpdatetime());
				serverMapList.add(serverMap);
			}
			page.setRows(serverMapList);
			this.pagination = page;
			log.info(this.getCurrentUser().getUsername()+"查看服务器列表！");
		} catch (Exception e) {
			log.error(this.getCurrentUser().getUsername()+"查看服务器列表失败");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return "queryPageJson";
	}
	
	@SuppressWarnings({ "unchecked" })
	private Map setMapValue(Map map) throws Exception{
		map.put("pcname", request.getParameter("pcname"));
		map.put("environment", request.getParameter("environment"));
		map.put("systemname", request.getParameter("systemname"));
		map.put("apptype", request.getParameter("apptype"));
		map.put("startupdatetime", request.getParameter("startupdatetime"));
		map.put("endupdatetime", request.getParameter("endupdatetime"));
		map.put("administrator", request.getParameter("administrator"));
		return map;
	}
	
	@SuppressWarnings({ "unchecked" })
	private Map setMapValueBycurrentUser(Map map) throws Exception{
		map.put("pcname", request.getParameter("pcname"));
		map.put("environment", request.getParameter("environment"));
		map.put("systemname", request.getParameter("systemname"));
		map.put("apptype", request.getParameter("apptype"));
		map.put("startupdatetime", request.getParameter("startupdatetime"));
		map.put("endupdatetime", request.getParameter("endupdatetime"));
		return map;
	}
	
	public String addServerUI() throws Exception{
		try {
			List<SerManage_User> serManage_Userlist=userService.getAdminUser();
			for(SerManage_User user:serManage_Userlist)
				administrators+=user.getUsername()+",";
			if(administrators!=null && !("").equals(administrators)){
				administrators=administrators.substring(0,administrators.length()-1);
			}
			log.info(this.getCurrentUser().getUsername()+"打开添加服务器页面！");
		} catch (Exception e) {
			log.error(this.getCurrentUser().getUsername()+"打开添加服务器页面失败！");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return "addServerUI";
	}
	
	public void add() throws Exception{
		try {
			server.setUpdatetime(StringUtil.dateToString());
			userService.save(server);
			log.info(this.getCurrentUser().getUsername() + "添加服务器入库！");
		} catch (Exception e) {
			log.error(this.getCurrentUser().getUsername() + "添加服务器入库失败！");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	public String editServerUI() throws Exception{
		try {
			server=serverService.getById(server.getId());
			List<SerManage_User> serManage_Userlist=userService.getAdminUser();
			for(SerManage_User user:serManage_Userlist)
				administrators+=user.getUsername()+",";
			if(administrators!=null && !("").equals(administrators)){
				administrators=administrators.substring(0,administrators.length()-1);
			}
			log.info(this.getCurrentUser().getUsername()+"打开修改服务器页面！");
		} catch (Exception e) {
			log.error(this.getCurrentUser().getUsername()+"打开修改服务器页面失败！");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return "editServerUI";
	}
	
	public void edit() throws Exception{
		try {
			server.setUpdatetime(StringUtil.dateToString());
			serverService.update(server);
			log.info(this.getCurrentUser().getUsername() + "更新服务器入库！");
		} catch (Exception e) {
			log.error(this.getCurrentUser().getUsername() + "更新服务器入库失败！");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void deleteServer() throws Exception{
		try {
			serverService.deleteServer(server);
			log.info(this.getCurrentUser().getUsername() + "删除服务器！");
		} catch (Exception e) {
			log.error(this.getCurrentUser().getUsername() + "删除服务器失败！");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public String getDBServers() throws Exception{
		try {
			if(request.getParameter("environment")!=null)
			     environment=request.getParameter("environment");
			List<String> systemColumnList=serverService.getSystemColumn(environment);
			List<BigInteger> DBServersList=serverService.getDBServers(environment,systemColumnList);
			for (Iterator<BigInteger> iterator = DBServersList.iterator(); iterator.hasNext();) {  
				BigInteger db = iterator.next(); 
				DBServerArray+=db+",";
			}
			DBServerArray=DBServerArray.substring(0,DBServerArray.length()-1);
			DBServerArray="["+DBServerArray+"]";
			System.out.println(DBServerArray);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return "DBServerArray";
	}
	
	public String getAPPServers() throws Exception{
		try {
			if(request.getParameter("environment")!=null)
			     environment=request.getParameter("environment");
			List<String> systemColumnList=serverService.getSystemColumn(environment);
			List<BigInteger> APPServersList=serverService.getAPPServers(environment,systemColumnList);
			for (Iterator<BigInteger> iterator = APPServersList.iterator(); iterator.hasNext();) {  
				BigInteger app = iterator.next(); 
				APPServerArray+=app+",";
			}
			APPServerArray=APPServerArray.substring(0,APPServerArray.length()-1);
			APPServerArray="["+APPServerArray+"]";
			System.out.println(APPServerArray);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return "APPServerArray";
	}
	
	public String getSystemColumn() throws Exception{
		try {
			if(request.getParameter("environment")!=null)
			     environment=request.getParameter("environment");
			List<String> systemColumnList=serverService.getSystemColumn(environment);
			for (Iterator<String> iterator = systemColumnList.iterator(); iterator.hasNext();) {  
			    String str = iterator.next();  
			    column+=str+"','";		
			}
			column=column.substring(0,column.length()-2);
			column="['"+column+"]";
			System.out.println(column);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return "column";
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String queryServerDistributePageJson() throws Exception{
		int currentPage = PageUtil.strToPage(request.getParameter("page"));
		int pageSize = PageUtil.strToPageSize(request.getParameter("rows"));
		Map map = new HashMap();
		try {
			if(request.getParameter("environment")!=null)
			     environment=request.getParameter("environment");
			List<String> systemColumnList=serverService.getSystemColumn(environment);
			int totalCounts = systemColumnList.size();
			Pagination page = new Pagination(currentPage,pageSize,totalCounts);
			//查询数据集
			Map map2 = PageUtil.getMap(page);
			List<BigInteger> DBServersList=serverService.getDBServers(environment,systemColumnList);
			List<BigInteger> APPServersList=serverService.getAPPServers(environment,systemColumnList);
			List serverMapList=new ArrayList();
			for (int i=0;i<systemColumnList.size();i++) { 
				Map serverMap=new HashMap();
				serverMap.put("systemname", systemColumnList.get(i));
				serverMap.put("dbservercount", DBServersList.get(i));
				serverMap.put("appservercount", APPServersList.get(i));
				serverMapList.add(serverMap);
			}
			page.setRows(serverMapList);
			this.pagination = page;
			log.info(this.getCurrentUser().getUsername()+"查看服务器分布情况列表！");
		} catch (Exception e) {
			log.error(this.getCurrentUser().getUsername()+"查看服务器分布情况列表失败");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return "queryPageJson";
	}
	
	public void ifServerHasExists() throws Exception{
		try {
			int flag=0;
			Long id=-1l;
			if(request.getParameter("id")!=null)
				id=Long.parseLong(request.getParameter("id"));
			String ipurl=request.getParameter("ipurl");
			flag = serverService.selectedIfServerExists(ipurl.trim(),id);
		    response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print(flag);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public String toList(){
		return "toList";
	}
	
	public String overview() throws Exception{
		try {
			if(request.getParameter("environment")!=null)
			     environment=request.getParameter("environment");
			total=serverService.getTotalServersByEnvironment(environment).get(0);
			if(serverService.getLastUpdateTimeByEnvironment(environment).size()!=0)
			      lastupdatetime=serverService.getLastUpdateTimeByEnvironment(environment).get(0).getUpdatetime();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return "overview";
	}

	public void getOperators() throws Exception{
		String operators="";
		try {
			List<SerManage_User> serManage_Userlist=userService.getAdminUser();
			for(SerManage_User user:serManage_Userlist)
				operators+=user.getUsername()+",";
			if(administrators!=null && !("").equals(operators)){
				operators=operators.substring(0,operators.length()-1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(operators);
	}
	
	public String getAdministrators() {
		return administrators;
	}

	public void setAdministrators(String administrators) {
		this.administrators = administrators;
	}

	public SerManage_Server getServer() {
		return server;
	}

	public void setServer(SerManage_Server server) {
		this.server = server;
	}

	public String getDBServerArray() {
		return DBServerArray;
	}

	public void setDBServerArray(String dBServerArray) {
		DBServerArray = dBServerArray;
	}

	public String getAPPServerArray() {
		return APPServerArray;
	}

	public void setAPPServerArray(String aPPServerArray) {
		APPServerArray = aPPServerArray;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public BigInteger getTotal() {
		return total;
	}

	public void setTotal(BigInteger total) {
		this.total = total;
	}

	public String getLastupdatetime() {
		return lastupdatetime;
	}

	public void setLastupdatetime(String lastupdatetime) {
		this.lastupdatetime = lastupdatetime;
	}
}
