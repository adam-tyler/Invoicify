package com.el.ally.invoicify.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.el.ally.invoicify.models.FlatFeeBillingRecord;

public class FlatFeeBillingRecordControllerTests {

	private FlatFeeBillingRecordController flatFeeBillingController;
	
	@Mock
	private BillingRecordRepository billingRecordRepo;
	
	@Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        flatFeeBillingController = new FlatFeeBillingRecordController(billingRecordRepo);
    }
	
	@Test
	public void create_givenFlatFeeBillingRecord_shouldSaveAndReturn() {
        FlatFeeBillingRecord flatFeeBillingRecord = new FlatFeeBillingRecord();
        when(billingRecordRepo.save(flatFeeBillingRecord)).thenReturn(flatFeeBillingRecord);
        
        FlatFeeBillingRecord actual = new FlatFeeBillingRecord();
        
        assertThat(actual).isSameAs(flatFeeBillingRecord);
        verify(billingRecordRepo).save(flatFeeBillingRecord);
	}
	
}
