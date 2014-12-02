package com.gome.sermanage.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gome.sermanage.base.BaseDaoImpl;
import com.gome.sermanage.dao.UserRoleDao;
import com.gome.sermanage.entity.SerManage_User_Role;

@Component
public class UserRoleDaoImpl extends BaseDaoImpl<SerManage_User_Role> implements UserRoleDao {

	@Override
	public void deleteUserRole(Long userid) throws Exception {
		getSession().createSQLQuery("delete from t_sermanage_user_role where userid=:userid").setLong("userid", userid).executeUpdate();;
	}

	@Override
	public List<Long> userroleidlist(Long userid) throws Exception {
		return getSession().createSQLQuery("select roleid from t_sermanage_user_role where userid=:userid").setLong("userid", userid).list();
	}
}
