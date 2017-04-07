package com.core.email;

import com.common.entity.Account;
import com.common.entity.ContactMessage;
import com.common.entity.Message;

public interface ISendGridEmailService {

	//boolean sendGrid(Message message);
	boolean sendGrid(Account account, ContactMessage message);
}
