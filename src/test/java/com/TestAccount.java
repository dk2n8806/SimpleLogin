package com;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import com.common.entity.Account;
import com.common.type.Role;
import com.core.service.AccountService;

public class TestAccount extends BaseTest{

	@Autowired private AccountService accountService;
	
	@Test
	public void testGetList() {
		List<Account> accounts = accountService.getAccounts(Role.CUSTOMER, new PageRequest(0, 10));
		assertEquals(4, accounts.size());
	}
	
	@Test
	public void testValidEmail() {
		Account account = accountService.getByEmail("derek@gmail.com");
		assertNotNull(account);
	}
	
	@Test
	public void testInvalidEmail() {
		Account account = accountService.getByEmail("derek112@gmail.com");
		assertNull(account);
		
	}
	
}
