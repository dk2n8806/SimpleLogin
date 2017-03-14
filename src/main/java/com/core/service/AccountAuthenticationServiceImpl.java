package com.core.service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.common.entity.Account;
import com.common.exception.AccountNotFoundException;
import com.common.type.Role;
import com.common.util.AccountUtil;

@Service
public class AccountAuthenticationServiceImpl implements AccountAuthenticationService
{

	@Autowired private AccountService accountService;
	
	private static final SecureRandom RANDOM;
	  private static final int HASHING_ROUNDS = 10;
	
	

	static {
	        try        {
	        	RANDOM = SecureRandom.getInstance("SHA1PRNG");
	        } catch(NoSuchAlgorithmException e){
	            throw new IllegalStateException(e);
	        }
	    }
	  
	

	@Override
	public Account register(Account account, String password) {
		try {
			if(!AccountUtil.validatePwd(password)) {
				throw new IllegalArgumentException("Invalid account password format");
			}
			
			String salt = BCrypt.gensalt(HASHING_ROUNDS, RANDOM);
			account = Account.create(account.getUsername(), account.getEmail(), BCrypt.hashpw(password, salt).getBytes());
			
			if(account == null) {
				throw new IllegalArgumentException("Unable to create an account");
			}
			accountService.save(account);
			Set<GrantedAuthority> authorities = 
											getGrantedAuthorities(getPrincipalRoles(account.getRole()));
			Authentication auth = new UsernamePasswordAuthenticationToken(
																						account, password, authorities);
			SecurityContextHolder.getContext().setAuthentication(auth);
			return account;
		} catch(IllegalArgumentException e) {
			return null;
		}
	}
	  
	  
	
	@Override
	public Account loadUserByUsername(String username) {
		Account account = accountService.getByEmail(username);
		if(account == null)  {
			throw new AccountNotFoundException();
		} 
		account.setAuthorities(getGrantedAuthorities(getPrincipalRoles(account.getRole())));
		return account;
	}
	
	

	private List<String> getPrincipalRoles(Role role) 
	{
		List<String> roles = new ArrayList<String>();
		if(role == Role.ADMIN || role == Role.CUSTOMER || role == Role.MERCHANT) {
			roles.add("ROLE_USER");
				
		}
		return roles;
	}

	
	private static Set<GrantedAuthority> getGrantedAuthorities(List<String> roles) 
	{
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }


	
	
	


	

}
