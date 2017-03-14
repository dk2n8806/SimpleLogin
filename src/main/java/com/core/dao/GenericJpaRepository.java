package com.core.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import java.io.Serializable;
import java.util.List;

public abstract class
        GenericJpaRepository<E, I extends Serializable>
    extends GenericBaseRepository<E, I>
{

    @PersistenceContext
    protected EntityManager entityManager;

    
    @Override
    public List<E> getList() {
    	CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
    	CriteriaQuery<E> query = builder.createQuery(this.entityClass);
    	return this.entityManager.createQuery(
    										query.select(query.from(this.entityClass))
    										).getResultList();
    }
    
    @Override
    public E findById(I id)
    {
        return this.entityManager.find(this.entityClass, id);
    }

    @Override
    public void persist(E entity)
    {
        this.entityManager.persist(entity);
    }

    @Override
    public void update(E entity)
    {
        this.entityManager.merge(entity);
    }

    @Override
    public void delete(E entity)
    {
        this.entityManager.remove(entity);
    }

    
}
