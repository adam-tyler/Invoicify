package com.el.ally.invoicify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.el.ally.invoicify.models.Invoice;
import com.el.ally.invoicify.repositories.InvoiceRepository;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

	@Autowired
	private InvoiceRepository invoiceRepo;
	
	public InvoiceController(InvoiceRepository invoiceRepo) {
		this.invoiceRepo = invoiceRepo;
	}
	
	@GetMapping
	public List<Invoice> list() {
		return invoiceRepo.findAll();
	}
}
