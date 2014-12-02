package com.gome.gmhx.service.wsdl.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gome.common.page.Page;
import com.gome.gmhx.dao.wsdl.JlInstallDao;
import com.gome.gmhx.entity.JlInstall;
import com.gome.gmhx.service.wsdl.service.JlInstallService;

@Service("installService")
public class JlInstallServiceImpl implements JlInstallService {
	@Resource
	private JlInstallDao installDao;
	
	@Override
	public void insertInstall(JlInstall entity) {
		if(null==installDao.selectInstallByPrimaryKey(entity.getAzd01())){
			installDao.insertInstall(entity);
		}else{
			installDao.updateInstallByPrimaryKey(entity);
		}
	}

	@Override
	public void deleteInstallById(BigDecimal installId) {
		installDao.deleteInstallByPrimaryKey(installId);
	}

	@Override
	public void updateInstall(JlInstall entity) {
		installDao.updateInstallByPrimaryKey(entity);
	}
	
	@Override
	public List<Map<String, Object>> getInstallPageList(Page page) {
		return installDao.getInstallPageList(page);
	}

	@Override
	public List<Map<String, Object>> getInstallList(JlInstall install) {
		return installDao.getInstallList(install);
	}

	@Override
	public JlInstall getInstallById(BigDecimal installId) {
		return installDao.selectInstallByPrimaryKey(installId);
	}

}
