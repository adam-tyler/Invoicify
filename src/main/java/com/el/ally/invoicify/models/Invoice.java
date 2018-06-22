package com.el.ally.invoicify.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="invoice")
public class Invoice {

	@Id
	@GeneratedValue
	private int id;

	@JsonIgnore
	@ManyToOne
	private Company company;
  
	private Date createdOn;
	private String invoiceDescription;
	
	@OneToMany(mappedBy="invoice", cascade=CascadeType.ALL)
	private List<InvoiceLineItem> lineItems;
	
	@ManyToOne
	private User createdBy;

	public Invoice() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getInvoiceDescription() {
		return invoiceDescription;
	}

	public void setInvoiceDescription(String invoiceDesription) {
		this.invoiceDescription = invoiceDesription;
	}

	public List<InvoiceLineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<InvoiceLineItem> lineItems) {
		this.lineItems = lineItems;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

}