package com.enphoneh.fileexploser;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Topbar extends RelativeLayout {

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
		titleTextSize = ta.getInt(R.styleable.Topbar_titleTextSize, 0);
		titleTextColor = ta.getColor(R.styleable.Topbar_titleTextColor, 0);
		
		ta.recycle();
		
		leftButton = new Button(context);
		rightButton = new Button(context);
		tvTitle = new TextView(context);
		
		leftButton.setText(leftText);
		leftButton.setTextColor(leftTextColor);
		leftButton.setBackground(leftBackground);
		
		rightButton.setText(rightText);
		rightButton.setTextColor(rightTextColor);
		rightButton.setBackground(rightBackground);
		
		tvTitle.setText(title);
		tvTitle.setTextColor(titleTextColor);
		tvTitle.setTextSize(titleTextSize);
		
		setBackgroundColor(0xFF454545);
		
		leftParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
		addView(leftButton, leftParams);
		
		rightParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
		addView(rightButton, rightParams);
		
		titleParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		titleParams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);
		addView(tvTitle, titleParams);
	}



}
