package com.gome.sermanage.util;

public class ConstUtils {

	public final static String Server_DBServer="数据库服务器";
	
	public final static String Server_APPServer="应用服务器";
	
	public static String getServerByAppType(int type) {
		String Server = "";
		switch (type) {
		case 0:
			Server = Server_DBServer;
			break;
		case 1:
			Server = Server_APPServer;
			break;
		default:
			System.out.println("未知的应用类型!");
		}
		return Server;
	}
}
