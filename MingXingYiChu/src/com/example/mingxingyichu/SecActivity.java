package com.example.mingxingyichu;

import com.example.mxyc.model.Obj;
import com.example.mxyc.wangluo.DomeDialog;
import com.example.second.SecondPage;
import com.example.textdome.ui.SlidingLayout;

import android.os.Bundle;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SecActivity extends FragmentActivity implements OnClickListener {
	private FragmentManager fragmentManager;
	private ShouYeFragment syFragment;
	private SecondPage ztFragment;
	private XiangyaoFragment xyFragment;
	private WodeFragment wdFragment;
	private View syView;
	private View ztView;
	private View xyView;
	private View wdView;
	private ImageView syImageView;
	private ImageView ztImageView;
	private ImageView xyImageView;
	private ImageView wdImageView;
	private TextView syTextView;
	private TextView ztTextView;
	private TextView xyTextView;
	private TextView wdTextView;
	private SlidingLayout slidingLayout;
	private View scView;
	private ListView titlView;
	private ArrayAdapter<String> adapter;
	private TextView sy_title;
	private Button sy_bt;
	public static int secWith;
	public static int secHeight;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sec);
		initView();
		fragmentManager = getSupportFragmentManager();
		setTabSelection(0);
		DisplayMetrics mm=new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(mm);
		secHeight=mm.heightPixels;
		secWith=mm.widthPixels;
	}

	private void initView() {
		slidingLayout = (SlidingLayout) findViewById(R.id.slidingLayout);
		syView = findViewById(R.id.shouye_layout);
		ztView = findViewById(R.id.zhuanti_layout);
		xyView = findViewById(R.id.xiangyao_layout);
		wdView = findViewById(R.id.wode_layout);
		syImageView = (ImageView) findViewById(R.id.shouye_image);
		ztImageView = (ImageView) findViewById(R.id.zhuanti_image);
		xyImageView = (ImageView) findViewById(R.id.xiangyao_image);
		wdImageView = (ImageView) findViewById(R.id.wode_image);
		syTextView = (TextView) findViewById(R.id.shouye_text);
		ztTextView = (TextView) findViewById(R.id.zhuanti_text);
		xyTextView = (TextView) findViewById(R.id.xiangyao_text);
		wdTextView = (TextView) findViewById(R.id.wode_text);
		syView.setOnClickListener(this);
		ztView.setOnClickListener(this);
		xyView.setOnClickListener(this);
		wdView.setOnClickListener(this);
		titlView = (ListView) findViewById(R.id.title_list);
		scView = findViewById(R.id.lz);
		adapter = new ArrayAdapter<String>(getApplicationContext(),
				android.R.layout.simple_expandable_list_item_1, Obj.getList());
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.shouye_layout:
			setTabSelection(0);
			break;
		case R.id.zhuanti_layout:
			setTabSelection(1);
			break;
		case R.id.xiangyao_layout:
			setTabSelection(2);
			break;
		case R.id.wode_layout:
			setTabSelection(3);
			break;
		default:
			break;
		}
	}

	private void setTabSelection(int index) {
		clearSelection();
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		hideFragments(transaction);
		switch (index) {
		case 0:
			syImageView.setImageResource(R.drawable.bottom_icon_home_on);
			syTextView.setTextColor(Color.rgb(255, 75, 155));
			slidingLayout.setScrollEvent(scView);
			if (syFragment == null) {
				syFragment = new ShouYeFragment();
				transaction.add(R.id.content, syFragment);
				titlView.setAdapter(adapter);
				titlView.setOnItemClickListener(new OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// TODO Auto-generated method stub
						if (slidingLayout.isLeftLayoutVisible()) {
							slidingLayout.scrollToRightLayout();
						} else {
							slidingLayout.scrollToLeftLayout();
						}
						Toast.makeText(getApplicationContext(),
								Obj.getList().get(arg2), 1).show();
					}
				});
			} else {
				transaction.show(syFragment);
			}
			break;
		case 1:
			ztImageView.setImageResource(R.drawable.bottom_icon_topic_on);
			ztTextView.setTextColor(Color.rgb(255, 75, 155));
			if (ztFragment == null) {
				ztFragment = new SecondPage();
				slidingLayout.getScrollEvent(scView);
				transaction.add(R.id.content, ztFragment);
			} else {
				transaction.show(ztFragment);
			}
			break;
		case 2:
			xyImageView.setImageResource(R.drawable.bottom_icon_item_on);
			xyTextView.setTextColor(Color.rgb(255, 75, 155));
			if (xyFragment == null) {
				xyFragment = new XiangyaoFragment();
				slidingLayout.getScrollEvent(scView);
				transaction.add(R.id.content, xyFragment);

			} else {
				transaction.show(xyFragment);
			}
			break;
		case 3:
		default:
			wdImageView.setImageResource(R.drawable.bottom_icon_like_on);
			wdTextView.setTextColor(Color.rgb(255, 75, 155));
			if (wdFragment == null) {
				wdFragment = new WodeFragment();
				slidingLayout.getScrollEvent(scView);
				transaction.add(R.id.content, wdFragment);
			} else {
				transaction.show(wdFragment);
			}
			break;

		}
		transaction.commit();
	}

	private void hideFragments(FragmentTransaction transaction) {
		// TODO Auto-generated method stub
		if (syFragment != null) {
			transaction.hide(syFragment);
		}
		if (ztFragment != null) {
			transaction.hide(ztFragment);
		}
		if (xyFragment != null) {
			transaction.hide(xyFragment);
		}
		if (wdFragment != null) {
			transaction.hide(wdFragment);
		}

	}

	private void clearSelection() {
		// TODO Auto-generated method stub
		syImageView.setImageResource(R.drawable.bottom_icon_home);
		ztImageView.setImageResource(R.drawable.bottom_icon_topic);
		xyImageView.setImageResource(R.drawable.bottom_icon_item);
		wdImageView.setImageResource(R.drawable.bottom_icon_like);
		syTextView.setTextColor(Color.parseColor("#000000"));
		ztTextView.setTextColor(Color.parseColor("#000000"));
		xyTextView.setTextColor(Color.parseColor("#000000"));
		wdTextView.setTextColor(Color.parseColor("#000000"));
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
			DomeDialog.confirmDialog(this, "提示", "是否要退出程序");
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sec, menu);
		return true;
	}

}
