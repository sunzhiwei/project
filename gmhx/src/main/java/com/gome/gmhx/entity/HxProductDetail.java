package com.gome.gmhx.entity;

import java.util.Date;
import java.util.UUID;

import com.gome.common.util.UUIDGenerator;

public class HxProductDetail {
	private String id;
    private String model;
    private String classifyCode;
    private String productCode;
    private String productName;
    private String englishName;
    private String modelClassify;
    private String productModel;
    private String gomeCode;
    private Boolean isNew;
    private Boolean isPreferential;
    private Float installationFee;
    private String spec;
    private String refrigeration;
    private Float price;
    private String comment;
    private Date updateTime;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getClassifyCode() {
		return classifyCode;
	}
	public void setClassifyCode(String classifyCode) {
		this.classifyCode = classifyCode;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getEnglishName() {
		return englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	public String getModelClassify() {
		return modelClassify;
	}
	public void setModelClassify(String modelClassify) {
		this.modelClassify = modelClassify;
	}
	public String getProductModel() {
		return productModel;
	}
	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}
	public String getGomeCode() {
		return gomeCode;
	}
	public void setGomeCode(String gomeCode) {
		this.gomeCode = gomeCode;
	}
	public Boolean getIsNew() {
		return isNew;
	}
	public void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}
	public Boolean getIsPreferential() {
		return isPreferential;
	}
	public void setIsPreferential(Boolean isPreferential) {
		this.isPreferential = isPreferential;
	}
	public Float getInstallationFee() {
		return installationFee;
	}
	public void setInstallationFee(Float installationFee) {
		this.installationFee = installationFee;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public String getRefrigeration() {
		return refrigeration;
	}
	public void setRefrigeration(String refrigeration) {
		this.refrigeration = refrigeration;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public HxProductDetail(){
		this.updateTime = new Date();
		this.id =UUIDGenerator.getUUID();
	}
}