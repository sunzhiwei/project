package com.wsdl;
import org.apache.axis.wsdl.WSDL2Java;
public class WSDL2JavaUtil {
	
	
	public static void main(String[] args) {
		String url = "http://10.2.2.131:8020/jlwebserver/services/CENJK?wsdl";
		System.out.println("===================开始生成！======================");
		String [] ss = {"-D",url,"-s"};
		WSDL2Java.main(ss);
		System.out.println("===================生成成功！======================");
	}
}
