package com.common.entity;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.common.type.Role;
import com.common.util.AccountUtil;


@Entity
@Table(name="ACCOUNT")
public class Account 
	extends AbstractPersistenceObject
implements UserDetails, CredentialsContainer, Cloneable {

	private static final long serialVersionUID = 5055780751875589105L;

	
	
	private String username;
	private String email;
	private byte[] hashedPassword;
	private Role role;
	private Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>(); 
	private boolean accountNonExpired = true;
	private boolean accountNonLocked = true;
	private boolean credentialsNonExpired = true;
	private boolean enabled = true;
	
	

	public static Account create(String username, String email, byte[] hashedPassword) 
	{
		try {
			if(!AccountUtil.validateUsername(username)) {
				throw new IllegalArgumentException("Invalid account username format");
			}
			if(!AccountUtil.validateEmail(email)) {
				throw new IllegalArgumentException("Invalid account email format");
			}
			if(hashedPassword == null || hashedPassword.length <= 0) {
				throw new IllegalArgumentException("Invalid password");
			}
			Account account = new Account();
			account.username 				= username;
			account.email 						= email.toLowerCase();					// Synchronize email format
			account.hashedPassword 	= hashedPassword;
			account.role 						= Role.CUSTOMER;
			return account;
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		}
	}

	
	
	@Column(name="EMAIL", nullable=false, unique=true)
	public String getEmail() {return email;	}
	public void setEmail(String email) {this.email = email;	}

	
	
	@Override
	@Column(name="USERNAME", nullable=false)
	public String getUsername() {		return this.username;	}
	public void setUsername(String username) {this.username = username;	}


	
	@Basic(fetch=FetchType.LAZY)
	@Column(name="PASSWORD", nullable=false)
	public byte[] getHashedPassword() {return hashedPassword;	}
	public void setHashedPassword(byte[] hashedPassword) {this.hashedPassword = hashedPassword;	}
	
	
	
	@Override	@Transient
	public String getPassword() {
		return this.getHashedPassword() == null 
						? null : new String(this.getHashedPassword(), StandardCharsets.UTF_8);
	}
	
	

	
	@Enumerated(EnumType.STRING)
	@Column(name="ROLE", nullable=false)
	public Role getRole() {return role;	}
	public void setRole(Role role) {this.role = role;	}
	
	
	
	@Override
	public void eraseCredentials() {		this.hashedPassword = null;}


	@Transient
	public Set<GrantedAuthority> getAuthorities() {		return this.authorities;	}
	public void setAuthorities(Set<GrantedAuthority> authorities) {this.authorities = authorities;	}
	
	
	
	@Type(type="yes_no")
	@Override
	@Column(name="IS_ACCOUNT_NON_EXPIRED")
	public boolean isAccountNonExpired() {		return this.accountNonExpired;	}
	public void setAccountNonExpired(boolean accountNonExpired) {this.accountNonExpired = accountNonExpired;	}
	

	@Type(type="yes_no")
	@Override
	@Column(name="IS_ACCOUNT_NON_LOCKED")
	public boolean isAccountNonLocked() { return this.accountNonLocked;	}
	public void setAccountNonLocked(boolean accountNonLocked) {this.accountNonLocked = accountNonLocked;	}
	
	
	
	
	@Type(type="yes_no")
	@Override
	@Column(name="IS_CREDENTIALS_NON_EXPIRED")
	public boolean isCredentialsNonExpired() { return this.credentialsNonExpired;	}
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {this.credentialsNonExpired = credentialsNonExpired;	}
	
	
	
	
	
	@Type(type="yes_no")
	@Override
	@Column(name="IS_ENABLED")
	public boolean isEnabled() { return this.enabled;	}
	public void setEnabled(boolean enabled) {this.enabled = enabled;	}


	
}
