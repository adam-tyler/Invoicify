package com.el.ally.invoicify.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flatfeebillingrecord")
public class FlatFeeBillingRecord extends BillingRecord {

  @Id
  @GeneratedValue(generator="people_id_seq", strategy=GenerationType.AUTO)
 
  private double amount;

  public double getTotal() {
	  return amount;
  }

public double getAmount() {
	return amount;
}

public void setAmount(Double amount) {
	this.amount = amount;
}

}
