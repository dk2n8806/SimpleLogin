package com.core.util;

import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;

public class HibernateProxyUtils {
	/**
     * <p>Ensure a domain object is an actual persisted object and not a Hibernate proxy object by getting its real implementation.
     *
     * <p>This is primarily useful when retrieving a lazy loaded object that has been subclassed and you have the intention of casting it.
     *
     * @param t the domain object to deproxy
     * @return the actual persisted object or the passed in object if it is not a Hibernate proxy
     */
	@SuppressWarnings("unchecked")
	public static <T> T deproxy(T t) {
		if(t instanceof HibernateProxy) {
			HibernateProxy proxy = (HibernateProxy)t;
			LazyInitializer lazyInitializer = proxy.getHibernateLazyInitializer();
			return (T)lazyInitializer.getImplementation();
		}
		return t;
	}
}
