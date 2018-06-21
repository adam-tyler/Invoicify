package com.el.ally.invoicify.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.el.ally.invoicify.models.BillingRecord;
import com.el.ally.invoicify.models.Invoice;
import com.el.ally.invoicify.models.InvoiceLineItem;
import com.el.ally.invoicify.repositories.BillingRecordRepository;
import com.el.ally.invoicify.repositories.CompanyRepository;
import com.el.ally.invoicify.repositories.InvoiceRepository;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

	@Autowired
	private InvoiceRepository invoiceRepo;
	
	@Autowired
	private CompanyRepository companyRepo;
	
	
	public InvoiceController(InvoiceRepository invoiceRepo) {
		this.invoiceRepo = invoiceRepo;
	}
	
	@GetMapping
	public List<Invoice> list() {
		return invoiceRepo.findAll();
	}
	
	@PostMapping("{clientId}")
	
	public Invoice createInvoice(@RequestBody Invoice invoice, @PathVariable int id) {
		List<BillingRecord> records = BillingRecordRepository.findByIdIn(invoice.getRecordIds());
		long nowish = Calendar.getInstance().getTimeInMillis();
		Date now = new Date(nowish);
		Invoice invoice = new Invoice();
		invoice.setInvoiceDescription(invoice.getInvoiceDescription());
		
		List<InvoiceLineItem> items = new ArrayList<InvoiceLineItem>();
		for (BillingRecord record : records) {
			InvoiceLineItem lineItem = new InvoiceLineItem();
			lineItem.setBillingRecord(record);
			lineItem.setCreatedOn(now);
			lineItem.setInvoice(invoice);
			items.add(lineItem);
		}
		invoice.setLineItems(items);
		invoice.setCreatedOn(now);
		invoice.setCompany(companyRepo.findOne(id));
		
		return invoiceRepo.save(invoice);
	}
}