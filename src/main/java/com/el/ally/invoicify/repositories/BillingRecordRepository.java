package com.el.ally.invoicify.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.el.ally.invoicify.models.BillingRecord;

public interface BillingRecordRepository extends JpaRepository<BillingRecord, Long> {

	List<BillingRecord> findByIdIn(Integer[] recordIds);

}