package com.nullninjadev.tipify;


/**
 * 
 * @author Alan Heuertz
 *
 * The ComponentInclusion class (object) records whether or not to include
 * the bill deductions or tax in the tip calculations. By default, tax is
 * not included and deductions are included.
 */
public class ComponentInclusion {
	private static boolean mDeductionIncluded = true;
	private static boolean mTaxIncluded = false;
	
	/**
	 * Returns whether or not the tax should be included in tip calculations.
	 * @return whether or not the tax should be included in tip calculations
	 */
	public static boolean isTaxIncluded(){
		return mTaxIncluded;
	}
	
	/**
	 * Returns whether or not the deductions should be included in tip calculations.
	 * @return whether or not the deductions should be included in tip calculations
	 */
	public static boolean isDeductionIncluded(){
		return mDeductionIncluded;
	}
	
	public static void setTaxInclusion(boolean taxIncluded){
		mTaxIncluded = taxIncluded;
	}
	public static void setDeductionInclusion(boolean deductionIncluded){
		mDeductionIncluded = deductionIncluded;
	}
}
