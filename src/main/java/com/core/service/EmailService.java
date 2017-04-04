package com.core.service;

import com.common.entity.EmailMessage;

public interface EmailService {

	void sendMessage(EmailMessage message);
}
