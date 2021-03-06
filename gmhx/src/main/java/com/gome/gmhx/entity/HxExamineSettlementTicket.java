package com.gome.gmhx.entity;

import java.util.Date;

import com.gome.gmhx.jbpm.JbpmWorkEntity;

public class HxExamineSettlementTicket implements JbpmWorkEntity{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_examine_settlement_ticket.settlement_id
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    private String settlementId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_examine_settlement_ticket.settlement_time
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    private Date settlementTime;

    private Integer sequence;
	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_examine_settlement_ticket.service_unit
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    private String serviceUnit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_examine_settlement_ticket.parent_organization
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    private String parentOrganization;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_examine_settlement_ticket.brand
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    private String brand;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_examine_settlement_ticket.settlement_type
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    private String settlementType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_examine_settlement_ticket.settlement_fee
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    private Float settlementFee;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_examine_settlement_ticket.settlement_factor
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    private Integer settlementFactor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_examine_settlement_ticket.service_fee
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    private Float serviceFee;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_examine_settlement_ticket.reward_fee
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    private Float rewardFee;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_examine_settlement_ticket.reward_quantity
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    private Integer rewardQuantity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_examine_settlement_ticket.punish_fee
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    private Float punishFee;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_examine_settlement_ticket.punish_quantity
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    private Integer punishQuantity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_examine_settlement_ticket.other_fee
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    private Float otherFee;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_examine_settlement_ticket.other_quantity
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    private Integer otherQuantity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_examine_settlement_ticket.fake_deduct_factor
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    private Integer fakeDeductFactor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_examine_settlement_ticket.settlement_status
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    private String settlementStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_examine_settlement_ticket.headquarters_check_man
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    private String headquartersCheckMan;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_examine_settlement_ticket.headquarters_check_time
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    private Date headquartersCheckTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_examine_settlement_ticket.settlement_unit_confirm_man
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    private String settlementUnitConfirmMan;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_examine_settlement_ticket.settlement_unit_confirm_time
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    private Date settlementUnitConfirmTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_examine_settlement_ticket.settlement_unit_comment
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    private String settlementUnitComment;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_examine_settlement_ticket.comment
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    private String comment;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_examine_settlement_ticket.create_man
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    private String createMan;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_examine_settlement_ticket.create_time
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_examine_settlement_ticket.alter_man
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    private String alterMan;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_examine_settlement_ticket.alter_time
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    private Date alterTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_examine_settlement_ticket.processInstance_id
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    private String processInstanceId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_examine_settlement_ticket.applicant
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    private String applicant;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_examine_settlement_ticket.apply_date
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    private Date applyDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_examine_settlement_ticket.create_position
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    private String createPosition;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_examine_settlement_ticket.is_pass_check
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    private Boolean isPassCheck;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_examine_settlement_ticket.settlement_id
     *
     * @return the value of hx_examine_settlement_ticket.settlement_id
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public String getSettlementId() {
        return settlementId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_examine_settlement_ticket.settlement_id
     *
     * @param settlementId the value for hx_examine_settlement_ticket.settlement_id
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public void setSettlementId(String settlementId) {
        this.settlementId = settlementId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_examine_settlement_ticket.settlement_time
     *
     * @return the value of hx_examine_settlement_ticket.settlement_time
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public Date getSettlementTime() {
        return settlementTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_examine_settlement_ticket.settlement_time
     *
     * @param settlementTime the value for hx_examine_settlement_ticket.settlement_time
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public void setSettlementTime(Date settlementTime) {
        this.settlementTime = settlementTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_examine_settlement_ticket.service_unit
     *
     * @return the value of hx_examine_settlement_ticket.service_unit
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public String getServiceUnit() {
        return serviceUnit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_examine_settlement_ticket.service_unit
     *
     * @param serviceUnit the value for hx_examine_settlement_ticket.service_unit
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public void setServiceUnit(String serviceUnit) {
        this.serviceUnit = serviceUnit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_examine_settlement_ticket.parent_organization
     *
     * @return the value of hx_examine_settlement_ticket.parent_organization
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public String getParentOrganization() {
        return parentOrganization;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_examine_settlement_ticket.parent_organization
     *
     * @param parentOrganization the value for hx_examine_settlement_ticket.parent_organization
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public void setParentOrganization(String parentOrganization) {
        this.parentOrganization = parentOrganization;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_examine_settlement_ticket.brand
     *
     * @return the value of hx_examine_settlement_ticket.brand
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public String getBrand() {
        return brand;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_examine_settlement_ticket.brand
     *
     * @param brand the value for hx_examine_settlement_ticket.brand
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_examine_settlement_ticket.settlement_type
     *
     * @return the value of hx_examine_settlement_ticket.settlement_type
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public String getSettlementType() {
        return settlementType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_examine_settlement_ticket.settlement_type
     *
     * @param settlementType the value for hx_examine_settlement_ticket.settlement_type
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public void setSettlementType(String settlementType) {
        this.settlementType = settlementType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_examine_settlement_ticket.settlement_fee
     *
     * @return the value of hx_examine_settlement_ticket.settlement_fee
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public Float getSettlementFee() {
        return settlementFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_examine_settlement_ticket.settlement_fee
     *
     * @param settlementFee the value for hx_examine_settlement_ticket.settlement_fee
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public void setSettlementFee(Float settlementFee) {
        this.settlementFee = settlementFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_examine_settlement_ticket.settlement_factor
     *
     * @return the value of hx_examine_settlement_ticket.settlement_factor
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public Integer getSettlementFactor() {
        return settlementFactor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_examine_settlement_ticket.settlement_factor
     *
     * @param settlementFactor the value for hx_examine_settlement_ticket.settlement_factor
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public void setSettlementFactor(Integer settlementFactor) {
        this.settlementFactor = settlementFactor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_examine_settlement_ticket.service_fee
     *
     * @return the value of hx_examine_settlement_ticket.service_fee
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public Float getServiceFee() {
        return serviceFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_examine_settlement_ticket.service_fee
     *
     * @param serviceFee the value for hx_examine_settlement_ticket.service_fee
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public void setServiceFee(Float serviceFee) {
        this.serviceFee = serviceFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_examine_settlement_ticket.reward_fee
     *
     * @return the value of hx_examine_settlement_ticket.reward_fee
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public Float getRewardFee() {
        return rewardFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_examine_settlement_ticket.reward_fee
     *
     * @param rewardFee the value for hx_examine_settlement_ticket.reward_fee
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public void setRewardFee(Float rewardFee) {
        this.rewardFee = rewardFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_examine_settlement_ticket.reward_quantity
     *
     * @return the value of hx_examine_settlement_ticket.reward_quantity
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public Integer getRewardQuantity() {
        return rewardQuantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_examine_settlement_ticket.reward_quantity
     *
     * @param rewardQuantity the value for hx_examine_settlement_ticket.reward_quantity
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public void setRewardQuantity(Integer rewardQuantity) {
        this.rewardQuantity = rewardQuantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_examine_settlement_ticket.punish_fee
     *
     * @return the value of hx_examine_settlement_ticket.punish_fee
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public Float getPunishFee() {
        return punishFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_examine_settlement_ticket.punish_fee
     *
     * @param punishFee the value for hx_examine_settlement_ticket.punish_fee
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public void setPunishFee(Float punishFee) {
        this.punishFee = punishFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_examine_settlement_ticket.punish_quantity
     *
     * @return the value of hx_examine_settlement_ticket.punish_quantity
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public Integer getPunishQuantity() {
        return punishQuantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_examine_settlement_ticket.punish_quantity
     *
     * @param punishQuantity the value for hx_examine_settlement_ticket.punish_quantity
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public void setPunishQuantity(Integer punishQuantity) {
        this.punishQuantity = punishQuantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_examine_settlement_ticket.other_fee
     *
     * @return the value of hx_examine_settlement_ticket.other_fee
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public Float getOtherFee() {
        return otherFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_examine_settlement_ticket.other_fee
     *
     * @param otherFee the value for hx_examine_settlement_ticket.other_fee
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public void setOtherFee(Float otherFee) {
        this.otherFee = otherFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_examine_settlement_ticket.other_quantity
     *
     * @return the value of hx_examine_settlement_ticket.other_quantity
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public Integer getOtherQuantity() {
        return otherQuantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_examine_settlement_ticket.other_quantity
     *
     * @param otherQuantity the value for hx_examine_settlement_ticket.other_quantity
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public void setOtherQuantity(Integer otherQuantity) {
        this.otherQuantity = otherQuantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_examine_settlement_ticket.fake_deduct_factor
     *
     * @return the value of hx_examine_settlement_ticket.fake_deduct_factor
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public Integer getFakeDeductFactor() {
        return fakeDeductFactor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_examine_settlement_ticket.fake_deduct_factor
     *
     * @param fakeDeductFactor the value for hx_examine_settlement_ticket.fake_deduct_factor
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public void setFakeDeductFactor(Integer fakeDeductFactor) {
        this.fakeDeductFactor = fakeDeductFactor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_examine_settlement_ticket.settlement_status
     *
     * @return the value of hx_examine_settlement_ticket.settlement_status
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public String getSettlementStatus() {
        return settlementStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_examine_settlement_ticket.settlement_status
     *
     * @param settlementStatus the value for hx_examine_settlement_ticket.settlement_status
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public void setSettlementStatus(String settlementStatus) {
        this.settlementStatus = settlementStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_examine_settlement_ticket.headquarters_check_man
     *
     * @return the value of hx_examine_settlement_ticket.headquarters_check_man
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public String getHeadquartersCheckMan() {
        return headquartersCheckMan;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_examine_settlement_ticket.headquarters_check_man
     *
     * @param headquartersCheckMan the value for hx_examine_settlement_ticket.headquarters_check_man
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public void setHeadquartersCheckMan(String headquartersCheckMan) {
        this.headquartersCheckMan = headquartersCheckMan;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_examine_settlement_ticket.headquarters_check_time
     *
     * @return the value of hx_examine_settlement_ticket.headquarters_check_time
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public Date getHeadquartersCheckTime() {
        return headquartersCheckTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_examine_settlement_ticket.headquarters_check_time
     *
     * @param headquartersCheckTime the value for hx_examine_settlement_ticket.headquarters_check_time
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public void setHeadquartersCheckTime(Date headquartersCheckTime) {
        this.headquartersCheckTime = headquartersCheckTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_examine_settlement_ticket.settlement_unit_confirm_man
     *
     * @return the value of hx_examine_settlement_ticket.settlement_unit_confirm_man
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public String getSettlementUnitConfirmMan() {
        return settlementUnitConfirmMan;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_examine_settlement_ticket.settlement_unit_confirm_man
     *
     * @param settlementUnitConfirmMan the value for hx_examine_settlement_ticket.settlement_unit_confirm_man
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public void setSettlementUnitConfirmMan(String settlementUnitConfirmMan) {
        this.settlementUnitConfirmMan = settlementUnitConfirmMan;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_examine_settlement_ticket.settlement_unit_confirm_time
     *
     * @return the value of hx_examine_settlement_ticket.settlement_unit_confirm_time
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public Date getSettlementUnitConfirmTime() {
        return settlementUnitConfirmTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_examine_settlement_ticket.settlement_unit_confirm_time
     *
     * @param settlementUnitConfirmTime the value for hx_examine_settlement_ticket.settlement_unit_confirm_time
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public void setSettlementUnitConfirmTime(Date settlementUnitConfirmTime) {
        this.settlementUnitConfirmTime = settlementUnitConfirmTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_examine_settlement_ticket.settlement_unit_comment
     *
     * @return the value of hx_examine_settlement_ticket.settlement_unit_comment
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public String getSettlementUnitComment() {
        return settlementUnitComment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_examine_settlement_ticket.settlement_unit_comment
     *
     * @param settlementUnitComment the value for hx_examine_settlement_ticket.settlement_unit_comment
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public void setSettlementUnitComment(String settlementUnitComment) {
        this.settlementUnitComment = settlementUnitComment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_examine_settlement_ticket.comment
     *
     * @return the value of hx_examine_settlement_ticket.comment
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public String getComment() {
        return comment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_examine_settlement_ticket.comment
     *
     * @param comment the value for hx_examine_settlement_ticket.comment
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_examine_settlement_ticket.create_man
     *
     * @return the value of hx_examine_settlement_ticket.create_man
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public String getCreateMan() {
        return createMan;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_examine_settlement_ticket.create_man
     *
     * @param createMan the value for hx_examine_settlement_ticket.create_man
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public void setCreateMan(String createMan) {
        this.createMan = createMan;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_examine_settlement_ticket.create_time
     *
     * @return the value of hx_examine_settlement_ticket.create_time
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_examine_settlement_ticket.create_time
     *
     * @param createTime the value for hx_examine_settlement_ticket.create_time
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_examine_settlement_ticket.alter_man
     *
     * @return the value of hx_examine_settlement_ticket.alter_man
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public String getAlterMan() {
        return alterMan;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_examine_settlement_ticket.alter_man
     *
     * @param alterMan the value for hx_examine_settlement_ticket.alter_man
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public void setAlterMan(String alterMan) {
        this.alterMan = alterMan;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_examine_settlement_ticket.alter_time
     *
     * @return the value of hx_examine_settlement_ticket.alter_time
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public Date getAlterTime() {
        return alterTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_examine_settlement_ticket.alter_time
     *
     * @param alterTime the value for hx_examine_settlement_ticket.alter_time
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public void setAlterTime(Date alterTime) {
        this.alterTime = alterTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_examine_settlement_ticket.processInstance_id
     *
     * @return the value of hx_examine_settlement_ticket.processInstance_id
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public String getProcessInstanceId() {
        return processInstanceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_examine_settlement_ticket.processInstance_id
     *
     * @param processinstanceId the value for hx_examine_settlement_ticket.processInstance_id
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_examine_settlement_ticket.applicant
     *
     * @return the value of hx_examine_settlement_ticket.applicant
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public String getApplicant() {
        return applicant;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_examine_settlement_ticket.applicant
     *
     * @param applicant the value for hx_examine_settlement_ticket.applicant
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_examine_settlement_ticket.apply_date
     *
     * @return the value of hx_examine_settlement_ticket.apply_date
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public Date getApplyDate() {
        return applyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_examine_settlement_ticket.apply_date
     *
     * @param applyDate the value for hx_examine_settlement_ticket.apply_date
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_examine_settlement_ticket.create_position
     *
     * @return the value of hx_examine_settlement_ticket.create_position
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public String getCreatePosition() {
        return createPosition;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_examine_settlement_ticket.create_position
     *
     * @param createPosition the value for hx_examine_settlement_ticket.create_position
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public void setCreatePosition(String createPosition) {
        this.createPosition = createPosition;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_examine_settlement_ticket.is_pass_check
     *
     * @return the value of hx_examine_settlement_ticket.is_pass_check
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public Boolean getIsPassCheck() {
        return isPassCheck;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_examine_settlement_ticket.is_pass_check
     *
     * @param isPassCheck the value for hx_examine_settlement_ticket.is_pass_check
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    public void setIsPassCheck(Boolean isPassCheck) {
        this.isPassCheck = isPassCheck;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hx_examine_settlement_ticket
     *
     * @mbggenerated Tue Dec 02 09:58:46 CST 2014
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", settlementId=").append(settlementId);
        sb.append(", settlementTime=").append(settlementTime);
        sb.append(", serviceUnit=").append(serviceUnit);
        sb.append(", parentOrganization=").append(parentOrganization);
        sb.append(", brand=").append(brand);
        sb.append(", settlementType=").append(settlementType);
        sb.append(", settlementFee=").append(settlementFee);
        sb.append(", settlementFactor=").append(settlementFactor);
        sb.append(", serviceFee=").append(serviceFee);
        sb.append(", rewardFee=").append(rewardFee);
        sb.append(", rewardQuantity=").append(rewardQuantity);
        sb.append(", punishFee=").append(punishFee);
        sb.append(", punishQuantity=").append(punishQuantity);
        sb.append(", otherFee=").append(otherFee);
        sb.append(", otherQuantity=").append(otherQuantity);
        sb.append(", fakeDeductFactor=").append(fakeDeductFactor);
        sb.append(", settlementStatus=").append(settlementStatus);
        sb.append(", headquartersCheckMan=").append(headquartersCheckMan);
        sb.append(", headquartersCheckTime=").append(headquartersCheckTime);
        sb.append(", settlementUnitConfirmMan=").append(settlementUnitConfirmMan);
        sb.append(", settlementUnitConfirmTime=").append(settlementUnitConfirmTime);
        sb.append(", settlementUnitComment=").append(settlementUnitComment);
        sb.append(", comment=").append(comment);
        sb.append(", createMan=").append(createMan);
        sb.append(", createTime=").append(createTime);
        sb.append(", alterMan=").append(alterMan);
        sb.append(", alterTime=").append(alterTime);
        sb.append(", processInstanceId=").append(processInstanceId);
        sb.append(", applicant=").append(applicant);
        sb.append(", applyDate=").append(applyDate);
        sb.append(", createPosition=").append(createPosition);
        sb.append(", isPassCheck=").append(isPassCheck);
        sb.append("]");
        return sb.toString();
    }

	@Override
	public String getWorkEntityId() {
		
		return settlementId;
	}

	@Override
	public String getStatus() {
		
		return settlementStatus;
	}

	@Override
	public void setStatus(String status) {
		this.settlementStatus = status;
	}
	
	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

}