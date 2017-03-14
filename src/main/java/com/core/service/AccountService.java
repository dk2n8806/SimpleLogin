package com.core.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.common.entity.Account;
import com.common.type.Role;

public interface AccountService {

	/** Persist a new account entity */
	Account save(Account account);
	
	/** Lookup an account by a given account_id */
	Account getById(Long id);
	
	/** Lookup an account by a given account email */
	Account getByEmail(String email);
	
	/** Retrieve a list of accounts */
	List<Account> getAccounts(Role role, Pageable pageable);
}
