package com.apress.prospring3.ch10.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ContactTelDetail.class)
public abstract class ContactTelDetail_ {

	public static volatile SingularAttribute<ContactTelDetail, Long> id;
	public static volatile SingularAttribute<ContactTelDetail, Contact> contact;
	public static volatile SingularAttribute<ContactTelDetail, Integer> version;
	public static volatile SingularAttribute<ContactTelDetail, String> telType;
	public static volatile SingularAttribute<ContactTelDetail, String> telNumber;

}

