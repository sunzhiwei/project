package com.gome.sermanage.service;

import java.util.List;
import java.util.Map;

import com.gome.sermanage.entity.SerManage_Role;
import com.gome.sermanage.entity.SerManage_Server;
import com.gome.sermanage.entity.SerManage_User;



public interface UserService {

	SerManage_User getByLoginNameAndPassword(String username, String password) throws Exception;
	
    List<Integer> userRoleidList(Integer userid) throws Exception;
    
    List<Integer> selectPrivilegeidByRoleid(Integer roleid) throws Exception;

	int checkSuperadmin(SerManage_User currentUser) throws Exception;

	List<SerManage_User> getAdminUser() throws Exception;

	void save(SerManage_Server server) throws Exception;

	int getTotalCountsByParams(Map map) throws Exception;

	List queryPageByParams(Map map2) throws Exception;

	List<SerManage_Role> selectRoleList() throws Exception;

	int checkUserExist(Map map) throws Exception;

	void save(SerManage_User user) throws Exception;

	void deleteUser(SerManage_User user) throws Exception;

	SerManage_User getById(Long id) throws Exception;

	void update(SerManage_User user) throws Exception;

}