package com.example.xiangyao;

import java.util.List;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.mingxingyichu.R;
import com.example.mingxingyichu.SecActivity;
import com.example.second.SecondPageJSON;
import com.example.second.SecondSecondModel;
import com.example.second.SecondSecondModelCell;
import com.example.tools.MyImageLoader;
import com.example.tools.NetTool;

import android.app.Activity;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SecondSecondActivity extends Activity {
	private String url="http://api2.haobao.com/topic?width=320&ga=%2Ftopic&gv=35&gi=000000000000000&access_token=&twm=1&gc=wandoujia&topic_id="+getIntent().getStringExtra("id")+"&gn=mxyc_adr&gf=android";
	
	LinearLayout ll;
	RequestQueue queue;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second_second);
		ll=(LinearLayout) findViewById(R.id.ass);
		
		WindowManager winManager=(WindowManager) getSystemService(Context.WINDOW_SERVICE);
		
		
		queue=Volley.newRequestQueue(this);
		MyImageLoader.initMyImageLoader(queue);
		
		new MyTask().execute(url);
	}
class MyTask extends AsyncTask<String, Void, SecondSecondModel>{

	@Override
	protected SecondSecondModel doInBackground(String... params) {
		// TODO Auto-generated method stub
		byte[] b=NetTool.getHttpInfo(params[0]);
		SecondSecondModel ssm=SecondPageJSON.secondSecondJSON(new String(b));
		return ssm;
	}
	@Override
	protected void onPostExecute(SecondSecondModel result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		List<SecondSecondModelCell> list=result.getItems();
		for(int i=0;i<list.size();i++){
			String type=list.get(i).getComponentType();
			if(type.equals("word")){
				TextView tv=new TextView(SecondSecondActivity.this);
				tv.setText(list.get(i).getContent());
			}else{
				ImageView iv=new ImageView(SecondSecondActivity.this);
				iv.setScaleType(ImageView.ScaleType.FIT_XY);
				LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(SecActivity.secWith, Integer.parseInt(list.get(i).getHeight())/Integer.parseInt(list.get(i).getWidth())*SecActivity.secWith);
				iv.setLayoutParams(params);
				
				queue.add(MyImageLoader.addImageRequest(iv, list.get(i).getPicUrl(), R.drawable.ic_launcher));
			}
		}
	}
}
}
