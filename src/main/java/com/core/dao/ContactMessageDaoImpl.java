package com.core.dao;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.common.entity.Account;
import com.common.entity.ContactMessage;
import com.common.entity.ContactMessage_;
import com.common.entity.MessageStatus;

@Repository
public class ContactMessageDaoImpl 
	extends GenericJpaRepository<ContactMessage, Long>
	implements ContactMessageDao
{

	@Override
	public List<ContactMessage> getMessages(Account account, MessageStatus status, Pageable pageable) {
		final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ContactMessage> query= builder.createQuery(ContactMessage.class);
		Root<ContactMessage> root = query.from(ContactMessage.class);
		List<Predicate> predicates = new LinkedList<Predicate>();
		
		if(account != null)
			predicates.add(builder.equal(root.get(ContactMessage_.account), account));
		if(status != null)
			predicates.add(builder.equal(root.get(ContactMessage_.status), status));
		
		query.select(root)
				.where(predicates.toArray(new Predicate[predicates.size()]))
				.orderBy(builder.desc(root));
		
		return entityManager.createQuery(query)
									.setFirstResult(pageable.getOffset())
									.setMaxResults(pageable.getPageSize())
									.getResultList();
	}

	
	
	@Override
	public void updateStatus(List<ContactMessage> messages, MessageStatus updateStatus) {
		final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaUpdate<ContactMessage> query 
											= builder.createCriteriaUpdate(ContactMessage.class);
		Root<ContactMessage> root = query.from(ContactMessage.class);
		List<Predicate> predicates = new LinkedList<Predicate>();
		
		for(ContactMessage message : messages) 
			predicates.add(builder.equal(root, message));

		query.set(root.get(ContactMessage_.status), updateStatus)
				.where(predicates.toArray(new Predicate[predicates.size()]))
				;
		
		entityManager.createQuery(query).executeUpdate();
		
		
		
	}

}
