package com.core.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.common.entity.Account;
import com.common.entity.ContactMessage;
import com.common.entity.MessageStatus;

public interface ContactMessageDao extends GenericRepository<ContactMessage, Long>{

	List<ContactMessage> getMessages(Account account, MessageStatus status, Pageable pageable);
	
	void updateStatus(List<ContactMessage> messages, MessageStatus updateStatus);
}
