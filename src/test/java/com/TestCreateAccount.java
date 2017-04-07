package com;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.common.entity.Account;
import com.core.service.AccountAuthenticationService;
import com.core.service.AccountService;

public class TestCreateAccount extends BaseTest{

	@Autowired private AccountService accountService;
	@Autowired private AccountAuthenticationService authenService;
	
	@Test
	public void test() {
		Account object = new Account();
		object.setUsername("simpleUsername1");
		object.setEmail("simpleEmail1@gmail.com");
		String password  = "password";
		
		Account account = authenService.register(object, password);
	}
}
