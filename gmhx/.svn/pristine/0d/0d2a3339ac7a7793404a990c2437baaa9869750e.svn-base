package com.gome.gmhx.dao.materialmanage;

import java.util.List;
import java.util.Map;

import com.gome.common.page.Page;
import com.gome.gmhx.entity.HxParcelDelivery;

public interface HxParcelDeliveryDao {
	List<Map<String, Object>> getParcelDeliveryPageList(Page page);

	void addHxParcelDelivery(Map<String, Object> map);

	HxParcelDelivery getHxParcelDeliveryById(String parcelCode);

	List<Map<String, Object>> getParcelDeliveryExport(HxParcelDelivery parcel);

	List<String> getOrgnazationBySuit(String receiveUnit);

	/**
	 * 根据收货单位查询处于邮包发货状态下相关配件及申请单信息
	 * @param page
	 * @return
	 */
	List<Map<String, Object>> getApplayCodeList(Page page);

	void updateParcelDelivery(HxParcelDelivery parcel);

	HxParcelDelivery getsendParcelDeliveryShow(String parcelCode);

	HxParcelDelivery getsendById(String parcelCode); // 跳进界面，显示数据

	void updatesendParcelDelivery(Map<String, String> map); // 再修改邮包状态等
	// HxParcelDelivery updateHxCurrentStock(HxParcelDelivery parcel);

	void updateHxCurrentStock(Map<String, String> map);// 先修改库存

	String getParcelCode(String number);

	String getListNumber(String companyId);

	List<Map<String, Object>> getParcelDeliveryDetail(String parcelCode);

	void delParcelDelivery(String parcelCode);

	void addMaterials(Map<String, Object> map);

	/**
	 * 根据code查询相关listNumbers
	 * @param parcelCode
	 * @return
	 */
	public List<Map<String, Object>> selectMaterialsByCode(String parcelCode);
	
	/**
	 * 根据code删除hx_parcel_material关联表数据
	 * @param parcelCode
	 */
	public void deleteMaterialsByCode(String parcelCode);

	public void updateByPrimaryKeySelective(HxParcelDelivery parcel);

	public HxParcelDelivery selectByPrimaryKey(String parcelCode);

}
