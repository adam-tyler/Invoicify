package com.el.ally.invoicify.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.el.ally.invoicify.models.Company;
import com.el.ally.invoicify.models.FlatFeeBillingRecord;
import com.el.ally.invoicify.repositories.BillingRecordRepository;
import com.el.ally.invoicify.repositories.CompanyRepository;

@RestController
@RequestMapping("/api/billing-record/flat-fee")
public class FlatFeeBillingRecordController {

	@Autowired
	private BillingRecordRepository billingRecordRepo;
	
	@Autowired
	private CompanyRepository companyRepo;
	
	public FlatFeeBillingRecordController(BillingRecordRepository billingRecordRepo) {
		this.billingRecordRepo = billingRecordRepo;
	}
	
	@PostMapping("{clientId}")
	public FlatFeeBillingRecord create(@PathVariable int clientId, @RequestBody FlatFeeBillingRecord flatFeeBillingRecord) {
		Company company = companyRepo.findOne(clientId);
		flatFeeBillingRecord.setCompany(company);
		return billingRecordRepo.save(flatFeeBillingRecord);
	}
}
