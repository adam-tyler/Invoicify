package com.el.ally.invoicify.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.Authentication;

import com.el.ally.invoicify.controllers.FlatFeeBillingRecordController;
import com.el.ally.invoicify.models.BillingRecord;
import com.el.ally.invoicify.models.Company;
import com.el.ally.invoicify.models.FlatFeeBillingRecord;
import com.el.ally.invoicify.models.User;
import com.el.ally.invoicify.repositories.BillingRecordRepository;
import com.el.ally.invoicify.repositories.CompanyRepository;

public class FlatFeeBillingRecordControllerTests {

	private FlatFeeBillingRecordController flatFeeBillingController;
	
	@Mock
	private BillingRecordRepository billingRecordRepo;
	
	@Mock
	private CompanyRepository companyRepo;
	
	@Mock
	private Authentication auth;
	
	@Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        flatFeeBillingController = new FlatFeeBillingRecordController(billingRecordRepo, companyRepo);
    }
	
	@Test
	public void create_givenFlatFeeBillingRecord_shouldSaveAndReturn() {
        FlatFeeBillingRecord flatFeeBillingRecord = new FlatFeeBillingRecord();
        Company client = new Company();
        client.setId(1);
        when(billingRecordRepo.save(flatFeeBillingRecord)).thenReturn(flatFeeBillingRecord);
        when(companyRepo.findOne(1)).thenReturn(client);
        when(auth.getPrincipal()).thenReturn(new User());
        
        FlatFeeBillingRecord actual = flatFeeBillingController.create(1, flatFeeBillingRecord, auth);
        
        assertThat(actual).isSameAs(flatFeeBillingRecord);
        verify(billingRecordRepo).save(flatFeeBillingRecord);
	}
	
}
