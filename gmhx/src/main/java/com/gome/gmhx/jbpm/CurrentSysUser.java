package com.gome.gmhx.jbpm;

import com.gome.gmhx.entity.SysUser;

public class CurrentSysUser {
	
	public static final String servicePositon = "service";//系统岗位
	public static final String materialPositon = "material";//物料岗位
	
	private static ThreadLocal<SysUser> sysUsers = new ThreadLocal<SysUser>();
	
	public static void setCurrentSysUser(SysUser sysUser){
		sysUsers.set(sysUser);
	}
	
	public static SysUser getCurrentSysUser(){
		return sysUsers.get();
	}
	
	public static void removeCurrentSysUser(){
		sysUsers.remove();
	}

}
