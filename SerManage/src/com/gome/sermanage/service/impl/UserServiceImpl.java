package com.gome.sermanage.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gome.sermanage.dao.UserDao;
import com.gome.sermanage.entity.SerManage_Role;
import com.gome.sermanage.entity.SerManage_Server;
import com.gome.sermanage.entity.SerManage_User;
import com.gome.sermanage.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	@Override
	public SerManage_User getByLoginNameAndPassword(String username,
			String password) throws Exception {
		return userDao.getByLoginNameAndPassword(username, password);
	}

	@Override
	public List<Integer> userRoleidList(Integer userid) throws Exception {
		return userDao.userRoleidList(userid);
	}

	@Override
	public List<Integer> selectPrivilegeidByRoleid(Integer roleid)
			throws Exception {
		return userDao.selectPrivilegeidByRoleid(roleid);
	}

	@Override
	public int checkSuperadmin(SerManage_User currentUser) throws Exception{
		return userDao.checkSuperadmin(currentUser);
	}

	@Override
	public List<SerManage_User> getAdminUser() throws Exception{
		return userDao.getAdminUser();
	}

	@Override
	public void save(SerManage_Server server) throws Exception{
		userDao.save(server);
	}

	@Override
	public int getTotalCountsByParams(Map map) throws Exception {
		return userDao.getTotalCountsByParams(map);
	}

	@Override
	public List queryPageByParams(Map map2) throws Exception {
		return userDao.queryPageByParams(map2);
	}

	@Override
	public List<SerManage_Role> selectRoleList() throws Exception {
		return userDao.selectRoleList();
	}

	@Override
	public int checkUserExist(Map map) throws Exception {
		return userDao.checkUserExist(map);
	}

	@Override
	public void save(SerManage_User user) throws Exception {
		userDao.save(user);
	}

	@Override
	public void deleteUser(SerManage_User user) throws Exception {
		userDao.delete(user);
	}

	@Override
	public SerManage_User getById(Long id) throws Exception {
		return userDao.getById(id);
	}

	@Override
	public void update(SerManage_User user) throws Exception {
		userDao.update(user);
	}
}
