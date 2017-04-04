package com.common.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ContactMessage.class)
public class ContactMessage_ extends AbstractPersistenceObject_{

	public static volatile SingularAttribute<ContactMessage, Account> account;
	public static volatile SingularAttribute<ContactMessage, String> name;
	public static volatile SingularAttribute<ContactMessage, String> email;
	public static volatile SingularAttribute<ContactMessage, String> message;
	public static volatile SingularAttribute<ContactMessage, MessageStatus> status;
}
