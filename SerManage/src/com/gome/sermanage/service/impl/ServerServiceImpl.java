package com.gome.sermanage.service.impl;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gome.sermanage.dao.ServerDao;
import com.gome.sermanage.entity.SerManage_Server;
import com.gome.sermanage.service.ServerService;
@Service
public class ServerServiceImpl implements ServerService {

	@Resource
	private ServerDao serverDao;
	@Override
	public int getTotalCountsByParams(Map map) throws Exception {
		return serverDao.getTotalCountsByParams(map);
	}

	@Override
	public List<SerManage_Server> queryPageByParams(Map map) throws Exception {
		return serverDao.queryPageByParams(map);
	}

	@Override
	public void update(SerManage_Server server) throws Exception{
		serverDao.update(server);
	}

	@Override
	public SerManage_Server getById(Long id) throws Exception{
		return serverDao.getById(id);
	}

	@Override
	public void deleteServer(SerManage_Server server) throws Exception{
		serverDao.delete(server);
	}

	@Override
	public List<BigInteger> getDBServers(String environment,List<String> systemname) throws Exception{
		return serverDao.getDBServers(environment,systemname);
	}

	@Override
	public List<BigInteger> getAPPServers(String environment,
			List<String> systemname) throws Exception {
		return serverDao.getAPPServers(environment,systemname);
	}

	@Override
	public List<String> getSystemColumn(String environment) throws Exception {
		return serverDao.getSystemColumn(environment);
	}

	@Override
	public int getSerDisTotalCountsByParams(Map map) throws Exception {
		return serverDao.getSerDisTotalCountsByParams(map);
	}

	@Override
	public List querySerDisPageByParams(Map map2) throws Exception {
		return serverDao.querySerDisPageByParams(map2);
	}

	@Override
	public int selectedIfServerExists(String ipurl,Long id) throws Exception {
		return serverDao.selectedIfServerExists(ipurl,id);
	}

	@Override
	public List<BigInteger> getTotalServersByEnvironment(String environment) throws Exception{
		return serverDao.getTotalServersByEnvironment(environment);
	}

	@Override
	public List<SerManage_Server> getLastUpdateTimeByEnvironment(String environment) throws Exception{
		return serverDao.getLastUpdateTimeByEnvironment(environment);
	}

}
