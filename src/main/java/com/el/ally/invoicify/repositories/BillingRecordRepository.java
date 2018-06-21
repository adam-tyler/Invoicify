package com.el.ally.invoicify.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.el.ally.invoicify.models.BillingRecord;

public interface BillingRecordRepository extends JpaRepository <BillingRecord, Integer> {

}
