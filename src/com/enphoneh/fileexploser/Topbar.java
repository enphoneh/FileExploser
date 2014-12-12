package com.enphoneh.fileexploser;

import fileexplorer.datamanager.GlobelVeluesManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Topbar extends RelativeLayout {

	static private int LEFT_BUTTON_ID = 101;
	static private int RIGHT_BUTTON_ID = 102;
	
	private Button leftButton , rightButton;
    private TextView tvTitle;

    private int leftTextColor;
    private Drawable leftBackground;
    private String leftText;

    private int rightTextColor;
    private Drawable rightBackground;
    private String rightText;

    private String title;
    private float titleTextSize;
    private int titleTextColor;
	
    private LayoutParams leftParams,rightParams,titleParams;
    
    private topbarClickListener listener;
    
    public interface topbarClickListener{
    	public void leftButtonClick();
    	public void rightButtonClick();
    }
    
    public void setOnTopbarClickListener(topbarClickListener listener){
    	this.listener = listener;
    }
    
	public Topbar(Context context, AttributeSet attrs) {
		super(context, attrs);
		TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.Topbar);
		leftTextColor =  ta.getColor(R.styleable.Topbar_leftTextColor, 0);
		leftText =  ta.getString(R.styleable.Topbar_leftText);
		leftBackground = ta.getDrawable(R.styleable.Topbar_leftBackground);
		
		rightTextColor =  ta.getColor(R.styleable.Topbar_rightTextColor, 0);
		rightText =  ta.getString(R.styleable.Topbar_rightText);
		rightBackground = ta.getDrawable(R.styleable.Topbar_rightBackground);
		
		title = ta.getString(R.styleable.Topbar_titleText);
		titleTextSize = ta.getFloat(R.styleable.Topbar_titleTextSize, 0);
		titleTextColor = ta.getColor(R.styleable.Topbar_titleTextColor, 0);
		
		ta.recycle();
		
		leftButton = new Button(context);
		rightButton = new Button(context);
		tvTitle = new TextView(context);
		
		leftButton.setId(LEFT_BUTTON_ID);
		leftButton.setText(leftText);
		leftButton.setTextSize(15);
		leftButton.setTextColor(leftTextColor);
		leftButton.setBackground(leftBackground);
		leftButton.setPadding(0, 0, 0, 0);
		
		rightButton.setId(RIGHT_BUTTON_ID);
		rightButton.setText(rightText);
		rightButton.setTextColor(rightTextColor);
		rightButton.setBackground(rightBackground);
		
		tvTitle.setText(title);
		tvTitle.setTextColor(titleTextColor);
		tvTitle.setTextSize(titleTextSize);
		
		setBackgroundColor(0xFF454545);
		
		leftParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
		leftParams.setMargins(0, 0, 0, 0);
		addView(leftButton,GlobelVeluesManager.TITLEBAR_LEFTBUTTON_INDEX, leftParams);
		
		rightParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
		rightParams.setMargins(0, 0, 0, 0);
		addView(rightButton,GlobelVeluesManager.TITLEBAR_RIGHTBUTTON_INDEX, rightParams);
		
		titleParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		titleParams.addRule(RelativeLayout.RIGHT_OF,LEFT_BUTTON_ID);
		titleParams.addRule(RelativeLayout.CENTER_VERTICAL,TRUE);
		titleParams.setMargins(10, 0, 0, 0);
		addView(tvTitle,GlobelVeluesManager.TITLEBAR_CENTERTITLE_INDEX, titleParams);
		
		leftButton.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				listener.leftButtonClick();				
			}
		});
		
		rightButton.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				listener.rightButtonClick();			
			}
		});
		
		rightButton.setVisibility(GONE);
		leftButton.setVisibility(GONE);
	}
	
	
}
