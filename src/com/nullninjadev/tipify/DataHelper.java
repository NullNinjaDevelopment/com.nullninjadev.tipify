package com.nullninjadev.tipify;

import java.util.Vector;

import android.content.Context;

public class DataHelper {
	private static Vector<Person> people;
	private static float mTip = 0;
	private static float mTipRate = 0.20f;
	private static float mMinTipRate = 0.1f;
	private static float mMaxTipRate = 0.3f;
	private static int mNumGuests = 1; // total number of guests, initially 1
	private static float mBillTotal = 0; // bill total dollar amount, initially 0
	private static float mDeductions = 0;
	private static float mTax = 0;
	
	/**
	 * Initializes the Person Vector and sets the number of guests to 1 by default.
	 */
	public static void initVars(){
		people = new Vector<Person>();
		setNumGuests(1);
	}
	
	/**
	 * Lets the program get the current list of people at any time.
	 * @return The list of Person objects that are splitting the tip.
	 */
	public static Vector<Person> getPeople(){
		if(people == null){
			people = new Vector<Person>();
			setNumGuests(1);
		}
		return people;
	}
	
	/**
	 * Takes the bill total, deductions and tax into account and calculates the total tip
	 * to be displayed on the Tipify screen.
	 */
	public static void calculateTotalTip(){
		mTip = (mBillTotal + (ComponentInclusion.isDeductionIncluded() ? mDeductions : 0)
				- (ComponentInclusion.isTaxIncluded() ? 0 : mTax)) * mTipRate;
	}
	
	/**
	 * Calculates the appropriate tips based on the weight given to each Person. Updates
	 * the TipTailor screen whenever this method is called within that Activity.
	 * @param context gives the method a handle on the Activity that calls it so that
	 * it knows if it should update the appropriate UI.
	 */
	public static void calculateTips(Context context){
		calculateTotalTip();
		int sumWeights = 0;
		for(Person person : getPeople()){
			sumWeights += person.getWeight();
		}
		for(Person person : getPeople()){
			person.setTip(person.getWeight() / sumWeights * mTip);
		}
		if(context == TipTailor.getInstance()){
			((TipTailor) context).updateUI();
		}
	}
	
	/**
	 * Adds or removes guests to/from the Person Vector when the number of
	 * guests changes on the Tipify screen.
	 */
	public static void adjustGuestList(){
		if(mNumGuests >= people.size()){
			for(int i = people.size(); i < mNumGuests; i++){
				people.add(new Person(i+1));
			}
		}
		else{
			for(int i = people.size()-1; i > mNumGuests-1; i--){
				people.remove(i);
			}
		}
	}

	/**
	 * Sets the number of guests who are splitting the tip.
	 * @param numGuests the number of guests who are splitting the tip
	 */
	public static void setNumGuests(int numGuests){
		mNumGuests = numGuests;
		adjustGuestList();
	}
	
	public static int getNumGuests(){ return mNumGuests; }
	public static void setBillTotal(float billTotal){ mBillTotal = billTotal; }
	public static float getBillTotal(){ return mBillTotal; }
	public static void setDeductions(float deductions){ mDeductions = deductions; }
	public static float getDeductions(){ return mDeductions; }
	public static void setTax(float tax){ mTax = tax; }
	public static float getTax(){ return mTax; }
	public static void setTipRate(float tipRate){ mTipRate = tipRate; }
	public static float getTipRate(){ return mTipRate; }
	public static float getTotalTip(){ return mTip; }
	public static float getIndividualTip(){ return mTip/mNumGuests; }
	public static float getMinTipRate(){ return mMinTipRate; }
	public static void setMinTipRate(float minTipRate){ mMinTipRate = minTipRate; }
	public static float getMaxTipRate(){ return mMaxTipRate; }
	public static void setMaxTipRate(float maxTipRate){ mMaxTipRate = maxTipRate; }
	
}
