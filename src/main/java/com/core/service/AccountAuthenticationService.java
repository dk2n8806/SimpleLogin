package com.core.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.common.entity.Account;

public interface AccountAuthenticationService extends UserDetailsService {

	
	@Override Account loadUserByUsername(String username);
	
	
	Account register(Account account, String password);

}
