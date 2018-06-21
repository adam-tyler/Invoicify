package com.el.ally.invoicify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.el.ally.invoicify.models.BillingRecord;
import com.el.ally.invoicify.repositories.BillingRecordRepository;

@RestController
@RequestMapping("/api/billing-record")
public class BillingRecordController {

	@Autowired
	private BillingRecordRepository billingRecordRepo;
	
	public BillingRecordController(BillingRecordRepository billingRecordRepo) {
		this.billingRecordRepo = billingRecordRepo;
	}
	
	@GetMapping("")
	public List<BillingRecord> list() {
		return billingRecordRepo.findAll();
	}
}
