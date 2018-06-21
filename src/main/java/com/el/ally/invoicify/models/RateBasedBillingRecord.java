package com.el.ally.invoicify.models;

public class RateBasedBillingRecord extends BillingRecord {
	
	private int rate;
	
	private int quantity;
	
	public RateBasedBillingRecord() {}
	
//Implement abstract method from parent for getTotal that returns the (rate * quantity)
public double getTotal (){
	return rate * quantity;
	
}

}

	