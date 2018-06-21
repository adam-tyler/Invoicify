package com.el.ally.invoicify.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.el.ally.invoicify.models.Invoice;

public interface InvoiceRepository extends JpaRepository <Invoice, Integer>{

}
