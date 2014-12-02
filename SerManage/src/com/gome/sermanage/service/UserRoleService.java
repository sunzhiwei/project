package com.gome.sermanage.service;

import java.util.List;

import com.gome.sermanage.entity.SerManage_User_Role;

public interface UserRoleService {

	void save(SerManage_User_Role role) throws Exception;

	void deleteUserRole(Long userid) throws Exception;

	List<Long> userroleidlist(Long userid) throws Exception;
}