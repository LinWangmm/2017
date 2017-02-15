package com.example.tools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.v4.util.LruCache;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.ImageRequest;

public class MyImageLoader {
	public static LruCache<String, Bitmap> cache=new LruCache<String, Bitmap>(
			1024 * 1024 * 4) {

		@Override
		protected void entryRemoved(boolean evicted, String key,
				Bitmap oldValue, Bitmap newValue) {
			super.entryRemoved(evicted, key, oldValue, newValue);
			oldValue.recycle();
		}

		@Override
		protected int sizeOf(String key, Bitmap value) {
			return value.getRowBytes() * value.getHeight();
		}

	};
	
	public static void initMyImageLoader(RequestQueue queue){
		ImageLoader imgLoader = new ImageLoader(queue, new ImageCache() {
			@Override
			public Bitmap getBitmap(String url) {
				return cache.get(url);
			}

			@Override
			public void putBitmap(String url, Bitmap bitmap) {
				cache.put(url, bitmap);
			}
		});
	}
	public static ImageRequest addImageRequest(final ImageView iv,String url,final int errorImage){
		ImageRequest bigbm = new ImageRequest(
				url,
				new Listener<Bitmap>() {
					@Override
					public void onResponse(Bitmap response) {
						iv.setImageBitmap(response);
					}
				}, 0, 0, Config.RGB_565, new ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						Log.e("Volley", error.getMessage());
						iv.setImageResource(errorImage);
					}
				});
		return bigbm;
	}
}
