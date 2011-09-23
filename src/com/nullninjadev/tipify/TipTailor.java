package com.nullninjadev.tipify;

import java.text.DecimalFormat;
import java.util.Vector;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class TipTailor extends Activity {
	private Vector<PersonBar> mBars;
	private static TipTailor ref;
	private LinearLayout pBarLayout;
	
	public static TipTailor getInstance(){
		if(ref == null) ref = new TipTailor();
		return ref;
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tip_tailor);
        ref = this;
        mBars = new Vector<PersonBar>();
//        Vector<Person> people = DataHelper.getPeople();
//        for(Person person : people){
//        	mBars.add(new PersonBar(this, person));
//        }
        initUI(); // Add the necessary PersonBars to the UI
        DataHelper.calculateTips(this);
    }
    
    private void initUI(){
    	pBarLayout = (LinearLayout)findViewById(R.id.pbar_container);
    	
    	for(Person person : DataHelper.getPeople()){
    		PersonBar pBar = new PersonBar(this, person);
    		pBar.getNameEditText().setText(person.getName());
    		mBars.add(pBar);
    		pBarLayout.addView(pBar);
    	}
    }
    
    public void updateUI(){
    	DecimalFormat myFormatter = (DecimalFormat) DecimalFormat.getCurrencyInstance();
		Vector<Person> people = DataHelper.getPeople();
		
    	for(int i = 0; i < mBars.size(); i++){
    		// "$###,###.##" or put "$" in front of the text!
//    		System.out.println("START DEBUG");
//    		System.out.println("mBars.size() = " + mBars.size() + " at iteration " + i);
 
//    		System.out.println("peeps.size() = " + peeps.size() + " at iteration " + i);
//    		for(int j = 0; j < peeps.size(); j++){
//    			Person peep = peeps.get(j);
//    			System.out.println(peep.getName());
//    		}
//    		System.out.println("END DEBUG");
//    		Person peep = peeps.get(i);
    		mBars.get(i).getTipTextView().setText(myFormatter.format(people.get(i).getTip()));
//    		mBars.get(i).getTipTextView().setText("hi");
    	}
    }

    /* TESTER!
    @Override
    public boolean onTouchEvent(MotionEvent event){
    	for(Person person : DataHelper.getPeople()){
    		if(person.getName() != null){
    		System.out.println("TOUCHED! " + person.getName());
    		}
    	}
    	return true;
    }
    */
}
