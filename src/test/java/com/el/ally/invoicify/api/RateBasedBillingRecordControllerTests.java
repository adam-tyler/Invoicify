package com.el.ally.invoicify.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.el.ally.invoicify.models.RateBasedBillingRecord;
import com.el.ally.invoicify.repositories.BillingRecordRepository;

public class RateBasedBillingRecordControllerTests {

	private RateBasedBillingRecordController rateBasedBillingControler;
	
	@Mock
	private BillingRecordRepository billingRecordRepo;
	
	@Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        rateBasedBillingControler = new RateBasedBillingRecordController(billingRecordRepo);
    }
	
	@Test
	public void create_givenRateBasedBillingRecord_shouldSaveAndReturn() {
        RateBasedBillingRecord rateBasedBillingRecord = new RateBasedBillingRecord();
        when(billingRecordRepo.save(rateBasedBillingRecord)).thenReturn(rateBasedBillingRecord);
        
        RateBasedBillingRecord actual = new RateBasedBillingRecord();
        
        assertThat(actual).isSameAs(rateBasedBillingRecord);
        verify(billingRecordRepo).save(rateBasedBillingRecord);
	}
}
