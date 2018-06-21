package com.el.ally.invoicify.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.el.ally.invoicify.models.InvoiceLineItem;

public interface InvoiceLineItemRepository extends JpaRepository <InvoiceLineItem, Integer>{

}
