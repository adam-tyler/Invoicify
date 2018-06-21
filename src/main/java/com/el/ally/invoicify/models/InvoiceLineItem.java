package com.el.ally.invoicify.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "InvoiceLineItem")

public class InvoiceLineItem{

	@Id
	@GeneratedValue
	private int id;
	
	@OneToOne
	private BillingRecord billingRecord;
	
	private Date createdOn;
	
	@ManyToOne
	private Invoice invoice;
	
	public InvoiceLineItem(int id, BillingRecord billingRecord, Date createdOn, Invoice invoice) {
		super();
		this.id = id;
		this.billingRecord = billingRecord;
		this.createdOn = createdOn;
		this.invoice = invoice;
	}
	public InvoiceLineItem() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BillingRecord getBillingRecord() {
		return billingRecord;
	}

	public void setBillingRecord(BillingRecord billingRecord) {
		this.billingRecord = billingRecord;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
}
	
