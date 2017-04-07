package com;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.common.entity.Account;
import com.common.entity.ContactMessage;
import com.common.entity.Message;
import com.core.email.ISendGridEmailService;

public class TestSendGridEmail extends BaseTest{

	@Autowired private ISendGridEmailService emailService;
	//private Message message;
	private Account account;
	private ContactMessage message;
	
	
	@Before
	public void init() {
		String senderName = "derek";
		String senderEmail = "dknguyen8806@gmail.com";
		String ccEmail = null;
		String subject = "Hello, this is test message";
		String body = "this is simple test of sendgrid email";
		String receiverName = "other derek";
		String receiverEmail = "dknguyen8806@gmail.com";
		//message = new Message(senderName, senderEmail, ccEmail, subject, body, receiverName, receiverEmail);
	
	}
	
	@Test
	public void testSend() {
		//System.out.println(emailService.send(message));
		System.out.println(emailService.sendGrid(account, message));
		
	}
	
}
