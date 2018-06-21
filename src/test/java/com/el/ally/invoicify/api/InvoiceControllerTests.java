package com.el.ally.invoicify.api;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

public class InvoiceControllerTests {

	private InvoiceController invoiceController;
	
	@Mock
	private InvoiceRepository invoiceRepo;
	
	@Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        InvoiceController = new InvoiceController(invoiceRepo);
    }
	
	@Test
	public void list_givenNoInvoices_shouldReturnEmptyList() {
		ArrayList<Invoice> invoices = new ArrayList<Invoice>();
		when(invoiceRepo.findAll()).thenReturn(invoices);
		
		ArrayList<Invoice> actual = invoiceController.list();
		
		assertThat(actual.size()).isEqualTo(invoices.size());
		verify(invoiceRepo).findAll();
	}
	
	@Test
	public void list_givenInvoices_shouldReturnListOfInvoices() {
		ArrayList<Invoice> invoices = new ArrayList<Invoice>();
		invoices.add(new Invoice());
		
		when(invoiceRepo.findAll()).thenReturn(invoices);
		
		ArrayList<Invoice> actual = invoiceController.list();
		
		assertThat(actual.size()).isEqualTo(invoices.size());
		verify(invoiceRepo).findAll();
	}
}
