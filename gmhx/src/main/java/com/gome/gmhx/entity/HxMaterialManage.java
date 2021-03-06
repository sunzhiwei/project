package com.gome.gmhx.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.gome.gmhx.jbpm.JbpmWorkEntity;

public class HxMaterialManage implements JbpmWorkEntity{
    private String type;
    private String sendCompany;
    private String receiveCompany;
    private String listNumber;
    private String proposer;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date applyDate;
    private String comment;
    private String customerName;
    private String customerTel;
    private String address;
    private String status;
    private String fittingOrgId;
    private String fittingPositionId;
    private Date createTime;
    private String createPerson;
    private Date updateTime;
    private String updatePerson;
    private String sendNumber;
    private String relatedListNumber;//总部新料采购对应的分部申请单号
    private String moveDirection;//分部库存转移良品，次品转移
    private String processInstanceId;
    private String applicant;//工作流的用户的身份标识
    private String inBatch;
    private String outBatch;
    
    public String getRelatedListNumber() {
		return relatedListNumber;
	}
	public void setRelatedListNumber(String relatedListNumber) {
		this.relatedListNumber = relatedListNumber;
	}
	public String getMoveDirection() {
		return moveDirection;
	}
	public void setMoveDirection(String moveDirection) {
		this.moveDirection = moveDirection;
	}
    
    public String getFittingOrgId() {
		return fittingOrgId;
	}
	public void setFittingOrgId(String fittingOrgId) {
		this.fittingOrgId = fittingOrgId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSendCompany() {
		return sendCompany;
	}
	public void setSendCompany(String sendCompany) {
		this.sendCompany = sendCompany;
	}
	public String getReceiveCompany() {
		return receiveCompany;
	}
	public void setReceiveCompany(String receiveCompany) {
		this.receiveCompany = receiveCompany;
	}
	public String getListNumber() {
		return listNumber;
	}
	public void setListNumber(String listNumber) {
		this.listNumber = listNumber;
	}
	public String getProposer() {
		return proposer;
	}
	public void setProposer(String proposer) {
		this.proposer = proposer;
	}
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerTel() {
		return customerTel;
	}
	public void setCustomerTel(String customerTel) {
		this.customerTel = customerTel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFittingPositionId() {
		return fittingPositionId;
	}
	public void setFittingPositionId(String fittingPositionId) {
		this.fittingPositionId = fittingPositionId;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreatePerson() {
		return createPerson;
	}
	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}
	public String getUpdatePerson() {
		return updatePerson;
	}
	public void setUpdatePerson(String updatePerson) {
		this.updatePerson = updatePerson;
	}
	public String getSendNumber() {
		return sendNumber;
	}
	public void setSendNumber(String sendNumber) {
		this.sendNumber = sendNumber;
	}
	@Override
	public String getProcessInstanceId() {
		return processInstanceId;
	}
	@Override
	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	@Override
	public String getWorkEntityId() {
		return listNumber;
	}
	@Override
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
	@Override
	public String getApplicant() {
		return applicant;
	}
	public String getInBatch() {
		return inBatch;
	}
	public void setInBatch(String inBatch) {
		this.inBatch = inBatch;
	}
	public String getOutBatch() {
		return outBatch;
	}
	public void setOutBatch(String outBatch) {
		this.outBatch = outBatch;
	}
}