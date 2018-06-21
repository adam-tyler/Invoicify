package com.el.ally.invoicify.models;

public class InvoiceView {

	private String invoiceDescription;
	private Integer[] recordIds;
	public String getInvoiceDescription() {
		return invoiceDescription;
	}
	public void setInvoiceDescription(String invoiceDescription) {
		this.invoiceDescription = invoiceDescription;
	}
	public Integer[] getRecordIds() {
		return recordIds;
	}
	public void setRecordIds(Integer[] recordIds) {
		this.recordIds = recordIds;
	}
	
	
}
