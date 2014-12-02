package com.gome.sermanage.dao;

import java.util.List;

import com.gome.sermanage.base.BaseDao;
import com.gome.sermanage.entity.SerManage_User_Role;

public interface UserRoleDao extends BaseDao<SerManage_User_Role>{

	void deleteUserRole(Long userid) throws Exception;

	List<Long> userroleidlist(Long userid) throws Exception;

}
