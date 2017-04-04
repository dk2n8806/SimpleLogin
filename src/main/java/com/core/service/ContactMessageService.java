package com.core.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.common.entity.Account;
import com.common.entity.ContactMessage;
import com.common.entity.MessageStatus;

public interface ContactMessageService {

	ContactMessage save(ContactMessage message);
	
	List<ContactMessage> getByAccount(Account account, MessageStatus status, Pageable pageable);
	
	void readMessage(ContactMessage message);
}
