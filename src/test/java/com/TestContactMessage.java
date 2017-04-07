package com;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.common.entity.Account;
import com.common.entity.ContactMessage;
import com.core.service.AccountService;
import com.core.service.ContactMessageService;

public class TestContactMessage extends BaseTest{

	@Autowired private ContactMessageService contactMessageService;
	@Autowired private AccountService accountService;
	
	private ContactMessage contact;
	
	
	@Before
	public void init() {
		String name = "test name";
		Account account = accountService.getById(new Long(48));
		String email = "test@gmail.com";
		String message = "test message";
		contact = new ContactMessage(account, name, email, message);
	}
	
	
	@Test
	public void test() {
		ContactMessage message = contactMessageService.save(contact);
	}
}
