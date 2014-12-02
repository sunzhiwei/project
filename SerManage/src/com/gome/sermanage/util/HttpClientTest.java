package com.gome.sermanage.util;

import java.io.IOException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class HttpClientTest {
  public static void main(String[] args) {
	
	  String url="http://localhost:8080/SerManage/userAction_login.action";
	  HttpClient client=new HttpClient();
	  PostMethod method =new PostMethod(url);
	  NameValuePair[] parametersBody={new NameValuePair("user.username", "superadmin"),new NameValuePair("user.password", "123")};
	  method.setRequestBody(parametersBody);
	  try {
		int executeMethod = client.executeMethod(method);
		if(executeMethod!=200)
		{
			System.out.println("失败");
		}
		if (executeMethod == HttpStatus.SC_MOVED_PERMANENTLY || executeMethod == HttpStatus.SC_MOVED_TEMPORARILY){
			Header responseHeader = method.getResponseHeader("location");
			String location=null;
			if(responseHeader!=null)
				location=responseHeader.getValue();
			System.out.println("#####"+location+"%%%%%");
		}
	    System.out.println(new String(method.getResponseBody()));
	  } catch (HttpException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		method.releaseConnection();
	}
}
}
