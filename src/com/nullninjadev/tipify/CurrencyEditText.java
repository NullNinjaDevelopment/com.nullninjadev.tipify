package com.nullninjadev.tipify;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;

public class CurrencyEditText extends EditText /*implements OnKeyListener*/{
	private int[] mKeyCodes = {
			KeyEvent.KEYCODE_0, KeyEvent.KEYCODE_1, KeyEvent.KEYCODE_2,
			KeyEvent.KEYCODE_3, KeyEvent.KEYCODE_4, KeyEvent.KEYCODE_5,
			KeyEvent.KEYCODE_6, KeyEvent.KEYCODE_7, KeyEvent.KEYCODE_8,
			KeyEvent.KEYCODE_9, KeyEvent.KEYCODE_PERIOD, KeyEvent.KEYCODE_DEL
	};
	
	
	public CurrencyEditText(Context context) {
		super(context);
//		this.setOnKeyListener(this);
//		setKeyListener(DigitsKeyListener.getInstance(true,true));
	}
	
	public CurrencyEditText(Context context, AttributeSet attrs){
		super(context, attrs);
//		this.setOnKeyListener(this);
//		setKeyListener(DigitsKeyListener.getInstance(false, true));
	}

//	private boolean isValidKeyCode(int keyCode){
//		for(int key: mKeyCodes){
//			if(keyCode == key)
//				return true;
//		}
//		return false;
//	}
}
