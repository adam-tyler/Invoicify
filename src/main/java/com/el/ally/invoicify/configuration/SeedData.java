package com.el.ally.invoicify.configuration;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.el.ally.invoicify.models.Company;
import com.el.ally.invoicify.models.FlatFeeBillingRecord;
import com.el.ally.invoicify.models.Invoice;
import com.el.ally.invoicify.models.InvoiceLineItem;
import com.el.ally.invoicify.models.RateBasedBillingRecord;
import com.el.ally.invoicify.repositories.BillingRecordRepository;
import com.el.ally.invoicify.repositories.CompanyRepository;
import com.el.ally.invoicify.repositories.InvoiceLineItemRepository;
import com.el.ally.invoicify.repositories.InvoiceRepository;

@Configuration
@Profile("development")
public class SeedData {
	
	public SeedData(BillingRecordRepository billingRecordRepo,
			CompanyRepository companyRepo,
			InvoiceLineItemRepository invoiceLineItemRepo,
			InvoiceRepository invoiceRepo) {
		
		Company company = new Company();
		company.setName("Ally Bank");
		companyRepo.save(company);
		
		InvoiceLineItem lineItem1 = new InvoiceLineItem();
		lineItem1.setCreatedOn(new Date());

		FlatFeeBillingRecord flatFeeBillingRecord = new FlatFeeBillingRecord();
		flatFeeBillingRecord.setAmount(100.0);
		flatFeeBillingRecord.setCompany(company);
		flatFeeBillingRecord.setCreatedOn(new Date());
		flatFeeBillingRecord.setDescripton("Flat Fee Item");
		billingRecordRepo.save(flatFeeBillingRecord);
		lineItem1.setBillingRecord(flatFeeBillingRecord);
		invoiceLineItemRepo.save(lineItem1);
		
		InvoiceLineItem lineItem2 = new InvoiceLineItem();
		lineItem2.setCreatedOn(new Date());
		
		RateBasedBillingRecord rateBasedBillingRecord = new RateBasedBillingRecord();
		rateBasedBillingRecord.setCompany(company);
		rateBasedBillingRecord.setCreatedOn(new Date());
		rateBasedBillingRecord.setDescripton("Rate Based Item");
		rateBasedBillingRecord.setQuantity(2);
		rateBasedBillingRecord.setRate(5);
		lineItem2.setBillingRecord(rateBasedBillingRecord);
		billingRecordRepo.save(rateBasedBillingRecord);
		invoiceLineItemRepo.save(lineItem2);
		
		ArrayList<InvoiceLineItem> lineItems = new ArrayList<InvoiceLineItem>();
		lineItems.add(lineItem1);
		lineItems.add(lineItem2);
		
		Invoice invoice = new Invoice();
		invoice.setCompany(company);
		invoice.setCreatedOn(new Date());
		invoice.setinvoiceDescription("An invoice for Ally");
		invoiceRepo.save(invoice);
		
		lineItem1.setInvoice(invoice);
		lineItem2.setInvoice(invoice);
		invoiceLineItemRepo.save(lineItem1);
		invoiceLineItemRepo.save(lineItem2);
	}
}
