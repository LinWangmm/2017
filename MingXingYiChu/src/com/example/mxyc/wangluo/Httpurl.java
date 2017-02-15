package com.example.mxyc.wangluo;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/*
 * 
 * 
 * 从网络中取数据
 * */
public class Httpurl {
	public static String getString(String url) {
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		try {
			HttpResponse response = httpClient.execute(post);
			if (response.getStatusLine().getStatusCode() == 200) {
				return EntityUtils.toString(response.getEntity());
			} else {
				System.out.println("链接失败");
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public static String getString(String url, String cod) {
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		try {
			HttpResponse response = httpClient.execute(post);
			if (response.getStatusLine().getStatusCode() == 200) {
				return EntityUtils.toString(response.getEntity());
			} else {
				System.out.println("链接失败");
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public static byte[] getByteArray(String url) {
		if (url != null && !url.equals("")) {
			HttpClient httpClient = new DefaultHttpClient();
			HttpGet get = new HttpGet(url);
			try {
				HttpResponse response = httpClient.execute(get);
				if (response.getStatusLine().getStatusCode() == 200) {
					return EntityUtils.toByteArray(response.getEntity());
				} else {
					System.out.println("链接失败");
					return null;
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		return null;
	}
}
