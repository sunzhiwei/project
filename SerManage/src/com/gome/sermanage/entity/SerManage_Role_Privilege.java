package com.gome.sermanage.entity;

import java.io.Serializable;

public class SerManage_Role_Privilege implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5391278595056456437L;

	private Long id;
	
	private Long roleid;
	
	private Long privilegeid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRoleid() {
		return roleid;
	}

	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}

	public Long getPrivilegeid() {
		return privilegeid;
	}

	public void setPrivilegeid(Long privilegeid) {
		this.privilegeid = privilegeid;
	}
}
