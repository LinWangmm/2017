package com.example.mingxingyichu;

import java.util.ArrayList;
import java.util.List;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.mxyc.model.Vaction;
import com.example.mxyc.model.Vcomponent;
import com.example.mxyc.wangluo.HttpBitmap;
import com.example.mxyc.wangluo.Httpget;
import com.example.mxyc.wangluo.Jsonjx;
import com.example.textdome.ui.MyScrollView;

public class ShouYeFragment extends Fragment {
	private ViewPager viewPager;
	private MyScrollView sc;
	private String url = "http://api2.haobao.com/banner?ga=%2Fbanner&gv=35&gi=000000000000000&access_token=&gc=wandoujia&gn=mxyc_adr&gf=android";
	private List<Vcomponent> list;
	private List<Bitmap> bim;
	private List<View> vpList;
	private int reswidth;
	private int reshight;
	private LayoutInflater pinflater;
	private Mypage aMypage;
	private View pView;
	private LayoutInflater viInflater;
	private ProgressDialog dialog;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		WindowManager wManager = (WindowManager) getActivity()
				.getSystemService(Context.WINDOW_SERVICE);
		pinflater = getActivity().getLayoutInflater().from(getActivity());
		viInflater = getActivity().getLayoutInflater().from(getActivity());
		reswidth = wManager.getDefaultDisplay().getWidth();
		reshight = wManager.getDefaultDisplay().getHeight() / 3;
		System.out.println("gggg===>" + reshight);
		System.out.println("KKKK===>" + reswidth);
		dialog = new ProgressDialog(getActivity());
		dialog.setTitle("正在加载");
		dialog.setMessage("Loding......");
		initView();

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return pView;
	}

	private void initView() {
		pView = pinflater.inflate(R.layout.activity_shouye, null);
		viewPager = (ViewPager) pView.findViewById(R.id.Viewp1);
		sc = (MyScrollView) pView.findViewById(R.id.scrollView1);	
		new Mytesk().execute(url);
	}

	class Mytesk extends AsyncTask<String, Void, List<Vcomponent>> {
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			dialog.show();
		}

		@Override
		protected List<Vcomponent> doInBackground(String... params) {
			// TODO Auto-generated method stub
			list = Jsonjx.getVcomponent(Httpget.getString(params[0]));
			System.out.println(list.size());
			bim = new ArrayList<Bitmap>();
			for (int i = 0; i < list.size(); i++) {
				Bitmap bitmap = HttpBitmap.getBitmap(list.get(i).getPicUrl(),
						reswidth, reshight);
				bim.add(bitmap);
				System.out.println("xxxx===>" + i);
			}
			vpList = new ArrayList<View>();
			for (int i = 0; i < list.size(); i++) {
				final Vaction v1 = list.get(i).getVaction();
				View view = viInflater.inflate(R.layout.viep, null);
				ImageView iv = (ImageView) view.findViewById(R.id.ivv);
				iv.setImageBitmap(bim.get(i));
				iv.setScaleType(ImageView.ScaleType.FIT_XY);
				iv.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(getActivity(),
								SeeActivity.class);
						intent.putExtra("id", v1.getId());
						intent.putExtra("title", v1.getTitle());
						startActivity(intent);
					}
				});
				vpList.add(view);
				System.out.println("llll=====)))" + i);
			}
			return list;
		}

		@Override
		protected void onPostExecute(List<Vcomponent> result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			aMypage = new Mypage(vpList);
			viewPager.setAdapter(aMypage);
			dialog.dismiss();
		}

	}

	class Mypage extends PagerAdapter {
		private List<View> convViews;

		public Mypage(List<View> convViews) {
			super();
			this.convViews = convViews;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return convViews.size();
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			container.addView(convViews.get(position));
			return convViews.get(position);
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// TODO Auto-generated method stub
			container.removeView(convViews.get(position));
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0 == arg1;
		}
	}
}
