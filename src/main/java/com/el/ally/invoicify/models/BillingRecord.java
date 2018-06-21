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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="billingrecord")
public abstract class BillingRecord {

	@Id
	@GeneratedValue
	private int id;

	private Date createdOn;
	private String description;

	@OneToOne(mappedBy="billingRecord")
	private InvoiceLineItem invoiceLineItem;

	@ManyToOne 
	private Company client;
  
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String descripton) {
		this.description = descripton;
	}

	public InvoiceLineItem getInvoiceLineItem() {
		return invoiceLineItem;
	}

	public void setInvoiceLineItem(InvoiceLineItem invoiceLineItem) {
		this.invoiceLineItem = invoiceLineItem;
	}

	public Company getCompany() {
		return client;
	}

	public void setCompany(Company company) {
		this.client = company;
	}
  
}

