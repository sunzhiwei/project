package com.gome.sermanage.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

import com.gome.sermanage.base.BaseDaoImpl;
import com.gome.sermanage.dao.UserDao;
import com.gome.sermanage.entity.SerManage_Role;
import com.gome.sermanage.entity.SerManage_Server;
import com.gome.sermanage.entity.SerManage_User;
import com.gome.sermanage.util.MapParamsUtil;

@Component
public class UserDaoImpl extends BaseDaoImpl<SerManage_User> implements UserDao {


	@Override
	public SerManage_User getByLoginNameAndPassword(String username,
			String password) throws Exception {
		return (SerManage_User) getSession().createQuery(//
				"FROM SerManage_User u WHERE u.username=? AND u.password=?")//
				.setParameter(0, username)
				.setParameter(1, password) // 若需要密码加密,DigestUtils.md5Hex(password)
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> userRoleidList(Integer userid) throws Exception {
		return getSession().createSQLQuery("select roleid from t_sermanage_user_role ur where ur.userid=:userid")
				.setLong("userid", userid).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> selectPrivilegeidByRoleid(Integer roleid)
			throws Exception {
		return getSession().createSQLQuery("select privilegeid from t_sermanage_role_privilege rp where rp.roleid=:roleid")
				.setLong("roleid", roleid).list();
	}

	@Override
	public int checkSuperadmin(SerManage_User currentUser) throws Exception{
		return getSession().createSQLQuery("select * from t_sermanage_role r ,t_sermanage_user u,t_sermanage_user_role ur where u.id=ur.userid and r.id=ur.roleid and r.id=1 and u.id=:userid")
				.setLong("userid", currentUser.getId()).list().size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SerManage_User> getAdminUser() throws Exception{
		String sql = "select u.* from t_sermanage_user u,t_sermanage_role r,t_sermanage_user_role ur where ur.userid=u.id and ur.roleid=r.id and r.id=2";
		return this.getSession().createSQLQuery(sql).addEntity(SerManage_User.class).list();
	}

	@Override
	public int getTotalCountsByParams(Map map) throws Exception {
		String hql="FROM SerManage_User where 1=1 ";
		hql+=MapParamsUtil.getUserConditionByMap(map);
		return getSession().createQuery(hql).list().size();
	}

	@Override
	public List queryPageByParams(Map map2) throws Exception {
		Integer start=new Integer(0);
		Integer end=new Integer(10);
		if(map2.get("startRow")!=null &&!("").equals(map2.get("startRow")) && map2.get("startRow") instanceof Integer){
			start=(Integer)map2.get("startRow")-1;
		}
		if(map2.get("endRow")!=null &&!("").equals(map2.get("endRow")) && map2.get("endRow") instanceof Integer){
			end=(Integer)map2.get("endRow")-start;
		}
		String sql="select * from  t_sermanage_user where 1=1 ";
		sql+=MapParamsUtil.getUserConditionByMap(map2);
		sql+=" order by id DESC limit "+start+","+end;
		return getSession().createSQLQuery(sql).addEntity(SerManage_User.class).list();
	}

	@Override
	public List<SerManage_Role> selectRoleList() throws Exception {
		return getSession().createQuery("FROM SerManage_Role").list();	
	}

	@Override
	public int checkUserExist(Map map) throws Exception {
		if(map.get("id")!=null && !("").equals(map.get("id")))
			return getSession().createQuery("FROM SerManage_User u where u.username=:username and u.id!=:id").setString("username", map.get("username").toString()).setLong("id", Long.parseLong(map.get("id").toString())).list().size(); 
		return getSession().createQuery("FROM SerManage_User u where u.username=:username").setString("username", map.get("username").toString()).list().size();
	}
}
