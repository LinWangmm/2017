package com.example.tools;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class NetTool {
	/**
	 * get����
	 * ����byte
	 * */
	public static byte[] getHttpInfo(String url){
		HttpResponse response=null;
		try {
			HttpGet get=new HttpGet(url);
			response=new DefaultHttpClient().execute(get);
//			response=new DefaultHttpClient().execute(new HttpGet(url));
//			System.out.println(response.getStatusLine().getStatusCode());
			if(response.getStatusLine().getStatusCode()==200)
				return EntityUtils.toByteArray(response.getEntity());
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
//	public static InputStream getUriInfo(String url){
//		H
//	}
}
