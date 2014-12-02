package com.gome.gmhx.entity.vo;

/*
 * 当前库存VO
 */
public class HxCurrentStockVO {
	private String orgName; //网点、分部名称
	private String orgId;//机构编码
	private String suitModel;//适用机型
	private String fittingCode;//配件编码
	private String fittingName;//配件名称
	private String partsCode;//部品号
	private Boolean isNew;//新料旧料
	
	
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getSuitModel() {
		return suitModel;
	}
	public void setSuitModel(String suitModel) {
		this.suitModel = suitModel;
	}
	public String getFittingCode() {
		return fittingCode;
	}
	public void setFittingCode(String fittingCode) {
		this.fittingCode = fittingCode;
	}
	public String getFittingName() {
		return fittingName;
	}
	public void setFittingName(String fittingName) {
		this.fittingName = fittingName;
	}
	public String getPartsCode() {
		return partsCode;
	}
	public void setPartsCode(String partsCode) {
		this.partsCode = partsCode;
	}
	public Boolean getIsNew() {
		return isNew;
	}
	public void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}
}
