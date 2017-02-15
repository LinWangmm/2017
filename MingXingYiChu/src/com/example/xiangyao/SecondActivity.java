package com.example.xiangyao;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.mingxingyichu.R;
import com.example.tools.MyImageLoader;

public class SecondActivity extends Activity{
	
	private TextView userName,date,info;
	private Button btn1,btn2;
	private ImageView iv1,iv2;
	private RequestQueue queue;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.waterfall_second);
		
		//Volley
		queue=Volley.newRequestQueue(this);
		MyImageLoader.initMyImageLoader(queue);
		
		String picUrl=getIntent().getStringExtra("picUrl");
		String userPic=getIntent().getStringExtra("userPic");
		String username=getIntent().getStringExtra("username");
		String dateString=getIntent().getStringExtra("date");
		String ping_lun=getIntent().getStringExtra("ping_lun");
		String shou_cang=getIntent().getStringExtra("shou_cang");
		String text=getIntent().getStringExtra("text");
		String with=getIntent().getStringExtra("with");
		String height=getIntent().getStringExtra("height");
//		int r=getIntent().getIntExtra("r", 0);
		ArrayList<String> intentList=getIntent().getStringArrayListExtra("urls"); 
		
		userName=(TextView) findViewById(R.id.second_textView1);
		userName.setText(username);
		date=(TextView) findViewById(R.id.second_textView2);
		date.setText(dateString);
		info=(TextView) findViewById(R.id.second_textView3);
		info.setText(text);
		btn1=(Button) findViewById(R.id.second_button1);
		btn1.setText(ping_lun);
		btn2=(Button) findViewById(R.id.second_button2);
		btn2.setText(shou_cang);
		
		int r=this.getWindowManager().getDefaultDisplay().getWidth();
		RelativeLayout.LayoutParams iv1Params=new RelativeLayout.LayoutParams(r, Integer.parseInt(height)/Integer.parseInt(with)*r);
		iv1=(ImageView) findViewById(R.id.second_imageView1);
		iv1.setLayoutParams(iv1Params);
		queue.add(MyImageLoader.addImageRequest(iv1, picUrl, R.drawable.ic_launcher));
		iv1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		RelativeLayout.LayoutParams iv2Params=new RelativeLayout.LayoutParams(r/5, r/5);
		iv2=(ImageView) findViewById(R.id.second_imageView2);
		iv2.setLayoutParams(iv2Params);
		queue.add(MyImageLoader.addImageRequest(iv2, userPic, R.drawable.ic_launcher));
	}
	
}
