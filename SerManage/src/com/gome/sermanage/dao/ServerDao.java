package com.gome.sermanage.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import com.gome.sermanage.base.BaseDao;
import com.gome.sermanage.entity.SerManage_Server;

public interface ServerDao extends BaseDao<SerManage_Server> {
	
    int getTotalCountsByParams(Map map) throws Exception;
	
	List<SerManage_Server> queryPageByParams(Map map) throws Exception;

	List<BigInteger> getDBServers(String environment,List<String> systemname) throws Exception;

	List<BigInteger> getAPPServers(String environment, List<String> systemname) throws Exception;

	List<String> getSystemColumn(String environment) throws Exception;

	int getSerDisTotalCountsByParams(Map map) throws Exception;

	List querySerDisPageByParams(Map map2) throws Exception;

	int selectedIfServerExists(String ipurl,Long id) throws Exception;

	List<BigInteger> getTotalServersByEnvironment(String environment) throws Exception;

	List<SerManage_Server> getLastUpdateTimeByEnvironment(String environment)throws Exception;
}
