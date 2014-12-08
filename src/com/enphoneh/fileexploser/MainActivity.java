package com.enphoneh.fileexploser;

import com.enphoneh.fileexploser.Topbar.topbarClickListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Topbar topbar =  (Topbar)findViewById(R.id.Topbar);
		topbar.setOnTopbarClickListener(new topbarClickListener() {
			
			@Override
			public void rightButtonClick() {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "leftButtonClick", Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void leftButtonClick() {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "rightButtonClick", Toast.LENGTH_SHORT).show();
			}
		});
	}

}
