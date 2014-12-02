package com.gome.sermanage.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.gome.sermanage.base.BaseDaoImpl;
import com.gome.sermanage.dao.PrivilegeDao;
import com.gome.sermanage.entity.SerManage_Privilege;

@Component
public class PrivilegeDaoImpl extends BaseDaoImpl<SerManage_Privilege> implements PrivilegeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<SerManage_Privilege> findByLevel(Integer menuid, Integer level)
			throws Exception {
		return getSession()
				.createQuery("FROM SerManage_Privilege p where p.id=:id and p.levelid=:levelid")
				.setLong("id",menuid ).setLong("levelid",level)
				.list();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<SerManage_Privilege> list(Map map) throws Exception {
		return getSession()
				.createQuery("FROM SerManage_Privilege ")
				.list();
	}

}
