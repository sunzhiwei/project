package com.gome.gmhx.service.servicemanage.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gome.common.page.Page;
import com.gome.common.util.UUIDGenerator;
import com.gome.gmhx.dao.servicemanage.HxServiceCustomerDao;
import com.gome.gmhx.dao.servicemanage.HxServiceProductDao;
import com.gome.gmhx.dao.servicemanage.HxServiceTicketDao;
import com.gome.gmhx.dao.sysconfig.HxOrganizationDao;
import com.gome.gmhx.entity.HxServiceCustomer;
import com.gome.gmhx.entity.HxServiceProduct;
import com.gome.gmhx.entity.HxServiceTicket;
import com.gome.gmhx.entity.SysUser;
import com.gome.gmhx.entity.vo.HxServiceTicketVO;
import com.gome.gmhx.jbpm.JbpmProcessDefinations;
import com.gome.gmhx.jbpm.JbpmService;
import com.gome.gmhx.service.servicemanage.HxInstallReceiptService;

@Service("hxServiceInstallReceiptService")
public class HxInstallReceiptServiceImpl implements HxInstallReceiptService {
	
	@Resource
	HxServiceCustomerDao hxServiceCustomerDao;
	
	@Resource
	HxServiceProductDao hxServiceProductDao;
	
	@Resource
	HxServiceTicketDao hxServiceTicketDao;
	
	@Resource 
	HxOrganizationDao hxOrganizationDao;
	
	@Resource
	JbpmService jbpmService;
	
	@Override
	public List<Map<String, Object>> getServiceInstallReceiptPageList(Page page) {
		return hxServiceTicketDao.getServiceTicketPageList(page);
	}

	@Override
	public Map<String, Object> getInstallReceiptById(String serviceId) {
		return hxServiceTicketDao.selectServiceTicketByPrimaryKey(serviceId);	
	}

	@Override
	public void deleteServiceInstallReceipt(String serviceId) {
		hxServiceTicketDao.deleteServiceTicketByPrimaryKey(serviceId);
	}

	@Override
	public String saveInstallReceipt(HxServiceTicketVO serviceTicketVO, SysUser sysUser) {
		HxServiceCustomer serviceCustomer = serviceTicketVO.getServiceCustomer();
		HxServiceProduct serviceProduct = serviceTicketVO.getServiceProduct();
		HxServiceTicket serviceTicket = serviceTicketVO.getServiceTicket();
		// 生成服务单号
		String productID = UUIDGenerator.getUUID();
		String serviceID = "";
		SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
		String currentDateString = format.format(new Date());
		Integer sequence = hxServiceTicketDao.getMaxSequence();
		String str = "";
		if(sequence!=null){
			if(sequence<10000){
				str = String.format("%04d", ++sequence); 
			}else{
				str = String.valueOf(++sequence);
			}
		}else{
			sequence = 1 ;
			str = String.format("%04d", sequence); 
		}
		serviceID = "IN-"+currentDateString + str;
		// 用户
		serviceCustomer.setCreateManC(sysUser.getUserAccount());
		serviceCustomer.setCreateTimeC(new Date());
		serviceCustomer.setCreateOrganizationC(sysUser.getCompanyId());
		
		// 产品
		serviceProduct.setProductId(productID);
		serviceProduct.setCreateManP(sysUser.getUserAccount());
		serviceProduct.setCreateTimeP(new Date());
		serviceProduct.setCreateOrganizationP(sysUser.getCompanyId());
		// 服务单信息
		serviceTicket.setServiceId(serviceID);
		serviceTicket.setProductId(productID);
		serviceTicket.setSequence(sequence);
		serviceTicket.setServiceType("02");
		serviceTicket.setServiceStatus("S1");
		serviceTicket.setCreateManS(sysUser.getUserAccount());
		serviceTicket.setCreateTimeS(new Date());
		serviceTicket.setCreateOrganizationS(sysUser.getCompanyId());
		
		if(null!=serviceCustomer.getCustomerId()&&!"".equals(serviceCustomer.getCustomerId())){
			hxServiceCustomerDao.updateServiceCustomer(serviceCustomer);
			serviceTicket.setCustomerId(serviceCustomer.getCustomerId());
			serviceProduct.setCustomerId(serviceCustomer.getCustomerId());
		}else{
			String customerID = UUIDGenerator.getUUID();
			serviceCustomer.setCustomerId(customerID);
			serviceTicket.setCustomerId(customerID);
			serviceProduct.setCustomerId(customerID);
			hxServiceCustomerDao.insertServiceCustomer(serviceCustomer);
		}
		hxServiceProductDao.insertServiceProduct(serviceProduct);
		hxServiceTicketDao.insertServiceTicket(serviceTicket);
		
		return serviceID;
	}

	@Override
	public void updateInstallReceipt(HxServiceTicketVO serviceTicketVO, SysUser sysUser) {
		HxServiceCustomer serviceCustomer = serviceTicketVO.getServiceCustomer();
		HxServiceProduct serviceProduct = serviceTicketVO.getServiceProduct();
		HxServiceTicket serviceTicket = serviceTicketVO.getServiceTicket();
		// 更新人信息
		serviceCustomer.setAlterTimeC(new Date());
		serviceCustomer.setAlterManC(sysUser.getUserAccount());
		serviceCustomer.setAlterOrganizationC(sysUser.getCompanyId());
		
		serviceProduct.setAlterTimeP(new Date());
		serviceProduct.setAlterManP(sysUser.getUserAccount());
		serviceProduct.setAlterOrganizationP(sysUser.getCompanyId());
		
		serviceTicket.setAlterTimeS(new Date());
		serviceTicket.setAlterManS(sysUser.getUserAccount());
		serviceTicket.setAlterOrganizationS(sysUser.getCompanyId());
		
		hxServiceCustomerDao.updateServiceCustomer(serviceCustomer);
		hxServiceProductDao.updateServiceProduct(serviceProduct);
		hxServiceTicketDao.updateServiceTicketByPrimaryKeySelective(serviceTicket);
	}

	@Override
	public Map<String, Object> getHxProductDetailById(String spbm) {
		return hxServiceTicketDao.selectHxProductDetailById(spbm);
	}

	@Override
	public void updateInstallReceiptStatus(String serviceId) {
		hxServiceTicketDao.affirmServiceTicketByPrimaryKey(serviceId);
	}

	@Override
	public void submit(String serviceId) {
		//TODO:1.根据id查询对应实体类
		HxServiceTicket serviceTicket = hxServiceTicketDao.getServiceTicketByServiceId(serviceId);
		
		Map ve = new HashMap();
		ve.put("dataSource", "1");//数据来源为1代表安装回执中系统建单 0 其他系统推送
		this.jbpmService.startProcessInstanceByKey(JbpmProcessDefinations.installationReceipt, serviceTicket, ve);
		hxServiceTicketDao.updateServiceTicketByPrimaryKeySelective(serviceTicket);
		
	}

}
