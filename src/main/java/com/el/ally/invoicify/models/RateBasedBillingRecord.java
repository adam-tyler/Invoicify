package com.el.ally.invoicify.models;

import javax.persistence.Entity;

@Entity
public class RateBasedBillingRecord extends BillingRecord {
	
	private int rate;
	private int quantity;
	
	public RateBasedBillingRecord() {}
	
	public double getTotal (){
		return rate * quantity;
		
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}

	