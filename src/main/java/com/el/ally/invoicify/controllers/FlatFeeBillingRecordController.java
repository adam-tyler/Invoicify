package com.el.ally.invoicify.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.el.ally.invoicify.models.FlatFeeBillingRecord;
import com.el.ally.invoicify.repositories.BillingRecordRepository;

@RestController
@RequestMapping("/api/billingRecords/flatFee")
public class FlatFeeBillingRecordController {

	@Autowired
	private BillingRecordRepository billingRecordRepo;
	
	public FlatFeeBillingRecordController(BillingRecordRepository billingRecordRepo) {
		this.billingRecordRepo = billingRecordRepo;
	}
	
	@PostMapping("/create")
	public FlatFeeBillingRecord create(@RequestBody FlatFeeBillingRecord flatFeeBillingRecord) {
		return billingRecordRepo.save(flatFeeBillingRecord);
	}
}
