package com.core.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.entity.Account;
import com.common.entity.ContactMessage;
import com.common.entity.MessageStatus;
import com.core.dao.ContactMessageDao;

@Service
@Transactional
public class ContactMessageServiceImpl	implements ContactMessageService
{
	@Autowired private ContactMessageDao messageDao;

	
	
	@Override
	public ContactMessage save(ContactMessage message) {
		if(message != null) 
			messageDao.persist(message);
		return message;
	}

	
	
	@Override
	public List<ContactMessage> getByAccount(Account account, MessageStatus status, Pageable pageable) {
		return messageDao.getMessages(account, status, pageable);
	}

	
	
	@Override
	public void readMessage(ContactMessage message) {
		if(message.getStatus().equals(MessageStatus.NEW))
			messageDao.updateStatus(Arrays.asList(message), MessageStatus.OPENED);
	}
	
}
