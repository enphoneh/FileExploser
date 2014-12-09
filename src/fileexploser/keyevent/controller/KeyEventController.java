package fileexploser.keyevent.controller;

import android.app.Activity;
import android.view.KeyEvent;

public class KeyEventController {
	
	private Activity  mActivity;

	public KeyEventController(Activity activity) {
		mActivity = activity;
	}
	
	public void  onKeyBack(){
		KeyEvent newEvent = new KeyEvent(KeyEvent.ACTION_DOWN,  
                KeyEvent.KEYCODE_BACK);  
		mActivity.onKeyDown(KeyEvent.KEYCODE_BACK, newEvent); 
	}
	

}
