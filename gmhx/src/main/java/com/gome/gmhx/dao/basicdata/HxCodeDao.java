package com.gome.gmhx.dao.basicdata;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.gome.common.page.Page;
import com.gome.gmhx.entity.HxCode;

@Repository("hxCodeDao")
public interface HxCodeDao {
	List<HxCode> getAll();
	
	List<HxCode> getCodeByKey(String codeKey);
	
	List<Map<String, Object>> getHxCodePageList(Page page);
	
	List<Map<String, Object>> getHxCodeSettingByCodeId(String codeId);
	
	void insertSetting(HxCode hxCode);

	List<Map<String, String>> getOrgCombobox();

	List<Map<String, String>> getFittingMenu(String fittingPositionId);

	List<Map<String, String>> getWdOrgCombobox();

	List<Map<String, String>> getFbOrgCombobox();

	List<Map<String, String>> getZbOrgCombobox();

	List<Map<String, String>> getPositions(String userAccount);

	List<Map<String, String>> getFittingMenuNoPosition();
	
	String getCodeValue(Map<String, String> map);

	List<Map<String, String>> getRoleCombobox();

	List<Map<String, String>> getECCombobox();

	List<Map<String, String>> getStoreCombobox(String center);

	List<Map<String, String>> getWebsiteCombobox();

	List<Map<String, String>> getAftermarketCombobox();

	List<Map<String, Object>> getModelCombobox();

	List<Map<String, Object>> getServiceUnit(String wd);
}
