package com.el.ally.invoicify.api;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.el.ally.invoicify.models.BillingRecord;

import static org.assertj.core.api.Assertions.assertThat;

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
		
		ArrayList<BillingRecord> actual = billingController.list();
		
		assertThat(actual.size()).isEqualTo(billingRecords.size());
		verify(billingRecordRepo).findAll();
	}
	
	@Test
	public void list_givenBillingRecords_shouldReturnListOfAllRecords() {
		ArrayList<BillingRecord> billingRecords = new ArrayList<BillingRecord>();
		billingRecords.add(new FlatFeeBillingRecord());
		billingRecords.add(new RateBasedBillingRecord());
		when(billingRecordRepo.findAll()).thenReturn(billingRecords);
		
		ArrayList<BillingRecord> actual = billingController.list();
		
		assertThat(actual.size()).isEqualTo(billingRecords.size());
		verify(billingRecordRepo).findAll();
	}
}
