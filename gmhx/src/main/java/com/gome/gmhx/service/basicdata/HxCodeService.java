package com.gome.gmhx.service.basicdata;

import java.util.List;
import java.util.Map;

import com.gome.common.page.Page;
import com.gome.gmhx.entity.HxCode;

public interface HxCodeService {
	
	List<HxCode> getAll();
	
	List<Map<String, Object>> getHxCodePageList(Page page);
	
	List<Map<String, Object>> getHxCodeSettingByCodeId(String codeId);
	
	void insertSetting(String codeId, HxCode hxCode);

	List<Map<String, String>> getOrgCombobox();

	List<Map<String, String>> getFittingMenu(String fittingPositionId);

	List<Map<String, String>> getWdOrgCombobox();

	List<Map<String, String>> getFbOrgCombobox();

	List<Map<String, String>> getZbOrgCombobox();

	List<Map<String, String>> getPositions(String userAccount);

	List<Map<String, String>> getFittingMenuNoPosition();

	List<Map<String, String>> getRoleCombobox();
}
