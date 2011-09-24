package com.nullninjadev.tipify;

public class Person {
	private String mName;
	private float mTip;
	private float mWeight;
	private int mID;
	
	/**
	 * 
	 * @param ID gives the Person a unique number which is used in naming them
	 */
	Person(int ID){
		mID = ID;
		mName = "Guest " + mID;
		mWeight = 100;
	}
	
	/**
	 * Sets the Person's name.
	 * @param name is the Person's name
	 */
	public void setName(String name){ mName = name; }
	
	/**
	 * Sets the tip amount associated with this Person.
	 * @param tip is the portion of the total tip that this Person should pay
	 */
	public void setTip(float tip){ mTip = tip; }
	
	/**
	 * Sets the weight of the overall tip that this Person will pay.
	 * @param weight is the weight of the total tip that is applied ot this Person.
	 */
	public void setWeight(float weight){ mWeight = weight; }
	
	public String getName(){ return mName; }
	public float getTip(){ return mTip; }
	public float getWeight(){ return mWeight; }
}
