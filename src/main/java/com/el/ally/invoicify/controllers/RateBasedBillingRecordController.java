package com.el.ally.invoicify.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.el.ally.invoicify.models.Company;
import com.el.ally.invoicify.models.FlatFeeBillingRecord;
import com.el.ally.invoicify.models.RateBasedBillingRecord;
import com.el.ally.invoicify.models.User;
import com.el.ally.invoicify.repositories.BillingRecordRepository;
import com.el.ally.invoicify.repositories.CompanyRepository;

@RestController
@RequestMapping("/api/billing-record/rate-based")
public class RateBasedBillingRecordController {

	@Autowired
	private BillingRecordRepository billingRecordRepo;
	
	@Autowired
	private CompanyRepository companyRepo;
	
	public RateBasedBillingRecordController(BillingRecordRepository billingRecordRepo, CompanyRepository companyRepo) {
		this.billingRecordRepo = billingRecordRepo;
		this.companyRepo = companyRepo;
	}
	
	@PostMapping("/{clientId}")
	public RateBasedBillingRecord create(@PathVariable int clientId, @RequestBody RateBasedBillingRecord rateBasedBillingRecord, Authentication auth) {
		User user = (User) auth.getPrincipal();
		Company client = companyRepo.findOne(clientId);
		rateBasedBillingRecord.setCompany(client);
		rateBasedBillingRecord.setCreatedBy(user);
		return billingRecordRepo.save(rateBasedBillingRecord);
	}
}
