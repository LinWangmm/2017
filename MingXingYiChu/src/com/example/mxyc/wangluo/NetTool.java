package com.example.mxyc.wangluo;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class NetTool {
	/**
	 * get«Î«Û
	 * ∑µªÿbyte
	 * */
	public static byte[] getHttpInfo(String url){
		HttpResponse response=null;
		try {
			response=new DefaultHttpClient().execute(new HttpGet(url));
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
}
