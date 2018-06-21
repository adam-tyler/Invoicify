package com.el.ally.invoicify.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="invoice")
public class Invoice {

  @Id
  @GeneratedValue(generator="people_id_seq", strategy=GenerationType.AUTO)
 
  private Long id;

  @ManyToOne
  private Invoice invoice;
  
  private String date;
 
  private String invoicedesription;

  
 @OneToMany(mappedBy="invoice", cascade=CascadeType.ALL)
 private InvoiceLineItem lineItems;


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public Invoice getInvoice() {
	return invoice;
}


public void setInvoice(Invoice invoice) {
	this.invoice = invoice;
}


public String getDate() {
	return date;
}


public void setDate(String date) {
	this.date = date;
}


public String getInvoicedesription() {
	return invoicedesription;
}


public void setInvoicedesription(String invoicedesription) {
	this.invoicedesription = invoicedesription;
}


public InvoiceLineItem getLineItems() {
	return lineItems;
}


public void setLineItems(InvoiceLineItem lineItems) {
	this.lineItems = lineItems;
}



}