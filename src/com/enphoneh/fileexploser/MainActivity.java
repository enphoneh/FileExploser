package com.enphoneh.fileexploser;

import com.enphoneh.fileexploser.Topbar.topbarClickListener;

import fileexploser.keyevent.controller.KeyEventController;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
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
				
			}
			
			@Override
			public void leftButtonClick() {				
				MainActivity.this.onBackPressed();
			}
		});
	}
	
	
}
