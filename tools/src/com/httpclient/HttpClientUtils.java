package com.httpclient;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.io.IOUtils;

public class HttpClientUtils {
	
	public static void main(String[] args) {
		try{
			String url = "http://localhost:8080/ass/message/processCrmMessage";
			String filePath = "packet.xml";
			HttpClient client = new HttpClient();
			PostMethod post = new PostMethod(url);
			String content = IOUtils.toString(HttpClientUtils.class.getResourceAsStream(filePath),"UTF-8");
			System.out.println(content);
			RequestEntity re = new StringRequestEntity(content,null,"UTF-8");
			post.setRequestEntity(re);
			client.executeMethod(post);
			System.out.println(post.getResponseBodyAsString());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
