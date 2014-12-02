package com.gome.gmhx.service.workflow;

import java.util.List;
import java.util.Map;

import com.gome.common.page.Page;
import com.gome.gmhx.entity.HxUser;
import com.gome.gmhx.entity.SysUser;

public interface HxWorkFlowService {

	List<Map<String, Object>> getWorkPageList(Page page);

	List<Map<String, Object>> getTaskTrajeCttoryPageList(Page page);

	String processInstanceIdToVal(String processInstanceId);

	void updateJbpmWorkEntity(String workEntityId, String transactionpass,
			String approveComment, String orderType, String checkAgree);

	List<Map<String, Object>> getWorkMonitoringPageList(Page page);

	void endProcessJbpmWorkEntity(String workEntityId,
			String transactiontermination);

}
