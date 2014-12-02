package com.gome.sermanage.entity;

import java.io.Serializable;

public class SerManage_User_Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 287962097011109839L;

	private Long id;
	
	private Long userid;
	
	private Long roleid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Long getRoleid() {
		return roleid;
	}

	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}
}
