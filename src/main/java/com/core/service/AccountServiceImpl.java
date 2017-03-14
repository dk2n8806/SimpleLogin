package com.core.service;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.entity.Account;
import com.common.type.Role;
import com.core.dao.AccountDao;

@Service
@Transactional
public class AccountServiceImpl implements AccountService
{

	@Autowired private AccountDao accountDao;
	
	@Override
	public Account save(Account account) {
		try {
			if(account != null) 
				accountDao.persist(account);
			return account;
		} catch(DataIntegrityViolationException e) {
			return null;
		}
	}

	
	
	@Override
	public Account getById(Long id) {
		return accountDao.findById(id);
	}

	
	
	@Override
	public Account getByEmail(String email) {
		try {
			return accountDao.findByEmail(email);
		} catch(NoResultException e) {
			return null;
		}
	}

	
	@Override
	public List<Account> getAccounts(Role role, Pageable pageable) {
		return accountDao.getAccounts(role, pageable);
	}

}
