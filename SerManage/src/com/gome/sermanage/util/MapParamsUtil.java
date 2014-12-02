package com.gome.sermanage.util;

import java.util.Map;

public class MapParamsUtil {

	public static String getServerConditionByMap(Map map){
		String sql="";
		if(map.get("pcname") != null && !("").equals(map.get("pcname").toString())){
			sql += " and pcname like '%" + map.get("pcname").toString() + "%'";
		}
		if(map.get("environment") != null && !("").equals(map.get("environment").toString())){
			sql += " and environment like '%" + map.get("environment").toString() + "%'";
		}
		if(map.get("systemname") != null && !("").equals(map.get("systemname").toString())){
			sql += " and systemname like '%" + map.get("systemname").toString() + "%'";
		}
		if(map.get("apptype") != null && !("").equals(map.get("apptype").toString())){
			sql += " and apptype=" + map.get("apptype").toString();
		}
		if(map.get("startupdatetime") != null && !("").equals(map.get("startupdatetime").toString())){
			sql += " and updatetime>='" + map.get("startupdatetime").toString() + "'";
		}
		if(map.get("endupdatetime") != null && !("").equals(map.get("endupdatetime").toString())){
			sql += " and updatetime<='" + map.get("endupdatetime").toString() + "'";
		}
		if(map.get("administrator") != null && !("").equals(map.get("administrator").toString())){
			sql += " and administrator='" + map.get("administrator").toString() + "'";
		}
		return sql;
	}
	
	public static String getUserConditionByMap(Map map){
		String sql="";
		if(map.get("username") != null && !("").equals(map.get("username").toString())){
			sql += " and username like '%" + map.get("username").toString() + "%'";
		}
		return sql;
	}
}
