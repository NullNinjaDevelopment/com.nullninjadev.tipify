package com.nullninjadev.tipify;

import android.content.Context;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class PersonBar extends LinearLayout{
	private static Context mContext;
	private EditText et;
	private SeekBar sb;
	private TextView tv;
	private Person mPerson;

	/**
	 * 
	 * @param context is the handle to the Activity which created this PersonBar
	 * @param person is the Person object associated with this PersonBar
	 */
	PersonBar(Context context, Person person){
		super(context);
		mContext = context;
		mPerson = person;
		initUI();
	}
	
	/**
	 * Initializes the components used by PersonBar.
	 */
	private void initUI(){
		/* initialize LinearLayout params */
		this.setWeightSum(3);
		this.setMinimumHeight(android.view.ViewGroup.LayoutParams.WRAP_CONTENT);
		
		/* initialize EditText params */
		et = new EditText(mContext);
		et.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
		et.setSelectAllOnFocus(true);
		et.addTextChangedListener(new TextWatcher(){
			@Override
			public void afterTextChanged(Editable arg0) {
				mPerson.setName(et.getText().toString());
			}
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {}
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {}
		});
		
		this.addView(et, new LayoutParams(0, android.view.ViewGroup.LayoutParams.WRAP_CONTENT, 1));
		
		/* initialize SeekBar params */
		sb = new SeekBar(mContext);
		sb.setProgress((int)mPerson.getWeight());
		sb.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				mPerson.setWeight(progress);
				DataHelper.calculateTips(PersonBar.mContext);
			}
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {}
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {} });
		this.addView(sb, new LayoutParams(0, android.view.ViewGroup.LayoutParams.WRAP_CONTENT, 1));
		
		/* initialize TextView params */
		tv = new TextView(mContext);
		tv.setGravity(Gravity.CENTER);
		
		this.addView(tv, new LayoutParams(0, android.view.ViewGroup.LayoutParams.WRAP_CONTENT, 1));
	}
	
	public EditText getNameEditText(){
		return et;
	}
	
	public SeekBar getWeightSeekBar(){
		return sb;
	}
	
	public TextView getTipTextView(){
		return tv;
	}
}
