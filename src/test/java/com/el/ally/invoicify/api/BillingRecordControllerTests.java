package com.el.ally.invoicify.api;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.el.ally.invoicify.controllers.BillingRecordController;
import com.el.ally.invoicify.models.BillingRecord;
import com.el.ally.invoicify.models.FlatFeeBillingRecord;
import com.el.ally.invoicify.models.RateBasedBillingRecord;
import com.el.ally.invoicify.repositories.BillingRecordRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BillingRecordControllerTests {

	private BillingRecordController billingController;
	
	@Mock
	private BillingRecordRepository billingRecordRepo;
	
	@Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        billingController = new BillingRecordController(billingRecordRepo);
    }
	
	@Test
	public void list_givenNoBillingRecords_shouldReturnEmptyList() {
		ArrayList<BillingRecord> billingRecords = new ArrayList<BillingRecord>();
		when(billingRecordRepo.findAll()).thenReturn(billingRecords);
		
		List<BillingRecord> actual = billingController.list();
		
		assertThat(actual.size()).isEqualTo(billingRecords.size());
		verify(billingRecordRepo).findAll();
	}
	
	@Test
	public void list_givenBillingRecords_shouldReturnListOfAllRecords() {
		ArrayList<BillingRecord> billingRecords = new ArrayList<BillingRecord>();
		billingRecords.add(new FlatFeeBillingRecord());
		billingRecords.add(new RateBasedBillingRecord());
		when(billingRecordRepo.findAll()).thenReturn(billingRecords);
		
		List<BillingRecord> actual = billingController.list();
		
		assertThat(actual.size()).isEqualTo(billingRecords.size());
		verify(billingRecordRepo).findAll();
	}
}
