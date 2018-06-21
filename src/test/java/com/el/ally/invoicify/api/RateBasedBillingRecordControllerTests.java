package com.el.ally.invoicify.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.el.ally.invoicify.controllers.RateBasedBillingRecordController;
import com.el.ally.invoicify.models.RateBasedBillingRecord;
import com.el.ally.invoicify.repositories.BillingRecordRepository;

public class RateBasedBillingRecordControllerTests {

	private RateBasedBillingRecordController rateBasedBillingController;
	
	@Mock
	private BillingRecordRepository billingRecordRepo;
	
	@Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        rateBasedBillingController = new RateBasedBillingRecordController(billingRecordRepo);
    }
	
	@Test
	public void create_givenRateBasedBillingRecord_shouldSaveAndReturn() {
        RateBasedBillingRecord rateBasedBillingRecord = new RateBasedBillingRecord();
        when(billingRecordRepo.save(rateBasedBillingRecord)).thenReturn(rateBasedBillingRecord);
        
        RateBasedBillingRecord actual = rateBasedBillingController.create(rateBasedBillingRecord);
        
        assertThat(actual).isSameAs(rateBasedBillingRecord);
        verify(billingRecordRepo).save(rateBasedBillingRecord);
	}
}
