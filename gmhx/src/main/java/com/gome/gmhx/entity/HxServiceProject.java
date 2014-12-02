package com.gome.gmhx.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class HxServiceProject {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_service_project.product_id
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    private String serviceId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_service_project.machine_type
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    private String machineType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_service_project.internal_machine_code1
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    private String internalMachineCode1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_service_project.internal_machine_code2
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    private String internalMachineCode2;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_service_project.external_machine_code
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    private String externalMachineCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_service_project.install_card_num
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    private BigDecimal installCardNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_service_project.install_date
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date installDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_service_project.installer
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    private String installer;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_service_project.is_double_install
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    private String isDoubleInstall;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_service_project.warranty_policy
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    private String warrantyPolicy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_service_project.delay_fee
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    private Float delayFee;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_service_project.other_fee
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    private Float otherFee;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hx_service_project.comment_p
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    private String commentP;
    
    private String gomeCode;
    
    private String brand;

    public String getGomeCode() {
		return gomeCode;
	}

	public String getBrand() {
		return brand;
	}

	public void setGomeCode(String gomeCode) {
		this.gomeCode = gomeCode;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_service_project.product_id
     *
     * @return the value of hx_service_project.product_id
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    public String getServiceId() {
        return serviceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_service_project.product_id
     *
     * @param productId the value for hx_service_project.product_id
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_service_project.machine_type
     *
     * @return the value of hx_service_project.machine_type
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    public String getMachineType() {
        return machineType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_service_project.machine_type
     *
     * @param machineType the value for hx_service_project.machine_type
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_service_project.internal_machine_code1
     *
     * @return the value of hx_service_project.internal_machine_code1
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    public String getInternalMachineCode1() {
        return internalMachineCode1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_service_project.internal_machine_code1
     *
     * @param internalMachineCode1 the value for hx_service_project.internal_machine_code1
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    public void setInternalMachineCode1(String internalMachineCode1) {
        this.internalMachineCode1 = internalMachineCode1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_service_project.internal_machine_code2
     *
     * @return the value of hx_service_project.internal_machine_code2
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    public String getInternalMachineCode2() {
        return internalMachineCode2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_service_project.internal_machine_code2
     *
     * @param internalMachineCode2 the value for hx_service_project.internal_machine_code2
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    public void setInternalMachineCode2(String internalMachineCode2) {
        this.internalMachineCode2 = internalMachineCode2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_service_project.external_machine_code
     *
     * @return the value of hx_service_project.external_machine_code
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    public String getExternalMachineCode() {
        return externalMachineCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_service_project.external_machine_code
     *
     * @param externalMachineCode the value for hx_service_project.external_machine_code
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    public void setExternalMachineCode(String externalMachineCode) {
        this.externalMachineCode = externalMachineCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_service_project.install_card_num
     *
     * @return the value of hx_service_project.install_card_num
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    public BigDecimal getInstallCardNum() {
        return installCardNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_service_project.install_card_num
     *
     * @param installCardNum the value for hx_service_project.install_card_num
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    public void setInstallCardNum(BigDecimal installCardNum) {
        this.installCardNum = installCardNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_service_project.install_date
     *
     * @return the value of hx_service_project.install_date
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    public Date getInstallDate() {
        return installDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_service_project.install_date
     *
     * @param installDate the value for hx_service_project.install_date
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    public void setInstallDate(Date installDate) {
        this.installDate = installDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_service_project.installer
     *
     * @return the value of hx_service_project.installer
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    public String getInstaller() {
        return installer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_service_project.installer
     *
     * @param installer the value for hx_service_project.installer
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    public void setInstaller(String installer) {
        this.installer = installer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_service_project.is_double_install
     *
     * @return the value of hx_service_project.is_double_install
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    public String getIsDoubleInstall() {
        return isDoubleInstall;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_service_project.is_double_install
     *
     * @param isDoubleInstall the value for hx_service_project.is_double_install
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    public void setIsDoubleInstall(String isDoubleInstall) {
        this.isDoubleInstall = isDoubleInstall;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_service_project.warranty_policy
     *
     * @return the value of hx_service_project.warranty_policy
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    public String getWarrantyPolicy() {
        return warrantyPolicy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_service_project.warranty_policy
     *
     * @param warrantyPolicy the value for hx_service_project.warranty_policy
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    public void setWarrantyPolicy(String warrantyPolicy) {
        this.warrantyPolicy = warrantyPolicy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_service_project.delay_fee
     *
     * @return the value of hx_service_project.delay_fee
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    public Float getDelayFee() {
        return delayFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_service_project.delay_fee
     *
     * @param delayFee the value for hx_service_project.delay_fee
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    public void setDelayFee(Float delayFee) {
        this.delayFee = delayFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_service_project.other_fee
     *
     * @return the value of hx_service_project.other_fee
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    public Float getOtherFee() {
        return otherFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_service_project.other_fee
     *
     * @param otherFee the value for hx_service_project.other_fee
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    public void setOtherFee(Float otherFee) {
        this.otherFee = otherFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hx_service_project.comment_p
     *
     * @return the value of hx_service_project.comment_p
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    public String getCommentP() {
        return commentP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hx_service_project.comment_p
     *
     * @param commentP the value for hx_service_project.comment_p
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    public void setCommentP(String commentP) {
        this.commentP = commentP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hx_service_project
     *
     * @mbggenerated Tue Sep 02 10:49:09 CST 2014
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serviceId=").append(serviceId);
        sb.append(", machineType=").append(machineType);
        sb.append(", internalMachineCode1=").append(internalMachineCode1);
        sb.append(", internalMachineCode2=").append(internalMachineCode2);
        sb.append(", externalMachineCode=").append(externalMachineCode);
        sb.append(", installCardNum=").append(installCardNum);
        sb.append(", installDate=").append(installDate);
        sb.append(", installer=").append(installer);
        sb.append(", isDoubleInstall=").append(isDoubleInstall);
        sb.append(", warrantyPolicy=").append(warrantyPolicy);
        sb.append(", delayFee=").append(delayFee);
        sb.append(", otherFee=").append(otherFee);
        sb.append(", commentP=").append(commentP);
        sb.append("]");
        return sb.toString();
    }
}