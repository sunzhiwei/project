package com.gome.sermanage.entity;

import java.io.Serializable;

public class SerManage_Server implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1873303920112293409L;

	private Long id;
	
	private String environment;
	
	private String systemname;
	
	private String pcname;

	private String ipurl;

	private String os;
	
	private String cpu;
	
	private String mem;
	
	private String disk;
	
	private Long apptype;  // 0:数据库服务器    1:应用服务器 

	private String appdescription;
	
	private String f5deploy;
	
	private String administrator;
	
	private String updatetime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getSystemname() {
		return systemname;
	}

	public void setSystemname(String systemname) {
		this.systemname = systemname;
	}

	public String getPcname() {
		return pcname;
	}

	public void setPcname(String pcname) {
		this.pcname = pcname;
	}

	public String getIpurl() {
		return ipurl;
	}

	public void setIpurl(String ipurl) {
		this.ipurl = ipurl;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getMem() {
		return mem;
	}

	public void setMem(String mem) {
		this.mem = mem;
	}

	public String getDisk() {
		return disk;
	}

	public void setDisk(String disk) {
		this.disk = disk;
	}

	public Long getApptype() {
		return apptype;
	}

	public void setApptype(Long apptype) {
		this.apptype = apptype;
	}

	public String getAppdescription() {
		return appdescription;
	}

	public void setAppdescription(String appdescription) {
		this.appdescription = appdescription;
	}

	public String getF5deploy() {
		return f5deploy;
	}

	public void setF5deploy(String f5deploy) {
		this.f5deploy = f5deploy;
	}

	public String getAdministrator() {
		return administrator;
	}

	public void setAdministrator(String administrator) {
		this.administrator = administrator;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
}
