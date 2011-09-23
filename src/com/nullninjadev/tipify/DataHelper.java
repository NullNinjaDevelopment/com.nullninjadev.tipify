package com.nullninjadev.tipify;

import java.util.Vector;

import android.content.Context;

public class DataHelper {
	private static Vector<Person> people;
	private static float mTip = 0;
	private static float mTipRate = 0.20f;
	private static float mMinTipRate = 0f;
	private static float mMaxTipRate = 1f;
	private static int mNumGuests = 1; // total number of guests, initially 1
	private static float mBillTotal = 0; // bill total dollar amount, initially 0
	private static float mDeductions = 0;
	private static float mTax = 0;
	
	public static void initVars(){
		people = new Vector<Person>();
		setNumGuests(1);
	}
	
	public static Vector<Person> getPeople(){
		if(people == null){
			people = new Vector<Person>();
			setNumGuests(1);
		}
		return people;
	}
	
	public static void calculateTotalTip(){
		mTip = (mBillTotal - (ComponentInclusion.isDeductionIncluded() ? 0 : mDeductions)
				- (ComponentInclusion.isTaxIncluded() ? 0 : mTax)) * mTipRate;
		// WHY THE SHIT ARE YOU DOING THIS?
	}
	
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
