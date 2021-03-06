package com.gome.gmhx.entity;

import java.util.Date;

import com.gome.common.util.FDate;


public class HxParcelReceipt {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_parcel_delivery.parcel_code
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
	private String orgId;
	private String billsCode;
	
    public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getBillsCode() {
		return billsCode;
	}

	public void setBillsCode(String billsCode) {
		this.billsCode = billsCode;
	}

	
	private String receiveUnitName;
	
	public String getReceiveUnitName() {
		return receiveUnitName;
	}

	public void setReceiveUnitName(String receiveUnitName) {
		this.receiveUnitName = receiveUnitName;
	}


	private String parcelCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_parcel_delivery.receive_unit
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    private String receiveUnit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_parcel_delivery.carrier_unit
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    private String carrierUnit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_parcel_delivery.state
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    private String state;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_parcel_delivery.update_date
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    private Date updateDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_parcel_delivery.send_date
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    private Date sendDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_parcel_delivery.delivery_way
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    private String deliveryWay;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_parcel_delivery.trantransportation_expenses
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    private String trantransportationExpenses;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_parcel_delivery.package_number
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    private String packageNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_parcel_delivery.package_weight
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    private String packageWeight;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_parcel_delivery.package_volume
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    private String packageVolume;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_parcel_delivery.volume_weight
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    private String volumeWeight;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_parcel_delivery.receive_name
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    private String receiveName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_parcel_delivery.receive_phone
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    private String receivePhone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_parcel_delivery.receive_post
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    private String receivePost;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_parcel_delivery.receive_address
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    private String receiveAddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_parcel_delivery.note
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    private String note;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_parcel_delivery.founders
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    private String founders;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_parcel_delivery.founder_date
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    private Date founderDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_parcel_delivery.modefieds
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    private String modefieds;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_parcel_delivery.modefied_date
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    private Date modefiedDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_parcel_delivery.send_number
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    private String sendNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_parcel_delivery.out_date
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    private Date outDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_parcel_delivery.send_unit
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    private String sendUnit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_parcel_delivery.receive_date
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    private Date receiveDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_parcel_delivery.type
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_parcel_delivery.fitting_code
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    private String fittingCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_parcel_delivery.fitting_name
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    private String fittingName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_parcel_delivery.norms
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    private String norms;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_parcel_delivery.number
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    private String number;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_parcel_delivery.parcel_code
     *
     * @return the value of hx_parcel_delivery.parcel_code
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public String getParcelCode() {
        return parcelCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_parcel_delivery.parcel_code
     *
     * @param parcelCode the value for hx_parcel_delivery.parcel_code
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public void setParcelCode(String parcelCode) {
        this.parcelCode = parcelCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_parcel_delivery.receive_unit
     *
     * @return the value of hx_parcel_delivery.receive_unit
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public String getReceiveUnit() {
        return receiveUnit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_parcel_delivery.receive_unit
     *
     * @param receiveUnit the value for hx_parcel_delivery.receive_unit
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public void setReceiveUnit(String receiveUnit) {
        this.receiveUnit = receiveUnit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_parcel_delivery.carrier_unit
     *
     * @return the value of hx_parcel_delivery.carrier_unit
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public String getCarrierUnit() {
        return carrierUnit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_parcel_delivery.carrier_unit
     *
     * @param carrierUnit the value for hx_parcel_delivery.carrier_unit
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public void setCarrierUnit(String carrierUnit) {
        this.carrierUnit = carrierUnit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_parcel_delivery.state
     *
     * @return the value of hx_parcel_delivery.state
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public String getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_parcel_delivery.state
     *
     * @param state the value for hx_parcel_delivery.state
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_parcel_delivery.update_date
     *
     * @return the value of hx_parcel_delivery.update_date
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_parcel_delivery.update_date
     *
     * @param updateDate the value for hx_parcel_delivery.update_date
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_parcel_delivery.send_date
     *
     * @return the value of hx_parcel_delivery.send_date
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public Date getSendDate() {
        return sendDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_parcel_delivery.send_date
     *
     * @param sendDate the value for hx_parcel_delivery.send_date
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_parcel_delivery.delivery_way
     *
     * @return the value of hx_parcel_delivery.delivery_way
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public String getDeliveryWay() {
        return deliveryWay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_parcel_delivery.delivery_way
     *
     * @param deliveryWay the value for hx_parcel_delivery.delivery_way
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public void setDeliveryWay(String deliveryWay) {
        this.deliveryWay = deliveryWay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_parcel_delivery.trantransportation_expenses
     *
     * @return the value of hx_parcel_delivery.trantransportation_expenses
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public String getTrantransportationExpenses() {
        return trantransportationExpenses;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_parcel_delivery.trantransportation_expenses
     *
     * @param trantransportationExpenses the value for hx_parcel_delivery.trantransportation_expenses
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public void setTrantransportationExpenses(String trantransportationExpenses) {
        this.trantransportationExpenses = trantransportationExpenses;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_parcel_delivery.package_number
     *
     * @return the value of hx_parcel_delivery.package_number
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public String getPackageNumber() {
        return packageNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_parcel_delivery.package_number
     *
     * @param packageNumber the value for hx_parcel_delivery.package_number
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public void setPackageNumber(String packageNumber) {
        this.packageNumber = packageNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_parcel_delivery.package_weight
     *
     * @return the value of hx_parcel_delivery.package_weight
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public String getPackageWeight() {
        return packageWeight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_parcel_delivery.package_weight
     *
     * @param packageWeight the value for hx_parcel_delivery.package_weight
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public void setPackageWeight(String packageWeight) {
        this.packageWeight = packageWeight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_parcel_delivery.package_volume
     *
     * @return the value of hx_parcel_delivery.package_volume
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public String getPackageVolume() {
        return packageVolume;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_parcel_delivery.package_volume
     *
     * @param packageVolume the value for hx_parcel_delivery.package_volume
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public void setPackageVolume(String packageVolume) {
        this.packageVolume = packageVolume;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_parcel_delivery.volume_weight
     *
     * @return the value of hx_parcel_delivery.volume_weight
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public String getVolumeWeight() {
        return volumeWeight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_parcel_delivery.volume_weight
     *
     * @param volumeWeight the value for hx_parcel_delivery.volume_weight
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public void setVolumeWeight(String volumeWeight) {
        this.volumeWeight = volumeWeight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_parcel_delivery.receive_name
     *
     * @return the value of hx_parcel_delivery.receive_name
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public String getReceiveName() {
        return receiveName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_parcel_delivery.receive_name
     *
     * @param receiveName the value for hx_parcel_delivery.receive_name
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_parcel_delivery.receive_phone
     *
     * @return the value of hx_parcel_delivery.receive_phone
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public String getReceivePhone() {
        return receivePhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_parcel_delivery.receive_phone
     *
     * @param receivePhone the value for hx_parcel_delivery.receive_phone
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_parcel_delivery.receive_post
     *
     * @return the value of hx_parcel_delivery.receive_post
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public String getReceivePost() {
        return receivePost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_parcel_delivery.receive_post
     *
     * @param receivePost the value for hx_parcel_delivery.receive_post
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public void setReceivePost(String receivePost) {
        this.receivePost = receivePost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_parcel_delivery.receive_address
     *
     * @return the value of hx_parcel_delivery.receive_address
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public String getReceiveAddress() {
        return receiveAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_parcel_delivery.receive_address
     *
     * @param receiveAddress the value for hx_parcel_delivery.receive_address
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_parcel_delivery.note
     *
     * @return the value of hx_parcel_delivery.note
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public String getNote() {
        return note;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_parcel_delivery.note
     *
     * @param note the value for hx_parcel_delivery.note
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_parcel_delivery.founders
     *
     * @return the value of hx_parcel_delivery.founders
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public String getFounders() {
        return founders;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_parcel_delivery.founders
     *
     * @param founders the value for hx_parcel_delivery.founders
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public void setFounders(String founders) {
        this.founders = founders;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_parcel_delivery.founder_date
     *
     * @return the value of hx_parcel_delivery.founder_date
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public Date getFounderDate() {
        return founderDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_parcel_delivery.founder_date
     *
     * @param founderDate the value for hx_parcel_delivery.founder_date
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public void setFounderDate(Date founderDate) {
        this.founderDate = founderDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_parcel_delivery.modefieds
     *
     * @return the value of hx_parcel_delivery.modefieds
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public String getModefieds() {
        return modefieds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_parcel_delivery.modefieds
     *
     * @param modefieds the value for hx_parcel_delivery.modefieds
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public void setModefieds(String modefieds) {
        this.modefieds = modefieds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_parcel_delivery.modefied_date
     *
     * @return the value of hx_parcel_delivery.modefied_date
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public Date getModefiedDate() {
        return modefiedDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_parcel_delivery.modefied_date
     *
     * @param modefiedDate the value for hx_parcel_delivery.modefied_date
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public void setModefiedDate(Date modefiedDate) {
        this.modefiedDate = modefiedDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_parcel_delivery.send_number
     *
     * @return the value of hx_parcel_delivery.send_number
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public String getSendNumber() {
        return sendNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_parcel_delivery.send_number
     *
     * @param sendNumber the value for hx_parcel_delivery.send_number
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public void setSendNumber(String sendNumber) {
        this.sendNumber = sendNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_parcel_delivery.out_date
     *
     * @return the value of hx_parcel_delivery.out_date
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public Date getOutDate() {
        return outDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_parcel_delivery.out_date
     *
     * @param outDate the value for hx_parcel_delivery.out_date
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public void setOutDate(String outDate) {
        this.outDate = FDate.getDate(outDate);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_parcel_delivery.out_date
     *
     * @param outDate the value for hx_parcel_delivery.out_date
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_parcel_delivery.send_unit
     *
     * @return the value of hx_parcel_delivery.send_unit
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public String getSendUnit() {
        return sendUnit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_parcel_delivery.send_unit
     *
     * @param sendUnit the value for hx_parcel_delivery.send_unit
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public void setSendUnit(String sendUnit) {
        this.sendUnit = sendUnit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_parcel_delivery.receive_date
     *
     * @return the value of hx_parcel_delivery.receive_date
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public Date getReceiveDate() {
        return receiveDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_parcel_delivery.receive_date
     *
     * @param receiveDate the value for hx_parcel_delivery.receive_date
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_parcel_delivery.type
     *
     * @return the value of hx_parcel_delivery.type
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_parcel_delivery.type
     *
     * @param type the value for hx_parcel_delivery.type
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_parcel_delivery.fitting_code
     *
     * @return the value of hx_parcel_delivery.fitting_code
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public String getFittingCode() {
        return fittingCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_parcel_delivery.fitting_code
     *
     * @param fittingCode the value for hx_parcel_delivery.fitting_code
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public void setFittingCode(String fittingCode) {
        this.fittingCode = fittingCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_parcel_delivery.fitting_name
     *
     * @return the value of hx_parcel_delivery.fitting_name
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public String getFittingName() {
        return fittingName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_parcel_delivery.fitting_name
     *
     * @param fittingName the value for hx_parcel_delivery.fitting_name
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public void setFittingName(String fittingName) {
        this.fittingName = fittingName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_parcel_delivery.norms
     *
     * @return the value of hx_parcel_delivery.norms
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public String getNorms() {
        return norms;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_parcel_delivery.norms
     *
     * @param norms the value for hx_parcel_delivery.norms
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public void setNorms(String norms) {
        this.norms = norms;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_parcel_delivery.number
     *
     * @return the value of hx_parcel_delivery.number
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public String getNumber() {
        return number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_parcel_delivery.number
     *
     * @param number the value for hx_parcel_delivery.number
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hx_parcel_delivery
     *
     * @mbggenerated Thu Sep 25 10:17:05 CST 2014
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orgId=").append(orgId);
        sb.append(", billsCode=").append(billsCode);
        sb.append(", parcelCode=").append(parcelCode);
        sb.append(", receiveUnit=").append(receiveUnit);
        sb.append(", carrierUnit=").append(carrierUnit);
        sb.append(", state=").append(state);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", sendDate=").append(sendDate);
        sb.append(", deliveryWay=").append(deliveryWay);
        sb.append(", trantransportationExpenses=").append(trantransportationExpenses);
        sb.append(", packageNumber=").append(packageNumber);
        sb.append(", packageWeight=").append(packageWeight);
        sb.append(", packageVolume=").append(packageVolume);
        sb.append(", volumeWeight=").append(volumeWeight);
        sb.append(", receiveName=").append(receiveName);
        sb.append(", receivePhone=").append(receivePhone);
        sb.append(", receivePost=").append(receivePost);
        sb.append(", receiveAddress=").append(receiveAddress);
        sb.append(", note=").append(note);
        sb.append(", founders=").append(founders);
        sb.append(", founderDate=").append(founderDate);
        sb.append(", modefieds=").append(modefieds);
        sb.append(", modefiedDate=").append(modefiedDate);
        sb.append(", sendNumber=").append(sendNumber);
        sb.append(", outDate=").append(outDate);
        sb.append(", sendUnit=").append(sendUnit);
        sb.append(", receiveDate=").append(receiveDate);
        sb.append(", type=").append(type);
        sb.append(", fittingCode=").append(fittingCode);
        sb.append(", fittingName=").append(fittingName);
        sb.append(", norms=").append(norms);
        sb.append(", number=").append(number);
        sb.append("]");
        return sb.toString();
    }
}