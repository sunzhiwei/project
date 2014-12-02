package com.gome.gmhx.dao.orgmanage;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.gome.common.page.Page;
import com.gome.gmhx.entity.HxExamineSettlementTicket;
import com.gome.gmhx.entity.HxSettlementDetail;

@Repository("hxExamineSettlementTicketDao")
public interface HxExamineSettlementTicketDao {

	List<Map<String, Object>> getExamineSettlementPageList(Page page);

	HxExamineSettlementTicket geExamineSettlementById(String settlementId);

	List<Map<String, Object>> getOtherFeeGridById(String settlementId);

	List<Map<String, Object>> getSettlementFeeDetailGrid(String settlementId);

	void insertExamineSettlementTicket(HxExamineSettlementTicket est);

	void insertSettlementDetails(List<HxSettlementDetail> hsds);

}
