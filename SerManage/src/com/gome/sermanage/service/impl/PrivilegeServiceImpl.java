package com.gome.sermanage.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gome.sermanage.dao.PrivilegeDao;
import com.gome.sermanage.entity.SerManage_Privilege;
import com.gome.sermanage.service.PrivilegeService;
@Service
public class PrivilegeServiceImpl implements PrivilegeService {

	@Resource
	private PrivilegeDao privilegeDao;
	@Override
	public List<SerManage_Privilege> findByLevel(Integer menuid, Integer level)
			throws Exception {
		return privilegeDao.findByLevel(menuid, level);
	}
	@Override
	public List<SerManage_Privilege> list(Map map) throws Exception {
		return privilegeDao.list(map);
	}
}
