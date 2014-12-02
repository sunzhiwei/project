package com.gome.gmhx.dao.materialmanage;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.gome.common.page.Page;
import com.gome.gmhx.entity.HxCurrentStock;
import com.gome.gmhx.entity.HxMaterialDetail;
import com.gome.gmhx.entity.HxMaterialManage;

@Repository("hxMaterialDao")
public interface HxMaterialDao {

	List<String> getFittingBySuit(String suitModel);

	Map<String, Object> getFittingInfo(Map<String, Object> map);

	void addHxMaterialManage(HxMaterialManage hxMaterialManage);

	void addHxMaterialDetail(List<HxMaterialDetail> list);

	String getListNumber(String companyId);
	
	/**
	 * 查询当天该机构人下发货量
	 * @param companyId
	 * @return
	 */
	String getSendNumber(String companyId);

	HxMaterialManage getHxMaterialManage(String listNumber);

	String getFatherFittingOrgId(String fittingOrgId);
	
	String getWebFittingOrgId(String orgId);

	List<Map<String, Object>> getHxMaterialPageList(Page page);
	
	/**
	 * 定创建人，物料岗位id查询邮包收发货历史
	 * @param page
	 * @return
	 */
	List<Map<String, Object>> getHxParcelPageList(Page page);//TODO 从已经完成的，和未完成的工作流中取，而不是所有的工作流了
	
	/**
	 * 查询配件申请历史
	 * @param page
	 * @return
	 */
	List<Map<String, Object>> getHxMaterialHistoryPageList(Page page);
	
	List<Map<String, Object>> getHxMaterialDetail(String listNumber);
	
	List<Map<String, Object>> getHxMaterialDetail2(Map<String, Object> map);

	void delHxMaterialDetail(String listNumber);

	void delHxMaterialManage(String listNumber);

	void updateStatus(Map<String, String> map);

	void insertRkCount(Map<String, Object> newMap);
	
	void updateRkCount(Map<String, Object> newMap);

	void updateCkCount(Map<String, Object> map);

	HxCurrentStock isExist(Map<String, Object> map);

	List<Map<String, Object>> getHxMaterialDetailForUpdate(Map<String, Object> map);

	void updateHxMaterialManage(HxMaterialManage manage);
	void updateHxMaterialDetail(HxMaterialDetail materialDetail);

	Float getFittingPrice(HxMaterialDetail hxMaterialDetail);

	List<Map<String, Object>> getHxMaterialDetail3(String listNumber);
}