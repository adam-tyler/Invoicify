package com.el.ally.invoicify.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name = "InvoiceLineItem")
public class InvoiceLineItem{

	@Id
	@GeneratedValue
	private int id;
	
	@JsonIgnore
	@OneToOne
	private BillingRecord billingRecord;
	
	private Date createdOn;
	
	@JsonIgnore
	@ManyToOne
	private Invoice invoice;
	
	@ManyToOne
	private User createdBy;
	
	public InvoiceLineItem() {}
	
	public InvoiceLineItem(int id, BillingRecord billingRecord, Date createdOn, Invoice invoice) {
		super();
		this.id = id;
		this.billingRecord = billingRecord;
		this.createdOn = createdOn;
		this.invoice = invoice;
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

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
}
	
