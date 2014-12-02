package com.gome.sermanage.dao;

import java.util.List;
import java.util.Map;

import com.gome.sermanage.base.BaseDao;
import com.gome.sermanage.entity.SerManage_Privilege;

public interface PrivilegeDao extends BaseDao<SerManage_Privilege> {
	
	 List<SerManage_Privilege> findByLevel(Integer menuid,Integer level) throws Exception;

	List<SerManage_Privilege> list(Map map) throws Exception;
}
