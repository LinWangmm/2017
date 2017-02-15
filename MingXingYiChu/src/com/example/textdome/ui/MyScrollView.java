package com.example.textdome.ui;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.mingxingyichu.R;
import com.example.mingxingyichu.SeeActivity;
import com.example.mxyc.model.Items;
import com.example.mxyc.model.Itm;
import com.example.mxyc.model.Tlt;
import com.example.mxyc.wangluo.HttpBitmap;
import com.example.mxyc.wangluo.Httpget;
import com.example.mxyc.wangluo.Jsonjx;

/**
 * 自定义的ScrollView，在其中动�?地对图片进行添加�?
 * 
 * @author guolin
 */
public class MyScrollView extends ScrollView implements OnTouchListener {

	/**
	 * 每一列的宽度
	 */
	private int columnWidth;

	/**
	 * 当前第一列的高度
	 */
	private int firstColumnHeight;

	/**
	 * 当前第二列的高度
	 */
	private int secondColumnHeight;

	/**
	 * 第一列的布局
	 */
	private LinearLayout firstColumn;

	/**
	 * 第二列的布局
	 */
	private LinearLayout secondColumn;

	/**
	 * MyScrollView下的直接子布�??
	 */
	private static View scrollLayout;

	/**
	 * MyScrollView布局的高度�?
	 */
	private static int scrollViewHeight;

	/**
	 * 记录上垂直方向的滚动距离�?
	 */
	private static int lastScrollY = -1;
	private List<Itm> list;
	private List<String> imgurl;
	private List<Bitmap> bim;
	private LinearLayout layout;
	private int reswidth;
	private int reshight;
	private String url="http://api2.haobao.com/stars?category=&ga=%2Fstars&flag=&gv=35&access_token=&gi=000000000000000&gc=wandoujia&gn=mxyc_adr&gf=android";

	/**
	 * MyScrollView的构造函数�?
	 * 
	 * @param context
	 * @param attrs
	 */
	public MyScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
		WindowManager wManager = (WindowManager) getContext().getSystemService(
				Context.WINDOW_SERVICE);
		reswidth = (wManager.getDefaultDisplay().getWidth()) / 2;
		reshight = (wManager.getDefaultDisplay().getHeight()) / 2;
		setOnTouchListener(this);
        new Mytsk().execute(url);
	}


	class Mytsk extends AsyncTask<String, Void, List<Itm>> {

		@Override
		protected List<Itm> doInBackground(String... params) {
			// TODO Auto-generated method stub
			String stt = Jsonjx.getJsonSy(Httpget.getString(params[0]))
					.getData().toString();
			System.out.println(1111111111);
			list = Jsonjx.getJsonItms(stt);
			System.out.println(222222222);
			imgurl = getUrList(list);
			System.out.println(333333333);
			bim = new ArrayList<Bitmap>();
			for (int i = 0; i < imgurl.size(); i++) {
				if (imgurl.get(i) != null) {
					Bitmap bitmap = HttpBitmap.getBitmap(imgurl.get(i),
							reswidth, reshight);
					bim.add(bitmap);
				} else {
					Bitmap bitmap = null;
					bim.add(bitmap);
				}
			}
			return list;
		}

		@Override
		protected void onPostExecute(List<Itm> result) {
			super.onPostExecute(result);
			for (int i = 0; i < result.size(); i++) {
				View view = getView(result.get(i), bim.get(i));
				findColumnToAdd(view);

			}
		}
	}

	private List<String> getUrList(List<Itm> it) {
		List<String> ilistStrings = new ArrayList<String>();
		System.out.println(33333);
		for (int i = 0; i < it.size(); i++) {
			Itm itm = it.get(i);
			if (itm.getTimestamp().equals("标题")) {
				Tlt tlt = (Tlt) it.get(i).getComponent();
				if (!tlt.getPicUrl().isEmpty()) {
					String url = tlt.getPicUrl();
					ilistStrings.add(url);
				} else {
					String url = "";
					ilistStrings.add(url);
				}

			} else {
				Items items = (Items) it.get(i).getComponent();
				String url = items.getPicUrl();
				ilistStrings.add(url);
			}
		}
		return ilistStrings;

	}

	/**
	 * 进行�?��关键性的初始化操作，获取MyScrollView的高度，以及得到第一列的宽度值�?并在这里�?��加载第一页的图片�?
	 */
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		super.onLayout(changed, l, t, r, b);
		if (changed) {
			scrollViewHeight = getHeight();
			scrollLayout = getChildAt(0);
			firstColumn = (LinearLayout) findViewById(R.id.first_column);
			secondColumn = (LinearLayout) findViewById(R.id.second_column);
			columnWidth = firstColumn.getWidth();

		}
	}

	private View getView(Itm itm, Bitmap bitmap) {
		if (itm.getTimestamp().equals("标题")) {
			final Tlt tlt = (Tlt) itm.getComponent();
			View view = LayoutInflater.from(getContext()).inflate(R.layout.tit,
					null);
			if (tlt.getPicUrl().equals("空")) {
				TextView tvday = (TextView) view.findViewById(R.id.textView1);
				TextView tvweek = (TextView) view.findViewById(R.id.textView2);
				TextView tvdate = (TextView) view.findViewById(R.id.textView3);
				TextView tvfab = (TextView) view.findViewById(R.id.textView4);
				tvday.setText(tlt.getDay());
				tvweek.setText(tlt.getWeekDay());
				tvdate.setText(tlt.getMonth());
				tvfab.setText(tlt.getShowTime());
				view.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						Intent intent = new Intent(getContext(),
								SeeActivity.class);
						intent.putExtra("id", tlt.getActions().getId());
						intent.putExtra("title", tlt.getActions().getTitle());
						getContext().startActivity(intent);
					}
				});
				return view;
			} else {
				TextView tvday = (TextView) view.findViewById(R.id.textView1);
				TextView tvweek = (TextView) view.findViewById(R.id.textView2);
				TextView tvdate = (TextView) view.findViewById(R.id.textView3);
				TextView tvfab = (TextView) view.findViewById(R.id.textView4);
				ImageView iView = (ImageView) view
						.findViewById(R.id.imageView1);
				tvday.setText(tlt.getDay());
				tvweek.setText(tlt.getWeekDay());
				tvdate.setText(tlt.getMonth());
				tvfab.setText(tlt.getShowTime());
				iView.setImageBitmap(bitmap);
				view.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						Intent intent = new Intent(getContext(),
								SeeActivity.class);
						intent.putExtra("id", tlt.getActions().getId());
						intent.putExtra("title", tlt.getActions().getTitle());
						getContext().startActivity(intent);
					}
				});
				return view;
			}

		} else {
			final Items items = (Items) itm.getComponent();
			View view = LayoutInflater.from(getContext()).inflate(R.layout.ron,
					null);
			ImageView iv = (ImageView) view.findViewById(R.id.imageView1);
			TextView msg = (TextView) view.findViewById(R.id.textView3);
			TextView cView = (TextView) view.findViewById(R.id.textView1);
			TextView xView = (TextView) view.findViewById(R.id.textView2);
			iv.setImageBitmap(bitmap);
			msg.setText(items.getDescription());
			cView.setText(items.getItemsCount());
			xView.setText(items.getCollectionCount());
			view.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Intent intent = new Intent(getContext(), SeeActivity.class);
					intent.putExtra("id", items.getAction().getName());
					intent.putExtra("title", items.getAction().getDateTime());
					getContext().startActivity(intent);
				}
			});
			return view;
		}

	}

	/**
	 * 找到此时应该添加图片的一列�?原则就是对三列的高度进行判断，当前高度最小的�?��就是应该添加的一列�?
	 * 
	 * @param imageView
	 * @param imageHeight
	 * @return 应该添加图片的一�?
	 */
	private void findColumnToAdd(View view) {
		if (firstColumnHeight <= secondColumnHeight) {
			firstColumnHeight += reshight;
			firstColumn.addView(view);
		} else {
			secondColumnHeight += reshight;
			secondColumn.addView(view);
		}
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

}