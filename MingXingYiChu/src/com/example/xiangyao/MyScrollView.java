package com.example.xiangyao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.example.mingxingyichu.R;
import com.example.tools.MyImageLoader;
import com.example.tools.NetTool;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;

import android.util.AttributeSet;
import android.util.Log;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;




public class MyScrollView extends ScrollView implements OnTouchListener{
	static String url="http://api2.haobao.com/threads?category=&ga=%2Fthreads&flag=&gv=35&gi=000000000000000&access_token=&type=hot&gc=wandoujia&gn=mxyc_adr&gf=android";
	private static final int PAGE=10;
	LinearLayout mLinearLayout1,mLinearLayout2;
	//LinearLayout with
	int mLinearLayoutWith,itemViewHeight,mLinearLayout1Height,mLinearLayout2Height;
	String shorterLayoutFlag;
	Context context;
	boolean loadOnce;
	View itemView;
//	MyImageLoader mImageLoader;
	Map<String,Object> loadBitmapTaskMap;
	List<ThirdModel> glist;
	int bimageHeight;
	int LinearLayoutHeight,b,r;
	int page;
	List listForImageCache;
	int listForImageCacheOldY,listForImageCacheNewY;
	Map<String,List<Bitmap>> bitmapMap;
//	Bitmap nullBitmap;
	Button remen;
	ImageButton pinglun;
	
	boolean popup_flag;
	View popParent,pop;
	PopupWindow mPopupWindow;
	
	////volley
	private RequestQueue queue;
	private ProgressDialog dialog;
	
	public MyScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		this.context=context;
//		mImageLoader=MyImageLoader.getInstance();
		setOnTouchListener(this);
		
//		loadBitmapTaskMap=new HashMap<String, Object>();
		dialog=new ProgressDialog(context);
//		dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		dialog = ProgressDialog.show(getContext(), "Loading...", "Please wait...", false, false);
	
		new MyTask().execute(url);
		
		//volley
		queue = Volley.newRequestQueue(getContext());
		MyImageLoader.initMyImageLoader(queue);
		
		
	}
	
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		if(glist!=null){
		switch(event.getAction()){
		case MotionEvent.ACTION_UP:
			if(b+getScrollY()>=LinearLayoutHeight){
				addLayoutToMain();												//
			}
			if(b+getScrollY()==LinearLayoutHeight)
				Toast.makeText(getContext(), "加载中···", 0).show();
			break;
		}
		}
		return false;
	}
	
	public void addLayoutToMain(){
		bitmapMap=new HashMap<String, List<Bitmap>>();
		
		int start=page*PAGE;
		int end=start+PAGE;
		int last=glist.size();
		
		if(end<=last){
			if(last>start&last<end)
				end=last;	
			for(int i=start;i<end;i++){
//				List list=new ArrayList();
				itemView=getItemView( glist, i);
				getShorterLayout().addView(itemView);
			}
			
		}else{
			//ˢ��
			Toast.makeText(getContext(), "ˢ��", 0).show();
		}
		page++;
	}
	@Override
	protected void onLayout(boolean changed, int l, int t, int r,int b) {
		// TODO Auto-generated method stub
		super.onLayout(changed, l, t, r, b);
		if(changed&!loadOnce){
			mLinearLayout1=(LinearLayout) findViewById(R.id.waterfall_LinearLayout1);
			mLinearLayout2=(LinearLayout) findViewById(R.id.waterfall_LinearLayout2);
			mLinearLayoutWith=mLinearLayout1.getWidth();
			loadOnce=true;
			
			this.b=b;
			this.r=r;
			
//			remen=(Button)findViewById(R.id.waterfall_button1);
//			pinglun=(ImageButton) findViewById(R.id.waterfall_imageButton1);
//			popParent=findViewById(R.id.waterfall_RelativeLayout);
//			pop=findViewById(R.layout.waterfall_popu);
//			LayoutInflater inflater=LayoutInflater.from(context);
//			mPopupWindow=new PopupWindow(inflater.inflate(R.layout.waterfall_popu, null), r, b);
//			
//			
//			remen.setOnClickListener(new OnClickListener() {
//				
//				@Override
//				public void onClick(View v) {
//					// TODO Auto-generated method stub
//					
//					if(!popup_flag){
//						mPopupWindow.showAsDropDown(popParent);
//						popup_flag=true;
//					}
//					else{
//						mPopupWindow.dismiss();
//						popup_flag=false;
//					}
//						
//				}
//			});
		}	
		
		
		LinearLayoutHeight=mLinearLayout1.getHeight();
	}

	class MyTask extends AsyncTask<String, Void, List<ThirdModel>>{
		public MyTask() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		protected List<ThirdModel> doInBackground(String... params) {
			// TODO Auto-generated method stub
			//�������
//			dialog=new ProgressDialog(getContext());
//			dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//			dialog = ProgressDialog.show(getContext(), "Loading...", "Please wait...", true, false);
			
			byte[] b=NetTool.getHttpInfo(params[0]);
			List<ThirdModel> list=ThirdJsonTool.getItemsData(b);
			return list;
		}
		@Override
		protected void onPostExecute(List<ThirdModel> result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			glist=result;
			System.out.println(glist);
			dialog.dismiss();
			addLayoutToMain();											//
//			
		}
	}
		
	private View getItemView(List<ThirdModel> list,final int i){
		
		final ItemHolder ih=new ItemHolder();
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View v=inflater.inflate(R.layout.waterfall_item,null);
		ih.content=(TextView) v.findViewById(R.id.waterfall_item_textView1);
		ih.username=(TextView) v.findViewById(R.id.waterfall_item_textView2);
		ih.date=(TextView) v.findViewById(R.id.waterfall_item_textView3);
		ih.btn1=(Button) v.findViewById(R.id.waterfall_item_button1);	      
		ih.btn2=(Button) v.findViewById(R.id.waterfall_item_button2);	
		ih.bigbm=(ImageView)v.findViewById(R.id.waterfall_item_imageView1);
		ih.userbm=(ImageView) v.findViewById(R.id.waterfall_item_imageView2);
		
		ih.content.setText(list.get(i).getDescription_main());
		Drawable d1=getResources().getDrawable(R.drawable.postdetail_like_button);
		d1.setBounds(0, 0, 25,25);
		ih.btn1.setCompoundDrawables(d1, null, null, null);
		ih.btn1.setText(list.get(i).getCommentCount());
		Drawable d2=getResources().getDrawable(R.drawable.list_icon_link);
		d2.setBounds(0, 0, 25,25);
		ih.btn2.setCompoundDrawables(d2, null, null, null);
		ih.btn2.setText(list.get(i).getCollectionCount());
		ih.username.setText(list.get(i).getUserName());
		ih.date.setText(list.get(i).getDateTime());
		
		bimageHeight= mLinearLayoutWith*Integer.parseInt(list.get(i).getHeight())/Integer.parseInt(list.get(i).getWidth());
		LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(mLinearLayoutWith,bimageHeight);
		ih.bigbm.setLayoutParams(params);
		queue.add(MyImageLoader.addImageRequest(ih.bigbm, list.get(i).getPicUrl_main(), R.drawable.ic_launcher));
		
		RelativeLayout.LayoutParams userparams=new RelativeLayout.LayoutParams(mLinearLayoutWith/4, mLinearLayoutWith/4);
		ih.userbm.setLayoutParams(userparams);
		ih.userbm.setTag(list.get(i).getUserAvatar());
		queue.add(MyImageLoader.addImageRequest(ih.userbm, list.get(i).getUserAvatar(), R.drawable.ic_launcher));
		
		v.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub				
				//��ת
				Intent intent=new Intent(context,SecondActivity.class);
								
				intent.putExtra("picUrl", glist.get(i).getPicUrl());
				System.out.println("---"+glist.get(i).getPicUrl());
				intent.putExtra("userPic", glist.get(i).getUserAvatar());
				intent.putExtra("username", glist.get(i).getUserName());
				intent.putExtra("date", glist.get(i).getDateTime());
				intent.putExtra("ping_lun", glist.get(i).getCollectionCount());
				intent.putExtra("shou_cang", glist.get(i).getCommentCount());
				intent.putExtra("text", glist.get(i).getText());
				intent.putStringArrayListExtra("urls",glist.get(i).getWebUrl());
				
				intent.putExtra("r", r);
				intent.putExtra("with", glist.get(i).getWidth());
				intent.putExtra("height", glist.get(i).getHeight());
				context.startActivity(intent);
			}
		});
		
		return v;
	}
	
//	public Bitmap fillBitmap(String url,int getBitmap_i,String bmFlag){
//		Bitmap bm;
//			if((bm=mImageLoader.getBitmapFromLru(url))!=null)
//				return bm;
//			else{
//				if(!loadBitmapTaskMap.containsKey(url)) {
//					Object obj = null;
//					if(bmFlag.equals("bigbm")){
//						obj=new MyBitmapTask(url,getBitmap_i).execute();
//					}
//					if(bmFlag.equals("userbm")){
//						obj=new MyUserBitmapTask(url,getBitmap_i).execute();
//					}
//					loadBitmapTaskMap.put(url, obj);
//				}
//			}
//		return BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
//	}
	
	
	//��ͼƬ
//	class MyBitmapTask extends AsyncTask<String, Void, Bitmap>{
//		String url;
//		int MyBitmapTask_i;
//		byte[] b;
//		public MyBitmapTask(String url,int MyBitmapTask_i) {
//			super();
//			// TODO Auto-generated constructor stub
//			this.url=url;
//			this.MyBitmapTask_i=MyBitmapTask_i;
//		}
//		@Override
//		protected Bitmap doInBackground(String... params) {
//			// TODO Auto-generated method stub
//			b=NetTool.getHttpInfo(url);
//			BitmapFactory.Options opt=new BitmapFactory.Options();
//			opt.inJustDecodeBounds=true;
//			Bitmap bmold=BitmapFactory.decodeByteArray(b, 0, b.length,opt);
//			int oldwith=opt.outWidth;
//			opt.inSampleSize=oldwith/mLinearLayoutWith;
//			opt.inJustDecodeBounds=false;
//			return BitmapFactory.decodeByteArray(b, 0, b.length, opt);
//		}
//		@Override
//		protected void onPostExecute(Bitmap result) {
//			// TODO Auto-generated method stub
//			super.onPostExecute(result);
//			loadBitmapTaskMap.remove(url);
//			
//			mImageLoader.addBitmapToLru(url, result);
//			ImageView iv=(ImageView) findViewWithTag(url);
//			iv.setImageBitmap(result);
//		}
//		
//	}
	
	//ͷ��ͼƬ
//		class MyUserBitmapTask extends AsyncTask<String, Void, Bitmap>{
//			String url;
//			int MyBitmapTask_i;
//			byte[] b;
//			public MyUserBitmapTask(String url,int MyBitmapTask_i) {
//				super();
//				// TODO Auto-generated constructor stub
//				this.url=url;
//				this.MyBitmapTask_i=MyBitmapTask_i;
//			}
//			@Override
//			protected Bitmap doInBackground(String... params) {
//				// TODO Auto-generated method stub
//				b=NetTool.getHttpInfo(url);
//				BitmapFactory.Options opt=new BitmapFactory.Options();
//				opt.inJustDecodeBounds=true;
//				Bitmap bmold=BitmapFactory.decodeByteArray(b, 0, b.length,opt);
//				int oldwith=opt.outWidth;
//				opt.inSampleSize=oldwith/mLinearLayoutWith/4;
//				opt.inJustDecodeBounds=false;
//				return BitmapFactory.decodeByteArray(b, 0, b.length, opt);
//			}
//			@Override
//			protected void onPostExecute(Bitmap result) {
//				// TODO Auto-generated method stub
//				super.onPostExecute(result);
//				loadBitmapTaskMap.remove(url);
//				
//				mImageLoader.addBitmapToLru(url, result);
//				ImageView iv=(ImageView) findViewWithTag(url);
//				iv.setImageBitmap(result);
//			}
//			
//		}
	class ItemHolder{
		ImageView bigbm,userbm;
		TextView content,username,date;
		Button btn1,btn2;
	}
	public LinearLayout getShorterLayout(){
//		System.out.println(mLinearLayout1Height+"---"+mLinearLayout2Height);
		if(mLinearLayout1Height>mLinearLayout2Height){
			mLinearLayout2Height+=bimageHeight;
			return mLinearLayout2;
		}else{ 
			mLinearLayout1Height+=bimageHeight;
			return mLinearLayout1;
		}
	}
}