package com.el.ally.invoicify.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="billingrecord")
public abstract class BillingRecord {

  @Id
  @GeneratedValue(generator="people_id_seq", strategy=GenerationType.AUTO)
  
  private int id;

  private Date createdOn;

 
  private String descripton;

  @OneToOne(mappedBy="billingRecord")
  private InvoiceLineItem invoiceLineItem;

  @ManyToOne 
  private Company company;
  
  public abstract double getTotal();

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Date getCreatedOn() {
	return createdOn;
}

public void setCreatedOn(Date createdOn) {
	this.createdOn = createdOn;
}

public String getDescripton() {
	return descripton;
}

public void setDescripton(String descripton) {
	this.descripton = descripton;
}

public InvoiceLineItem getInvoiceLineItem() {
	return invoiceLineItem;
}

public void setInvoiceLineItem(InvoiceLineItem invoiceLineItem) {
	this.invoiceLineItem = invoiceLineItem;
}

public Company getCompany() {
	return company;
}

public void setCompany(Company company) {
	this.company = company;
}

  
  
}

