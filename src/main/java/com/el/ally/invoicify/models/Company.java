package com.el.ally.invoicify.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class Company {

  @Id
  @GeneratedValue(generator="people_id_seq", strategy=GenerationType.AUTO)
  private int id;

  private String name;

  @OneToMany(mappedBy="company")
  private List<Invoice> invoices;

  public Company() {}
  
  public int getId() {
	return id;
  }

  public void setId(int id) {
	this.id = id;
  }

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public List<Invoice> getInvoices() {
	return invoices;
}

public void setInvoices(List<Invoice> invoices) {
	this.invoices = invoices;
}
 

}
