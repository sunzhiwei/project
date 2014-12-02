package com.gome.sermanage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gome.sermanage.dao.UserRoleDao;
import com.gome.sermanage.entity.SerManage_User_Role;
import com.gome.sermanage.service.UserRoleService;
@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Resource
	private UserRoleDao userroleDao;

	@Override
	public void save(SerManage_User_Role userrole) throws Exception {
		userroleDao.save(userrole);
	}

	@Override
	public void deleteUserRole(Long userid) throws Exception {
		userroleDao.deleteUserRole(userid);
	}

	@Override
	public List<Long> userroleidlist(Long userid) throws Exception {
		return userroleDao.userroleidlist(userid);
	}
}
