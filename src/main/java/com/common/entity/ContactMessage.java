package com.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.validator.EmailValidator;

@Entity
@Table(name="CONTACT_MESSAGE")
public class ContactMessage extends AbstractPersistenceObject{

	private static final long serialVersionUID = 1L;
	private Account account;
	private String name;
	private String email;
	private String message;
	private MessageStatus status;
	
	
	public ContactMessage() {
		super();
	}

	public ContactMessage(Account account, String name, String email, String message) {
		super();
		if(account == null)
			throw new IllegalArgumentException("account is invalid");
		if(name == null || name.length() == 0)
			throw new IllegalArgumentException("name is invalid");
		if(email == null || email.length() == 0 || EmailValidator.getInstance().isValid(email))
			throw new IllegalArgumentException("email is invalid");
		if(message == null || message.length() == 0) 
			throw new IllegalArgumentException("contact message is invalid");
		this.name = name;
		this.email = email;
		this.message = message;
		this.status = MessageStatus.NEW;
	}
	
	
	@ManyToOne
	@JoinColumn(name="ACCOUNT_ID", nullable=false, updatable=false)
	public Account getAccount() {return account;}
	public void setAccount(Account account) {	this.account = account;}
	
	@Column(name="NAME", nullable=false, updatable=false)
	public String getName() {	return name;}
	public void setName(String name) {		this.name = name;}
	

	@Column(name="EMAIL", nullable=false, updatable=false)
	public String getEmail() {return email;}
	public void setEmail(String email) {		this.email = email;}
	

	@Column(name="MESSAGE", nullable=false, updatable=false)
	public String getMessage() {		return message;}
	public void setMessage(String message) {	this.message = message;}
	

	@Column(name="STATUS", nullable=false)
	public MessageStatus getStatus() {		return status;}
	public void setStatus(MessageStatus status) {		this.status = status;
	}
	
	
	
	
}
