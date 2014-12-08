package com.gome.gmhx.service.basicdata.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gome.common.annotation.MaintenanceCode;
import com.gome.common.page.Page;
import com.gome.gmhx.dao.basicdata.HxCodeDao;
import com.gome.gmhx.entity.HxCode;
import com.gome.gmhx.service.basicdata.HxCodeService;

@Service("hxCodeService")
public class HxCodeServiceImpl implements HxCodeService {
	@Resource
	private HxCodeDao hxCodeDao;

	@Override
	public List<HxCode> getAll() {
		return hxCodeDao.getAll();
	}

	@Override
	public List<Map<String, Object>> getHxCodePageList(Page page) {
		return hxCodeDao.getHxCodePageList(page);
	}

	@Override
	public List<Map<String, Object>> getHxCodeSettingByCodeId(String codeId) {
		return hxCodeDao.getHxCodeSettingByCodeId(codeId);
	}

	@Override
	@MaintenanceCode
	public void insertSetting(String codeId, HxCode hxCode) {
		hxCodeDao.insertSetting(hxCode);
	}

	@Override
	public List<Map<String, String>> getOrgCombobox() {
		return hxCodeDao.getOrgCombobox();
	}

	@Override
	public List<Map<String, String>> getFittingMenu(String fittingPositionId) {
		return hxCodeDao.getFittingMenu(fittingPositionId);
	}

	@Override
	public List<Map<String, String>> getWdOrgCombobox() {
		return hxCodeDao.getWdOrgCombobox();
	}

	@Override
	public List<Map<String, String>> getFbOrgCombobox() {
		return hxCodeDao.getFbOrgCombobox();
	}

	@Override
	public List<Map<String, String>> getZbOrgCombobox() {
		return hxCodeDao.getZbOrgCombobox();
	}

	@Override
	public List<Map<String, String>> getPositions(String userAccount) {
		return hxCodeDao.getPositions(userAccount);
	}

	@Override
	public List<Map<String, String>> getFittingMenuNoPosition() {
		return hxCodeDao.getFittingMenuNoPosition();
	}

	@Override
	public List<Map<String, String>> getRoleCombobox() {
		return hxCodeDao.getRoleCombobox();
	}


}
