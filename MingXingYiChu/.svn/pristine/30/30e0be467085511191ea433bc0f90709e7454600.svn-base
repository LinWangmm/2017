package com.example.mxyc.wangluo;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class Httpget {
	public static String getString(String url)
	{
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet  = new HttpGet(url);
		try {
			HttpResponse hr = httpClient.execute(httpGet);
			if(hr.getStatusLine().getStatusCode()==200){
				return EntityUtils.toString(hr.getEntity(),HTTP.UTF_8);
			}else {
				return "连接失败";
			}
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}

}
