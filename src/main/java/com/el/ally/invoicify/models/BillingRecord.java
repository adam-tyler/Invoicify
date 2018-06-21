package com.el.ally.invoicify.models;

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
  
  private Long id;

  private String date;

 
  private String descripton;

  @OneToOne(mappedBy="billingRecord")
   private List<BillingRecord> billingRecords;

  @ManyToOne 
  private Company company;
  
  public abstract double getTotal();

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}

public String getDescripton() {
	return descripton;
}

public void setDescripton(String descripton) {
	this.descripton = descripton;
}

public List<BillingRecord> getBillingRecords() {
	return billingRecords;
}

public void setBillingRecords(List<BillingRecord> billingRecords) {
	this.billingRecords = billingRecords;
}

public Company getCompany() {
	return company;
}

public void setCompany(Company company) {
	this.company = company;
}
  
  
  
  
}

