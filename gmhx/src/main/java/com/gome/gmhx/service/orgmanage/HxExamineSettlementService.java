package com.gome.gmhx.service.orgmanage;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.gome.common.page.Page;
import com.gome.gmhx.entity.HxExamineSettlementTicket;

public interface HxExamineSettlementService {

	List<Map<String, Object>> getExamineSettlementPageList(Page page);

	HxExamineSettlementTicket geExamineSettlementById(String settlementId);

	List<Map<String, Object>> getOtherFeeGridById(String settlementId);

	List<Map<String, Object>> getSettlementFeeDetailGrid(String settlementId);

	public void settlementFee(Date date);
}
