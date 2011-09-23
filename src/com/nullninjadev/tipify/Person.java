package com.nullninjadev.tipify;

public class Person {
	private String mName;
	private float mTip;
	private float mWeight;
	private int mID;
	
	Person(int ID){
		mID = ID;
		mName = "Guest " + mID;
		mWeight = 100;
	}
	
	public void setName(String name){ mName = name; }
	public void setTip(float tip){ mTip = tip; }
	public void setWeight(float weight){ mWeight = weight; }
	
	public String getName(){ return mName; }
	public float getTip(){ return mTip; }
	public float getWeight(){ return mWeight; }
}
