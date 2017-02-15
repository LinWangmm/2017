package com.example.mingxingyichu;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class SeeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_see);
		Intent intent = getIntent();
		TextView t1 = (TextView) findViewById(R.id.tss);
		t1.setText(intent.getStringExtra("id")+intent.getStringExtra("title"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.see, menu);
		return true;
	}

}
