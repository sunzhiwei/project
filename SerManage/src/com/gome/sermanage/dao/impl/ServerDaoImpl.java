package com.gome.sermanage.dao.impl;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.gome.sermanage.base.BaseDaoImpl;
import com.gome.sermanage.dao.ServerDao;
import com.gome.sermanage.entity.SerManage_Server;
import com.gome.sermanage.util.MapParamsUtil;

@Component
public class ServerDaoImpl extends BaseDaoImpl<SerManage_Server> implements ServerDao {

	@SuppressWarnings("unchecked")
	@Override
	public int getTotalCountsByParams(Map map) throws Exception {
		String hql="FROM SerManage_Server where 1=1 ";
		hql+=MapParamsUtil.getServerConditionByMap(map);
		return getSession().createQuery(hql).list().size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SerManage_Server> queryPageByParams(Map map) throws Exception {
		Integer start=new Integer(0);
		Integer end=new Integer(10);
		if(map.get("startRow")!=null &&!("").equals(map.get("startRow")) && map.get("startRow") instanceof Integer){
			start=(Integer)map.get("startRow")-1;
		}
		if(map.get("endRow")!=null &&!("").equals(map.get("endRow")) && map.get("endRow") instanceof Integer){
			end=(Integer)map.get("endRow")-start;
		}
		String sql="select * from  t_sermanage_server where 1=1 ";
		sql+=MapParamsUtil.getServerConditionByMap(map);
		sql+=" order by updatetime DESC limit "+start+","+end;
		return getSession().createSQLQuery(sql).addEntity(SerManage_Server.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BigInteger> getDBServers(String environment,List<String> systemname) throws Exception{
		String sql="";
		for(String name:systemname){
			sql+="select count(*) count from t_sermanage_server s where s.apptype=0 and s.environment='"+environment+"' and s.systemname='"+name+"' UNION ALL ";
		}
		sql = sql.substring(0,sql.length()-(sql.length()-sql.lastIndexOf("UNION ALL")));
		return getSession().createSQLQuery(sql).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BigInteger> getAPPServers(String environment,
			List<String> systemname) throws Exception {
		String sql="";
		for(String name:systemname){
			sql+="select count(*) count from t_sermanage_server s where s.apptype=1 and s.environment='"+environment+"' and s.systemname='"+name+"' UNION ALL ";
		}
		sql = sql.substring(0,sql.length()-(sql.length()-sql.lastIndexOf("UNION ALL")));
		return getSession().createSQLQuery(sql).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getSystemColumn(String environment) throws Exception {
		return getSession().createSQLQuery("select distinct systemname from t_sermanage_server where environment=:environment order by systemname").setString("environment", environment).list();
	}

	@Override
	public int getSerDisTotalCountsByParams(Map map) throws Exception {
		String sql="select systemname,apptype,count(*) count from t_sermanage_server where 1=1 ";
		if(map.get("environment") != null && !("").equals(map.get("environment").toString())){
			sql += " and environment='" + map.get("environment").toString() + "'";
		}
		sql+=" GROUP BY systemname,apptype";
		return getSession().createSQLQuery(sql).list().size();
	}

	@Override
	public List querySerDisPageByParams(Map map2) throws Exception {
		Integer start=new Integer(1);
		if(map2.get("startRow")!=null &&!("").equals(map2.get("startRow")) && map2.get("startRow") instanceof Integer){
			start=(Integer)map2.get("startRow")-1;
		}
		String sql="select systemname,apptype,count(*) count from t_sermanage_server where 1=1 ";
		if(map2.get("environment") != null && !("").equals(map2.get("environment").toString())){
			sql += " and environment='" + map2.get("environment").toString() + "'";
		}
		sql+=" GROUP BY systemname,apptype order by systemname,apptype limit "+start+","+map2.get("endRow");
		return getSession().createSQLQuery(sql).list();
	}

	@Override
	public int selectedIfServerExists(String ipurl,Long id) throws Exception {
		if(id!=-1)
		    return getSession().createQuery("FROM SerManage_Server  where ipurl=:ipurl and id!=:id").setString("ipurl", ipurl).setLong("id", id).list().size();
		return getSession().createQuery("FROM SerManage_Server where ipurl=:ipurl").setString("ipurl", ipurl).list().size();
	
	}

	@Override
	public List<BigInteger> getTotalServersByEnvironment(String environment) throws Exception{
		return getSession().createSQLQuery("select count(*) from t_sermanage_server where environment=:environment").setString("environment", environment).list();
	}

	@Override
	public List<SerManage_Server> getLastUpdateTimeByEnvironment(String environment) throws Exception{
		return getSession().createQuery("from SerManage_Server where environment=:environment order by updatetime desc limit 1").setString("environment", environment).list();
	}
}
