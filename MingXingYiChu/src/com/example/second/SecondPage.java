package com.example.second;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.support.v4.util.LruCache;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.example.mingxingyichu.MainActivity;
import com.example.mingxingyichu.R;
import com.example.mingxingyichu.SecActivity;
import com.example.tools.MyImageLoader;
import com.example.tools.NetTool;
import com.example.xiangyao.SecondSecondActivity;



public class SecondPage extends ListFragment implements OnScrollListener,OnTouchListener{
	static LruCache<String, Bitmap> cache=MyImageLoader.cache;
	String url="http://api2.haobao.com/topics?category=%E5%85%A8%E9%83%A8&ga=%2Ftopics&flag=&gv=35&gi=000000000000000&access_token=&gc=wandoujia&gn=mxyc_adr&gf=android";
	RequestQueue queue;
	RelativeLayout.LayoutParams params;
	List<ImageView> imageList;
	boolean isTouch;
	private RequestQueue requestQueue;
	private ImageLoader imageLoader;
public SecondPage() {
		// TODO Auto-generated constructor stub
		
	
	params=new RelativeLayout.LayoutParams(SecActivity.secWith, SecActivity.secHeight/5);
	
	imageList=new ArrayList<ImageView>();
}


@Override
public void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	
	queue=Volley.newRequestQueue(getActivity());
	MyImageLoader.initMyImageLoader(queue);
	
	new MyTask().execute(url);
}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	return super.onCreateView(inflater, container, savedInstanceState);
}
class MyTask extends AsyncTask<String, Void, List>{

	@Override
	protected List doInBackground(String... params) {
		// TODO Auto-generated method stub
		byte[] b=NetTool.getHttpInfo(params[0]);
		List list=SecondPageJSON.getSecondPageJSONData(new String(b));
		return list;
	}
	@Override
	protected void onPostExecute(List result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		if(result!=null&&!result.isEmpty()){
		setListAdapter(new MyBaseAdapter(result));	
		}
	}
}
class MyBaseAdapter extends BaseAdapter{
	List<SecondPageModel> mList;
	public MyBaseAdapter(List<SecondPageModel> mList) {
		// TODO Auto-generated constructor stub
		this.mList=mList;		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Holder holder=null;
//		View v=null;
		if(convertView==null){
			holder=new Holder();
			LayoutInflater inflater=LayoutInflater.from(getActivity());
//			View v=inflater.inflate(R.layout.second_page_item, parent, false);
			convertView=inflater.inflate(R.layout.second_page_item, parent, false);
			holder.mainImage=(ImageView) convertView.findViewById(R.id.second_page_item_imageView1);
//			System.out.println(position+"--convertView--"+holder.mainImage);
//			holder.mainImage.setTag(mList.get(position).getPicUrl());
			holder.iv=(ImageView) convertView.findViewById(R.id.second_page_item_imageView2);
			holder.title= (TextView) convertView.findViewById(R.id.second_page_item_textView1);
			holder.date=(TextView) convertView.findViewById(R.id.second_page_item_textView2);
			holder.btn=(Button) convertView.findViewById(R.id.second_page_item_button1);
			convertView.setTag(holder);
//			queue.add(MyImageLoader.addImageRequest(hold2er.mainImage, mList.get(position).getPicUrl(), R.drawable.ic_launcher));
		}else{
//			v=convertView;
		
		holder=(Holder) convertView.getTag();
		}
		
		holder.title.setText(mList.get(position).getTitle());
		holder.date.setText(mList.get(position).getDay());
		holder.btn.setText(mList.get(position).getCollectionCount());
		
		
		holder.mainImage.setLayoutParams(params);
		holder.mainImage.setTag(mList.get(position).getPicUrl());
		holder.mainImage.setImageBitmap(getBitmap(mList.get(position).getPicUrl()));
//		imageList.add(holder.mainImage);
//		System.out.println(position+"--getView--"+holder.mainImage);
		convertView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(getActivity(),SecondSecondActivity.class);
				intent.putExtra("id", mList.get(position).getId());
				startActivity(intent);
			}
		});
		return convertView;
	}
	
}


private class Holder{
	ImageView mainImage,iv;
	TextView title,date;
	Button btn;
}
private Bitmap getBitmap(String getBitmapurl){
	Bitmap bm;
	if((bm=getBitmapFromLrucache(getBitmapurl))!=null){
		return bm;
	}else if((bm=BitmapFactory.decodeFile(Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+getBitmapurl))!=null){
		return bm;
	}
	else{
		new MyBitmapTask(getBitmapurl).execute();
	}
	return BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
	
}
private void putToLrucache(String url, Bitmap bitmap){
	cache.put(url, bitmap);
}
private Bitmap getBitmapFromLrucache(String url) {
	return cache.get(url);
}
private class MyBitmapTask extends AsyncTask<String, Void, Bitmap>{
	String urlTask;
	
	public MyBitmapTask(String url) {
		// TODO Auto-generated constructor stub
		this.urlTask=url;
		
	}

	@Override
	protected Bitmap doInBackground(String... params) {
		// TODO Auto-generated method stub
		byte[] b=NetTool.getHttpInfo(urlTask);
		Bitmap bm=BitmapFactory.decodeByteArray(b, 0, b.length);
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					FileOutputStream out=new FileOutputStream(new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+urlTask));
					out.flush();
					out.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		return bm;
	}
	@Override
	protected void onPostExecute(Bitmap result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		ImageView iv=(ImageView) getView().findViewWithTag(urlTask);
		if(iv!=null)
		iv.setImageBitmap(result);
	}
}

@Override
public void onScrollStateChanged(AbsListView view, int scrollState) {
	// TODO Auto-generated method stub
	
}


@Override
public void onScroll(AbsListView view, int firstVisibleItem,
		int visibleItemCount, int totalItemCount) {
	// TODO Auto-generated method stub
	if(isTouch)
	System.out.println(firstVisibleItem);
//	for(int ){
//		
//	}
}


@Override
public boolean onTouch(View v, MotionEvent event) {
	// TODO Auto-generated method stub
	if(event.getAction()==MotionEvent.ACTION_MOVE|event.getAction()==MotionEvent.ACTION_DOWN|event.getAction()==MotionEvent.ACTION_UP){
		isTouch=true;
	}
	return false;
}
}
