package com.core.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.common.entity.Account;
import com.common.entity.Account_;
import com.common.type.Role;

@Repository
public class AccountDaoImpl
extends GenericJpaRepository<Account, Long> 
implements AccountDao 
{

	
	@Override
	public Account findByEmail(String email)
	{
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery< Account> query = builder.createQuery(Account.class);
		Root<Account> root = query.from(Account.class);
		query.select(root).where(builder.equal(root.get(Account_.email), email));
		return entityManager.createQuery(query).getSingleResult();
	}

	@Override
	public List<Account> getAccounts(Role role, Pageable pageable) 
	{
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery< Account> query = builder.createQuery(Account.class);
		Root<Account> root = query.from(Account.class);	
		
		query.select(root)
				.where(builder.equal(root.get(Account_.role), role))
				.orderBy(builder.desc(root.get(Account_.id)));
				
		return entityManager.createQuery(query)
										.setFirstResult(pageable.getOffset())
										.setMaxResults(pageable.getPageSize())
										.getResultList();
	}

}
