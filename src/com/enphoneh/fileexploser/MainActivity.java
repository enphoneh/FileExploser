package com.enphoneh.fileexploser;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.enphoneh.fileexploser.Topbar.topbarClickListener;

import fileexplorer.datamanager.GlobelVeluesManager;
import fileexploser.keyevent.controller.KeyEventController;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener {

	private TextView tvTitle;
	private ListView lvFiletree;
	private String path;
	private List<Map<String, Object>> list;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Topbar topbar =  (Topbar)findViewById(R.id.Topbar);
		tvTitle = (TextView) topbar.getChildAt(GlobelVeluesManager.TITLEBAR_CENTERTITLE_INDEX);
		lvFiletree = (ListView)findViewById(R.id.content_listview);
		tvTitle.setText("文件管理器");
		path = "/";
		refreshListItem(path);
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
	
	private void refreshListItem(String path){
		this.path = path;
		tvTitle.setText("文件管理器 > " + path);
		this.list = buildListForSimpleAdapter(path);
		String Keys []= new String [] {"name","path","img"};
		int IDs [] = new int [] {R.id.item_name,R.id.item_path,R.id.item_image};
		SimpleAdapter notes = new SimpleAdapter(this, this.list, R.layout.listitem, Keys, IDs);
		lvFiletree.setAdapter(notes);
		lvFiletree.setOnItemClickListener(this);
		lvFiletree.setSelection(0);
	}
	
	private List<Map<String, Object>> buildListForSimpleAdapter(String path){
		File [] files = new File(path).listFiles();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>(files.length);
		Map<String, Object> parentMap = new HashMap<String, Object>();
		parentMap.put("name", "..");
		parentMap.put("img", R.drawable.parent);
		parentMap.put("path", "go to parent directory");
		list.add(parentMap);		
		for (File file : files){
			Map<String, Object> directoryMap = new HashMap<String, Object>();
			if(file.isDirectory()){
				directoryMap.put("img", R.drawable.diretory);
			}else{
				directoryMap.put("img", R.drawable.file);
			}
			directoryMap.put("name", file.getName());
			directoryMap.put("path", file.getPath());
			list.add(directoryMap);
			Log.i("files", String.valueOf(directoryMap));
		}
		return list;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		if(position == 0){
			goToParent(this.path);
		}else{
			path = (String) this.list.get(position).get("path");
			File file = new File(path);
			if(file.isDirectory()){
				refreshListItem(path);
			}else{
//				文件的处理
			}
		}
		
	}
	
	private void goToParent(String path){
		File file = new File(path);
		File str_pa = file.getParentFile();
		if(str_pa == null){
			refreshListItem(path);
		}else{
			path = str_pa.getAbsolutePath();
			refreshListItem(path);
		}
	}
	
	
}
