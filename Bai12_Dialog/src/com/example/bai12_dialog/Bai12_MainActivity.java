package com.example.bai12_dialog;

import com.example.bai13_dialog.R;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Bai12_MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bai12_activity_main);
		Button btDialog = (Button) findViewById(R.id.button1);
		btDialog.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				final Dialog dialog = new Dialog(Bai12_MainActivity.this);
				dialog.setContentView(R.layout.bai12_dialog);
				TextView tvTitle = (TextView) dialog.findViewById(R.id.tvTitle);
				TextView tvContent = (TextView) dialog
						.findViewById(R.id.tvContent);
				Button btCancel = (Button) dialog.findViewById(R.id.btCancel);
				Button btConfirm = (Button) dialog.findViewById(R.id.btConfirm);
				tvTitle.setText("Permissions");
				tvContent
						.setText("This app determines your phone's location and shares it with Google in order to serve personalized alerts to you. This allows for a beter overall app experience.");
				btCancel.setText("DECLINE");
				btConfirm.setText("ACCEPT");
				btCancel.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						Toast.makeText(getApplicationContext(), "DECLINE!",
								Toast.LENGTH_SHORT).show();
						dialog.dismiss();
					}
				});
				btConfirm.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						Toast.makeText(getApplicationContext(), "ACCEPT!",
								Toast.LENGTH_SHORT).show();
						dialog.dismiss();
					}
				});
				dialog.show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
