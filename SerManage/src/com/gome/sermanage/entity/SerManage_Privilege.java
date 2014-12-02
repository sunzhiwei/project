package com.gome.sermanage.entity;

import java.io.Serializable;

public class SerManage_Privilege implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8038648253166616114L;

	private Long id;
	
	private Long leaf;
	
	private String name;
	
	private String target;

	private String title;

	private String url;
	
	private Long pid;
	
	private Long subsequence;
	
	private Long levelid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLeaf() {
		return leaf;
	}

	public void setLeaf(Long leaf) {
		this.leaf = leaf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Long getSubsequence() {
		return subsequence;
	}

	public void setSubsequence(Long subsequence) {
		this.subsequence = subsequence;
	}

	public Long getLevelid() {
		return levelid;
	}

	public void setLevelid(Long levelid) {
		this.levelid = levelid;
	}

}
