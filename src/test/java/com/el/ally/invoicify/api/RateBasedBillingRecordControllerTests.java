package com.el.ally.invoicify.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.Authentication;

import com.el.ally.invoicify.controllers.RateBasedBillingRecordController;
import com.el.ally.invoicify.models.Company;
import com.el.ally.invoicify.models.RateBasedBillingRecord;
import com.el.ally.invoicify.models.User;
import com.el.ally.invoicify.repositories.BillingRecordRepository;
import com.el.ally.invoicify.repositories.CompanyRepository;

public class RateBasedBillingRecordControllerTests {

	private RateBasedBillingRecordController rateBasedBillingController;
	
	@Mock
	private BillingRecordRepository billingRecordRepo;
	
	@Mock
	private CompanyRepository companyRepo;
	
	@Mock
	private Authentication auth;
	
	@Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        rateBasedBillingController = new RateBasedBillingRecordController(billingRecordRepo, companyRepo);
    }
	
	@Test
	public void create_givenRateBasedBillingRecord_shouldSaveAndReturn() {
        RateBasedBillingRecord rateBasedBillingRecord = new RateBasedBillingRecord();
        Company client = new Company();
        client.setId(1);
        when(billingRecordRepo.save(rateBasedBillingRecord)).thenReturn(rateBasedBillingRecord);
        when(companyRepo.findOne(1)).thenReturn(client);
        when(auth.getPrincipal()).thenReturn(new User());
        
        RateBasedBillingRecord actual = rateBasedBillingController.create(1,rateBasedBillingRecord, auth);
        
        assertThat(actual).isSameAs(rateBasedBillingRecord);
        verify(billingRecordRepo).save(rateBasedBillingRecord);
	}
}
