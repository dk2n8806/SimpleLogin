package com.core.dao;


import java.util.List;

import org.springframework.data.domain.Pageable;

import com.common.entity.Account;
import com.common.type.Role;

public interface AccountDao extends GenericRepository<Account, Long>
{

	/** @return an account by a given email */
	Account findByEmail(final String email);
	
	
	/** @return a list of accounts */
	List<Account> getAccounts(Role role, Pageable pageable);

}
