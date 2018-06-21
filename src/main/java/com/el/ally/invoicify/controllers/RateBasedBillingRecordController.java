package com.el.ally.invoicify.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.el.ally.invoicify.models.FlatFeeBillingRecord;
import com.el.ally.invoicify.models.RateBasedBillingRecord;
import com.el.ally.invoicify.repositories.BillingRecordRepository;

@RestController
@RequestMapping("/api/billingRecords/rateBase")
public class RateBasedBillingRecordController {

	@Autowired
	private BillingRecordRepository billingRecordRepo;
	
	public RateBasedBillingRecordController(BillingRecordRepository billingRecordRepo) {
		this.billingRecordRepo = billingRecordRepo;
	}
	
	@PostMapping("/create")
	public RateBasedBillingRecord create(@RequestBody RateBasedBillingRecord rateBasedBillingRecord) {
		return billingRecordRepo.save(rateBasedBillingRecord);
	}
}
