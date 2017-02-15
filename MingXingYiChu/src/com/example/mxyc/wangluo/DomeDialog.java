package com.example.mxyc.wangluo;



import com.example.mingxingyichu.SecActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
/*
 * 
 * Dialog�趨
 * */
public class DomeDialog {
	public static void confirmDialog(final Context context, String title,
			String message) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setTitle(title);
		builder.setMessage(message);
		builder.setPositiveButton("OK", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
                ((SecActivity)context).finish();
			}
		});
		builder.setNegativeButton("Cancel", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub

			}
		});
		builder.create().show();
	}

}
