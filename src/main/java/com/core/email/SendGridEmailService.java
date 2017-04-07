package com.core.email;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.entity.Account;
import com.common.entity.ContactMessage;
import com.common.entity.Message;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

@Service
public class SendGridEmailService implements ISendGridEmailService {

	
	@Autowired private SendGrid sendgrid;
	
//	@Override
//	public boolean sendGrid(Message message) {
//		Email from = new Email(message.getSenderEmail());
//	    String subject = message.getSubject();
//	    Email to = new Email(message.getReceiverEmail());
//	    Content content = new Content("text/plain", message.getBody());
//	    Mail mail = new Mail(from, subject, to, content);
//
//	    Request request = new Request();
//	    try {
//	      request.method = Method.POST;
//	      request.endpoint = "mail/send";
//	      request.body = mail.build();
//	      Response response = sendgrid.api(request);
//	      System.out.println(response.statusCode);
//	      System.out.println(response.body);
//	      System.out.println(response.headers);
//	      return true;
//	    } catch (IOException ex) {
//	    	ex.printStackTrace();
//	    }
//	    return false;
//	}

	@Override
	public boolean sendGrid(Account account, ContactMessage message) {
		Email from = new Email(account.getEmail());
	    String subject = message.getName();
	    Email to = new Email(message.getEmail());
	    Content content = new Content("text/plain", message.getMessage());
	    Mail mail = new Mail(from, subject, to, content);

	    Request request = new Request();
	    try {
	      request.method = Method.POST;
	      request.endpoint = "mail/send";
	      request.body = mail.build();
	      Response response = sendgrid.api(request);
	      System.out.println(response.statusCode);
	      System.out.println(response.body);
	      System.out.println(response.headers);
	      return true;
	    } catch (IOException ex) {
	    	ex.printStackTrace();
	    }
	    return false;
	}
	
	
	
}
