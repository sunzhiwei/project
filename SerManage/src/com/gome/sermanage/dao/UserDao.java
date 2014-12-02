package com.gome.sermanage.dao;

import java.util.List;
import java.util.Map;

import com.gome.sermanage.base.BaseDao;
import com.gome.sermanage.entity.SerManage_Role;
import com.gome.sermanage.entity.SerManage_User;

public interface UserDao extends BaseDao<SerManage_User>{

	SerManage_User getByLoginNameAndPassword(String username, String password) throws Exception;
	
    List<Integer> userRoleidList(Integer userid) throws Exception;
    
    List<Integer> selectPrivilegeidByRoleid(Integer roleid) throws Exception;

	int checkSuperadmin(SerManage_User currentUser) throws Exception;

	List<SerManage_User> getAdminUser() throws Exception;

	int getTotalCountsByParams(Map map) throws Exception;

	List queryPageByParams(Map map2) throws Exception;

	List<SerManage_Role> selectRoleList() throws Exception;

	int checkUserExist(Map map) throws Exception;
}
